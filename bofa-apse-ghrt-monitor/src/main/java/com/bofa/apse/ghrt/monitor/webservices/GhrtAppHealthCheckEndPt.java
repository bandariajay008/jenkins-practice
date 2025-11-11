package com.bofa.apse.ghrt.monitor.webservices;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.bofa.apse.ghrt.monitor.json.ApplicationStatus;

public interface GhrtAppHealthCheckEndPt {

	public List<ApplicationStatus> getHealthChecknNdSendEmail(
			@RequestParam(value = "categoryName", required = false) String catrgoryName);

}
