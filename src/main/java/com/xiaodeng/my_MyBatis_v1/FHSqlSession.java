package com.xiaodeng.my_MyBatis_v1;

/**
 * @author dengfuhai
 * @description
 * MyBatis的三大对象Configuration,SqlSession,Executor.
 * @date 2019/9/12 0012
 */
public class FHSqlSession {
    //Configuration
    private FHConfiguration fhConfiguration;
    //Executor
    private FHExecutor fhExecutor;

    public FHSqlSession(FHConfiguration fhConfiguration, FHExecutor fhExecutor) {
        this.fhConfiguration = fhConfiguration;
        this.fhExecutor = fhExecutor;
    }

    public <T> T getMapper(Class<T> clazz){//泛型表示返回和传入任何类型的实现类
       return fhConfiguration.getMapper(clazz,this);
    }
    /**
     * 功能描述:
     * @author deng_fuhai
     * @date 2019/9/16 0016
     * @param statement sql语句
     * @param parameter sql语句的参数
     * @return T
     */
    public <T> T selectOne(String statement,String parameter){//传入sql和参数
        return  fhExecutor.query(statement,parameter);
    }
}
