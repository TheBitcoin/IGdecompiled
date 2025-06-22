package com.mbridge.msdk.e;

import J.C0308g;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.ArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f12709a = "";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12710b = false;

    public static void a() {
        if (ah.a().a("cronet_env_check", false)) {
            try {
                C0308g.n().a(com.mbridge.msdk.foundation.controller.c.m().c());
                C0308g.n().k(com.mbridge.msdk.foundation.controller.c.m().c(), 11925000);
                try {
                    String b5 = b();
                    boolean isEmpty = TextUtils.isEmpty(b5);
                    f12710b = !isEmpty;
                    if (!isEmpty) {
                        f12709a = b5;
                    }
                } catch (Throwable th) {
                    af.b("CronetEnvCheckUtil", th.getMessage());
                }
            } catch (Throwable th2) {
                af.b("CronetEnvCheckUtil", th2.getMessage());
                f12710b = false;
            }
        }
    }

    private static String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.c.m().c().getClassLoader();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                Pair pair = (Pair) obj;
                if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{com.mbridge.msdk.foundation.controller.c.m().c()}).getClass().getName())) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(pair.first);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            af.b("CronetEnvCheckUtil", th.getMessage());
            return "";
        }
    }
}
