document.writeln("<!DOCTYPE html>");
document.writeln("<html>");
document.writeln("<head>");
document.writeln("    <meta charset=\'UTF-8\'>");
document.writeln("    <title>header</title>");
/*document.writeln("    <link href=\'../../../webui/images/favicon.ico\' rel=\'shortcut icon\' type=\'text/css\'/>");*/
document.writeln("    <link href=\'../../../webui/css/head_style.css\' rel=\'stylesheet\' type=\'text/css\'/>");
document.writeln("    <link href=\'../../../webui/js/layui/css/layui.css\' rel=\'stylesheet\' type=\'text/css\'/>");
document.writeln("    <script src=\'../../../webui/js/layui/layui.all.js\'></script>");
document.writeln("    <script type=\'text/javascript\' src=\'../../../webui/js/interceptor.js\'></script>");
document.writeln("</head>");
document.writeln("<body>");
document.writeln("");
document.writeln("<div class=\'aui-header-nav moveDown\'>");
document.writeln("    <div class=\'wrapper\'>");
/*document.writeln("        <a href=\'#\'>");
document.writeln("            <div class=\'aui-logo\'>");
document.writeln("                <h1>首页</h1>");
document.writeln("            </div>");
document.writeln("        </a>");*/
/*logo*/
document.writeln("<img src=\"../../../webui/images/header_img/logo01.png\" style=\"margin-left: 0;\"  width=\"256px\" height=\"100%\">");
document.writeln("<img src=\"../../../webui/images/header_img/logo02.png\" width=\"70px\" height=\"100%\">");

document.writeln(" <div class=\'aui-top-nav\' style='left: 30%'>");
document.writeln("            <ul class=\'menu\'>");
document.writeln("                <li class=\'product\'>");
document.writeln("                    <a href=\'../../../index.html\'>");
document.writeln("                        首页");
document.writeln("                        <span class=\'u-icon-caret\'></span>");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'finance\'>");
document.writeln("                    <a href=\'../../../webui/leasson/leasson.html\'>");
document.writeln("                        课程");
document.writeln("                        <span class=\'u-icon-caret\'></span>");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li>");
document.writeln("                    <a href=\'../../../webui/project/project.html\'>");
document.writeln("                        项目");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'price\'>");
document.writeln("                    <a href=\'../../../webui/activity/activity02.html\'>");
document.writeln("                        活动");
document.writeln("                        <span class=\'u-icon-caret\'></span>");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'service\'>");
/*document.writeln("                    <a href=\'/webui/live/live.html\'>直播");*/
document.writeln("                    <a href=\'../../../webui/live/live.html\'>直播");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'merchants\'>");
document.writeln("                    <a href=\'../../../webui/news/news.html\'>上大社区");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li class=\'college\'>");
document.writeln("                    <a href=\'../../../webui/supervisor/supervisor.html\'>导师");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("                <li id='person' class=\'qa\'>");
document.writeln("                    <a href=\'#\'>");
document.writeln("                        个人工作台");
document.writeln("                        <span class=\'u-icon-caret\'></span>");
document.writeln("                    </a>");
document.writeln("                </li>");
document.writeln("");
document.writeln("            </ul>");
document.writeln("        </div>");
document.writeln("        <div id=\'layerDemo\' class=\'m-login\' style=\'right: 100px\'>");
document.writeln("            <a id='loginBtn' style='display: none'  onclick=\'openLogin()\' class=\'u-btn  sign\'>登录</a>");
document.writeln("            <i onmouseover=\'showUser()\' id='userIcon' style='display: none;font-size: 28px;color: #1E9FFF;'   class=\'layui-icon  layui-icon-username\'></i>");
document.writeln("            <a id='logoutBtn' style='display: none'  onclick=\'logout()\' class=\'u-btn  sign\'>注销</a>");
document.writeln("            <a id='manager' style='display: none'  href=\'#\' class=\'u-btn  free\'>管理端</a>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</div>");
/*document.writeln("<div class=\'aui-banner-slide\'>");
document.writeln("    <div class=\'aui-banner-main\'>");
document.writeln("        <div class=\'aui-banner-wrapper bd\'>");
document.writeln("            <ul>");
document.writeln("                <li>");
document.writeln("                    <img src=\'/webui/images/header_img/banner004.png\' alt=\'\'>");
document.writeln("                </li>");
document.writeln("            </ul>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</div>");*/
document.writeln("<div class=\'aui-banner-slide\'>");
document.writeln("    <div class=\'aui-banner-main\'>");
document.writeln("        <div class=\'aui-banner-wrapper bd\'>");
document.writeln("<div class=\'layui-carousel\' id=\'test10\' style=\'position: relative;\'>");
document.writeln("    <div carousel-item=\'\' id=\'publicCarousel\'>");
document.writeln("    <!--轮播图--> ");
document.writeln("    </div>");
document.writeln("</div>");
document.writeln("        </div>");
document.writeln("    </div>");
document.writeln("</div>");
document.writeln("");
document.writeln("");
document.writeln("<script type=\'text/javascript\'>");
document.writeln("    $(window).on(\'scroll\', function () {");
document.writeln("        if ($(document).scrollTop() > 10) {");
document.writeln("            $(\'.aui-header-nav\').addClass(\'solid\').removeClass(\'moveDown\');");
document.writeln("            $(\'.aui-header-top\').addClass(\'moveUp\');");
document.writeln("        } else {");
document.writeln("            $(\'.aui-header-nav\').removeClass(\'solid\').addClass(\'moveDown\');");
document.writeln("            $(\'.aui-header-top\').removeClass(\'moveUp\');");
document.writeln("        }");
document.writeln("    });");
document.writeln("");
document.writeln(" var insCarousel;");
document.writeln("    layui.use([\'carousel\', \'form\'], function() {");
document.writeln("        var carousel = layui.carousel");
document.writeln("");
document.writeln("        //图片轮播");
document.writeln("        insCarousel = carousel.render({");
document.writeln("            elem: \'#test10\'");
document.writeln("            ,width: \'100%\'");
document.writeln("            ,height: \'546px\'");
document.writeln("            ,indicator: \'inside\'");
document.writeln("            ,interval: 3000");
document.writeln("        });");
document.writeln("    })");

document.writeln("</script>");
document.writeln("");
document.writeln("");
document.writeln("");
document.writeln("</body>");
document.writeln("</html>");
document.writeln("");