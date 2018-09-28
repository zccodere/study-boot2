package com.zccoder.boot2.ch13.elasticsearch.entity;

import java.util.Date;

/**
 * <br>
 * 标题: 书籍<br>
 * 描述: 书籍<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
public class Book {
    private String name;
    private String message;
    private Date postDate;
    private String type;

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
