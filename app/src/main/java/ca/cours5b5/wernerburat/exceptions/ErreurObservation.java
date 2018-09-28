package ca.cours5b5.wernerburat.exceptions;

public class ErreurObservation extends RuntimeException {
    public ErreurObservation(Exception e){

    }

    public ErreurObservation(String message){
        message = "Erreur d'observation";
    }
}
