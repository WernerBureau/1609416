package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.controleurs.ControleurObservation;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.modeles.MPartie;
import ca.cours5b5.wernerburat.modeles.Modele;

public class VPartie extends Vue {

    private VGrille grille;

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
    protected void onFinishInflate(){
        super.onFinishInflate();

    }

    private void initialiser(){
        grille.findViewById(R.id.grille);
    }

    private void observerPartie(){
        String name = MPartie.class.getSimpleName();

        ControleurObservation.observerModele(name, new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele){
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;

                initialiserGrille(partie);
            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
                afficherParametres((MPartie) modele);
            }
        });
    }

    private MPartie getPartie (Modele modele){
        return null;
    }

    private void initialiserGrille (MPartie partie){
        int hauteur = partie.getParametres().getHauteur();
        int largeur = partie.getParametres().getLargeur();
        int pourGagner = partie.getParametres().getPourGagner();
    }

    private void afficherParametres(MPartie partie) {

    }

}
