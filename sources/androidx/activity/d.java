package androidx.activity;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

public final /* synthetic */ class d implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f778a;

    public /* synthetic */ d(ComponentActivity componentActivity) {
        this.f778a = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        ComponentActivity.d(this.f778a, context);
    }
}
