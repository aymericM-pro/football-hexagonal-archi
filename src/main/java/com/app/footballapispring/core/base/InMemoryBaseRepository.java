package com.app.footballapispring.core.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class InMemoryBaseRepository<T, ID> implements BaseRepository<T> {

    protected final Map<ID, T> store = new HashMap<>();

    protected abstract ID extractId(T entity);

    @Override
    public Optional<T> findById(Object id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public T save(T entity) {
        store.put(extractId(entity), entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        store.remove(extractId(entity));
    }

    @Override
    public void clear() {
        store.clear();
    }
}
