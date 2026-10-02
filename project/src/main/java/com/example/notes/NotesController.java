package com.example.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotesController {

    @GetMapping("/")
    public String greeting() {
        return "Hello";
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
}