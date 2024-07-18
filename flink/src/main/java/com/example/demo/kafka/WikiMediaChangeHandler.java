package com.example.demo.kafka;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

public class WikiMediaChangeHandler implements EventHandler {

    private KafkaTemplate<String,String> kafkaTemplate;
    private String topic;

    public WikiMediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        System.out.println("data from handler is "+messageEvent.getData());
        String data = messageEvent.getData();
        kafkaTemplate.send("test",data);
//        kafkaTemplate.send("test",messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
