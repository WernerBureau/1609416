package ca.cours5b5.wernerburat.modeles;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;
import ca.cours5b5.wernerburat.vues.VParametres;

public class MParametres extends Modele{

    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    private final String __pourGagner = "pourGagner";

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
        hauteur = GConstantes.HAUTEURDEFAUT;
        largeur = GConstantes.LARGEURDEFAUT;
        pourGagner = GConstantes.HAUTEURDEFAUT;

        choixHauteur = new ArrayList<Integer>();
        choixLargeur = new ArrayList<Integer>();
        choixPourGagner = new ArrayList<Integer>();

        genererListesDeChoix();
    }



    public Integer getHauteur(){
        return this.hauteur;
    }

    public Integer getLargeur(){
        return this.largeur;
    }

    public Integer getPourGagner(){
        return this.pourGagner;
    }

    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur){
        this.largeur = largeur;
    }

    public void setPourGagner(int pourGagner){
        this.pourGagner = pourGagner;
    }

    private void genererListesDeChoix(){
        choixHauteur = genererListeChoix(GConstantes.HAUTEURMIN, GConstantes.HAUTEURMAX);
        choixLargeur = genererListeChoix(GConstantes.LARGEURMIN, GConstantes.LARGEURMAX);
        choixPourGagner = genererListeChoix(GConstantes.GAGNERMIN, GConstantes.GAGNERMAX);

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
    public void aPartirObjetJson(Map<String, Object> objectJson) {
        for(Map.Entry entry : objectJson.entrySet()){

            if(entry.getKey().equals("hauteur")){
                hauteur = Integer.valueOf((String)entry.getValue());
            }

            else if(entry.getKey().equals("largeur")){
                largeur = Integer.valueOf((String)entry.getValue());
            }

            else if(entry.getKey().equals("pourGagner")){
                pourGagner = Integer.valueOf((String)entry.getValue());
            }
        }
    }

    //Sauvegarder
    @Override
    public Map<String, Object> enObjetJson() {

        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur, hauteur);
        objetJson.put(__largeur, largeur);
        objetJson.put(__pourGagner, pourGagner);

        return objetJson;
    }


//    private void genererListeChoixHauteur(){
//
//    }
//
//    private void genererListeChoixLargeur(){
//
//    }
//
//    private void genererListeChoixPourGagner(){
//
//    }

}
