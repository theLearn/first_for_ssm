package ssm.exception;



import java.net.ConnectException;

/**
 * Created by hongcheng on 17/1/22.
 */
public class ExceptionHandler {

    public static ActionException handleException(Throwable e) {
        ActionException ex;
       if (e instanceof ConnectException) {
            ex = new ActionException(e, ERROR.NETWORK_ERROR, "连接失败");
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ActionException(e, ERROR.SSL_ERROR, "证书验证失败");
            return ex;
        }
        else {
            ex = new ActionException(e, ERROR.UNKNOWN, "未知错误");
            return ex;
        }
    }


    /**
     * 约定异常
     */
    class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORK_ERROR = 1002;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1003;
    }
}
