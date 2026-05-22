package Normal_Code;

import java.util.Arrays;

public class Print_2D_3D_Array {
    public static void main(String[] args) {
        int arr[][] = {{1,2},{2,3,10},{3,4},{1,3}};
        System.out.println(Arrays.deepToString(arr));

        int m = arr.length;


        for(int i = 0 ;i<m;i++){  //row
            for (int j = 0; j < arr[i].length; j++) { //col
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
