package per.wxp.wxpredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.wxp.wxpredis.component.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxpRedisApplicationTests {

	@Autowired
	RedisService redisService;
	@Test
	public void contextLoads() {

	}

	@Test
	public void test1()  {
		redisService.setValue("key","hello");
	}


	@Test
	public void test2()  {
		System.out.println("get key value:"+ redisService.getValue("key"));
	}

}
