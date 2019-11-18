package per.wxp.serve.syncdata.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wxp.serve.common.base.BaseController;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.syncdata.service.SyncService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 10:22
 */
@RestController
@RequestMapping("/sync")
public class SyncController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SyncService syncService;

    @PostMapping(value="synctasks")
    public PageResult tasks(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        Map<String ,Object> map= new HashMap<String ,Object>();
        PageResult pageResult= syncService.getSyncTasks(params);
        return pageResult;
    }

    /**
     * 数据库配置列表
     * @param params
     * @return
     */
//    @ApiOperation(value = "数据库码表", notes = "配置数据库的信息 ")
//    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
//    @PostMapping(value = "syncDataSources")
//    public List<Map<String,Object>> getsyncDataSourceList(@RequestBody Map<String, Object> params){
//        logger.info(params.toString());
//        List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
//        mapList= syncService.getSyncDataSources(params);
//        return mapList;
//    }

    @ApiOperation(value = "数据库配置列表", notes = "数据库配置列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/syncDataSources")
    public Map<String,Object> getSyncDataSources(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        List<Map<String,Object>> list = syncService.getSyncDataSources(SvcCont);
        return this.getResponeseList(SvcCont,true,list);
    }


    @ApiOperation(value = "添加数据库配置", notes = "添加数据库配置 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/insertSyncDataSources")
    public Map<String,Object> insertSyncDataSources(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        logger.info(SvcCont.toString());
        int i = syncService.insertSyncDataSources(SvcCont);
        map.put("state",i);
        return this.getResponeseMap(SvcCont,true,map);
    }

    @ApiOperation(value = "修改数据库配置", notes = "修改数据库配置 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/updateSyncDataSources")
    public Map<String,Object> updateSyncDataSources(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        int i = syncService.updateSyncDataSources(SvcCont);
        map.put("state",i);
        return this.getResponeseMap(SvcCont,true,map);
    }

    @ApiOperation(value = "删除数据库配置", notes = "删除数据库配置 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/delSyncDataSources")
    public Map<String,Object> delSyncDataSources(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        int i = syncService.delSyncDataSources(SvcCont);
        map.put("state",i);
        return this.getResponeseMap(SvcCont,true,map);
    }






    @PostMapping(value="syncCols")
    public List<Map<String,Object>> getTaskCols(@RequestBody Map<String, Object> params){
        logger.info(params.toString());
        List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
        mapList= syncService.getSyncDataSources(params);
        return mapList;
    }

    @ApiOperation(value = "测测试", notes = "测测试")
    @PostMapping(value="synctest")
    public Map<String, Object> getMaterial(@RequestParam("mid") Integer mid) {
      logger.info("mid:{}",mid);
       Map<String, Object> map = new HashMap<String, Object>();
       map.put("wxp","aaaa");
        return map;
    }

}
