package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ca.cours5b5.wernerburat.global.GCouleur;

public class VCase extends AppCompatButton {
    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int colonne;
    private int rangee;

    public VCase(Context context, int colonne, int rangee) {
        super(context);

        this.colonne = colonne;
        this.rangee = rangee;

        setText(""+rangee + "," + colonne);
        setEnabled(false);
    }

    public void afficherJeton(GCouleur jeton){
        if(jeton.equals(GCouleur.JAUNE)){
            this.setBackgroundColor(Color.YELLOW);
        } else {
            this.setBackgroundColor(Color.RED);
        }
    }
}
