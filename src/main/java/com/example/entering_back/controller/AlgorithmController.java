package com.example.entering_back.controller;

import com.example.entering_back.Algorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AlgorithmController {

    @GetMapping("/use_algorithm")
    public ResponseEntity<String> useAlgorithm(@RequestParam String str) {
        try {
            String result = new Algorithm().middleElement(str);
            if (null != result) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (NumberFormatException exception) {
            return new ResponseEntity<>("Wrong numbers", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Should be exactly 3 arguments", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
