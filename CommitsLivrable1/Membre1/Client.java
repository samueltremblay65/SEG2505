package com.example.livrable1;

public class Client extends Utilisateur {
    public Client(String username, String prenom, String nom, String email, String password) {
        super(username, prenom, nom, email, password, Role.CLIENT);
    }
}
