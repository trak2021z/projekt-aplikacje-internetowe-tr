package com.example.projektaplikacjeinternetowe.hotel.company_branch.entity;

import com.example.projektaplikacjeinternetowe.hotel.commons.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company_branch")
@Getter
@Setter
public class CompanyBranchEntity extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;
}
