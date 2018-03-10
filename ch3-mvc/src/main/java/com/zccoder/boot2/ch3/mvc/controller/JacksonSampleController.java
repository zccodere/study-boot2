package com.zccoder.boot2.ch3.mvc.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.*;
import com.zccoder.boot2.ch3.mvc.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author zc
 * @title Jackson控制器
 * @describe JSON相关演示
 * @date 2018/03/09
 **/
@Controller
@RequestMapping("/jackson")
public class JacksonSampleController {

    Log log = LogFactory.getLog(JacksonSampleController.class);

    /**
     * //参考JacksonConf
     */
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/now.json")
    @ResponseBody
    public Map now() {
        Map map = new HashMap(16);
        map.put("date", new Date());
        return map;
    }

    @GetMapping("/readtree.json")
    @ResponseBody
    public String readtree() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"lijz\",\"id\":10}";
        JsonNode node = mapper.readTree(json);

        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        return "name:" + name + ",id:" + id;

    }


    @GetMapping("/databind.json")
    @ResponseBody
    public String databind() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"lijz\",\"id\":10}";
        User user = mapper.readValue(json, User.class);
        return "name:" + user.getName() + ",id:" + user.getId();

    }


    @GetMapping("/serialization.json")
    @ResponseBody
    public String custom() throws JsonProcessingException {

        User user = new User();
        user.setId(1L);
        user.setName("hello");
        String str = mapper.writeValueAsString(user);

        return str;

    }

    @JsonIgnoreProperties({"id", "photo"})
    public static class SamplePojo {
        Long id;
        String name;
        byte[] photo;
        @JsonIgnore
        BigDecimal salary;
        Map<String, Object> otherProperties = new HashMap<String, Object>();

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public byte[] getPhoto() {
            return photo;
        }

        public void setPhoto(byte[] photo) {
            this.photo = photo;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @JsonAnyGetter
        public Map<String, Object> getOtherProperties() {
            return otherProperties;
        }

        @JsonAnySetter
        public void setOtherProperties(Map<String, Object> otherProperties) {
            this.otherProperties = otherProperties;
        }
    }

    public static class Usererializer extends JsonSerializer<User> {
        @Override
        public void serialize(User value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {
            jgen.writeStartObject();
            jgen.writeStringField("user-name", value.getName());
            jgen.writeEndObject();
        }
    }

    public class UserDeserializer extends JsonDeserializer<User> {

        @Override
        public User deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            String name = node.get("user-name").asText();
            User user = new User();
            user.setName(name);
            return user;
        }
    }
}
