package com.example.projektaplikacjeinternetowe.hotel.address.impl;

import com.example.projektaplikacjeinternetowe.hotel.address.dto.AddressDto;
import com.example.projektaplikacjeinternetowe.hotel.address.entity.AddressEntity;
import com.example.projektaplikacjeinternetowe.hotel.country.impl.CountryMapper;

public class AddressMapper {

    private final CountryMapper countryMapper;

    public AddressMapper() {
        this.countryMapper = new CountryMapper();
    }

    public AddressDto mapToDto(AddressEntity entity) {
        var address = new AddressDto();
        address.setId(entity.getId());
        address.setCity(entity.getCity());
        address.setHouseNumber(entity.getHouseNumber());
        address.setPostcode(entity.getPostcode());
        address.setLocalNumber(entity.getLocalNumber());
        address.setCountry(countryMapper.mapToDto(entity.getCountry()));
        return address;
    }
}
