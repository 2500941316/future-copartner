package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProPerson;
import com.shu.copartner.pojo.ProPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPersonMapper {
    long countByExample(ProPersonExample example);

    int deleteByExample(ProPersonExample example);

    int deleteByPrimaryKey(Long personid);

    int insert(ProPerson record);

    int insertSelective(ProPerson record);

    List<ProPerson> selectByExample(ProPersonExample example);

    ProPerson selectByPrimaryKey(Long personid);

    int updateByExampleSelective(@Param("record") ProPerson record, @Param("example") ProPersonExample example);

    int updateByExample(@Param("record") ProPerson record, @Param("example") ProPersonExample example);

    int updateByPrimaryKeySelective(ProPerson record);

    int updateByPrimaryKey(ProPerson record);
}