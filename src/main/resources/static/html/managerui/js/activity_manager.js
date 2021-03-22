//var $ = layui.jquery;
var form = layui.form;
$(function () {
    $("#footer").load("../../../webui/footer/footer.html");
    var url = window.location.pathname;
    if(url === "/html/managerui/html/activity/activity_manager.html"){
        searchActivityInfo();
    }
})

// activity_manager.html

/**
 *活动信息管理表格
 */
function searchActivityInfo(){
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#activity'
            , url: '/manager/activity/searchAllActivity'
            //,data: data
            , title: '活动信息管理表'
            , cols: [[
                /*{
                    field: 'activityId', title: 'ID', fixed: 'left', width: 80,unresize: true, sort: true, align: 'center',type:'numbers'
                }*/
                {field: 'activityTitle', title: '活动标题',width:150, align: 'center'}
                , {field: 'activityAuthor', title: '创建人', align: 'center'}
                , {field: 'startTime', title: '开始时间', sort: true,width:150,align: 'center'}
                , {field: 'isPublish', title: '状态', sort: true, align: 'center',templet: function(res){
                        if(res.isPublish === 0){ return  '未发布';}
                        else if(res.isPublish === 1){ return  '已发布';}
                    }}
                , {fixed: 'right', title: '操作', toolbar: '#activityOperate', width: 260, align: 'center'}
            ]]
            , page: true
            ,limits: [10]
        });
        //监听操作栏
        table.on('tool(activityTable)', function (obj) {
            var activityData = obj.data;
            if (obj.event === 'detail') {
                viewActivityInfo(activityData.activityId);
            } else if (obj.event === 'edit') {
                editActivityInfo(activityData.activityId);
            } else if (obj.event === 'delete') {
                layer.confirm('确认删除？', function (index) {
                    deleteActivityInfo(activityData.activityId);
                    layer.close(index);
                    obj.del();
                });
            } else if(obj.event === 'manage'){
                // 活动发布或撤回
                manageActivityInfo(obj.data);
            } else if(obj.event === 'people'){
                // 查看活动报名人员
                viewEnrolledPeople(activityData.activityId);
            }

        });
    })
}


/**
 *查看活动信息
 * */
function viewActivityInfo(activityId) {
    localStorage.setItem("activityId", activityId);
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.open({
            type: 2,
            area: ["90%", "100%"],
            fixed: true, //固定
            maxmin: true,
            content: "../../../webui/activity/activity_detail.html"
        });
    });
}

/**
 * 删除活动
 * @param activityId
 */
function deleteActivityInfo(activityId) {
    $.ajax({
        url: "/manager/activity/deleteActivityById",
        type: "GET",
        data: "activityId="+activityId,
        success: function (res) {
            if(res.code = 200){
                layer.msg("删除成功！", {icon: 1,shade: 0.1,time: 2000})
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}

/**
 * 修改活动信息
 * @param activityId
 */
function editActivityInfo(activityId) {
    localStorage.setItem("activityId",activityId);
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.open({
            title:"活动信息修改",
            type: 2,
            area: ["70%", "100%"],
            fixed: false, //不固定
            maxmin: true,
            content: "activity_edit.html"
        });
    });
}

/**
 * 发布活动
 * @param projectId
 */
function manageActivityInfo(info) {
    var $=layui.jquery;
    var form = layui.form;
    // 获取选中的状态值
    layer.open({
        type:1,
        area:['30%','25%'],
        title: '活动状态设置',
        content: $("#test"),
        shade: 0.1,
        btn: ['提交']
        ,btn1: function(index, layero){
            var typeValue = $('#test input[name="type"]:checked ').val()
            if(typeValue == info.isPublish){
                layer.msg("状态重复", {icon: 2,shade: 0.1,time: 2000,shift: 6});
                layer.close(index);
                return;
            }
            updateActivityStatus(info.activityId,typeValue);
            layer.close(index);
        },
        cancel: function(layero,index){
            layer.closeAll();
        }
    });
}

/**
 * 更新活动状态
 * @param activityId
 * @param isPublish
 */
function updateActivityStatus(activityId,isPublish){
    var updateData = {
        activityId: activityId,
        isPublish: isPublish
    }
    $.ajax({
        url: "/manager/activity/updateActivityStatus",
        type: "GET",
        data: updateData,
        success: function (res) {
            if(res.code = 200){
                layer.msg("设置成功！",{icon: 1,shade: 0.1,time: 2000})
                searchActivityInfo(); // 刷新表格
            }else{
                layer.msg("网络异常！");
            }
        }
    })
}

/**
 * 查看活动报名人员
 * @param activityId
 */
function viewEnrolledPeople(activityId) {
    //活动报名人员表格
    layui.use('table', function () {
        var table = layui.table;
        var high = 40; //表头高度
        table.render({
            elem: '#displayBoxTable'
            , url: '/manager/activity/searchEnrolledPeople'
            ,where: {activityId: activityId}
            , title: '活动已报名人员'
            ,smartReloadModel:true
            , cols: [[
                {field: 'activityId',title: '序号', width: 100, align: 'center',type: 'numbers' },
                {field: 'personId', title: '账号ID',width: 160, align: 'center'},
                {field: 'personName', title: '姓名',width: 160, align: 'center'},
                {field: 'enrollTime', title: '报名时间',width: 160, align: 'center'}
            ]]
            , page: true
            , limits: [10]
            , done: function(count){
                $("table").css("width", "100%");//宽度
                high = high + count * 40;//一条数据的高度是40
                layer.open({
                    type: 1,
                    title: '报名详情：',
                    shade: 0.1,
                    /*offset: '100px',*/
                    area: ['605px', high+'px'], //宽高
                    content: $('#displayBox')
                });
            }
        });
    })
}
