package Stack_Queue.Largest_Reactangle_In_Histogram;

public class Brute_Approach {
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        int ans = largestRectangleArea(heights);
        System.out.println("largestRectangleArea is -> " + ans);
    }
    public static int largestRectangleArea(int[] heights){
        int n= heights.length;

        int max = Integer.MIN_VALUE;

        for(int i = 0 ;i<n;i++){
            int cntleft = 0 , cntright = 0 ;
            int leftI = i-1, rightI = i+1;


            while(leftI >=0 && heights[leftI] >= heights[i]){
                cntleft++;
                leftI--;
            }
            while(rightI <n && heights[rightI] >= heights[i]){
                cntright++;
                rightI++;
            }

            int width = cntleft + cntright +1;
            int total = heights[i] * width;

            max = Math.max(max,total);
        }
        return max;
    }
}
