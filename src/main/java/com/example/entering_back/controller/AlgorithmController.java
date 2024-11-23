package com.example.entering_back.controller;

import com.example.entering_back.exception.WrongNumberOfArgumentsException;
import com.example.entering_back.service.AlgorithmService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AlgorithmController {

    private final AlgorithmService algorithmService;

    public AlgorithmController(AlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
    }

    @GetMapping("/use_algorithm")
    public ResponseEntity<String> useAlgorithm(@RequestParam String str) {
        String result = algorithmService.useAlgorithm(str);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler({WrongNumberOfArgumentsException.class, NumberFormatException.class})
    public ResponseEntity<String> handleExceptions(HttpServletRequest req, Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
