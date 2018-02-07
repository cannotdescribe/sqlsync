package com.insigma.sqlsync.repository.util;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;

public class TableNameUtils {
    private static String getDvTypeCodeByClassName(RealTimeDataBean realTimeDataBean){
        String simpleClassName = realTimeDataBean.getClass().getSimpleName();
        return simpleClassName.substring(0, simpleClassName.indexOf("RealTimeDataBean"));
    }
    public static String getTable(RealTimeDataBean realTimeBean){
        String dvTypeCode = getDvTypeCodeByClassName(realTimeBean);
        if("".equals(dvTypeCode)){
            dvTypeCode = realTimeBean.getDvTypeCode();
        }
        return getTable(dvTypeCode);
    }

    public static String getTable(String dvTypeCode){
        return "tb"+(dvTypeCode==null?"":dvTypeCode)+"realtimedata";
    }

    public static void main(String[] args) {
        String dv = getDvTypeCodeByClassName(new RealTimeDataBean());
        System.out.println(dv.equals(""));
    }
}
