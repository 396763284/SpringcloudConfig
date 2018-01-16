package per.wxp.elasticsearchDemo.web;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import per.wxp.elasticsearchDemo.entity.User;

@RestController
@RequestMapping(value="/users")
public class IndexController {

    @Autowired
    private TransportClient transportClient;







    @ApiOperation(value = "简单创建索引", notes = "curl -XPUT [address]/ ")
    @RequestMapping(value={""}, method=RequestMethod.PUT)
    public ResponseEntity CreateSIndex(){

        IndexResponse result=this.transportClient.prepareIndex()
                    .setSource()
                    .get();
        System.out.println(result.toString());
        return  new ResponseEntity( result.toString(),HttpStatus.OK);
    }
//
//
//    @ApiOperation(value = "带参数的创建索引", notes = "curl -XPUT [address]/blog/ -d")
//    @PutMapping("/{index}/-d")
//    public ResponseEntity CreateIndex(@PathVariable(value="index")String index){
//
//        System.out.println("index="+index);
//        return  new ResponseEntity( HttpStatus.NOT_FOUND);
//    }






//
//    @GetMapping("get/book/novel")
//    @ResponseBody
//    public ResponseEntity get(@RequestParam(name="name") String id){
//
//        if (id.isEmpty()){
//            new ResponseEntity( HttpStatus.NOT_FOUND);
//        }
//
//        GetResponse result= this.transportClient.prepareGet("book","novel",id)
//            .get();
//
//        if(!result.isExists()){
//            new ResponseEntity(result.getSource(), HttpStatus.NOT_FOUND);
//        }
//
//        return  new ResponseEntity(result.getSource(), HttpStatus.OK);
//
//
//    }
//
//
//    @PostMapping("post/book/novel")
//    @ResponseBody
//    public ResponseEntity save(@RequestParam(name = "name") String name,
//                               @RequestParam(name = "sex") String sex,
//                               @RequestParam(name = "age") Integer age,
//                               @RequestParam(name = "introduce") String introduce,
//                               @RequestParam(name = "birthday")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date birthday){
//
//        System.out.println("name="+name);
//        System.out.println("sex="+sex);
//        System.out.println("age="+age);
//        System.out.println("introduce="+introduce);
//        System.out.println("birthday="+birthday);
//
//        try {
//            XContentFactory.jsonBuilder()
//                    .startObject()
//                    .field("title",name)
//                    .endObject();
//
//            IndexResponse result=this.transportClient.prepareIndex()
//                    .setSource()
//                    .get();
//            return  new ResponseEntity(result.getId(), HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}

