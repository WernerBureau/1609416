package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.controleurs.ControleurObservation;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.donnees.SourceDeDonnees;
import ca.cours5b5.wernerburat.exceptions.ErreurObservation;
import ca.cours5b5.wernerburat.global.GCouleur;
import ca.cours5b5.wernerburat.modeles.MParametresPartie;
import ca.cours5b5.wernerburat.modeles.MPartie;
import ca.cours5b5.wernerburat.modeles.Modele;


public class VPartie extends Vue {

    private VGrille grille;

    private TextView joueur1;
    private TextView joueur2;

    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initialiser();

        observerPartie();

    }

    private void initialiser() {

        grille = findViewById(R.id.grille);

        joueur1 = findViewById(R.id.texte_joueur_un);
        joueur2 = findViewById(R.id.texte_joueur_deux);
    }

    private void observerPartie() {

        ControleurObservation.observerModele(getNomModele(),
                new ListenerObservateur() {
                    @Override
                    public void reagirNouveauModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        preparerAffichage(partie);

                        miseAJourGrille(partie);

                    }

                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        MPartie partie = getPartie(modele);

                        miseAJourGrille(partie);

                    }
                });
    }

    private void preparerAffichage(MPartie partie) {

        MParametresPartie parametresPartie = partie.getParametres();

        grille.creerGrille(parametresPartie.getHauteur(), parametresPartie.getLargeur());

    }

    private MPartie getPartie(Modele modele){

        try{

            return (MPartie) modele;

        }catch(ClassCastException e){

            throw new ErreurObservation(e);

        }

    }

    protected String getNomModele(){
        return MPartie.class.getSimpleName();
    }

    private void miseAJourGrille(MPartie partie){
        grille.afficherJetons(partie.getGrille());
        setCouleur(partie.getCouleurCourante());
    }

    private void setCouleur(GCouleur couleurCourante){

        switch(couleurCourante){
            case ROUGE:
                joueur1.setBackgroundColor(Color.RED);
                joueur2.setBackgroundColor(Color.WHITE);
                break;
            case JAUNE:
                joueur1.setBackgroundColor(Color.WHITE);
                joueur2.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

}
