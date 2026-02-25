package WorldAnimal;

class Animal {
    String color = "White";


    Animal() {
        System.out.println("Animal constructor called");
    }


    void sound() {
        System.out.println("Animal makes a sound");
    }
}


class Dog extends Animal {
    String color = "Black";


    Dog() {
        super();
        System.out.println("Dog constructor called");
    }

    void displayColor() {

        System.out.println("Dog color: " + color);
        System.out.println("Animal color: " + super.color);
    }

    @Override
    void sound() {
        System.out.println("Dog barks");

        super.sound();
    }
}


public class SuperKeywordDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.displayColor();
        d.sound();
    }
}
