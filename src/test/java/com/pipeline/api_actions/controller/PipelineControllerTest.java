package com.pipeline.api_actions.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PipelineControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new PipelineController()).build();
    }

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Projeto GitHub Actions - V1: API ativa e operando com sucesso!"));
    }

    @Test
    void shouldReturnStatusMessage() throws Exception {
        mockMvc.perform(get("/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("Projeto GitHub Actions - V1: API ativa e operando com sucesso!"));
    }
}
