package com.mytests.spring.webflux.webfluxmustache.data;

/**
 * *******************************
 * Created by irina on 3/9/2020.
 * Project: webflux-mustache
 * *******************************
 */
public class Student {
    
    String firstName;
    String lastName;
    int age;
    Gender gender;
    int group;

    public Student(String firstName, String lastName, int age, Gender gender, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getGroup() {
        return group;
    }
}
