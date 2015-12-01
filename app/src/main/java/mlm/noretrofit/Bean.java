package mlm.noretrofit;

import java.io.Serializable;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  20:10
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public class Bean implements Serializable {

    private static final long serialVersionUID = -6994329545768578678L;

    //产品信息
    private String id;
    private String image;
    private String market_price;
    private String summary;
    private String team_price;
    private String title;
    private String tags;

    private String buynums;
    private String end_time;

    //是否支持
    private String outdatefun;//过期退款
    private String allowrefund;//随时退

    //商家信息
    private String partner_name;
    private String partner_phone;
    private String address;
    private String distance;

    //webView数据：本单简介 团购详情 购买须知
    private String product;//本单简介;
    private String txtDetail;//团购详情
    private String notice;//购买须知
    private String detail;//更详细的详细



    //用于逻辑判断，价格的显示
    private String newversion;//判断数据版本
    private String p_store;//剩余个数
    private String now_number;//购买人数
    private String delivery;//新数据版本判断是商品还是劵
    private String deposit;//定金

    private String reser_price;//预约价


    @Override
    public String toString() {
        return "Bean{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", market_price='" + market_price + '\'' +
                ", summary='" + summary + '\'' +
                ", team_price='" + team_price + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", buynums='" + buynums + '\'' +
                ", end_time='" + end_time + '\'' +
                ", outdatefun='" + outdatefun + '\'' +
                ", allowrefund='" + allowrefund + '\'' +
                ", partner_name='" + partner_name + '\'' +
                ", partner_phone='" + partner_phone + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                ", product='" + product + '\'' +
                ", txtDetail='" + txtDetail + '\'' +
                ", notice='" + notice + '\'' +
                ", detail='" + detail + '\'' +
                ", newversion='" + newversion + '\'' +
                ", p_store='" + p_store + '\'' +
                ", now_number='" + now_number + '\'' +
                ", delivery='" + delivery + '\'' +
                ", deposit='" + deposit + '\'' +
                ", reser_price='" + reser_price + '\'' +
                '}';
    }

    public String getReser_price() {
        return reser_price;
    }
    public void setReser_price(String reser_price) {
        this.reser_price = reser_price;
    }
    public String getDeposit() {
        return deposit;
    }
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    public String getDelivery() {
        return delivery;
    }
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
    public String getNewversion() {
        return newversion;
    }
    public void setNewversion(String newversion) {
        this.newversion = newversion;
    }
    public String getP_store() {
        return p_store;
    }
    public void setP_store(String p_store) {
        this.p_store = p_store;
    }
    public String getNow_number() {
        return now_number;
    }
    public void setNow_number(String now_number) {
        this.now_number = now_number;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getNotice() {
        return notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public String getTxtDetail() {
        return txtDetail;
    }
    public void setTxtDetail(String txtDetail) {
        this.txtDetail = txtDetail;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getMarket_price() {
        return market_price;
    }
    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getTeam_price() {
        return team_price;
    }
    public void setTeam_price(String team_price) {
        this.team_price = team_price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getBuynums() {
        return buynums;
    }
    public void setBuynums(String buynums) {
        this.buynums = buynums;
    }
    public String getEnd_time() {
        return end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public String getOutdatefun() {
        return outdatefun;
    }
    public void setOutdatefun(String outdatefun) {
        this.outdatefun = outdatefun;
    }
    public String getAllowrefund() {
        return allowrefund;
    }
    public void setAllowrefund(String allowrefund) {
        this.allowrefund = allowrefund;
    }
    public String getPartner_name() {
        return partner_name;
    }
    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }
    public String getPartner_phone() {
        return partner_phone;
    }
    public void setPartner_phone(String partner_phone) {
        this.partner_phone = partner_phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
}
