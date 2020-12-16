package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProGroup;
import com.shu.copartner.pojo.ProGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProGroupMapper {
    long countByExample(ProGroupExample example);

    int deleteByExample(ProGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProGroup record);

    int insertSelective(ProGroup record);

    List<ProGroup> selectByExample(ProGroupExample example);

    ProGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProGroup record, @Param("example") ProGroupExample example);

    int updateByExample(@Param("record") ProGroup record, @Param("example") ProGroupExample example);

    int updateByPrimaryKeySelective(ProGroup record);

    int updateByPrimaryKey(ProGroup record);
}