package com.insigma.sqlsync.spring.init;

import com.insigma.sqlsync.config.DataSourceInfoUtils;
import com.insigma.sqlsync.datasource.util.CommonRock;
import com.insigma.sqlsync.datasource.util.DataSourceEntity;
import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.RealTimeRepository;
import org.dom4j.Element;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CommonRockInitializeBean implements InitializingBean {

    @Autowired
    private RealTimeRepository realTimeRepository;

    public void childrenInit(){
        List<DataSourceEntity> dataSourceEntityList = CommonRock.getDataSourceEntityList();
        for(DataSourceEntity dataSourceEntity : dataSourceEntityList){
            dataSourceEntity.active();
            realTimeRepository.save(new RealTimeDataBean());
        }
        CommonRock.restoreRoot();
    }

    public void initDataSourceConfig(){
        List<Element> dataSourceElements = DataSourceInfoUtils.getDataSources();
        List<DataSourceEntity> dataSourceEntityList = new ArrayList<DataSourceEntity>();
        DataSourceEntity rootDataSourceEntity = null;
        for(int i=0;i<dataSourceElements.size();i++){
            Element dataSourceElement = dataSourceElements.get(i);
            String keyName = DataSourceInfoUtils.getKey(dataSourceElement);

            if(i==0){
                rootDataSourceEntity = new DataSourceEntity();
                rootDataSourceEntity.setKey(keyName);
            }else{
                DataSourceEntity dataSourceEntity = new DataSourceEntity();
                dataSourceEntity.setKey(keyName);
                dataSourceEntityList.add(dataSourceEntity);
            }
        }
        CommonRock.setDataSourceEntityList(dataSourceEntityList);

        CommonRock.setRootDataSourceEntity(rootDataSourceEntity);
    }
    @Override
    public void afterPropertiesSet() throws Exception {

        initDataSourceConfig();

    }
}
