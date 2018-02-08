package com.insigma.sqlsync.datasource;

import com.insigma.sqlsync.datasource.util.DataSourceContextHolder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DynamicDataSource extends AbstractRoutingDataSource{
	private Map<Object, Object> targetDataSources;

	private String defaultDataSourceKeyName;

	@Override
	protected Object determineCurrentLookupKey(){
		String key = DataSourceContextHolder.getDbType();
		if(DataSourceContextHolder.getBlnManual()){
            if(!targetDataSources.containsKey(key)){
				try {
					throw new Exception("数据源"+key+"不存在!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        }
		System.out.println("获得数据源: "+key);
		return key;
	}
	
	/*
	private void getConnectionInfo(Map<Object, Object> targetDataSources){
		DriverManagerDataSource dmds = (DriverManagerDataSource)targetDataSources.get("station");
		Connection conn = null;
		Statement stmt = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = dmds.getConnection();
			String sql = "select sqlUrl, sqlKeyName, sqlUsername, sqlPassword from tbstationinfo ";
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			int size = 0;
			while (resultSet.next()){
				DriverManagerDataSource dataSourceBean = new DriverManagerDataSource();
				dataSourceBean.setDriverClassName("com.mysql.jdbc.Driver");
				String sqlKeyName = resultSet.getString(2);
				String url = "jdbc:mysql://"+resultSet.getString(1)+"/"+sqlKeyName+"?useUnicode=true&amp;characterEncoding=utf-8";
				dataSourceBean.setUrl(url);
				dataSourceBean.setUsername(resultSet.getString(3));
				dataSourceBean.setPassword(resultSet.getString(4));
				if(size!=0){
					targetDataSources.put(sqlKeyName, dataSourceBean);
				}
				
				size++;
			};
			if(size==1){
				System.out.println("你创的为单一的站点，不存在任何关联;");
			}else{
				System.out.println("你创建的是区域。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	};
	*/
	public Map<Object, Object> getAllTargetDataSources(){
		return targetDataSources;
	}

	public Map<Object, Object> getTargetDataSources(){
//		ConfigStationInfoFactory.getKey().contains(station.substring(7))
        Map<Object, Object> result = new HashMap<Object, Object>();
        for(Entry<Object, Object> e :targetDataSources.entrySet()){
			if(((String)e.getKey()).indexOf("station")!=-1){
				result.put(e.getKey(), e.getValue());
			}
        }
		return result;
	}
	
	public void setDefaultTargetDataSource(DriverManagerDataSource defaultTargetDataSource, String keyName) {
        this.defaultDataSourceKeyName = keyName;
		super.setDefaultTargetDataSource(defaultTargetDataSource);
	}
	public String getDefaultTargetDataSourceKeyName() {
        return this.defaultDataSourceKeyName;
	}
	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		this.targetDataSources = targetDataSources;
		Set<Entry<Object, Object>> targetDataSourceSets = targetDataSources.entrySet();
		Iterator<Entry<Object, Object>> iter = targetDataSourceSets.iterator();
		int i=0;
		if(iter.hasNext()){
			Entry<Object, Object> targetDataSource = iter.next();
			DriverManagerDataSource dmds = (DriverManagerDataSource)targetDataSource.getValue();
			Connection conn = null;
			try {
				conn = dmds.getConnection();
				if(conn==null){
					iter.remove(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
				iter.remove();
			}
		}
		super.setTargetDataSources(targetDataSources);
	}
}


