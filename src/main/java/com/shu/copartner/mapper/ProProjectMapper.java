package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.ProProjectExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProProjectMapper {
    long countByExample(ProProjectExample example);

    int deleteByExample(ProProjectExample example);

    int deleteByPrimaryKey(Long projectId);

    int insert(ProProject record);


    int insertSelective(ProProject record);

    // 根据用户名称查询
    List<ProProject> selectByCreater(@Param("projectCreater") String projectCreater);

     /*  *
     * 根据状态值查询待审批项目
     * @param tokens
     * @return
     */
    List<ProProject> selectProjectByToken(@Param("tokens") String[] tokens);

    /**
     * 根据id查询其他项目数据
     * @param projectId
     * @return
     */
    List<ProProject> selectOtherProjectById(@Param("projectId") Long projectId);

    List<ProProject> selectByExample(ProProjectExample example);

    /* *
     * 查询所有项目
     * @return
     */
    List<ProProject> selectAllProject();

    /**
     * 随机查询3个项目
     * @return
     */
    List<ProProject> selectRandom();

    /**
     *查询我关注的项目
     * @return
     */
    List<ProProject> selectMyFollowProject(@Param("follower") String follower);

    /**
     *查询我加入的项目
     * @return
     */
    List<ProProject> selectMyJoinProject(@Param("phone") String phone);

    /**
     *查询我的被关注的项目
     * @return
     */
    List<ProProject> selectProjectBeFollowed(@Param("projectCreater") String projectCreater);

    Long selectCountOfProject(@Param("projectCreater") String projectCreater);

    ProProject selectByPrimaryKey(Long projectId);

    int updateByExampleSelective(@Param("record") ProProject record, @Param("example") ProProjectExample example);

    int updateByExample(@Param("record") ProProject record, @Param("example") ProProjectExample example);

    int updateByPrimaryKeySelective(ProProject record);

    int updateByPrimaryKey(ProProject record);
}