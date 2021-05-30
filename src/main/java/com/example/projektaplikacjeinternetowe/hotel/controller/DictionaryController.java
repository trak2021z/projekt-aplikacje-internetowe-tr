package com.example.projektaplikacjeinternetowe.hotel.controller;

import com.example.projektaplikacjeinternetowe.hotel.dictionary.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/dictionaries")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping("/countries")
    public ResponseEntity getCountries() {
        return ResponseEntity.ok(dictionaryService.getAllCountries());
    }

    @GetMapping("/countries-no-cache")
    public ResponseEntity getCountriesWithoutCache() {
        return ResponseEntity.ok(dictionaryService.fetchCountries());
    }
}
