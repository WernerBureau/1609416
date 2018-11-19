package ca.cours5b5.wernerburat.modeles;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.wernerburat.exceptions.ErreurSerialisation;
import ca.cours5b5.wernerburat.global.GCouleur;
import ca.cours5b5.wernerburat.global.GDirection;


public class MGrille extends Modele  {

    private List<MColonne> colonnes;

    public MGrille(int largeur){

        colonnes = new ArrayList<>();

        initialiserColonnes(largeur);

    }

    private void initialiserColonnes(int largeur) {

        for(int i=0; i<largeur; i++){

            colonnes.add(new MColonne());

        }
    }

    public boolean siCouleurGagne(GCouleur couleur, int pourGagner){
        for(int i = 0; i < colonnes.size(); i++){
            if (siCouleurGagneCetteColonne(couleur, i, pourGagner)){
                return true;
            }
        }
        return false;
    }

    private boolean siCouleurGagneCetteColonne(GCouleur couleur, int idColonne, int pourGagner){
        for (int i = 0; i < colonnes.get(idColonne).nombreDeJetons(); i++){
            if (siCouleurGagneCetteCase(couleur, idColonne, i, pourGagner)){
                return true;
            }
        }
        return false;
    }

    private boolean siCouleurGagneCetteCase(GCouleur couleur, int idColonne, int idRangee, int pourGagner){
        for(int i = 0; i < GDirection.directions.size(); i++){
            if (siCouleurGagneCetteDirection(couleur, idColonne, idRangee, GDirection.directions.get(i), pourGagner)){
                return true;
            }
        }
        return false;
    }

    private boolean siCouleurGagneCetteDirection(GCouleur couleur, int idColonne, int idRangee, GDirection direction, int pourGagner){
        if(pourGagner==1){
            return true;
        } else if (siMemeCouleurCetteCase(couleur, idColonne, idRangee)){
            idColonne += direction.incrementHorizontal;
            idRangee += direction.incrementVertical;

            if (siDansLaGrille(idColonne, idRangee)){
                pourGagner--;

                return siCouleurGagneCetteDirection(couleur, idColonne, idRangee, direction, pourGagner);
            }
        }
        return false;
    }

    private boolean siMemeCouleurCetteCase(GCouleur couleur, int idColonne, int idRangee){
        MColonne colonne = colonnes.get(idColonne);
        GCouleur couleurActuelle = colonne.getJetons().get(idRangee);

        return couleurActuelle.equals(couleur);
    }

    private boolean siDansLaGrille(int idColonne, int idRangee){
        if(idColonne >= 0 && idRangee >= 0){
            if(idColonne < colonnes.size() && idRangee < colonnes.get(idColonne).nombreDeJetons()){
                return true;
            }
        }

        return false;
    }

    public List<MColonne> getColonnes() {
        return colonnes;
    }


    public void placerJeton(int colonne, GCouleur couleur) {

        colonnes.get(colonne).placerJeton(couleur);

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }

}
