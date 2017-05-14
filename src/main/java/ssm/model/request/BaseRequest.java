package ssm.model.request;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import ssm.utils.SecurityUtils;
import ssm.validator.CheckRequestParameter;

import java.io.Serializable;

/**
 * Created by hongcheng on 17/4/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRequest<T> implements Serializable {

    private static final long serialVersionUID = -4185151304720685014L;

    @CheckRequestParameter(isAuthSuccess = true)
    protected String token;

    protected T data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseRequest() {
    }

    public BaseRequest(String token, String encodeJsonStr) {
        this.token = token;
        String jsonStr = SecurityUtils.decodeBase64(encodeJsonStr);
        if(StringUtils.hasText(jsonStr))
        {
            this.data = (T) JSON.parseObject(jsonStr, this.data.getClass());
        }
        else
        {
            Logger.getLogger(BaseRequest.class.getName()).error("parameter error");
        }
    }
}
