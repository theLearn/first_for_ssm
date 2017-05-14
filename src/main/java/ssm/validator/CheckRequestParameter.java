package ssm.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 自定义validator标签(和 hibernate validator组合使用)
 * 
 * @author hongcheng
 *
 */
//@Constraint(validatedBy = CheckRequestParameterValidator.class) // 具体的实现
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
//@Documented
public @interface CheckRequestParameter {

//	// 提示信息,可以写死,可以填写国际化的key
//	String message() default "999";
//
//	// 下面这两个属性必须添加
//	Class<?>[] groups() default {};
//
//	Class<? extends Payload>[] payload() default {};

	/**
	 * 鉴权是否成功
	 */
	public boolean isAuthSuccess() default false;

	/**
	 * 是否非空
	 */
	public boolean notNull() default false;

	/**
	 * 是否为数值
	 */
	public boolean numeric() default false;

	/**
	 * 最大长度
	 */
	public int maxLen() default -1;

	/**
	 * 最小长度
	 */
	public int minLen() default -1;

	/**
	 * 最小数值
	 */
	public long minNum() default -999999;
}
