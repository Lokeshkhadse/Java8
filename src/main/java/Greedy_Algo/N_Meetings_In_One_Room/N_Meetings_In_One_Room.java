package Greedy_Algo.N_Meetings_In_One_Room;
import java.util.Arrays;

public class N_Meetings_In_One_Room {
    public static void main(String[] args) {

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[]   = {2, 4, 6, 7, 9, 9};

        int n = start.length;

        // Step 1: combine into meetings array
        int[][] meetings = new int[n][2];
        for(int i = 0; i < n; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Step 2: sort by end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        // Step 3: your logic
        int cnt = 1;
        int lastendtime = meetings[0][1];

        for(int i = 1; i < n; i++){
            if(meetings[i][0] > lastendtime){
                cnt++;
                lastendtime = meetings[i][1];
            }
        }

        // Output
        System.out.println("Maximum meetings = " + cnt);
    }
}

