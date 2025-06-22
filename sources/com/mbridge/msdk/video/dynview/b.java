package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.h.a;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f15982b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, SoftReference<View>> f15983a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (f15982b != null) {
            return f15982b;
        }
        synchronized (b.class) {
            try {
                if (f15982b == null) {
                    f15982b = new b();
                }
                bVar = f15982b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void a(c cVar, h hVar) {
        new a(cVar, hVar, new HashMap());
    }

    public final void a(c cVar, h hVar, Map<String, Object> map) {
        new a(cVar, hVar, map);
    }
}
