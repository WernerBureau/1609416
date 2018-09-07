package ca.cours5b5.wernerburat.serialisation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import ca.cours5b5.wernerburat.modeles.MParametres;

public class Jsonification {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // aPartirJson : desérialiser
    // Désérialiser :   .json   ===>  Map<String, Object>  ===>  Modele
    public static <T extends Serialisable> T aPartirJson(Class<T> classeAImplanter, String json){


        Map<String, Object> objetJson = gson.fromJson(json, Map.class);

        // si l'objet est un MParametres
        if(classeAImplanter.getSimpleName().equals(MParametres.class.getSimpleName())){

            MParametres mParametres = new MParametres();

            mParametres.deserialiser(objetJson);


            return (T) mParametres;
        }

        return null;

    }

    // enJson : sérialiser
    // Sérialiser :    Modele ==>  Map<String, Object>   ==>  .json
    public static String enJson(Serialisable obj){

        if(obj instanceof MParametres){

            MParametres mParametres = (MParametres) obj;

            Map<String, Object> objetJson  = mParametres.serialiser();
            return gson.toJson(objetJson);
        }


        return null;
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
