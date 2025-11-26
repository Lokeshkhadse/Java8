package Normal_Code;

public class Smallest_Integer_Divisible_by_K {
    public static void main(String[] args) {
        int k = 9;
        int ans = smallestRepunitDivByK(k);
        System.out.println(ans);
    }
    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int rem = 0;

        for (int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0) return len;
        }

        return -1;
    }
}

// more Approach

//    public int smallestRepunitDivByK(int k) {

//         int mini = (int)1e9;
//         int bhetla = 0;

//         for (int n = 1; n <= 1_000_000; n++) {

//             String value = String.valueOf(n);

//             boolean verification = verify(value);

//             if (!verification) continue;

//             int digit = n;

//             // FIXED divisibility condition
//             if (digit % k == 0) {
//                 int length = digitLength(digit);
//                 mini = Math.min(mini, length);
//                 bhetla++;
//                 break;
//             }
//         }

//         return bhetla == 1 ? mini : -1;
//     }

//     public static int digitLength(int number) {
//         return String.valueOf(number).length();
//     }


//     public static boolean verify(String value) {
//         for (char c : value.toCharArray()) {
//             if (c != '1') return false;
//         }
//         return true;
//     }
