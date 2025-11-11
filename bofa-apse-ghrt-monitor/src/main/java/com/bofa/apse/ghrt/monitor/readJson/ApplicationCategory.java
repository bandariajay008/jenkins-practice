package com.bofa.apse.ghrt.monitor.readJson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ApplicationCategory {

	@JsonProperty("categoryName")
	private String categoryName;

	@JsonProperty("applications")
	private List<Applications> applications;

}
