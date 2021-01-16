package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProActivity;
import com.shu.copartner.pojo.ProActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProActivityMapper {
    long countByExample(ProActivityExample example);

    int deleteByExample(ProActivityExample example);

    int deleteByPrimaryKey(Long activityId);

    int insert(ProActivity record);

    int insertSelective(ProActivity record);

    List<ProActivity> selectByExample(ProActivityExample example);
    /**
     * 查询所有已发布活动，根据时间倒序
     * @return
     */
      List<ProActivity> selectAllActivityPublished();

    /**
     * 查询所有活动
     * @return
     */
     List<ProActivity> selectAllActivity();

    ProActivity selectByPrimaryKey(Long activityId);

    int updateByExampleSelective(@Param("record") ProActivity record, @Param("example") ProActivityExample example);

    int updateByExample(@Param("record") ProActivity record, @Param("example") ProActivityExample example);

    int updateByPrimaryKeySelective(ProActivity record);

    int updateByPrimaryKey(ProActivity record);
}