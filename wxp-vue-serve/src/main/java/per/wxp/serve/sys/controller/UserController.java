package per.wxp.serve.sys.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wxp.serve.common.base.BaseController;
import per.wxp.serve.common.model.PageResult;
import per.wxp.serve.common.model.ResultMsg;
import per.wxp.serve.common.utils.ResultUtil;
import per.wxp.serve.sys.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:用户管理
 * @author: 点岩喵
 * @date: 2019-05-07 18:36
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    private Logger logger= LoggerFactory.getLogger(this.getClass());



    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表", notes = "用户列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/userList")
    public ResultMsg getUserList(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        PageResult pages =userService.getUserList(params);
        map.put("pages",pages);
        return ResultUtil.success(map);
    }

    @ApiOperation(value = "用户角色列表", notes = "用户角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/userRoleList")
    public ResultMsg getUserRoleList(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        List<Map<String,Object>> list = userService.UserRoleList(SvcCont);

        map.put("list",list);
        return ResultUtil.success(map);
    }


    @ApiOperation(value = "添加用户", notes = "添加用户 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/insertUser")
    public Map<String,Object> insertUser(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        logger.info(SvcCont.toString());
        Map<String,Object> RequestInfo = this.getRequestInfo(SvcCont);
        Map<String,Object> map =new HashMap<String,Object>();
        int i =userService.insertUser(RequestInfo);
        map.put("state",i);
        return this.getResponeseMap(SvcCont,true,map);
    }

    @ApiOperation(value = "修改用户", notes = "修改用户 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/updateUser")
    public Map<String,Object> updateUser(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        return this.getResponeseData(map);
    }

    @ApiOperation(value = "冻结用户", notes = "冻结用户 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/freezeUser")
    public Map<String,Object> freezeUser(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        return this.getResponeseData(map);
    }


    @ApiOperation(value = "修改用户角色", notes = "修改用户角色 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/updateUserRoles")
    public Map<String,Object> updateUserRoles(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        return this.getResponeseData(map);
    }

    @ApiOperation(value = "新增用户角色", notes = "添加用户 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/insertUserRoles")
    public Map<String,Object> insertUserRoles(@RequestBody Map<String, Object> params) {

        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        return this.getResponeseData(map);
    }

}
