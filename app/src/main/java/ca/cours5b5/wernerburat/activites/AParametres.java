package ca.cours5b5.wernerburat.activites;

import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.wernerburat.R;

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
        outState.putInt("cle",18);
    }
    @Override
    protected void onDestroy() {
        Log.d("Atelier04", AParametres.class.getSimpleName() + "::onDestroy");
        super.onDestroy();
    }
}