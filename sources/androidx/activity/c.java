package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class c implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f777a;

    public /* synthetic */ c(ComponentActivity componentActivity) {
        this.f777a = componentActivity;
    }

    public final Bundle saveState() {
        return ComponentActivity.e(this.f777a);
    }
}
