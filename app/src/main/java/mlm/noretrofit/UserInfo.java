package mlm.noretrofit;


import java.io.Serializable;

/**
 * 登录成功后返回的用户信息
 *
 * @author xiongwei
 */

public class UserInfo implements Serializable {


    private String regtype;  //登录的类型，qq，weibo，空为手机号登录
    private String username;  //用户名称
    private String type;                   //type 1用户，2医生，3是机构， 16管理员
    private String uid;              //用户id
    private String phone;     //手机号码
    private String token;  //token 认证登录是否过期
    private String version;                             //表情版本
    private String thumb;
    private String uploadImageToken;   //七牛图片上传token
    private String messageNotReadCount; //总的未读记录数
    private String jifen;                 //用户总积分
    private String logintype;                //登录类型，默认为空
    private String is_question;         // 判断咨询
    private String category_version;        //类别版本
    private String score;                     //登录积分

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getUploadImageToken() {
        return uploadImageToken;
    }

    public void setUploadImageToken(String uploadImageToken) {
        this.uploadImageToken = uploadImageToken;
    }

    public String getMessageNotReadCount() {
        return messageNotReadCount;
    }

    public void setMessageNotReadCount(String messageNotReadCount) {
        this.messageNotReadCount = messageNotReadCount;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getIs_question() {
        return is_question;
    }

    public void setIs_question(String is_question) {
        this.is_question = is_question;
    }

    public String getCategory_version() {
        return category_version;
    }

    public void setCategory_version(String category_version) {
        this.category_version = category_version;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "regtype='" + regtype + '\'' +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", token='" + token + '\'' +
                ", version='" + version + '\'' +
                ", thumb='" + thumb + '\'' +
                ", uploadImageToken='" + uploadImageToken + '\'' +
                ", messageNotReadCount='" + messageNotReadCount + '\'' +
                ", jifen='" + jifen + '\'' +
                ", logintype='" + logintype + '\'' +
                ", is_question='" + is_question + '\'' +
                ", category_version='" + category_version + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
