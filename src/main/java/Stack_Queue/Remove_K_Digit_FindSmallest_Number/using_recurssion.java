package Stack_Queue.Remove_K_Digit_FindSmallest_Number;

public class using_recurssion {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String finalans = removeKdigits(num,k);
        System.out.println(finalans);
    }

    static String  ans = null;

    public static String removeKdigits(String num, int k) {

        solve(0, num, k, new StringBuilder());

        // remove leading zeros
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') i++;

        return (i == ans.length()) ? "0" : ans.substring(i);
    }

    public static void solve(int index, String num, int k, StringBuilder path) {

        // invalid case
        if (k < 0) return;

        // end of string
        if (index == num.length()) {
            if (k == 0) {
                String formed = path.toString();
                if (ans == null || formed.compareTo(ans) < 0) {
                    ans = formed;
                }
            }
            return;
        }

        // ✅ PICK (keep digit)
        path.append(num.charAt(index));
        solve(index + 1, num, k, path);
        path.deleteCharAt(path.length() - 1);

        // ❌ NOT PICK (remove digit)
        solve(index + 1, num, k - 1, path);
    }
}
