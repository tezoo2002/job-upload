package com.hubstaff.jobs.jobupload.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubstaff.jobs.jobupload.domain.JobEvent;
import com.hubstaff.jobs.jobupload.domain.JobsEventProducer;

@Service("outboundMessageService")
public class OutboundMessageService {

    @Autowired
    private JobsEventProducer eventProducer;

    public void sendEvents(JobEvent eventRequest) {
        eventRequest.setTitle(eventRequest.getTitle());
        eventRequest.setDescription(eventRequest.getDescription());
        eventRequest.setCreatedDate((new Date()).getTime());
        publishRequest(eventRequest);

    }

    private void publishRequest(JobEvent request) {
        eventProducer.publishRequest(request);
    }

}