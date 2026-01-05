package Stack_Queue.Silding_Window_Maximum;

public class Without_Stack {
    public static void main(String[] args) {
        int arr[]= {1,3,-1,-3,5,3,2,1,6};
        int k = 3;
        int[] ans = func(arr,k);

        for(int i:ans){
            System.out.print(" " + i);
        }

    }
    public static int[] func(int arr[],int k){
        int n = arr.length;
        int size = (n-k)+1;
        int newarr[] = new int[size];
        int track = 0 ;

        for(int i =  0;i<=n-k;i++){
            int maxi = arr[i];
            for(int j = i;j<i+k;j++){
                if(arr[j] > maxi){
                    maxi = arr[j];
                }

            }
            newarr[track] = maxi;
            track++;
        }
        return newarr;
    }
}
