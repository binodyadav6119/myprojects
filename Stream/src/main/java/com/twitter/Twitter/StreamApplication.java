package com.twitter.Twitter;

import com.twitter.Twitter.kafka.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StreamApplication {


    public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);

	}

}
