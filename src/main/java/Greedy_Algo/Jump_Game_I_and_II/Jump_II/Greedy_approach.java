package Greedy_Algo.Jump_Game_I_and_II.Jump_II;

public class Greedy_approach {
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        int jumps = 0, end = 0, farthest = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end) {
                jumps++;
                end = farthest;
            }
        }

        System.out.println("minimum step is -> "+ jumps);
    }
}
    