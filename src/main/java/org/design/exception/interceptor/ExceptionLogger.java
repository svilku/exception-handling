package org.design.exception.interceptor;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@InterceptorBinding
public @interface ExceptionLogger {
}
