package com.jiawa.wiki.Controller;

import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Resp.CommonResp;
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
    public CommonResp list(){
        List<Ebook> list = ebookService.list();

        CommonResp<List<Ebook>> resp = new CommonResp<List<Ebook>>();

        resp.setContent(list);

        return resp;
    }
}
