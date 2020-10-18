package com.example.livrable1;

public class Admin extends Utilisateur {
    public Admin(String username, String prenom, String nom, String email, String password) {
        super(username, prenom, nom, email, password, Role.ADMIN);
    }
}
