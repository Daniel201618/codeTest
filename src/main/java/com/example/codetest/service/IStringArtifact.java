package com.example.codetest.service;

import com.example.codetest.utils.Order;
import com.example.codetest.service.dto.OutputResultDTO;

public interface IStringArtifact {
    public OutputResultDTO resolveStr(Order order, String inputWords);//int consecutiveLen, String inputWords

}
