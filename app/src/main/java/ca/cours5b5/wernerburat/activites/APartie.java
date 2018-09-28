package ca.cours5b5.wernerburat.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.wernerburat.R;

public class APartie extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
