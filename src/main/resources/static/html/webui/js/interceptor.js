var $ = layui.jquery;
$.ajaxSetup({
    dataType: "json",
    cache: false,

    xhrFields: {
        withCredentials: true
    },
    complete: function (xhr, status) {
        console.log(status)
        var responseData = xhr.responseJSON;
        console.log(responseData)
        if (responseData != null) {
            console.log(responseData.code)
        }

        //token过期，则跳转到登录页面
        // if (xhr.responseJSON.code === 200) {
        //  alert("200")
        // parent.location.href = baseURL + 'login.html';
        // }
    },
    error: function (xhr, status, error) {
        alert("错误信息: " + xhr.status + " " + xhr.statusText);
    },
    success: function (result, status, xhr) {
        //alert("成功信息: " + xhr.status + " " + xhr.statusText);
    }
});