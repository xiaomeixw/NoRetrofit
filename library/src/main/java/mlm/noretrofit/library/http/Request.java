package mlm.noretrofit.library.http;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  18:53
 * Base on Meilimei.com (PHP Service)
 * Describe: 请求封装
 * Version:1.0
 * Open source
 */
public class Request {

    //get or post
    private HttpType mHttpType;

    //full url website
    private String mFullUrl;

    //get params
    private List<NameValuePair> queryParams;

    //post params
    private List<NameValuePair> bodyParams;

    //head params
    private List<Header> headers;

    //post has body
    private boolean hasBody;

    //defalut
    public Request(){
        this.headers = new ArrayList<>();
        this.queryParams=new ArrayList<>();
        this.bodyParams=new ArrayList<>();
        hasBody=false;
        mHttpType=HttpType.GET;
    }

    //set params outside
    public Request(HttpType httpType,String mFullUrl,List<Header> headers,List<NameValuePair> queryParams,List<NameValuePair> bodyParams){
        //如果外部不传入HttpType-->异常报知
        if(httpType == null){
            throw new IllegalArgumentException("please use @GET OF @POST above your method");
        }

        if(mFullUrl == null){
            throw new IllegalArgumentException("Url can not be null");
        }

        this.headers = headers;

        //Post请求,同时是有参数的
        if(httpType == HttpType.POST && bodyParams.size()>0){
            hasBody=true;
        }else{
            hasBody=false;
        }

        this.mHttpType=httpType;
        this.mFullUrl=mFullUrl;
        this.bodyParams=bodyParams;
        //TODO WHT???
        this.queryParams=new ArrayList<NameValuePair>();
    }


    //--------------------------------------
    // SET/GET
    //--------------------------------------
    public HttpType getHttpType() {
        return mHttpType;
    }

    public void setHttpType(HttpType mHttpType) {
        this.mHttpType = mHttpType;
    }


    public String getFullUrl() {
        return mFullUrl;
    }

    public void setFullUrl(String mFullUrl) {
        this.mFullUrl = mFullUrl;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(List<NameValuePair> queryParams) {
        this.queryParams = queryParams;
    }

    public List<NameValuePair> getBodyParams() {
        return bodyParams;
    }

    public void setBodyParams(List<NameValuePair> bodyParams) {
        this.bodyParams = bodyParams;
    }

    public boolean hasBody() {
        return hasBody;
    }


    /**
     * 为打印数据而用
     * @return
     */
    @Override
    public String toString() {

        StringBuilder requestStringBuilder = new StringBuilder();
        for(NameValuePair param : queryParams)
            requestStringBuilder.append(String.format("[QueryParam]%s=%s\n", param.getName(), param.getValue()));

        for(Header header : headers)
            requestStringBuilder.append(String.format("[Header]%s : %s\n", header.getName(), header.getValue()));

        for(NameValuePair param : bodyParams)
            requestStringBuilder.append(String.format("[BodyParam]%s=%s\n", param.getName(), param.getValue()));

        requestStringBuilder.append(String.format("[Url]%s=%s\n", "Full url", mFullUrl));


        return requestStringBuilder.toString();
    }
}
