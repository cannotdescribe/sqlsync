package com.insigma.sqlsync.service;

import com.insigma.sqlsync.datasource.util.CommonRock;
import com.insigma.sqlsync.datasource.util.DataSourceEntity;
import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;
import com.insigma.sqlsync.repository.RealTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealTimeService {
    @Autowired
    private RealTimeRepository realTimeRespository;

    public void initRealtime(){
        List<RealTimeDataBean> realTimeBeans = new ArrayList<RealTimeDataBean>();

        List<DataSourceEntity> children = CommonRock.getDataSourceEntityList();
        for(DataSourceEntity dataSourceEntity : children){
            dataSourceEntity.active();
//            realTimeBeans.addAll(realTimeRespository.dynamicQuery(realTimeBean));
//            List<RealTimeDataBean> result = SystemInfoUtils.getRealTime();
//            for(RealTimeDataBean realTimeDataBean : result){
                realTimeBeans.addAll(realTimeRespository.find(new RealTimeDataBean()));
//            }
        }
        CommonRock.restoreRoot();
        realTimeRespository.saveAll(realTimeBeans);
    }
}
