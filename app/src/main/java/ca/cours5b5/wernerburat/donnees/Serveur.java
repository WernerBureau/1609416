package ca.cours5b5.wernerburat.donnees;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.ControleurModeles;

public final class Serveur extends SourceDeDonnees {
    /*
     * Serveur est un singleton
     */

    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson){
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement){
        return null;
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){

    }
}
