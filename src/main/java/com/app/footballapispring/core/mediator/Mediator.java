package com.app.footballapispring.core.mediator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Mediator {

    private final Map<Class<?>, CommandHandler<?, ?>> commandHandlers = new HashMap<>();
    private final Map<Class<?>, QueryHandler<?, ?>> queryHandlers = new HashMap<>();

    public Mediator(
            List<CommandHandler<?, ?>> commandHandlersList,
            List<QueryHandler<?, ?>> queryHandlersList
    ) {
        // Construire la map basée sur la commande/querie manipulée
        for (CommandHandler<?, ?> handler : commandHandlersList) {
            Class<?> commandType = HandlerUtils.getCommandType(handler);
            this.commandHandlers.put(commandType, handler);
        }

        for (QueryHandler<?, ?> handler : queryHandlersList) {
            Class<?> queryType = HandlerUtils.getQueryType(handler);
            this.queryHandlers.put(queryType, handler);
        }
    }

    @SuppressWarnings("unchecked")
    public <R, C extends Command<R>> R send(C command) {
        CommandHandler<C, R> handler =
                (CommandHandler<C, R>) commandHandlers.get(command.getClass());

        if (handler == null)
            throw new IllegalArgumentException("No handler found for command: " + command.getClass());

        return handler.handle(command);
    }

    @SuppressWarnings("unchecked")
    public <R, Q extends Query<R>> R send(Q query) {
        QueryHandler<Q, R> handler =
                (QueryHandler<Q, R>) queryHandlers.get(query.getClass());

        if (handler == null)
            throw new IllegalArgumentException("No handler found for query: " + query.getClass());

        return handler.handle(query);
    }
}

