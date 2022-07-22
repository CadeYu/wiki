package com.jiawa.wiki.Controller;

import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    EbookService ebookService;


    @GetMapping("/list")
    public List<Ebook> list(){
        return ebookService.list();
    }
}
