package com.taosx.one.View.Home.Entity;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class EssayEntity {

    private int res;
    private List<EssayDataEntity> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<EssayDataEntity> getData() {
        return data;
    }

    public void setData(List<EssayDataEntity> data) {
        this.data = data;
    }

    public static class EssayDataEntity {
        /**
         * content_id : 2302
         * hp_title : 软糖| “格斗” _ box
         * hp_makettime : 2017-04-27 06:00:00
         * guide_word : 我们每周会选择一个主题，由七个作者绘制不同风格的短篇漫画，每天一幅。
         * start_video :
         * author : [{"user_id":"7750983","user_name":"巨巨","desc":"一个小孩子。","wb_name":"","is_settled":"0","settled_type":"0","summary":"一个小孩子。","fans_total":"406","web_url":"http://image.wufazhuce.com/Fj7r9kl4xKHpHzJJ4TwoGo01rFb7"}]
         * has_audio : false
         * author_list : [{"user_id":"7750983","user_name":"巨巨","desc":"一个小孩子。","wb_name":"","is_settled":"0","settled_type":"0","summary":"一个小孩子。","fans_total":"406","web_url":"http://image.wufazhuce.com/Fj7r9kl4xKHpHzJJ4TwoGo01rFb7"}]
         */

        private String content_id;
        private String hp_title;
        private String hp_makettime;
        private String guide_word;
        private String start_video;
        private boolean has_audio;
        private List<AuthorEntity> author;
        private List<AuthorListEntity> author_list;

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getHp_title() {
            return hp_title;
        }

        public void setHp_title(String hp_title) {
            this.hp_title = hp_title;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public void setHp_makettime(String hp_makettime) {
            this.hp_makettime = hp_makettime;
        }

        public String getGuide_word() {
            return guide_word;
        }

        public void setGuide_word(String guide_word) {
            this.guide_word = guide_word;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public boolean isHas_audio() {
            return has_audio;
        }

        public void setHas_audio(boolean has_audio) {
            this.has_audio = has_audio;
        }

        public List<AuthorEntity> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorEntity> author) {
            this.author = author;
        }

        public List<AuthorListEntity> getAuthor_list() {
            return author_list;
        }

        public void setAuthor_list(List<AuthorListEntity> author_list) {
            this.author_list = author_list;
        }

        public static class AuthorEntity {
            /**
             * user_id : 7750983
             * user_name : 巨巨
             * desc : 一个小孩子。
             * wb_name :
             * is_settled : 0
             * settled_type : 0
             * summary : 一个小孩子。
             * fans_total : 406
             * web_url : http://image.wufazhuce.com/Fj7r9kl4xKHpHzJJ4TwoGo01rFb7
             */

            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getWb_name() {
                return wb_name;
            }

            public void setWb_name(String wb_name) {
                this.wb_name = wb_name;
            }

            public String getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(String is_settled) {
                this.is_settled = is_settled;
            }

            public String getSettled_type() {
                return settled_type;
            }

            public void setSettled_type(String settled_type) {
                this.settled_type = settled_type;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getFans_total() {
                return fans_total;
            }

            public void setFans_total(String fans_total) {
                this.fans_total = fans_total;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }
        }

        public static class AuthorListEntity {
            /**
             * user_id : 7750983
             * user_name : 巨巨
             * desc : 一个小孩子。
             * wb_name :
             * is_settled : 0
             * settled_type : 0
             * summary : 一个小孩子。
             * fans_total : 406
             * web_url : http://image.wufazhuce.com/Fj7r9kl4xKHpHzJJ4TwoGo01rFb7
             */

            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getWb_name() {
                return wb_name;
            }

            public void setWb_name(String wb_name) {
                this.wb_name = wb_name;
            }

            public String getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(String is_settled) {
                this.is_settled = is_settled;
            }

            public String getSettled_type() {
                return settled_type;
            }

            public void setSettled_type(String settled_type) {
                this.settled_type = settled_type;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getFans_total() {
                return fans_total;
            }

            public void setFans_total(String fans_total) {
                this.fans_total = fans_total;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }
        }
    }
}
