package com.jiawa.wiki.Service;

import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Domain.EbookExample;
import com.jiawa.wiki.Mapper.EbookMapper;
import com.jiawa.wiki.Req.EbookReq;
import com.jiawa.wiki.Resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.InvalidRelationTypeException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq ebookReq){
        //模糊查询
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

          criteria.andNameLike("%" + ebookReq.getName() + "%");

        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> reqList = new ArrayList<>();

        for(Ebook ebook : ebookList){
            EbookResp ebookResp = new EbookResp();

            BeanUtils.copyProperties(ebook, ebookResp);

            reqList.add(ebookResp);


        }

        return reqList;

    }

}
