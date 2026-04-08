package Greedy_Algo.Shortest_Job_First;

import java.util.Arrays;

public class SJF {
    public static void main(String[] args) {
        int bt[] = {4,7,1,2,3};
        int ans = shotestJobFirst(bt);
        System.out.println("average waiting time of processes is -> "+ans);
    }

    private static int shotestJobFirst(int[] bt) {
        Arrays.sort(bt);

        int time = 0 ;
        int waitTime = 0 ;

        for(int i = 0 ;i< bt.length;i++){
            waitTime = waitTime + time;

            time = time + bt[i];
        }
        return (waitTime/bt.length);
    }
}
