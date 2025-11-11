package com.shfit.mgmt.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "emp_sup_app")
public class SupportingApplications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String empId;
	
	@Column(name = "istmgrpname")
	private String itsmGrpName;

	@Column(name = "AppList")
	private List<String> appList;

	

}
