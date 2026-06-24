package Normal_Code;
import java.util.*;

public class Maximum_sum_in_two_D {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,22},{5,6,7},{8,9,10}};
        int n = arr.length;

        int max = 0;
        for(int i = 0 ;i<n-1;i++){
            int sum = 0;
            for(int j = i+1;j<n;j++){
                sum = 0;
                for(int k = 0 ;k<Math.max(arr[i].length,arr[j].length);k++){
                    if(arr[i].length > arr[j].length) sum = arr[i][k];
                    else if(arr[i].length < arr[j].length) sum = arr[j][k];
                    else sum = arr[i][k] + arr[j][k];
                    max = Math.max(max ,sum);
                }
            }
        }
        System.out.println(max);
    }
}
