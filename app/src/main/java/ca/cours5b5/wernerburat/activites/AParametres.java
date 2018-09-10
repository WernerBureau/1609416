package ca.cours5b5.wernerburat.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.modeles.MParametres;
import ca.cours5b5.wernerburat.serialisation.Jsonification;

public class AParametres extends Activite {
    static{
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("logmessage", this.getResources().getString(R.string.lang) + " (" + this.getResources().getString(R.string.orientation) + ")");

        if(savedInstanceState != null){
            String json = savedInstanceState.getString("MaCle");
            Map<String, Object> objetJson = Jsonification.enObjetJson(json);

            MParametres modeleParametres = new MParametres();
            modeleParametres.aPartirObjetJson(objetJson);
        }
    }

    @Override
    protected void onResume(){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onResume");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onPause");
        super.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onSaveInstanceState");
        super.onSaveInstanceState(outState);

        //Sauvegarder les données
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaine(objetJson);

        outState.putString("MaCle", json);

        Log.d("Atelier05", json);
    }
    @Override
    protected void onDestroy() {
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onDestroy");
        super.onDestroy();
    }
}