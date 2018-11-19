package ca.cours5b5.wernerburat.controleurs.interfaces;

import ca.cours5b5.wernerburat.controleurs.Action;
import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GCouleur;

public class ControleurPartie {
    private ControleurPartie(){}

    private static final ControleurPartie instance = new ControleurPartie();

    public static ControleurPartie getInstance(){
        return instance;
    }

    public void gagnerPartie(GCouleur couleurGagnante){
        Action actionGagner = ControleurAction.demanderAction(GCommande.AFFICHER_GAGNANT);
        actionGagner.setArguments(couleurGagnante);
        actionGagner.executerDesQuePossible();
    }
}
