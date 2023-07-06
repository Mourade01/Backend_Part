package com.bpm.backendpart.restcontroller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bpm.backendpart.services.CcvService;


@RestController
@RequestMapping("/api")
public class CsvRestController {
       
    
	
    	
	
	
	@Autowired
    CcvService csvservice;
	
	
	
	
	
	@PostMapping("/csv")
			public void csvservice() throws Exception {
			  csvservice.CompareFileCsv();
			}
	         
	         
	         
}