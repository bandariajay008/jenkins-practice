package com.bofa.apse.ghrt.monitor.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.apse.ghrt.monitor.json.ApplicationStatus;
import com.bofa.apse.ghrt.monitor.service.GhrtService;

@RestController
@RequestMapping("/ghrt")
public class GhrtAppHealthCheckEndPtImpl implements GhrtAppHealthCheckEndPt {

	@Autowired
	private GhrtService ghrtService;

	@Override
	@GetMapping("/appHealthcheck")
	public List<ApplicationStatus> getHealthChecknNdSendEmail(String categoryName) {
		return ghrtService.getHealthCheckOfApp(categoryName);
	}

}
