package com.example.projektaplikacjeinternetowe.hotel.country.impl;

import com.example.projektaplikacjeinternetowe.hotel.country.dto.CountryDto;
import com.example.projektaplikacjeinternetowe.hotel.country.entity.CountryEntity;

public class CountryMapper {

    public CountryDto mapToDto(CountryEntity countryEntity) {
        var dto = new CountryDto();
        dto.setName(countryEntity.getName());
        dto.setId(countryEntity.getId());
        return dto;
    }
}
