//CODIGO ORIGINAL
package com.example.demo.unsolid;

public class PartTimeEmployee extends Employee {
    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }
}

//SOLUCION PLANTEADA
public class PartTimeEmployee extends Employee {
    private String name;

    public PartTimeEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

