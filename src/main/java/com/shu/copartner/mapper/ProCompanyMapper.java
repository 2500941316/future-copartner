package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProCompany;
import com.shu.copartner.pojo.ProCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProCompanyMapper {
    long countByExample(ProCompanyExample example);

    int deleteByExample(ProCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProCompany record);

    int insertSelective(ProCompany record);

    List<ProCompany> selectByExample(ProCompanyExample example);

    ProCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProCompany record, @Param("example") ProCompanyExample example);

    int updateByExample(@Param("record") ProCompany record, @Param("example") ProCompanyExample example);

    int updateByPrimaryKeySelective(ProCompany record);

    int updateByPrimaryKey(ProCompany record);
}