package com.zccoder.boot2.ch4.view.beetl.conf;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.zccoder.boot2.ch4.view.beetl.util.SimpleFunction;
import com.zccoder.boot2.ch4.view.beetl.util.SimpleTag;

/**
 * <br>
 * 标题: 配置类<br>
 * 描述: 配置 GroupTemplate <br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Configuration
public class BeetlExtConfig {

    @Autowired
    private GroupTemplate groupTemplate;
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void config() {
        Map<String, Object> shared = new HashMap<String, Object>(16);
        shared.put("jsVersion", System.currentTimeMillis());
        groupTemplate.registerFunction("hi", applicationContext.getBean(SimpleFunction.class));
        groupTemplate.registerTagFactory("myTag", new TagFactory() {
            @Override
            public Tag createTag() {
                return applicationContext.getBean(SimpleTag.class);
            }
        });
        URL url = BeetlExtConfig.class.getResource("/templates/functions");
        System.out.print("==================" + url);
    }

//		@Bean /*另外一种配置方法，实现BeetlTemplateCustomize*/
//	  public BeetlTemplateCustomize beetlTemplateCustomize(){
//	    return new BeetlTemplateCustomize(){
//	      public void customize(GroupTemplate groupTemplate){
//
//	      }
//	    };
//	  }

}
