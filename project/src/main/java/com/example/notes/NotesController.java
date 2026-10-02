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
    public int health() {
        return 200;
    }

    @GetMapping("/notes")
    public List<String> notes() {
        return List.of(
            "Task 1",
            "Task 2",
            "Task 3"
        );
    }
}