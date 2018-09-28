package ca.cours5b5.wernerburat.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;

import static java.lang.StrictMath.max;

public class MParametres extends Modele implements Fournisseur{

    //FIXME: temporaire, on va écrire un controleurModeles à l'atelier 9.
    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie;
    private String __parametresPartie = "parametresPartie";


    private List<Integer> choixHauteur;
    private List<Integer> choixLargeur;
    private List<Integer> choixPourGagner;

    public List<Integer> getChoixHauteur(){
        return this.choixHauteur;
    }

    public List<Integer> getChoixLargeur(){
        return this.choixLargeur;
    }

    public List<Integer> getChoixPourGagner(){
        return this.choixPourGagner;
    }


    public MParametres() {

        parametresPartie = new MParametresPartie();

        choixHauteur = new ArrayList<>();
        choixLargeur = new ArrayList<>();
        choixPourGagner = new ArrayList<>();

        genererListesDeChoix();
    }

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    private void genererListesDeChoix(){

        choixHauteur = genererListeChoix(GConstantes.HAUTEURMIN, GConstantes.HAUTEURMAX);
        choixLargeur = genererListeChoix(GConstantes.LARGEURMIN, GConstantes.LARGEURMAX);
        choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(), parametresPartie.getLargeur()) * 75 / 100);

        fournirActions();
    }
    private void fournirActions(){
        ControleurAction.fournirAction(this,
                GCommande.CHOISIR_HAUTEUR,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        parametresPartie.setHauteur((int) args[0]);
                        choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(), parametresPartie.getLargeur()) * 75 / 100);
                    }
                });

        ControleurAction.fournirAction(this,
                GCommande.CHOISIR_LARGEUR,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        parametresPartie.setLargeur((int) args[0]);
                        choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, max(parametresPartie.getHauteur(), parametresPartie.getLargeur()) * 75 / 100);
                    }
                });

        ControleurAction.fournirAction(this,
                GCommande.CHOISIR_POUR_GAGNER,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        parametresPartie.setPourGagner((int) args[0]);
                    }
                });
    }

    private List<Integer> genererListeChoix(int min, int max){
        List<Integer> liste = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            liste.add(i);
        }

        return liste;
    }

    //Récupérer
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        for(Map.Entry entry : objetJson.entrySet()){

            if(entry.getKey().equals(parametresPartie.__hauteur)){
                parametresPartie.setHauteur(Integer.valueOf((String)entry.getValue()));
            }

            else if(entry.getKey().equals(parametresPartie.__largeur)){
                parametresPartie.setLargeur(Integer.valueOf((String)entry.getValue()));
            }

            else if(entry.getKey().equals(parametresPartie.__pourGagner)){
                parametresPartie.setPourGagner(Integer.valueOf((String)entry.getValue()));
            }
        }
    }

    //Sauvegarder
    @Override
    public Map<String, Object> enObjetJson() {

        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(parametresPartie.__hauteur, parametresPartie.getHauteur().toString());
        objetJson.put(parametresPartie.__largeur, parametresPartie.getLargeur().toString());
        objetJson.put(parametresPartie.__pourGagner, parametresPartie.getPourGagner().toString());

        return objetJson;
    }

}
