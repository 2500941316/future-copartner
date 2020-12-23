package com.shu.copartner.utils.constance;

/**
 * @author cxy
 * @Date: 2020/12/6 14:36
 * @Description: 常量类
 */
public final class ConstantsTT {

    /**
     * @Description 用户名的长度
     */
    public static final int USERNAME_LENGTH = 8;

    /**
     * @Description 每一页查询的个数
     */
    public static final int pageSize = 10;

    /**
     * @Description 一共显示几个页数选择
     */
    public static final int pageView = 5;

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
     * @Description 新闻发布流程中,用来查询task表中用户申请的任务
     */
    public static final String NEWSAPPLY_PROCESS_APPLYNAME = "用户提交新闻申请";

    /**
     * @Description 新闻发布流程中,用来查询task表中管理员审批任务
     */
    public static final String NEWSAPPLY_PROCESS_MANAGERNAME = "管理员审批文章";

    /**
     * @Description 管理员角色名
     */
    public static final String MANAGER_ROLE = "manager";

    /**
     * @Description 项目流程key
     */
    public static final String PROJECT_PROCESS_PROCESSKEY = "project_process";

    /**
     * @Description 用于查询
     */
    public static final String PROJECTAPPLY_PROCESS_APPLYNAME = "用户提交项目申请";

    /**
     * @Description 用于查询
     */
    public static final String PROJECT_PROCESS_MANAGERNAME = "管理员审批项目申请";


    /**
     * @Description activiti任务间传输object对象的参数名称
     */
    public static final String ACTIVITI_OBJECT_NAME = "object";

}