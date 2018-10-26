package ca.cours5b5.wernerburat.usagers;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {
    public static boolean siUsagerConnecte(){
        boolean connecte = false;

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            connecte = true;
        }
        return connecte;
    }

    public static String getId(){
        String id = "0";

        if (siUsagerConnecte()){
            id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        }
        return id;
    }
}
