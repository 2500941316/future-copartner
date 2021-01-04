package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProSupervisor;
import com.shu.copartner.pojo.ProSupervisorExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProSupervisorMapper {
    long countByExample(ProSupervisorExample example);

    int deleteByExample(ProSupervisorExample example);

    int deleteByPrimaryKey(Long supervisorId);

    int insert(ProSupervisor record);

    int insertSelective(ProSupervisor record);

    List<ProSupervisor> selectByExample(ProSupervisorExample example);

    /**
     * 查询导师列表
     * @return
     */
    List<ProSupervisor> selectAllSupervisor();

    /**
     * 根据名称查询导师
     * @param supervisorName
     * @return
     */
    List<ProSupervisor> selectSupervisorByName(@Param("supervisorName") String supervisorName);

    /**
     * 查询导师参加的项目
     * @param supervisor_id
     * @return
     */
    List<ProSupervisor> selectSupervisorProject(@Param("supervisorId") Long supervisor_id);

    /**
     * 查询导师代表性成就
     * @param supervisor_id
     * @return
     */
    List<ProSupervisor> selectSupervisorAchievement(@Param("supervisorId") Long supervisor_id);

    ProSupervisor selectByPrimaryKey(Long supervisorId);

    int updateByExampleSelective(@Param("record") ProSupervisor record, @Param("example") ProSupervisorExample example);

    int updateByExample(@Param("record") ProSupervisor record, @Param("example") ProSupervisorExample example);

    int updateByPrimaryKeySelective(ProSupervisor record);

    int updateByPrimaryKey(ProSupervisor record);
}