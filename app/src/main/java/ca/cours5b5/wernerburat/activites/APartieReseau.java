package ca.cours5b5.wernerburat.activites;

import android.os.Bundle;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.controleurs.ControleurModeles;
import ca.cours5b5.wernerburat.controleurs.ControleurPartieReseau;
import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.modeles.MPartieReseau;

public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);
    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MPartieReseau.class.getSimpleName());

        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();
        ControleurPartieReseau.getInstance().deconnecterDuServeur();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ControleurPartieReseau.getInstance().connecterAuServeur();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
