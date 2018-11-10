package ca.cours5b5.wernerburat.controleurs;

import ca.cours5b5.wernerburat.proxy.ProxyListe;

public final class ControleurPartieReseau {
    private static final ControleurPartieReseau instance;
    public static ControleurPartieReseau getInstance();

    private ProxyListe proxyEmettreCoups;
    private ProxyListe proxyRecevoirCoups;

    public void connecterAuServeur(){
        //TODO: Obtenir modele MPartieReseau, obtenir ID du modèle (qui est l'ID du host), appeler connecterAuServeur(String idJoueurHote)
    }

    private void connecterAuServeur(String idJoueurHote){
       //TODO: Connecter en tant que joueur hôte OU en tant qu'invité, selon le cas.
        //TODO: Connecter les deux proxy au serveur, ajouter l'action RECEVOIR_COUP_RESEAU au proxyRecevoirCoups
    }

    private void connecterEnTantQueJoueurHote(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        //TODO: Créer les proxy... avec les bons chemins
    }

    private void connecterEnTantQueJoueurInvite(String cheminCoupsJoueurHote, String cheminCoupsJoueurInvite){
        //TODO: Créer les proxy... avec les bons chemins
    }

    public void deconnecterDuServeur(){
        //TODO: Détruire les valeurs du proxyEmettreCoups, déconnecter les deux proxy.
    }

    public void transmettreCoup(Integer idColonne){
        //TODO: Transmettre avec proxyEmettreCoups
    }

    private String getCheminCoupsJoueurInvite(String idJoueurHote){
        //TODO: Utiliser p.ex la constante CLE_COUPS_JOUEUR_INVITE
        return null;
    }

    private String getCheminCoupsJoueurHote(String idJoueurHote){
        //TODO: Utiliser p.ex la constante CLE_COUPS_JOUEUR_HOTE
        return null;
    }

    private String getCheminPartie(String idJoueurHote){
        //TODO: retourner chemin qui contient l'ID de la partie (id du joueur host)
        return null;
    }

    public void detruireSauvegardeServeur(){
        //TODO: Appeler p.ex le detruireSauvegarde de Serveur (Avec le bon chemin)
    }

}
