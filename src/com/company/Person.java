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

    public boolean spendTimeTogether(Person p) {
        float max;
        float min;
        float diff = p.height > this.height ? p.height * 0.1F : this.height * 0.1F;
        System.out.println(this.height);
        System.out.println(p.height);
        if (this.height > p.height) {
            max = this.height;
            min = p.height;
        } else {
            max = p.height;
            min = this.height;
        }
        boolean s = max - min > diff ? Math.random() < 0.85 : Math.random() < 0.95;
        if (s) {
            System.out.println("Couple spend a lot of time together");
        } else {
            System.out.println("Couple spend a not lot of time together");
        }
        return s;
    }

    public abstract Person relations(Person p);
}
