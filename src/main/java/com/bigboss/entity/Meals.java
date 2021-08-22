package com.bigboss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_meals")
public class Meals implements Serializable {


    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String breakfast;

    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private Date createAt;

    private String dinner;

    private String lunch;

    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    @TableField("customer_id")
    private String customerId;

    @TableField("supper_meal")
    private String supperMeal;

    private BigDecimal weight;

    private String sport;


}
