package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProLeassonVedio;
import com.shu.copartner.pojo.ProLeassonVedioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLeassonVedioMapper {
    long countByExample(ProLeassonVedioExample example);

    int deleteByExample(ProLeassonVedioExample example);

    int deleteByPrimaryKey(Long courseId);

    int insert(ProLeassonVedio record);

    int insertSelective(ProLeassonVedio record);

    List<ProLeassonVedio> selectByExample(ProLeassonVedioExample example);

    ProLeassonVedio selectByPrimaryKey(Long courseId);

    int updateByExampleSelective(@Param("record") ProLeassonVedio record, @Param("example") ProLeassonVedioExample example);

    int updateByExample(@Param("record") ProLeassonVedio record, @Param("example") ProLeassonVedioExample example);

    int updateByPrimaryKeySelective(ProLeassonVedio record);

    int updateByPrimaryKey(ProLeassonVedio record);
}