package com.example.projektaplikacjeinternetowe.hotel.country.impl;

import com.example.projektaplikacjeinternetowe.hotel.country.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
        this.mapper = new CountryMapper();
    }

    public List<CountryDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
}
