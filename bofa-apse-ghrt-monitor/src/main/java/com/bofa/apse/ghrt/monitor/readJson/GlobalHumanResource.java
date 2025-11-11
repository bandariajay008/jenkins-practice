package com.bofa.apse.ghrt.monitor.readJson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GlobalHumanResource {

	@JsonProperty("applicationCategories")
	private List<ApplicationCategory> applicationCategories;

}
