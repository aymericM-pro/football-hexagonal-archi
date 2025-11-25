package com.app.footballapispring.core.mediator;

import java.lang.reflect.ParameterizedType;

public final class HandlerUtils {

    public static Class<?> getCommandType(CommandHandler<?, ?> handler) {
        return (Class<?>) ((ParameterizedType)
                handler.getClass().getGenericInterfaces()[0]
        ).getActualTypeArguments()[0];
    }

    public static Class<?> getQueryType(QueryHandler<?, ?> handler) {
        return (Class<?>) ((ParameterizedType)
                handler.getClass().getGenericInterfaces()[0]
        ).getActualTypeArguments()[0];
    }
}
