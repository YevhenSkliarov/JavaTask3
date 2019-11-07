package com.company;

public class Male extends Person {
    public Male(boolean gender, String name, String surname, float height, float weight) {
        super(gender, name, surname, height, weight);
    }

    @Override
    public String toString() {
        return "Male{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean talk(Person p) {
        if (this.gender != p.gender) {
            System.out.println("Talkative couple");
            return true;
        } else {
            System.out.println("Boys couple");
            return Math.random() < 0.5;
        }
    }

    @Override
    public boolean tolerate(Person p) {
        return this.gender == p.gender ? Math.random() > 0.056 : Math.random() < 0.7;
    }

    @Override
    public Person relations(Person p) {
        if ((talk(p) && tolerate(p) && spendTimeTogether(p)) && (this.gender != p.gender)) {
            Female f = (Female) p;
            System.out.println("Couple decide to have a child");
            return f.giveBirthToAMan(this);
        } else {
            System.out.println("Couple decide break up");
            return null;
        }
    }
}
