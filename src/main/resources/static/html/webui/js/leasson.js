$(function () {
    $("#footer").load("/html/webui/footer/footer.html");

    var url = window.location.pathname;
    //如果是首页
    if (url === "/html/webui/leasson/leasson.html") {
        getLeassonInfo();
    } else if (url === "/html/webui/leasson/leasson_vedio.html") {
        var courseId = getQueryVariable("courseId");
        getCourseInfoById(courseId);
    }
});


layui.use('element', function () {
    var $ = layui.jquery
        , element = layui.element;
});


//查询所有的课程信息
function getLeassonInfo() {
    $.ajax({
        type: "GET",
        url: "/user/leasson/getLeassonInfo",
        success: function (data) {
            if (data.code === 200) {
                //设置默认的视频id
                if (data.data[0] != null) {
                    localStorage.setItem("courseId", data.data[0].courseId);
                }
                renderLeassons(data.data)
            } else
                layer.msg('网络异常，请稍后重试');
        },
        error: function (data) {
            layer.msg('参数异常');
        }
    });
}


//用户点击了课程，跳转到具体的页面后查询某一个课程的方法
function getCourseInfoById(courseId) {
    $.ajax({
        type: "GET",
        url: "/user/leasson/getcourseInfo_vedio",
        data: {
            courseId: courseId
        },
        success: function (data) {
            //将课程vedio类放入缓存
            for (var i = 0; i < data.data.vedioList.length; i++) {
                localStorage.setItem(data.data.vedioList[i].courseVedioId, data.data.vedioList[i].courseVedioUrl)
            }
            renderVedioPage(data.data);
        }
    });
}

//渲染课程页
function renderLeassons(arrParO) {
    const $active = $("#leassons");
    $active.html("");
    $.each(arrParO, function (i, obj) {
        const $children = $('   <li onclick="redirecToVedio(' + obj.courseId + ')">\n' +
            '                                    <a href="#">\n' +
            '                                        <div class="image-ti">\n' +
            '                                            <img src="/html/webui/images/ad020.jpg" alt="">\n' +
            '                                        </div>\n' +
            '                                        <p class="slide-title">' + obj.courseName + '</p>\n' +
            '                                        <p class="slide-body">\n' +
            '                                        <span class="slide-body-nub">\n' +
            '                                            <i class="slide-body-nub-icon"></i>\n' +
            '                                            0\n' +
            '                                        </span>\n' +
            '                                            <span class="slide-body-nup">\n' +
            '                                            <i class="slide-body-nup-icon"></i>\n' +
            '                                            0\n' +
            '                                        </span>\n' +
            '                                            <span class="slide-body-price">免费</span>\n' +
            '                                        </p>\n' +
            '                                    </a>\n' +
            '                                </li>');
        $active.append($children);
    });
}


//渲染视频播放页
function renderVedioPage(data) {
    var courseList = data.clickCourseList;
    var vedioList = data.vedioList;
    document.getElementById("course_title").innerHTML = data.courseName;

    document.getElementById("course_introduction").innerHTML = data.courseDescription;
    document.getElementById("curLeassonName").innerText = data.courseName;
    if (data.vedioList != null) {
        localStorage.setItem("courseVedioId", data.vedioList[0].courseVedioId)
        document.getElementById("vedio_url").src = data.vedioList[0].courseVedioUrl;
    }

    const $active = $("#clickLeassons");
    $active.html("");
    $.each(courseList, function (i, obj) {
        const $children = $('   <article class="post" onclick="redirecToVedio(' + obj.courseId + ')">\n' +
            '                                                                <div class="post-inner">\n' +
            '                                                                    <figure class="post-thumb"><img\n' +
            '                                                                            src="/html/webui/images/post-thumb-1.jpg"\n' +
            '                                                                            alt=""><a href="#" class="overlay-box"></a>\n' +
            '                                                                    </figure>\n' +
            '                                                                    <div class="text"><a href="#">' + obj.courseName + '</a></div>\n' +
            '                                                                    <div class="timing">课程时长: ' + obj.courseTotaltime + '</div>\n' +
            '                                                                </div>\n' +
            '                                                            </article>');
        $active.append($children);
    });


    //渲染章节列表
    const $active1 = $("#chapter");
    $active1.html("");
    $.each(vedioList, function (i, obj) {
        const $children = $('<div class="content">\n' +
            '                                                                                <div  class="clearfix">' +
            '                                                                                    <div class="pull-left">' +
            '                                                 <a onclick="changeVideoPath(' + obj.courseVedioId + ')" class="lightbox-image play-icon"><span' +
            '                                                                                                class="fa fa-play"><i  id="icon"\n' +
            '                                                                                ></i></span>' + obj.courseVedioName + '</a>\n' +
            '                                                                                    </div>\n' +
            '                                                                                    <div  class="pull-right" >\n' +
            '                                                                                        <a style="color: red" href="' + obj.courseVedioPptUrl + '"> 下载ppt</a>\n' +
            '                                                                                    </div>\n' +
            '                                                                                    <div class="pull-right" style="margin-right: 20px">\n' +
            '                                                                                        <div>' + obj.courseVedioDuringtime + 'min</div>\n' +
            '                                                                                    </div>\n' +
            '                                                                                </div>\n' +
            '                                                                            </div>'
        );
        $active1.append($children);
    });
}

//跳转到视频页的方法
function redirecToVedio(courseId) {
    layui.use('element', function () {
        var $ = layui.jquery
            , element = layui.element;
        //新打开一个页面开始放视频
        window.open("/html/webui/leasson/leasson_vedio.html?courseId=" + courseId);
    });
}


//更新视频源的方法
function changeVideoPath(vedioId) {
    //查询当前vedio地址
    let url = localStorage.getItem(vedioId)
    document.getElementById("vedio_url").src = url;
    document.getElementById("vedio_url").load();
}


//解析当前url参数的方法
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}