package com.exxeta.interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
@Inherited
public @interface Perfomance {}
