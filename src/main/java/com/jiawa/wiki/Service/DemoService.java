package com.jiawa.wiki.Service;

import com.jiawa.wiki.Domain.Demo;
import com.jiawa.wiki.Mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list(){
        return demoMapper.selectByExample(null);

    }

}
