package mlm.noretrofit.library.http;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  19:00
 * Base on Meilimei.com (PHP Service)
 * Describe: 封装Header
 * Version:1.0
 * Open source
 */
public class Header {
    private String name;

    private String value;

    public Header(String name,String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static List<Header> convertFromApacheHeaders(org.apache.http.Header[] headers) {

        List<Header> headerList = new ArrayList<Header>();

        if (headers != null) {
            for (int i = 0; i < headers.length; i++) {
                org.apache.http.Header header = headers[i];
                headerList.add(new Header(header.getName(), header.getValue()));
            }
        }


        return headerList;

    }

    public static org.apache.http.Header[] convertToApacheHeaders(List<Header> headers) {

        if (headers != null) {
            return headers.toArray(new org.apache.http.Header[headers.size()]);
        }

        return null;

    }


}
