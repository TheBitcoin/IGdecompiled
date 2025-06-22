package I;

import android.content.Intent;
import android.os.Bundle;
import k0.C0928c;
import k0.C0937l;

/* renamed from: I.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0299f implements C0928c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0299f f256a = new C0299f();

    private /* synthetic */ C0299f() {
    }

    public final Object a(C0937l lVar) {
        Intent intent = (Intent) ((Bundle) lVar.j()).getParcelable("notification_data");
        if (intent != null) {
            return new C0294a(intent);
        }
        return null;
    }
}
