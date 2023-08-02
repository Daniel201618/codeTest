package com.example.codetest;

import com.example.codetest.controller.StringArtifactController;
import com.example.codetest.entity.StringArtifact;
import com.example.codetest.service.dto.OutputResultDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StringArtifactControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;


    @Before
    public void setUp () throws Exception{
        log.debug("StringArtifactControllerTests test started.");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void testStringArtifactController() throws Exception {
        OutputResultDTO outputResultDTO = new OutputResultDTO();
        StringArtifact strArtifact = new StringArtifact();
        strArtifact.setInput("aabcccbbad");
        strArtifact.setRequireType("BasicStringArtifact");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/StringArtifact/resolvedStr")
                .content(mapper.writeValueAsString(strArtifact))
                .contentType(MediaType.APPLICATION_JSON);


        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void testStringArtifactController2() throws Exception {
        OutputResultDTO outputResultDTO = new OutputResultDTO();
        StringArtifact strArtifact = new StringArtifact();
        strArtifact.setInput("aabcccbbad");
        strArtifact.setRequireType("AdvancedStringArtifact");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/StringArtifact/resolvedStr")
                .content(mapper.writeValueAsString(strArtifact))
                .contentType(MediaType.APPLICATION_JSON);


        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

}
