package com.hubstaff.jobs.jobupload.events;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.hubstaff.jobs.jobupload.domain.JobEvent;

//@Service
@EnableBinding(JobsEventInputChannel.class)
public class JobsCjEventListener {


//	@KafkaListener(topics="surya")
    @StreamListener(JobsEventInputChannel.CUSTOMER_JOURNEY_EVENT_CHANNEL)
    public void processEvent(@Payload JobEvent job) {
    	System.out.println("Message Recieved ==============================");
    	System.out.println(job.getTitle() + " " + job.getDescription());
    }
}