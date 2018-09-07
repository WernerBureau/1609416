package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.util.Log;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.global.GConstantes;
import ca.cours5b5.wernerburat.modeles.MParametres;

public class VParametres extends Vue{

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static{
        Log.d("Atelier04", VParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        Log.d("Atelier04", VParametres.class.getSimpleName() + "::onFinishInflate");

        MParametres mParametres = new MParametres(this);
    }
}
