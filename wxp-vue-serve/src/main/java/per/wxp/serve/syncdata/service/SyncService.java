package per.wxp.serve.syncdata.service;

import per.wxp.serve.common.model.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 11:01
 */
public interface SyncService {

    PageResult getSyncTasks(Map<String ,Object> map);

    int  updateSyncTask(Map<String ,Object> map);

    int  insertSyncTask(Map<String ,Object> map);

    /*---------数据库配置 ：增删查改方法-----------*/
    List<Map<String, Object>> getSyncDataSources(Map<String ,Object> map);

    int  insertSyncDataSources(Map<String ,Object> map);

    int  updateSyncDataSources(Map<String ,Object> map);

    int  delSyncDataSources(Map<String ,Object> map);

    /*---------同步任务表字段 ：增删查改方法-----------*/
    List<Map<String, Object>> getSyncCols(Map<String ,Object> map);

    int  insertSyncCols(Map<String ,Object> map);

    int  updateSyncCols(Map<String ,Object> map);

    int  deleteSyncCols(Map<String ,Object> map);

}
