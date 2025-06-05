package com.twitter.Twitter.kafka;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AvroConsumer {

    private final Schema schema;

    public AvroConsumer() throws IOException {
        // Load the Avro schema
        schema = new Schema.Parser().parse(getClass().getResourceAsStream("/user.avsc"));
    }

    @KafkaListener(
            topics = "avro-topic",
            groupId = "avro-batch-group",
            containerFactory = "kafkaBatchListenerContainerFactory"
    )
    public void consumeBatch(List<ConsumerRecord<String, byte[]>> records) {
        System.out.println("Received batch of size: " + records.size());
        records.forEach(record -> {
            try {
                // Deserialize each byte[] into a GenericRecord
                byte[] value = record.value();
                GenericDatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);
                Decoder decoder = DecoderFactory.get().binaryDecoder(value, null);
                GenericRecord avroRecord = reader.read(null, decoder);

                System.out.println("Consumed Avro message: " + avroRecord);
            } catch (IOException e) {
                System.err.println("Failed to deserialize Avro message: " + e.getMessage());
            }
        });
    }
}
