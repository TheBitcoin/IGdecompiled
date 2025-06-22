package I;

import android.os.Bundle;
import android.util.Log;
import k0.C0938m;

abstract class A {

    /* renamed from: a  reason: collision with root package name */
    final int f225a;

    /* renamed from: b  reason: collision with root package name */
    final C0938m f226b = new C0938m();

    /* renamed from: c  reason: collision with root package name */
    final int f227c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f228d;

    A(int i4, int i5, Bundle bundle) {
        this.f225a = i4;
        this.f227c = i5;
        this.f228d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public final void c(B b5) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj = toString();
            String obj2 = b5.toString();
            Log.d("MessengerIpcClient", "Failing " + obj + " with " + obj2);
        }
        this.f226b.b(b5);
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj2 = toString();
            String valueOf = String.valueOf(obj);
            Log.d("MessengerIpcClient", "Finishing " + obj2 + " with " + valueOf);
        }
        this.f226b.c(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f227c + " id=" + this.f225a + " oneWay=" + b() + "}";
    }
}
