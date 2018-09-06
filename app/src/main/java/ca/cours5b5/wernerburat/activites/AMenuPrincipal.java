package ca.cours5b5.wernerburat.activites;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;

import ca.cours5b5.wernerburat.R;

public class AMenuPrincipal extends Activite {
    static{
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
    }

    @Override
    protected void onResume(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onResume");
        super.onResume();
    }

    @Override
    protected void onPause(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onPause");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("cle",18);
    }

    @Override
    protected void onDestroy(){
        Log.d("Atelier04", AMenuPrincipal.class.getSimpleName() + "::onDestroy");
        super.onDestroy();
    }

    public void goToAnActivity(View view){
        Intent monIntention = new Intent(this, AParametres.class);
        this.startActivity(monIntention);
    }
}
