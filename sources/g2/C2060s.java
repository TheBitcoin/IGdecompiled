package g2;

import N1.k;
import W1.C1612h;
import W1.i;
import W1.s;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import u2.t;
import u2.w;
import u2.z;

/* renamed from: g2.s  reason: case insensitive filesystem */
public final class C2060s implements Parcelable {
    public static Parcelable.Creator<C2060s> CREATOR = new a();

    /* renamed from: u  reason: collision with root package name */
    public static final b f20736u = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private int f20737a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20738b;

    /* renamed from: c  reason: collision with root package name */
    private int f20739c;

    /* renamed from: d  reason: collision with root package name */
    private int f20740d = 1;

    /* renamed from: e  reason: collision with root package name */
    private long f20741e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f20742f;

    /* renamed from: g  reason: collision with root package name */
    private long f20743g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f20744h;

    /* renamed from: i  reason: collision with root package name */
    private String f20745i;

    /* renamed from: j  reason: collision with root package name */
    private String f20746j;

    /* renamed from: k  reason: collision with root package name */
    private int f20747k;

    /* renamed from: l  reason: collision with root package name */
    private String f20748l;

    /* renamed from: m  reason: collision with root package name */
    private String f20749m;

    /* renamed from: n  reason: collision with root package name */
    private long f20750n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList f20751o;

    /* renamed from: p  reason: collision with root package name */
    private long f20752p = -1;

    /* renamed from: q  reason: collision with root package name */
    private long f20753q = -1;

    /* renamed from: r  reason: collision with root package name */
    private long f20754r = -1;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f20755s;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList f20756t = new ArrayList();

