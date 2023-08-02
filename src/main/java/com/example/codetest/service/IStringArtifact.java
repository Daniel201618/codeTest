package com.example.codetest.service;

import com.example.codetest.utils.Order;
import com.example.codetest.response.OutputResultResponse;

public interface IStringArtifact {
    public OutputResultResponse resolveStr(Order order, String inputWords);//int consecutiveLen, String inputWords

}
