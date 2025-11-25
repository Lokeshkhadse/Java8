package DesignPattern.Creational;

// it is use to build complex object  or use @builder annotation

class User{
    private int no;
    private String name;

    private User (UserBuilder userBuilder){
        this.no = userBuilder.no;
        this.name=userBuilder.name;
    }

     public static class UserBuilder{
         private int no;
         private String name;

         public UserBuilder setNo(int no){
             this.no = no;
             return this;
         }

         public UserBuilder setName(String name){
             this.name = name;
             return this;
         }

         public User build(){
             return new User(this);
         }
     }

    @Override
    public String toString() {
        return no + " | " + name ;
    }
}


public class Builder {
    public static void main(String[] args) {

        User user = new User.UserBuilder().setNo(1).setName("loki").build();

        System.out.println(user);
    }
}
