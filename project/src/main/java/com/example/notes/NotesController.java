package com.example.notes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class NotesController {

    @Value("${API_KEY:}")
    private String apiKey;

    @Value("${app.greeting}")
    private String greeting;

    @GetMapping("/")
    public String greeting() {
        return greeting;
    }

    @GetMapping("/healthz")
    public String health() {
        return "OK";
    }

    @GetMapping("/notes")
    public List<String> notes() {
        return List.of(
            "Note 1",
            "Note 2",
            "Note 3"
        );
    }

    @GetMapping("/api")
    public String checkApi() {
        if (apiKey == null || apiKey.isBlank()) {
            return "API_KEY is missing";
        }
        return "API_KEY is present";
    }
    
}