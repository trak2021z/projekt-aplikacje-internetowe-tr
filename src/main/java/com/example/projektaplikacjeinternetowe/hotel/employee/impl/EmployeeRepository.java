package com.example.projektaplikacjeinternetowe.hotel.employee.impl;

import com.example.projektaplikacjeinternetowe.hotel.commons.repository.JpaSearchRepository;
import com.example.projektaplikacjeinternetowe.hotel.employee.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaSearchRepository<EmployeeEntity, Long> {
}
