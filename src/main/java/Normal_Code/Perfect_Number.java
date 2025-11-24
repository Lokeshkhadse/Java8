package Normal_Code;

public class Perfect_Number {
    public static void main(String[] args) {
        int no = 28;
        int sum = 0 ;

        for(int i = 1;i<=no/2;i++){
            if(no % i == 0){
                sum = sum + i;
            }
        }

        boolean value = (sum == no)?true:false;
        System.out.println(value);

    }
}
