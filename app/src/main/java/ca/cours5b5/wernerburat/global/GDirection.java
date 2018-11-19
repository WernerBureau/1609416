package ca.cours5b5.wernerburat.global;

import java.util.ArrayList;
import java.util.List;

public class GDirection {

    public int incrementHorizontal;
    public int incrementVertical;

    public static List<GDirection> directions;

    static{
        directions = new ArrayList<>();
        directions.add(new GDirection(1, 1));
        directions.add(new GDirection(0, 1));
        directions.add(new GDirection(1, 0));
        directions.add(new GDirection(-1, 1));

    }

    public GDirection(int incrementHorizontal, int incrementVertical){
        this.incrementHorizontal = incrementHorizontal;
        this.incrementVertical = incrementVertical;
    }
}
