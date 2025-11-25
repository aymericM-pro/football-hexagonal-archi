package com.app.footballapispring.core.mediator;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
