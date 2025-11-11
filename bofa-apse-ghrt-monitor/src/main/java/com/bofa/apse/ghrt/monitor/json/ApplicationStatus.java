package com.bofa.apse.ghrt.monitor.json;

import com.bofa.apse.ghrt.monitor.readJson.Applications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplicationStatus {

	private String appCategory;
	private Applications appDetails;
	private Boolean status;

}
