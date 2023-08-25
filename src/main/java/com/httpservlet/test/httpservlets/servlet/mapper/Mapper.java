package com.httpservlet.test.httpservlets.servlet.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
    
}
