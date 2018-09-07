package ca.cours5b5.wernerburat.serialisation;

import ca.cours5b5.wernerburat.exceptions.ErreurDeConstruction;
import ca.cours5b5.wernerburat.exceptions.ErreurIntrospection;

public class Construction {
    public static <T extends Constructible> T construire(Class<T> classeAInstancier) throws ErreurDeConstruction{

    }

    private static <T extends Constructible> T finaliserConstruction(Class<T> classeAInstancier, Object obj){

    }
}
