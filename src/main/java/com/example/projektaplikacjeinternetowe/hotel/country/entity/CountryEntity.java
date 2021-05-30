package com.example.projektaplikacjeinternetowe.hotel.country.entity;

import com.example.projektaplikacjeinternetowe.hotel.commons.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class CountryEntity extends AbstractEntity<Long> {

    private String name;
}
