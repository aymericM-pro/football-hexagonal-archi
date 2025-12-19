package com.app.footballapispring.core.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Object id);
    void delete(T entity);
    void clear();
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
}

