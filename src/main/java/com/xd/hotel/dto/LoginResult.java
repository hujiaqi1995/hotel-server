package com.xd.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jiaqi on 2019/6/18 5:45 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {
    private boolean status;

    private String token;

    private String meuns;
}
