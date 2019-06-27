package com.exxeta.interceptors;


import lombok.extern.java.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Perfomance
@Interceptor
@Log
public class PerformanceInterceptor {

    public static final int THRESHOLD = 1;

    @AroundInvoke
    public Object measureTime(InvocationContext ic) throws Throwable {
        Instant start = Instant.now();
        Object result = ic.proceed();
        long elapsedTime = ChronoUnit.NANOS.between(start, Instant.now());
        if(elapsedTime > THRESHOLD) {
            String classname = ic.getTarget().getClass().getName();
            String methodname = ic.getMethod().getName();
            String parameters = Arrays.toString(ic.getParameters());
            String msg = new StringBuilder().append("PERFORMANCE ALERT: ").append(classname).append(".").append(methodname).append("(").append(parameters).append("), duration: ").append(elapsedTime).append(" ms").toString();
            log.warning(msg);
        }

        return result;

    }

}
