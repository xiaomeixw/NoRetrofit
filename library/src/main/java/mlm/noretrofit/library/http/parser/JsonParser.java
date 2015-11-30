package mlm.noretrofit.library.http.parser;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import mlm.noretrofit.library.constans.Constant;
import mlm.noretrofit.library.exception.JsonConversionException;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-11-30  15:35
 * Base on Meilimei.com (PHP Service)
 * Describe: use gson parser json
 * Gson提供了fromJson(jsonData,Class)方法来实现从Json相关对象到java实体的方法。
 * Version:1.0
 * Open source
 */
public class JsonParser<T> {

    private Gson gson;

    /**
     * 需要返回的jave实体对象
     */
    private Type responseType;

    public JsonParser(Type responseType) {
        this.gson = new Gson();
        this.responseType = responseType;
    }

    /**
     * 使用gson.fromJson(jsonData,class)将json转成bean对象;
     * @param is
     * @return
     * @throws JsonConversionException
     */
    public T parse(InputStream is) throws JsonConversionException {
        try {
            return gson.fromJson(new InputStreamReader(is, Constant.UTF_8), responseType);
        } catch (JsonIOException e) {
            throw new JsonConversionException(e);
        } catch (UnsupportedEncodingException e) {
            throw new JsonConversionException(e);
        } catch (JsonSyntaxException e) {
            throw new JsonConversionException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
