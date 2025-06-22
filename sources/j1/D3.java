package J1;

import android.view.View;
import c2.C1680n0;
import com.uptodown.activities.PreregistrationActivity;
import java.util.HashMap;

public final /* synthetic */ class D3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f6745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f6746b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1680n0 f6747c;

    public /* synthetic */ D3(PreregistrationActivity preregistrationActivity, HashMap hashMap, C1680n0 n0Var) {
        this.f6745a = preregistrationActivity;
        this.f6746b = hashMap;
        this.f6747c = n0Var;
    }

    public final void onClick(View view) {
        PreregistrationActivity.E3(this.f6745a, this.f6746b, this.f6747c, view);
    }
}
