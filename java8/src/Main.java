import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        forEach
        consumer interface
        functional interface
        java stream
        lambda function
         */
        List<String> list = new ArrayList<>();
        list.add("binod");
        list.add("kumar");
        list.add("yadav");

        list.forEach(i-> System.out.println(i));

        List<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("value is "+integer);
            }
        };
        list1.forEach(consumer);
        list1.forEach(i-> System.out.println(i));
        list1.removeIf(i -> i % 2 == 0);
        System.out.println(list1);

        System.out.println("Hello world!");


        List<Integer> list2 = Arrays.asList(1,1,5,2,3,4,5,6,7,8,9,9);
        List<Integer> list3 = list2
                .parallelStream()
                .sorted()
                .distinct()
                .filter(i->i%2==0)
                .map(i-> i+2)
                .collect(Collectors.toList());
        System.out.println(list3);

    }
}