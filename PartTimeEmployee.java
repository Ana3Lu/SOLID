package com.example.demo.unsolid;

public class PartTimeEmployee implements DeparmentEmployee {
    
    String departament;

    public PartTimeEmployee(String departament) {
        this.departament = departament;
    }

    @Override
    public String getDepartament() {
        return departament;
    }
}
