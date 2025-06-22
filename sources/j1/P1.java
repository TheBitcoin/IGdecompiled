package J1;

import android.view.View;
import com.uptodown.activities.MyApps;
import java.util.HashMap;

public final /* synthetic */ class P1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyApps f6853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f6854b;

    public /* synthetic */ P1(MyApps myApps, HashMap hashMap) {
        this.f6853a = myApps;
        this.f6854b = hashMap;
    }

    public final void onClick(View view) {
        MyApps.h5(this.f6853a, this.f6854b, view);
    }
}
