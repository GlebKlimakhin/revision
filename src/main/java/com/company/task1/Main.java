package com.company.task1;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .setAddress("Paris")
                .setAge(60)
                .setCountry("France")
                .setFirstName("Jean")
                .setLastName("Sartre")
                .setGender("Male")
                .setMiddleName("Paul")
                .setPhone("59909898987")
                .build();

        System.out.println(person.toString());
    }
}
