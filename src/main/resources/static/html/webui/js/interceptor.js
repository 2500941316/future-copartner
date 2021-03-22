var $ = layui.jquery;
var layer = layui.layer;

$(function () {
    // 轮播图
    searchCarouselImage();
})

var insCarousel;
layui.use(['carousel', 'form'], function() {
    var carousel = layui.carousel

    //图片轮播
    insCarousel = carousel.render({
        elem: '#test10'
        ,width: '100%'
        ,height: '546px'
        ,indicator: 'inside'
        ,interval: 3000
    });
})
function searchCarouselImage() {
    $.ajax({
        url: '/public/carousel/searchPublicCarousel',
        type: 'GET',
        success: function (res) {
            if(res.code == 200){
                fillIndexCarousel(res.data);
            }else{
                layer.msg('网络异常！');
            }
        },
        error: function () {
            layer.msg('网络异常');
        }
    })
}

/**
 * 填充公共页轮播图
 * @param carouselImages
 */
function fillIndexCarousel(carouselImages) {
    const $active =  $('#publicCarousel');
    $active.html('');
    for(var i in carouselImages){
        const $children = (
            '<div><img src="'+carouselImages[i].carouselUrl+'" style="height: 576px;width: 100%" ></div>'
    );
        $active.append($children);
    }
    // 循环后需要再次加载已渲染的轮播图
    insCarousel.reload({
        elem: '#test10'
        ,width: '100%'
        ,height: '546px'
        ,interval: 3000
    });
}


$.ajaxSetup({
    dataType: "json",
    cache: false,
    xhrFields: {
        withCredentials: true
    },
    beforeSend: function (xhr) {
    },
    complete: function (xhr, status) {
        var responseData = xhr.responseJSON;
        if (responseData != null && responseData.code === 405) {
            window.location.href = "http://10.10.0.24:8080/index.html";
            openLogin();
        }
    },
    error: function (xhr, status, error) {
    },
    success: function (result, status, xhr) {
    }
});

/**
 * 路由检测，如果是
 */
window.onload = function () {
    var personBtn = document.getElementById("person");
    var managerBtn = document.getElementById("manager");
    personBtn.addEventListener('click', function () {
        checkAuth("/html/webui/personal/person.html");
    }, false);

    managerBtn.addEventListener('click', function () {
        checkAuth("/html/managerui/index.html");
    }, false);
}

//直接调用
$(function checkAuthForIcon() {
    if (localStorage.getItem("username") != null) {
        renderIcon(true);
    } else {
        $.ajax({
            type: "GET",
            url: "/public/checkAuth",
            success: function (data) {

                if (data.code === 500) {
                    renderIcon(false);
                } else {
                    localStorage.setItem("username", data.data.msg);
                    localStorage.setItem("auth", data.data.data);
                    renderIcon(true);
                }
            },
            error: function (data) {
                layer.msg('网络异常');
            }
        });
    }
})


//点击需要登录按钮时判断是否已经登录，如果已经登录返回权限列表
function checkAuth(url) {
    if (localStorage.getItem("username") != null) {
        window.location.href = url;
    } else {
        $.ajax({
            type: "GET",
            url: "/public/checkAuth",
            success: function (data) {
                if (data.code === 500) {
                    openLogin();
                } else {
                    localStorage.setItem("username", data.data.msg);
                    localStorage.setItem("auth", data.data.data);
                    window.location.href = url;
                }
            },
            error: function (data) {
                layer.msg('网络异常');
            }
        });
    }
}


function openLogin() {
    layer.open({
        type: 2
        , area: ['30%', '52%']
        , btn: []
        , anim: 1
        , title: false
        , closeBtn: true
        , shade: 0.6
        , id: 'LAY_layuipro'
        , btnAlign: 'c'
        , moveType: 1
        , content: '/html/webui/header/login/login.html'
    });
}


function logout() {
    $.ajax({
        type: "GET",
        url: "/logout",
        success: function (data) {
            if (data.code === 200) {
                localStorage.clear();
                window.location.href = "http://10.10.0.24:8080/";
            }
        },
        error: function (data) {
            layer.msg('网络异常');
        }
    });
}


//鼠标悬停显示当前登录用户的方法
function showUser() {
    layer.tips(localStorage.getItem("username"), '#userIcon', {
        time: 1000,
        tips: 3
    });
}

//渲染是否显示登录按钮
function renderIcon(isAuthed) {
    if (isAuthed === true) {
        document.getElementById('loginBtn').style.display = "none";
        document.getElementById('logoutBtn').style.display = "";
        document.getElementById('userIcon').style.display = "";
        if (localStorage.getItem("auth") === "ROLE_MANAGER") {
            document.getElementById('manager').style.display = "";
        } else {
            document.getElementById('manager').style.display = "none";
        }

    } else {
        document.getElementById('logoutBtn').style.display = "none";
        document.getElementById('userIcon').style.display = "none";
        document.getElementById('manager').style.display = "none";
        document.getElementById('loginBtn').style.display = "";
    }
}
