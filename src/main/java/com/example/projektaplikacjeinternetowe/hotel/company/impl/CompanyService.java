package com.example.projektaplikacjeinternetowe.hotel.company.impl;

import com.example.projektaplikacjeinternetowe.hotel.commons.exception.BadRequestException;
import com.example.projektaplikacjeinternetowe.hotel.commons.exception.ResponseMessage;
import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import com.example.projektaplikacjeinternetowe.hotel.company_branch.repository.CompanyBranchRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyBranchRepository branchRepository;

    public CompanyService(CompanyRepository companyRepository, CompanyBranchRepository branchRepository) {
        this.companyRepository = companyRepository;
        this.companyMapper = new CompanyMapper();
        this.branchRepository = branchRepository;
    }

    @Cacheable(cacheNames = "companies")
    public List<CompanyDto> getCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CompanyDto> getCompaniesWithOutCaching() {
        return companyRepository.findAll().stream()
                .map(companyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Cacheable("company")
    public CompanyDto getOne(Long id) {
        return companyRepository.findById(id).map(companyMapper::mapToDto).orElse(null);
    }

    @CacheEvict(value = "companies", allEntries = true)
    public CompanyDto create(CompanyDto dto) {
        var branch = branchRepository.findById(dto.getCompanyBranchId())
                .orElseThrow(() -> new BadRequestException(new ResponseMessage("Branch doesn't exists!")));
        return Optional.of(dto)
                .map(company -> companyMapper.mapToEntity(dto, branch))
                .map(companyRepository::save)
                .map(companyMapper::mapToDto)
                .orElseThrow(() -> new BadRequestException(new ResponseMessage("Error while saving company")));
    }

    @CachePut(cacheNames = "company", key = "#result.id")
    public CompanyDto updateCompany(long id, CompanyDto dto) {
        var branch = branchRepository.findById(dto.getCompanyBranchId())
                .orElse(null);
        var entity = companyRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(new ResponseMessage("Company doesn't exists!")));
        return Optional.of(entity)
                .map(company -> companyMapper.updateEntity(entity, dto, branch))
                .map(companyRepository::save)
                .map(companyMapper::mapToDto)
                .orElseThrow(() -> new BadRequestException(new ResponseMessage("Error while saving company")));
    }

    @CacheEvict(cacheNames = "companies", allEntries = true)
    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }
}
