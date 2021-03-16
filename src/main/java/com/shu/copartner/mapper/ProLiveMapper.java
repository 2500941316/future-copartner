package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProLive;
import com.shu.copartner.pojo.ProLiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLiveMapper {
    long countByExample(ProLiveExample example);

    int deleteByExample(ProLiveExample example);

    int deleteByPrimaryKey(Long liveId);

    int insert(ProLive record);

    int insertSelective(ProLive record);

    List<ProLive> selectByExample(ProLiveExample example);

    /**
     * 查询直播列表
     * @return
     */
    List<ProLive> selectAllLives();


    ProLive selectByPrimaryKey(Long liveId);

    int updateByExampleSelective(@Param("record") ProLive record, @Param("example") ProLiveExample example);

    int updateByExample(@Param("record") ProLive record, @Param("example") ProLiveExample example);

    int updateByPrimaryKeySelective(ProLive record);

    int updateByPrimaryKey(ProLive record);
}