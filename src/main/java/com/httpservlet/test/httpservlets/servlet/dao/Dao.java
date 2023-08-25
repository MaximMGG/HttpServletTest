package com.httpservlet.test.httpservlets.servlet.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, K> {
    
    List<K> findAl();

    Optional<K> finndById(T t);

    boolean delete(T t);

    void update(K k);

    K save(K k);
}
