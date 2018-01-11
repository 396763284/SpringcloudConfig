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

import java.io.IOException;
import java.util.Date;

@RestController
public class IndexController {

    @Autowired
    private TransportClient transportClient;


    @GetMapping("/")
    public String index(){

        return  "index";
    }


    @PutMapping("/")
    public String getAllIndex(){

        return  "index";
    }


    @GetMapping("get/book/novel")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name="name") String id){

        if (id.isEmpty()){
            new ResponseEntity( HttpStatus.NOT_FOUND);
        }

        GetResponse result= this.transportClient.prepareGet("book","novel",id)
            .get();

        if(!result.isExists()){
            new ResponseEntity(result.getSource(), HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(result.getSource(), HttpStatus.OK);
    }


    @PostMapping("post/book/novel")
    @ResponseBody
    public ResponseEntity save(@RequestParam(name = "name") String name,
                               @RequestParam(name = "sex") String sex,
                               @RequestParam(name = "age") Integer age,
                               @RequestParam(name = "introduce") String introduce,
                               @RequestParam(name = "birthday")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date birthday){

        System.out.println("name="+name);
        System.out.println("sex="+sex);
        System.out.println("age="+age);
        System.out.println("introduce="+introduce);
        System.out.println("birthday="+birthday);

        try {
            XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title",name)
                    .endObject();

            IndexResponse result=this.transportClient.prepareIndex()
                    .setSource()
                    .get();
            return  new ResponseEntity(result.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }




    }

}

