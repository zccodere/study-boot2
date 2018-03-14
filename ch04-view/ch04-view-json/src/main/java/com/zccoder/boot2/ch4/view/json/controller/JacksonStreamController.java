package com.zccoder.boot2.ch4.view.json.controller;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <br>
 * 标题: 控制器<br>
 * 描述: 直接输出 JSON 字符串<br>
 *
 * @author zc
 * @date 2018/03/14
 */
@Controller
@RequestMapping("/stream")
public class JacksonStreamController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("/parser.html")
    @ResponseBody
    public String parser() throws JsonParseException, IOException {
        String json = "{\"name\":\"lijz\",\"id\":10}";
        JsonFactory f = mapper.getFactory();
        String key = null, value = null;
        JsonParser parser = f.createParser(json);
        // {
        JsonToken token = parser.nextToken();
        //"name"
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME) {
            key = parser.getCurrentName();

        }

        token = parser.nextToken();
        //"lijz"
        value = parser.getValueAsString();
        parser.close();
        return key + "," + value;

    }

    @RequestMapping("/generator.html")
    @ResponseBody
    public String generator() throws JsonParseException, IOException {
        JsonFactory f = mapper.getFactory();
        //输出到stringWriter
        StringWriter sw = new StringWriter();
        JsonGenerator g = f.createGenerator(sw);
        // {
        g.writeStartObject();

        // "message", "Hello world!"
        g.writeStringField("name", "lijiazhi");
        // }
        g.writeEndObject();
        g.close();
        return sw.toString();
    }
}
