package com.hubstaff.jobs.jobupload.domain;

import javax.inject.Inject;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.hubstaff.jobs.jobupload.events.JobsEventOutputChannel;

@EnableBinding(JobsEventOutputChannel.class)
public class JobsEventProducer {

//    private static final LogWriter logger = LogWriterFactory.getLogWriter(MbosEventProducer.class);

    @Inject
    private JobsEventOutputChannel mbosOutputChannel;

    private boolean publishMessage(Message<JobEvent> message, MessageChannel channel) {
        boolean send = channel.send(message);
//        logger.info().withObject("notificationPublishRequest", message).logMessage("GV notificationPublishRequest");
        return send;
    }

    public boolean publishRequest(JobEvent request) {
        MessageBuilder<JobEvent> builder = MessageBuilder.withPayload(request);
        Message<JobEvent> message = builder.build();
        publishMessage(message, mbosOutputChannel.notificationRequestEvents());
        return true;
    }

}
