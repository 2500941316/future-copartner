package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProLog;
import com.shu.copartner.pojo.ProLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLogMapper {
    long countByExample(ProLogExample example);

    int deleteByExample(ProLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(ProLog record);

    int insertSelective(ProLog record);

    List<ProLog> selectByExample(ProLogExample example);

    ProLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") ProLog record, @Param("example") ProLogExample example);

    int updateByExample(@Param("record") ProLog record, @Param("example") ProLogExample example);

    int updateByPrimaryKeySelective(ProLog record);

    int updateByPrimaryKey(ProLog record);
}