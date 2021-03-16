var courseVedioId = "";
var layer = null;
var upload = null;
var element = null;
var vedioUploadInst = null;
var pptUploadInst = null;
layui.use(['element', 'layer', 'upload',], function () {
    element = layui.element
        , layer = layui.layer
        , upload = layui.upload;
    element.render();

    //上传视频初始化
    vedioUploadInst = upload.render({
        elem: '#vedio' //绑定元素
        , url: '/manager/leasson/leassonVedioUpload'//上传接口
        , data: {
            courseVedioId: 56,
            fileUploadType: "vedio"
        }
        , accept: 'file' //允许上传的文件类型
        , choose: function (obj) {
            //选择文件后的回调函数
            //console.log(obj);
        }
        , before: function (obj) {
            //自定页
            layer.open({
                type: 1,
                title: "上传进度", //不显示标题
                closeBtn: 0, //不显示关闭按钮
                skin: 'layui-layer-demo', //样式类名
                area: ['420px', 'auto'], //宽高
                content: '<div style="margin: 10px 20px;"><div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="uploadfile"><div class="layui-progress-bar" lay-percent="" id="uploadfile"></div></div><p><span id="uploadfilemsg">正在上传</span></p></div>',
                success: function (layero, index) {
                    layer.setTop(layero); //重点2
                }
            });
            element.render();
        }
        , progress: function (n, elem) {
            //上传进度回调
            var percent = n + '%'; //获取进度百分比
            console.log(percent)
            $("#uploadfile").attr("lay-percent", percent);
            element.render();
        }
        , done: function (res, index, upload) {
            //上传完毕回调
            $("#uploadfilemsg").text("上传完成");
            layer.closeAll(); //关闭loading
            layer.msg("上传成功");
        }
        , error: function () {
            //请求异常回调
            layer.closeAll(); //关闭loading
            layer.msg("请求异常");
        }
    });

    //上传ppt初始化（资料包括zip，rar）
    pptUploadInst = upload.render({
        elem: '#ppt' //绑定元素
        , url: '/manager/leasson/leassonVedioUpload'//上传接口
        , data: {
            courseVedioId: 56,
            fileUploadType: "vedio"
        }
        , accept: 'file' //允许上传的文件类型
        , choose: function (obj) {
            //选择文件后的回调函数
            //console.log(obj);
        }
        , before: function (obj) {
            //自定页
            layer.open({
                type: 1,
                title: "上传进度", //不显示标题
                //closeBtn: 0, //不显示关闭按钮
                skin: 'layui-layer-demo', //样式类名
                area: ['420px', 'auto'], //宽高
                content: '<div style="margin: 10px 20px;"><div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="uploadfile"><div class="layui-progress-bar" lay-percent="" id="uploadfile"></div></div><p><span id="uploadfilemsg">正在上传</span></p></div>',
                success: function (layero, index) {
                    layer.setTop(layero); //重点2
                }
            });
            element.render();
        }
        , progress: function (n, elem) {
            //上传进度回调
            var percent = n + '%'; //获取进度百分比
            $("#uploadfile").attr("lay-percent", percent);
            element.render();
        }
        , done: function (res, index, upload) {
            //上传完毕回调
            $("#uploadfilemsg").text("上传完成");
            layer.closeAll(); //关闭loading
            layer.msg("上传成功");
        }
        , error: function () {
            //请求异常回调
            layer.closeAll(); //关闭loading
            layer.msg("上传失败");
        }
    });

    //普通图片上传
    upload.render({
        elem: '#test1'
        , url: '/manager/leasson/leassonImgUpload'
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }, done: function (res) {
            if (res.data.src !== null) {
                $("#pic").val(res.data.src);
                return layer.msg('上传成功');
            }
        }, error: function () {
        }
    });
});

$(function () {
    $("#footer").load("/html/webui/footer/footer.html");
});
layui.config({
    base: '/html/webui/js/layui/'
}).extend({
    treetable: 'treetable-lay/treetable'
});


