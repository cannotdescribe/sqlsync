package com.insigma.sqlsync.repository.custom;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;

import java.util.List;

public interface CustomRealTimeRepository {
    List<RealTimeDataBean> find(RealTimeDataBean realTimeDataBean);

}
