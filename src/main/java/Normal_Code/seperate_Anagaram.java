package Normal_Code;

import java.util.*;

public class seperate_Anagaram {
    public static void main(String[] args) {
        String arr[] = {"cat","food","rat","doof"};

        Map<String, List<String>>map = new HashMap<>();

        for(String word:arr){

             char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

//            if(map.containsKey(sorted)){
//                map.get(sorted).add(word);
//            }else{
//                List<String> list = new ArrayList<>();
//                list.add(word);
//                map.put(sorted,list);
//            }

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> obj :map.entrySet()){
            ans.add(new ArrayList<>(obj.getValue()));
        }
        System.out.println(ans);

    }
}
