var colorList;
var count;
var category;
var form;
var layer;
var layedit;
var laydate;
var clock = '';
var nums = 90;
var btn;
$(function () {
    count = 3;
    loadFlow(count);
    checkColor(colorList);

})


layui.use(['form', 'layedit', 'laydate'], function () {
    form = layui.form;
    layer = layui.layer;
    layedit = layui.layedit;
    laydate = layui.laydate;

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        }
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
        , content: function (value) {
            layedit.sync(editIndex);
        }
    });

    form.on('select(aihao)', function (data) {
        category = data.value; //得到被选中的值
    });

    //监听指定开关
    form.on('switch(switchTest)', function (data) {
        layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    //监听提交
    form.on('submit(LAY-user-reg-submits)', function (data) {
        $.ajax({
            type: "post",
            url: "/public/registry",
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(data.field),
            success: function (data) {
                if (data.code === 200) {
                    parent.layer.closeAll();
                    parent.layer.msg('提交成功，请等待管理员审核');
                } else if (data.code === 10) {
                    layer.msg('验证码过期');
                    return false;
                } else if (data.code === 11) {
                    layer.msg('验证码错误');
                    return false;
                } else if (data.code === 12) {
                    layer.msg('验证码验证异常，请重新验证');
                    return false;
                } else if (data.code === 13) {
                    layer.msg('您已经注册过，请等待管理员审核');
                    return false;
                } else {
                    return false;
                }
            },
            error: function (data) {
                layer.msg('网络异常');
            }
        });
        return false;
    });

    //表单取值
    layui.$('#LAY-component-form-getval').on('click', function () {
        var data = form.val('example');
        alert(JSON.stringify(data));
    });
});


/**
 * 获得短信验证码的方法
 */
function getverifyCode(thisBtn) {
    if ($('#LAY-user-login-cellphone').val().length !== 11) {
        return;
    }
    $.ajax({
        type: "get",
        url: "/public/registerGetVrifyCode",
        data: {
            "phone": $('#LAY-user-login-cellphone').val()
        },
        success: function (data) {
            if (data.code === 200) {
                btn = thisBtn;
                btn.disabled = true; //将按钮置为不可点击
                btn.value = '重新获取（' + nums + '）';
                clock = setInterval(doLoop, 1000); //一秒执行一次
            } else if (data.code === 8)
                layer.msg('手机号码已经注册，请直接登录');
        },
        error: function (data) {
            layer.msg('参数异常');
        }
    });
}

/**
 * 发送验证码倒计时
 */
function doLoop() {
    nums--;
    if (nums > 0) {
        btn.value = '重新获取（' + nums + '）';
    } else {
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        btn.value = '发送验证码';
        nums = 90;
    }
}

//页面跳转
function methodBtn(index, method, end) {
    var fFor;
    if (end != true) {
        if (method == "back") {
            if (index == 1) {
                fFor = ".for" + String.fromCharCode(index + 65);
            } else {
                fFor = ".for" + String.fromCharCode(index + 64);
            }
            $(fFor).removeClass("for-cur");
            loadFlowDiv(index - 1);
            checkColor("default");
        } else if (method == "forward") {
            fFor = ".for" + String.fromCharCode(index + 65);
            $(fFor).addClass("for-cur");
            loadFlowDiv(index + 1);
            checkColor(colorList);
        }
    } else if (end == true) {

    }

}

//确定流程颜色状态
function checkColor(color) {

    if (color != "default") {
        $(".flowList.for-cur").css({"border": "2px solid #1ABB9C"});
        $(".flowList.for-cur,.flowListBox .for-cur em").css({"background-color": "#1ABB9C"});
        $(".flowListBox .for-cur em").css({"border": "0px none #000"});
    } else {
        $this = $('.flowList:not(.for-cur)');
        $this.css({"border": "2px solid #ccc", "background-color": "#ccc"});
        $this.children("em").css({"background-color": "#ccc"});
    }
    /*让当前选中步骤变为深蓝色*/
    var obj = $('.for-cur:last');
    obj.css({"border": "2px solid #34495e", "background-color": "#34495e"});
    obj.children("em").css({"background-color": "#34495e"});
}

//确定步骤的宽度占比
function fixWidth(count) {
    var part = parseInt(100 / count) + "%";
    $(".flowListBox .flowList").css("width", part);
}

//加载步骤
function loadFlow(count) {
    var flowFor;
    var flowVar = "";
    for (var i = 1; i <= count; i++) {
        flowFor = "for" + String.fromCharCode(i + 64);
        if (i == 1) {
            flowVar += "<div class='flowList for-cur " + flowFor + "' style='position:relative'>\n";
            flowVar += "	<em style='position:absolute;left:35%'>" + i + "</em><br/><strong style='position:absolute;left:40%'>第" + i + "步</strong>\n";
            flowVar += "</div>\n";
        } else {
            flowVar += "<div class='flowList " + flowFor + "' style='position:relative'>\n";
            flowVar += "	<em style='position:absolute;left:35%'>" + i + "</em><br/><strong style='position:absolute;left:40%'>第" + i + "步</strong>\n";
            flowVar += "</div>\n";
        }

    }
    $(".flowListBox").html(flowVar);
    fixWidth(count);
    loadFlowDiv(1);
    checkBtn(1, count);
}

//加载内容详情
function loadFlowDiv(index) {

    if (index === 1) {
        $("#contA").removeClass("contentList");
        $("#contA").siblings().addClass("contentList")
    }
    if (index === 2) {

        if (category === "ROLE_STUDENT") {
            document.getElementById("contents").innerHTML = $("#student").html();
            laydate.render({
                elem: document.getElementById('test1')
            });
        } else if (category === "ROLE_TEACHER") {
            document.getElementById("contents").innerHTML = $("#teacher").html();
        } else {
            document.getElementById("contents").innerHTML = $("#company").html();
            laydate.render({
                elem: document.getElementById('birthday')
            });
            laydate.render({
                elem: document.getElementById('gradutedate')
            });
        }
        form.render();


        $("#contB").removeClass("contentList");
        $("#contB").siblings().addClass("contentList")
    }
    if (index === 3) {
        $("#contC").removeClass("contentList");
        $("#contC").siblings().addClass("contentList")
    }
    if (index === 4) {
        $("#contD").removeClass("contentList");
        $("#contD").siblings().addClass("contentList")
    }


}

//上一步下一步按钮点击事件
var maxstep = 1;

function checkBtn(index, count) {

    $("#btnBack").addClass("disabled");
    /*默认进来隐藏上一步按钮*/
    $("#btnBack").hide();
    /*下一步点击事件*/
    $("#btnNext").click(function () {
        if (category == null) {
            return;
        }
        methodBtn(index++, 'forward', false);
        if (index > maxstep) {
            maxstep = index;

        }
        if (index != 1) {
            /*非第一步的时候，显示上一步*/
            $("#btnBack").removeClass("disabled");
            $("#btnBack").show();
        }
        if (index >= count) {
            /*到最后一步时 去掉下一步 显示上一步和完成*/
            $("#btnNext").hide();
            $("#btnBack").show();
            $("#btnok").show();
        }
        refreshBack(index);
    });
    /*上一步点击事件*/
    $("#btnBack").click(function () {
        if (refreshBack(index) > 1) {
            methodBtn(index--, 'back', false);
            $("#btnok").hide();
            $("#btnNext").show();
            if (index == 1) {
                /*如果当前为第一步 则给上一步添加disabled属性*/
                $("#btnBack").addClass("disabled");
            }
        }
    });
}

/*上一步*/
function refreshBack(index) {
    return index;

}
