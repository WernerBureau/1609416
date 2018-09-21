package ca.cours5b5.wernerburat.controleurs;

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
        return null;
    }
}
