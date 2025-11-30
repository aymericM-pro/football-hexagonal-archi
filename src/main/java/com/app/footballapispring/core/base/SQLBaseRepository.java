package com.app.footballapispring.core.base;

import jakarta.persistence.EntityManager;

import java.util.Optional;

public abstract class SQLBaseRepository<T> implements BaseRepository<T> {

    protected final EntityManager entityManager;

    SQLBaseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findById(Object id) {
        return Optional.ofNullable(
                entityManager.find(getEntityClass(), id)
        );
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void clear() {
        entityManager.createQuery("DELETE FROM " + getEntityClass().getSimpleName())
                .executeUpdate();
    }

    public abstract Class<T> getEntityClass();
}
