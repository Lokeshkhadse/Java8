package Normal_Code;

import java.util.Arrays;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int arr[] = {6,0,8,9,1,3};
        int n  = arr.length;

        for(int i =0  ;i<n;i++){
            int max = arr[i];
            int cnt = 0 ;
            for(int j = i+1;j<n;j++){
                if(max < arr[j]){
                    max = arr[j];
                    cnt++;
                    break;
                }
            }
            if(cnt != 0){
                arr[i] = max;
            }else{
                arr[i] = -1 ;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
