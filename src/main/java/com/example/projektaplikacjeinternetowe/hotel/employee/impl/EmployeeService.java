package com.example.projektaplikacjeinternetowe.hotel.employee.impl;

import com.example.projektaplikacjeinternetowe.hotel.employee.dto.EmployeeDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = new EmployeeMapper();
    }

    @Cacheable(cacheNames = "employees")
    public EmployeeDto getEmployee(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::mapToDto).orElseThrow(() -> new IllegalArgumentException("No Employee"));
    }

    public EmployeeDto getEmployeeWithoutCache(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::mapToDto).orElseThrow(() -> new IllegalArgumentException("No Employee"));
    }
}
