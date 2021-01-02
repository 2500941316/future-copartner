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

    // 根据projectId查询
    List<ProFollow> selectUserOfFollowMe(@Param("projectId") Long projectId);

    int updateByExampleSelective(@Param("record") ProFollow record, @Param("example") ProFollowExample example);

    int updateByExample(@Param("record") ProFollow record, @Param("example") ProFollowExample example);

    int updateByPrimaryKeySelective(ProFollow record);

    int updateByPrimaryKey(ProFollow record);
}