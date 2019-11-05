package com.company;

public abstract class Person {
    boolean gender;
    String name;
    String surname;
    float height;
    float weight;

    public Person(boolean gender, String name, String surname, float height, float weight) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
    }

    public abstract boolean talk(Person p);

    public abstract boolean tolerate(Person p);

    public abstract boolean spendTimeTogether(Person p);

    public abstract Person relations(Person p);

}
