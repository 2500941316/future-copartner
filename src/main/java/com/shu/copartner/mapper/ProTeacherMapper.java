package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProTeacher;
import com.shu.copartner.pojo.ProTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProTeacherMapper {
    long countByExample(ProTeacherExample example);

    int deleteByExample(ProTeacherExample example);

    int deleteByPrimaryKey(Long teacherid);

    int insert(ProTeacher record);

    int insertSelective(ProTeacher record);

    List<ProTeacher> selectByExample(ProTeacherExample example);

    ProTeacher selectByPrimaryKey(Long teacherid);

    int updateByExampleSelective(@Param("record") ProTeacher record, @Param("example") ProTeacherExample example);

    int updateByExample(@Param("record") ProTeacher record, @Param("example") ProTeacherExample example);

    int updateByPrimaryKeySelective(ProTeacher record);

    int updateByPrimaryKey(ProTeacher record);
}