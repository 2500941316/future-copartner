package com.shu.copartner.utils.constance;

import io.swagger.models.auth.In;

import java.util.ArrayList;
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
    public static final int USERNAME_LENGTH = 8;

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
    public static final Integer LEASSON_CLICKNUMBER = 5;

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


}