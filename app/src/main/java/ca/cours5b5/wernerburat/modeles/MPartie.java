package ca.cours5b5.wernerburat.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;

public class MPartie extends Modele implements Fournisseur{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie (MParametresPartie parametres){
        MPartie mPartie = new MPartie(parametres);
    }

    public MParametresPartie getParametres(){
        return this.parametres;
    }

    //Récupérer
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

    }

    //Sauvegarder
    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objetJson = new HashMap<>();
        return objetJson;
    }
}
