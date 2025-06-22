package O3;

import N3.C2518i;
import N3.C2519j;
import N3.C2520k;
import N3.Q;
import N3.Z;
import R2.g;
import R2.h;
import R2.p;
import S2.C1601o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import d3.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

/* renamed from: O3.h  reason: case insensitive filesystem */
public final class C2542h extends C2520k {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final a f23759f = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Q f23760g = Q.a.e(Q.f23639b, "/", false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final g f23761e;

    /* renamed from: O3.h$a */
    private static final class a {

        /* renamed from: O3.h$a$a  reason: collision with other inner class name */
        static final class C0286a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0286a f23762a = new C0286a();

            C0286a() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(C2543i iVar) {
                m.e(iVar, "entry");
                return Boolean.valueOf(C2542h.f23759f.c(iVar.a()));
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean c(Q q4) {
            return !m3.m.n(q4.f(), ".class", true);
        }

        public final Q b() {
            return C2542h.f23760g;
        }

        public final List d(ClassLoader classLoader) {
            m.e(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            m.d(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            m.d(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                T t4 = list.get(i5);
                i5++;
                URL url = (URL) t4;
                a m4 = C2542h.f23759f;
                m.d(url, "it");
                R2.l e5 = m4.e(url);
                if (e5 != null) {
                    arrayList.add(e5);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            m.d(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            m.d(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            int size2 = list2.size();
            while (i4 < size2) {
                T t5 = list2.get(i4);
                i4++;
                URL url2 = (URL) t5;
                a m5 = C2542h.f23759f;
                m.d(url2, "it");
                R2.l f4 = m5.f(url2);
                if (f4 != null) {
                    arrayList2.add(f4);
                }
            }
            return C1601o.S(arrayList, arrayList2);
        }

        public final R2.l e(URL url) {
            m.e(url, "<this>");
            if (!m.a(url.getProtocol(), "file")) {
                return null;
            }
            return p.a(C2520k.f23728b, Q.a.d(Q.f23639b, new File(url.toURI()), false, 1, (Object) null));
        }

        public final R2.l f(URL url) {
            int R4;
            m.e(url, "<this>");
            String url2 = url.toString();
            m.d(url2, "toString()");
            if (!m3.m.y(url2, "jar:file:", false, 2, (Object) null) || (R4 = m3.m.R(url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Q.a aVar = Q.f23639b;
            String substring = url2.substring(4, R4);
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return p.a(C2544j.d(Q.a.d(aVar, new File(URI.create(substring)), false, 1, (Object) null), C2520k.f23728b, C0286a.f23762a), b());
        }

        private a() {
        }
    }

    /* renamed from: O3.h$b */
    static final class b extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ClassLoader f23763a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ClassLoader classLoader) {
            super(0);
            this.f23763a = classLoader;
        }

        /* renamed from: a */
        public final List invoke() {
            return C2542h.f23759f.d(this.f23763a);
        }
    }

    public C2542h(ClassLoader classLoader, boolean z4) {
        m.e(classLoader, "classLoader");
        this.f23761e = h.a(new b(classLoader));
        if (z4) {
            p().size();
        }
    }

    private final Q o(Q q4) {
        return f23760g.k(q4, true);
    }

    private final List p() {
        return (List) this.f23761e.getValue();
    }

    private final String q(Q q4) {
        return o(q4).j(f23760g).toString();
    }

    public void a(Q q4, Q q5) {
        m.e(q4, "source");
        m.e(q5, TypedValues.AttributesType.S_TARGET);
        throw new IOException(this + " is read-only");
    }

    public void d(Q q4, boolean z4) {
        m.e(q4, "dir");
        throw new IOException(this + " is read-only");
    }

    public void f(Q q4, boolean z4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        throw new IOException(this + " is read-only");
    }

    public C2519j h(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (!f23759f.c(q4)) {
            return null;
        }
        String q5 = q(q4);
        for (R2.l lVar : p()) {
            C2519j h4 = ((C2520k) lVar.a()).h(((Q) lVar.b()).l(q5));
            if (h4 != null) {
                return h4;
            }
        }
        return null;
    }

    public C2518i i(Q q4) {
        m.e(q4, "file");
        if (f23759f.c(q4)) {
            String q5 = q(q4);
            for (R2.l lVar : p()) {
                try {
                    return ((C2520k) lVar.a()).i(((Q) lVar.b()).l(q5));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + q4);
        }
        throw new FileNotFoundException("file not found: " + q4);
    }

    public C2518i k(Q q4, boolean z4, boolean z5) {
        m.e(q4, "file");
        throw new IOException("resources are not writable");
    }

    public Z l(Q q4) {
        m.e(q4, "file");
        if (f23759f.c(q4)) {
            String q5 = q(q4);
            for (R2.l lVar : p()) {
                try {
                    return ((C2520k) lVar.a()).l(((Q) lVar.b()).l(q5));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + q4);
        }
        throw new FileNotFoundException("file not found: " + q4);
    }
}
