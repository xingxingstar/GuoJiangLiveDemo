package com.example.zhuwojia.guojianglivedemo.bean;

import java.util.List;

/**
 * author：shixinxin on 2017/7/19
 * version：v1.0
 */

public class UseBean {

    /**
     * errno : 0
     * msg :
     * data : {"id":"10055139","nickname":"星星61928408","headPic":"http://tvax4.sinaimg.cn/default/images/default_avatar_male_50.gif","birthday":"1990-01-01","sex":"1","signature":"","level":"0","nextLevel":1,"levelCoin":0,"nextLevelNeedCoin":1000,"attentionNum":"0","fansNum":"0","type":"2","coin":"0","lowCoin":"0","incomeAvailable":0,"canEditSex":true,"bgImg":"http://static.guojiang.tv/app/img/userBg/default.jpg","isFirstLogin":false,"lowkeyEnter":false,"mobile":"","messageCardNum":0,"isIdVerifiedModerator":false,"iosStatus":0,"beginnerDeadline":1501055414,"gallery":[],"applePay":false,"newMessageNum":0,"moderatorLevel":"0","moderatorLevelCoin":0,"moderatorNextLevel":1,"moderatorNextLevelNeedCoin":5000,"moderatorDesc":"","verified":"0","verifyInfo":"","rid":"845941","playForecast":"","moderatorLevelName":"0星","postNum":"0","groupCreateNumLeft":1,"ryToken":"gyawMDm1VGk3dclqpdiXsGwJPvA+It15mK2AGkfeOS1+4zZTQEkHGxbDXQzNYKy6zl1FyrcK0U5njPdAxl3Q2P7L1h/e0raB","isBan":false,"banLeftTime":-2,"guardNum":"0"}
     */

    private int errno;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 10055139
         * nickname : 星星61928408
         * headPic : http://tvax4.sinaimg.cn/default/images/default_avatar_male_50.gif
         * birthday : 1990-01-01
         * sex : 1
         * signature :
         * level : 0
         * nextLevel : 1
         * levelCoin : 0
         * nextLevelNeedCoin : 1000
         * attentionNum : 0
         * fansNum : 0
         * type : 2
         * coin : 0
         * lowCoin : 0
         * incomeAvailable : 0
         * canEditSex : true
         * bgImg : http://static.guojiang.tv/app/img/userBg/default.jpg
         * isFirstLogin : false
         * lowkeyEnter : false
         * mobile :
         * messageCardNum : 0
         * isIdVerifiedModerator : false
         * iosStatus : 0
         * beginnerDeadline : 1501055414
         * gallery : []
         * applePay : false
         * newMessageNum : 0
         * moderatorLevel : 0
         * moderatorLevelCoin : 0
         * moderatorNextLevel : 1
         * moderatorNextLevelNeedCoin : 5000
         * moderatorDesc :
         * verified : 0
         * verifyInfo :
         * rid : 845941
         * playForecast :
         * moderatorLevelName : 0星
         * postNum : 0
         * groupCreateNumLeft : 1
         * ryToken : gyawMDm1VGk3dclqpdiXsGwJPvA+It15mK2AGkfeOS1+4zZTQEkHGxbDXQzNYKy6zl1FyrcK0U5njPdAxl3Q2P7L1h/e0raB
         * isBan : false
         * banLeftTime : -2
         * guardNum : 0
         */

        private String id;
        private String nickname;
        private String headPic;
        private String birthday;
        private String sex;
        private String signature;
        private String level;
        private int nextLevel;
        private int levelCoin;
        private int nextLevelNeedCoin;
        private String attentionNum;
        private String fansNum;
        private String type;
        private String coin;
        private String lowCoin;
        private int incomeAvailable;
        private boolean canEditSex;
        private String bgImg;
        private boolean isFirstLogin;
        private boolean lowkeyEnter;
        private String mobile;
        private int messageCardNum;
        private boolean isIdVerifiedModerator;
        private int iosStatus;
        private int beginnerDeadline;
        private boolean applePay;
        private int newMessageNum;
        private String moderatorLevel;
        private int moderatorLevelCoin;
        private int moderatorNextLevel;
        private int moderatorNextLevelNeedCoin;
        private String moderatorDesc;
        private String verified;
        private String verifyInfo;
        private String rid;
        private String playForecast;
        private String moderatorLevelName;
        private String postNum;
        private int groupCreateNumLeft;
        private String ryToken;
        private boolean isBan;
        private int banLeftTime;
        private String guardNum;
        private List<?> gallery;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public int getNextLevel() {
            return nextLevel;
        }

        public void setNextLevel(int nextLevel) {
            this.nextLevel = nextLevel;
        }

        public int getLevelCoin() {
            return levelCoin;
        }

        public void setLevelCoin(int levelCoin) {
            this.levelCoin = levelCoin;
        }

        public int getNextLevelNeedCoin() {
            return nextLevelNeedCoin;
        }

        public void setNextLevelNeedCoin(int nextLevelNeedCoin) {
            this.nextLevelNeedCoin = nextLevelNeedCoin;
        }

        public String getAttentionNum() {
            return attentionNum;
        }

        public void setAttentionNum(String attentionNum) {
            this.attentionNum = attentionNum;
        }

