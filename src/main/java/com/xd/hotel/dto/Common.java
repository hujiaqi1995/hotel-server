package com.xd.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiaqi on 2019/6/14 11:31 AM
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Common {
    private Integer code;

    private String msg;

    private Object data;

    public static final Integer SUCCESS = 200;

    public static final Integer FAILED = 500;

    private Common(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Common of(Integer code, String msg, Object data) {
        return new Common(code, msg, data);
    }

    public static Common of(Integer code, String msg) {
        return new Common(code, msg);
    }
}


