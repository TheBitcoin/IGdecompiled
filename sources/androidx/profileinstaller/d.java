package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f975b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f976c;

    public /* synthetic */ d(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i4, Object obj) {
        this.f974a = diagnosticsCallback;
        this.f975b = i4;
        this.f976c = obj;
    }

    public final void run() {
        this.f974a.onDiagnosticReceived(this.f975b, this.f976c);
    }
}
