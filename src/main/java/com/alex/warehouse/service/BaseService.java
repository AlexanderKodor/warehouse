package com.alex.warehouse.service;

import java.util.List;

public interface BaseService<T> {
    public List<T> getAllEntity();

    public T saveEntity(T t);

    public T getEntity(int id);

    public void deleteEntity(int id);
}
