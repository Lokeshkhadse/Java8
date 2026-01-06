package Normal_Code;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sort_Using_Priorit_Queue {
    public static void main(String[] args) {
        int[] arr = {1,4,2,7,3,5};

        int n = arr.length;
        int[] newArr = new int[n];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int j : arr) {
            priorityQueue.add(j);
        }

//        👉 Queue will never be empty
//        👉 No NullPointerException at runtime

        for(int i = 0 ;i<n;i++){
            if(!priorityQueue.isEmpty()){
                newArr[i] = priorityQueue.poll();
            }
        }

        System.out.println(Arrays.toString(newArr));
    }
}
