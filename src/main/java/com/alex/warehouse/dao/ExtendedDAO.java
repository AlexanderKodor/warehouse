package com.alex.warehouse.dao;

import java.util.List;

public interface ExtendedDAO<T> {
    public List<T> dynamicFilter(T t);
}
