package ca.cours5b5.wernerburat.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.wernerburat.global.GCommande;

public class ControleurAction {

    private static Map<GCommande, Action> actions;
    private static List<Action> fileAttenteExecution;

    static {
        actions = new HashMap<>();
        fileAttenteExecution = new ArrayList<>();

        for(GCommande commande : GCommande.values()){
            actions.put(commande, new Action());
        }
    }

    public static Action demanderAction(GCommande commande){
        return actions.get(commande);
    }

    public static void fournirAction(Fournisseur fournisseur, GCommande commande, ListenerFournisseur listenerFournisseur){
        listenerFournisseur.executer();
    }

    static void executerDesQuePossible(Action action){
        fileAttenteExecution.add(action);
        //fileAttenteExecution.
    }
}
