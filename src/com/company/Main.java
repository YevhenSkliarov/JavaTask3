package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person p1 = generatePerson();
        Person p2 = generatePerson();
        compatibilityTest(p1,p2);
    }

    private static Person generatePerson() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input true if it's a male person or false if it's a female: ");
        Boolean gen = in.nextBoolean();
        System.out.println("Please input person name: ");
        String name = in.next();
        System.out.println("Please input person surname: ");
        String surname = in.next();
        System.out.println("Please input person height: ");
        float height = in.nextFloat();
        System.out.println("Please input person weight: ");
        float weight = in.nextFloat();
        if (gen == true) {
            System.out.println("Male person with name " + name + " was created");
            return new Male(gen, name, surname, height, weight);
        } else {
            System.out.println("Female person with name " + name + " was created");
            return new Female(gen, name, surname, height, weight);
        }

    }

    private static Person compatibilityTest(Person p1,Person p2){
            Person p3 = p2.relations(p1);
            return p3;
    }
}
