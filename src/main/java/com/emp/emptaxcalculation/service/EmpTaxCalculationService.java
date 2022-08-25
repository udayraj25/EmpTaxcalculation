package com.emp.emptaxcalculation.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.emptaxcalculation.dto.EmployeeInformationDTO;
import com.emp.emptaxcalculation.models.EmployeeInformation;
import com.emp.emptaxcalculation.repository.EmpTaxCalculationRepository;
import com.emp.emptaxcalculation.service.EmpTaxCalculationService;

@Service
public class EmpTaxCalculationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpTaxCalculationService.class);

	@Autowired
	private EmpTaxCalculationRepository empTaxCalculationRepository;


	public String saveEmployeeInformation(EmployeeInformationDTO request) {
		LOGGER.info("Entered into saveEmployeeInformation method");
		String response = null;
		try {
			
			EmployeeInformation employeeInfo = new EmployeeInformation();
			employeeInfo.setFName(request.getFName());
			employeeInfo.setLName(request.getLName());
			employeeInfo.setEmailId(request.getEmailId());
			employeeInfo.setContactNumber(request.getContactNumber());
			employeeInfo.setAltContactNumber(request.getAltContactNumber());
			employeeInfo.setDateOfJoining(Date.valueOf(request.getDateOfJoining()));
			employeeInfo.setSalary(request.getSalary());
		
			empTaxCalculationRepository.save(employeeInfo);
			response = "Successfully Saved";

		} catch (Exception ex) {
			LOGGER.error("Exception occurred while saving the employee Infomation");
		    response = "Failed to save";
			ex.printStackTrace();
		}
		return response;
	}

	
	public List<EmployeeInformationDTO> getAllEmployeeInfoTax() {
		LOGGER.info("Entered into getAllEmployeesInfoTax method");
		List<EmployeeInformationDTO> empInfoList = new ArrayList<EmployeeInformationDTO>();
		try {
			
			List<EmployeeInformation> employeeInfoList = empTaxCalculationRepository.findAll();
			
			if(null != employeeInfoList) {
				for (EmployeeInformation employeeInformation : employeeInfoList) {
					EmployeeInformationDTO employeeInformationDTO = new EmployeeInformationDTO();
					employeeInformationDTO.setEmpId(employeeInformation.getEmpId());
					employeeInformationDTO.setFName(employeeInformation.getFName());
					employeeInformationDTO.setLName(employeeInformation.getLName());
					employeeInformationDTO.setDateOfJoining(String.valueOf(employeeInformation.getDateOfJoining()));
					employeeInformationDTO.setContactNumber(employeeInformation.getContactNumber());
					employeeInformationDTO.setAltContactNumber(employeeInformation.getAltContactNumber());
					employeeInformationDTO.setSalary(employeeInformation.getSalary());
					employeeInformationDTO.setFinalTax(empTaxCalculation(employeeInformation.getSalary(),employeeInformation.getDateOfJoining()));
					empInfoList.add(employeeInformationDTO);
				}
			}
			
		}catch (Exception ex) {
			LOGGER.error("Exception occurred while fetching the employee information");
			ex.printStackTrace();
		}
		return empInfoList;
	}
	
	private static Double empTaxCalculation(Double sal, Date dateOfJoining) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfJoining);
		int year = cal.get(Calendar.YEAR);
		
		String startYear = "2022-04-01";
		String endYear = "2023-03-31";
		
		Date startYearDate = Date.valueOf(startYear);
		long startDateInMillis = startYearDate.getTime();
		
		Date endYearDate = Date.valueOf(endYear);
		long endDateInMillis = endYearDate.getTime();
		
		Double salPerMonth = sal/12;
		Double salPerDay = salPerMonth/30;
		
		long dateOfJoiningInMillis = dateOfJoining.getTime();
		
		Double totSalary = sal;
		long diffInMillis = 0;
		if(dateOfJoiningInMillis > startDateInMillis && dateOfJoiningInMillis < endDateInMillis) {
			diffInMillis = endDateInMillis - dateOfJoiningInMillis;
			int daysDiff = (int) (diffInMillis / (1000 * 60 * 60* 24));
			totSalary = salPerDay*daysDiff;
		}else {
			totSalary = sal;
		}
		
		
		double taxExemption = 250000.00;
		
		Double finalTax = 0.00;
		if(totSalary<=250000) {
			finalTax = 0.00;
		}else if(totSalary<=500000) {
			finalTax = (totSalary - taxExemption)*0.05;
		}
		
		return finalTax;
	}
}
