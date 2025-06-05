package com.twitter.Twitter.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class AvroProducer {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    private final Schema schema;

    public AvroProducer() throws IOException {
        // Load the Avro schema
        schema = new Schema.Parser().parse(getClass().getResourceAsStream("/user.avsc"));
        System.out.println("test");
    }

    public void sendMessage(String topic, String jsonString) {
        try {
            // Create a GenericRecord
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(jsonString, Map.class);

            // Create a GenericRecord using the parsed schema
            GenericRecord record = new GenericData.Record(schema);
            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                record.put(entry.getKey(), entry.getValue());
            }

            byte[] serializedMessage = serialize(record);

            // Send the message to Kafka
            kafkaTemplate.send(topic, serializedMessage);
//            System.out.println("Produced Avro message: " + record);
        } catch (IOException e) {
            System.err.println("Failed to serialize Avro message: " + e.getMessage());
        }
    }

    private byte[] serialize(GenericRecord record) throws IOException {
        DatumWriter<GenericRecord> writer = new SpecificDatumWriter<>(schema);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        writer.write(record, encoder);
        encoder.flush();
        out.close();
        return out.toByteArray();
    }
}
