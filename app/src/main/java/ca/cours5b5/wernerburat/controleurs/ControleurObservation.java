package ca.cours5b5.wernerburat.controleurs;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.modeles.MParametres;
import ca.cours5b5.wernerburat.modeles.MPartie;
import ca.cours5b5.wernerburat.modeles.Modele;

public class ControleurObservation {
    private static Map<Modele, ListenerObservateur> observations;
    private static MPartie partie;

    static {
        observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

        if (nomModele.equals("MParametres")) {
            observations.put(MParametres.instance, listenerObservateur);
            lancerObservationPremiereFois(MParametres.instance);
        }

        else if (nomModele.equals("MPartie")){
            observations.put(ControleurObservation.partie, listenerObservateur);
            lancerObservationPremiereFois(ControleurObservation.partie);
        }

    }

    public static void lancerObservation(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if (listenerObservateur != null) {
            listenerObservateur.reagirChangementAuModele(modele);
        }
    }

    public static void lancerObservationPremiereFois(Modele modele){
        ListenerObservateur listenerObservateur = observations.get(modele);
        if (listenerObservateur != null) {
            listenerObservateur.reagirNouveauModele(modele);
        }
    }
}
