package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActRuIntegration;
import com.shu.copartner.pojo.ActRuIntegrationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActRuIntegrationMapper {
    long countByExample(ActRuIntegrationExample example);

    int deleteByExample(ActRuIntegrationExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActRuIntegration record);

    int insertSelective(ActRuIntegration record);

    List<ActRuIntegration> selectByExample(ActRuIntegrationExample example);

    ActRuIntegration selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActRuIntegration record, @Param("example") ActRuIntegrationExample example);

    int updateByExample(@Param("record") ActRuIntegration record, @Param("example") ActRuIntegrationExample example);

    int updateByPrimaryKeySelective(ActRuIntegration record);

    int updateByPrimaryKey(ActRuIntegration record);
}