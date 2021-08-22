package com.bigboss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author bigboss
 * @since 2021-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_customer")
public class Customer implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String avatar;

    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private Date createAt;

    private Integer gender;

    @TableField("last_login_at")
    private Date lastLoginAt;

    private String mobile;

    private String name;

    @TableField("open_id")
    private String openId;

    @TableField("session_key")
    private String sessionKey;

    @TableField("union_id")
    private String unionId;

    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    @TableField("user_id")
    private String userId;


}