//tab标签页引用
layui.use(['layer', 'table', 'treetable', 'element', 'upload'], function () {
    var $ = layui.jquery
        , element = layui.element;
    var table = layui.table;
    var layer = layui.layer;
    var upload = layui.upload;
    var treetable = layui.treetable;

    //一些事件监听
    element.on('tab(demo)', function (data) {
        if (data.index === 1) {
            layer.load(1);
            // 课程视频管理表格
            $.ajax({
                type: "GET",
                url: "/manager/leasson/getLeassonInfo",
                data: {
                    page: 1
                },
                success: function (data) {
                    layer.closeAll('loading');
                    treetable.render({
                        height: 600,
                        treeColIndex: 0,
                        treeSpid: -1,
                        treeIdName: 'name',
                        treePidName: 'name',
                        treeDefaultClose: true,
                        treeLinkage: false,

                        elem: '#table1',
                        data: data.data,
                        page: true,
                        cols: [[
                            {field: 'courseName', title: '课程名称'},
                            {field: 'courseVedioName', edit: 'text', align: "center", title: '章节名称'},
                            {field: 'status', align: "center", width: 120, title: '状态'},
                            {
                                field: 'courseVedioDuringtime',
                                width: 60,
                                edit: 'text',
                                width: 80,
                                align: "center",
                                title: '时长'
                            },
                            {templet: '#oper-col', width: 120, align: "center", title: '操作'},
                        ]]
                    });
                },
                error: function (data) {
                    layer.closeAll('loading');
                    layer.msg('参数异常');
                }
            });
        }else if (data.index === 2) {
            layer.load(1);
            // 课程作业管理表格
            $.ajax({
                type: "GET",
                url: "/manager/leasson/getLeassonTask",
                data: {
                    page: 1
                },
                success: function (data) {
                    layer.closeAll('loading');
                    treetable.render({
                        height: 600,
                        treeColIndex: 0,
                        treeSpid: -1,
                        treeIdName: 'name',
                        treePidName: 'name',
                        treeDefaultClose: true,
                        treeLinkage: false,

                        elem: '#table2',
                        data: data.data,
                        page: true,
                        cols: [[
                            {field: 'courseName', title: '课程名称'},
                            {field: 'courseTaskContent', align: "center",title: '作业内容'},
                            {field: 'updateDate', align: "center", width: 120, title: '更新时间'},
                            {templet: '#oper-col2', width: 120, align: "center", title: '操作'},
                        ]]
                    });
                },
                error: function (data) {
                    layer.closeAll('loading');
                    layer.msg('参数异常');
                }
            });
        }
    });

    //监听工具条
    table.on('tool(table1)', function (obj) {

        var layEvent = obj.event;
        if (obj.data.courseVedioId != null) {
            courseVedioId = obj.data.courseVedioId;
            if (layEvent === 'ppt') {
                pptUploadInst.reload({
                    url: '/manager/leasson/leassonVedioUpload'
                    , data: {
                        courseVedioId: courseVedioId,
                        fileUploadType: "ppt"
                    }
                    , elem: '#ppt' //绑定元素
                    , accept: 'file'
                    , exts: 'pptx|zip|rar|7z' //允许上传资料的格式
                    , size: 1024 * 1024 * 20 //限定大小
                });
                $("#ppt").click();
            } else if (layEvent === 'vedio') {
                vedioUploadInst.reload({
                    url: '/manager/leasson/leassonVedioUpload'
                    , data: {
                        courseVedioId: courseVedioId,
                        fileUploadType: "vedio"
                    }
                    , elem: '#vedio' //绑定元素
                    , accept: 'video' //只允许上传图片
                    , exts: 'mp4'
                    , size: 1024 * 1024 * 300 //限定大小
                });
                $("#vedio").click();
            }
        } else if (obj.data.pid === -1) {
            if (layEvent === 'del') {
                layer.confirm('删除该视频？： ' + obj.data.courseName, {
                    btn: ['删除', '取消'] //按钮
                }, function () {
                    $.ajax({
                        type: "GET",
                        url: "/manager/leasson/deleteLeasson",
                        data: {
                            courseId: obj.data.courseId
                        },
                        success: function (data) {
                            if (data.code === 200) {
                                obj.del();
                                layer.msg('删除成功', {
                                    icon: 16
                                    , shade: 0.01
                                });
                            } else {
                                layer.msg('网络异常，请稍后重试');
                            }
                        },
                        error: function (data) {
                            layer.msg('参数异常');
                        }
                    });
                }, function () {
                });
            }
        }
    });


    //监听单元格编辑
    table.on('edit(table1)', function (obj) {
        updateTable(obj);
    });

    table.on('tool(table2)', function (obj) {
        var layEvent = obj.event;
        courseId = obj.data.courseId;
        courseName = obj.data.courseName;
        courseTaskId = obj.data.courseTaskId;
        if (obj.data.courseTaskId != null) {
            if (layEvent === 'edit') {
                layer.prompt({
                    formType: 2,
                    value: obj.data.courseTaskContent,
                    title: '修改作业内容',
                    area: ['500px', '100px'] //自定义文本域宽高
                }, function (value, index) {
                    updateCourseTask(courseTaskId,value);
                    layer.close(index);
                });
            } else if (layEvent === 'delete') {
                layer.confirm('确认删除？', function (index) {
                    deleteLessonTask(courseTaskId);
                    layer.close(index);
                    obj.del();
                });
            }
        } else if (obj.data.pid === -1) {
            if (layEvent === 'add') {
                layer.prompt({
                    formType: 2,
                    value: ' ',
                    title: '请填写作业内容',
                    area: ['500px', '100px'] //自定义文本域宽高
                }, function (value, index) {
                    addCourseTask(courseId,courseName,value);
                    layer.close(index);
                });
            }
        }
    });


    function updateTable(obj) {
        if (obj.data.courseVedioId != null) {
            $.ajax({
                type: "POST",
                url: "/manager/leasson/updateLeasson",
                contentType: "application/json",
                data: JSON.stringify(obj.data),
                success: function (data) {
                    if (data.code === 200) {
                        layer.msg('更新成功', {
                            icon: 16
                            , shade: 0.01
                        });
                    } else
                        layer.msg('网络异常，请稍后重试');
                },
                error: function (data) {
                    layer.msg('参数异常');
                }
            });
        }
    }
});


