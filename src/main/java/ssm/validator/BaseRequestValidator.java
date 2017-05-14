package ssm.validator;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import ssm.exception.ActionException;

import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by hongcheng on 17/5/10.
 */
@Component
public class BaseRequestValidator {

    private Logger log = Logger.getLogger(BaseRequestValidator.class.getName());

    public void checkValid(ProceedingJoinPoint joinPoint) throws ActionException{
        Object[] args = null;
        Method method = null;
        Object target = null;
        String methodName = null;


        Annotation[][] annotations = null;

        try {
            methodName = joinPoint.getSignature().getName();
            target = joinPoint.getTarget();
            method = getMethodByClassAndName(target.getClass(), methodName);
            annotations = method.getParameterAnnotations();
        } catch (Exception e) {
            if(methodName != null)
            {
                log.error(methodName + " valid failed : " + e);
            }
            else
            {
                log.error("methodName is null valid failed : " + e);
            }

            throw new ActionException(999, "valid failed");
        }


        CheckParameterResult result = null;
        args = joinPoint.getArgs(); // 方法的参数
        if (annotations != null) {
            for (int i = 0; i < annotations.length; i++) {
                Annotation[] anno = annotations[i];
                for (int j = 0; j < anno.length; j++) {
                    if (annotations[i][j].annotationType().equals(
                            Valid.class)) {
                        try {
                            result = checkParam(args[i]);
                        } catch (Exception e) {
                            log.error(methodName + " valid failed : " + e);
                            throw new ActionException(999, "valid failed");
                        }

                        if (result != null) {
                            log.error(methodName + " valid failed");
                            throw new ActionException(result.getErrCode(), result.getDescription());
                        }
                    }
                }
            }
        }

        try {

        } catch (Throwable e) {
            log.error("valid failed : " + e);
            if(!(e instanceof  ActionException))
            {
                throw new ActionException(999, "valid failed");
            }
        }
    }

    /**
     * 校验参数
     *
     * @param args
     * @return
     * @throws Exception
     */
    private CheckParameterResult checkParam(Object args) throws Exception {
        Field[] field = args.getClass().getDeclaredFields();// 获取方法参数（实体）的field
        for (int j = 0; j < field.length; j++) {
            CheckRequestParameter check = field[j].getAnnotation(CheckRequestParameter.class);// 获取方法参数（实体）的field上的注解Check
            if (check != null) {
                CheckParameterResult result = validateFiled(check, field[j], args);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 校验参数规则
     *
     * @param check
     * @param field
     * @return
     * @throws Exception
     */
    public CheckParameterResult validateFiled(CheckRequestParameter check, Field field, Object args)
            throws Exception {
        field.setAccessible(true);
        // 获取field长度
        int length = 0;
        if (field.get(args) != null) {
            length = (String.valueOf(field.get(args))).length();
        }

        CheckParameterResult result = new CheckParameterResult();

        if(check.isAuthSuccess())
        {
            if(!"12345".equals(field.get(args)))
            {
                result.setErrCode(101);
                result.setDescription(field.getName() + " auth failed");
                return result;
            }
        }
        if (check.notNull()) {
            if (field.get(args) == null
                    || "".equals(String.valueOf(field.get(args)))) {
                result.setErrCode(102);
                result.setDescription(field.getName() + "不能为空");
                return result;
            }
        }
        if (check.maxLen() > 0 && (length > check.maxLen())) {
            result.setErrCode(102);
            result.setDescription(field.getName() + "长度不能大于" + check.maxLen());
            return result;
        }

        if (check.minLen() > 0 && (length < check.minLen())) {
            result.setErrCode(102);
            result.setDescription(field.getName() + "长度不能小于" + check.minLen());
            return result;
        }

        if (check.numeric() && field.get(args) != null) {
            try {
                new BigDecimal(String.valueOf(field.get(args)));
            } catch (Exception e) {
                result.setErrCode(102);
                result.setDescription(field.getName() + "必须为数值型");
                return result;
            }
        }
        if (check.minNum() != -999999) {
            try {
                long fieldValue = Long
                        .parseLong(String.valueOf(field.get(args)));
                if (fieldValue < check.minNum()) {
                    result.setErrCode(102);
                    result.setDescription(field.getName() + "必须不小于" + check.minNum());
                    return result;
                }
            } catch (Exception e) {
                result.setErrCode(102);
                result.setDescription(field.getName() + "必须为数值型，且不小于" + check.minNum());
                return result;
            }
        }
        return null;
    }

    /**
     * 根据类和方法名得到方法
     */
    @SuppressWarnings("rawtypes")
    public Method getMethodByClassAndName(Class c, String methodName)
            throws Exception {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }
}
