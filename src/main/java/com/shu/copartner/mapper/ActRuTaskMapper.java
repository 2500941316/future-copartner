package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActRuTask;
import com.shu.copartner.pojo.ActRuTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
  * @author cxy
  * @date 2020/12/7 17:12
  * @Description 任务表mapper
  * @return
  */
public interface ActRuTaskMapper {
    long countByExample(ActRuTaskExample example);

    int deleteByExample(ActRuTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActRuTask record);

    int insertSelective(ActRuTask record);

    List<ActRuTask> selectByExample(ActRuTaskExample example);

    ActRuTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActRuTask record, @Param("example") ActRuTaskExample example);

    int updateByExample(@Param("record") ActRuTask record, @Param("example") ActRuTaskExample example);

    int updateByPrimaryKeySelective(ActRuTask record);

    int updateByPrimaryKey(ActRuTask record);
}