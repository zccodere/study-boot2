package com.zccoder.boot2.ch13.elasticsearch.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * <br>
 * 标题: 书籍实体<br>
 * 描述: 书籍实体<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
@Document(indexName = "product", type = "default")
public class BookEntity {

    @Id
    private String id;
    private String name;
    private String message;
    private Date postDate;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
