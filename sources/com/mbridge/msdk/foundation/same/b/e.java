package com.mbridge.msdk.foundation.same.b;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f13191a;

    /* renamed from: b  reason: collision with root package name */
    private final b f13192b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a> f13193c = new ArrayList<>();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public File f13194a;

        /* renamed from: b  reason: collision with root package name */
        public c f13195b;

        public a(c cVar, File file) {
            this.f13195b = cVar;
            this.f13194a = file;
        }
    }

    private e(b bVar) {
        this.f13192b = bVar;
    }

    public static String a(c cVar) {
        File b5 = b(cVar);
        if (b5 != null) {
            return b5.getAbsolutePath();
        }
        return null;
    }

    public static File b(c cVar) {
        try {
            if (a() == null || a().f13193c == null || a().f13193c.isEmpty()) {
                return null;
            }
            ArrayList<a> arrayList = a().f13193c;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                a aVar = arrayList.get(i4);
                i4++;
                a aVar2 = aVar;
                if (aVar2.f13195b.equals(cVar)) {
                    return aVar2.f13194a;
                }
            }
            return null;
        } catch (Throwable th) {
            af.b("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f13191a == null && c.m().c() != null) {
                    ai.a(c.m().c());
                }
                eVar = f13191a;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (f13191a == null) {
                f13191a = new e(bVar);
            }
        }
    }

    public final boolean b() {
        return a(this.f13192b.b());
    }

    private boolean a(a aVar) {
        String str;
        a c5 = aVar.c();
        if (c5 == null) {
            str = aVar.b();
        } else {
            File b5 = b(c5.d());
            if (b5 == null) {
                return false;
            }
            str = b5.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(str);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.f13193c.add(new a(aVar.d(), file));
        List<a> a5 = aVar.a();
        if (a5 != null) {
            for (a a6 : a5) {
                if (!a(a6)) {
                    return false;
                }
            }
        }
        return true;
    }
}
