package ca.cours5b5.wernerburat.donnees;

import java.util.Map;

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

    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde){
        return null;
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){

    }
}
