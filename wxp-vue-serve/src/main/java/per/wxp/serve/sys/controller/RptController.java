package per.wxp.serve.sys.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wxp.serve.common.base.BaseController;
import per.wxp.serve.sys.service.RptService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 点岩喵
 * @date: 2019-06-26 17:41
 */
@RestController
@RequestMapping("/rpt")
public class RptController extends BaseController{

    @Autowired
    private RptService rptService;

    @ApiOperation(value = "用户角色列表", notes = "用户角色列表 ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @PostMapping("/head")
    public Map<String,Object> getRptHeadList(@RequestBody Map<String, Object> params) {
        Map<String,Object> SvcCont = this.getRequestBody(params);
        Map<String,Object> map =new HashMap<String,Object>();
        Map<String,Object> map1 =new HashMap<String,Object>();
        map1.put("rpt_code","test_user");
        List<Map<String,Object>> list = rptService.getRptHeadList(map1);
        map.put("list",list);
        return this.getResponeseMap(SvcCont,true,map);
    }


    @ApiOperation(value = "download", notes = "download ")
    @ApiImplicitParam(name = "params", value = "xxx", required = true, dataType = "Map")
    @GetMapping("/download")
    public void exportSucExcel( HttpServletResponse response){
        String fileName="yizhifu50.png";
        response.setContentType("application/force-download");
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        response.setCharacterEncoding("utf-8");
        // 读取要下载的文件，保存到文件输入流
        String path= "D:\\tmp\\yizhifu50.png";
        File file = new File(path);
        if (file.exists()) {

            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;

            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(bis!=null){
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


}
