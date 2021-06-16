package com.example.projektaplikacjeinternetowe.hotel.address.dto;

import com.example.projektaplikacjeinternetowe.hotel.commons.dto.AbstractDto;
import com.example.projektaplikacjeinternetowe.hotel.country.dto.CountryDto;
import com.example.projektaplikacjeinternetowe.hotel.country.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto extends AbstractDto<Long> {

    private String city;

    private CountryDto country;

    private String street;

    private String postcode;

    private String houseNumber;

    private String localNumber;
}
