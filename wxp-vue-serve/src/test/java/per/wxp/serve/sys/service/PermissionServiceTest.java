package per.wxp.serve.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-10 19:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public  void qryMenusRolesByUcode(){
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("user_code","wxp");

        List<Map<String, Object>> list=permissionService.qryMenusRolesByUcode(params);

        System.out.println(list.size());
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }
    }





}
