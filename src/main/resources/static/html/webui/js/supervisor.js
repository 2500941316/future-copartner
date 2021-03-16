var $ = layui.jquery;
$(function () {
    layer.load(1, {
        shade: [0.1, '#fff'] //0.1透明度的白色背景
    });
    $("#footer").load("/html/webui/footer/footer.html");
    var url = window.location.pathname;
    if(url === "/html/webui/supervisor/supervisor.html"){
        searchSupervisorList();
    }else if(url === "/html/webui/supervisor/supervisor_detail.html"){
        searchSupervisorDetail();
    }

})


/**
 * 查询导师列表
 */
function searchSupervisorList(pageConf) {
    if (!pageConf) {
        pageConf = {};
        pageConf.pageSize = 6;
        pageConf.currentPage = 1;

    }
    $.get("/public/supervisor/searchSupervisorList", pageConf, function (data) {
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
                layout: [ 'prev', 'page', 'next', 'skip'],// 'limit','count',
                jump: function (obj, first) {
                    if (!first) {
                        pageConf.currentPage = obj.curr;
                        pageConf.pageSize = obj.limit;
                        searchSupervisorList(pageConf);
                    }
                    fillSupervisorList(data.data); //页面填充
                }
            });
        })
    })
}

/**
 * 填充导师列表信息
 * @param supervisorInfo
 */
function fillSupervisorList(supervisorInfo) {
    const $active =  $("#supervisorList");
    $active.html("");
    for(var i in supervisorInfo){
        const $children = (
            '<div class="col-lg-6 col-md-6 col-12">\n' +
            '  			<div class="single-event-wrap">\n' +
            ' 				<div class="row">\n' +
            ' 				<div class="col-lg-5">\n' +
            ' 				  <div class="event-bg bg-cover" id="supervisorImage" style="background-image: url('+supervisorInfo[i].supervisorImage+');">\n' +
            ' 						<span class="event-date" id="updateTime">'+supervisorInfo[i].updateTime+'</span>\n' +
            ' 					</div>\n' +
            ' 				  </div>\n' +
            ' 			   <div class="col-lg-7">\n' +
            ' 				 <div class="event-content">\n' +
            ' 					<h6><span id="supervisorName" onclick="viewSupervisorDetail('+supervisorInfo[i].supervisorId+')" style="cursor: pointer">'+supervisorInfo[i].supervisorName+'</span></h6>\n' +
            '                   <p class="event-meta"> <i class="las la-clock"></i> <span ><span id="supervisorStatus" style="margin-right: 5px;">'+supervisorInfo[i].supervisorStatus+' </span>| <i class="las la-map-marker"></i> </span>  <span id="supervisorInstitute">'+supervisorInfo[i].supervisorInstitute+'</span> </p>\n' +
            '                   <p id="supervisorDescription">'+supervisorInfo[i].supervisorDescription+'</p>\n' +
            '                   <a href="#" onclick="viewSupervisorDetail('+supervisorInfo[i].supervisorId+')">Read More</a>\n' +
            '                </div>\n' +
            '              </div>\n' +
            '             </div>\n' +
            '           </div>\n' +
            '         </div>'
        );
        $active.append($children);
    }
}

/**
 * 查看导师详情
 * @param supervisorId
 */
function viewSupervisorDetail(supervisorId) {
    localStorage.setItem("supervisorId",supervisorId)
    window.location.href = "/html/webui/supervisor/supervisor_detail.html";
}

/**
 * 根据名称搜索导师
 */
