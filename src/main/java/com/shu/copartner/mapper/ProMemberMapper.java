package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProMember;
import com.shu.copartner.pojo.ProMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProMemberMapper {
    long countByExample(ProMemberExample example);

    int deleteByExample(ProMemberExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(ProMember record);

    int insertSelective(ProMember record);

    List<ProMember> selectByExample(ProMemberExample example);

    ProMember selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") ProMember record, @Param("example") ProMemberExample example);

    int updateByExample(@Param("record") ProMember record, @Param("example") ProMemberExample example);

    int updateByPrimaryKeySelective(ProMember record);

    int updateByPrimaryKey(ProMember record);
}