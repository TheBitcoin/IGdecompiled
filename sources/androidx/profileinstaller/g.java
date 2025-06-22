package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f980a;

    public /* synthetic */ g(Context context) {
        this.f980a = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.f980a);
    }
}
