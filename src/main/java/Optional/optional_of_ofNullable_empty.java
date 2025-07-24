package Optional;
import java.util.*;

public class optional_of_ofNullable_empty {
    public static void main(String[] args) {

       Optional<String>opt = Optional.of("hii");
        System.out.println(opt.get());          //--> hii
        System.out.println(opt.isEmpty());
         if(opt.isPresent()) System.out.println(opt.map(String::toUpperCase));

         Optional<String> name = Optional.of("");
        System.out.println(name);  //Optional[]

//        Optional<String>name1 = Optional.of(null);
//        System.out.println(name1); // nullPointerException

        System.out.println("**************************************************************");

        Optional<String> abc = Optional.ofNullable("data");
        System.out.println(abc);        //Optional[data]
        System.out.println(abc.get()); //data
        System.out.println(abc.isEmpty());  //false
        System.out.println(abc.isPresent()); //true

        Optional<String> abc1 = Optional.ofNullable("");  //" " not null value
        System.out.println(abc1);  //Optional[]
        System.out.println(abc1.isEmpty());  //false
        System.out.println(abc1.isPresent()); //true

        Optional<String>abc2 = Optional.ofNullable(null);
        System.out.println(abc2.orElse("default"));   //default
        System.out.println(abc2); //Optional.empty
        System.out.println(abc2.isEmpty());  //true
        System.out.println(abc2.isPresent()); //false
        System.out.println("**************************************************************");


        Optional<String> opt3 = Optional.empty();
        System.out.println(opt3);  //Optional.empty
        System.out.println(opt3.orElse("qwe"));   //qwe
//        System.out.println(opt3.get()); //NoSuchElementException


        System.out.println("**************************************************************");
        List<String> names = Arrays.asList("Ajay", "Sunil", "Raj");
        names.stream()
                .map(Optional::ofNullable)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);




    }

}
