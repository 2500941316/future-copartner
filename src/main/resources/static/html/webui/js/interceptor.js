$.ajaxSetup({
    dataType: "json",
    cache: false,
    // headers: {
    //     "token": token
    // },
    xhrFields: {
        withCredentials: true
    },
    complete: function (xhr) {
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
    }
});