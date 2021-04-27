package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    public class WebController {

        @Autowired
        Producer rabbitMQSender;

        @GetMapping(value = "/producer")
        public String producer(@RequestParam("Helloworld") String msg) {
            rabbitMQSender.produceMsg(msg);

            return "Message sent to the RabbitMQ Successfully";
        }

    }


