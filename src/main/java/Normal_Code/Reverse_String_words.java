package Normal_Code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Reverse_String_words {
    public static void main(String[] args) {
        String s = "hi my name is loki";

        String words[] = s.split(" ");

//        StringJoiner joiner = new StringJoiner(" ");
//
//        for(int i = words.length-1;i>=0;i--){
//            joiner.add(words[i]);
//        }
//        String rev = joiner.toString();
//
//        System.out.println(rev);

        String revwords[] = new String[words.length];
        int k  = 0;

        for(int i = words.length-1;i>=0;i--){
            revwords[k++] = words[i];
        }

        String rev = Arrays.stream(revwords).collect(Collectors.joining(" "));
        System.out.println(rev);
    }
}
