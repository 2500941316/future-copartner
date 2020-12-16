package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ActHiAttachment;
import com.shu.copartner.pojo.ActHiAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActHiAttachmentMapper {
    long countByExample(ActHiAttachmentExample example);

    int deleteByExample(ActHiAttachmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActHiAttachment record);

    int insertSelective(ActHiAttachment record);

    List<ActHiAttachment> selectByExample(ActHiAttachmentExample example);

    ActHiAttachment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActHiAttachment record, @Param("example") ActHiAttachmentExample example);

    int updateByExample(@Param("record") ActHiAttachment record, @Param("example") ActHiAttachmentExample example);

    int updateByPrimaryKeySelective(ActHiAttachment record);

    int updateByPrimaryKey(ActHiAttachment record);
}