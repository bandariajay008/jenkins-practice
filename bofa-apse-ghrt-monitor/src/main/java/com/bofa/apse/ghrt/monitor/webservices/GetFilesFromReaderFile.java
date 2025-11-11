package com.bofa.apse.ghrt.monitor.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.apse.ghrt.monitor.readJson.GhrtAppDetailsReader;
import com.bofa.apse.ghrt.monitor.readJson.Root;

@RestController
@RequestMapping("/get")
public class GetFilesFromReaderFile {
	
	@Autowired
	public GhrtAppDetailsReader appDetailsReader;
	
	
	@GetMapping("/allValues")
	public List<Root> getDetails() throws Exception{
		List<Root> ghrtAppDetails = appDetailsReader.getApplications();
		return ghrtAppDetails;
	}

}
