package com.example.projektaplikacjeinternetowe.hotel.controller;

import com.example.projektaplikacjeinternetowe.hotel.company.entity.CompanyEntity;
import com.example.projektaplikacjeinternetowe.hotel.company.impl.CompanyRepository;
import com.example.projektaplikacjeinternetowe.hotel.company_branch.entity.CompanyBranchEntity;
import com.example.projektaplikacjeinternetowe.hotel.company_branch.repository.CompanyBranchRepository;
import liquibase.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final CacheManager cacheManager;

    private final CompanyRepository companyRepository;
    private final CompanyBranchRepository companyBranchRepository;

    @GetMapping("/cache")
    public ResponseEntity testCase() {
        var caches = cacheManager.getCacheNames();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello there!";
    }

    @GetMapping("/populate/{number}")
    public String populate(@PathVariable int number) {
        populateDatabase(number);
        return "OK";
    }

    private void populateDatabase(int number) {
        for (int i = 0; i < number; i++) {
            CompanyBranchEntity branchEntity = companyBranchRepository.getOne(getRandomNumberUsingInts(1, 4));
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setPhoneNumber(getRandomNumberString());
            companyEntity.setNip(StringUtil.randomIdentifer(10));
            companyEntity.setCity(StringUtil.randomIdentifer(11));
            companyEntity.setName(StringUtil.randomIdentifer(12));
            companyEntity.setEmail(StringUtil.randomIdentifer(7) + "@email.com");
            companyEntity.setBranch(branchEntity);
            companyRepository.save(companyEntity);
        }


    }

    public static String getRandomNumberString() {
        // It will generate 9 digit random Number.
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);

        return String.format("%09d", number);
    }

    public long getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
