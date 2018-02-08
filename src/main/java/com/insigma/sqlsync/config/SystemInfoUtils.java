package com.insigma.sqlsync.config;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SystemInfoUtils {
    private static Document document ;
    public final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    static{
        SAXReader reader = new SAXReader();
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource("classpath:config/system.xml");
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

    public static List<RealTimeDataBean> getRealTime(){
        List<RealTimeDataBean> result = new ArrayList<>();
        Element e = getRoot().element("dvTypeCodes");
        if(e == null){
            return result;
        }else{
            List<Element> se = e.elements("key");
            for(Element s: se){
                String clazzStr = s.attribute("realtimeClass").getText();
                try {
                    Class<?> clazz = Class.forName(clazzStr);
                    result.add((RealTimeDataBean)clazz.newInstance());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

}
