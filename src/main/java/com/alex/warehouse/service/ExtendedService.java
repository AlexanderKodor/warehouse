package com.alex.warehouse.service;

import java.util.List;

public interface ExtendedService<T> {
    public List<T> dynamicFilter(T t);
}
