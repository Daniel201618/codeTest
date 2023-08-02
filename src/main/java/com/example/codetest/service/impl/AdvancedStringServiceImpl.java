package com.example.codetest.service.impl;

import com.example.codetest.service.IStringArtifact;
import com.example.codetest.utils.ConsecutiveCharactersUtil;
import com.example.codetest.utils.Order;
import com.example.codetest.service.dto.OutputResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 高级字符串处理
 */
@Slf4j
@Service("AdvancedStringArtifact")
public class AdvancedStringServiceImpl implements IStringArtifact {

    public OutputResultDTO resolveStr(Order order, String input){
        log.info("AdvancedStringArtifact requireType: "+order.getRequireType());
        String output = ConsecutiveCharactersUtil.advancedLoopReplaceStr(input);
        OutputResultDTO result = new OutputResultDTO();
        result.setStatusCode("200");
        result.setStatus("success");
        result.setData(output);
        result.setMsg(order.getRequireType()+" Bean");
        return result;
    }

}
