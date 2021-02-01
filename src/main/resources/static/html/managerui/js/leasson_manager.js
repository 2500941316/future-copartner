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

    //上传ppt初始化
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
                    , accept: 'file' //只允许上传图片
                    , exts: 'pptx'
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
