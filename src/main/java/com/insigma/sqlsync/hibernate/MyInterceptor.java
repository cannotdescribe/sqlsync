package com.insigma.sqlsync.hibernate;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;

import java.io.Serializable;

public class MyInterceptor extends EmptyInterceptor {
    @Override
    public Object getEntity(String entityName, Serializable id) {
        return null;
    }
}
