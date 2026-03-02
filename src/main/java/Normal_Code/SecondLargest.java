package Normal_Code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SecondLargest {
    public static void main(String[] args) {
        int arr[]= {1,2,7,7,5,3};
        int n = arr.length;
        int largest = arr[0];
        int secondLargest = arr[0];

        for(int i = 1;i<n;i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];

            }else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);

        int secondlar = Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(secondlar);
    }
}
