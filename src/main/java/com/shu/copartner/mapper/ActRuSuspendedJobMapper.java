package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActRuSuspendedJob;
import com.shu.copartner.pojo.ActRuSuspendedJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActRuSuspendedJobMapper {
    long countByExample(ActRuSuspendedJobExample example);

    int deleteByExample(ActRuSuspendedJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActRuSuspendedJob record);

    int insertSelective(ActRuSuspendedJob record);

    List<ActRuSuspendedJob> selectByExample(ActRuSuspendedJobExample example);

    ActRuSuspendedJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActRuSuspendedJob record, @Param("example") ActRuSuspendedJobExample example);

    int updateByExample(@Param("record") ActRuSuspendedJob record, @Param("example") ActRuSuspendedJobExample example);

    int updateByPrimaryKeySelective(ActRuSuspendedJob record);

    int updateByPrimaryKey(ActRuSuspendedJob record);
}