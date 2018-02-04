package com.insigma.sqlsync.datasource.util;

import com.insigma.sqlsync.entity.SqlTableBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ConfigStationInfoFactory {
    private static Map<String, SqlTableBean> store = new HashMap<String, SqlTableBean>();

    public static void put(String stIsid, SqlTableBean sqlTableBean){
        store.put(stIsid, sqlTableBean);
    }
    public static SqlTableBean get(String stIsid){
        return store.get(stIsid);
    }

    public static void put(String stIsid, DriverManagerDataSource driverManagerDataSource){
        SqlTableBean sqlTableBean = new SqlTableBean();
        sqlTableBean.setUsername(driverManagerDataSource.getUsername());
        sqlTableBean.setPassword(driverManagerDataSource.getPassword());
        String url = driverManagerDataSource.getUrl();
        sqlTableBean.setIp(StationDbInfoUtil.getIp(url));
        sqlTableBean.setDbName(StationDbInfoUtil.getSqlName(url));
        put(stIsid, sqlTableBean);
    }

    public static Set<String> getKey(){
        return store.keySet();
    }
}
