package com.example.demo;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.api.datastream.DataStream;

import java.util.Properties;

public class KafkaFlinkConsumer {

    public static void main(String[] args) throws Exception {

        // Set up the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Configure Kafka consumer properties
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("group.id", "myGroup");

        // Create a Flink Kafka consumer
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(
                "test",       // Kafka topic name
                new SimpleStringSchema(), // Deserialization schema
                properties                // Consumer properties
        );

        // Add the Kafka consumer as a source to the Flink execution environment
        DataStream<String> stream = env.addSource(consumer);
        System.out.println("consumerids test is");
        // Print the consumed messages to the console
        stream.print();

        // Execute the Flink job
        env.execute("Flink Kafka Consumer Example");
    }
}
