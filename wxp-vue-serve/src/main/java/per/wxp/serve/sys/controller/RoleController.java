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
import per.wxp.serve.common.model.ResultMsg;
import per.wxp.serve.common.utils.ResultUtil;
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
    @PostMapping("/rolePage")
    public ResultMsg getRolePage (@RequestBody Map<String, Object> params) {
        Map<String,Object> queryMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        PageResult pages =roleService.getRolePage(queryMap);
        map.put("pages",pages);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/roleList")
    public ResultMsg getRoleList(@RequestBody Map<String, Object> params) {
        Map<String,Object> queryMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        List<Map<String,Object>> list = roleService.getRoleList(queryMap);
        map.put("list",list);
        return ResultUtil.success(map);
    }


    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/addRole")
    public ResultMsg addRole(@RequestBody Map<String, Object> params) {
        Map<String,Object> dataMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        roleService.insertRole(dataMap);
        return  ResultUtil.success(map);
    }

    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/updateRole")
    public ResultMsg updateRole(@RequestBody Map<String, Object> params) {
        Map<String,Object> dataMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        roleService.updateRole(dataMap);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/getRolePermRel")
    public ResultMsg getRolePermRel(@RequestBody Map<String, Object> params) {
        Map<String,Object> queryMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        List<Map<String,Object>> list = roleService.getPermsByRoleId(queryMap);
        map.put("list",list);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "角色列表", notes = "角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/updateRolePermissions")
    public ResultMsg updateRolePermissions(@RequestBody Map<String, Object> params) {
        Map<String,Object> dataMap = this.getParams(params);
        Map<String,Object> map =new HashMap<String,Object>();
        roleService.updateRolePermissions(dataMap);
        return ResultUtil.success(map);
    }

}
