package com.shu.copartner.service;

import com.shu.copartner.pojo.request.NewsManagerOperationVO;
import com.shu.copartner.pojo.request.NewsPublishVO;
import com.shu.copartner.utils.returnobj.TableModel;

/**
 * @author cxy
 * @Date: 2020/12/21 15:18
 * @Description:
 */
public interface ManagerNewsService {
    TableModel searchNewsApplication(int page);

    TableModel operateNew(NewsManagerOperationVO newsManagerOperationVO);

    TableModel publisSHUNews(NewsPublishVO newsPublishVO);

    TableModel searchAllNews(int page);

    TableModel updateNewsAudit(String newsId,String isaudit);
}
