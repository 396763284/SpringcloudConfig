package per.wxp.serve.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wxp.serve.sys.mapper.RptMapper;
import per.wxp.serve.sys.service.RptService;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-26 17:52
 */
@Service
public class RptServiceImpl implements RptService{

    @Autowired
    private RptMapper rptMapper;

    @Override
    public List<Map<String, Object>> getRptHeadList(Map<String, Object> map) {
        return rptMapper.getRptHeadList(map);
    }
}
