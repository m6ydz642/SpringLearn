package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator{

	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public RegisterRequestValidator() { // 기본생성자로 pattern값 지정
		pattern = Pattern.compile(emailRegExp);
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		if (regReq.getEmail() == null | regReq.getEmail().trim().isEmpty() ) {
			errors.rejectValue("email", "required"); // label.properties랑 연동되는 항목임
			// required가 에러키 임
		}else{
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad"); // label.properties랑 연동되는 항목임
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if(!regReq.getPassword().isEmpty()) {
			if(!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
		
	}
	

}
