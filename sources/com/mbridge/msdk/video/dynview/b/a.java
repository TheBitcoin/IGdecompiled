package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f15984b;

    /* renamed from: a  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.d.a f15985a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f15984b != null) {
            return f15984b;
        }
        synchronized (a.class) {
            try {
                if (f15984b == null) {
                    f15984b = new a();
                }
                aVar = f15984b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.f15985a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int h4 = cVar.h();
        if (h4 == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.f15985a = aVar.f16085a;
        } else if (h4 == 2) {
            new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
        } else if (h4 == 4) {
            new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
        } else if (h4 != 5) {
            eVar.a(view, new ArrayList());
        } else {
            new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
        }
    }
}
