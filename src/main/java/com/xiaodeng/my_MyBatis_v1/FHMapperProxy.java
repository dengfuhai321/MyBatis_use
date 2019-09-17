package com.xiaodeng.my_MyBatis_v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/16 0016
 */
//这个接口是拦截器，再加上反射形成动态代理，在调用具体方法之前调用invoke方法来处理。
public class FHMapperProxy implements InvocationHandler {
    private FHSqlSession sqlSession;

    public FHMapperProxy(FHSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //getDeclaringClass()返回该方法对象表示的方法所在类的Class对象

        if(method.getDeclaringClass().getName().equals(FHConfiguration.TestMapperXml.namespace)){
           String sql= FHConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
           return sqlSession.selectOne(sql,String.valueOf(args[0]));//传入sql和参数

        }

        return method.invoke(this,args);//this是指调用调用该方法的实例对象
    }
}
