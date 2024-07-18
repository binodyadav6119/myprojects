package com.example.demo;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class WordCount {

    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<String> text = env.fromElements(
                "Hello",
                "My Dataset API Flink Program");

        DataSet<Tuple2<String, Integer>> wordCounts = text
                .flatMap(new LineSplitter())
                .groupBy(0)
                .sum(1);

        wordCounts.print();
    }

    public static class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String line, Collector<Tuple2<String, Integer>> out) {
            for (String word : line.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }
//        // Set up the execution environment
//        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
//
//        // Create a DataSet from a collection (replace this with your data source)
//        DataSet<String> data = env.fromElements("hello", "world", "flink");
//
//        // Transformations on the data set (e.g., word count)
//        DataSet<Tuple2<String, Integer>> wordCounts = data
//                .flatMap(new Tokenizer())
//                .groupBy(0)
//                .sum(1);
//
//        // Print the word counts to stdout (replace this with your sink)
//        wordCounts.print();
//
//        // Execute the job
//        env.execute("WordCount Example");
//    }

//    public static final class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {
//        @Override
//        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) {
//            // Split the line into words and emit a count for each word
//            for (String word : value.toLowerCase().split("\\W+")) {
//                if (word.length() > 0) {
//                    out.collect(new Tuple2<>(word, 1));
//                }
//            }
//        }
//    }
}

