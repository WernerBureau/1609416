package ca.cours5b5.wernerburat.modeles;

import android.util.Log;

public class MJoueur {
    private String nomJoueur;

    public MJoueur(String username) {
        nomJoueur = username.split("@")[0];
        Log.d("testUsername", getNomJoueur());
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nom) {
        nomJoueur = nom.split("@")[0];
    }
}
