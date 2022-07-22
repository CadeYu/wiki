package com.jiawa.wiki.Service;

import com.jiawa.wiki.Domain.Ebook;
import com.jiawa.wiki.Mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }

}
