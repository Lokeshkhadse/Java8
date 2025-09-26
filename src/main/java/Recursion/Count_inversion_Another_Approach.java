package Recursion;

public class Count_inversion_Another_Approach {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        int cnt = 0;
        int n = arr.length;

        for(int i = 0  ;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i] > arr[j] && i<j){
                    cnt++;
                }
            }
        }
        System.out.println("inversion cnt is -> " + cnt);
    }
}
