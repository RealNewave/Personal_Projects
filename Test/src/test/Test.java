/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Hans
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog sammy = new Dog("Sammy");
        Cat smokey = new Cat("Smokey");

        System.out.println(Application.getAnimalName(sammy));
        System.out.println(Application.getAnimalName(smokey));

    }

}

abstract class Animal {
    String name;
    Animal(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    
}

class Application {

    /**
     * @return the name of the given​​​​​​​‌​‌‌​​‌‌‌​‌‌​​‌​​​‌‌‌​​​ animal
     */
    static String getAnimalName(Animal a) {
        String name = null;
        if (a instanceof Dog) {
            name = ((Dog) a).getName();
        } else if (a instanceof Cat) {
            name = ((Cat) a).getName();
        }

        return name;
    }
}
