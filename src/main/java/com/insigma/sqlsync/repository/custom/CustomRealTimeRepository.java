package com.insigma.sqlsync.repository.custom;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;

import java.util.List;

public interface CustomRealTimeRepository {
    List<RealTimeDataBean> dynamicQuery(RealTimeDataBean realTimeBean);

    List<RealTimeDataBean> dynamicQuery(String realTimeBean);

}
