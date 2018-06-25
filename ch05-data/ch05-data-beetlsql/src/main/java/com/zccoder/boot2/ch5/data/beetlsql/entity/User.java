package com.zccoder.boot2.ch5.data.beetlsql.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * 标题: 用户实体类<br>
 * 描述: 用户实体类<br>
 * 时间: 2018/06/25<br>
 *
 * @author zc
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6015847192273728434L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 部门ID
     */
    private Integer departmentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
