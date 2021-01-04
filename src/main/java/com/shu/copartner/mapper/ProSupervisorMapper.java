package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProSupervisor;
import com.shu.copartner.pojo.ProSupervisorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProSupervisorMapper {
    long countByExample(ProSupervisorExample example);

    int deleteByExample(ProSupervisorExample example);

    int deleteByPrimaryKey(Long supervisorId);

    int insert(ProSupervisor record);

    int insertSelective(ProSupervisor record);

    List<ProSupervisor> selectByExample(ProSupervisorExample example);

    List<ProSupervisor> selectAllSupervisor();

    ProSupervisor selectByPrimaryKey(Long supervisorId);

    int updateByExampleSelective(@Param("record") ProSupervisor record, @Param("example") ProSupervisorExample example);

    int updateByExample(@Param("record") ProSupervisor record, @Param("example") ProSupervisorExample example);

    int updateByPrimaryKeySelective(ProSupervisor record);

    int updateByPrimaryKey(ProSupervisor record);
}