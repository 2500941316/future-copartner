package com.shu.copartner.service;

import com.shu.copartner.pojo.ProProject;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author
 * @date 2020/12/20 14:47
 * @description
 */
public interface ProProjectService {
    int insert(ProProject record);

    TableModel projectApply(ProjectApplyVO projectApplyVO, String creater);

}
