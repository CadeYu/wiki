package com.jiawa.wiki.Mapper;

import com.jiawa.wiki.Domain.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<Test> list();

}
