package com.hubstaff.jobs.jobupload.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hubstaff.jobs.jobupload.messaging.JobsUploadService;
import com.hubstaff.jobs.jobupload.service.OutboundMessageService;
import com.hubstaff.jobs.jobupload.service.UploadJobsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/jobs")
public class UploadJobsResource {
	
	@Autowired UploadJobsService uploadJobsService;
	@Autowired JobsUploadService jobsUploadService;
	@Autowired OutboundMessageService outboundMessageService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	@ApiOperation(value = "upload csv file content to Kafka", notes = "upload csv file to Kafka as jobs")
    public void uploadJobs(@ApiParam(required = true) @RequestBody String csvJobs) {
        
		uploadJobsService.uploadJobsFromCsv(csvJobs);
    }
	
}
