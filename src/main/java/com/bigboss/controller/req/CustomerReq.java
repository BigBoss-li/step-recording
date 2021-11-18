package com.bigboss.controller.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class CustomerReq {

    @JSONField(name = "contact_id")
    private String contactId;

    @JSONField(name = "start_data")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
}
