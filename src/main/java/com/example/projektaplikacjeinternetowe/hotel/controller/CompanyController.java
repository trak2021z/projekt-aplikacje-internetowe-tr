package com.example.projektaplikacjeinternetowe.hotel.controller;

import com.example.projektaplikacjeinternetowe.hotel.commons.dto.PageImpl;
import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import com.example.projektaplikacjeinternetowe.hotel.company.impl.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        return ResponseEntity.ok(companyService.getCompanies());
    }

    @GetMapping("/no-cache")
    public ResponseEntity<List<CompanyDto>> getCompaniesWithoutCaching() {
        return ResponseEntity.ok(companyService.getCompaniesWithOutCaching());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto dto) {
        return ResponseEntity.ok(companyService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable long id, @RequestBody CompanyDto dto) {
        return ResponseEntity.ok(companyService.updateCompany(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany(@PathVariable long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
