package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProVerify;
import com.shu.copartner.pojo.ProVerifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProVerifyMapper {
    long countByExample(ProVerifyExample example);

    int deleteByExample(ProVerifyExample example);

    int deleteByPrimaryKey(String phone);

    int insert(ProVerify record);

    int insertSelective(ProVerify record);

    List<ProVerify> selectByExample(ProVerifyExample example);

    ProVerify selectByPrimaryKey(String phone);

    int updateByExampleSelective(@Param("record") ProVerify record, @Param("example") ProVerifyExample example);

    int updateByExample(@Param("record") ProVerify record, @Param("example") ProVerifyExample example);

    int updateByPrimaryKeySelective(ProVerify record);

    int updateByPrimaryKey(ProVerify record);
}