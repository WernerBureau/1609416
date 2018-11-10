package ca.cours5b5.wernerburat.proxy;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.List;

import ca.cours5b5.wernerburat.controleurs.Action;
import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.global.GCommande;

public class ProxyListe extends Proxy implements Fournisseur {
    private ChildEventListener childEventListener;

    private Query requete;

    private Action actionNouvelItem;

    private List<DatabaseReference> noeudsAjoutes;

    public ProxyListe(String cheminServeur){

    }

    public void setActionNouvelItem(GCommande commande){

    }

    public void ajouterValeur(Object valeur){

    }

    @Override
    public void connecterAuServeur(){
        super.connecterAuServeur();
        //TODO: Créer le listener, sauvgarder la requête, ajouter le listener

        creerListener();
    }

    private void creerListener(){

    }

    protected Query getRequete(){
        //TODO: Trier par clé et limiter à un nombre max (utiliser constante)
        return null;
    }

    @Override
    public void deconnecterDuServeur(){
        //TODO: Retirer listener, oublier noeuds ajoutés, déconnecter via super.
    }

    @Override
    public void detruireValeurs(){

    }

}
