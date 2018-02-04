package com.insigma.sqlsync.datasource.util;

public class StationDbInfoUtil {
    public static String getSqlName(String url) {
        return url.substring(url.lastIndexOf("/")+1, url.indexOf("?"));
    }
    public static String getIp(String url) {
        Integer index = url.indexOf("//")+2;
        Integer last = url.indexOf("/", index);
        return url.substring(index, last);
    }
}
