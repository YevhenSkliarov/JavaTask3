package com.company;

import java.util.Scanner;

public class Female extends Person {
    public Female(boolean gender, String name, String surname, float height, float weight) {
        super(gender, name, surname, height, weight);
    }

    @Override
    public String toString() {
        return "Female{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean talk(Person p) {
        System.out.println("Talkative couple");
        return this.gender == p.gender ? true : true;
    }

    @Override
    public boolean tolerate(Person p) {
        boolean truthy = Math.random() > 0.05;
        boolean falthy = Math.random() < 0.7;
        return this.gender == p.gender ? truthy : falthy;
    }

    @Override
    public Person relations(Person p) {
        if ((talk(p) && tolerate(p) && spendTimeTogether(p)) && (this.gender != p.gender)) {
            System.out.println("Couple decide to have a child");
            return giveBirthToAMan(p,this);
        } else {
            System.out.println("Couple decide break up");
            return null;
        }
    }

    public static Person giveBirthToAMan(Person m,Person f) {
        float height;
        float weight;
        Scanner in = new Scanner(System.in);
        boolean gender = Math.random() < 0.5;
        String child = gender ? "boy" : "girl";
        System.out.println("Couple will have a " + child + " Please input children name:");
        String name = in.next();
        String surname = m.surname;
        if (gender) {
            height = m.height + ((f.height - m.height) * 0.1F);
            weight = m.weight + ((f.weight - m.weight) * 0.1F);
        } else {
            height = f.height + ((m.height - f.height) * 0.1F);
            weight = f.weight + ((m.weight - f.weight) * 0.1F);
        }
        System.out.println("Children was born");
        Person person = gender ? new Male(gender, name, surname, height, weight) : new Female(gender, name, surname, height, weight);
        System.out.println(person);
        return person;
    }
}
