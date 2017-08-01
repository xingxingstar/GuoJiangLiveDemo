package com.example.zhuwojia.guojianglivedemo.bean;

import java.util.List;

/**
 * author：shixinxin on 2017/7/17
 * version：v1.0
 */

public class HomeBanner {

    /**
     * errno : 0
     * msg :
     * data : [{"type":"2","pic":"http://static.guojiang.tv/pc/upload/2017_07_11/ae74fafcf70a58c43f1d8abfaba0c272.jpg","rid":587030},{"type":"2","pic":"http://static.guojiang.tv/pc/upload/2017_07_07/75a85bc5576decb004421dd5306c3a92.jpg","rid":795553},{"type":"2","pic":"http://static.guojiang.tv/pc/upload/2017_06_29/e1366f23100b39ae65455747f1893163.jpg","rid":88528},{"type":"2","pic":"http://static.guojiang.tv/pc/upload/2017_07_06/c40774a851585e5b10b92328e45bebc7.jpg","rid":140792},{"type":"1","pic":"http://static.guojiang.tv/pc/upload/2016_10_18/b56f3047eac998ffe4257e1682e057f7.jpg","title":"充值引导","url":"http://m.guojiang.tv/notice/rechargeWelfareGj","share_url":"http://m.guojiang.tv/notice/rechargeWelfareGj"},{"type":"1","pic":"http://static.guojiang.tv/pc/upload/2016_10_22/4395fe7847af01b6b2ddbe76442540a2.jpg","title":"iOS版充值问题说明","url":"http://m.guojiang.tv/notice/rechargeAbnormal","share_url":"http://m.guojiang.tv/notice/rechargeAbnormal"},{"type":"2","pic":"http://static.guojiang.tv/pc/upload/2017_07_12/635db72d1f3a9b35198fc59bfca6087c.jpg","rid":220829},{"type":"1","pic":"http://static.guojiang.tv/pc/upload/2017_06_27/2a3a11b9b6611c11dbaba6754f969796.jpg","title":"招募令","url":"http://m.guojiang.tv/dist/activity/staticPage/recruitOrder.html","share_url":"http://m.guojiang.tv/dist/activity/staticPage/recruitOrder.html","share_title":"招募令","share_content":"果酱招募令","share_img":"http://static.guojiang.tv/pc/upload/2017_06_27/ae783b32995d6c996a6aad07fd60fae4.jpg"},{"type":"1","pic":"http://static.guojiang.tv/pc/upload/2016_06_03/c788d12a92769abeed5207c9387e52ce.jpg","title":"果酱合约","url":"http://m.guojiang.tv/help/violationDesc","share_url":"http://m.guojiang.tv/help/violationDesc"},{"type":"1","pic":"http://static.guojiang.tv/pc/upload/2016_09_23/fda9b70b1781a2ff1f28e6db74c3297e.jpg","title":"违规公示","url":"http://m.guojiang.tv/notice/violationGj","share_url":"http://m.guojiang.tv/notice/violationGj"}]
     */

    private int errno;
    private String msg;
    private List<DataBean> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : 2
         * pic : http://static.guojiang.tv/pc/upload/2017_07_11/ae74fafcf70a58c43f1d8abfaba0c272.jpg
         * rid : 587030
         * title : 充值引导
         * url : http://m.guojiang.tv/notice/rechargeWelfareGj
         * share_url : http://m.guojiang.tv/notice/rechargeWelfareGj
         * share_title : 招募令
         * share_content : 果酱招募令
         * share_img : http://static.guojiang.tv/pc/upload/2017_06_27/ae783b32995d6c996a6aad07fd60fae4.jpg
         */

        private String type;
        private String pic;
        private int rid;
        private String title;
        private String url;
        private String share_url;
        private String share_title;
        private String share_content;
        private String share_img;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getShare_content() {
            return share_content;
        }

        public void setShare_content(String share_content) {
            this.share_content = share_content;
        }

        public String getShare_img() {
            return share_img;
        }

        public void setShare_img(String share_img) {
            this.share_img = share_img;
        }
    }
}
