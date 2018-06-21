package com.lnminh.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode constraint) {
      coursePrefix = constraint.value();
   }

   public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
      boolean result = true;
      if(theCode!=null){
         result=theCode.startsWith(coursePrefix);
      }
      return result;
   }
}
