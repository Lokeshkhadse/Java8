package Normal_Code;

public class Abc {
    static class Inner{
        void display(){
            System.out.println("not static method inside static class");
        }
    }

    static class SecondInner{
        static void display2(){
            System.out.println("static method");
        }
    }

    public static void main(String[] args) {
        Abc.Inner obj = new Abc.Inner();
        obj.display();  //calling not static method inside Inner static class

        Abc.SecondInner.display2(); // calling static method inside Inner static class
    }
}
