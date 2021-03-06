package ca.cours5b5.wernerburat.modeles;

import android.util.Log;

import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.controleurs.ControleurPartieReseau;
import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.wernerburat.exceptions.ErreurAction;
import ca.cours5b5.wernerburat.exceptions.ErreurSerialisation;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur, Identifiable {

    @AttributSerialisable
    private String idJoueurInvite;
    private String __idJoueurInvite = "idJoueurInvite";
    private String nomJoueurInvite;
    private String __nomJoueurInvite = "nomJoueurInvite";

    @AttributSerialisable
    public String idJoueurHote;
    private String __idJoueurHote = "idJoueurHote";
    private String nomJoueurHote;
    private String __nomJoueurHote = "nomJoueurHote";

    public MPartieReseau(MParametresPartie parametres){

        super(parametres);
        fournirActionRecevoirCoup();
    }

    @Override
    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup(){
        ControleurAction.fournirAction(this,
                GCommande.RECEVOIR_COUP_RESEAU,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = Integer.parseInt((String)args[0]);

                            recevoirCoupReseau(colonne);


                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });
    }

    @Override
    protected void fournirActionPlacerJeton(){
        ControleurAction.fournirAction(this,
                GCommande.JOUER_COUP_ICI,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {
                        try{

                            int colonne = (Integer) args[0];

                            jouerCoup(colonne);
                            ControleurPartieReseau.getInstance().transmettreCoup(colonne);


                        }catch(ClassCastException e){

                            throw new ErreurAction(e);

                        }
                    }
                });
    }

    private void recevoirCoupReseau(int colonne){
        jouerCoup(colonne);
    }

    public void setNomJoueurHote(String nom) {
        nomJoueurHote = nom;
        Log.d("loggg", nomJoueurHote);
    }
    public void setNomJoueurInvite(String nom) {
        nomJoueurInvite = nom;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
        super.aPartirObjetJson(objetJson);
        idJoueurHote = (String) objetJson.get(__idJoueurHote);
        idJoueurInvite = (String) objetJson.get(__idJoueurInvite);

        nomJoueurHote = (String) objetJson.get(__nomJoueurHote);
        nomJoueurInvite = (String) objetJson.get(__nomJoueurInvite);
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = super.enObjetJson();

        objetJson.put(__idJoueurHote, idJoueurHote);
        objetJson.put(__idJoueurInvite, idJoueurInvite);

        objetJson.put(__nomJoueurHote, nomJoueurHote);
        objetJson.put(__nomJoueurInvite, nomJoueurInvite);

        return objetJson;
    }

}
