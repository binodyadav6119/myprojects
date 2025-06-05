package com.twitter.Twitter.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestProducer implements CommandLineRunner {
    @Autowired
    AvroProducer avroProducer;

//    public TestProducer(AvroProducer avroProducer) {
//        this.avroProducer = avroProducer;
//    }

    @Override
    public void run(String... args) throws Exception {
//        avroProducer.sendMessage("avro-topic", 1, "Binod", "binod@example.com");
    }
}
