package ca.cours5b5.wernerburat.modeles;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.vues.VParametres;

public class MParametres extends Modele{

    public MParametres( VParametres vue ) {
        Spinner spinnerHauteur = vue.findViewById(R.id.spinnerHeight);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(vue.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerHauteur.setAdapter(adapterHauteur);

        Spinner spinnerLargeur = vue.findViewById(R.id.spinnerWidth);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(vue.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerLargeur.setAdapter(adapterLargeur);

        Spinner spinnerPourGagner = vue.findViewById(R.id.spinnerToWin);
        ArrayAdapter<Integer> adapterPourGagner = new ArrayAdapter<>(vue.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerPourGagner.setAdapter(adapterPourGagner);

        for (int i = GConstantes.HAUTEURMIN; i <= GConstantes.HAUTEURMAX; i++){
            adapterHauteur.add(i);
        }

        for (int i = GConstantes.LARGEURMIN; i <= GConstantes.LARGEURMAX; i++){
            adapterLargeur.add(i);
        }

        for (int i = GConstantes.GAGNERMIN; i <= GConstantes.GAGNERMAX; i++){
            adapterPourGagner.add(i);
        }

        spinnerHauteur.setSelection(adapterHauteur.getPosition(GConstantes.HAUTEURDEFAUT));
        spinnerLargeur.setSelection(adapterLargeur.getPosition(GConstantes.LARGEURDEFAUT));
        spinnerPourGagner.setSelection(adapterPourGagner.getPosition(GConstantes.GAGNERDEFAUT));
    }
}
