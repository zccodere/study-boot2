package com.zccoder.boot2.ch11.mongodb.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zccoder.boot2.ch11.mongodb.entity.Baike;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * <br>
 * 标题: 驱动测试Controller<br>
 * 描述: 驱动测试Controller<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@RestController
@RequestMapping("/driver")
public class DriverTestController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/baike/{name}")
    public Baike findUser(@PathVariable String name) {
        final String id = name;
        Baike baike = mongoTemplate.execute(new DbCallback<Baike>() {
            @Override
            public Baike doInDB(MongoDatabase db) throws MongoException, DataAccessException {
                MongoCollection<Document> collection = db.getCollection("baike");
                MongoCursor<Document> cursor = collection.find(new Document("_id", id)).iterator();
                try {
                    while (cursor.hasNext()) {
                        System.out.println(cursor.next().toJson());
                    }
                } finally {
                    cursor.close();
                }
                return null;
            }
        });

        return baike;
    }
}
