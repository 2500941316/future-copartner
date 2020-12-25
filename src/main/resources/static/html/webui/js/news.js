document.write("<script src='/html/webui/js/jquery-1.8.2.min.js'></script>");
document.write("<script src='/html/managerui/js/layui/layui.js'></script>");
$(function () {
    $("#header").load("/html/webui/header/header.html");
    $("#footer").load("/html/webui/footer/footer.html");
    var url = window.location.pathname;
    //如果是首页
    if (url === "/html/webui/news.html") {
        news_index_init();
    } else if (url === "/html/webui/news/news_content.html") {
        news_content_init();
    } else {
        initPage();
        initCatagoryNews(1);
    }
});


//跳转到新闻内容页的方法
function toNew_content(newId) {
    localStorage.setItem("newId", newId);
    window.location.href = "/html/webui/news/news_content.html";
}

//跳转到分类新闻页的方法
function redirecTo(catagory) {
    localStorage.setItem("news_catagory", catagory);
    window.location.href = "/html/webui/news/news_catalog.html";
}

//新闻搜索按钮跳转到新闻分类页
function searchNew() {
    var value = $("#keywords").val();
    if (value.length > 0) {
        localStorage.setItem("news_catagory", "s_" + value);
        window.location.href = "/html/webui/news/news_catalog.html";
    }
}


//新闻内容页根据获取到的内容渲染页面
function fillPage(news) {
    document.getElementById("news_title").innerText = news.newsTitle;
    document.getElementById("news_category").innerText = news.newsCategory;
    document.getElementById("news_date").innerText = news.newsPublistime;
    document.getElementById("news_clickTimes").innerText = news.newsBrowsecount;
    document.getElementById("news_content").innerHTML = news.newsContent;
    document.getElementById("news_writer").innerText = news.newsAuthor;
}


//新闻内容页根据查到的最新关注来渲染
function doData(arrParO) {
    const $active = $("#latestNews");
    $active.html("");
    $.each(arrParO, function (i, obj) {
        const $children = $('<a href="#" onclick="toNew_content(' + obj.newsId + ')">' + obj.newsTitle + '</a>');

        $active.append($children);
    });
}


//新闻首页初始化方法
function news_index_init() {
    $.ajax({
        type: "GET",
        url: "/user/news/getNewsIndexInfo",
        success: function (data) {
            if (data.code === 200) {
                renderNewsPage_topNews(data.data.topNewsList);
                renderNewsPage_mostClickTimes(data.data.recently_NewsList);
                renderNewsPage_byCatagories(data.data.categoriesNewsList);
            }
        },
        error: function (data) {
            layer.msg('网络异常');
        }
    });
}


//新闻内容页初始化方法
function news_content_init() {
    var newsId = localStorage.getItem("newId");
    if (newsId != null) {
        $.ajax({
            type: "GET",
            url: "/user/news/searchNewsById",
            data: "newsId=" + newsId,
            success: function (data) {
                if (data.code === 200) {
                    fillPage(data.data[0]);
                    doData(data.data[1]);
                }
            },
            error: function (data) {
                layer.msg('网络异常');
            }
        });
    }
}

//初始化分类新闻页的方法
function initCatagoryNews(page) {
    var keyword = localStorage.getItem("news_catagory");
    $.ajax({
        type: "GET",
        url: "/user/news/searchNewsByKeywords",
        data: {
            page: page,
            keyword: keyword
        },
        success: function (data) {
            if (data.code === 200) {
                pageCount = data.count;
                renderNews_news(data.data[0]);
                renderNewsPage_mostClickTimes(data.data[1]);
            }
        },
        error: function (data) {
            layer.msg('网络异常');
        }
    });
}

//初始化分类新闻的页面号
function initPage() {
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage
            , layer = layui.layer;
        //自定义每页条数的选择项
        laypage.render({
            elem: 'page'
            , count: 15
            , layout: ['prev', 'page', 'next']
            , jump: function (obj, first) {
                if (first) {
                    return;
                }
                initCatagoryNews(obj.curr);
            }
        });
    });
}


//新闻首页根据数据来渲染topNews
function renderNewsPage_topNews(arrParO) {
    ///根据ajax数据进行渲染
    const $active = $("#topNews");
    $active.html("");
    $.each(arrParO, function (i, obj) {
        const $children = $("    <div onclick=\"toNew_content(" + obj.newsId + ")\" class=\"newsbox\">\n" +
            "                <div class=\"tit\"><a href=\"#\">" + obj.newsTitle + "</a></div>\n" +
            "                <div class=\"con\">" + obj.newsContent + "... <a\n" +
            "                        href=\"#\">继续阅读>></a>\n" +
            "                </div>\n" +
            "            </div>");

        $active.append($children);
    });
}

//新闻首页根据数据来渲染clickTimes
function renderNewsPage_mostClickTimes(arrParO) {
    ///根据ajax数据进行渲染
    const $active = $("#click_TimesNews");
    $active.html("");
    $.each(arrParO, function (i, obj) {
        const $children = $('<a href="#" onclick="toNew_content(' + obj.newsId + ')">' + obj.newsTitle + '</a>');

        $active.append($children);
    });
}

//新闻首页根据数据来渲染catagory_news
function renderNewsPage_byCatagories(arrParO) {
    const catagory = [
        "精彩上大", "每周一文", "项目风采", "学术交流", "人文社科", "活动咨询", "法律法规"
    ];
    for (let i = 0; i < arrParO.length; i++) {
        const $active0 = $("#" + catagory[i]);
        $.each(arrParO[i], function (i, obj) {
            const $children = $('<span onclick="toNew_content(' + obj.newsId + ')"><img src="/html/webui/images/01.gif"/><a href="#">' + obj.newsTitle + '</a></span>');
            $active0.append($children);
        });
    }
}


//分类新闻页渲染方法
function renderNews_news(arrParO) {
    const $active = $("#newsTable");
    $active.html("");
    $.each(arrParO, function (i, obj) {
        const $children = $(
            '<tr>\n' +
            '        <td><a onclick="toNew_content(' + obj.newsId + ')" href="#" class="listtit">' + obj.newsTitle + '</a></td>\n' +
            '        <td><span class="listly">' + obj.newsAuthor + '</span></td>\n' +
            '        <td><span class="liatdate">' + obj.newsPublistime + '</span></td>\n' +
            '        </tr>');
        $active.append($children);
    });
}

