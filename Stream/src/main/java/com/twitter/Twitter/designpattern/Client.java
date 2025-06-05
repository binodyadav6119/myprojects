package com.twitter.Twitter.designpattern;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {

        Car newCar =  new Car.CarBuilder()
                .setEngine("abc")

                .build();

        List<Integer> nos = Arrays.asList(1,2,3,4,5);
//        //avg=sum/n
//         double ans = nos.stream().mapToInt(Integer:: intValue)
//                 .average();
//
//
//         1 2 3
//            //
//        /*
//         push pop minm
//                like in
//            o(1)
//            stack o(1)
//             space--->
//
//             store those and compare
//             8 1 5 4
//             1
//             1
//             1
//             8
//
//             container-->to store current value
//             while poping
//             8 min 8
//             8 1 min 1
//             8 1 5 min 1
//             8 1 5 -2 min -2
//
//             push 8 1 // [8 1]
//             1<8
//
//             pop 1
//             popped element =1
//             1=1
//             delete 1 from container 1[8]
//
//             1:  [8,1,5],     container will be stack [8,1]
//            pop 5
//            popped element =5
//            5 != 1(container stack)
//
//            [8,1,1]
//
//
//
//         */





    }
}
