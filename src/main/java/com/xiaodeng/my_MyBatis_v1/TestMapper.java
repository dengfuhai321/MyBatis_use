package com.xiaodeng.my_MyBatis_v1;

import com.xiaodeng.pojo.Test;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/16 0016
 */
public interface TestMapper {

    Test selectById(Integer id);

}
