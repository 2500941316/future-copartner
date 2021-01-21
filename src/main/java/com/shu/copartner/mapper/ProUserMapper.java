package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProUser;
import com.shu.copartner.pojo.ProUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProUserMapper {
    long countByExample(ProUserExample example);

    int deleteByExample(ProUserExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(ProUser record);

    int insertSelective(ProUser record);

    List<ProUser> selectByExample(ProUserExample example);

    ProUser selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") ProUser record, @Param("example") ProUserExample example);

    int updateByExample(@Param("record") ProUser record, @Param("example") ProUserExample example);

    int updateByPrimaryKeySelective(ProUser record);

    int updateByPrimaryKey(ProUser record);
}