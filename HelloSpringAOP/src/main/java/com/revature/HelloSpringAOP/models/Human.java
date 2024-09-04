package com.revature.HelloSpringAOP.models;

import org.springframework.stereotype.Component;

@Component //Make this class a bean so SpringAOP can generate logs off of it
public class Human {

    //3 human fields
    private String name;
    private int age;
    private String occupation;

    //method that returns a String or throws an exception
    public String eat(int calories){

        if(calories < 0){
            throw new IllegalArgumentException("That doesn't even make sense...");
        }

        if(calories > 50000){
            throw new IllegalArgumentException("That's too many calories! You're gonna explode");
        }

        return "I am eating " + calories + " calories";
    }

    //no args, all args, and some getters/setters, toString
    public Human() {
    }

    public Human(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
