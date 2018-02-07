package com.insigma.sqlsync.datasource.util;

import java.util.List;

public class CommonRock {
    private static List<DataSourceEntity> dataSourceEntityList;

    private static DataSourceEntity rootDataSourceEntity;

    public static void setRootDataSourceEntity(DataSourceEntity dataSourceEntity){
        CommonRock.rootDataSourceEntity = dataSourceEntity;
    }

    public static DataSourceEntity getRootDataSourceEntity(){
        return CommonRock.rootDataSourceEntity ;
    }

    public static void setDataSourceEntityList(List<DataSourceEntity> dataSourceEntityList){
        CommonRock.dataSourceEntityList = dataSourceEntityList;
    }

    public static List<DataSourceEntity> getDataSourceEntityList(){
        return CommonRock.dataSourceEntityList;
    }

    public static void restoreRoot(){
        Common.restoreRoot();
    }

}

