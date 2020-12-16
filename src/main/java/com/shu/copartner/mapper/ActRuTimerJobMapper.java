package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActRuTimerJob;
import com.shu.copartner.pojo.ActRuTimerJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActRuTimerJobMapper {
    long countByExample(ActRuTimerJobExample example);

    int deleteByExample(ActRuTimerJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActRuTimerJob record);

    int insertSelective(ActRuTimerJob record);

    List<ActRuTimerJob> selectByExample(ActRuTimerJobExample example);

    ActRuTimerJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActRuTimerJob record, @Param("example") ActRuTimerJobExample example);

    int updateByExample(@Param("record") ActRuTimerJob record, @Param("example") ActRuTimerJobExample example);

    int updateByPrimaryKeySelective(ActRuTimerJob record);

    int updateByPrimaryKey(ActRuTimerJob record);
}