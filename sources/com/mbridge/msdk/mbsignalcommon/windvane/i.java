package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbsignalcommon.c.a;
import java.util.regex.Pattern;

public final class i implements Handler.Callback, c {

    /* renamed from: a  reason: collision with root package name */
    protected Pattern f14176a;

    /* renamed from: b  reason: collision with root package name */
    protected String f14177b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f14178c = 1;

    /* renamed from: d  reason: collision with root package name */
    protected Context f14179d;

    /* renamed from: e  reason: collision with root package name */
    protected WindVaneWebView f14180e;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f14181f;

    public i(Context context) {
        this.f14179d = context;
        this.f14181f = new Handler(Looper.getMainLooper(), this);
    }

    public final void a(WindVaneWebView windVaneWebView) {
        this.f14180e = windVaneWebView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 2
            r1 = 1
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto L_0x000a
            goto L_0x00c2
        L_0x000a:
            r2 = 0
            if (r8 != 0) goto L_0x000e
            goto L_0x0069
        L_0x000e:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r7.f14180e
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(r3, r8)
            if (r3 == 0) goto L_0x001b
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.f14180e
            r3.f14150b = r8
            goto L_0x006a
        L_0x001b:
            java.util.regex.Pattern r3 = r7.f14176a
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L_0x0069
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = new com.mbridge.msdk.mbsignalcommon.windvane.a
            r3.<init>()
            int r4 = r8.groupCount()
            r5 = 5
            if (r4 < r5) goto L_0x0039
            java.lang.String r5 = r8.group(r5)
            r3.f14154f = r5
        L_0x0039:
            r5 = 3
            if (r4 < r5) goto L_0x0069
            java.lang.String r4 = r8.group(r1)
            r3.f14152d = r4
            java.lang.String r4 = r8.group(r0)
            r3.f14155g = r4
            java.lang.String r8 = r8.group(r5)
            r3.f14153e = r8
            java.util.HashMap<java.lang.String, java.lang.String> r4 = com.mbridge.msdk.mbsignalcommon.base.e.f14049k
            if (r4 == 0) goto L_0x0064
            boolean r8 = r4.containsKey(r8)
            if (r8 == 0) goto L_0x0064
            java.util.HashMap<java.lang.String, java.lang.String> r8 = com.mbridge.msdk.mbsignalcommon.base.e.f14049k
            java.lang.String r4 = r3.f14153e
            java.lang.Object r8 = r8.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            r3.f14153e = r8
        L_0x0064:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.f14180e
            r3.f14150b = r8
            goto L_0x006a
        L_0x0069:
            r3 = r2
        L_0x006a:
            if (r3 != 0) goto L_0x006d
            goto L_0x00c2
        L_0x006d:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r3.f14150b
            if (r8 != 0) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            java.lang.String r2 = r3.f14152d
            java.lang.Object r2 = r8.getJsObject(r2)
        L_0x0078:
            if (r2 != 0) goto L_0x007b
            goto L_0x00c2
        L_0x007b:
            android.content.Context r8 = r7.f14179d     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.Class r4 = r2.getClass()     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.String r4 = r4.getName()     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            com.mbridge.msdk.mbsignalcommon.c.a$c r8 = com.mbridge.msdk.mbsignalcommon.c.a.a(r8, r4)     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.String r4 = r3.f14153e     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r6 = 0
            r0[r6] = r5     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r1] = r5     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            com.mbridge.msdk.mbsignalcommon.c.a$d r8 = r8.a(r4, r0)     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            r8.a()     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            boolean r0 = r2 instanceof com.mbridge.msdk.mbsignalcommon.windvane.h     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            if (r0 == 0) goto L_0x00c2
            r3.f14149a = r8     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            r3.f14151c = r2     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            android.os.Message r8 = android.os.Message.obtain()     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            r8.what = r1     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            r8.obj = r3     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            android.os.Handler r0 = r7.f14181f     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            r0.sendMessage(r8)     // Catch:{ a -> 0x00b9, Exception -> 0x00b7 }
            return
        L_0x00b7:
            r8 = move-exception
            goto L_0x00bb
        L_0x00b9:
            r8 = move-exception
            goto L_0x00bf
        L_0x00bb:
            r8.printStackTrace()
            goto L_0x00c2
        L_0x00bf:
            r8.printStackTrace()
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.windvane.i.b(java.lang.String):void");
    }

    public final boolean handleMessage(Message message) {
        String str;
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
            if (message.what != 1) {
                return false;
            }
            Object obj = aVar.f14151c;
            a.d dVar = aVar.f14149a;
            if (!(dVar == null || obj == null)) {
                if (TextUtils.isEmpty(aVar.f14154f)) {
                    str = "{}";
                } else {
                    str = aVar.f14154f;
                }
                dVar.a(obj, aVar, str);
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final boolean a(String str) {
        if (!j.a(str)) {
            return false;
        }
        this.f14176a = j.b(str);
        this.f14177b = str;
        return true;
    }
}
