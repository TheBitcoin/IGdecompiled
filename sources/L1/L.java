package L1;

import android.view.View;
import c2.C1670i0;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;
import kotlin.jvm.internal.A;

public final /* synthetic */ class L implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7297a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f7298b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ A f7299c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1670i0 f7300d;

    public /* synthetic */ L(PreferencesActivity preferencesActivity, HashMap hashMap, A a5, C1670i0 i0Var) {
        this.f7297a = preferencesActivity;
        this.f7298b = hashMap;
        this.f7299c = a5;
        this.f7300d = i0Var;
    }

    public final void onClick(View view) {
        PreferencesActivity.z4(this.f7297a, this.f7298b, this.f7299c, this.f7300d, view);
    }
}
