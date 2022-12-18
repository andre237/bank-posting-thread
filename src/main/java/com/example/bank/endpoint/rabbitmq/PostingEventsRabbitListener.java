package com.example.bank.endpoint.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PostingEventsRabbitListener {

    @RabbitListener(queues = "bank.postings.realtime")
    public void getAndSavePosting(Message message) {

    }

}
