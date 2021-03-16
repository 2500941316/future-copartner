var $ = layui.jquery;
var layer = layui.layer;
$(function () {
    layer.load(1, {
        shade: [0.1, '#fff'] //0.1透明度的白色背景
    });
    $("#footer").load("/html/webui/footer/footer.html");
    var url = window.location.pathname;
    if(url === "/html/webui/activity/activity.html"){
        searchActivityList();
    }else if(url === "/html/webui/activity/activity_detail.html"){
        searchActivityDetail();
    }

})

// activity.html

layui.config({
    base: '/html/webui/activity/js/util/'
}).use(['element','laypage','jquery','menu'],function(){
    element = layui.element,laypage = layui.laypage,$ = layui.$,menu = layui.menu;
    laypage.render({
        elem: 'demo'
        ,count: 70 //数据总数，从服务端得到
    });
    menu.init();
})

/**
 * 查询活动列表
 * @param pageConf
 */
function searchActivityList(pageConf) {
    // 先确定当前是否登录，
    var url;
    if(localStorage.getItem("username") != null){
        url = "/vip/activity/searchActivityList";
    }else{
        url = "/public/activity/searchActivityList";
    }
    if (!pageConf) {
        pageConf = {};
        pageConf.pageSize = 5;
        pageConf.currentPage = 1;

    }
    $.get(url, pageConf, function (data) {
        layer.closeAll();
        layui.use(['laypage', 'layer'], function () {
            var page = layui.laypage;
            page.render({
                elem: 'page',
                count: data.count,
                curr: pageConf.currentPage,
                limit: pageConf.pageSize,
                first: "首页",
                last: "尾页",
                layout: [ 'count','prev', 'page', 'next', 'skip'],// 'limit',
                jump: function (obj, first) {
                    if (!first) {
                        pageConf.currentPage = obj.curr;
                        pageConf.pageSize = obj.limit;
                        searchActivityList(pageConf);
                    }
                    fillActivityList(data.data); //页面填充
                }
            });
        })
    })
}

/**
 * 填充活动列表信息
 * @param activityInfo
 */
function fillActivityList(activityInfo) {
    const $active =  $("#activityList");
    $active.html("");
    for(var i in activityInfo){
        const $children = (
            '<div class="item">\n' +
            '          <div class="layui-fluid">\n' +
            '            <div class="layui-row">\n' +
            '              <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">\n' +
            '                <div class="img"><img src="'+activityInfo[i].activityImage+'" alt="" id="activityImage"></div>\n' +
            '              </div>\n' +
            '              <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">\n' +
            '                <div class="item-cont">\n' +
            '                  <h3><span id="activityTitle" style="cursor: pointer;" onclick="viewActivityDetail('+activityInfo[i].activityId+')">'+activityInfo[i].activityTitle+'</span><button class="layui-btn layui-btn-danger new-icon '+i+1000+'" id="new">new</button></h3>\n' +
            '                  <h5>\n' +
            '                    <span id="startTime"><i class="layui-icon layui-icon-date"></i> '+activityInfo[i].startTime+'</span>\n' +
            '                    <span style="margin-left: 20px;" id="activityStatus"><i class="layui-icon layui-icon-tips"></i> '+activityInfo[i].activityStatus+'</span>\n' +
            '                  </h5>\n' +
            '                  <p><span id="activityContent" class="activityContent">'+activityInfo[i].activityContent+'</span></p>\n' +
            '                  <a href="#" onclick="viewActivityDetail('+activityInfo[i].activityId+')" class="go-icon"></a>\n' +
            '                  <span id="'+activityInfo[i].activityId+'" class="signUp bright '+activityInfo[i].activityId+'" onclick="checkLogin('+activityInfo[i].activityId+')" style="cursor: pointer">立即报名</span>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            </div>\n' +
            '           </div>\n' +
            '        </div>'
        );/*style="float: right;color: #ff7f21"*/
        $active.append($children);

        // 将当前用户已报名的活动，设置为‘已报名’状态
        if(activityInfo[i].isEnrolled == 1){
            document.getElementsByClassName(activityInfo[i].activityId)[0].classList.remove('bright'); // 移除样式
            document.getElementById(activityInfo[i].activityId).innerText = "已报名";
        }
        // 当前活动已结束，不可再报名，并且隐藏new
        if(activityInfo[i].activityStatus === "已结束"){
            document.getElementsByClassName(activityInfo[i].activityId)[0].classList.remove('bright'); // 移除样式
            document.getElementById(activityInfo[i].activityId).innerText = "已结束";

            // 隐藏new
            document.getElementsByClassName(i+1000)[0].style.display = "none";
        }
    }
}

