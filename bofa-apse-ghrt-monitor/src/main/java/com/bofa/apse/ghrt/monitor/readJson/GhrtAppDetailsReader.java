package com.bofa.apse.ghrt.monitor.readJson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GhrtAppDetailsReader {

	/**
	 * This method is used to read the application details from ghrtAppDetailsJson
	 * file from the source folder
	 * @throws Exception 
	 * @throws DatabindException 
	 * @throws StreamReadException 
	 */
//	public Root getGhrtAppDetails() {
//		
//		Root root = new Root();
//
//		List<GlobalHumanResources> appDetailsJsons = new ArrayList<>();
//		GlobalHumanResources detailsJson = new GlobalHumanResources();
//		ObjectMapper mapper = new ObjectMapper();
//		try (InputStream inputStream = getClass().getClassLoader()
//				.getResourceAsStream("templates/ghrtAppDetailsJson.json")) {
//
//			detailsJson = mapper.readValue(inputStream, Root.class);
//
//			appDetailsJsons.add(detailsJson);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return appDetailsJsons;
//
//	}

//	public List<GhrtAppDetails> getGhrtAppDetails() {
//	    ObjectMapper mapper = new ObjectMapper();
//	    try (InputStream inputStream = getClass().getClassLoader()
//	            .getResourceAsStream("templates/ghrtAppDetailsJson.json")) {
//
//	        GhrtApplicationDetails appDetails = mapper.readValue(inputStream, GhrtApplicationDetails.class);
//
//	        // Flatten all categories into a single list of apps
//	        List<GhrtAppDetails> allApps = new ArrayList<>();
//	        for (GhrtAppDetailsContainer container : appDetails.getGhrtAppDetails()) {
//	            for (ApplicationCategory category : container.getApplicationCategories()) {
//	                allApps.addAll(category.getApplications());
//	            }
//	        }
//	        return allApps;
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	    return Collections.emptyList();
//	}
	
	public List<Root> getApplications() throws Exception {
		List<Root> globalHumanResources = new ArrayList<Root>();
		ObjectMapper mapper = new ObjectMapper();
		try (InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream("templates/ghrtAppDetailsJson.json")) {

			Root readValue = mapper.readValue(inputStream, Root.class);

			globalHumanResources.add(readValue);
		}

		return globalHumanResources;

	}

}
