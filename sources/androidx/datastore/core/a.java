package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import d3.l;
import o3.Z;

public final /* synthetic */ class a implements Z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f932a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f933b;

    public /* synthetic */ a(String str, l lVar) {
        this.f932a = str;
        this.f933b = lVar;
    }

    public final void dispose() {
        MulticastFileObserver.Companion.observe$lambda$4(this.f932a, this.f933b);
    }
}
