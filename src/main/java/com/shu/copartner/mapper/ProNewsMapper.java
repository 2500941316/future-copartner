package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProNews;
import com.shu.copartner.pojo.ProNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProNewsMapper {
    long countByExample(ProNewsExample example);

    int deleteByExample(ProNewsExample example);

    int deleteByPrimaryKey(Long newsId);

    int insert(ProNews record);

    int insertSelective(ProNews record);

    List<ProNews> selectByExample(ProNewsExample example);

    ProNews selectByPrimaryKey(Long newsId);

    int updateByExampleSelective(@Param("record") ProNews record, @Param("example") ProNewsExample example);

    int updateByExample(@Param("record") ProNews record, @Param("example") ProNewsExample example);

    int updateByPrimaryKeySelective(ProNews record);

    int updateByPrimaryKey(ProNews record);
}