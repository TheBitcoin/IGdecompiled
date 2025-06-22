package u2;

import S2.C1601o;
import W1.C1611g;
import W1.C1612h;
import W1.s;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21950a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
        }
    }

    public final ArrayList a() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory() && (listFiles = externalStoragePublicDirectory.listFiles()) != null) {
            for (File file : listFiles) {
                C1611g gVar = new C1611g();
                String name = file.getName();
                m.d(name, "getName(...)");
                if (gVar.l(name)) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    public final void b(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        ArrayList F02 = a5.F0();
        a5.i();
        Iterator it = new w().e(context).iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            File file = (File) next;
            Iterator it2 = F02.iterator();
            m.d(it2, "iterator(...)");
            boolean z4 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                S s4 = (S) next2;
                if (!s4.m() && s4.a() != null) {
                    C2060s a6 = s4.a();
                    m.b(a6);
                    if (!a6.o().isEmpty()) {
                        C2060s a7 = s4.a();
                        m.b(a7);
                        Iterator it3 = a7.o().iterator();
                        m.d(it3, "iterator(...)");
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            Object next3 = it3.next();
                            m.d(next3, "next(...)");
                            if (m3.m.q(((C2060s.c) next3).a(), file.getAbsolutePath(), false, 2, (Object) null)) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!z4) {
                file.delete();
            }
        }
    }

    public final void c(String str) {
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final ArrayList d(Context context) {
        m.e(context, "context");
        return new C1611g().i(f(context), context);
    }

    public final ArrayList e(Context context) {
        m.e(context, "context");
        return new C1611g().i(g(context), context);
    }

    public final File f(Context context) {
        m.e(context, "context");
        return new C1612h().a(context, "Apps");
    }

    public final File g(Context context) {
        m.e(context, "context");
        return new C1612h().a(context, "Updates");
    }

    public final File h(Context context) {
        m.e(context, "context");
        ArrayList j4 = j(context);
        int size = j4.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (File) j4.get(0);
        }
        if (j4.size() > 1) {
            C1601o.t(j4, new b());
        }
        return (File) j4.get(0);
    }

    public final String i(String str) {
        int R4;
        m.e(str, "fileNameParam");
        String str2 = "uptodown" + "-";
        if (m3.m.y(str, str2, false, 2, (Object) null)) {
            String str3 = str;
            String str4 = str3;
            if (m3.m.j0(str3, new String[]{"-"}, false, 0, 6, (Object) null).size() == 2) {
                int L4 = m3.m.L(str4, " ", 0, false, 6, (Object) null);
                if (L4 > 0) {
                    String substring = str4.substring(0, L4);
                    m.d(substring, "substring(...)");
                    str4 = substring + ".apk";
                }
                if (m3.m.D(str4, "(", false, 2, (Object) null) && m3.m.n(str4, ").apk", true)) {
                    String substring2 = str4.substring(0, m3.m.L(str4, "(", 0, false, 6, (Object) null));
                    m.d(substring2, "substring(...)");
                    String substring3 = substring2.substring(str2.length());
                    m.d(substring3, "substring(...)");
                    return substring3;
                } else if (m3.m.n(str4, ".apk", true) && (R4 = m3.m.R(str4, ".apk", 0, false, 6, (Object) null)) > 0 && str4.length() == R4 + 4) {
                    String substring4 = str4.substring(0, R4);
                    m.d(substring4, "substring(...)");
                    String substring5 = substring4.substring(str2.length());
                    m.d(substring5, "substring(...)");
                    return substring5;
                }
            }
        }
        return null;
    }

    public final ArrayList j(Context context) {
        m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory()) {
            C1611g gVar = new C1611g();
            m.b(externalStoragePublicDirectory);
            Iterator it = gVar.i(externalStoragePublicDirectory, context).iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                File file = (File) next;
                String name = file.getName();
                m.d(name, "getName(...)");
                if (m3.m.n(name, ".apk", true)) {
                    m.b(packageManager);
                    String absolutePath = file.getAbsolutePath();
                    m.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = s.c(packageManager, absolutePath, 128);
                    if (c5 != null && c5.packageName.equals("com.uptodown")) {
                        arrayList.add(file);
                    }
                }
            }
        }
        return arrayList;
    }

    public final long k(Context context, File file) {
        m.e(context, "context");
        m.e(file, "storageDir");
        ArrayList i4 = new q().i(context);
        int size = i4.size();
        long j4 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = i4.get(i5);
            i5++;
            j4 += ((C2060s) obj).z();
        }
        return file.getUsableSpace() - j4;
    }
}
