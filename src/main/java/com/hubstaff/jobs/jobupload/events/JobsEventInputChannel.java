package com.hubstaff.jobs.jobupload.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface JobsEventInputChannel {

    String CUSTOMER_JOURNEY_EVENT_CHANNEL = "uploadJobs";

    @Input(JobsEventInputChannel.CUSTOMER_JOURNEY_EVENT_CHANNEL)
    MessageChannel notificationRequestEvents();

}