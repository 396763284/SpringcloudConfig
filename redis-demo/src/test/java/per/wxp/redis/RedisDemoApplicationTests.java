package per.wxp.redis;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {


	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Test
	public void contextLoads() {

		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

}
