package ca.cours5b5.wernerburat.controleurs;

import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.modeles.Modele;

public class ControleurObservation {
    private static Map<Modele, ListenerObservateur> observations;

    static {

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){

    }

    public static void lancerObservation(Modele modele){

    }
}
