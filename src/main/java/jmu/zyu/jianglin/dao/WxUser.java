package jmu.zyu.jianglin.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="wx_user")
public class WxUser {

    @Id
    @Column(name="open_id")
    private String open_id;

    @Column(name="wx_avatar_path")
    private String wx_avatar_path;

    @Column(name="wx_gender")
    private String wx_gender;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    public WxUser(){

    }

    public WxUser(String open_id, String wx_avatar_path, String wx_gender, String name, String phone) {
        this.open_id = open_id;
        this.wx_avatar_path = wx_avatar_path;
        this.wx_gender = wx_gender;
        this.name = name;
        this.phone = phone;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getWx_avatar_path() {
        return wx_avatar_path;
    }

    public void setWx_avatar_path(String wx_avatar_path) {
        this.wx_avatar_path = wx_avatar_path;
    }

    public String getWx_gender() {
        return wx_gender;
    }

    public void setWx_gender(String wx_gender) {
        this.wx_gender = wx_gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