/**
 * 查看活动详情
 * @param activityId
 */
function viewActivityDetail(activityId) {
    localStorage.setItem("activityId",activityId);
    window.location.href = "/html/webui/activity/activity_detail.html";
}

/**
 *报名和取消报名，先验证是否登录
 */
function checkLogin(activityId) {
    if (localStorage.getItem("username") != null) {
        clickSignUp(activityId)
    } else {
        layer.msg("请先完成登录！", {icon: 7,shade: 0.05,time: 2000});
    }
}
/**
 * 立即报名
 * @param activityId
 */
function clickSignUp(activityId){
    if(document.getElementById(activityId).innerText == "立即报名"){

        /* document.getElementsByClassName(activityId)[0].classList.remove('bright'); // 移除样式
         document.getElementById(activityId).innerText = "已报名";*/
        //console.log("已报名");
        enrollInActivity(activityId);
    }else if(document.getElementById(activityId).innerText == "已报名"){
        // 确认取消报名该活动
        comfirmCancelEnroll(activityId);
        /*  document.getElementsByClassName(activityId)[0].classList.add('bright'); // 添加样式
          document.getElementById(activityId).innerText = "立即报名";
          console.log("已取消");*/
    }
}

/**
 * 活动报名处理
 * @param activityId
 */
function enrollInActivity(activityId) {
    $.ajax({
        url: "/vip/activity/enrollInActivity",
        type: "GET",
        data: "activityId="+activityId,
        success: function (res) {
            if(res.code = 200){
                document.getElementsByClassName(activityId)[0].classList.remove('bright'); // 移除样式
                document.getElementById(activityId).innerText = "已报名";
                layer.msg('报名成功', {icon: 1,shade: 0.05,time: 2000});
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}

/**
 *确认取消报名
 */
function comfirmCancelEnroll(activityId) {
    top.layer.confirm('确认取消报名？', {title: '提示'},function (index) {
        cancelEnrollActivity(activityId);
        layer.close(index);
    });
}

/**
 * 取消关注
 * @param projectId
 * @param follower
 */
function cancelEnrollActivity(activityId) {
    $.ajax({
        url: "/vip/activity/cancelEnrollActivity",
        type: "GET",
        data: "activityId="+activityId,
        success: function (res) {
            if(res.code == 200){
                layer.msg("已取消报名！", {icon: 1,shade: 0.05,time: 2000});
                // 将活动转为‘立即报名’ 状态
                document.getElementsByClassName(activityId)[0].classList.add('bright'); // 添加样式
                document.getElementById(activityId).innerText = "立即报名";
            }else{
                top.layer.msg("网络异常");
            }
        }
    })
}


// activity_detail.html
/*$(function () {
    $("#footer").load("/html/webui/footer/footer.html");

    searchActivityDetail();
})*/

/**
 * 根据id查询活动详细信息
 */
function searchActivityDetail() {
    var activityId = localStorage.getItem("activityId");
    $.ajax({
        url: "/public/activity/searchActivityById",
        type: "GET",
        data: "activityId="+activityId,
        success: function (res) {
            layer.closeAll();
            if(res.code = 200){
                // console.log(res);
                // 填充活动详情
                fillActivityDetail(res.data[0]);
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}

function fillActivityDetail(activityDetail) {
    document.getElementById("activityTitle").innerText = activityDetail.activityTitle;
    document.getElementById("startTime").innerText = activityDetail.startTime;
    document.getElementById("activityStatus").innerText = activityDetail.activityStatus;
    document.getElementById("activityImage").src = activityDetail.activityImage; // src格式
    document.getElementById("activityContent").innerHTML = activityDetail.activityContent;
}