function searchSupervisorByName() {
    var supervisorName = $("#searchPlaceholder").val();
    $.ajax({
        url: "/public/supervisor/searchSupervisorByName",
        type: "GET",
        data: "supervisorName="+supervisorName,
        success: function (res) {
            if(res.code == 200){
                fillSupervisorList(res.data);
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}


// supervisor_detail.html

/*$(function () {
    $("#footer").load("/html/webui/footer/footer.html")

    searchSupervisorDetail();
    //searchSupervisorProject();
    //searchSupervisorAchievement();
})*/

layui.use('layer',function () {
    var layer = layui.layer;
})

/**
 * 根据id查询导师详细信息
 */
function searchSupervisorDetail() {
    var supervisorId = localStorage.getItem("supervisorId");
    $.ajax({
        url: "/public/supervisor/searchSuperviosrById",
        type: "GET",
        data: "supervisorId="+supervisorId,
        success: function (res) {
            layer.closeAll();
            if(res.code = 200){
                //console.log(res);
                // 填充导师详情
                fillSupervisorDetail(res.data.supervisorDetails[0]);
                // 填充导师参加的项目
                fillSupervisorProject(res.data.supervisorProjects[0]);
                // 填充导师代表性成就
                fillSupervisorAchievement(res.data.supervisorAchievements[0])
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}

/**
 * 填充导师详细信息
 * @param supervisorInfo
 */
function fillSupervisorDetail(supervisorInfo) {
    document.getElementById("supervisorName").innerText = supervisorInfo.supervisorName;
    document.getElementById("supervisorInstitute").innerText = supervisorInfo.supervisorInstitute;
    document.getElementById("supervisorEmail").innerText = supervisorInfo.supervisorEmail;

    document.getElementById("supervisorImage").src = supervisorInfo.supervisorImage; // src格式
    document.getElementById("supervisorName2").innerText = supervisorInfo.supervisorName;
    document.getElementById("supervisorStatus").innerText = supervisorInfo.supervisorStatus;
    document.getElementById("supervisorSchool").innerText = supervisorInfo.supervisorSchool;
    document.getElementById("supervisorBriefIntro").innerHTML = supervisorInfo.supervisorBriefIntro; // html格式
}

/**
 * 根据导师id查询该导师参加的项目
 */
/*function searchSupervisorProject(){
    var supervisorId = localStorage.getItem("supervisorId");
    $.ajax({
        url: "/user/supervisor/searchSupervisorProject",
        type: "GET",
        data: "supervisorId="+supervisorId,
        success: function (res) {
            if(res.code = 200){
                fillSupervisorProject(res.data[0]);
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}*/

/**
 * 填充导师参与的项目信息
 * @param supervisorProject
 */
function fillSupervisorProject(supervisorProject) {
    if(typeof (supervisorProject) != "undefined" ){
        const $active = $("#supervisorProject");
        $active.html("");
        for(var i in supervisorProject.projects) {
            const $children = (
                '<div class="event-content blue-bg">\n' +
                '          <h6 onclick="viewSupervisorProject('+supervisorProject.projects[i].projectId+')" style="cursor: pointer;"><span>'+supervisorProject.projects[i].projectName+'</span></h6>\n' +
                '          <p class="event-meta"> <i class="las la-calendar-check"></i> '+supervisorProject.projects[i].updateTime+' | <span><i class="las la-clock"></i></span> <span>'+supervisorProject.projects[i].isGoing+' </span>\n' +
                '          <br> <i class="las la-map-marker"></i> <span>'+supervisorProject.supervisorSchool+'</span> </p>\n' +
                ' </div>'
            );
            $active.append($children);
        }
    }else {
        //console.log("无项目数据");
    }
}

/**
 * 查看导师参加的项目详情
 * @param projectId
 */
function viewSupervisorProject(projectId) {
    localStorage.setItem("projectId",projectId);
    window.location.href = "/html/webui/project/project_details_info.html";
}

/**
 * 查询导师代表性成就
 */
/*	function searchSupervisorAchievement() {
		var supervisorId = localStorage.getItem("supervisorId");

		$.ajax({
			url: "/user/supervisor/searchSupervisorAchievement",
			type: "GET",
			data: "supervisorId="+supervisorId,
			success: function (res) {
				if(res.code = 200){
					console.log(res);
					fillSupervisorAchievement(res.data[0]);
				}else{
					layer.msg("网络异常！");
				}
			}
		})
	}*/

/**
 * 填充导师代表性成就
 * @param achievement
 */
function fillSupervisorAchievement(achievement) {
    if(typeof (achievement) != "undefined" ) {
        const $active = $("#supervisorAchievement");
        $active.html("");
        for (var i in achievement.logAchievements) {
            const $children = (
                '<ul>\n' +
                ' 	<li>\n' +
                '       ' + achievement.logAchievements[i].logSupervisorAchievement + '     \n' +
                ' 	</li>\n' +
                '</ul>'
            );
            $active.append($children);
        }
    }else{
        //console.log("无代表性成就");
    }
}