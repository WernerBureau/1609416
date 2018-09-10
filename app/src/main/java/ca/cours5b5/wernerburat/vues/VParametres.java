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
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.modeles.MParametres;

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

    static{
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("Atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");

        Spinner spinnerHauteur = this.findViewById(R.id.spinnerHeight);
        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerHauteur.setAdapter(adapterHauteur);

        Spinner spinnerLargeur = this.findViewById(R.id.spinnerWidth);
        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerLargeur.setAdapter(adapterLargeur);

        Spinner spinnerPourGagner = this.findViewById(R.id.spinnerToWin);
        ArrayAdapter<Integer> adapterPourGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
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

        spinnerHauteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer choixHauteur = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setHauteur(choixHauteur);
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });

        spinnerLargeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer choixLargeur = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setLargeur(choixLargeur);
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });

        spinnerPourGagner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Integer spinnerPourGagner = (Integer) parent.getAdapter().getItem(position);
                MParametres.instance.setPourGagner(spinnerPourGagner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> position){

            }
        });
    }
}
