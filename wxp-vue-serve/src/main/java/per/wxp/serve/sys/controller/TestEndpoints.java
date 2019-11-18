package per.wxp.serve.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestEndpoints {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("/product/{id}")
    public String getProduce(@PathVariable String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product="+id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order="+id;
    }
}
