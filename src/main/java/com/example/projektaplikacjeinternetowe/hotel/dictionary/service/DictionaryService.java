package com.example.projektaplikacjeinternetowe.hotel.dictionary.service;

import com.example.projektaplikacjeinternetowe.hotel.country.dto.CountryDto;
import com.example.projektaplikacjeinternetowe.hotel.country.impl.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryService {

    private final CountryService countryService;

    @Cacheable("countries")
    public List<CountryDto> getAllCountries() {
        return countryService.getAll();
    }

    public List<CountryDto> fetchCountries() {
        return countryService.getAll();
    }
}
