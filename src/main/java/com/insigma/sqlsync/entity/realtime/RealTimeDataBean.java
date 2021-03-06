package com.insigma.sqlsync.entity.realtime;

import javax.persistence.*;

//@FilterDef(name = "filterByHotelCode", parameters = {
//        @ParamDef(name = "filterCode", type = "string")
//})
//@Filters({
//        @Filter(name = "filterByHotelCode", condition = "hotel_code like :filterCode")
//})
//@EntityListeners(RealTimeListeners.class)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tbrealtimedata")
//@DiscriminatorColumn(name = "tbrealtimedata")
public class RealTimeDataBean {
    @Id
//    @Column(unique = true,nullable=false,insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String tagIsid;

    private String codeValue;

    private Integer alarmFlag;

    private String updateTime;

    private Integer alarmLevel;

    private String dvTypeCode;


    public String getDvTypeCode() {
        return dvTypeCode;
    }

    public void setDvTypeCode(String dvTypeCode) {
        this.dvTypeCode = dvTypeCode;
    }

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
