package com.dx.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: duanxu
 * @Date: 2019/5/9 22:00
 */
@Entity
@Table(name = "beauty_info", schema = "cell")
public class BeautyInfoEntity {
    private int id;
    private String name;
    private String telphone;
    private String email;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte isDelete;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telphone")
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "isDelete")
    public byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BeautyInfoEntity that = (BeautyInfoEntity) o;
        return id == that.id &&
                isDelete == that.isDelete &&
                Objects.equals(name, that.name) &&
                Objects.equals(telphone, that.telphone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telphone, email, createTime, updateTime, isDelete);
    }

    @Override
    public String toString() {
        return "【" +
                "编号=" + id +
                ", 姓名=" + name +
                ", 建立时间=" + createTime +
                ", 更新时间=" + updateTime +
                '】';
    }
}
