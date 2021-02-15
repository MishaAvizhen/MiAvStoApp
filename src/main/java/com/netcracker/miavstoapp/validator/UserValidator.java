package com.netcracker.miavstoapp.validator;

import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,  user.getUsername(), "Required");
        if (user.getUsername().length() < 1 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, user.getPhoneNumber(), "Required");
        if (user.getPhoneNumber().length() != 13) {
            errors.rejectValue("phoneNumber", "Format.userForm.phoneNumber");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, user.getEmail(), "Required");
        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
            errors.rejectValue("email", "Format.userForm.email");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, user.getPassword(), "Required");
        if (user.getPassword().length() < 1 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

//        if (!user.getConfirmPassword().equals(user.getPassword())) {
//            errors.rejectValue("confirmPassword", "Different.userForm.password");
//        }
    }
}