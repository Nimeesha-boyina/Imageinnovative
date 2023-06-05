package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    // Endpoint to store employee details
    @PostMapping
    public ResponseEntity<String> storeEmployeeDetails(@RequestBody Employee employee) {
        // Validate the employee data
        if (employee.getEmployeeId() == null || employee.getFirstName() == null || employee.getLastName() == null ||
            employee.getEmail() == null || employee.getPhoneNumbers() == null || employee.getDoj() == null) {
            return ResponseEntity.badRequest().body("All fields are mandatory.");
        }

        // Validate and store the employee data
        // You can add additional validation logic here

        employees.add(employee);
        return ResponseEntity.ok("Employee details stored successfully.");
    }

    // Endpoint to return tax deduction for the current financial year
    @GetMapping("/tax-deduction")
    public ResponseEntity<List<TaxDeductionDTO>> getTaxDeduction() {
        List<TaxDeductionDTO> taxDeductions = new ArrayList<>();

        // Calculate tax deduction for each employee and populate the taxDeductions list
        // You need to implement the tax calculation logic based on the provided rules

        return ResponseEntity.ok(taxDeductions);
    }
}