package com.xiaodeng.my_MyBatis_v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/12 0012
 */

public class FHConfiguration {

    /**
     * 功能描述：JDK的动态代理实现的原理其实是动态生成Proxy的.java文件，
     * 再动态编译.java文件成为对应的.class文件，再通过ClassLoader
     * 将字节码对象加载到内存中从而实现动态的效果。
     * @param:
     * @return:
     * @author:
     * @date:
     */
    public <T> T getMapper(Class<T> clazz, FHSqlSession fhSqlSession) {
        //普通方法内部的this是指调用该方法的对象，
        //但是构造方法的this不同，
        // 产生新对象并且放在内存里是虚拟机的工作，构造方法的功能其实是初始化这个新对象。就是说构造方法之前该对象已经存在。
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                        new Class[]{clazz},
                        new FHMapperProxy(fhSqlSession)
        );
    }
    /*
     *用来代替解析mapepr.xml 文件
     */
    static class TestMapperXml{

        public static final String namespace="com.xiaodeng.my_MyBatis_v1.TestMapper";

        public static final Map<String,String> methodSqlMapping=new HashMap<>();

        static{
            //获得了所有的方法名和对应的sql
            methodSqlMapping.put("selectById","select id,nums,mingzi from test where id=?");
        }
    }
}
