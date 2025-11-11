package com.shfit.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shfit.mgmt.model.EmployeeDetails;
import com.shfit.mgmt.model.ShiftDetails;

@Repository
public interface ShiftMgmtRepository  extends JpaRepository<ShiftDetails, Integer>{
	
//	ShiftDetails assginShiftdaoCall(ShiftAssignRequestJSON json);
//
//	void save(EmployeeDetails employeeDetails);
//	
	

}
