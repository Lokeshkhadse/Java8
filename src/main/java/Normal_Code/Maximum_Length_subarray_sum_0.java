package Normal_Code;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Length_subarray_sum_0 {

    public static void main(String[] args) {

        int arr[] = {6, -2, 2, -8, 1, 7, 4, -10};

        int n = arr.length;

        int sum = 0;
        int maxlen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            sum = sum + arr[i];

            // If sum becomes 0
            if (sum == 0) {
                maxlen = i + 1;
            }

            // If same sum already exists
            if (map.containsKey(sum)) {

                maxlen = Math.max(maxlen, i - map.get(sum));

            } else {

                map.put(sum, i);
            }
        }

        System.out.println("Maximum length of subarray is -> " + maxlen);
    }
}