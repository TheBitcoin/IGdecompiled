package g2;

import W1.E;
import W1.i;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: g2.f  reason: case insensitive filesystem */
public final class C2048f implements Parcelable {

    /* renamed from: C  reason: collision with root package name */
    public static final b f20565C = new b((C2103g) null);
    public static Parcelable.Creator<C2048f> CREATOR = new a();

    /* renamed from: A  reason: collision with root package name */
    private ArrayList f20566A;

    /* renamed from: B  reason: collision with root package name */
    private boolean f20567B;

    /* renamed from: a  reason: collision with root package name */
    private long f20568a;

    /* renamed from: b  reason: collision with root package name */
    private String f20569b;

    /* renamed from: c  reason: collision with root package name */
    private String f20570c;

    /* renamed from: d  reason: collision with root package name */
    private long f20571d;

    /* renamed from: e  reason: collision with root package name */
    private String f20572e;

    /* renamed from: f  reason: collision with root package name */
    private String f20573f;

    /* renamed from: g  reason: collision with root package name */
    private c f20574g;

    /* renamed from: h  reason: collision with root package name */
    private int f20575h;

    /* renamed from: i  reason: collision with root package name */
    private int f20576i;

    /* renamed from: j  reason: collision with root package name */
    private int f20577j;

    /* renamed from: k  reason: collision with root package name */
    private int f20578k;

    /* renamed from: l  reason: collision with root package name */
    private String f20579l;

    /* renamed from: m  reason: collision with root package name */
    private int f20580m;

    /* renamed from: n  reason: collision with root package name */
    private long f20581n;

    /* renamed from: o  reason: collision with root package name */
    private long f20582o;

    /* renamed from: p  reason: collision with root package name */
    private int f20583p;

    /* renamed from: q  reason: collision with root package name */
    private String f20584q;

    /* renamed from: r  reason: collision with root package name */
    private long f20585r;

    /* renamed from: s  reason: collision with root package name */
    private String f20586s;

    /* renamed from: t  reason: collision with root package name */
    private int f20587t;

    /* renamed from: u  reason: collision with root package name */
    private C2038F f20588u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f20589v;

    /* renamed from: w  reason: collision with root package name */
    private long f20590w;

    /* renamed from: x  reason: collision with root package name */
    private int f20591x;

    /* renamed from: y  reason: collision with root package name */
    private int f20592y;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList f20593z;

