package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProApplication;
import com.shu.copartner.pojo.ProApplicationExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProApplicationMapper {
    long countByExample(ProApplicationExample example);

    int deleteByExample(ProApplicationExample example);

    int deleteByPrimaryKey(Long applicationId);

    int insert(ProApplication record);

    int insertSelective(ProApplication record);

    List<ProApplication> selectByExample(ProApplicationExample example);

    /**
     * 根据状态值查询待审批项目
     * @param tokens
     * @return
     */
    List<ProApplication> selectAuditInfo(@Param("tokens") String[] tokens);

    ProApplication selectByPrimaryKey(Long applicationId);

    int updateByExampleSelective(@Param("record") ProApplication record, @Param("example") ProApplicationExample example);

    int updateByExample(@Param("record") ProApplication record, @Param("example") ProApplicationExample example);

    int updateByPrimaryKeySelective(ProApplication record);

    int updateByPrimaryKey(ProApplication record);
}