package androidx.window.layout;

import androidx.window.layout.SidecarWindowBackend;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f1039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowLayoutInfo f1040b;

    public /* synthetic */ i(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f1039a = windowLayoutChangeCallbackWrapper;
        this.f1040b = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m11accept$lambda0(this.f1039a, this.f1040b);
    }
}
