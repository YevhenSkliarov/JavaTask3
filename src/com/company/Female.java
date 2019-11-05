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
        boolean truthy = Math.random() < 0.05;
        boolean falthy = Math.random() < 0.7;
        return this.gender == p.gender ? truthy : falthy;
    }

    @Override
    public boolean spendTimeTogether(Person p) {
        float diff = p.height > this.height ? p.height * 0.1F : this.height * 0.1F;
        boolean s = this.height - p.height > diff || p.height - this.height > diff ? Math.random() < 0.85 : Math.random() < 0.95;
        if (s) {
            System.out.println("Couple compatibility 85%");
        } else {
            System.out.println("Couple compatibility 95%");
        }
        return s;
    }

    @Override
    public Person relations(Person p) {
        if ((talk(p) && tolerate(p) && spendTimeTogether(p)) && this.gender != p.gender) {
            System.out.println("Couple decide to have a child");
            return giveBirthToAMan(p);
        } else {
            System.out.println("Couple decide break up");
            return null;
        }
    }

    public static Person giveBirthToAMan(Person p) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input children name:");
        String name = in.next();
        boolean gender = Math.random() < 0.5;
        System.out.println(gender);
        String surname = p.surname;
        float height = p.height * 0.9F;
        float weight = p.height * 0.9F;
        System.out.println("Children was born");
        Person person = gender?new Male(gender, name, surname, height, weight):new Female(gender, name, surname, height, weight);;
        System.out.println(person);
        return person;
    }
}
