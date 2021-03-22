//新闻申请tab表格的使用
function searchNewsApplication() {
    layui.use('table', function () {
        var table = layui.table
            , form = layui.form;

        table.render({
            elem: '#new'
            , url: '/manager/news/searchNewsApplication'
            , cols: [[
                {field: 'newsTitle', title: '标题', width: 130, align: 'center'},
                {field: 'newsAuthor', title: '发布人', width: 110, align: 'center'},
                {field: 'newsCategory', title: '种类', width: 110, align: 'center'},
                {field: 'newsPublistime', title: '发布时间', width: 150, sort: true, align: 'center'},
                {field: 'istopping', title: '置顶', align: 'center', width: 80},
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo'}
            ]]
            , page: true
        });

        //监听性别操作
        form.on('switch(sexDemo)', function (obj) {
            layer.tips("更改置顶项" + obj.othis);
        });

        //监听行工具事件
        table.on('tool(new)', function (obj) {
            var data = obj.data;
            if (obj.event === 'pass') {
                layer.confirm('批准该帖子上线？', function (index) {
                    operateNew(obj, 1, "");
                    layer.close(index);
                });
            } else if (obj.event === 'reject') {
                layer.prompt({
                    formType: 2
                    , value: data.email
                }, function (value, index) {
                    operateNew(obj, 2, value);
                    layer.close(index);
                });
            } else if (obj.event === 'view') {
                viewNew(data.newsId);
            }
        });
    });
}

//点击查看新闻按钮，打开一个对话框
function viewNew(newsId) {
    localStorage.setItem("newId", newsId);
    layui.use("layer", function () {
        var layer = layui.layer;
        layer.open({
            type: 2,
            area: ["90%", "100%"],
            fixed: false, //不固定
            maxmin: true,
            content: "../../../webui/news/news_content.html"
        });
    });
}

//通过或者驳回新闻申请的方法:通过为1，驳回为2
function operateNew(thisNew, isaudit, newsAdvice) {
    var data = {
        newsId: thisNew.data.newsId,
        taskId: thisNew.data.taskId,
        isaudit: isaudit,
        newsAdvice: newsAdvice,
    };

    $.ajax({
        type: "POST",
        url: "/manager/news/operateNew",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (data) {
            if (data.code === 200) {

                layer.msg('操作成功', function () {
                });
                thisNew.del();
            } else
                layer.msg('网络异常，请稍后重试');
        },
        error: function (data) {
            layer.msg('参数异常');
        }
    });
}