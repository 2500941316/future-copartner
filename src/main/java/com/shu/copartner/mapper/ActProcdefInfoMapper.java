package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActProcdefInfo;
import com.shu.copartner.pojo.ActProcdefInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActProcdefInfoMapper {
    long countByExample(ActProcdefInfoExample example);

    int deleteByExample(ActProcdefInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActProcdefInfo record);

    int insertSelective(ActProcdefInfo record);

    List<ActProcdefInfo> selectByExample(ActProcdefInfoExample example);

    ActProcdefInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActProcdefInfo record, @Param("example") ActProcdefInfoExample example);

    int updateByExample(@Param("record") ActProcdefInfo record, @Param("example") ActProcdefInfoExample example);

    int updateByPrimaryKeySelective(ActProcdefInfo record);

    int updateByPrimaryKey(ActProcdefInfo record);
}