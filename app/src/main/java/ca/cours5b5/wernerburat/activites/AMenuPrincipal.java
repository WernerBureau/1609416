package ca.cours5b5.wernerburat.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.controleurs.ControleurAction;
import ca.cours5b5.wernerburat.controleurs.interfaces.Fournisseur;
import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GConstantes;

public class AMenuPrincipal extends Activite implements Fournisseur {

    private static List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    static {
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionConnexion(){
        ControleurAction.fournirAction(this, GCommande.CONNEXION,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        etablirConnexion();
                    }
                });

    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void etablirConnexion() {

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intentionConnexion = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(fournisseursDeConnexion)
                    .build();

            this.startActivityForResult(intentionConnexion, GConstantes.CODE_CONNEXION_FIREBASE);
        }

        else {
            AuthUI.getInstance().signOut(getApplicationContext());
        }

    }

    private void fournirActionJoindreOuCreerPartieReseau(){

    }

    private void transitionPartieReseau(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GConstantes.CODE_CONNEXION_FIREBASE) {
            if (resultCode == RESULT_OK){
                // Connexion réussie
                Log.d("Atelier11", "onActivityResult: Reussi");
            } else {
                // Connexion échouée
                Log.d("Atelier11", "onActivityResult: Echec");
            }
        }
    }

}
