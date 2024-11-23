package com.example.entering_back.service;

import com.example.entering_back.util.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmService {

    public String useAlgorithm(String str) {
        return new Algorithm().middleElement(str);
    }

}
