package DesignPattern.Creational;

//: Provide an interface for creating families of related objects without specifying concrete classes

interface Button{
    void click();
}

interface Checkbox{
    void check();
}

class WindowButton implements  Button{
    @Override
    public void click() {
        System.out.println("WindowButton object created");
    }
}

class WindowChekbox implements Checkbox{
    @Override
    public void check() {
        System.out.println("WindowCheckbox object created");
    }
}

class MacButton implements Button{
    @Override
    public void click() {
        System.out.println("MacButton object created");
    }
}

class MacCheckbox implements  Checkbox{
    @Override
    public void check() {
        System.out.println("MacCheckbox object created");
    }
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckBox();
}

class WinFactory implements GUIFactory{
    public Button createButton() {
        return new WindowButton();
    }

    public Checkbox createCheckBox(){
        return new WindowChekbox();
    }
}

 class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

     public Checkbox createCheckBox() {
        return new MacCheckbox();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        GUIFactory factory = new WinFactory();
        Button b = factory.createButton();
        Checkbox c = factory.createCheckBox();

        b.click();
        c.check();
    }
}
