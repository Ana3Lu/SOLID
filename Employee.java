package com.example.demo.unsolid;

public class Employee implements NamedEmployee, DeparmentEmployee {

    String name;
    String departament;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDepartament() {
        return departament;
    }
}
