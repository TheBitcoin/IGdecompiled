package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.Map;
import kotlin.jvm.internal.A;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A f7337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f7338b;

    public /* synthetic */ k0(A a5, Map.Entry entry) {
        this.f7337a = a5;
        this.f7338b = entry;
    }

    public final void onClick(View view) {
        PreferencesActivity.U3(this.f7337a, this.f7338b, view);
    }
}
