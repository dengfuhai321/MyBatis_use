package com.xiaodeng.demo;

import com.xiaodeng.mapper.TestMapper;
import com.xiaodeng.pojo.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/11 0011
 */
public class Demo {
    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        InputStream configFile = new FileInputStream(
                "D:\\idea\\MyBatis\\MyBatis_use\\src\\main\\java\\com\\xiaodeng\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        return sqlSessionFactory.openSession();

    }

    public static void main(String[] args) throws FileNotFoundException {
        SqlSession sqlSession = getSqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        List<String> strings = new ArrayList<>();
        strings.add("健身");
        strings.add("游泳");
        strings.add("飞天");
        Test test1 = new Test(12,"xiaodeng",strings);
        testMapper.insertTest(test1);
        sqlSession.commit();
        //List<Test> list = getSqlSession().selectList("com.xiaodeng.mapper.TestMapper.selectTest");
        List<Test> list1 = testMapper.selectTest();
        for (Test test:list1) {
            System.out.println(test.toString());

        }
    }
}
