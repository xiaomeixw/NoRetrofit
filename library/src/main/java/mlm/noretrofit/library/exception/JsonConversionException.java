package mlm.noretrofit.library.exception;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  21:20
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class JsonConversionException extends NoRetrofitException {

    private static final long serialVersionUID = -1;

    public JsonConversionException(String message) {
        super(message);
    }

    public JsonConversionException(Throwable throwable) {
        super(throwable);
    }
}
