package tests;

public class Person {
   String name;
     int age;
     String lastname;

    public Person(String name, int age,String lastname) {
        this.name = name;
        this.age = age;
        this.lastname=lastname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}