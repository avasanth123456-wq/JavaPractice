package Animals;


// Superclass
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating...");
    }

    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}


class Dog extends Animal {

    Dog(String name) {

        super(name);
    }


    @Override
    void eat() {
        System.out.println(name + " is eating dog food...");
    }


    void bark() {
        System.out.println(name + " is barking: Woof Woof!");
    }
}


public class SuperSubExample {
    public static void main(String[] args) {

        Animal a1 = new Animal("Generic Animal");
        a1.eat();
        a1.sleep();

        System.out.println("----");


        Dog d1 = new Dog("Buddy");
        d1.eat();
        d1.sleep();
        d1.bark();
    }
}

