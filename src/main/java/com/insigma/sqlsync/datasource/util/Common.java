package com.insigma.sqlsync.datasource.util;


/**
 * 数据源切换类，一般都不需要手动调度该方法
 * 如果顺利，已经在aop中全部完成了数据源切换工作
 * @author Sunset
 *
 */
public class Common {
	/**
	 * 根据station key 来切换数据源
	 * @param station
	 */
	public static boolean setDataSource(String station){
        if(ConfigStationInfoFactory.getKey().contains(station.substring(7))){
            DataSourceContextHolder.setDbType(station);
            return true;
        }else{
            return false;
        }
	}
	/**
	 * 根据stIsid 来切换数据源
	 * @param stIsid
	 */
	public static boolean setDataSourceById(String stIsid){
		System.out.println("切换数据源:"+stIsid);
		if(ConfigStationInfoFactory.getKey().contains(stIsid)){
            DataSourceContextHolder.setDbType("station"+stIsid);
            return true;
        }else{
            return false;
        }
	}
	public static String getDataSource(){
		return DataSourceContextHolder.getDbType();
	}
	/**
	 * 初始化到总站数据源，默认初始化为  targetDataSources 的第一个key
	 */
	public static void restoreRoot(){
		DataSourceContextHolder.restoreRoot();
	}
}
