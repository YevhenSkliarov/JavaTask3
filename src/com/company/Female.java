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
            return giveBirthToAMan(p);
        } else {
            System.out.println("Couple decide break up");
            return null;
        }
    }

    public Person giveBirthToAMan(Person p) {
        float height;
        float weight;
        Scanner in = new Scanner(System.in);
        boolean gender = Math.random() < 0.5;
        String child = gender ? "boy" : "girl";
        System.out.println("Couple will have a " + child + " Please input children name:");
        String name = in.next();
        String surname = p.surname;
        if (gender) {
            height = p.height + ((this.height - p.height) * 0.1F);
            weight = p.weight + ((this.weight - p.weight) * 0.1F);
        } else {
            height = this.height + ((p.height - this.height) * 0.1F);
            weight = this.weight + ((p.weight - this.weight) * 0.1F);
        }
        System.out.println("Children was born");
        Person person = gender ? new Male(gender, name, surname, height, weight) : new Female(gender, name, surname, height, weight);
        System.out.println(person);
        return person;
    }
}
