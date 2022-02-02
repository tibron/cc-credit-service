package org.tibron.cccrediteservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.tibron.cccrediteservice.domain.CreditInformationDTO;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CreditRestConctroller.class)
class CreditRestConctrollerTest {


    //mock service also when we have one =)

    @Autowired
    private MockMvc mockMvc;
    public static final String api = CreditRestConctroller.API;

    @Autowired
    ObjectMapper objectMapper; //needed for transformation to json


    @Test
    void testGetCreditInformation() throws Exception {
        mockMvc.perform(
                get(api+ UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void testCreateCretitInformation() throws Exception {

        CreditInformationDTO mmm = CreditInformationDTO.builder().credit_uuid(UUID.randomUUID()).credit_institution("MMM").credit_yearly_rate(BigDecimal.valueOf(0.25)).build();
        String request_and_responce = objectMapper.writeValueAsString(mmm);
        mockMvc.perform(
                post(api)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request_and_responce))
                .andExpect(content().json(request_and_responce))
                .andExpect(status().isNotAcceptable());
    }


    @Test
    void testUpdateCreditInformation() throws Exception{
        //uuid for url
        String url_id = UUID.randomUUID().toString();
        //sent object
        CreditInformationDTO fmfa = CreditInformationDTO.builder().credit_uuid(UUID.randomUUID()).credit_institution("Free money for all GmbH").credit_yearly_rate(BigDecimal.valueOf(0.00001)).build();
        String request_and_responce = objectMapper.writeValueAsString(fmfa);
        //prep complete
        mockMvc.perform(
                        put(api+url_id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request_and_responce))
                .andExpect(content().json(request_and_responce))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    void testDeleteCreditInformation() throws Exception{
        //uuid for url
        String url_id = UUID.randomUUID().toString();
        mockMvc.perform(
                delete(api+ UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }
}