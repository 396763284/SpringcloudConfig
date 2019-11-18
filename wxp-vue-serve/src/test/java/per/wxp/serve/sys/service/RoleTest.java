package per.wxp.serve.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void roleTest(){
        long id= 1;
        List<String> result= roleService.findRolesByUid(id);
        System.out.println(result.toString());
    }

}
