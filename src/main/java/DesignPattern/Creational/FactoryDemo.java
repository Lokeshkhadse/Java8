package DesignPattern.Creational;

public class FactoryDemo {
    public static void main(String[] args) {

        ShapeFactory factory= new ShapeFactory();

        shape s1  = factory.getshape("circle");

        s1.draw();
    }
}

interface shape{
    void draw();
}

class circle implements shape{
    @Override
    public void draw() {
        System.out.println("circle shape");
    }
}

class square implements shape{
    @Override
    public void draw() {
        System.out.println("square shape");
    }
}

class ShapeFactory{
    public shape getshape(String type){
        return switch(type.toLowerCase()){
            case "circle" -> new circle();
            case "square" -> new square();
            default -> null;
        };
    }
}

