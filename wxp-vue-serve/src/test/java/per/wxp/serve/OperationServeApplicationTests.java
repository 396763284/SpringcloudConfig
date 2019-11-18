package per.wxp.serve;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.wxp.serve.sys.mapper.RptMapper;
import per.wxp.serve.sys.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServeApplicationTests {


	@Autowired
	private RptMapper rptMapper;

	@Test
	public void contextLoads() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rpt_code","test_user");
		List<Map<String,Object>> list= rptMapper.getRptHeadList(map);

		for (Map<String, Object> smap : list) {
			System.out.println(smap.toString());
		}
	}

}
