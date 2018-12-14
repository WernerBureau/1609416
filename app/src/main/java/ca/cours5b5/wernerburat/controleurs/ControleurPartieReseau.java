package ca.cours5b5.wernerburat.controleurs;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import ca.cours5b5.wernerburat.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.wernerburat.global.GCommande;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.modeles.MJoueur;
import ca.cours5b5.wernerburat.modeles.MPartieReseau;
import ca.cours5b5.wernerburat.modeles.Modele;
import ca.cours5b5.wernerburat.proxy.ProxyListe;
import ca.cours5b5.wernerburat.usagers.UsagerCourant;

public final class ControleurPartieReseau {
    private static final ControleurPartieReseau instance = new ControleurPartieReseau();
    public static ControleurPartieReseau getInstance(){
        return instance;
    }

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    private MJoueur joueurHote = new MJoueur("player1");
    private MJoueur joueurInvite = new MJoueur("player2");

    public void connecterAuServeur(){

        ControleurModeles.getModele(MPartieReseau.class.getSimpleName(), new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                MPartieReseau mPartieReseau = (MPartieReseau) modele;

                Log.d("testConnexion", mPartieReseau.getId());

                connecterAuServeur(mPartieReseau.idJoueurHote);

                if (UsagerCourant.getId().equals(mPartieReseau.idJoueurHote)) {
                    joueurHote.setNomJoueur(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                    mPartieReseau.setNomJoueurHote(joueurHote.getNomJoueur());
                } else {
                    joueurInvite.setNomJoueur(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                    mPartieReseau.setNomJoueurInvite(joueurHote.getNomJoueur());
                }

                Log.d("testJoueurs", joueurHote.getNomJoueur() + " " + joueurInvite.getNomJoueur());
            }
        });
    }

    private void connecterAuServeur(String idJoueurHote){
        String cheminCoupJoueurHote = getCheminCoupsJoueurHote(idJoueurHote);
        String cheminCoupJoueurInvite = getCheminCoupsJoueurInvite(idJoueurHote);

        if(UsagerCourant.getId().equals(idJoueurHote)){
            connecterEnTantQueJoueurHote(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }else{
            connecterEnTantQueJoueurInvite(cheminCoupJoueurHote,cheminCoupJoueurInvite);
        }


        proxyRecevoirCoups.setActionNouvelItem(GCommande.RECEVOIR_COUP_RESEAU);
        proxyRecevoirCoups.connecterAuServeur();
        proxyEmettreCoups.connecterAuServeur();
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurHote);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurInvite);
    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        proxyEmettreCoups = new ProxyListe(cheminCoupsJoueurInvite);
        proxyRecevoirCoups = new ProxyListe(cheminCoupsJoueurHote);
    }

    public void deconnecterDuServeur(){
        proxyEmettreCoups.deconnecterDuServeur();
        proxyRecevoirCoups.deconnecterDuServeur();
    }

    public void transmettreCoup(Integer idColonne){
        proxyEmettreCoups.ajouterValeur(idColonne);
    }

    private String getNomJoueurHote(MJoueur joueurHote){
        return joueurHote.getNomJoueur() + "/" + GConstantes.CLE_NOM_JOUEUR_HOTE;
    }

    private String getNomJoueurInvite(MJoueur joueurInvite){
        return joueurInvite.getNomJoueur() + "/" + GConstantes.CLE_NOM_JOUEUR_INVITE;
    }

    private String getCheminCoupsJoueurInvite(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_INVITE;
    }

    private String getCheminCoupsJoueurHote(String idJoueurHote){
        return getCheminPartie(idJoueurHote) + "/" + GConstantes.CLE_COUPS_JOUEUR_HOTE;
    }

    private String getCheminPartie(String idJoueurHote){
        return MPartieReseau.class.getSimpleName() + "/" + idJoueurHote;
    }

    public void detruireSauvegardeServeur(){
        //TODO: Appeler p.ex le detruireSauvegarde de Serveur (Avec le bon chemin)
    }

}
