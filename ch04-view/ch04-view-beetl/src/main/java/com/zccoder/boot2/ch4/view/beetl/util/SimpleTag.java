package com.zccoder.boot2.ch4.view.beetl.util;

import java.io.IOException;

import org.beetl.core.Tag;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 自定义标签函数<br>
 * 描述: 对模版进行扩展<br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Component
@Scope("prototype")
public class SimpleTag extends Tag {

    @Override
    public void render() {
        System.out.println(this);
        try {
            ctx.byteWriter.writeString("被删除了，付费可以看");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
