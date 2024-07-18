package com.example.demo.kafka;


import com.example.demo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "test_json", groupId = "myGroup")
    public void listenJson(User user)
    {
        LOGGER.info(String.format("json message rcvd is %s",user.toString()));

    }
}
