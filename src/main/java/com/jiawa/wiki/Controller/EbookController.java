package com.jiawa.wiki.Controller;

import com.jiawa.wiki.Req.EbookQueryReq;
import com.jiawa.wiki.Req.EbookSaveReq;
import com.jiawa.wiki.Resp.CommonResp;
import com.jiawa.wiki.Resp.EbookQueryResp;
import com.jiawa.wiki.Resp.PageResp;
import com.jiawa.wiki.Service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list( EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }


    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq ebookReq){
        //保存成功之后前端刷新列表,所以不需要返回值
        CommonResp resp = new CommonResp<>();

        ebookService.save(ebookReq);

        return resp;


    }
}
