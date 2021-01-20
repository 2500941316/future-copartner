package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProStudent;
import com.shu.copartner.pojo.ProStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProStudentMapper {
    long countByExample(ProStudentExample example);

    int deleteByExample(ProStudentExample example);

    int deleteByPrimaryKey(Long studentid);

    int insert(ProStudent record);

    int insertSelective(ProStudent record);

    List<ProStudent> selectByExample(ProStudentExample example);

    ProStudent selectByPrimaryKey(Long studentid);

    int updateByExampleSelective(@Param("record") ProStudent record, @Param("example") ProStudentExample example);

    int updateByExample(@Param("record") ProStudent record, @Param("example") ProStudentExample example);

    int updateByPrimaryKeySelective(ProStudent record);

    int updateByPrimaryKey(ProStudent record);
}