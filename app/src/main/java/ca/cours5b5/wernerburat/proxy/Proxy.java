package ca.cours5b5.wernerburat.proxy;

import com.google.firebase.database.DatabaseReference;

public abstract class Proxy {
    private String cheminServeur;

    protected DatabaseReference noeudServeur;

    public Proxy(String cheminServeur){

    }

    public void connecterAuServeur(){
        // TODO: Obtenir le noeud
    }

    public void deconnecterDuServeur(){
        // TODO: Oublier le noeud
    }

    public abstract void detruireValeurs();
}
