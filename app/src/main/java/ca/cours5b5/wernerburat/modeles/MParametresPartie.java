package ca.cours5b5.wernerburat.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.wernerburat.exceptions.ErreurDeSerialisation;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

    @AttributSerialisable
    public Integer hauteur;
    protected final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected final String __pourGagner = "pourGagner";

    public static MParametresPartie aPartirMParametres(MParametres mParametres){
        MParametresPartie mParametresPartie;
        mParametresPartie = mParametres.parametresPartie.cloner();

        return mParametresPartie;
    }

    public MParametresPartie cloner(){
        MParametresPartie mParametresPartie = new MParametresPartie();
        mParametresPartie.setHauteur(this.getHauteur());
        mParametresPartie.setLargeur(this.getLargeur());
        mParametresPartie.setPourGagner(this.getPourGagner());

        return mParametresPartie;
    }

    public MParametresPartie(){
        this.hauteur = GConstantes.HAUTEURDEFAUT;
        this.largeur = GConstantes.LARGEURDEFAUT;
        this.pourGagner = GConstantes.GAGNERDEFAUT;
    }

    public Integer getHauteur(){
        return hauteur;
    }

    public Integer getLargeur(){
        return largeur;
    }

    public Integer getPourGagner(){
        return pourGagner;
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


    //Récupérer
    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurDeSerialisation {

    }

    //Sauvegarder
    @Override
    public Map<String, Object> enObjetJson() throws ErreurDeSerialisation {
        Map<String, Object> objetJson = new HashMap<>();
        return objetJson;
    }
}
