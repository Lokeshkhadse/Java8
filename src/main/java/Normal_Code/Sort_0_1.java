package Normal_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort_0_1 {
    public static void main(String[] args) {
        int arr[] = {1,0,1,0,0,0,1};
                                         //comparator requires Integer, not int
        int[] finalArr = Arrays.stream(arr)
                        .boxed()  // convert int → Integer Stream<Integer>
                        .sorted(Comparator.reverseOrder()).
                        mapToInt(Integer::intValue)
                        .toArray();

        System.out.println(Arrays.toString(finalArr));

        int[] abc = Arrays.stream(arr).sorted() // works because it's IntStream
                .toArray();

        System.out.println(Arrays.toString(abc));



        List<Integer> list = Arrays.asList(1,0,1,0,0,0,1);

        List<Integer> oneFirst = list.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> zeroFirst = list.stream().sorted().toList();

        System.out.println(oneFirst);
        System.out.println(zeroFirst);

    }
}
