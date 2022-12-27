package com.example.KafkaProducerConsumer;

import com.example.KafkaProducerConsumer.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//POST: http://localhost:8888/kafkaapp/post?msg=xxx
@RestController
@RequestMapping("/kafkaapp")
public class KafkaContrller {

    @Autowired
    Producer producer;

    @PostMapping(value="/post")
    public void sendMessage(@RequestParam("msg") String msg) {
        producer.publishToTopic(msg);
    }

}
