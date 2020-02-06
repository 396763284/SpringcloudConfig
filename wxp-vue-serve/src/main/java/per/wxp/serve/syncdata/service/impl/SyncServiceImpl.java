package per.wxp.serve.syncdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.syncdata.mapper.SyncMapper;
import per.wxp.serve.syncdata.service.SyncService;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 11:01
 */
@Service
public class SyncServiceImpl implements SyncService {

    @Autowired
    private SyncMapper mapper;

    @Override
    @Transactional
    public PageResult getSyncTasks(Map<String, Object> map) {

        PageResult result= new PageResult();
        result.setData(mapper.getSyncTasks(map));
        result.setTotal(mapper.getSyncTasksTotal(map));
        return result;
    }

    @Override
    public int updateSyncTask(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int insertSyncTask(Map<String, Object> map) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> getSyncDataSources(Map<String, Object> map) {
        return mapper.getSyncDataSources(map);
    }

    @Override
    public int insertSyncDataSources(Map<String, Object> map) {
        return mapper.insertSyncDataSources(map);
    }

    @Override
    public int updateSyncDataSources(Map<String, Object> map) {
        return mapper.updateSyncDataSources(map);
    }

    @Override
    public int delSyncDataSources(Map<String, Object> map) {
        return mapper.delSyncDataSources(map);
    }

    @Override
    public List<Map<String, Object>> getSyncCols(Map<String, Object> map) {
        return null;
    }

    @Override
    public int insertSyncCols(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int updateSyncCols(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int deleteSyncCols(Map<String, Object> map) {
        return 0;
    }


}
