package com.example.codetest.response;

import lombok.Data;

/**
 * 输出结果
 */
@Data
public class OutputResultResponse {

    private String status;
    private String msg;
    private String statusCode;
    private String data;


}
