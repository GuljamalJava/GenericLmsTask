package generic.models;

import generic.enums.Gender;

public class Person {
    private Long id;
    private String name;
    private int age;
    private Gender gender;

    public Person() {
    }
    public Person(int age, Gender gender, Long id, String name) {
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '\n'+'}';
    }
}

