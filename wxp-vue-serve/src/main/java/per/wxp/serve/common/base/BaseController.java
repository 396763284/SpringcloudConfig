package per.wxp.serve.common.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-04 10:23
 */
@SuppressWarnings("all")
public class BaseController {

    protected Map<String,Object> getRequestBody(Map<String,Object> map){

        Map<String,Object> TcpCont= (Map<String, Object>) map.get(Constant.TCP_CONT);
        Map<String,Object> SvcCont= (Map<String, Object>) map.get(Constant.SVC_CONT);


        // 验证服务是否注册REQUEST_INFO
//        Map<String,Object> REQUEST_INFO=(Map<String, Object>) SvcCont.get(Constant.REQUEST_INFO);

        return SvcCont;
    }

    protected Map<String,Object> getParams(Map<String,Object> map){

        Map<String,Object> dataMap= (Map<String, Object>) map.get(Constant.DATA_INFO);


        // 验证服务是否注册REQUEST_INFO
//        Map<String,Object> REQUEST_INFO=(Map<String, Object>) SvcCont.get(Constant.REQUEST_INFO);

        return dataMap;
    }

    protected Map<String,Object> getRequestInfo(Map<String,Object> map){

        Map<String,Object> RequestInfo= (Map<String, Object>) map.get(Constant.REQUEST_INFO);

        return RequestInfo;
    }

    protected Map<String,Object> createTcpCont(Map<String,Object> map){
        Map<String,Object> TcpCont=new HashMap<String, Object>();
        TcpCont.put("ServiceCode","XXXXXX");
        TcpCont.put("TransactionID","XXXXXX");
        TcpCont.put("SystemCode","XXXXXX");
        TcpCont.put("AcceptTime","XXXXXX");
        TcpCont.put("RespTime","XXXXXX");
        TcpCont.put("RespCode","0");
        TcpCont.put("RespDesc","XXXXXX");
        return TcpCont;
    }


    protected Map<String,Object> getResponeseData(Map<String,Object> acceptMap){

        Map<String,Object> result= new HashMap<String, Object>();
        Map<String,Object> TcpCont=createTcpCont(acceptMap);
        Map<String,Object> SvcCont=new HashMap<String, Object>();

        return result;
    }


    protected Map<String,Object> getResponeseMap(Map<String,Object> acceptMap,boolean bo,Map<String,Object> map){
        Map<String,Object> response =new HashMap<String, Object>();
        Map<String,Object> TcpCont=createTcpCont(acceptMap);
        Map<String,Object> SvcCont=new HashMap<String, Object>();
        Map<String,Object> result=new HashMap<String, Object>();
        response.put("TcpCont",TcpCont);
        if(bo){
            result.put("ResultCode",0);
        }else {
            result.put("ResultCode",1);
        }
        SvcCont.put("Result",result);
        SvcCont.put("Response",map);
        response.put("SvcCont",SvcCont);
        return response;
    }

    protected Map<String,Object> getResponeseList(Map<String,Object> acceptMap,boolean bo,List<Map<String,Object>> list){
        Map<String,Object> response =new HashMap<String, Object>();
        Map<String,Object> TcpCont=createTcpCont(acceptMap);
        Map<String,Object> SvcCont=new HashMap<String, Object>();
        Map<String,Object> result=new HashMap<String, Object>();
        response.put("TcpCont",TcpCont);
        if(bo){
            result.put("ResultCode",0);
        }else {
            result.put("ResultCode",1);
        }
        SvcCont.put("Result",result);
        SvcCont.put("Response",list);
        response.put("SvcCont",SvcCont);
        return response;
    }

}
