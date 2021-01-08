$(function () {
    $("#footer").load("/html/webui/footer/footer.html");
});

layui.config({
    base: '/html/managerui/js/layui/'
}).extend({
    treetable: 'treetable-lay/treetable'
});

//课程图片上传方法
layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    //普通图片上传
    var uploadInst = upload.render({
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
})


//tab标签页引用
layui.use(['layer', 'table', 'treetable', 'element', 'upload'], function () {
    var $ = layui.jquery
        , element = layui.element;
    var table = layui.table;
    var upload = layui.upload;
    var layer = layui.layer;
    var treetable = layui.treetable;

    //一些事件监听
    element.on('tab(demo)', function (data) {
        if (data.index === 1) {
            $.ajax({
                type: "GET",
                url: "/manager/leasson/getLeassonInfo",
                data: {
                    page: 1
                },
                success: function (data) {
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
                            {field: 'courseVedioDuringtime',width:60, edit: 'text', width: 80, align: "center", title: '时长'},
                            {templet: '#oper-col',width:120, align: "center", title: '操作'},
                        ]]
                    });
                },
                error: function (data) {
                    layer.msg('参数异常');
                }
            });
        }
    });

    //上传vedio
    upload.render({
        elem: '#vedio'
        , url: '/manager/leasson/leassonVedioUpload' //改成您自己的上传接口
        , data: {
            courseVedioId: localStorage.getItem("course_vedio_id"),
            fileUploadType: "vedio"
        }
        , accept: 'file',
        before: function (obj) {
            console.log(obj)
            layer.load(2);

        },
        done: function (res) {
            layer.closeAll('loading');
            layer.msg('视频上传成功', {
                offset: 't',
                anim: 6
            });
        }
    });

    //上传ppt
    upload.render({
        elem: '#ppt'
        , url: '/manager/leasson/leassonVedioUpload'
        , data: {
            course_vedio_id: localStorage.getItem("course_vedio_id"),
            fileUploadType: "ppt"
        },
        accept: 'file',
        before: function (obj) {
            layer.load(2);

        },
        done: function (res) {
            layer.closeAll('loading');
            layer.msg('ppt上传成功', {
                offset: 't',
                anim: 6
            });
        }
    });


    //监听工具条
    table.on('tool(table1)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (obj.data.courseVedioId != null) {

            localStorage.setItem("course_vedio_id", obj.data.courseVedioId);
            if (layEvent === 'ppt') {
                $("#ppt").click();
            } else if (layEvent === 'vedio') {
                $("#vedio").click();
            }
        } else if (obj.data.pid === -1) {
            if (layEvent === 'del') {
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


    //监听单元格编辑
    table.on('edit(table1)', function (obj) {
        update(obj);
    });

    function update(obj) {
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
        var teacher = $("#teacher").val();
        var introduction = layedit.getContent(editor);
        var category = $("#category option:selected").val();
        var number = $("#number").val();
        var time = $("#time").val();
        var picUrl = $("#pic").val();

        if (title.length === 5 || title.length > 30 || teacher.length === 0 || teacher.length > 20
            || introduction.length === 0 || category.length === 0 || number.length === 0 || time.length === 0 || picUrl.length === 0) {
            layer.msg('请填写完整信息！');
            return;
        }
        var data = {
            "courseName": title,
            "courseTotalblocks": number,
            "courseTeacher": teacher,
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
