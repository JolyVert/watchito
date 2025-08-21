package com.jolyvert.watchito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public ResponseEntity<String> getPage(Model model) {
        return ResponseEntity.ok("hello");
    }
}
