package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import d3.l;
import kotlin.jvm.internal.A;

public final /* synthetic */ class l0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f7340a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ A f7341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7342c;

    public /* synthetic */ l0(l lVar, A a5, PreferencesActivity preferencesActivity) {
        this.f7340a = lVar;
        this.f7341b = a5;
        this.f7342c = preferencesActivity;
    }

    public final void onClick(View view) {
        PreferencesActivity.V3(this.f7340a, this.f7341b, this.f7342c, view);
    }
}
