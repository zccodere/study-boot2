package com.zccoder.boot2.ch11.mongodb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <br>
 * 标题: 百科<br>
 * 描述: 百科<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
public class Baike {

    private String id;
    private String desc;
    private List<String> tag = new ArrayList<String>();
    private Comment comment = null;
    private Date crateDate = null;
    private Date updateDate = null;
    private int status = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Date getCrateDate() {
        return crateDate;
    }

    public void setCrateDate(Date crateDate) {
        this.crateDate = crateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
