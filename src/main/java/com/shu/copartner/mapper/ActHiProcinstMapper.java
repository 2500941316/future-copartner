package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActHiProcinst;
import com.shu.copartner.pojo.ActHiProcinstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActHiProcinstMapper {
    long countByExample(ActHiProcinstExample example);

    int deleteByExample(ActHiProcinstExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActHiProcinst record);

    int insertSelective(ActHiProcinst record);

    List<ActHiProcinst> selectByExample(ActHiProcinstExample example);

    ActHiProcinst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActHiProcinst record, @Param("example") ActHiProcinstExample example);

    int updateByExample(@Param("record") ActHiProcinst record, @Param("example") ActHiProcinstExample example);

    int updateByPrimaryKeySelective(ActHiProcinst record);

    int updateByPrimaryKey(ActHiProcinst record);
}