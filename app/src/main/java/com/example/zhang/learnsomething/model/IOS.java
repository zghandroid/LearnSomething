package com.example.zhang.learnsomething.model;

import java.util.List;

/**
 * Created by 12345 on 2018/3/29.
 */

public class IOS {
        /**
         * _id : 5a273dc8421aa90fe2f02cb6
         * createdAt : 2017-12-06T08:46:00.413Z
         * desc : 在 App 内实现 App UI 设计的设计工具。
         * publishedAt : 2017-12-06T08:49:34.303Z
         * source : chrome
         * type : iOS
         * url : https://github.com/willowtreeapps/Hyperion-iOS
         * used : true
         * who : 代码家
         * images : ["http://img.gank.io/2814abae-4e7f-4297-b959-cecbd0779f1d"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
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

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
}
