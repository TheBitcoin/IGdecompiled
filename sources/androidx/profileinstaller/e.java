package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;

public final /* synthetic */ class e implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f977a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f978b;

    public /* synthetic */ e(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f977a = profileInstallerInitializer;
        this.f978b = context;
    }

    public final void doFrame(long j4) {
        this.f977a.installAfterDelay(this.f978b);
    }
}
