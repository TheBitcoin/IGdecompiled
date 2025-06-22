package E0;

import A0.m;
import B0.F;
import C0.j;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import v0.g;
import y0.C2408A;
import y0.C2424n;

public class e {

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f6295e = Charset.forName(C.UTF8_NAME);

    /* renamed from: f  reason: collision with root package name */
    private static final int f6296f = 15;

    /* renamed from: g  reason: collision with root package name */
    private static final j f6297g = new j();

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator f6298h = new C1293a();

    /* renamed from: i  reason: collision with root package name */
    private static final FilenameFilter f6299i = new b();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f6300a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final g f6301b;

    /* renamed from: c  reason: collision with root package name */
    private final G0.j f6302c;

    /* renamed from: d  reason: collision with root package name */
    private final C2424n f6303d;

    public e(g gVar, G0.j jVar, C2424n nVar) {
        this.f6301b = gVar;
        this.f6302c = jVar;
        this.f6303d = nVar;
    }

    private void A(String str, long j4) {
        boolean z4;
        List r4 = this.f6301b.r(str, f6299i);
        if (r4.isEmpty()) {
            g f4 = g.f();
            f4.i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(r4);
        ArrayList arrayList = new ArrayList();
        Iterator it = r4.iterator();
        loop0:
        while (true) {
            z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File file = (File) it.next();
                try {
                    arrayList.add(f6297g.j(y(file)));
                    if (z4 || s(file.getName())) {
                        z4 = true;
                    }
                } catch (IOException e5) {
                    g f5 = g.f();
                    f5.l("Could not add event to report for " + file, e5);
                }
            }
        }
        if (arrayList.isEmpty()) {
            g f6 = g.f();
            f6.k("Could not parse event files for session " + str);
            return;
        }
        B(this.f6301b.q(str, "report"), arrayList, j4, z4, m.j(str, this.f6301b), this.f6303d.d(str));
    }

    private void B(File file, List list, long j4, boolean z4, String str, String str2) {
        File file2;
        try {
            j jVar = f6297g;
            F r4 = jVar.L(y(file)).v(j4, z4, str).p(str2).r(list);
            F.e n4 = r4.n();
            if (n4 != null) {
                g f4 = g.f();
                f4.b("appQualitySessionId: " + str2);
                if (z4) {
                    file2 = this.f6301b.l(n4.i());
                } else {
                    file2 = this.f6301b.n(n4.i());
                }
                D(file2, jVar.M(r4));
            }
        } catch (IOException e5) {
            g f5 = g.f();
            f5.l("Could not synthesize final report file for " + file, e5);
        }
    }

    private int C(String str, int i4) {
        List r4 = this.f6301b.r(str, new c());
        Collections.sort(r4, new d());
        return f(r4, i4);
    }

    private static void D(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f6295e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void E(File file, String str, long j4) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f6295e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j4));
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private SortedSet e(String str) {
        this.f6301b.d();
        SortedSet p4 = p();
        if (str != null) {
            p4.remove(str);
        }
        if (p4.size() > 8) {
            while (p4.size() > 8) {
                String str2 = (String) p4.last();
                g f4 = g.f();
                f4.b("Removing session over cap: " + str2);
                this.f6301b.e(str2);
                p4.remove(str2);
            }
        }
        return p4;
    }

    private static int f(List list, int i4) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i4) {
                break;
            }
            g.u(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i4 = this.f6302c.b().f6521a.f6533b;
        List n4 = n();
        int size = n4.size();
        if (size > i4) {
            for (File delete : n4.subList(i4, size)) {
                delete.delete();
            }
        }
    }

    private static long h(long j4) {
        return j4 * 1000;
    }

    private void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static String m(int i4, boolean z4) {
        String str;
        String format = String.format(Locale.US, "%010d", new Object[]{Integer.valueOf(i4)});
        if (z4) {
            str = "_";
        } else {
            str = "";
        }
        return NotificationCompat.CATEGORY_EVENT + format + str;
    }

    private List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6301b.m());
        arrayList.addAll(this.f6301b.j());
        Comparator comparator = f6298h;
        Collections.sort(arrayList, comparator);
        List o4 = this.f6301b.o();
        Collections.sort(o4, comparator);
        arrayList.addAll(o4);
        return arrayList;
    }

    private static String o(String str) {
        return str.substring(0, f6296f);
    }

    private static boolean s(String str) {
        if (!str.startsWith(NotificationCompat.CATEGORY_EVENT) || !str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean t(File file, String str) {
        if (!str.startsWith(NotificationCompat.CATEGORY_EVENT) || str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int v(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    private static String y(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f6295e);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    private void z(File file, F.d dVar, String str, F.a aVar) {
        String d5 = this.f6303d.d(str);
        try {
            j jVar = f6297g;
            D(this.f6301b.i(str), jVar.M(jVar.L(y(file)).u(dVar).q(aVar).p(d5)));
        } catch (IOException e5) {
            g f4 = g.f();
            f4.l("Could not synthesize final native report file for " + file, e5);
        }
    }

    public void i() {
        j(this.f6301b.o());
        j(this.f6301b.m());
        j(this.f6301b.j());
    }

    public void k(String str, long j4) {
        for (String str2 : e(str)) {
            g f4 = g.f();
            f4.i("Finalizing report for session " + str2);
            A(str2, j4);
            this.f6301b.e(str2);
        }
        g();
    }

    public void l(String str, F.d dVar, F.a aVar) {
        File q4 = this.f6301b.q(str, "report");
        g f4 = g.f();
        f4.b("Writing native session report for " + str + " to file: " + q4);
        z(q4, dVar, str, aVar);
    }

    public SortedSet p() {
        return new TreeSet(this.f6301b.f()).descendingSet();
    }

    public long q(String str) {
        return this.f6301b.q(str, "start-time").lastModified();
    }

    public boolean r() {
        if (!this.f6301b.o().isEmpty() || !this.f6301b.m().isEmpty() || !this.f6301b.j().isEmpty()) {
            return true;
        }
        return false;
    }

    public List u() {
        List<File> n4 = n();
        ArrayList arrayList = new ArrayList();
        for (File file : n4) {
            try {
                arrayList.add(C2408A.a(f6297g.L(y(file)), file.getName(), file));
            } catch (IOException e5) {
                g f4 = g.f();
                f4.l("Could not load report file " + file + "; deleting", e5);
                file.delete();
            }
        }
        return arrayList;
    }

    public void w(F.e.d dVar, String str, boolean z4) {
        int i4 = this.f6302c.b().f6521a.f6532a;
        try {
            D(this.f6301b.q(str, m(this.f6300a.getAndIncrement(), z4)), f6297g.k(dVar));
        } catch (IOException e5) {
            g f4 = g.f();
            f4.l("Could not persist event for session " + str, e5);
        }
        C(str, i4);
    }

    public void x(F f4) {
        F.e n4 = f4.n();
        if (n4 == null) {
            g.f().b("Could not get session for report");
            return;
        }
        String i4 = n4.i();
        try {
            D(this.f6301b.q(i4, "report"), f6297g.M(f4));
            E(this.f6301b.q(i4, "start-time"), "", n4.l());
        } catch (IOException e5) {
            g f5 = g.f();
            f5.c("Could not persist report for session " + i4, e5);
        }
    }
}