//课程说明图片上传方法
layui.use('layedit', function () {
    var layedit = layui.layedit;
    layedit.set({
        uploadImage: {
            url: '/user/news/newImagesUpload' //接口url
            , type: 'POST' //默认post
        }
    });
    var editor = layedit.build('LAY_demo1', {
        height: 170
    });

    //点击发布按钮的操作
    $("#publish").click(function () {
        var title = $("#title").val();
        //var teacher = $("#teacher").val();
        var introduction = layedit.getContent(editor);
        var category = $("#category option:selected").val();
        var number = $("#number").val();
        var time = $("#time").val();
        var picUrl = $("#pic").val();

        if (title.length === 5 || title.length > 30
            || introduction.length === 0 || category.length === 0 || number.length === 0 || time.length === 0 || picUrl.length === 0) {
            layer.msg('请填写完整信息！');
            return;
        }// || teacher.length === 0 || teacher.length > 20
        var data = {
            "courseName": title,
            "courseTotalblocks": number,
            //"courseTeacher": teacher,
            "courseType": category,
            "courseTotaltime": time,
            "courseDescription": introduction,
            "courseImg": picUrl
        };

        $.ajax({
            type: "POST",
            url: "/manager/leasson/applyLeasson",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                if (data.code === 200) {
                    layer.msg('发布成功', {
                        icon: 16
                        , shade: 0.01
                    });
                } else
                    layer.msg('网络异常，请稍后重试');
            },
            error: function (data) {
                layer.msg('参数异常');
            }
        });
    })
});

function textLimitCheck(thisArea, maxLength) {
    if (thisArea.value.length > maxLength) {
        thisArea.value = thisArea.value.substring(0, 30);
        thisArea.focus();
    }
    messageCount.innerText = thisArea.value.length;
}

function addCourseTask(courseId,courseName,taskContent) {
    layer.load(1);
    var taskData = {
        courseId: courseId,
        courseName: courseName,
        courseTaskContent: taskContent
    }
    $.ajax({
        type: "GET",
        url: "/manager/leasson/addCourseTask",
        data: taskData,
        success: function (data) {
            layer.closeAll('loading');
            if (data.code === 200) {
                layer.msg('添加成功', {
                    icon: 1
                    , shade: 0.01
                });
            } else
                layer.msg('网络异常，请稍后重试');
        },
        error: function (data) {
            layer.closeAll('loading');
            layer.msg('网络异常！');
        }
    });
}

function updateCourseTask(courseTaskId,taskContent) {
    var taskData = {
        courseTaskId: courseTaskId,
        courseTaskContent: taskContent
    }
    layer.load();
    $.ajax({
        type: "GET",
        url: "/manager/leasson/updateCourseTask",
        data: taskData,
        success: function (data) {
            layer.closeAll('loading');
            if (data.code === 200) {
                layer.msg('修改成功', {icon: 1, shade: 0.01
                });
            } else
                layer.msg('网络异常，请稍后重试');
        },
        error: function (data) {
            layer.closeAll('loading');
            layer.msg('网络异常！');
        }
    });
}

function deleteLessonTask(courseTaskId) {
    var taskData={
        courseTaskId: courseTaskId
    }
    $.ajax({
        type: "GET",
        url: "/manager/leasson/deleteCourseTask",
        data: taskData,
        success: function (res) {
            if(res.code === 200){
                layer.msg('修改成功', {
                    icon: 1
                    , shade: 0.01
                });
            }else{
                layer.msg("网络异常!");
            }
        },
        error: function (data) {
            layer.msg("网络异常!");
        }
    })

}


