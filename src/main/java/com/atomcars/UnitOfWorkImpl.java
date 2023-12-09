package com.atomcars;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UnitOfWorkImpl implements UnitOfWork {

    private final EntityManager entityManager;

    public UnitOfWorkImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void begin() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            throw new IllegalStateException();
        }
        transaction.begin();
    }

    @Override
    public void save() {
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.dispose();
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }
}
