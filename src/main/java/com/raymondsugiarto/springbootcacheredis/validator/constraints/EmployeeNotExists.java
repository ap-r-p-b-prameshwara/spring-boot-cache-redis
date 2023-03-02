package com.raymondsugiarto.springbootcacheredis.validator.constraints;

import com.raymondsugiarto.springbootcacheredis.validator.EmployeeNotExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = {EmployeeNotExistsValidator.class})
@Target({ TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeNotExists {
  /**
   *
   * @return String
   */
  String message() default "Employee already exists";

  /**
   *
   * @return class
   */
  Class<?>[] groups() default {};

  /**
   *
   * @return class
   */
  Class<? extends Payload>[] payload() default {};
}
