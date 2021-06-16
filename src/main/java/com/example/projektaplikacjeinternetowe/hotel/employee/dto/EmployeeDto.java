package com.example.projektaplikacjeinternetowe.hotel.employee.dto;

import com.example.projektaplikacjeinternetowe.hotel.address.dto.AddressDto;
import com.example.projektaplikacjeinternetowe.hotel.commons.dto.AbstractDto;
import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import com.example.projektaplikacjeinternetowe.hotel.country.dto.CountryDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EmployeeDto extends AbstractDto<Long> {

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private Set<CompanyDto> company;

    private Set<AddressDto> addresses;

    private CountryDto countryOfBirth;
}
