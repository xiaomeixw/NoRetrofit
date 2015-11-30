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

    private String name;
    private String phone;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
