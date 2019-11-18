package per.wxp.serve.sys.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wxp.serve.common.base.BaseController;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.sys.service.RoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:角色角色相关
 * @author: 点岩喵
 * @date: 2019-06-21 11:06
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "角色分页数据", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/roleList")
    public Map<String,Object> getUserList(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        List<Map<String,Object>> list= roleService.getRoleList(params);
        map.put("list",list);
        return this.getResponeseMap(SvcCont,true,map);
    }

    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/rolePage")
    public Map<String,Object> getRolePage(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        PageResult pages =roleService.getRolePage(params);
        map.put("pages",pages);
        return this.getResponeseMap(SvcCont,true,map);
    }





}
