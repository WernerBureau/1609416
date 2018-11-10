package ca.cours5b5.wernerburat.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.cours5b5.wernerburat.controleurs.ControleurModeles;
import ca.cours5b5.wernerburat.donnees.Disque;
import ca.cours5b5.wernerburat.donnees.SauvegardeTemporaire;
import ca.cours5b5.wernerburat.donnees.Serveur;
import ca.cours5b5.wernerburat.donnees.Transition;
import ca.cours5b5.wernerburat.modeles.MParametres;


public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialiserControleurModeles(savedInstanceState);
        initialiserApplication();

    }

    protected void initialiserControleurModeles(Bundle savedInstanceState) {

        /*TODO : ajouter Transition dans la séquence de chargement, utiliser les extras de
                 l'intention pour initialiser Transition
         */

        ControleurModeles.setSequenceDeChargement(
                new SauvegardeTemporaire(savedInstanceState),
                Serveur.getInstance(),
                Disque.getInstance());
        
    }

    protected void initialiserApplication(){

        Disque.getInstance().setRepertoireRacine(getFilesDir());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MParametres.class.getSimpleName(),
                new SauvegardeTemporaire(outState));
    }

}
