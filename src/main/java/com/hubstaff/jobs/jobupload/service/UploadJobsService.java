package com.hubstaff.jobs.jobupload.service;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubstaff.jobs.jobupload.domain.JobEvent;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Service
public class UploadJobsService {	
	
	@Autowired OutboundMessageService outboundMessageService;
	
	public void uploadJobsFromCsv(String csvJobs) {

		Map mapping = new HashMap();
        mapping.put("title", "title");
        mapping.put("description", "description");
        mapping.put("availability", "availability");
        mapping.put("company", "company");
        mapping.put("location", "location");

        HeaderColumnNameTranslateMappingStrategy mapper = new HeaderColumnNameTranslateMappingStrategy();
        mapper.setType(JobEvent.class);
        mapper.setColumnMapping(mapping);

        Reader reader = new StringReader(csvJobs);
        CSVReader csvReader = new CSVReader(reader);
        CsvToBean csv = new CsvToBean();
        List<JobEvent> jobs = csv.parse(mapper, csvReader);

        jobs.stream().forEach(job -> outboundMessageService.sendEvents(job));
		
	}
	
	public void persistJob(JobEvent job) {
		System.out.println("Persisted");
		System.out.println("++++++++++++++++");
	}
}

