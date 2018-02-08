package com.insigma.sqlsync.datasource.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 该方法为系统初始化所使用的静态方法
 * 如果没看懂这套程序，请勿调度该类的任何静态方法。
 * 请使用com.insigma.monitor.utils.Common
 * @author Sunset
 * 
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); //无用户时候切换数据源  
	
	private static boolean flag = false;

	private static boolean blnManual = false;
	
	private static Map<Long, String> dataSourceStore = null; // 存在用户信息时切换
	
	private static String rootStation;
	
	static{
		dataSourceStore = Collections.synchronizedMap(new HashMap<Long, String>());
	}
	/**
	 * 系统初始化时会调度这个方法来初始化总站的key
	 * 请勿自己去初始化该方法。
	 * @param root
	 */
	public static void setRoot(String root){
		rootStation = root;
	}

	public static String getRoot(){
		return rootStation;
	}
	
	public static void restoreRoot(){
		setDbType(rootStation);
	}
	
	public static void initOver(){
		flag = true;
	}
    public static void manualInit(){
        blnManual = true;
    }
    public static boolean getBlnManual(){
        return blnManual;
    }
    public static void setDbType(String dbType) {
    	if(flag){
    		/*
    		String userId = SessionUtils.getUserId();
    		*/
    		Long id = Thread.currentThread().getId();
    		dataSourceStore.put(id, dbType);
    	}else{
    		contextHolder.set(dbType);
    	}
    }
  
    public static String getDbType() {
    	if(flag){
    		/*
    		String userId = SessionUtils.getUserId();
    		*/
    		Long id = Thread.currentThread().getId();
    		String dataSource = dataSourceStore.get(id);
    		if(dataSource==null){
    			return rootStation;
    		}else{
    			return dataSource;
    		}
    	}else{
            System.out.println("奇怪:"+ contextHolder.get());
            return contextHolder.get();
    	}
    }

    public static void clearDbType() {  
    	dataSourceStore.clear();
    	contextHolder.remove();
    }  

}
