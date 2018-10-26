package com.hubstaff.jobs.jobupload.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface JobsEventOutputChannel {

    String CUSTOMER_JOURNEY_EVENT_CHANNEL = "surya";

    @Output(JobsEventOutputChannel.CUSTOMER_JOURNEY_EVENT_CHANNEL)
    MessageChannel notificationRequestEvents();

}