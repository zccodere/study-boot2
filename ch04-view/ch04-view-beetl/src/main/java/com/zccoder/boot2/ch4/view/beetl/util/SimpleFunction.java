package com.zccoder.boot2.ch4.view.beetl.util;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 自定义函数<br>
 * 描述: 对模版进行扩展<br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Component
public class SimpleFunction implements Function {

    @Override
    public Object call(Object[] paras, Context ctx) {
        return "hi";
    }

}
