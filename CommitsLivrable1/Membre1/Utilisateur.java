package com.example.livrable1;

public abstract class Utilisateur {
    private String username;
    private String email;
    private String password;
    private Role role;
    private String prenom;
    private String nom;

    public Utilisateur(String username, String prenom, String nom, String email, String password, Role role)
    {
        this.username = username;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPrenom() { return prenom;}

    public String getNom() { return nom; }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public Role getRole()
    {
        return role;
    }
}
