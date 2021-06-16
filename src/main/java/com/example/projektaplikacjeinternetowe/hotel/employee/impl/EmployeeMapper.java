package com.example.projektaplikacjeinternetowe.hotel.employee.impl;

import com.example.projektaplikacjeinternetowe.hotel.address.impl.AddressMapper;
import com.example.projektaplikacjeinternetowe.hotel.company.impl.CompanyMapper;
import com.example.projektaplikacjeinternetowe.hotel.country.impl.CountryMapper;
import com.example.projektaplikacjeinternetowe.hotel.employee.dto.EmployeeDto;
import com.example.projektaplikacjeinternetowe.hotel.employee.entity.EmployeeEntity;

import java.util.stream.Collectors;

public class EmployeeMapper {

    private final AddressMapper addressMapper;
    private final CompanyMapper companyMapper;
    private final CountryMapper countryMapper;

    public EmployeeMapper() {
        this.addressMapper = new AddressMapper();
        this.companyMapper = new CompanyMapper();
        this.countryMapper = new CountryMapper();
    }

    public EmployeeDto mapToDto(EmployeeEntity entity) {
        var employee = new EmployeeDto();
        employee.setFirstname(entity.getFirstname());
        employee.setLastname(entity.getLastname());
        employee.setDateOfBirth(entity.getDateOfBirth());
        employee.setId(entity.getId());
        employee.setAddresses(entity.getAddresses().stream().map(addressMapper::mapToDto).collect(Collectors.toSet()));
        employee.setCompany(entity.getCompanies().stream().map(companyMapper::mapToDto).collect(Collectors.toSet()));
        employee.setCountryOfBirth(countryMapper.mapToDto(entity.getCountryOfBirth()));
        return employee;

    }
}
