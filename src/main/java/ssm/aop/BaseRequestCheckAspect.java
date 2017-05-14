package ssm.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssm.exception.ActionException;
import ssm.model.BaseResponse;
import ssm.validator.BaseRequestValidator;

/**
 * Created by hongcheng on 17/5/10.
 */
@Component
@Aspect
public class BaseRequestCheckAspect {

    private Logger log = Logger.getLogger(BaseRequestCheckAspect.class.getName());

    @Autowired
    private BaseRequestValidator baseRequestValidator;

    @Pointcut("execution(* ssm.controller.*.*(..))")
    public void check(){}

    /**
     * 切面方法，使用统一异常处理
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "check()")
    public Object checkIsValid(ProceedingJoinPoint joinPoint){
        log.info("before method invoking!");
        Object object = null;
        // 参数校验，未抛出异常表示验证OK
        try {
            baseRequestValidator.checkValid(joinPoint);
        } catch (ActionException e) {
            log.info("checkValid failed");
            return new BaseResponse<Boolean>(e.getErrorCode(), e.getErrorMessage(), false);
        }
        try {
            object = ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable throwable) {
            log.error("throwable : ", throwable);
        }
        return object;
    }

}
