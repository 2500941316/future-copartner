package com.shu.copartner.utils.constance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxy
 * @Date: 2020/12/6 14:36
 * @Description: 常量类
 */
public final class Constants {
    /**
     * fastdfs删除时filename截取的长度
     */
    public static final Integer FASTDFSSUBSTRLEN = 28;

    /**
     * fastdfs的组名称
     */
    public static final String FASTDFSGROUPNAME = "group1";

    /**
     * @Description 用户名的长度
     */
    public static final int USERNAME_LENGTH = 11;

    /**
     * @Description 每一页查询的个数
     */
    public static final int PAGESIZE = 10;

    /**
     * @Description 一共显示几个页数选择
     */
    public static final int PAGEVIEW = 5;

    /**
     * @Description 请假流程的key
     */
    public static final String QJ_KEY = "QJ";

    /**
     * @Description 文件服务器的前缀
     */
    public static final String FILEURL_FIRSTNAME = "http://114.55.93.118/";
/*   http://114.55.93.118/ 改 10.10.0.24*/

    /**
     * @Description 用户注册流程码
     * 1：待审核
     * 2.同意
     * 3.驳回
     */
    public static final Integer[] REGISTER_CODE = {1, 2, 3};

    /**
     * 需要登录才能访问的界面
     */
    public static final List<String> ROUTE_URL = Arrays.asList("/html/managerui/index.html", "/html/webui/personal/person.html");

    public static final String ERROR_URL = "http://47.99.244.66:8080/html/webui/header/login/error.html";

    /**
     * @Description 新闻发布流程processKey
     */
    public static final String NEWSAPPLY_PROCESSKEY = "newApply_Process";

    /**
     * @Description 新闻发布流程中，用户的身份
     */
    public static final String NEWSAPPLY_PROCESS_USERALIGN = "newsAuthor";

    /**
     * @Description 新闻发布流程中, 用来查询task表中用户申请的任务
     */
    public static final String NEWSAPPLY_PROCESS_APPLYNAME = "用户提交新闻申请";

    /**
     * @Description 新闻发布流程中, 用来查询task表中管理员审批任务
     */
    public static final String NEWSAPPLY_PROCESS_MANAGERNAME = "管理员审批文章";

    /**
     * @Description 新闻种类的列表
     */
    public static final String[] NEWS_CATAGORIES = new String[]{"精彩上大", "每周一文", "项目风采", "人文社科", "活动咨询", "法律法规"};

    /**
     * @Description 新闻是否审核标志位
     */
    public static final String NEW_AUTHED = "1";

    /**
     * @Description 新闻是否置顶标志位
     */
    public static final String NEW_ISTOP = "是";

    /**
     * @Description 新闻关键字查询前缀
     */
    public static final String NEW_FIRSTKEY = "s_";

    /**
     * @Description 新闻按照时间排序查询条件
     */
    public static final String NEW_DESCBYDATE = "news_publisTime desc";


    /**
     * @Description 新闻按照点击数量排序查询条件
     */
    public static final String NEW_DESCBYCLICKTIME = "news_browseCount desc";

    /**
     * @Description 课程资料上传的状态
     */
    public static final String LEASSON_FILESTATUS_NOPPT = "资料不完整";

    /**
     * @Description 课程资料上传的状态
     */
    public static final String LEASSON_FILESTATUS_FINE = "资料完整";

    /**
     * @Description 课程按照章节排序查询条件
     */
    public static final String LEASSON_ASCBYNUMBER = "course_vedio_number asc";


    /**
     * @Description 推荐课程模块查询的数量
     */
    public static final Integer LEASSON_CLICKNUMBER = 4;

    /**
     * @Description 课程页面按照点击数来排序
     */
    public static final String LEASSON_DESCBYCLICKTIMES = "course_clickTime desc";

    /**
     * @Description 课程上传材料的类型
     */
    public static final String LEASSON_FILETYPE_PPT = "ppt";

    /**
     * @Description 课程上传材料的类型
     */
    public static final String LEASSON_FILETYPE_VEDIO = "vedio";


    /**
     * @Description TRUE标志位
     */
    public static final Boolean TRUE = true;

    /**
     * @Description False标志位
     */
    public static final Boolean FALSE = false;
    /**
     * @Description 未被删除标识位
     */
    public static final String NO_DELETED = "0";

    /**
     * @Description 已经被删除标识位
     */
    public static final String BE_DELETED = "1";


    /**
     * @Description 项目流程key
     */
    public static final String PROJECT_PROCESS_PROCESSKEY = "project_Process";

    /**
     * @Description 项目申请流程中，用户的身份
     */
    public static final String PROJECTAPPLY_PROCESS_USERALIGN = "applicant";

    /**
     * @Description 项目申请流程中, 用来查询task表中用户申请的任务
     */
    public static final String PROJECTAPPLY_PROCESS_APPLYNAME = "用户提交项目申请";

    /**
     * @Description 项目申请流程中, 用来查询task表中用户申请的任务
     */
    public static final String PROJECTAPPLY_PROCESS_MANAGERNAME = "管理员审批项目申请";

    /**
     * @Description 管理员角色名
     */
    public static final String MANAGER_ROLE = "manager";

    /**
     * @Description activiti任务间传输object对象的参数名称
     */
    public static final String ACTIVITI_OBJECT_NAME = "object";

    /**
     * @Description 项目状态对应的标志
     */
    public static final Map<String, String> PROJECT_STATE_TOKEN = new HashMap<String, String>() {
        {
            put("11", "项目申请待提交");
            put("12", "人员加入待提交");
            put("13", "项目视频待上传");
            put("14", "项目计划书待上传");

            put("21", "项目申请审批中");
            put("22", "项目申请审批已通过");
            put("23", "项目申请审批已驳回");

            put("31", "人员加入审批中");
            put("32", "人员加入审批已通过");
            put("33", "人员加入审批已驳回");

            put("41", "项目视频审批中");
            put("42", "项目视频审批已通过");
            put("43", "项目视频审批已驳回");

            put("51", "项目计划书审批中");
            put("52", "项目计划书审批已通过");
            put("53", "项目计划书审批已驳回");

            put("10", "项目里程碑");
            put("0", "项目未开始");
            put("1", "项目已完成");
            put("2", "在创");
            put("3", "可选");

        }
    };

    /**
     * 活动的状态设置
     */
    public static final String ACTIVITY_BEFORE_START = "未开始";
    public static final String ACTIVITY_IN_START = "进行中";
    public static final String ACTIVITY_AFTER_START = "已结束";

    /**
     * 直播状态设置
     */
    public static final String LIVE_BEFORE_START = "未开始";
    public static final String LIVE_IN_START = "正在直播";
    public static final String LIVE_AFTER_START = "已结束";


    /**
     * @Description 项目按照时间排序查询条件
     */
    public static final String PROJECT_DESCBYDATE = "starttime desc";

    /**
     * @Description 项目类型
     */
    public static final String[] PROJECT_CATAGORIES = new String[]{"新零售", "文创", "科创", "K12", "校园行", "其他"};

    /**
     * @Description 人员加入项目状态
     */
    public static final String[] MEMBER_PROJECT_STAUTS = new String[]{"已申请", "已加入", "已拒绝","已退出","已邀请"};

    /**
     * 管理员角色
     */
    public static final String USER_AUTH_MANAGER = "ROLE_MANAGER";

    /**
     * 活动按照开始时间倒序
     */
    public static final String ACTIVITY_DESCBYDATE = "start_time desc";

}