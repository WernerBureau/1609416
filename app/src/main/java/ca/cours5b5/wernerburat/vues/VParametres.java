package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.controleurs.Action;
import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.controleurs.ControleurObservation;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.modeles.MParametres;
import ca.cours5b5.wernerburat.modeles.Modele;

public class VParametres extends Vue{

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Spinner spinnerHauteur;
    private Spinner spinnerLargeur;
    private Spinner spinnerPourGagner;

    private ArrayAdapter<Integer> adapterHauteur;
    private ArrayAdapter<Integer> adapterLargeur;
    private ArrayAdapter<Integer> adapterPourGagner;

    static{
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("Atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");

        spinnerHauteur = this.findViewById(R.id.spinnerHeight);
        adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerHauteur.setAdapter(adapterHauteur);

        spinnerLargeur = this.findViewById(R.id.spinnerWidth);
        adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerLargeur.setAdapter(adapterLargeur);

        spinnerPourGagner = this.findViewById(R.id.spinnerToWin);
        adapterPourGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerPourGagner.setAdapter(adapterPourGagner);

        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());
        adapterLargeur.addAll(MParametres.instance.getChoixLargeur());
        adapterPourGagner.addAll(MParametres.instance.getChoixPourGagner());

        spinnerHauteur.setSelection(adapterHauteur.getPosition(MParametres.instance.getParametresPartie().getHauteur()));
        spinnerLargeur.setSelection(adapterLargeur.getPosition(MParametres.instance.getParametresPartie().getLargeur()));
        spinnerPourGagner.setSelection(adapterPourGagner.getPosition(MParametres.instance.getParametresPartie().getPourGagner()));

        spinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionHauteur = ControleurAction.demanderAction(GCommande.CHOISIR_HAUTEUR);

                Integer choixHauteur = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setHauteur(choixHauteur);

                actionHauteur.setArguments(choixHauteur);
                actionHauteur.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });

        spinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionLargeur = ControleurAction.demanderAction(GCommande.CHOISIR_LARGEUR);

                Integer choixLargeur = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setLargeur(choixLargeur);

                actionLargeur.setArguments(choixLargeur);
                actionLargeur.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });

        spinnerPourGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Action actionPourGagner = ControleurAction.demanderAction(GCommande.CHOISIR_POUR_GAGNER);

                Integer choixPourGagner = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.getParametresPartie().setPourGagner(choixPourGagner);

                actionPourGagner.setArguments(choixPourGagner);
                actionPourGagner.executerDesQuePossible();
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });

        //Observateur; réagir au changement
        ControleurObservation.observerModele(MParametres.class.getSimpleName(),
                new ListenerObservateur() {
                    @Override
                    public void reagirChangementAuModele(Modele modele) {

                        afficherParametres((MParametres)modele);
                    }
                });

    }
    private void afficherParametres(MParametres modele){
        adapterHauteur.clear();
        adapterHauteur.addAll(modele.getChoixHauteur());

        adapterLargeur.clear();
        adapterLargeur.addAll(modele.getChoixLargeur());

        adapterPourGagner.clear();
        adapterPourGagner.addAll(modele.getChoixPourGagner());
    }
}
