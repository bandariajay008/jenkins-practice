package com.bofa.apse.ghrt.monitor.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.apse.ghrt.monitor.json.ApplicationStatus;
import com.bofa.apse.ghrt.monitor.readJson.ApplicationCategory;
import com.bofa.apse.ghrt.monitor.readJson.Applications;
import com.bofa.apse.ghrt.monitor.readJson.GhrtAppDetailsReader;
import com.bofa.apse.ghrt.monitor.readJson.GlobalHumanResource;
import com.bofa.apse.ghrt.monitor.readJson.Root;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GhrtService {
	
	@Autowired
	private GhrtAppDetailsReader appDetailsReader;

	public List<ApplicationStatus> getHealthCheckOfApp(String categoryName) {
		List<ApplicationStatus> applicationStatus = new ArrayList<ApplicationStatus>();
		try {
			List<Root> list = appDetailsReader.getApplications();

			for (Root root : list) {
				List<GlobalHumanResource> globalHumanResources = root.getGlobalHumanResources();

				for (GlobalHumanResource globalHumanResource : globalHumanResources) {
					List<ApplicationCategory> applicationCategories = globalHumanResource.getApplicationCategories();
					for (ApplicationCategory applicationCategory : applicationCategories) {
						List<Applications> applications = applicationCategory.getApplications();

						if (categoryName == null
								|| applicationCategory.getCategoryName().equalsIgnoreCase(categoryName)) {
							for (Applications application : applications) {
								ApplicationStatus status = new ApplicationStatus();
								if (!isUrlReachable(application.getAppUrl())) {
									status.setAppCategory(applicationCategory.getCategoryName());
									application.setAppName(application.getAppName());
									application.setAppUrl(application.getAppUrl());
									status.setAppDetails(application);
									status.setStatus(false);
								} else {
									status.setAppCategory(applicationCategory.getCategoryName());
									application.setAppName(application.getAppName());
									application.setAppUrl(application.getAppUrl());
									status.setAppDetails(application);
									status.setStatus(true);
								}

								applicationStatus.add(status);

							}

						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return applicationStatus;
	}

	public static boolean isUrlReachable(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int responseCode = connection.getResponseCode();
			return responseCode == HttpURLConnection.HTTP_OK;
		} catch (IOException e) {
			return false;
		}
	}

}
