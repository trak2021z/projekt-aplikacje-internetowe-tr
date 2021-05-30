package com.example.projektaplikacjeinternetowe.hotel.country.dto;

import com.example.projektaplikacjeinternetowe.hotel.commons.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto extends AbstractDto<Long> {

    private String name;
}
