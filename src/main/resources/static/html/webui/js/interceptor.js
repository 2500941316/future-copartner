var $ = layui.jquery;
var layer = layui.layer;
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
            //先重定向到
            openLogin();
        }
    },
    error: function (xhr, status, error) {
    },
    success: function (result, status, xhr) {
        var responseData = xhr.responseJSON;
        console.log(responseData)
    }
});

/**
 * 路由检测，如果是
 */


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
