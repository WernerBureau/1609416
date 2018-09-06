package ca.cours5b5.wernerburat.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import ca.cours5b5.wernerburat.R;
import ca.cours5b5.wernerburat.activites.AParametres;

public class VMenuPrincipal extends Vue {
    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static{
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + "::onFinishInflate");
        Button boutonParametres = this.findViewById(R.id.btnParametres);
    }

}
