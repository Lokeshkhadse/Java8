package Stack_Queue.Sum_subArray_Lergest_Smallest;

public class Brute_Approach {
    public static void main(String[] args) {
        int arr[] = {1,4,3,2};
        int n = arr.length;

        int total = 0;

        for(int i = 0;i<n;i++){
            int min = arr[i];
            int max = arr[i];

            for(int j = i ;j<n;j++){
                min = Math.min(min,arr[j]);
                max  = Math.max(max,arr[j]);
                total = total + max-min;
            }

        }
        System.out.println(total);
    }
}
