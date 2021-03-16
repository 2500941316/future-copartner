package com.shu.copartner.mapper;

import com.shu.copartner.pojo.ProCarousel;
import com.shu.copartner.pojo.ProCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProCarouselMapper {
    long countByExample(ProCarouselExample example);

    int deleteByExample(ProCarouselExample example);

    int deleteByPrimaryKey(Long carouselId);

    int insert(ProCarousel record);

    int insertSelective(ProCarousel record);

    List<ProCarousel> selectByExample(ProCarouselExample example);

    ProCarousel selectByPrimaryKey(Long carouselId);

    int updateByExampleSelective(@Param("record") ProCarousel record, @Param("example") ProCarouselExample example);

    int updateByExample(@Param("record") ProCarousel record, @Param("example") ProCarouselExample example);

    int updateByPrimaryKeySelective(ProCarousel record);

    int updateByPrimaryKey(ProCarousel record);
}