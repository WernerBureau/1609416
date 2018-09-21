package ca.cours5b5.wernerburat.controleurs;

import android.util.Log;

import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;
    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){
        this.args = args;
        Log.d("Atelier06",args.toString());

    }

    public void executerDesQuePossible(){
        //Appeler le controleur
        ControleurAction.executerDesQuePossible(this);

    }

    public Action cloner(){
        return null;
    }
}
