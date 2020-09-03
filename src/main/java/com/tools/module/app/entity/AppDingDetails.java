package com.tools.module.app.entity;


import com.tools.common.model.PageBean;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.GregorianCalendar;

@Data
@Entity
@Table(name = "app_ding_details")
public class AppDingDetails  extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Id
    private Integer userId;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 城市
     */
    @Column(name = "city")
    private String city;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;

    /**
     * 发表的信息
     */
    @Column(name = "description")
    private String description;

    /**
     * START  上班  END 下班
     */
    @Column(name = "type")
    private String type;

    /**
     * 经度
     */
    private String longitude;

    public AppDingDetails() {
        //  结果为“0”是上午 结果为“1”是下午
        GregorianCalendar ca = new GregorianCalendar();
        if (ca.get(GregorianCalendar.AM_PM) == 0 || "0".equals(ca.get(GregorianCalendar.AM_PM))) {
            this.type = "START";
        } else {
            this.type = "END";
        }
    }
}