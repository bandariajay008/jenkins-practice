package com.shfit.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shfit.mgmt.model.EmployeeDetails;
import com.shfit.mgmt.model.ShiftDetails;
import com.shfit.mgmt.repository.ShiftMgmtRepository;

@RestController
@RequestMapping("/shift")
public class ShiftMgmtController {

	@Autowired
	private ShiftMgmtRepository shiftRepo;

	@PostMapping("/assign")
	public ShiftDetails assignShifToResource(@RequestBody ShiftDetails shiftDetails) {
		ShiftDetails shDetails = shiftRepo.save(shiftDetails);
		return shDetails;

	}

}
