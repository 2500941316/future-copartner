package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActRuDeadletterJob;
import com.shu.copartner.pojo.ActRuDeadletterJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActRuDeadletterJobMapper {
    long countByExample(ActRuDeadletterJobExample example);

    int deleteByExample(ActRuDeadletterJobExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActRuDeadletterJob record);

    int insertSelective(ActRuDeadletterJob record);

    List<ActRuDeadletterJob> selectByExample(ActRuDeadletterJobExample example);

    ActRuDeadletterJob selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActRuDeadletterJob record, @Param("example") ActRuDeadletterJobExample example);

    int updateByExample(@Param("record") ActRuDeadletterJob record, @Param("example") ActRuDeadletterJobExample example);

    int updateByPrimaryKeySelective(ActRuDeadletterJob record);

    int updateByPrimaryKey(ActRuDeadletterJob record);
}