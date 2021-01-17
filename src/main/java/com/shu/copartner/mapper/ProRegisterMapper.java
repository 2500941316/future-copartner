package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProRegister;
import com.shu.copartner.pojo.ProRegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProRegisterMapper {
    long countByExample(ProRegisterExample example);

    int deleteByExample(ProRegisterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProRegister record);

    int insertSelective(ProRegister record);

    List<ProRegister> selectByExample(ProRegisterExample example);

    ProRegister selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProRegister record, @Param("example") ProRegisterExample example);

    int updateByExample(@Param("record") ProRegister record, @Param("example") ProRegisterExample example);

    int updateByPrimaryKeySelective(ProRegister record);

    int updateByPrimaryKey(ProRegister record);
}