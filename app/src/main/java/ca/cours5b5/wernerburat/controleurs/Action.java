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

    }

    public void executerDesQuePossible(){
        //Appeler le controleur
        ControleurAction.executerDesQuePossible(this);

    }

    public Action cloner(){
        Action action = new Action();

        if (args!=null)
            action.setArguments(args.clone());

        action.fournisseur=fournisseur;
        action.listenerFournisseur=listenerFournisseur;
        return action;
    }
}
