package mlm.noretrofit.library.exception;

/**
 * Created by xiongwei , An Android project Engineer.
 * Data : 2015-11-28  20:37
 * Describe:
 * Version : 1.0
 * Open Source ：NoRetrofit
 */
public class NoRetrofitException extends Exception{

    private static final long serialVersionUID = -1;

    private String extraMessage;

    public NoRetrofitException(String message){
        super(message);
    }

    public NoRetrofitException(Throwable throwable){
        super(throwable);
    }

    public NoRetrofitException(String message,String extraMessage){
        super(message);
        this.extraMessage=extraMessage;
    }

    public NoRetrofitException(Throwable throwable,String extraMessage){
        super(throwable);
        this.extraMessage=extraMessage;
    }




}
