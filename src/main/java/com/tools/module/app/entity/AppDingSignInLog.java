package com.tools.module.app.entity;

import com.tools.common.model.PageBean;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "app_ding_signIn_log")
public class AppDingSignInLog  extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer logId;


    private String username;


    private String address;


    private String state;


    private String logTime;
}
