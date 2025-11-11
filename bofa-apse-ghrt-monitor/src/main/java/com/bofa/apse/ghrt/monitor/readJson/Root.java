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
public class Root {
	@JsonProperty("GlobalHumanResources")
	private List<GlobalHumanResource> globalHumanResources;

}
