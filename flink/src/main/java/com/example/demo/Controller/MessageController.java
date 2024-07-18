package com.example.demo.Controller;


import com.example.demo.kafka.JsonKafkaProducer;
import com.example.demo.kafka.KafkaProducer;
import com.example.demo.payload.User;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    ResponseEntity<String> publish(@RequestParam("message") String message) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Set up Kafka properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "myGroup");
        properties.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        // Define the Kafka Consumer
//        DeserializationSchema<String> StringDeserializer=new SimpleStringSchema();
        FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(
                "test",
                 new SimpleStringSchema(),
                properties
        );
        DataStream<String> stream = env.addSource(kafkaConsumer);
        System.out.println("consumer ids is1");
        stream.print();
//
//		// Execute the Flink job
		env.execute("Flink Kafka Consumer");
//        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent");

    }
    @PostMapping("/publishJson")
    ResponseEntity<String> publishJson(@RequestBody User user)
    {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent");

    }
}
