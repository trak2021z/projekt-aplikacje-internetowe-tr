package com.example.projektaplikacjeinternetowe.hotel.controller;

import com.example.projektaplikacjeinternetowe.hotel.company.dto.CompanyDto;
import com.example.projektaplikacjeinternetowe.hotel.company.impl.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies() {
        var start = System.nanoTime();
        var result = ResponseEntity.ok(companyService.getCompanies());
        var end = System.nanoTime();
        log.info("With cache elapsed time: " + (end - start));
        return result;
    }

    @GetMapping("/no-cache")
    public ResponseEntity<List<CompanyDto>> getCompaniesWithoutCaching() {
        var start = System.nanoTime();
        var result = ResponseEntity.ok(companyService.getCompaniesWithOutCaching());
        var end = System.nanoTime();
        log.info("Without cache elapsed time: " + (end - start));
        return result;
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
