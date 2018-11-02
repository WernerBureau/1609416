package ca.cours5b5.wernerburat.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.wernerburat.exceptions.ErreurModele;
import ca.cours5b5.wernerburat.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

        String cle = getCle(cheminSauvegarde);


        if(bundle != null && bundle.containsKey(cle)){

            String json = bundle.getString(cle);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            listenerChargement.reagirSucces(objetJson);

        }else{
            listenerChargement.reagirErreur(new ErreurModele("Clé inexistante"));

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        String cle = getCle(cheminSauvegarde);


        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cle, json);

        }
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){

    }

    private String getCle(String cheminDeSauvegarde){
        return getNomModele(cheminDeSauvegarde);
    }
}