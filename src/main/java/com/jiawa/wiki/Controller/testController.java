package com.jiawa.wiki.Controller;

import com.jiawa.wiki.Domain.Test;
import com.jiawa.wiki.Service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class testController {

    @Resource
    TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/hello/post")
    public  String helloPost( String name ) {
        return "Hello, " + name;
    }


    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
