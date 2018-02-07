package com.insigma.sqlsync.entity.listeners;

import com.insigma.sqlsync.entity.realtime.RealTimeDataBean;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class RealTimeListeners {


    @PrePersist
    public void touchForCreate(Object target) {
        if(target instanceof RealTimeDataBean){
            RealTimeDataBean rtb = (RealTimeDataBean)target;
            rtb.setAlarmLevel(32);
        }
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        System.out.println(target);
    }

    @PreRemove
    public void touchForRemove(Object target) {
        System.out.println(target);
    }
}
