package com.example.projektaplikacjeinternetowe.hotel.employee.entity;

import com.example.projektaplikacjeinternetowe.hotel.address.entity.AddressEntity;
import com.example.projektaplikacjeinternetowe.hotel.commons.entity.AbstractEntity;
import com.example.projektaplikacjeinternetowe.hotel.company.entity.CompanyEntity;
import com.example.projektaplikacjeinternetowe.hotel.country.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity extends AbstractEntity<Long> {

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "employee_company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<CompanyEntity> companies;

    @ManyToMany
    @JoinTable(
            name = "employee_address",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<AddressEntity> addresses;

    @ManyToOne
    @JoinColumn(name = "country_of_birth_id")
    private CountryEntity countryOfBirth;

}
