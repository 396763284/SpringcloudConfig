package per.wxp.redis.web;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wxp.redis.entity.User;
import per.wxp.redis.service.UserService;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @ApiOperation(value="获取用户", notes="")
    @GetMapping("/getUser")
    public User selectByPrimaryKey(@RequestParam("id")  Integer id){
        return userService.selectByPrimaryKey(id);
    }


    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        userService.insert(user);
        return "success";
    }

    @ApiOperation(value="更新用户", notes="根据User对象更新用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/update", method= RequestMethod.POST)
    public String update(@RequestBody User user) {
        userService.updateByPrimaryKey(user);
        return "success";
    }


    @ApiOperation(value="删除用户", notes="")
    @GetMapping("/delete")
    public Integer deleteByPrimaryKey(@RequestParam("id")  Integer id){
        return userService.deleteByPrimaryKey(id);
    }



}
