package Stack_Queue.Celebirty_Problem;

public class Brute_force {
    public static void main(String[] args) {
        int[][] arr = {{0,1,1,1},{0,0,1,1},{0,0,0,0},{0,1,1,0}};
        int ans = findCelebrity(arr);
        System.out.println(ans);
    }
    public static int findCelebrity(int[][] arr){
        int n = arr.length;

        int iknow[] = new int[n];
        int knowme[] = new int[n];

        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                int x = arr[i][j];

                if(x == 1){
                    iknow[i]++;   // i knows someone
                    knowme[j]++;  // someone knows j
                }
            }
        }

        // Find celebrity
        for (int i = 0; i < n; i++) {
            if (iknow[i] == 0 && knowme[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}

//
//🧠 Step 1: Initialize arrays
//iKnow  = [0, 0, 0, 0]
//knowMe = [0, 0, 0, 0]
//
//        🧠 Step 2: Traverse the matrix
//Row 0:
//
//mat[0][1] = 1 → 0 knows 1
//
//mat[0][2] = 1 → 0 knows 2
//
//mat[0][3] = 1 → 0 knows 3
//
//iKnow  = [3, 0, 0, 0]
//knowMe = [0, 1, 1, 1]
//
//Row 1:
//
//mat[1][2] = 1 → 1 knows 2
//
//mat[1][3] = 1 → 1 knows 3
//
//iKnow  = [3, 2, 0, 0]
//knowMe = [0, 1, 2, 2]
//
//Row 2:
//
//All zeros → 2 knows nobody
//
//iKnow  = [3, 2, 0, 0]
//knowMe = [0, 1, 2, 2]
//
//Row 3:
//
//mat[3][1] = 1 → 3 knows 1
//
//mat[3][2] = 1 → 3 knows 2
//
//iKnow  = [3, 2, 0, 2]
//knowMe = [0, 2, 3, 2]
//
//        🧠 Step 3: Identify the Celebrity
//
//Check condition:
//
//iKnow[i] == 0
//knowMe[i] == n - 1 (3)
//
//Person 2:
//iKnow[2]  = 0
//knowMe[2] = 3  ✅
//
//
//        🎉 Person 2 is the CELEBRITY
//
//✅ Final Answer
//Celebrity index = 2