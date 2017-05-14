package ssm.validator;

/**
 * Created by hongcheng on 17/5/11.
 */
public class CheckParameterResult {

    private String description;
    private int errCode;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public CheckParameterResult(String description, int errCode) {
        this.description = description;
        this.errCode = errCode;
    }

    public CheckParameterResult() {
    }
}
