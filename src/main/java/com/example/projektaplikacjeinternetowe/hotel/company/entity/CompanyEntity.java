package com.example.projektaplikacjeinternetowe.hotel.company.entity;

import com.example.projektaplikacjeinternetowe.hotel.commons.entity.AbstractEntity;
import com.example.projektaplikacjeinternetowe.hotel.company_branch.entity.CompanyBranchEntity;
import com.example.projektaplikacjeinternetowe.hotel.employee.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
@Getter
@Setter
public class CompanyEntity extends AbstractEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nip", nullable = false)
    private String nip;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private CompanyBranchEntity branch;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @ManyToMany(mappedBy = "companies")
    private Set<EmployeeEntity> employees;
}
