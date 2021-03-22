var $ = layui.jquery;
var layer = layui.layer;
$(function () {
    layer.load(1, {
        shade: [0.1, '#fff'] //0.1透明度的白色背景
    });
    $("#footer").load("/html/webui/footer/footer.html");
    var url = window.location.pathname;
    if(url === "/html/webui/project/project.html" ){
        // 项目浏览页
        searchProject();// 填充搜索的项目
        getAllProjectData(); // 填充右侧项目总览
    }
    checkLogin();

})


// project.html

/**
 * 检查是否登录
 * @param activityId
 */
function checkLogin() {
    if (localStorage.getItem("username") != null) {
        /*document.getElementById("loginNow").innerText = "已登录";
        document.getElementById("loginLabelA").onclick = function(){return "#"};*/
        document.getElementById("leftLoginDiv").style.display = "none";

        document.getElementById("login").innerText = "已登录，可申请项目>>";
        document.getElementById("loginLabelRight").onclick = function(){
            localStorage.setItem("project.html",1); // 设置标志位，用于跳转时判断
            window.location.href =  "../personal/person.html"};
    }
}

/**
 * 填充项目数据
 * @param projectInfo
 */
function fillProjectInfo(projectInfo) {
    const $active = $("#contentmeet");
    $active.html("");
    var count = 1;
    for(var i in projectInfo){
        //count ++;
        // console.log(count)
        var $children = $(
            '<div class="item gray">\n' +
            '                        <div class="iteml ">\n' +
            '                            <span class="span1" id="projectType">'+projectInfo[i].projectType+'</span><br />\n' +
            '                            <span class="span2" id="starttime">'+projectInfo[i].starttime+'</span>\n' +
            '                        </div>\n' +
            '                        <div class="itemr">\n' +
            '                           <a onclick="viewProjectDetail('+projectInfo[i].projectId+')" class="tit" id="projectName">'+projectInfo[i].projectName+'</a>\n' +
            '                           <div class="sub" >\n' +
            '                              <span>项目简述：</span> <div id="description" style="display:inline-block;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 500px">'+projectInfo[i].description+'</div>\n' +
            '                           </div>\n' +
            '                        </div>\n' +
            '                     </div>'
        );
        /*    if(count % 2 === 0){
                $('.item').addClass('gray');
            }
            console.log("count:"+count)*/
        $active.append($children);
    }
}

/**
 * 点击查看项目具体信息
 * @param projectId
 */
function viewProjectDetail(projectId) {
    localStorage.setItem("projectId",projectId);
    //window.open("../project/project_details_info.html");
    window.location.href = "../project/project_details_info.html";

}

/**
 * 根据输入的值搜索项目
 */
function searchProject(pageConf) {
    if (!pageConf) {
        pageConf = {};
        pageConf.pageSize = 8;
        pageConf.currentPage = 1;

        pageConf.projectType= $("#projectTypeInput").val(),
        pageConf.projectName= $("#projectNameInput").val(),
        pageConf.projectCreater= $("#projectCreaterInput").val(),
        pageConf.projectTwoStatus= projectTwoStatus === "" ? "在创" : projectTwoStatus
    }
    $.get("/public/project/searchProjectByFour", pageConf, function (data) {
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
                layout: ['count', 'prev', 'page', 'next', 'skip'],// 'limit',
                jump: function (obj, first) {
                    if (!first) {
                        pageConf.currentPage = obj.curr;
                        pageConf.pageSize = obj.limit;
                        searchProject(pageConf);
                    }
                    fillProjectInfo(data.data); //页面填充
                }
            });
        })
    })
}

/**
 * 请求所有项目数据
 */
function getAllProjectData() {
    $.get("/public/project/getProjectOverview", function (data) {
        //console.log(data);
        fillProjectOverview(data.data);
    })
}

/**
 * 填充项目总览
 * @param projectData
 */
function fillProjectOverview(projectData) {
    const $active = $("#newRetail");
    $active.html("");

    const $active2 = $("#culture");
    $active2.html("");

    const $active3 = $("#science");
    $active2.html("");

    const $active4 = $("#K12");
    $active3.html("");

    const $active5 = $("#school");
    $active4.html("");

    const $active6 = $("#others");
    $active5.html("");
    for(var i in projectData){
        if(projectData[i].projectType === "新零售"){
            var $children = $(
                '<a href="#" onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px;">'+projectData[i].projectName+'</a>\n'
            );
            $active.append($children);
        }else if(projectData[i].projectType === "文创"){
            var $children2 = $(
                '<a onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px">'+projectData[i].projectName+'</a>\n'
            );
            $active2.append($children2);
        }else if(projectData[i].projectType === "科创"){
            var $children3 = $(
                '<a onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px">'+projectData[i].projectName+'</a>\n'
            );
            $active3.append($children3);
        }else if(projectData[i].projectType === "K12"){
            var $children4 = $(
                '<a onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px">'+projectData[i].projectName+'</a>\n'
            );
            $active4.append($children4);
        }else if(projectData[i].projectType === "校园行"){
            var $children5 = $(
                '<a onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px">'+projectData[i].projectName+'</a>\n'
            );
            $active5.append($children5);
        }else if(projectData[i].projectType === "其他"){
            var $children6 = $(
                '<a onclick="viewProjectDetail('+projectData[i].projectId+')" style="margin-right: 8px">'+projectData[i].projectName+'</a>\n'
            );
            $active6.append($children6);
        }
    }
}

