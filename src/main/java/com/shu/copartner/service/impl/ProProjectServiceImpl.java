package com.shu.copartner.service.impl;

import com.shu.copartner.mapper.ProProjectMapper;
import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.service.ProProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/12/20 14:48
 * @description
 */
@Service
public class ProProjectServiceImpl implements ProProjectService {

    @Resource
    private ProProjectMapper proProjectMapper;

    /**
     * 新增项目信息到数据库
     * @param record
     * @return
     */
    @Override
    public int insert(ProProject record) {
        return this.proProjectMapper.insert(record);
    }
}
