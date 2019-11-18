package per.wxp.serve.sys.service;

import java.util.List;
import java.util.Map; /**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-26 17:52
 */
public interface RptService {
    List<Map<String,Object>> getRptHeadList(Map<String, Object> svcCont);
}
