package ca.cours5b5.wernerburat.controleurs;

import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){

    }

    public void executerDesQuePossible(){
        //Appeler le controleur

    }

    public Action cloner(){
        return null;
    }
}
