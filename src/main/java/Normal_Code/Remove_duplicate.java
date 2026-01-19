package Normal_Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Remove_duplicate {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,4,3,5};
        int n = arr.length;

        Set<Integer> uni = new HashSet<>();
        Set<Integer> dupli = Arrays.stream(arr).filter(no -> !uni.add(no)).boxed().collect(Collectors.toSet());
        System.out.println("unique is -> " + uni);
        System.out.println("duplicate is ->" + dupli);

        int newarr[] = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(newarr));


        //another approach
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] == arr[j]){
                    System.out.print(arr[i] + " ");
                    break;   // avoid printing same duplicate again
                }
            }
        }

        //another appraoch
        Map<Integer, Long> freq =
                Arrays.stream(arr).boxed()
                        .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

        Set<Integer> duplicates =
                freq.entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());

    }
}
