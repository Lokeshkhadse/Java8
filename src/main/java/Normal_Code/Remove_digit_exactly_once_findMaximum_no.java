package Normal_Code;

import java.util.Scanner;

public class Remove_digit_exactly_once_findMaximum_no {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your number string");
        String s = scanner.next();

        System.out.println("enter your character number");
        char digit = scanner.next().charAt(0);

        String checkdigit = String.valueOf(digit);

        if(!s.contains(checkdigit)){
            System.out.println(s);
        }

        String max = "";
        //String max = null;  for Integer.parseInt() Through compare

        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i) == digit) {

                String formed = s.substring(0, i) + s.substring(i + 1);

                if (max.equals("") || formed.compareTo(max) > 0) {
                    max = formed;
                }

                //IntegerParseInt() using
                //if(max == null || Integer.parseInt(formed) > Integer.parseInt(max)){
                //max = formed;
                // }
            }
        }
        System.out.println("Maximum number: " + max);
        scanner.close();
    }
}



// or approach

//for(int i = 0 ;i<s.length()-1;i++){
//    if(s.charAt(i) == digit && s.charAt(i+1) > digit){
//        return s.substring(0,i) + s.substring(i+1);
//        }
// }
//
//// fallback: remove last occurrence
//int lastIndex = s.lastIndexOf(digit);
//        return s.substring(0, lastIndex) + s.substring(lastIndex + 1);

