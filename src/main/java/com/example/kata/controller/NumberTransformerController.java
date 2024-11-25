
package com.example.kata.controller;

import com.example.kata.service.NumberConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${frontend.origin.url}")
@AllArgsConstructor
public class NumberTransformerController {

    private final NumberConverterService numberConverterService;

    @GetMapping("/convert")
    public ResponseEntity<String> convertNumber(@RequestParam int number) {
        try {
            String result = numberConverterService.convertNumber(number);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
