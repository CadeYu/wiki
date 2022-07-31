package com.jiawa.wiki.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Domain.EbookExample;
import com.jiawa.wiki.Mapper.EbookMapper;
import com.jiawa.wiki.Req.EbookReq;
import com.jiawa.wiki.Resp.EbookResp;
import com.jiawa.wiki.Resp.PageResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.management.relation.InvalidRelationTypeException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookReq ebookReq){


        //模糊查询
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
            if (!ObjectUtils.isEmpty(ebookReq.getName()))   {
                //传进书本的名字才模糊查询
                criteria.andNameLike("%" + ebookReq.getName() + "%");
            }


            //分页
        Page<Object> page = PageHelper.startPage(ebookReq.getPage(), ebookReq.getSize());


        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> reqList = new ArrayList<>();

        for(Ebook ebook : ebookList){
            EbookResp ebookResp = new EbookResp();

            BeanUtils.copyProperties(ebook, ebookResp);

            reqList.add(ebookResp);


        }

        PageResp<EbookResp> pageResp = new PageResp<>();
        pageResp.setTotal(page.getTotal());
        pageResp.setList(reqList);

        return pageResp;

    }

}
