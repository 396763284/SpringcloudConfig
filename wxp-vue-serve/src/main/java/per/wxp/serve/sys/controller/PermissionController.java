package per.wxp.serve.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wxp.serve.sys.service.PermissionService;
import per.wxp.serve.sys.service.RoleService;
import per.wxp.serve.sys.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-13 21:25
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;



    @PostMapping("/getUserAllInfo")
    public Map<String,Object> getUserAllInfo(@RequestBody Map<String,Object> map){

        logger.info(map.toString());
        List<Map<String,Object>> roleInfos=  permissionService.qryMenusRolesByUcode(map);
        Map<String,Object> userInfo= userService.findUserByParams(map);
        logger.info(userInfo.toString());
        Map<String,Object> result= new HashMap<String,Object>();
        result.put("roles_info",roleInfos);
        result.put("user_info",userInfo);
        logger.info(result.toString());
        return result;
    }





}
