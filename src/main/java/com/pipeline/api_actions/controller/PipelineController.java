package com.pipeline.api_actions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController {

    @GetMapping({"/", "/status", "/api/status"})
    public String getStatus() {
        return "Projeto GitHub Actions - V1: API ativa e operando com sucesso!";
    }
}
