package org.example.patterns;

public interface AbstractFactory<T>{
    T create(String v);
}

 interface Animal {

}

class AnimalFactory implements AbstractFactory<Animal> {

    @Override
    public Animal create(String v) {
        return new Dog();
    }
}

class Dog implements Animal {

}