    /* renamed from: g2.f$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2048f createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2048f(parcel);
        }

        /* renamed from: b */
        public C2048f[] newArray(int i4) {
            return new C2048f[i4];
        }
    }

    /* renamed from: g2.f$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    /* renamed from: g2.f$c */
    public enum c {
        OUTDATED,
        UPDATED,
        UNAVAILABLE;

        static {
            c[] a5;
            f20598e = X2.b.a(a5);
        }
    }

    /* renamed from: g2.f$d */
    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20599a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                g2.f$c[] r0 = g2.C2048f.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                g2.f$c r1 = g2.C2048f.c.OUTDATED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                g2.f$c r1 = g2.C2048f.c.UPDATED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f20599a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2048f.d.<clinit>():void");
        }
    }

    public C2048f() {
        this.f20568a = -1;
        this.f20571d = -1;
        this.f20574g = c.UPDATED;
        this.f20592y = -1;
    }

    public final long A() {
        return this.f20571d;
    }

    public final String B() {
        return this.f20572e;
    }

    public final boolean C(Context context) {
        m.e(context, "context");
        if (this.f20570c == null) {
            return false;
        }
        if (H()) {
            return com.uptodown.activities.preferences.a.f18818a.g0(context);
        }
        if (F()) {
            return com.uptodown.activities.preferences.a.f18818a.f0(context);
        }
        return true;
    }

    public final boolean D() {
        long j4 = this.f20582o;
        long j5 = this.f20585r;
        long currentTimeMillis = System.currentTimeMillis();
        if (j5 == j4 || currentTimeMillis - j4 >= 604800000) {
            return false;
        }
        return true;
    }

    public final int E() {
        return this.f20575h;
    }

    public final boolean F() {
        if (this.f20575h == 1) {
            return true;
        }
        return false;
    }

    public final int G() {
        return this.f20576i;
    }

    public final boolean H() {
        if (this.f20576i == 1) {
            return true;
        }
        return false;
    }

    public final void I(t tVar) {
        m.e(tVar, "dbManager");
        this.f20566A = new ArrayList();
        E e5 = new E();
        String str = this.f20570c;
        m.b(str);
        ArrayList a5 = e5.a(str);
        if (!a5.isEmpty()) {
            String str2 = this.f20570c;
            m.b(str2);
            C2048f Y4 = tVar.Y(str2);
            if (Y4 != null) {
                ArrayList Z4 = tVar.Z(Y4.f20568a);
                Iterator it = a5.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    File file = (File) next;
                    if (file.isFile()) {
                        String name = file.getName();
                        m.d(name, "getName(...)");
                        if (m3.m.o(name, ".obb", false, 2, (Object) null)) {
                            String absolutePath = file.getAbsolutePath();
                            m.d(absolutePath, "getAbsolutePath(...)");
                            ArrayList arrayList = this.f20566A;
                            m.b(arrayList);
                            a(absolutePath, Z4, tVar, Y4, arrayList);
                        }
                    }
                }
            }
        }
    }

    public final void J(ApplicationInfo applicationInfo, t tVar) {
        m.e(applicationInfo, "applicationInfo");
        m.e(tVar, "dbManager");
        this.f20593z = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            String str = this.f20570c;
            m.b(str);
            C2048f Y4 = tVar.Y(str);
            if (Y4 != null) {
                ArrayList Z4 = tVar.Z(Y4.f20568a);
                Iterator a5 = C2098b.a(strArr);
                while (a5.hasNext()) {
                    String str2 = (String) a5.next();
                    m.b(str2);
                    if (m3.m.o(str2, ".apk", false, 2, (Object) null)) {
                        ArrayList arrayList = this.f20593z;
                        m.b(arrayList);
                        a(str2, Z4, tVar, Y4, arrayList);
                    }
                }
                t tVar2 = tVar;
                if (!Z4.isEmpty()) {
                    Iterator it = Z4.iterator();
                    m.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        m.d(next, "next(...)");
                        tVar2.w((C2063v) next);
                    }
                }
            }
        }
    }

    public final void K(long j4) {
        this.f20590w = j4;
    }

    public final void L(String str) {
        this.f20584q = str;
    }

    public final void M(boolean z4) {
        this.f20567B = z4;
    }

    public final void N(int i4) {
        this.f20580m = i4;
    }

    public final void O(int i4) {
        this.f20583p = i4;
    }

    public final void P(boolean z4, boolean z5) {
        if (F()) {
            if (!z4) {
                this.f20583p = 1;
            } else {
                this.f20583p = 0;
            }
        }
        if (!H()) {
            return;
        }
        if (!z5) {
            this.f20583p = 1;
        } else {
            this.f20583p = 0;
        }
    }

    public final void Q(long j4) {
        this.f20585r = j4;
    }

    public final void R(int i4) {
        this.f20591x = i4;
    }

    public final void S(long j4) {
        this.f20568a = j4;
    }

    public final void T(long j4) {
        this.f20582o = j4;
    }

    public final void U(String str) {
        this.f20579l = str;
    }

    public final void V(String str) {
        this.f20569b = str;
    }

    public final void W(String str) {
        this.f20570c = str;
    }

    public final void X(C2038F f4) {
        this.f20588u = f4;
    }

    public final void Y(int i4) {
        this.f20587t = i4;
    }

    public final void Z(String str) {
        this.f20586s = str;
    }

    public final void a(String str, ArrayList arrayList, t tVar, C2048f fVar, ArrayList arrayList2) {
        String str2 = str;
        ArrayList<C2063v> arrayList3 = arrayList;
        t tVar2 = tVar;
        C2048f fVar2 = fVar;
        ArrayList arrayList4 = arrayList2;
        m.e(str2, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        m.e(arrayList3, "appFilesStored");
        m.e(tVar2, "dbManager");
        m.e(fVar2, "appStored");
        m.e(arrayList4, "out");
        C2063v vVar = new C2063v();
        vVar.g(new File(str2).length());
        vVar.e(str2);
        int i4 = -1;
        int i5 = 0;
        for (C2063v vVar2 : arrayList3) {
            int i6 = i5 + 1;
            if (m3.m.q(vVar2.a(), vVar.a(), false, 2, (Object) null) && vVar2.d() == vVar.d()) {
                if (vVar2.c() != null) {
                    vVar.f(vVar2.c());
                }
                i4 = i5;
            }
            i5 = i6;
        }
        if (i4 != -1) {
            arrayList3.remove(i4);
            arrayList4.add(vVar);
        } else if (tVar2.K0(fVar2.f20568a, vVar) >= 0) {
            arrayList4.add(vVar);
        }
    }

    public final void a0(boolean z4) {
        this.f20589v = z4;
    }

    public final long b() {
        return this.f20590w;
    }

    public final void b0(long j4) {
        this.f20581n = j4;
    }

    public final String c() {
        return this.f20584q;
    }

    public final void c0(c cVar) {
        m.e(cVar, "<set-?>");
        this.f20574g = cVar;
    }

    public final boolean d() {
        return this.f20567B;
    }

    public final void d0(int i4) {
        this.f20575h = i4;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f20580m;
    }

    public final void e0(int i4) {
        this.f20576i = i4;
    }

    public final int f() {
        return this.f20583p;
    }

    public final void f0(int i4) {
        this.f20592y = i4;
    }

    public final long g() {
        return this.f20585r;
    }

    public final void g0(String str) {
        this.f20573f = str;
    }

    public final int h() {
        return this.f20591x;
    }

    public final void h0(long j4) {
        this.f20571d = j4;
    }

    public final long i() {
        return this.f20568a;
    }

    public final void i0(String str) {
        this.f20572e = str;
    }

    public final long j() {
        return this.f20582o;
    }

    public final String k() {
        return this.f20579l;
    }

    public final int l() {
        return this.f20577j;
    }

    public final String m() {
        return this.f20569b;
    }

    public final ArrayList n() {
        return this.f20566A;
    }

    public final String o() {
        return this.f20570c;
    }

    public final C2038F p() {
        return this.f20588u;
    }

    public final int q() {
        return this.f20587t;
    }

    public final String r() {
        return this.f20586s;
    }

    public final boolean s() {
        return this.f20589v;
    }

    public final long t() {
        return this.f20581n;
    }

    public String toString() {
        return "{id='" + this.f20568a + "', name='" + this.f20569b + "', packagename='" + this.f20570c + "', versionCode=" + this.f20571d + ", versionName='" + this.f20572e + "', urlFicha='" + this.f20573f + "', status=" + this.f20574g + ", isSystemApp=" + this.f20575h + ", isSystemService=" + this.f20576i + ", minSdkVersion=" + this.f20577j + ", targetSdkVersion=" + this.f20578k + ", md5signature='" + this.f20579l + "', exclude=" + this.f20580m + ", size=" + this.f20581n + ", lastUpdateTime=" + this.f20582o + ", excludeFromTracking=" + this.f20583p + ", defaultName='" + this.f20584q + "', firstInstallTime=" + this.f20585r + ", sha256='" + this.f20586s + "', appID=" + this.f20590w + ", hasOldVersions=" + this.f20591x + ", trackInfoRegistered=" + this.f20592y + '}';
    }

    public final String u(Context context) {
        m.e(context, "context");
        return new i().d(this.f20581n, context);
    }

    public final ArrayList v() {
        return this.f20593z;
    }

    public final c w() {
        return this.f20574g;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20568a);
        parcel.writeString(this.f20569b);
        parcel.writeString(this.f20570c);
        parcel.writeLong(this.f20571d);
        parcel.writeString(this.f20572e);
        parcel.writeString(this.f20573f);
        int i5 = d.f20599a[this.f20574g.ordinal()];
        if (i5 == 1) {
            parcel.writeInt(0);
        } else if (i5 != 2) {
            parcel.writeInt(2);
        } else {
            parcel.writeInt(1);
        }
        parcel.writeInt(this.f20575h);
        parcel.writeInt(this.f20576i);
        parcel.writeInt(this.f20577j);
        parcel.writeInt(this.f20578k);
        parcel.writeString(this.f20579l);
        parcel.writeInt(this.f20580m);
        parcel.writeLong(this.f20581n);
        parcel.writeLong(this.f20582o);
        parcel.writeInt(this.f20583p);
        parcel.writeString(this.f20584q);
        parcel.writeLong(this.f20585r);
        parcel.writeString(this.f20586s);
        parcel.writeInt(this.f20587t);
        parcel.writeLong(this.f20590w);
        parcel.writeInt(this.f20591x);
        parcel.writeInt(this.f20567B ? 1 : 0);
    }

    public final int x() {
        return this.f20578k;
    }

    public final int y() {
        return this.f20592y;
    }

    public final String z() {
        return this.f20573f;
    }

    public C2048f(Parcel parcel) {
        m.e(parcel, "source");
        this.f20568a = -1;
        this.f20571d = -1;
        c cVar = c.UPDATED;
        this.f20574g = cVar;
        this.f20592y = -1;
        this.f20568a = parcel.readLong();
        this.f20569b = parcel.readString();
        this.f20570c = parcel.readString();
        this.f20571d = parcel.readLong();
        this.f20572e = parcel.readString();
        this.f20573f = parcel.readString();
        int readInt = parcel.readInt();
        boolean z4 = true;
        if (readInt == 0) {
            this.f20574g = c.OUTDATED;
        } else if (readInt != 1) {
            this.f20574g = c.UNAVAILABLE;
        } else {
            this.f20574g = cVar;
        }
        this.f20575h = parcel.readInt();
        this.f20576i = parcel.readInt();
        this.f20577j = parcel.readInt();
        this.f20578k = parcel.readInt();
        this.f20579l = parcel.readString();
        this.f20580m = parcel.readInt();
        this.f20581n = parcel.readLong();
        this.f20582o = parcel.readLong();
        this.f20583p = parcel.readInt();
        this.f20584q = parcel.readString();
        this.f20585r = parcel.readLong();
        this.f20586s = parcel.readString();
        this.f20587t = parcel.readInt();
        this.f20590w = parcel.readLong();
        this.f20591x = parcel.readInt();
        this.f20567B = parcel.readInt() != 1 ? false : z4;
    }
}
