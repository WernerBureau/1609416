package ca.cours5b5.wernerburat.exceptions;

import android.util.Log;

public class ErreurDeSerialisation extends RuntimeException{
    public ErreurDeSerialisation(String message){
        Log.d("Atelier05", "Erreur de Serialisation: " + message);
    }
}
