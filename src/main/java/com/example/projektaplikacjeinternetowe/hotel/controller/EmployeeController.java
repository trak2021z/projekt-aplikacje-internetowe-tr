package com.example.projektaplikacjeinternetowe.hotel.controller;

import com.example.projektaplikacjeinternetowe.hotel.employee.dto.EmployeeDto;
import com.example.projektaplikacjeinternetowe.hotel.employee.impl.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        var start = System.nanoTime();
        var result = ResponseEntity.ok(employeeService.getEmployee(id));
        var end = System.nanoTime();
        log.info("With cache elapsed time: " + (end - start));
        return result;
    }

    @GetMapping("/no-cache/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeWithoutCache(@PathVariable Long id) {
        var start = System.nanoTime();
        var result = ResponseEntity.ok(employeeService.getEmployeeWithoutCache(id));
        var end = System.nanoTime();
        log.info("Without cache elapsed time: " + (end - start));
        return result;
    }
}
