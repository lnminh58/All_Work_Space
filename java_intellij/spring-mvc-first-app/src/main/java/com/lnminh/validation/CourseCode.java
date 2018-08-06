package com.lnminh.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//    Define default course code
    public  String value() default "LUV";
//    Define default error message
    public String message() default "Must start with LUV";

//    Define default groups
    public Class<?>[] groups() default {};
    /* Define default payloads */
    public Class <? extends Payload>[] payload() default {};
}
