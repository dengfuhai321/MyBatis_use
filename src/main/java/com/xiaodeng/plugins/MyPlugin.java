package com.xiaodeng.plugins;


import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.util.Properties;

/*
 * 在MyPlugin 这个类上加上这段注解。设置需要拦截的方法签名：
    属性 type代表需要拦截方法所属的类
    属性 method需要拦截的方法的具体方法名
    属性args需要拦截方法的参数列表。（为了区别重载方法）
 */
@Intercepts(value={
        @Signature(type = ParameterHandler.class ,method = "setParameters" ,args = PreparedStatement.class)
})
public class MyPlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        /**
         * 拦截目标方法的执行方法
         *
         */
        //显示的执行目标方法
        Object proceed = invocation.proceed();
        System.out.println("MyPlugin.....intercept....拦截的目标方法执行");

        //输出一下目标方法的对象
        Object target = invocation.getTarget();
        //输出一下目标方法
        Method method = invocation.getMethod();
        //目标方法的参数
        Object[] args = invocation.getArgs();
        System.out.println("对象target======>"+target+"方法method=====>"+method.getName());
        for (Object arg : args) {
            System.out.println("参数arg======>"+arg);
        }
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("当前执行对象======>"+target.getClass().getSimpleName());
        System.out.println("执行wrap包装前方法......plugin=======>包装前的对象"+target);
        //包装目标方法 返回代理对象
        Object wrap = Plugin.wrap(target, this);
        System.out.println("执行wrap包装方法......plugin=======>包装后的对象"+target);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
