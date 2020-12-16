package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActGeProperty;
import com.shu.copartner.pojo.ActGePropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActGePropertyMapper {
    long countByExample(ActGePropertyExample example);

    int deleteByExample(ActGePropertyExample example);

    int deleteByPrimaryKey(String name);

    int insert(ActGeProperty record);

    int insertSelective(ActGeProperty record);

    List<ActGeProperty> selectByExample(ActGePropertyExample example);

    ActGeProperty selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") ActGeProperty record, @Param("example") ActGePropertyExample example);

    int updateByExample(@Param("record") ActGeProperty record, @Param("example") ActGePropertyExample example);

    int updateByPrimaryKeySelective(ActGeProperty record);

    int updateByPrimaryKey(ActGeProperty record);
}