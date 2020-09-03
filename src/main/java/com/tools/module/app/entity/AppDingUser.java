package com.tools.module.app.entity;

import com.tools.common.model.PageBean;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 蘑菇钉用户信息
 */
@Data
@Entity
@Table(name = "app_ding_user")
public class AppDingUser  extends PageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

}
