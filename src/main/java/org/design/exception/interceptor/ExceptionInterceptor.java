package org.design.exception.interceptor;

import jakarta.annotation.Priority;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;
import org.design.entity.ExceptionEntity;

@ExceptionLogger
@Interceptor
@Priority(10)
@Slf4j
public class ExceptionInterceptor {

    @Inject
    Event<ExceptionEntity> listener;

    @AroundInvoke
    Object log(InvocationContext context) {
        try {
            return context.proceed();
        } catch (Exception exception) {
            log.info("Exception occurred : ", exception);
            createException(exception);
        }
        return null;
    }

    private void createException(Exception exception) {
        ExceptionEntity entity = ExceptionEntity.builder()
                .exceptionName("SERVER_ERROR")
                .cause(exception.toString()).build();
        listener.fire(entity);
    }
}
