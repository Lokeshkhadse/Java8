package Marker_Interface;

public class MarkerTest {
    public static void main(String[] args) {
        Employee emp = new Employee("loki",101);

        if(emp instanceof Marker){
            System.out.println("created marker interface");
            emp.display();
        }else{
            System.out.println("not marker interface");
        }
    }
}
