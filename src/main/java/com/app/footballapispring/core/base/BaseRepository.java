package com.app.footballapispring.core.base;

import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Object id);
    T save(T entity);
    void delete(T entity);
    void clear();
}
