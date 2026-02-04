package Normal_Code;

public class LCM_Using_GCD {
    public static void main(String[] args) {
        int a = 18;
        int b = 12;

        int lcm = (a*b)/gcd(a,b);
        System.out.println("lcm is -> " + lcm);
    }
    public static int gcd(int a, int b){
        while(b!= 0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        return a;
    }
}
