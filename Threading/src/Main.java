import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
            Student s1= new Student("abc",32);
        Student s2= new Student("abc",30);
        s1=s2;
        s1.age=40;
        s2.age=50;
        System.out.println(s2.age);
        System.out.println(s1.age);

//        Item item = new Item();
//        Producer producer = new Producer(item);
//        Consumer consumer= new Consumer(item);
//        producer.start();
//        consumer.start();
//
//        System.out.println("Hello world!");



        List<List<String>>list = Arrays.asList(Arrays.asList("binod","yadav"),Arrays.asList("binod1","yadav1"));

        Set<String> intter=new HashSet<>();

        List<String>streamList=list.stream().flatMap(List::stream).filter(s->s.startsWith("b")).map(String::toUpperCase).distinct().sorted()
                .peek(s->intter.add(s)).collect(Collectors.toList());
        System.out.println(intter);

        streamList.forEach(System.out::println);
        intter.forEach(System.out::println);
    }
}