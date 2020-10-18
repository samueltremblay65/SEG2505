package com.example.livrable1;

public class Employee extends Utilisateur {
    public Employee(String username, String prenom, String nom, String email, String password) {
        super(username, prenom, nom, email, password, Role.EMPLOYEE);
    }
}
