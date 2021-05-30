package com.example.projektaplikacjeinternetowe.hotel.company.dto;

import com.example.projektaplikacjeinternetowe.hotel.commons.dto.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CompanyDto extends AbstractDto<Long> {

    @NotBlank
    @Size(min = 3)
    private String name;

    private String nip;

    private String email;

    private Long companyBranchId;

    private String city;

    private String phoneNumber;
}
