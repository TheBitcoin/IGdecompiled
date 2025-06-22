package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f972b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f973c;

    public /* synthetic */ c(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i4, Object obj) {
        this.f971a = diagnosticsCallback;
        this.f972b = i4;
        this.f973c = obj;
    }

    public final void run() {
        this.f971a.onResultReceived(this.f972b, this.f973c);
    }
}
