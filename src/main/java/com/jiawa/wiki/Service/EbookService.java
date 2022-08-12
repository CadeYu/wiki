package com.jiawa.wiki.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Domain.EbookExample;
import com.jiawa.wiki.Mapper.EbookMapper;
import com.jiawa.wiki.Req.EbookQueryReq;
import com.jiawa.wiki.Req.EbookSaveReq;
import com.jiawa.wiki.Resp.EbookQueryResp;
import com.jiawa.wiki.Resp.PageResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookQueryResp> list(EbookQueryReq ebookReq){


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

        List<EbookQueryResp> reqList = new ArrayList<>();

        for(Ebook ebook : ebookList){
            EbookQueryResp ebookResp = new EbookQueryResp();

            BeanUtils.copyProperties(ebook, ebookResp);

            reqList.add(ebookResp);


        }

        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(page.getTotal());
        pageResp.setList(reqList);

        return pageResp;

    }

    //保存书籍
    public void save(EbookSaveReq ebookReq) {
       Ebook ebook = new Ebook();
       BeanUtils.copyProperties(ebookReq,ebook);
        //判断是新增书籍还是更新书籍
        if(!ObjectUtils.isEmpty(ebookReq.getId())){
            //pk不为空说明是更新
            ebookMapper.updateByPrimaryKey(ebook);
        }else {
            ebookMapper.insert(ebook);
        }




    }
}
