package per.wxp.serve.sys.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RptMapper mapper;

    @Test
    public void insertUser(){
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("user_name","aaa");
        map.put("user_code","aaa");
        map.put("password","test");

       int id= userMapper.insertUser(map);
        System.out.println(map.toString());
    }

    @Test
    public void test(){
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("rpt_code","test_user");

        List<Map<String,Object>> list=mapper.getRptHeadList(map);
        for (Map<String, Object> map1 : list) {
            System.out.println(map1.toString());
        }
    }


}
