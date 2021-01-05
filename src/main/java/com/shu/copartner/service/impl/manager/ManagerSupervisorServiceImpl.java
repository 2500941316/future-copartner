package com.shu.copartner.service.impl.manager;

import com.shu.copartner.service.ManagerSupervisorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author
 * @date 2021/1/5 13:50
 * @description
 */
@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class ManagerSupervisorServiceImpl implements ManagerSupervisorService {

}
