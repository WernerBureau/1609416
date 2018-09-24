package ca.cours5b5.wernerburat.controleurs;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.modeles.MParametres;
import ca.cours5b5.wernerburat.modeles.Modele;

public class ControleurObservation {
    private static Map<Modele, ListenerObservateur> observations;

    static {
        observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        observations.put(MParametres.instance, listenerObservateur); //FIXME Atelier07
        lancerObservation(MParametres.instance);
    }

    public static void lancerObservation(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if (listenerObservateur != null) {
            listenerObservateur.reagirChangementAuModele(modele);
        }
    }
}
