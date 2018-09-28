package com.zccoder.boot2.ch13.elasticsearch.rest;

import java.util.HashMap;
import java.util.Map;

import com.zccoder.boot2.ch13.elasticsearch.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <br>
 * 标题: 直接使用RestTemplate访问<br>
 * 描述: 直接使用RestTemplate访问<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@RestController
public class RestClientController {

    @RequestMapping("/restclient/book/{id}")
    public String getLogById(@PathVariable String id) throws Exception {
        Book book = null;
        RestTemplate template = new RestTemplate();
        Map<String, Object> paras = new HashMap<>(16);
        paras.put("id", id);
        String str = template.getForObject("http://127.0.0.1:9200/product/book/{id}", String.class, paras);
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode root = mapper.readTree(parser);
        JsonNode sourceNode = root.get("_source");
        book = mapper.convertValue(sourceNode, Book.class);
        return book.getMessage();

    }

//	@RequestMapping("/restclient/search/{key}")
//	public String search(@PathVariable String key) throws Exception {
//		Book book = null;
//		RestTemplate template = new RestTemplate();
//		Map<String,Object> paras = new HashMap<>();
//		paras.put("key", key);
//		String str = template.getForObject("http://172.16.86.56:9200/product/book/_search?q=message:{key}", String.class,paras);
//		ObjectMapper mapper = new ObjectMapper();
//		JsonFactory factory = mapper.getFactory();
//		JsonParser parser = factory.createParser(str);
//		JsonNode root = mapper.readTree(parser);
//		JsonNode hitsNode = root.get("hits");
//		int result = hitsNode.get("total").asInt();
//		JsonNode  array = hitsNode.get("hits");
//		
//		for(JsonNode node:  array.){
//			
//		}
//		book  = mapper.convertValue(sourceNode, Book.class);
//		return book.getMessage();
//
//	}
}
