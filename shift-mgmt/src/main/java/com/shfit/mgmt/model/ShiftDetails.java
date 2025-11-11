package com.shfit.mgmt.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shf_dtl")
public class ShiftDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int empId;

	@Column(name = "shiftStartDate")
	private LocalDate shiftStartDate;

	@Column(name = "shiftEndDate")
	private LocalDate shiftEndDate;

	@Column(name = "shiftType")
	private ShiftType shiftType;

	@OneToOne
	@JoinColumn(name = "emp_id", nullable = false)
	private EmployeeDetails employeeDetails;

}
