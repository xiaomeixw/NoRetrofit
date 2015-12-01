package mlm.noretrofit;

import java.io.Serializable;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-01  11:48
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public class JsonBean<T> implements Serializable {

    private String state;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
