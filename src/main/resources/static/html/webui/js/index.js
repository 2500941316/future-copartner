$(function () {
    $("#footer").load("/html/webui/footer/footer.html");

    //鼠标悬停时动画
    $('ul.yun-solution-list li').hover(function () {
        var index = $(this).index();
        $('ul.yun-solution-wrap li').removeClass('current').eq(index).addClass('current');
        $('#yun-arrow-wrap').attr('class', 'yun-arrow-wrap yun-arrow-current' + (index + 1));
    })

    //鼠标点击时页面跳转
    $('ul.yun-solution-list li').click(function () {
        var index = $(this).index();

        switch (index) {
            case 0:
                window.location.href = "/html/webui/news/news.html";
                break;
            case 1:
                window.location.href = "/html/webui/project/project.html";
                break;
            case 2:
                window.location.href = "/html/webui/supervisor/supervisor.html";
                break;
            case 3:
                window.location.href = "#";
                break;
            case 4:
                window.location.href = "/html/webui/leasson/leasson.html";
                break;
            case 5:
                window.location.href = "html/webui/personal/person.html";
                break;
            case 6:
                window.location.href = "";
                break;
            case 7:
                window.location.href = "#";
                break;
            default:
                window.location.href = "activity.html"
                break;
        }
    })


    //背景变换
    $('ul.yun-solution-list li').hover(function () {
        var that = $(this);
        var i = 0;
        bgChange = setInterval(function () {
            i += -84
            that.find('div').css('backgroundPositionY', i)
            if (i <= -2058) {
                clearInterval(bgChange);
            }
        }, 50)
    }, function () {
        clearInterval(bgChange);
    })
});

