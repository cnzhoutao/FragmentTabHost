package com.example.nanke.fragmenttabhost_learn.Data;

import java.util.List;

/**
 * Created by zt on 2017/2/23.
 */

public class JavaBean {

    /**
     * error : false
     * results : [{"_id":"58a6e902421aa966366d05ef","createdAt":"2017-02-17T20:13:54.599Z","desc":"java 8 lambda表达式详解，有这篇就够了","publishedAt":"2017-02-23T11:50:23.116Z","source":"web","type":"Android","url":"http://blog.csdn.net/xiaochuanding/article/details/55516726","used":true,"who":null},{"_id":"58abf3b8421aa93d376f74f7","createdAt":"2017-02-21T16:00:56.110Z","desc":" Android 内存泄漏详解 ","publishedAt":"2017-02-23T11:50:23.116Z","source":"web","type":"Android","url":"http://blog.csdn.net/xiaochuanding/article/details/56286074","used":true,"who":null},{"_id":"58ad46f2421aa93d376f7507","createdAt":"2017-02-22T16:08:18.462Z","desc":"美丽说热修复框架","publishedAt":"2017-02-23T11:50:23.116Z","source":"chrome","type":"Android","url":"https://github.com/meili/Aceso","used":true,"who":"wuzheng"},{"_id":"58ae4fd5421aa95810795baa","createdAt":"2017-02-23T10:58:29.824Z","desc":"主要写了在Android6.0+版本上，修改EditText、TextView的文本选择菜单内容和为其他APP提供自定义文本操作这两个功能。","images":["http://img.gank.io/df2a0707-b0cf-4eee-8d9c-abaddcd71602"],"publishedAt":"2017-02-23T11:50:23.116Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/89970f098012","used":true,"who":null},{"_id":"58ace75e421aa957ef935316","createdAt":"2017-02-22T09:20:30.844Z","desc":"从Android到React Native开发，帮助你用Android开发来理解React Native","publishedAt":"2017-02-22T11:43:57.286Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/97692b1c451d","used":true,"who":"Shuyu Guo"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58a6e902421aa966366d05ef
         * createdAt : 2017-02-17T20:13:54.599Z
         * desc : java 8 lambda表达式详解，有这篇就够了
         * publishedAt : 2017-02-23T11:50:23.116Z
         * source : web
         * type : Android
         * url : http://blog.csdn.net/xiaochuanding/article/details/55516726
         * used : true
         * who : null
         * images : ["http://img.gank.io/df2a0707-b0cf-4eee-8d9c-abaddcd71602"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private Object who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public Object getWho() {
            return who;
        }

        public void setWho(Object who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
