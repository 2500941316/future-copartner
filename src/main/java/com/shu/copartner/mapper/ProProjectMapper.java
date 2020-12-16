package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.ProProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProProjectMapper {
    long countByExample(ProProjectExample example);

    int deleteByExample(ProProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProProject record);

    int insertSelective(ProProject record);

    List<ProProject> selectByExample(ProProjectExample example);

    ProProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProProject record, @Param("example") ProProjectExample example);

    int updateByExample(@Param("record") ProProject record, @Param("example") ProProjectExample example);

    int updateByPrimaryKeySelective(ProProject record);

    int updateByPrimaryKey(ProProject record);
}