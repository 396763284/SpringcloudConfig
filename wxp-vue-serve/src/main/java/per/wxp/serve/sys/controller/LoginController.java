package per.wxp.serve.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.wxp.serve.common.base.BaseController;
import per.wxp.serve.common.model.ResultMsg;
import per.wxp.serve.common.utils.ResultUtil;
import per.wxp.serve.sys.service.PermissionService;
import per.wxp.serve.sys.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-21 11:04
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController{

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    @PostMapping("/getUserInfo")
    public ResultMsg getUserInfo(@RequestBody Map<String,Object> map){
        logger.info(map.toString());
        Map<String, Object> permsInfo=  permissionService.qryPermissionsByUcode(map);
        Map<String,Object> userInfo= userService.findUserByParams(map);
        logger.info(userInfo.toString());
        Map<String,Object> result= new HashMap<String,Object>();
        result.put("perms_info",permsInfo);
        result.put("user_info",userInfo);
        logger.info(result.toString());
        return ResultUtil.success(result);
    }

}
