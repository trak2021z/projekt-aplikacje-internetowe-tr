package com.example.projektaplikacjeinternetowe.hotel.company.impl;

import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import com.example.projektaplikacjeinternetowe.hotel.company.entity.CompanyEntity;
import com.example.projektaplikacjeinternetowe.hotel.company_branch.entity.CompanyBranchEntity;

public class CompanyMapper {

    public CompanyDto mapToDto(CompanyEntity companyEntity) {
        var dto = new CompanyDto();
        dto.setId(companyEntity.getId());
        dto.setName(companyEntity.getName());
        dto.setNip(companyEntity.getNip());
        dto.setEmail(companyEntity.getEmail());
        dto.setCity(companyEntity.getCity());
        dto.setCompanyBranchId(companyEntity.getBranch().getId());
        dto.setPhoneNumber(companyEntity.getPhoneNumber());
        return dto;
    }

    public CompanyEntity mapToEntity(CompanyDto dto, CompanyBranchEntity branch) {
        var entity = new CompanyEntity();
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setNip(dto.getNip());
        entity.setBranch(branch);
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

    public CompanyEntity updateEntity(CompanyEntity entity, CompanyDto dto, CompanyBranchEntity branch) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getName() != null) {
            entity.setCity(dto.getCity());
        }
        if (dto.getName() != null) {
            entity.setNip(dto.getNip());
        }
        if (dto.getName() != null) {
            entity.setBranch(branch);
        }
        if (dto.getName() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getName() != null) {
            entity.setPhoneNumber(dto.getPhoneNumber());
        }
        return entity;
    }
}
