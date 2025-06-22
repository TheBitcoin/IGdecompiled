package y0;

import B0.F;
import G0.j;
import H0.C1303d;
import H0.C1304e;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: y0.z  reason: case insensitive filesystem */
public class C2435z {

    /* renamed from: g  reason: collision with root package name */
    private static final Map f22733g;

    /* renamed from: h  reason: collision with root package name */
    static final String f22734h = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"19.2.1"});

    /* renamed from: a  reason: collision with root package name */
    private final Context f22735a;

    /* renamed from: b  reason: collision with root package name */
    private final I f22736b;

    /* renamed from: c  reason: collision with root package name */
    private final C2412b f22737c;

    /* renamed from: d  reason: collision with root package name */
    private final C1303d f22738d;

    /* renamed from: e  reason: collision with root package name */
    private final j f22739e;

    /* renamed from: f  reason: collision with root package name */
    private final v0.j f22740f = v0.j.f21978a;

    static {
        HashMap hashMap = new HashMap();
        f22733g = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public C2435z(Context context, I i4, C2412b bVar, C1303d dVar, j jVar) {
        this.f22735a = context;
        this.f22736b = i4;
        this.f22737c = bVar;
        this.f22738d = dVar;
        this.f22739e = jVar;
    }

    private F.e.d.a.c A(F.a aVar) {
        return this.f22740f.a(aVar.e(), aVar.d(), aVar.c());
    }

    private F.a a(F.a aVar) {
        List list;
        if (!this.f22739e.b().f6522b.f6531c || this.f22737c.f22620c.size() <= 0) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (C2417g gVar : this.f22737c.f22620c) {
                arrayList.add(F.a.C0059a.a().d(gVar.c()).b(gVar.a()).c(gVar.b()).a());
            }
            list = DesugarCollections.unmodifiableList(arrayList);
        }
        return F.a.a().c(aVar.c()).e(aVar.e()).g(aVar.g()).i(aVar.i()).d(aVar.d()).f(aVar.f()).h(aVar.h()).j(aVar.j()).b(list).a();
    }

    private F.b b() {
        return F.b().l("19.2.1").h(this.f22737c.f22618a).i(this.f22736b.a().c()).g(this.f22736b.a().e()).f(this.f22736b.a().d()).d(this.f22737c.f22623f).e(this.f22737c.f22624g).k(4);
    }

    private static long f(long j4) {
        if (j4 > 0) {
            return j4;
        }
        return 0;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = (Integer) f22733g.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }

    private F.e.d.a.b.C0063a h() {
        return F.e.d.a.b.C0063a.a().b(0).d(0).c(this.f22737c.f22622e).e(this.f22737c.f22619b).a();
    }

    private List i() {
        return Collections.singletonList(h());
    }

    private F.e.d.a j(int i4, F.a aVar) {
        boolean z4;
        if (aVar.c() != 100) {
            z4 = true;
        } else {
            z4 = false;
        }
        return F.e.d.a.a().c(Boolean.valueOf(z4)).d(A(aVar)).h(i4).f(o(aVar)).a();
    }

    private F.e.d.a k(int i4, C1304e eVar, Thread thread, int i5, int i6, boolean z4) {
        Boolean bool;
        boolean z5;
        F.e.d.a.c e5 = this.f22740f.e(this.f22735a);
        if (e5.b() > 0) {
            if (e5.b() != 100) {
                z5 = true;
            } else {
                z5 = false;
            }
            bool = Boolean.valueOf(z5);
        } else {
            bool = null;
        }
        return F.e.d.a.a().c(bool).d(e5).b(this.f22740f.d(this.f22735a)).h(i4).f(p(eVar, thread, i5, i6, z4)).a();
    }

    private F.e.d.c l(int i4) {
        Double d5;
        C2416f a5 = C2416f.a(this.f22735a);
        Float b5 = a5.b();
        if (b5 != null) {
            d5 = Double.valueOf(b5.doubleValue());
        } else {
            d5 = null;
        }
        int c5 = a5.c();
        boolean n4 = C2420j.n(this.f22735a);
        long f4 = f(C2420j.b(this.f22735a) - C2420j.a(this.f22735a));
        return F.e.d.c.a().b(d5).c(c5).f(n4).e(i4).g(f4).d(C2420j.c(Environment.getDataDirectory().getPath())).a();
    }

    private F.e.d.a.b.c m(C1304e eVar, int i4, int i5) {
        return n(eVar, i4, i5, 0);
    }

    private F.e.d.a.b.c n(C1304e eVar, int i4, int i5, int i6) {
        String str = eVar.f6622b;
        String str2 = eVar.f6621a;
        StackTraceElement[] stackTraceElementArr = eVar.f6623c;
        int i7 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        C1304e eVar2 = eVar.f6624d;
        if (i6 >= i5) {
            C1304e eVar3 = eVar2;
            while (eVar3 != null) {
                eVar3 = eVar3.f6624d;
                i7++;
            }
        }
        F.e.d.a.b.c.C0066a d5 = F.e.d.a.b.c.a().f(str).e(str2).c(r(stackTraceElementArr, i4)).d(i7);
        if (eVar2 != null && i7 == 0) {
            d5.b(n(eVar2, i4, i5, i6 + 1));
        }
        return d5.a();
    }

    private F.e.d.a.b o(F.a aVar) {
        return F.e.d.a.b.a().b(aVar).e(w()).c(i()).a();
    }

    private F.e.d.a.b p(C1304e eVar, Thread thread, int i4, int i5, boolean z4) {
        return F.e.d.a.b.a().f(z(eVar, thread, i4, z4)).d(m(eVar, i4, i5)).e(w()).c(i()).a();
    }

    private F.e.d.a.b.C0069e.C0071b q(StackTraceElement stackTraceElement, F.e.d.a.b.C0069e.C0071b.C0072a aVar) {
        long j4;
        long j5 = 0;
        if (stackTraceElement.isNativeMethod()) {
            j4 = Math.max((long) stackTraceElement.getLineNumber(), 0);
        } else {
            j4 = 0;
        }
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j5 = (long) stackTraceElement.getLineNumber();
        }
        return aVar.e(j4).f(str).b(fileName).d(j5).a();
    }

    private List r(StackTraceElement[] stackTraceElementArr, int i4) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement q4 : stackTraceElementArr) {
            arrayList.add(q(q4, F.e.d.a.b.C0069e.C0071b.a().c(i4)));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    private F.e.a s() {
        return F.e.a.a().e(this.f22736b.f()).g(this.f22737c.f22623f).d(this.f22737c.f22624g).f(this.f22736b.a().c()).b(this.f22737c.f22625h.d()).c(this.f22737c.f22625h.e()).a();
    }

    private F.e t(String str, long j4) {
        return F.e.a().m(j4).j(str).h(f22734h).b(s()).l(v()).e(u()).i(3).a();
    }

    private F.e.c u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int g4 = g();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b5 = C2420j.b(this.f22735a);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean w4 = C2420j.w();
        int l4 = C2420j.l();
        String str = Build.MANUFACTURER;
        return F.e.c.a().b(g4).f(Build.MODEL).c(availableProcessors).h(b5).d(blockCount).i(w4).j(l4).e(str).g(Build.PRODUCT).a();
    }

    private F.e.C0076e v() {
        return F.e.C0076e.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(C2420j.x()).a();
    }

    private F.e.d.a.b.C0067d w() {
        return F.e.d.a.b.C0067d.a().d("0").c("0").b(0).a();
    }

    private F.e.d.a.b.C0069e x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private F.e.d.a.b.C0069e y(Thread thread, StackTraceElement[] stackTraceElementArr, int i4) {
        return F.e.d.a.b.C0069e.a().d(thread.getName()).c(i4).b(r(stackTraceElementArr, i4)).a();
    }

    private List z(C1304e eVar, Thread thread, int i4, boolean z4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, eVar.f6623c, i4));
        if (z4) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(x(thread2, this.f22738d.a((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public F.e.d c(F.a aVar) {
        int i4 = this.f22735a.getResources().getConfiguration().orientation;
        return F.e.d.a().g("anr").f(aVar.i()).b(j(i4, a(aVar))).c(l(i4)).a();
    }

    public F.e.d d(Throwable th, Thread thread, String str, long j4, int i4, int i5, boolean z4) {
        int i6 = this.f22735a.getResources().getConfiguration().orientation;
        C1304e a5 = C1304e.a(th, this.f22738d);
        int i7 = i6;
        return F.e.d.a().g(str).f(j4).b(k(i7, a5, thread, i4, i5, z4)).c(l(i7)).a();
    }

    public F e(String str, long j4) {
        return b().m(t(str, j4)).a();
    }
}
