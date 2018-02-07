package com.insigma.sqlsync.datasource.util;

public class DataSourceEntity {
    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    public void active(){
        Common.setDataSource(key);
    }
}
