package org.example;

import java.util.*;
import java.util.stream.*;

public class Boxed_mapToInt {

    public static void main(String[] args) {
        // int[] → List<Integer>
        int[] intArray = {1, 2, 3, 4};
        List<Integer> integerList = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("List from int[]: " + integerList);

        // List<Integer> → int[]
        List<Integer> list = Arrays.asList(10, 20, 30);
        int[] arrFromList = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("int[] from List: " + Arrays.toString(arrFromList));
    }


}
