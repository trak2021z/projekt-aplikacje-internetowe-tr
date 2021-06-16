package com.example.projektaplikacjeinternetowe.hotel.address.entity;

import com.example.projektaplikacjeinternetowe.hotel.commons.entity.AbstractEntity;
import com.example.projektaplikacjeinternetowe.hotel.country.entity.CountryEntity;
import com.example.projektaplikacjeinternetowe.hotel.employee.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity extends AbstractEntity<Long> {

    private String city;

    private String street;

    private String postcode;

    private String houseNumber;

    private String localNumber;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @ManyToMany(mappedBy = "addresses")
    private Set<EmployeeEntity> employees;
}
