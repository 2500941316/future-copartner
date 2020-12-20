package com.shu.copartner.service;

import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 * @Date: 2020/12/20 13:39
 * @Description:
 */
public interface UserNewsService {
    TableModel publisNews(NewsPublishVO newsPublishVO);
}
