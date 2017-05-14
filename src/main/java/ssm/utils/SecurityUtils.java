package ssm.utils;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Created by hongcheng on 17/5/9.
 */
public class SecurityUtils {

    private static Logger log = Logger.getLogger(SecurityUtils.class);

    // 加密
    public static String encodeBase64(String source) {
        byte[] b = null;
        String s = null;
        try {
            b = source.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException", e);
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String decodeBase64(String source) {
        byte[] b = null;
        String result = null;
        if (source != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(source);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                log.error("Exception", e);
            }
        }
        return result;
    }
}
