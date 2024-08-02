package com.example.demo.unsolid;

public class Employee implements NamedEmployee, DeparmentEmployee {

    String name;
    String departament;

    public Employee(String name, String departament) {
        this.name = name;
        this.departament = departament;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDepartament() {
        return departament;
    }
}
