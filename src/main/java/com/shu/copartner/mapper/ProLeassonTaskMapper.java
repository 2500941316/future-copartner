package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProLeassonTask;
import com.shu.copartner.pojo.ProLeassonTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLeassonTaskMapper {
    long countByExample(ProLeassonTaskExample example);

    int deleteByExample(ProLeassonTaskExample example);

    int deleteByPrimaryKey(Long courseTaskId);

    int insert(ProLeassonTask record);

    int insertSelective(ProLeassonTask record);

    List<ProLeassonTask> selectByExample(ProLeassonTaskExample example);

    ProLeassonTask selectByPrimaryKey(Long courseTaskId);

    int updateByExampleSelective(@Param("record") ProLeassonTask record, @Param("example") ProLeassonTaskExample example);

    int updateByExample(@Param("record") ProLeassonTask record, @Param("example") ProLeassonTaskExample example);

    int updateByPrimaryKeySelective(ProLeassonTask record);

    int updateByPrimaryKey(ProLeassonTask record);
}