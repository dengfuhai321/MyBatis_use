package com.xiaodeng.mapper;


import com.xiaodeng.pojo.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {

   List<Test> selectTest();

   void insertTest(@Param("test") Test test);
}