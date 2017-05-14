package ssm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckRequestParameterValidator implements ConstraintValidator<CheckRequestParameter, Long> {

	@Override
	public void initialize(CheckRequestParameter arg0) {
		
	}

	@Override
	public boolean isValid(Long vaule, ConstraintValidatorContext context) {
		if(vaule==999){
			return false;
		}else{
			return true;
		}
	}



}
