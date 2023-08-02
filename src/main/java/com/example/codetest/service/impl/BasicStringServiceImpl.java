package com.example.codetest.service.impl;

import com.example.codetest.service.IStringArtifact;
import com.example.codetest.utils.ConsecutiveCharactersUtil;
import com.example.codetest.utils.Order;
import com.example.codetest.service.dto.OutputResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 基本字符串处理
 */
@Service("BasicStringArtifact")
@Slf4j
public class BasicStringServiceImpl implements IStringArtifact {

    @Override
    public OutputResultDTO resolveStr(Order order, String input){
        log.info("BasicStringArtifact requireType: "+order.getRequireType());
        String replaceStr ="";
        String output = ConsecutiveCharactersUtil.loopReplaceStr(input,replaceStr);
        OutputResultDTO result = new OutputResultDTO();
        result.setStatusCode("200");
        result.setStatus("success");
        result.setData(output);
        result.setMsg(order.getRequireType()+" Bean");
        return result;
    }



}
