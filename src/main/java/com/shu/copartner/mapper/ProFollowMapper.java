package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProFollow;
import com.shu.copartner.pojo.ProFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProFollowMapper {
    long countByExample(ProFollowExample example);

    int deleteByExample(ProFollowExample example);

    int deleteByPrimaryKey(Long followId);

    int insert(ProFollow record);

    int insertSelective(ProFollow record);

    List<ProFollow> selectByExample(ProFollowExample example);

    ProFollow selectByPrimaryKey(Long followId);

    // 根据projectId 和 follower 查询
    ProFollow selectByPidFollower(@Param("projectId") Long projectId, @Param("follower") String follower);

    ProFollow selectByPidFolloer02(@Param("projectId") Long projectId, @Param("follower") String follower);

    // 根据projectId查询
    List<ProFollow> selectUserOfFollowMe(@Param("projectId") Long projectId);

    // 我关注的项目的个数
    Long selectCountOfMyFollow(@Param("follower") String follower);

    //查询关注我的项目 关注总个数，一个人同时关注我的十个项目结果就是10，不一定是人数，是关注总数
    Long selectCountOfFollowMe(@Param("follower") String follower);

    int updateByExampleSelective(@Param("record") ProFollow record, @Param("example") ProFollowExample example);

    int updateByExample(@Param("record") ProFollow record, @Param("example") ProFollowExample example);

    int updateByPrimaryKeySelective(ProFollow record);

    int updateByPrimaryKey(ProFollow record);
}