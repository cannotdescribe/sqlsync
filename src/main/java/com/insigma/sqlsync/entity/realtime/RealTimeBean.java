package com.insigma.sqlsync.entity.realtime;

import com.insigma.sqlsync.entity.BaseBean;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Entity
@FilterDef(name = "filterByHotelCode", parameters = {
        @ParamDef(name = "filterCode", type = "string")
})
@Filters({
        @Filter(name = "filterByHotelCode", condition = "hotel_code like :filterCode")
})
@Table(name = "tbrealtimedata")
public class RealTimeBean extends BaseBean {
    private Long id;

    private String tagIsid;

    private String codeValue;

    private Integer alarmFlag;

    private String updateTime;

    private Integer alarmLevel;

    @Id
    @Column(unique = true,nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagIsid() {
        return tagIsid;
    }

    public void setTagIsid(String tagIsid) {
        this.tagIsid = tagIsid;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Integer getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(Integer alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
}
