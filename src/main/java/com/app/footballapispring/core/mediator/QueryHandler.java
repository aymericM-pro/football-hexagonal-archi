package com.app.footballapispring.core.mediator;

public interface QueryHandler<Q extends Query<R>, R>{
    R handle(Q query);
}
