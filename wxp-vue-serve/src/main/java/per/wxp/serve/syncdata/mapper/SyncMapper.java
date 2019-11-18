package per.wxp.serve.syncdata.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 11:00
 */
@Mapper
public interface SyncMapper {

    /*---------同步任务 ：增删查改方法-----------*/
    List<Map<String, Object>> getSyncTasks(Map<String ,Object> map);

    int getSyncTasksTotal(Map<String ,Object> map);

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
