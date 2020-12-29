package com.shu.copartner.service;

import com.shu.copartner.utils.returnobj.TableModel;

public interface UserLeassonService {

    TableModel getLeassonInfo();

    TableModel getcourseInfo_vedio(Long courseId);
}
