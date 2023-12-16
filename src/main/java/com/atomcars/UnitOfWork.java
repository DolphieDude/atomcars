package com.atomcars;

public interface UnitOfWork {
    void begin();

    void save();

    void dispose();

    void registerNew(Object entity);

    void registerDirty(Object entity);

    void registerRemoved(Object entity);

}
