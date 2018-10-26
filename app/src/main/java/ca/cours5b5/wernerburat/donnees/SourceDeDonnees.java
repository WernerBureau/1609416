package ca.cours5b5.wernerburat.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void detruireSauvegarde(final String cheminSauvegarde);

}
