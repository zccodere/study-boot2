package com.zccoder.boot2.ch17.monitor.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 测试 Controller<br>
 * 描述: 测试 Controller<br>
 * 时间: 2018/09/30<br>
 *
 * @author zc
 */
@Controller
public class TestController {

    private Log log = LogFactory.getLog(TestController.class);

    @RequestMapping("/test.html")
    public @ResponseBody
    String create() throws Exception {
        return "hello ";
    }

    @RequestMapping("/testsleep.html")
    public @ResponseBody
    String sleepTest() throws Exception {
        Thread.sleep(1000 * 1000);
        return "";
    }

    @RequestMapping("/testloglevel.html")
    public @ResponseBody
    String logLevelTest(String para) throws Exception {
        log.debug("enter testlog level " + para);
        return "";
    }


}