    /* renamed from: g2.s$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2060s createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2060s(parcel);
        }

        /* renamed from: b */
        public C2060s[] newArray(int i4) {
            return new C2060s[i4];
        }
    }

    /* renamed from: g2.s$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    public C2060s() {
    }

    private final boolean J() {
        if (this.f20742f >= 4) {
            return true;
        }
        return false;
    }

    private final void O(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String str = this.f20738b;
                m.b(str);
                packageInfo = s.d(packageManager, str, 0);
            } else {
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f20754r = new C1612h().m(packageInfo);
            }
        } catch (Exception unused) {
        }
    }

    private final boolean a() {
        if (System.currentTimeMillis() > this.f20750n) {
            return true;
        }
        return false;
    }

    private final boolean c(File file, c cVar) {
        boolean z4;
        boolean p4 = m3.m.p(cVar.a(), file.getAbsolutePath(), true);
        if (!p4 || cVar.i() != file.length()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!p4 || !z4) {
            return false;
        }
        return true;
    }

    public final String A() {
        return this.f20746j;
    }

    public final ArrayList B() {
        return this.f20751o;
    }

    public final long C() {
        return this.f20752p;
    }

    public final String D() {
        return this.f20748l;
    }

    public final long E() {
        return this.f20741e;
    }

    public final long F() {
        return this.f20753q;
    }

    public final long G() {
        return this.f20754r;
    }

    public final boolean H() {
        if (J() || !a()) {
            return false;
        }
        return true;
    }

    public final void I(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        this.f20742f++;
        this.f20750n = System.currentTimeMillis() + 1800000;
        a5.z(this);
        if (this.f20742f >= 4) {
            S(context);
        } else {
            a5.M0(this);
        }
        a5.i();
    }

    public final boolean K() {
        if (this.f20738b == null || !N() || f() || this.f20745i == null || this.f20741e <= 0 || !H()) {
            return false;
        }
        return true;
    }

    public final boolean L() {
        T1.a i4 = k.f7778g.i();
        if (this.f20741e <= 0 || this.f20738b == null || i4 == null || !m3.m.p(i4.b(), this.f20738b, true) || i4.e() != this.f20741e) {
            return false;
        }
        return true;
    }

    public final boolean M() {
        if (this.f20752p > 0) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        if (this.f20752p == -1) {
            return true;
        }
        return false;
    }

    public final void P(Cursor cursor) {
        m.e(cursor, "c");
        this.f20737a = cursor.getInt(0);
        this.f20738b = cursor.getString(1);
        this.f20739c = cursor.getInt(2);
        this.f20740d = cursor.getInt(3);
        this.f20741e = cursor.getLong(4);
        this.f20742f = cursor.getInt(5);
        this.f20743g = cursor.getLong(6);
        this.f20744h = cursor.getInt(7);
        this.f20745i = cursor.getString(8);
        this.f20746j = cursor.getString(9);
        this.f20747k = cursor.getInt(10);
        this.f20748l = cursor.getString(11);
        this.f20749m = cursor.getString(12);
        this.f20750n = cursor.getLong(13);
        this.f20752p = cursor.getLong(14);
    }

    public final int Q(Context context) {
        m.e(context, "context");
        if (this.f20756t.isEmpty() || ((c) this.f20756t.get(0)).d() < 0) {
            return -1;
        }
        t a5 = t.f21927u.a(context);
        a5.a();
        String str = this.f20738b;
        m.b(str);
        C2060s i02 = a5.i0(str, this.f20741e);
        if (i02 == null) {
            i02 = a5.M0(this);
        }
        a5.i();
        return i02.f20737a;
    }

    public final int R(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        int z4 = a5.z(this);
        a5.i();
        return z4;
    }

    public final void S(Context context) {
        c cVar;
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        this.f20740d = 1;
        a5.w1(this);
        String str = null;
        if (!this.f20756t.isEmpty()) {
            Iterator it = this.f20756t.iterator();
            m.d(it, "iterator(...)");
            cVar = null;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                cVar = (c) next;
                new w().c(cVar.a());
                if (M()) {
                    cVar.m(-1);
                    cVar.k((String) null);
                    cVar.p(0);
                    cVar.l(0);
                    cVar.o(0);
                    a5.x1(cVar);
                }
            }
        } else {
            cVar = null;
        }
        a5.i();
        if (M()) {
            if (cVar != null) {
                str = cVar.a();
            }
            if (str != null) {
                String a6 = cVar.a();
                m.b(a6);
                File parentFile = new File(a6).getParentFile();
                if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                    String[] list = parentFile.list();
                    if (list == null || list.length == 0) {
                        parentFile.delete();
                    }
                }
            }
        }
    }

    public final void T(long j4) {
        this.f20743g = j4;
    }

    public final void U(String str) {
        this.f20749m = str;
    }

    public final void V() {
        this.f20740d = 0;
    }

    public final void W(int i4) {
        this.f20744h = i4;
    }

    public final void X(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f20756t = arrayList;
    }

    public final void Y(int i4) {
        this.f20737a = i4;
    }

    public final void Z(String str) {
        this.f20738b = str;
    }

    public final void a0(long j4) {
        this.f20752p = j4;
    }

    public final boolean b(File file) {
        boolean z4;
        m.e(file, "file");
        boolean z5 = false;
        if (this.f20756t.isEmpty()) {
            new i().a(file);
        } else if (this.f20756t.size() == 1 && file.isFile()) {
            Object obj = this.f20756t.get(0);
            m.d(obj, "get(...)");
            z5 = c(file, (c) obj);
        } else if (this.f20756t.size() > 1 && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    ArrayList arrayList = new ArrayList();
                    Iterator a5 = C2098b.a(listFiles);
                    boolean z6 = true;
                    while (a5.hasNext()) {
                        File file2 = (File) a5.next();
                        Iterator it = this.f20756t.iterator();
                        m.d(it, "iterator(...)");
                        boolean z7 = false;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            m.d(next, "next(...)");
                            c cVar = (c) next;
                            if (m3.m.p(cVar.a(), file.getAbsolutePath(), true)) {
                                if (cVar.i() != file.length()) {
                                    arrayList.add(file2);
                                    z6 = false;
                                    z7 = true;
                                    break;
                                }
                                z7 = true;
                            }
                        }
                        if (!z7) {
                            arrayList.add(file2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        m.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            m.d(next2, "next(...)");
                            new i().a((File) next2);
                        }
                    }
                    z5 = z6;
                }
            }
            z5 = true;
        }
        if (!z5) {
            new i().a(file);
        }
        return z5;
    }

    public final void b0(String str) {
        this.f20748l = str;
    }

    public final void c0(long j4) {
        this.f20741e = j4;
    }

    public final void d(C2050h hVar) {
        c cVar;
        String l02;
        m.e(hVar, "appInfo");
        this.f20738b = hVar.Q();
        this.f20743g = hVar.e();
        this.f20749m = hVar.L();
        if (this.f20745i == null) {
            this.f20745i = hVar.J();
        }
        if (!this.f20756t.isEmpty()) {
            cVar = (c) this.f20756t.get(0);
        } else {
            cVar = new c();
        }
        if (cVar.e() == null) {
            cVar.n(hVar.i0());
        }
        if (cVar.d() < 0) {
            cVar.m(hVar.z());
        }
        if (!(cVar.i() > 0 || (l02 = hVar.l0()) == null || l02.length() == 0)) {
            try {
                String l03 = hVar.l0();
                m.b(l03);
                cVar.q(Long.parseLong(l03));
            } catch (NumberFormatException e5) {
                e5.printStackTrace();
            }
        }
        if (!this.f20756t.isEmpty()) {
            this.f20756t.set(0, cVar);
        } else {
            this.f20756t.add(cVar);
        }
        this.f20748l = hVar.E();
        this.f20751o = hVar.n0();
        if (!z.f21956a.f()) {
            this.f20744h = 1;
        }
        if (this.f20741e <= 0) {
            if (hVar.v0() > 0) {
                this.f20741e = hVar.v0();
            } else if (hVar.H() > 0) {
                this.f20741e = hVar.H();
            }
        }
        this.f20746j = null;
        if (hVar.m0() != null) {
            ArrayList m02 = hVar.m0();
            m.b(m02);
            if (m02.size() > 0) {
                ArrayList m03 = hVar.m0();
                m.b(m03);
                int size = m03.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String str = this.f20746j;
                    if (str == null) {
                        ArrayList m04 = hVar.m0();
                        m.b(m04);
                        this.f20746j = (String) m04.get(i4);
                    } else {
                        F f4 = F.f20971a;
                        ArrayList m05 = hVar.m0();
                        m.b(m05);
                        String format = String.format("%s,%s", Arrays.copyOf(new Object[]{str, m05.get(i4)}, 2));
                        m.d(format, "format(...)");
                        this.f20746j = format;
                    }
                }
            }
        }
        if (hVar.K() != null) {
            try {
                String K4 = hVar.K();
                m.b(K4);
                this.f20747k = Integer.parseInt(K4);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public int describeContents() {
        return hashCode();
    }

    public final void e(C2048f fVar, S s4) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        m.e(s4, "update");
        this.f20738b = s4.h();
        this.f20743g = fVar.b();
        this.f20749m = fVar.m();
        this.f20745i = fVar.k();
        this.f20741e = s4.j();
        if (s4.d() == -1) {
            this.f20752p = 0;
        } else {
            this.f20752p = s4.d();
        }
    }

    public final boolean f() {
        if (this.f20740d == 0) {
            return true;
        }
        return false;
    }

    public final void g() {
        if (!this.f20756t.isEmpty()) {
            Iterator it = this.f20756t.iterator();
            m.d(it, "iterator(...)");
            String str = null;
            c cVar = null;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                cVar = (c) next;
                new w().c(cVar.a());
            }
            if (M()) {
                if (cVar != null) {
                    str = cVar.a();
                }
                if (str != null) {
                    String a5 = cVar.a();
                    m.b(a5);
                    File parentFile = new File(a5).getParentFile();
                    if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                        String[] list = parentFile.list();
                        if (list == null || list.length == 0) {
                            parentFile.delete();
                        }
                    }
                }
            }
        }
    }

    public final long h() {
        return this.f20743g;
    }

    public final String i() {
        return this.f20749m;
    }

    public final int j() {
        return this.f20742f;
    }

    public final int k() {
        return this.f20739c;
    }

    public final int l() {
        return this.f20744h;
    }

    public final File m(Context context) {
        String str;
        m.e(context, "context");
        if (!this.f20756t.isEmpty()) {
            str = ((c) this.f20756t.get(0)).a();
        } else {
            str = null;
        }
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public final File n() {
        if (this.f20756t.size() == 1 && ((c) this.f20756t.get(0)).a() != null) {
            String a5 = ((c) this.f20756t.get(0)).a();
            m.b(a5);
            return new File(a5);
        } else if (this.f20756t.size() <= 1 || ((c) this.f20756t.get(0)).a() == null) {
            return null;
        } else {
            String a6 = ((c) this.f20756t.get(0)).a();
            m.b(a6);
            return new File(a6).getParentFile();
        }
    }

    public final ArrayList o() {
        return this.f20756t;
    }

    public final Drawable p() {
        return this.f20755s;
    }

    public final int q() {
        return this.f20737a;
    }

    public final int r() {
        return this.f20740d;
    }

    public final void s(Context context, File file) {
        m.e(context, "context");
        m.e(file, "file");
        if (this.f20738b != null) {
            long j4 = this.f20741e;
            if (j4 > 0) {
                this.f20753q = j4;
                O(context);
                return;
            }
            String name = file.getName();
            m.d(name, "getName(...)");
            if (m3.m.o(name, ".apk", false, 2, (Object) null)) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    m.d(packageManager, "getPackageManager(...)");
                    String absolutePath = file.getAbsolutePath();
                    m.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = s.c(packageManager, absolutePath, 128);
                    if (c5 != null) {
                        this.f20753q = new C1612h().m(c5);
                    }
                    if (c5 != null && m3.m.q(this.f20738b, c5.packageName, false, 2, (Object) null)) {
                        O(context);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String t() {
        return this.f20745i;
    }

    public String toString() {
        return "{id='" + this.f20737a + "', packagename='" + this.f20738b + "', checkedByUser=" + this.f20739c + ", incomplete=" + this.f20740d + ", versioncode='" + this.f20741e + "', attempts=" + this.f20742f + ", appId=" + this.f20743g + ", downloadAnyway=" + this.f20744h + ", md5signature='" + this.f20745i + "', supportedAbis='" + this.f20746j + "', minsdk=" + this.f20747k + ", urlIcon='" + this.f20748l + "', appName='" + this.f20749m + "', versioncodeFile=" + this.f20753q + ", versioncodeInstalled=" + this.f20754r + ", nextAttemptTimeStamp=" + this.f20750n + ", updateId=" + this.f20752p + ", files=" + this.f20756t + '}';
    }

    public final int u() {
        return this.f20747k;
    }

    public final long v() {
        return this.f20750n;
    }

    public final String w() {
        return this.f20738b;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeInt(this.f20737a);
        parcel.writeString(this.f20738b);
        parcel.writeInt(this.f20739c);
        parcel.writeInt(this.f20740d);
        parcel.writeLong(this.f20741e);
        parcel.writeInt(this.f20742f);
        parcel.writeLong(this.f20743g);
        parcel.writeInt(this.f20744h);
        parcel.writeString(this.f20745i);
        parcel.writeString(this.f20746j);
        parcel.writeInt(this.f20747k);
        parcel.writeString(this.f20748l);
        parcel.writeString(this.f20749m);
        parcel.writeLong(this.f20750n);
        parcel.writeStringList(this.f20751o);
        parcel.writeTypedList(this.f20756t);
        parcel.writeLong(this.f20752p);
    }

    public final int x() {
        long j4;
        long j5;
        if (!this.f20756t.isEmpty()) {
            Iterator it = this.f20756t.iterator();
            m.d(it, "iterator(...)");
            j5 = 0;
            j4 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                c cVar = (c) next;
                j5 += cVar.i();
                j4 += cVar.h();
            }
        } else {
            j5 = 0;
            j4 = 0;
        }
        if (j4 <= 0 || j5 <= 0) {
            return 0;
        }
        return (int) ((((double) j4) * 100.0d) / ((double) j5));
    }

    public final long y() {
        long j4 = 0;
        if (!this.f20756t.isEmpty()) {
            Iterator it = this.f20756t.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                j4 += ((c) next).h();
            }
        }
        return j4;
    }

    public final long z() {
        long j4 = 0;
        if (!this.f20756t.isEmpty()) {
            Iterator it = this.f20756t.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                j4 += ((c) next).i();
            }
        }
        return j4;
    }

    /* renamed from: g2.s$c */
    public static final class c implements Parcelable {
        public static Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: k  reason: collision with root package name */
        public static final b f20757k = new b((C2103g) null);

        /* renamed from: a  reason: collision with root package name */
        private long f20758a = -1;

        /* renamed from: b  reason: collision with root package name */
        private long f20759b = -1;

        /* renamed from: c  reason: collision with root package name */
        private long f20760c = -1;

        /* renamed from: d  reason: collision with root package name */
        private String f20761d;

        /* renamed from: e  reason: collision with root package name */
        private long f20762e = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f20763f;

        /* renamed from: g  reason: collision with root package name */
        private String f20764g;

        /* renamed from: h  reason: collision with root package name */
        private String f20765h;

        /* renamed from: i  reason: collision with root package name */
        private int f20766i;

        /* renamed from: j  reason: collision with root package name */
        private long f20767j;

        /* renamed from: g2.s$c$a */
        public static final class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                m.e(parcel, "source");
                return new c(parcel);
            }

            /* renamed from: b */
            public c[] newArray(int i4) {
                return new c[i4];
            }
        }

        /* renamed from: g2.s$c$b */
        public static final class b {
            public /* synthetic */ b(C2103g gVar) {
                this();
            }

            private b() {
            }
        }

        public c() {
        }

        public final String a() {
            return this.f20765h;
        }

        public final int b() {
            return this.f20766i;
        }

        public final long c() {
            return this.f20759b;
        }

        public final long d() {
            return this.f20760c;
        }

        public int describeContents() {
            return hashCode();
        }

        public final String e() {
            return this.f20764g;
        }

        public final long f() {
            return this.f20758a;
        }

        public final long g() {
            return this.f20767j;
        }

        public final long h() {
            return this.f20763f;
        }

        public final long i() {
            return this.f20762e;
        }

        public final void j(Cursor cursor) {
            m.e(cursor, "c");
            this.f20758a = cursor.getLong(0);
            this.f20759b = cursor.getLong(1);
            this.f20760c = cursor.getLong(2);
            this.f20761d = cursor.getString(3);
            this.f20762e = cursor.getLong(4);
            this.f20763f = cursor.getLong(5);
            this.f20764g = cursor.getString(6);
            this.f20765h = cursor.getString(7);
            this.f20766i = cursor.getInt(8);
            this.f20767j = cursor.getLong(9);
        }

        public final void k(String str) {
            this.f20765h = str;
        }

        public final void l(int i4) {
            this.f20766i = i4;
        }

        public final void m(long j4) {
            this.f20760c = j4;
        }

        public final void n(String str) {
            this.f20764g = str;
        }

        public final void o(long j4) {
            this.f20767j = j4;
        }

        public final void p(long j4) {
            this.f20763f = j4;
        }

        public final void q(long j4) {
            this.f20762e = j4;
        }

        public String toString() {
            return "{id='" + this.f20758a + "', downloadId='" + this.f20759b + "', fileId='" + this.f20760c + "', type=" + this.f20761d + ", sizeExpected='" + this.f20762e + "', sizeDownloaded='" + this.f20763f + "', filehashExpected='" + this.f20764g + "', absolutePath='" + this.f20765h + "', attempts=" + this.f20766i + ", nextAttemptTimeStamp=" + this.f20767j + '}';
        }

        public void writeToParcel(Parcel parcel, int i4) {
            m.e(parcel, "parcel");
            parcel.writeLong(this.f20758a);
            parcel.writeLong(this.f20759b);
            parcel.writeLong(this.f20760c);
            parcel.writeString(this.f20761d);
            parcel.writeLong(this.f20762e);
            parcel.writeLong(this.f20763f);
            parcel.writeString(this.f20764g);
            parcel.writeString(this.f20765h);
            parcel.writeInt(this.f20766i);
            parcel.writeLong(this.f20767j);
        }

        public c(Parcel parcel) {
            m.e(parcel, "source");
            this.f20758a = parcel.readLong();
            this.f20759b = parcel.readLong();
            this.f20760c = parcel.readLong();
            this.f20761d = parcel.readString();
            this.f20762e = parcel.readLong();
            this.f20763f = parcel.readLong();
            this.f20764g = parcel.readString();
            this.f20765h = parcel.readString();
            this.f20766i = parcel.readInt();
            this.f20767j = parcel.readLong();
        }
    }

    public C2060s(Parcel parcel) {
        m.e(parcel, "source");
        this.f20737a = parcel.readInt();
        this.f20738b = parcel.readString();
        this.f20739c = parcel.readInt();
        this.f20740d = parcel.readInt();
        this.f20741e = parcel.readLong();
        this.f20742f = parcel.readInt();
        this.f20743g = parcel.readLong();
        this.f20744h = parcel.readInt();
        this.f20745i = parcel.readString();
        this.f20746j = parcel.readString();
        this.f20747k = parcel.readInt();
        this.f20748l = parcel.readString();
        this.f20749m = parcel.readString();
        this.f20750n = parcel.readLong();
        this.f20751o = parcel.createStringArrayList();
        parcel.readTypedList(this.f20756t, c.CREATOR);
        this.f20752p = parcel.readLong();
    }
}
