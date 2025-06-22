package q0;

import M.C0335p;
import O0.d;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;
import com.google.firebase.analytics.connector.internal.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import p0.C2190b;
import p0.C2194f;
import q0.C2204a;

public class b implements C2204a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile C2204a f21500c;

    /* renamed from: a  reason: collision with root package name */
    private final e0.a f21501a;

    /* renamed from: b  reason: collision with root package name */
    final Map f21502b = new ConcurrentHashMap();

    class a implements C2204a.C0267a {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ String f21503a;

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ b f21504b;

        a(b bVar, String str) {
            this.f21503a = str;
            this.f21504b = bVar;
        }
    }

    private b(e0.a aVar) {
        C0335p.l(aVar);
        this.f21501a = aVar;
    }

    public static C2204a d(C2194f fVar, Context context, d dVar) {
        C0335p.l(fVar);
        C0335p.l(context);
        C0335p.l(dVar);
        C0335p.l(context.getApplicationContext());
        if (f21500c == null) {
            synchronized (b.class) {
                try {
                    if (f21500c == null) {
                        Bundle bundle = new Bundle(1);
                        if (fVar.u()) {
                            dVar.a(C2190b.class, new c(), new d());
                            bundle.putBoolean("dataCollectionDefaultEnabled", fVar.t());
                        }
                        f21500c = new b(C0544e1.f(context, (String) null, (String) null, (String) null, bundle).x());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21500c;
    }

    static /* synthetic */ void e(O0.a aVar) {
        throw null;
    }

    private final boolean f(String str) {
        if (str.isEmpty() || !this.f21502b.containsKey(str) || this.f21502b.get(str) == null) {
            return false;
        }
        return true;
    }

    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.a.g(str) && com.google.firebase.analytics.connector.internal.a.c(str2, bundle) && com.google.firebase.analytics.connector.internal.a.e(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.a.b(str, str2, bundle);
            this.f21501a.a(str, str2, bundle);
        }
    }

    public C2204a.C0267a b(String str, C2204a.b bVar) {
        Object obj;
        C0335p.l(bVar);
        if (!com.google.firebase.analytics.connector.internal.a.g(str) || f(str)) {
            return null;
        }
        e0.a aVar = this.f21501a;
        if ("fiam".equals(str)) {
            obj = new com.google.firebase.analytics.connector.internal.d(aVar, bVar);
        } else if ("clx".equals(str)) {
            obj = new f(aVar, bVar);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.f21502b.put(str, obj);
        return new a(this, str);
    }

    public void c(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.a.g(str) && com.google.firebase.analytics.connector.internal.a.d(str, str2)) {
            this.f21501a.c(str, str2, obj);
        }
    }
}
