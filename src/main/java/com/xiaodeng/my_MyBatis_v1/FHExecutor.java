package com.xiaodeng.my_MyBatis_v1;

public interface FHExecutor {

    <T> T query(String statement, String parameter);
}
