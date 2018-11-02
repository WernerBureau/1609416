package ca.cours5b5.wernerburat.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    protected String getNomModele(String cheminDeSauvegarde){
        return cheminDeSauvegarde.split("/")[0];
    }

    public abstract void detruireSauvegarde(final String cheminSauvegarde);

}
