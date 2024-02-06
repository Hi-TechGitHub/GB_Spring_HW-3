package com.example.example3.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
    private int id;
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email){
        this.age = age;
        this.name = name;
        this.email = email;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}