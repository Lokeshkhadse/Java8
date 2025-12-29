package Stack_Queue.Rain_Trapping_water;

public class Pref_Suffix_Rain_Trapping_water {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = arr.length;

        int totalWater = 0 ;

        int prefixSum[] = new int[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i<n;i++){
            prefixSum[i] = Math.max(prefixSum[i-1],arr[i]);
        }

        int suffixSum[] = new int[n];
        suffixSum[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            suffixSum[i] = Math.max(suffixSum[i+1],arr[i]);
        }

        for(int k = 0;k<n;k++){
            int prefix = prefixSum[k];
            int sufix = suffixSum[k];

            if(arr[k] < prefix && arr[k] < sufix){
                totalWater = totalWater + Math.min(prefix,sufix) - arr[k];
            }

        }
        System.out.println("total water capture -> " + totalWater);
    }
}
