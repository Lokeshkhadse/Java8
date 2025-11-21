package Normal_Code;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Check_Anagram {
    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "tac";

        boolean ans = s1.length() == s2.length() &&
                 s1.chars().boxed().sorted().collect(Collectors.toList()).
                         equals(s2.chars().boxed().sorted().collect(Collectors.toList()));

        System.out.println(ans);

    }
}
