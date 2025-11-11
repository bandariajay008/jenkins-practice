package com.bofa.apse.monitor.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.apse.monitor.service.ScreenShotUtilService;

@RestController
@RequestMapping("/api")
public class CaptureScreenshotEndPt {
	
	
	@Autowired
	private ScreenShotUtilService screenShotUtilService;
	
	@GetMapping("/getTitle")
	public String getTitle() throws Exception {
		return screenShotUtilService.captureScreenShot();
	}

}
