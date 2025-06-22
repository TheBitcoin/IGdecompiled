package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f15986a;

    private b() {
    }

    public static b a() {
        b bVar;
        if (f15986a != null) {
            return f15986a;
        }
        synchronized (b.class) {
            try {
                if (f15986a == null) {
                    f15986a = new b();
                }
                bVar = f15986a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void a(View view, c cVar, Map<String, Object> map) {
        if (cVar != null) {
            int h4 = cVar.h();
            if (h4 == 1) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, map);
            } else if (h4 == 2) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar, map);
            } else if (h4 == 3) {
                new com.mbridge.msdk.video.dynview.j.b().a(view, cVar);
            } else if (h4 == 4) {
                new com.mbridge.msdk.video.dynview.j.b().b(view, cVar, map);
            } else if (h4 == 5) {
                new com.mbridge.msdk.video.dynview.j.b();
            }
        }
    }
}
