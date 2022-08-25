package com.emp.emptaxcalculation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.emptaxcalculation.dto.EmployeeInformationDTO;
import com.emp.emptaxcalculation.service.EmpTaxCalculationService;

@RestController
@RequestMapping("/employees")
public class EmpTaxCalculationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmpTaxCalculationController.class);
	
	@Autowired
	private EmpTaxCalculationService empTaxCalculationService;
	
	@PostMapping("/saveEmployeeInformation")
	public ResponseEntity<?> saveEmployeeInformation(@RequestBody EmployeeInformationDTO request){
		LOGGER.info("Entered into saveEmployeeInformation method");
		return ResponseEntity.ok(empTaxCalculationService.saveEmployeeInformation(request));
	}
	
	@GetMapping("/getAllEmployeesTax")
	public ResponseEntity<?> getAllEmployeeInfoTax(){
		LOGGER.info("Entered into saveEmployeeDetails method");
		return ResponseEntity.ok(empTaxCalculationService.getAllEmployeeInfoTax());
	}
}
