package com.insigma.sqlsync.datasource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.List;

public class DataSourceInfoUtils {
    private static Document document ;
    public final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    static{
        SAXReader reader = new SAXReader();
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource("classpath:config/sqlConfig.xml");
            document = reader.read(resource.getFile());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Element getRoot(){
        return document.getRootElement();
    }

    public static Element getDataSourcesElement(){
        return getRoot().element("dataSources");
    }


    public static List<Element> getDataSources(){
        return getDataSourcesElement().elements("dataSource");
    }

    public static String getUrl(Element dataSource){
        String ip = dataSource.element("ip").getText();
        String dbName = dataSource.element("dbName").getText();
        return getUrl(ip, dbName);
    }

    public static String getUrl(String ip, String dbName){
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://");
        sb.append(ip);
        sb.append("/");
        sb.append(dbName);
        sb.append("?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        return sb.toString();
    }

    public static String getPassword(Element dataSource){
        return dataSource.element("password").getText();
    }
    public static String getUsername(Element dataSource){
        return dataSource.element("username").getText();
    }
    public static String getStation(Element dataSource){
        return dataSource.element("station").getText();
    }
    public static String getPlusKey(Element dataSource){
        return dataSource.element("key").getText();
    }
    public static String getKey(Element dataSource){
        return dataSource.element("key").getText();
    }

    public static Element getDataSourcePlusElement(){
        return getRoot().element("dataSourcePlus");
    }

    public static List<Element> getDataSourcePlusses(){
        Element dataSourcePlus = getDataSourcePlusElement();
        if(dataSourcePlus == null){
            return null;
        }else{
            return dataSourcePlus.elements("dataSource");
        }
    }
}
