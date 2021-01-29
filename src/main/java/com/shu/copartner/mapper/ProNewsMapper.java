package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsExample;
import com.shu.copartner.pojo.ProNewsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProNewsMapper {
    long countByExample(ProNewsExample example);

    int deleteByExample(ProNewsExample example);

    int deleteByPrimaryKey(Long newsId);

    int insert(ProNewsWithBLOBs record);

    int insertSelective(ProNewsWithBLOBs record);

    List<ProNewsWithBLOBs> selectByExampleWithBLOBs(ProNewsExample example);

    List<ProNews> selectByExample(ProNewsExample example);

    ProNewsWithBLOBs selectByPrimaryKey(Long newsId);

    int updateByExampleSelective(@Param("record") ProNewsWithBLOBs record, @Param("example") ProNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") ProNewsWithBLOBs record, @Param("example") ProNewsExample example);

    int updateByExample(@Param("record") ProNews record, @Param("example") ProNewsExample example);

    int updateByPrimaryKeySelective(ProNewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProNewsWithBLOBs record);

    int updateByPrimaryKey(ProNews record);
}