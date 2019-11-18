package per.wxp.serve.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.wxp.serve.syncdata.mapper.SyncMapper;
import per.wxp.serve.syncdata.service.SyncService;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-06 10:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SyncTest {

    @Autowired
    private SyncService syncService;


    @Autowired
    private SyncMapper  syncMapper;

    @Test
    public void syncTest(){

        Map<String,Object> map= new HashMap<String,Object>();
        List<Map<String,Object>> list=  syncMapper.getSyncTasks(map);
        System.out.println(list.size());

    }



}
