package com.app.footballapispring.core.mediator;

import org.springframework.aop.support.AopUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class HandlerUtils {

    public static Class<?> getCommandType(CommandHandler<?, ?> handler) {
        return extractGenericType(handler, CommandHandler.class, 0);
    }

    public static Class<?> getQueryType(QueryHandler<?, ?> handler) {
        return extractGenericType(handler, QueryHandler.class, 0);
    }

    private static Class<?> extractGenericType(
            Object handler,
            Class<?> handlerInterface,
            int index
    ) {
        Class<?> targetClass = AopUtils.getTargetClass(handler);

        for (Type type : targetClass.getGenericInterfaces()) {
            if (type instanceof ParameterizedType param) {
                if (param.getRawType().equals(handlerInterface)) {
                    return (Class<?>) param.getActualTypeArguments()[index];
                }
            }
        }

        throw new IllegalStateException(
                "Cannot resolve generic type for handler: " + targetClass.getName()
        );
    }
}
