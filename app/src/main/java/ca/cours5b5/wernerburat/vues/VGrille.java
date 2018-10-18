package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.wernerburat.controleurs.Action;
import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GCouleur;
import ca.cours5b5.wernerburat.modeles.MColonne;
import ca.cours5b5.wernerburat.modeles.MGrille;

public class VGrille extends GridLayout {
    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Action actionEnTete;

    private VCase[][] tabCases;

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier06", "Appellation de VGrille::onFinishInflate");
    }

    void creerGrille(int hauteur, int largeur){
        tabCases = new VCase[hauteur][largeur];
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);
    }

    private void ajouterEnTetes(int largeur){

        for (int i = 0; i < largeur; i++ ){
            VEntete entete = new VEntete(getContext(), i);
            installerListenerEntete(entete, i);
            addView(entete, getMiseEnPageEntete(i));
        }
        demanderActionEntete();
    }


    private LayoutParams getMiseEnPageEntete(int colonne) {
        int rangee = 0;

        float poidsRangee = 3;
        float poidsColonne = 1;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

    private void ajouterCases(int hauteur, int largeur){
        for(int i = 1; i<hauteur+1; i++) {
            for(int j =0; j<largeur; j++){
                VCase caseTemp = new VCase(getContext(), j, (hauteur-i));
                addView(caseTemp, getMiseEnPageCase(i, j));
                tabCases[hauteur-i][j] = caseTemp;
            }
        }
    }

    private void demanderActionEntete(){
        actionEnTete = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);
    }

    private void installerListenerEntete(VEntete entete, final int colonne){
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionEnTete.setArguments(colonne);
                actionEnTete.executerDesQuePossible();
            }
        });
    }

    void afficherJetons(MGrille grille){
        List<MColonne> listeColonne = grille.getColonnes();
        for (int i = 0; i < listeColonne.size(); i++){
            MColonne colonneActuelle = listeColonne.get(i);
            for (int j = 0; j < colonneActuelle.getJetons().size(); j++){
                afficherJeton(i,j,colonneActuelle.getJetons().get(j));
            }
        }
    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){
        tabCases[rangee][colonne].afficherJeton(jeton);
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        float poidsRangee = 1;
        float poidsColonne = 1;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }
}
