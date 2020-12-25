package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProLeasson;
import com.shu.copartner.pojo.ProLeassonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLeassonMapper {
    long countByExample(ProLeassonExample example);

    int deleteByExample(ProLeassonExample example);

    int deleteByPrimaryKey(Long courseId);

    int insert(ProLeasson record);

    int insertSelective(ProLeasson record);

    List<ProLeasson> selectByExample(ProLeassonExample example);

    ProLeasson selectByPrimaryKey(Long courseId);

    int updateByExampleSelective(@Param("record") ProLeasson record, @Param("example") ProLeassonExample example);

    int updateByExample(@Param("record") ProLeasson record, @Param("example") ProLeassonExample example);

    int updateByPrimaryKeySelective(ProLeasson record);

    int updateByPrimaryKey(ProLeasson record);
}