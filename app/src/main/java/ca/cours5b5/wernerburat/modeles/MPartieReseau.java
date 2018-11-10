package ca.cours5b5.wernerburat.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.exceptions.ErreurSerialisation;
import ca.cours5b5.wernerburat.serialisation.AttributSerialisable;

public class MPartieReseau extends MPartie implements Fournisseur {

    @AttributSerialisable
    public String idJoueurInvite;
    public String __idJoueurInvite;

    @AttributSerialisable
    public String idJoueurHote;
    public String __idJoueurHote;

    public MPartieReseau(MParametresPartie parametres){
        super(parametres);
    }

    public String getId() {
        return idJoueurHote;
    }

    private void fournirActionRecevoirCoup(){

    }

    @Override
    protected void fournirActionPlacerJeton(){

    }

    private void recevoirCoupReseau(int colonne){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {
            //TODO: charger les champs, appeler aussi super
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        Map<String, Object> objetJson = new HashMap<>();

        //TODO: Sauvegarder les champs, appeler aussi super

        return objetJson;
    }

}
