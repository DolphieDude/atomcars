package com.atomcars;

public interface UnitOfWork {
    void begin();

    void save();

    void dispose();

}
