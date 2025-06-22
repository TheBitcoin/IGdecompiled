package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import java.util.HashMap;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Class> f14168a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f14169b;

    /* renamed from: c  reason: collision with root package name */
    private Object f14170c;

    /* renamed from: d  reason: collision with root package name */
    private WindVaneWebView f14171d;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r1, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2) {
        /*
            r0 = this;
            r0.<init>()
            r0.f14169b = r1
            r0.f14171d = r2
            java.lang.String r1 = "com.mbridge.msdk.interstitial.signalcommon.interstitial"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0012 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14039a     // Catch:{ ClassNotFoundException -> 0x0012 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0012 }
        L_0x0012:
            java.lang.Class<com.mbridge.msdk.video.signal.communication.RewardSignal> r1 = com.mbridge.msdk.video.signal.communication.RewardSignal.class
            int r2 = com.mbridge.msdk.video.signal.communication.RewardSignal.f16627g     // Catch:{ ClassNotFoundException -> 0x001b }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14040b     // Catch:{ ClassNotFoundException -> 0x001b }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x001b }
        L_0x001b:
            java.lang.Class<com.mbridge.msdk.video.signal.communication.VideoCommunication> r1 = com.mbridge.msdk.video.signal.communication.VideoCommunication.class
            int r2 = com.mbridge.msdk.video.signal.communication.VideoCommunication.f16653g     // Catch:{ ClassNotFoundException -> 0x0024 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14041c     // Catch:{ ClassNotFoundException -> 0x0024 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0024 }
        L_0x0024:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication> r1 = com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication.class
            int r2 = com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication.f14112g     // Catch:{ ClassNotFoundException -> 0x002d }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14043e     // Catch:{ ClassNotFoundException -> 0x002d }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x002d }
        L_0x002d:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin> r1 = com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin.class
            int r2 = com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin.f14104g     // Catch:{ ClassNotFoundException -> 0x0036 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14044f     // Catch:{ ClassNotFoundException -> 0x0036 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0036 }
        L_0x0036:
            java.lang.String r1 = "com.mbridge.msdk.splash.signal.SplashSignal"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0041 }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14045g     // Catch:{ ClassNotFoundException -> 0x0041 }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0041 }
        L_0x0041:
            java.lang.Class<com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal> r1 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal.class
            int r2 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal.f14124g     // Catch:{ ClassNotFoundException -> 0x004a }
            java.lang.String r2 = com.mbridge.msdk.mbsignalcommon.base.e.f14046h     // Catch:{ ClassNotFoundException -> 0x004a }
            r0.a(r2, r1)     // Catch:{ ClassNotFoundException -> 0x004a }
        L_0x004a:
            boolean r1 = com.mbridge.msdk.e.b.a()     // Catch:{ Exception -> 0x005d }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = "com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = r1.getSimpleName()     // Catch:{ Exception -> 0x005d }
            r0.a(r2, r1)     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.windvane.f.<init>(android.content.Context, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView):void");
    }

    public final void a(Context context) {
        this.f14169b = context;
    }

    public final void a(Object obj) {
        this.f14170c = obj;
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f14168a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!h.class.isAssignableFrom(cls)) {
                return null;
            }
            h hVar = (h) cls.newInstance();
            hVar.initialize(context, windVaneWebView);
            hVar.initialize(this.f14170c, windVaneWebView);
            return hVar;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final void a(String str, Class cls) {
        if (f14168a == null) {
            f14168a = new HashMap<>();
        }
        f14168a.put(str, cls);
    }

    public final Object a(String str) {
        if (f14168a == null) {
            f14168a = new HashMap<>();
        }
        return a(str, this.f14171d, this.f14169b);
    }
}
