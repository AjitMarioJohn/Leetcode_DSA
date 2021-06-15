package com.questions.concept.enums;

public class Person {

    private String name;
    private Gender gender;
    enum Gender{
        MALE, FEMALE
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person: {" +
                "name: '" + name + '\'' +
                ", gender: " + gender +
                '}';
    }
}
