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

    @Column(name="wx_nickname")
    private String wx_nickname;

    @Column(name="wx_avatar_url")
    private String wx_avatar_url;

    @Column(name="wx_gender")
    private String wx_gender;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    public WxUser(){

    }

    public WxUser(String open_id, String wx_nickname, String wx_avatar_url, String wx_gender) {
        this.open_id = open_id;
        this.wx_nickname = wx_nickname;
        this.wx_avatar_url = wx_avatar_url;
        this.wx_gender = wx_gender;
        this.name = "unknown";
        this.phone = "unknown";
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getWx_nickname() {
        return wx_nickname;
    }

    public void setWx_nickname(String wx_nickname) {
        this.wx_nickname = wx_nickname;
    }

    public String getWx_avatar_url() {
        return wx_avatar_url;
    }

    public void setWx_avatar_url(String wx_avatar_url) {
        this.wx_avatar_url = wx_avatar_url;
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
