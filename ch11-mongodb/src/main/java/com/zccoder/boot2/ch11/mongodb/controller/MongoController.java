package com.zccoder.boot2.ch11.mongodb.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zccoder.boot2.ch11.mongodb.entity.Baike;
import com.mongodb.client.result.UpdateResult;

/**
 * <br>
 * 标题: MongoDB controller<br>
 * 描述: MongoDB controller<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@RestController
public class MongoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/baike/{name}")
    public Baike findUser(@PathVariable String name) {

        Baike dict = mongoTemplate.findById(name, Baike.class);
        return dict;
    }

    @GetMapping("/addbaike")
    public Baike addDict(Baike baike) {
        baike.setCrateDate(new Date());
        mongoTemplate.insert(baike);
        return baike;
    }

    @GetMapping("/querybad/{bad}")
    public List<Baike> queryBad(@PathVariable int bad) {
        Criteria criteria = where("comment.bad").gt(bad);
        ;
        List<Baike> list = mongoTemplate.find(query(criteria), Baike.class);
        return list;
    }

    @GetMapping("/baike/tag/{tag}")
    public @ResponseBody
    String addOne(@PathVariable String tag) {
        Criteria criteria = where("tag").in(tag);
        Update update = new Update();
        update.inc("comment.good", 1);
        UpdateResult result = mongoTemplate.updateMulti(query(criteria), update, Baike.class);
        return "成功修改 " + result.getModifiedCount();
    }

    @GetMapping("/baike/tag/{tag}/{pageNum}")
    public List<Baike> findBaike(@PathVariable String tag, @PathVariable int pageNum) {
        Criteria criteria = where("tag").in(tag);
        Query query = query(criteria);
        //查询总数
        long totalCount = mongoTemplate.count(query, Baike.class);
        //每页个数 
        int numOfPage = 10;
        //计算总数
        long totalPage = totalCount % numOfPage == 0 ? (totalCount / numOfPage) : (totalCount / numOfPage + 1);

        int skip = (pageNum - 1) * numOfPage;
        query.skip(skip).limit(numOfPage);
        List<Baike> list = mongoTemplate.find(query, Baike.class);
        return list;
    }


    @GetMapping("/updatebaike")
    public Baike updateDict(Baike baike) {
        baike.setUpdateDate(new Date());
        mongoTemplate.save(baike);
        return baike;
    }

    @GetMapping("/deletebaike")
    public Baike deleteDict(String id) {
        Baike baike = new Baike();
        baike.setId(id);
        mongoTemplate.remove(baike);
        return baike;
    }


}
