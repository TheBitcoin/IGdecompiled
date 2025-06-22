package L1;

import android.view.View;
import c2.C1668h0;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import kotlin.jvm.internal.A;

/* renamed from: L1.h  reason: case insensitive filesystem */
public final /* synthetic */ class C1506h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A f7330a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdvancedPreferencesActivity f7331b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1668h0 f7332c;

    public /* synthetic */ C1506h(A a5, AdvancedPreferencesActivity advancedPreferencesActivity, C1668h0 h0Var) {
        this.f7330a = a5;
        this.f7331b = advancedPreferencesActivity;
        this.f7332c = h0Var;
    }

    public final void onClick(View view) {
        AdvancedPreferencesActivity.B3(this.f7330a, this.f7331b, this.f7332c, view);
    }
}
