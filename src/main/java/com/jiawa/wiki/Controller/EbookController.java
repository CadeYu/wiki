package com.jiawa.wiki.Controller;

import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Req.EbookReq;
import com.jiawa.wiki.Resp.CommonResp;
import com.jiawa.wiki.Resp.EbookResp;
import com.jiawa.wiki.Service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookReq ebookReq){
        List<EbookResp> ebookRespList = ebookService.list(ebookReq);
        CommonResp<List<EbookResp>> CommonResp = new CommonResp<>();

        CommonResp.setContent(ebookRespList);

        return CommonResp;


    }
}
