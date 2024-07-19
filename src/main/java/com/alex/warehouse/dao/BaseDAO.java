package com.alex.warehouse.dao;

import java.util.List;

public interface BaseDAO<T> {
    public List<T> getAllEntity();

    public T saveEntity(T t);

    public T getEntity(int id);

    public void deleteEntity(int id);
}
