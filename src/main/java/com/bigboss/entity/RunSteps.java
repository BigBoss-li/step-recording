package com.bigboss.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author bigboss
 * @since 2021-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_run_steps")
public class RunSteps implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long date;

    @TableField("steps_count")
    private Integer stepsCount;

    @TableField("customer_id")
    private String customerId;


}
