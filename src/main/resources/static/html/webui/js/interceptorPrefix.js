var $ = layui.jquery;
var layer = layui.layer;
//var serverIp = "http://10.10.0.24:8080"
var serverIp = "http://202.120.117.251/partner/8080"

$.ajaxSetup({
    dataType: "json",
    cache: false,
    xhrFields: {
        withCredentials: true
    },
    beforeSend: function (xhr) {
        this.url = serverIp + this.url;
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
