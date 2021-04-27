package com.iiitb.feign;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iiitb.feign.payloads.JwtRequest;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${iiitb.rabbitmq.exchange}")
    private String exchange;

    @Value("${iiitb.rabbitmq.routingkey}")
    private String routingkey;

    public void send(JwtRequest user) {
        rabbitTemplate.convertAndSend(exchange, routingkey, user);
        System.out.println("-********\n\n\n\n\n\n\n\nSend msg = " + user+"\n\n\n\n\n\n\n");

    }
}
