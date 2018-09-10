package ca.cours5b5.wernerburat.serialisation;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import ca.cours5b5.wernerburat.modeles.MParametres;

public class Jsonification {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // aPartirJson : desérialiser
    // Désérialiser :   .json   ===>  Map<String, Object>  ===>  Modele
    public static Map<String, Object> enObjetJson(String json){
        Map<String, Object> objetJson = gson.fromJson(json, Map.class);

        // si l'objet est un MParametres
//        if(objetJson.getClass().getSimpleName().equals(MParametres.class.getSimpleName())){
//
//            MParametres mParametres = new MParametres();
//
//            mParametres.aPartirObjetJson(objetJson);

            return objetJson;
//        }
//        return null;
    }

    // enJson : sérialiser
    // Sérialiser :    Modele ==>  Map<String, Object>   ==>  .json
    public static String enChaine(Map<String, Object> objetJson){
        // si l'objet est un MParametres
//        if(objetJson instanceof MParametres){
//
//            MParametres mParametres = (MParametres) objetJson;
//
//            objetJson  = mParametres.enObjetJson();
            return gson.toJson(objetJson);
//        }
//
//
//        return null;
    }

//    private static <T extends Serialisable> T aPartirJson(Serialisable obj, String json){
//
//    }
//
//    private static <T extends Serialisable> T aPartirObjetJson(Serialisable obj, Map<String, Object> objetJson){
//        String chaineJson = gson.toJson(objetJson);
//
//    }

}
