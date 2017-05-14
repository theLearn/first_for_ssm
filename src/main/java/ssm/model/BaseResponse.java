package ssm.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 
 * @author hongcheng
 *
 * ajax 请求的返回类型封装JSON结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -4185151304730685014L;

    protected int status;

    protected T data;

    protected String description;

    public BaseResponse(int status, String description, T data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public BaseResponse(int status, String description) {
        this(0, "ok", null);
    }

    public BaseResponse(T data) {
        this(0, "ok", data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