        public String getFansNum() {
            return fansNum;
        }

        public void setFansNum(String fansNum) {
            this.fansNum = fansNum;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCoin() {
            return coin;
        }

        public void setCoin(String coin) {
            this.coin = coin;
        }

        public String getLowCoin() {
            return lowCoin;
        }

        public void setLowCoin(String lowCoin) {
            this.lowCoin = lowCoin;
        }

        public int getIncomeAvailable() {
            return incomeAvailable;
        }

        public void setIncomeAvailable(int incomeAvailable) {
            this.incomeAvailable = incomeAvailable;
        }

        public boolean isCanEditSex() {
            return canEditSex;
        }

        public void setCanEditSex(boolean canEditSex) {
            this.canEditSex = canEditSex;
        }

        public String getBgImg() {
            return bgImg;
        }

        public void setBgImg(String bgImg) {
            this.bgImg = bgImg;
        }

        public boolean isIsFirstLogin() {
            return isFirstLogin;
        }

        public void setIsFirstLogin(boolean isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
        }

        public boolean isLowkeyEnter() {
            return lowkeyEnter;
        }

        public void setLowkeyEnter(boolean lowkeyEnter) {
            this.lowkeyEnter = lowkeyEnter;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMessageCardNum() {
            return messageCardNum;
        }

        public void setMessageCardNum(int messageCardNum) {
            this.messageCardNum = messageCardNum;
        }

        public boolean isIsIdVerifiedModerator() {
            return isIdVerifiedModerator;
        }

        public void setIsIdVerifiedModerator(boolean isIdVerifiedModerator) {
            this.isIdVerifiedModerator = isIdVerifiedModerator;
        }

        public int getIosStatus() {
            return iosStatus;
        }

        public void setIosStatus(int iosStatus) {
            this.iosStatus = iosStatus;
        }

        public int getBeginnerDeadline() {
            return beginnerDeadline;
        }

        public void setBeginnerDeadline(int beginnerDeadline) {
            this.beginnerDeadline = beginnerDeadline;
        }

        public boolean isApplePay() {
            return applePay;
        }

        public void setApplePay(boolean applePay) {
            this.applePay = applePay;
        }

        public int getNewMessageNum() {
            return newMessageNum;
        }

        public void setNewMessageNum(int newMessageNum) {
            this.newMessageNum = newMessageNum;
        }

        public String getModeratorLevel() {
            return moderatorLevel;
        }

        public void setModeratorLevel(String moderatorLevel) {
            this.moderatorLevel = moderatorLevel;
        }

        public int getModeratorLevelCoin() {
            return moderatorLevelCoin;
        }

        public void setModeratorLevelCoin(int moderatorLevelCoin) {
            this.moderatorLevelCoin = moderatorLevelCoin;
        }

        public int getModeratorNextLevel() {
            return moderatorNextLevel;
        }

        public void setModeratorNextLevel(int moderatorNextLevel) {
            this.moderatorNextLevel = moderatorNextLevel;
        }

        public int getModeratorNextLevelNeedCoin() {
            return moderatorNextLevelNeedCoin;
        }

        public void setModeratorNextLevelNeedCoin(int moderatorNextLevelNeedCoin) {
            this.moderatorNextLevelNeedCoin = moderatorNextLevelNeedCoin;
        }

        public String getModeratorDesc() {
            return moderatorDesc;
        }

        public void setModeratorDesc(String moderatorDesc) {
            this.moderatorDesc = moderatorDesc;
        }

        public String getVerified() {
            return verified;
        }

        public void setVerified(String verified) {
            this.verified = verified;
        }

        public String getVerifyInfo() {
            return verifyInfo;
        }

        public void setVerifyInfo(String verifyInfo) {
            this.verifyInfo = verifyInfo;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getPlayForecast() {
            return playForecast;
        }

        public void setPlayForecast(String playForecast) {
            this.playForecast = playForecast;
        }

        public String getModeratorLevelName() {
            return moderatorLevelName;
        }

        public void setModeratorLevelName(String moderatorLevelName) {
            this.moderatorLevelName = moderatorLevelName;
        }

        public String getPostNum() {
            return postNum;
        }

        public void setPostNum(String postNum) {
            this.postNum = postNum;
        }

        public int getGroupCreateNumLeft() {
            return groupCreateNumLeft;
        }

        public void setGroupCreateNumLeft(int groupCreateNumLeft) {
            this.groupCreateNumLeft = groupCreateNumLeft;
        }

        public String getRyToken() {
            return ryToken;
        }

        public void setRyToken(String ryToken) {
            this.ryToken = ryToken;
        }

        public boolean isIsBan() {
            return isBan;
        }

        public void setIsBan(boolean isBan) {
            this.isBan = isBan;
        }

        public int getBanLeftTime() {
            return banLeftTime;
        }

        public void setBanLeftTime(int banLeftTime) {
            this.banLeftTime = banLeftTime;
        }

        public String getGuardNum() {
            return guardNum;
        }

        public void setGuardNum(String guardNum) {
            this.guardNum = guardNum;
        }

        public List<?> getGallery() {
            return gallery;
        }

        public void setGallery(List<?> gallery) {
            this.gallery = gallery;
        }
    }
}
