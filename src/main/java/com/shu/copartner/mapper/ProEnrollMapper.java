package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProEnroll;
import com.shu.copartner.pojo.ProEnrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProEnrollMapper {
    long countByExample(ProEnrollExample example);

    int deleteByExample(ProEnrollExample example);

    int deleteByPrimaryKey(Long enrollId);

    int insert(ProEnroll record);

    int insertSelective(ProEnroll record);

    List<ProEnroll> selectByExample(ProEnrollExample example);

    /**
     * 查询该用户报名的所有活动
     * @param personId
     * @return
     */
    List<ProEnroll> selectEnrollByPersonId(@Param("personId") Long personId);

    /**
     * 查询该用户是否报名一个特定的活动
     * @param personId
     * @param activityId
     * @return
     */
    ProEnroll selectEnrollByPersonActivityId(@Param("personId") Long personId,@Param("activityId") Long activityId);

    /**
     * 查询该活动全部的报名人员
     * @param activityId
     * @return
     */
    List<ProEnroll> selectEnrollByActivityId(@Param("activityId") Long activityId);

    ProEnroll selectByPrimaryKey(Long enrollId);

    int updateByExampleSelective(@Param("record") ProEnroll record, @Param("example") ProEnrollExample example);

    int updateByExample(@Param("record") ProEnroll record, @Param("example") ProEnrollExample example);

    int updateByPrimaryKeySelective(ProEnroll record);

    int updateByPrimaryKey(ProEnroll record);
}