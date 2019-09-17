package com.xiaodeng.my_MyBatis_v1;

import com.xiaodeng.pojo.Test;

/**
 * @author dengfuhai
 * @description用来测试自己写的MyBatis
 * @date 2019/9/16 0016
 */
public class Entity {
    public static void main(String[] args) {
        FHSqlSession sqlSession=new FHSqlSession(new FHConfiguration(), new FHSimpleExecutor());
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        Test test = mapper.selectById(1);
        System.out.println(test.toString());
    }

}
