package com.bigboss.controller;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "build")
public class BaseResult {

    @NonNull
    private Integer code;

    @NonNull
    private String message;

    public static BaseResult success(Integer code, String message) {
        return BaseResult.build(code, message);
    }

    public static BaseResult failure(Integer code, String message) {
        return BaseResult.build(code, message);
    }
}
