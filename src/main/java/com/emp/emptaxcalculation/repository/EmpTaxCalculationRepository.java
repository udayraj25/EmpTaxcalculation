package com.emp.emptaxcalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.emptaxcalculation.models.EmployeeInformation;

public interface EmpTaxCalculationRepository extends JpaRepository<EmployeeInformation, Long> {

}
