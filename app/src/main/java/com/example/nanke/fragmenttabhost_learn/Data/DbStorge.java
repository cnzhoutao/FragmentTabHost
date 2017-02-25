package com.example.nanke.fragmenttabhost_learn.Data;

import java.util.Date;

/**
 * Created by zt on 2017/2/25.
 */

public class DbStorge {
    String title;//文章标题
    String url;//文章的链接地址
    String storge_time;//存储时间
    String createdAt;//文章的发表时间
    String type;//文章所属类别

    public DbStorge(String title,String url,String storge_time,String createdAt,String type){
        this.title=title;
        this.url=url;
        this.storge_time=storge_time;
        this.createdAt=createdAt;
        this.type=type;
    }
    public DbStorge(){

    }
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getStorge_time() {
        return storge_time;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStorge_time(String storge_time) {
        this.storge_time = storge_time;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setType(String type) {
        this.type = type;
    }
}
