package Greedy_Algo.LemonadeChange;

public class Lemonade_Change {   //each lemonds price is 5$ , give customer to changes of 5,10,20$
    public static void main(String[] args) {
        int bills[] = {5,5,5,10,20};
        boolean res = lemonadeChange(bills);
        System.out.println("result is -> " + res);
    }

    public static boolean lemonadeChange(int[] bills) {

        int five = 0 , ten = 0;

        for(int i = 0 ;i<bills.length;i++){
            if(bills[i] == 5){
                five = five +1;
            }else if(bills[i] == 10){
                if(five > 0){
                    five = five-1;
                    ten = ten+1;
                }else{
                    return false;
                }
            }else{
                if(ten>0 && five>0){
                    ten = ten-1;
                    five = five-1;
                }else if(five >= 3){
                    five = five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
