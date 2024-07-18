package com.example.demo.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createTopic()
    {
        return TopicBuilder.name("test").build();

    }

    @Bean
    public NewTopic createTopicJson()
    {
        return TopicBuilder.name("test_json").build();

    }
}
