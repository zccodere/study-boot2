package com.zccoder.boot2.ch10.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.zccoder.boot2.ch10.rest.entity.Order;

/**
 * <br>
 * 标题: 模拟调用订单接口<br>
 * 描述: 模拟调用订单接口<br>
 * 时间: 2018/09/26<br>
 *
 * @author zc
 */
@Controller
@RequestMapping("/test")
public class RestClientTestController {

    @Value(value = "${api.order}")
    String base;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/get/{orderId}")
    public @ResponseBody
    Order testGetOrder(@PathVariable String orderId) throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order/{orderId}";
        //如果期待返回的是Order集合，参考书里的讲解如何指定泛型
        ResponseEntity<Order> responseEntity = client.getForEntity(uri, Order.class, orderId);
        HttpHeaders headers = responseEntity.getHeaders();
        Order order = responseEntity.getBody();
        ;

        return order;
    }

    @GetMapping("/getorders")
    public @ResponseBody
    List<Order> queryOrder() throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/orders?offset={offset}";
        Integer offset = 1;
        //无参数
        HttpEntity body = null;
        ParameterizedTypeReference<List<Order>> typeRef = new ParameterizedTypeReference<List<Order>>() {
        };
        ResponseEntity<List<Order>> rs = client.exchange(uri, HttpMethod.GET, body, typeRef, offset);
        List<Order> order = rs.getBody();
        return order;

    }


    @GetMapping("/addorder")
    public @ResponseBody
    String testAddOrder() throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String uri = base + "/order";
        Order order = new Order();
        order.setName("test");
        HttpEntity<Order> body = new HttpEntity<Order>(order);
        String ret = client.postForObject(uri, body, String.class);
        return ret;
    }


}
