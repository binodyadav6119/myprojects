package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
//		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//
//		// Set up Kafka properties
//		Properties properties = new Properties();
//		properties.setProperty("bootstrap.servers", "localhost:9092");
//		properties.setProperty("group.id", "myGroup");
//
//		// Define the Kafka Consumer
//		FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>(
//				"test",
//				new SimpleStringSchema(),
//				properties
//		);
//		DataStream<String> stream = env.addSource(kafkaConsumer);
//
//		// Process the data (for example, print it to the console)
//		stream.print();
//
//		// Execute the Flink job
//		env.execute("Flink Kafka Consumer");
//		ExecutionEnvironment env
//				= ExecutionEnvironment.getExecutionEnvironment();
//		DataSet<Integer> amounts = env.fromElements(1, 29, 40, 50);
//
//		int threshold = 30;
//		List<Integer> collect = amounts
//				.filter(a -> a > threshold)
//				.reduce((integer, t1) -> integer + t1)
//				.collect();
//		System.out.println("test flink");
//		System.out.println(collect.get(0));
		SpringApplication.run(DemoApplication.class, args);
	}


//	@Autowired
//	private KafkaProducer kafkaProducer;
//	@Override
//	public void run(String... args) throws Exception {
//		kafkaProducer.sendMessage();
//
//	}
}
