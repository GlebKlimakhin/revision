package com.company.task1;

//via Lombok
//@Builder
public class Person {
    int age;
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    String gender;


    private Person() {

    }

    public static PersonBuilder builder() {
        return new Person().new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    class PersonBuilder {

        private PersonBuilder(){

        }

        public PersonBuilder setAge(int age) {
            Person.this.age = age;
            return this;
        }

        public PersonBuilder setFirstName(String firstName) {
            Person.this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            Person.this.lastName = lastName;
            return this;
        }

        public PersonBuilder setMiddleName(String middleName) {
            Person.this.middleName = middleName;
            return this;
        }

        public PersonBuilder setCountry(String country) {
            Person.this.country = country;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            Person.this.address = address;
            return this;
        }

        public PersonBuilder setPhone(String phone) {
            Person.this.phone = phone;
            return this;
        }

        public PersonBuilder setGender(String gender) {
            Person.this.gender = gender;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }
}
