package d2;

import S2.C1601o;
import W2.b;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.privacysandbox.ads.adservices.adid.a;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import f2.N;
import f2.O;
import g2.C2039G;
import g2.C2046d;
import g2.C2047e;
import g2.C2050h;
import g2.C2052j;
import g2.C2053k;
import g2.C2062u;
import g2.C2065x;
import g2.L;
import g2.N;
import g2.O;
import g2.Q;
import g2.X;
import g2.Z;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.C2103g;
import o3.C0977g;
import o3.C1001s0;
import o3.G;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import u2.E;

/* renamed from: d2.y1  reason: case insensitive filesystem */
public final class C1988y1 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public final r3.t f20151A;

    /* renamed from: B  reason: collision with root package name */
    private final I f20152B;

    /* renamed from: C  reason: collision with root package name */
    private final r3.t f20153C = K.a((Object) null);

    /* renamed from: D  reason: collision with root package name */
    private final r3.t f20154D = K.a((Object) null);

    /* renamed from: E  reason: collision with root package name */
    private final r3.t f20155E = K.a((Object) null);

    /* renamed from: F  reason: collision with root package name */
    private r3.t f20156F = K.a(0);

    /* renamed from: G  reason: collision with root package name */
    private r3.t f20157G = K.a(0);

    /* renamed from: H  reason: collision with root package name */
    private final r3.t f20158H = K.a(-1L);

    /* renamed from: I  reason: collision with root package name */
    private final r3.t f20159I = K.a("");

    /* renamed from: J  reason: collision with root package name */
    private final r3.t f20160J = K.a(-1);

    /* renamed from: K  reason: collision with root package name */
    private final r3.t f20161K;

    /* renamed from: L  reason: collision with root package name */
    private final r3.t f20162L;

    /* renamed from: M  reason: collision with root package name */
    private final r3.t f20163M;

    /* renamed from: N  reason: collision with root package name */
    private final r3.t f20164N;

    /* renamed from: O  reason: collision with root package name */
    private final r3.t f20165O;

    /* renamed from: P  reason: collision with root package name */
    private final r3.t f20166P;

    /* renamed from: Q  reason: collision with root package name */
    private final r3.t f20167Q;

    /* renamed from: R  reason: collision with root package name */
    private final r3.t f20168R;

    /* renamed from: S  reason: collision with root package name */
    private final r3.t f20169S;

    /* renamed from: T  reason: collision with root package name */
    private final r3.t f20170T;

    /* renamed from: U  reason: collision with root package name */
    private final r3.t f20171U;

    /* renamed from: V  reason: collision with root package name */
    private final r3.t f20172V;

    /* renamed from: W  reason: collision with root package name */
    private AtomicBoolean f20173W;

    /* renamed from: X  reason: collision with root package name */
    private final r3.t f20174X;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final r3.t f20175a;

    /* renamed from: b  reason: collision with root package name */
    private final I f20176b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final r3.t f20177c;

    /* renamed from: d  reason: collision with root package name */
    private final I f20178d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final r3.t f20179e;

    /* renamed from: f  reason: collision with root package name */
    private final I f20180f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final r3.t f20181g;

    /* renamed from: h  reason: collision with root package name */
    private final I f20182h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final r3.t f20183i;

    /* renamed from: j  reason: collision with root package name */
    private final I f20184j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final r3.t f20185k;

    /* renamed from: l  reason: collision with root package name */
    private final I f20186l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final r3.t f20187m;

    /* renamed from: n  reason: collision with root package name */
    private final I f20188n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final r3.t f20189o;

    /* renamed from: p  reason: collision with root package name */
    private final I f20190p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final r3.t f20191q;

    /* renamed from: r  reason: collision with root package name */
    private final I f20192r;

    /* renamed from: s  reason: collision with root package name */
    private final r3.t f20193s;

    /* renamed from: t  reason: collision with root package name */
    private final I f20194t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final r3.t f20195u;

    /* renamed from: v  reason: collision with root package name */
    private final I f20196v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final r3.t f20197w;

    /* renamed from: x  reason: collision with root package name */
    private final I f20198x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final r3.t f20199y;

    /* renamed from: z  reason: collision with root package name */
    private final I f20200z;

    /* renamed from: d2.y1$A */
    static final class A extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20201a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20202b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20203c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20204d;

        /* renamed from: d2.y1$A$a */
        public static final class a implements N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20205a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1988y1 f20206b;

            a(Context context, C1988y1 y1Var) {
                this.f20205a = context;
                this.f20206b = y1Var;
            }

            public void a() {
                this.f20206b.p0().setValue(0);
                this.f20206b.o0().setValue(Boolean.FALSE);
            }

            public void d() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "added");
                new u2.x(this.f20205a).d("wishlist", bundle);
                this.f20206b.p0().setValue(1);
                this.f20206b.o0().setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        A(C1988y1 y1Var, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20202b = y1Var;
            this.f20203c = context;
            this.f20204d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new A(this.f20202b, this.f20203c, this.f20204d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20201a == 0) {
                R2.n.b(obj);
                a aVar = new a(this.f20203c, this.f20202b);
                this.f20202b.o0().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                new b2.x(this.f20203c, ViewModelKt.getViewModelScope(this.f20202b)).e(this.f20204d, aVar);
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((A) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$B */
    static final class B extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20208b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20209c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20210d;

        /* renamed from: d2.y1$B$a */
        public static final class a implements O {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20211a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1988y1 f20212b;

            a(Context context, C1988y1 y1Var) {
                this.f20211a = context;
                this.f20212b = y1Var;
            }

            public void a() {
                this.f20212b.p0().setValue(1);
                this.f20212b.o0().setValue(Boolean.FALSE);
            }

            public void f() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "removed");
                new u2.x(this.f20211a).d("wishlist", bundle);
                this.f20212b.p0().setValue(0);
                this.f20212b.o0().setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        B(C1988y1 y1Var, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20208b = y1Var;
            this.f20209c = context;
            this.f20210d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new B(this.f20208b, this.f20209c, this.f20210d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20207a == 0) {
                R2.n.b(obj);
                a aVar = new a(this.f20209c, this.f20208b);
                this.f20208b.o0().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                new b2.x(this.f20209c, ViewModelKt.getViewModelScope(this.f20208b)).g(this.f20210d, aVar);
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((B) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$a  reason: case insensitive filesystem */
    public static final class C1989a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f20213a;

        /* renamed from: b  reason: collision with root package name */
        private final C2046d f20214b;

        public C1989a(ArrayList arrayList, C2046d dVar) {
            kotlin.jvm.internal.m.e(arrayList, "appFAQs");
            this.f20213a = arrayList;
            this.f20214b = dVar;
        }

        public final C2046d a() {
            return this.f20214b;
        }

        public final ArrayList b() {
            return this.f20213a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1989a)) {
                return false;
            }
            C1989a aVar = (C1989a) obj;
            if (kotlin.jvm.internal.m.a(this.f20213a, aVar.f20213a) && kotlin.jvm.internal.m.a(this.f20214b, aVar.f20214b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int hashCode = this.f20213a.hashCode() * 31;
            C2046d dVar = this.f20214b;
            if (dVar == null) {
                i4 = 0;
            } else {
                i4 = dVar.hashCode();
            }
            return hashCode + i4;
        }

        public String toString() {
            return "AppDetailsData(appFAQs=" + this.f20213a + ", appAffiliated=" + this.f20214b + ')';
        }
    }

    /* renamed from: d2.y1$b  reason: case insensitive filesystem */
    public static final class C1990b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f20215a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f20216b;

        public C1990b(ArrayList arrayList, ArrayList arrayList2) {
            kotlin.jvm.internal.m.e(arrayList, "appScreenshot");
            kotlin.jvm.internal.m.e(arrayList2, "appVideos");
            this.f20215a = arrayList;
            this.f20216b = arrayList2;
        }

        public final ArrayList a() {
            return this.f20215a;
        }

        public final ArrayList b() {
            return this.f20216b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1990b)) {
                return false;
            }
            C1990b bVar = (C1990b) obj;
            if (kotlin.jvm.internal.m.a(this.f20215a, bVar.f20215a) && kotlin.jvm.internal.m.a(this.f20216b, bVar.f20216b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f20215a.hashCode() * 31) + this.f20216b.hashCode();
        }

        public String toString() {
            return "AppMediaData(appScreenshot=" + this.f20215a + ", appVideos=" + this.f20216b + ')';
        }
    }

    /* renamed from: d2.y1$c */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f20217a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f20218b;

        public c(ArrayList arrayList, ArrayList arrayList2) {
            this.f20217a = arrayList;
            this.f20218b = arrayList2;
        }

        public final ArrayList a() {
            return this.f20218b;
        }

        public final ArrayList b() {
            return this.f20217a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (kotlin.jvm.internal.m.a(this.f20217a, cVar.f20217a) && kotlin.jvm.internal.m.a(this.f20218b, cVar.f20218b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            ArrayList arrayList = this.f20217a;
            int i5 = 0;
            if (arrayList == null) {
                i4 = 0;
            } else {
                i4 = arrayList.hashCode();
            }
            int i6 = i4 * 31;
            ArrayList arrayList2 = this.f20218b;
            if (arrayList2 != null) {
                i5 = arrayList2.hashCode();
            }
            return i6 + i5;
        }

        public String toString() {
            return "AppRelatedCategoriesData(appTopByCategories=" + this.f20217a + ", appCategories=" + this.f20218b + ')';
        }
    }

    /* renamed from: d2.y1$d */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f20219a;

        /* renamed from: b  reason: collision with root package name */
        private final g2.N f20220b;

        public d(ArrayList arrayList, g2.N n4) {
            kotlin.jvm.internal.m.e(arrayList, "appReviews");
            this.f20219a = arrayList;
            this.f20220b = n4;
        }

        public final g2.N a() {
            return this.f20220b;
        }

        public final ArrayList b() {
            return this.f20219a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (kotlin.jvm.internal.m.a(this.f20219a, dVar.f20219a) && kotlin.jvm.internal.m.a(this.f20220b, dVar.f20220b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int hashCode = this.f20219a.hashCode() * 31;
            g2.N n4 = this.f20220b;
            if (n4 == null) {
                i4 = 0;
            } else {
                i4 = n4.hashCode();
            }
            return hashCode + i4;
        }

        public String toString() {
            return "AppReviewsData(appReviews=" + this.f20219a + ", appMyReview=" + this.f20220b + ')';
        }
    }

    /* renamed from: d2.y1$e */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f20221a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20222b;

        public e(boolean z4, boolean z5) {
            this.f20221a = z4;
            this.f20222b = z5;
        }

        public final boolean a() {
            return this.f20221a;
        }

        public final boolean b() {
            return this.f20222b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f20221a == eVar.f20221a && this.f20222b == eVar.f20222b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (a.a(this.f20221a) * 31) + a.a(this.f20222b);
        }

        public String toString() {
            return "PreRegisterActionData(succeed=" + this.f20221a + ", isAddPreRegisterAction=" + this.f20222b + ')';
        }
    }

    /* renamed from: d2.y1$f */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final String f20223a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20224b;

        public f(String str, boolean z4) {
            this.f20223a = str;
            this.f20224b = z4;
        }

        public final String a() {
            return this.f20223a;
        }

        public final boolean b() {
            return this.f20224b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (kotlin.jvm.internal.m.a(this.f20223a, fVar.f20223a) && this.f20224b == fVar.f20224b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            String str = this.f20223a;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            return (i4 * 31) + a.a(this.f20224b);
        }

        public String toString() {
            return "PreRegisterStatusData(buttonText=" + this.f20223a + ", isPreRegister=" + this.f20224b + ')';
        }
    }

    /* renamed from: d2.y1$g */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f20225a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20226b;

        public g(boolean z4, int i4) {
            this.f20225a = z4;
            this.f20226b = i4;
        }

        public final int a() {
            return this.f20226b;
        }

        public final boolean b() {
            return this.f20225a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (this.f20225a == gVar.f20225a && this.f20226b == gVar.f20226b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (a.a(this.f20225a) * 31) + this.f20226b;
        }

        public String toString() {
            return "SendReviewActionData(succeed=" + this.f20225a + ", statusCode=" + this.f20226b + ')';
        }
    }

    /* renamed from: d2.y1$h */
    static final class h extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20227a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20228b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20229c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f20230d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f20231e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f20232f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f20233g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Context f20234h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(C1988y1 y1Var, long j4, String str, String str2, boolean z4, long j5, Context context, V2.d dVar) {
            super(2, dVar);
            this.f20228b = y1Var;
            this.f20229c = j4;
            this.f20230d = str;
            this.f20231e = str2;
            this.f20232f = z4;
            this.f20233g = j5;
            this.f20234h = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f20228b, this.f20229c, this.f20230d, this.f20231e, this.f20232f, this.f20233g, this.f20234h, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20227a == 0) {
                R2.n.b(obj);
                this.f20228b.f20189o.setValue(E.a.f21883a);
                C2039G g4 = new C2039G(this.f20229c, this.f20230d, this.f20231e, this.f20232f, this.f20233g);
                L a5 = new u2.L(this.f20234h).a(this.f20229c);
                if (!a5.b() && a5.e() != null) {
                    JSONObject e5 = a5.e();
                    kotlin.jvm.internal.m.b(e5);
                    if (e5.optInt("success") == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "added");
                        new u2.x(this.f20234h).d("preregister", bundle);
                        g4.i(this.f20234h);
                        this.f20228b.f20189o.setValue(new E.c(new e(true, true)));
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$i */
    static final class i extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20236b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20237c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20238d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(C1988y1 y1Var, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20236b = y1Var;
            this.f20237c = context;
            this.f20238d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new i(this.f20236b, this.f20237c, this.f20238d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20235a == 0) {
                R2.n.b(obj);
                this.f20236b.f20189o.setValue(E.a.f21883a);
                L e5 = new u2.L(this.f20237c).e(this.f20238d);
                if (!e5.b() && e5.e() != null) {
                    JSONObject e6 = e5.e();
                    kotlin.jvm.internal.m.b(e6);
                    if (e6.optInt("success") == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "removed");
                        new u2.x(this.f20237c).d("preregister", bundle);
                        C2039G g4 = new C2039G();
                        g4.k(this.f20238d);
                        g4.j(this.f20237c);
                        this.f20236b.f20189o.setValue(new E.c(new e(true, false)));
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((i) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$j */
    static final class j extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20239a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20240b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20241c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20242d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(Context context, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20240b = context;
            this.f20241c = j4;
            this.f20242d = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f20240b, this.f20241c, this.f20242d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20239a == 0) {
                R2.n.b(obj);
                L i4 = new u2.L(this.f20240b).i(this.f20241c);
                boolean z4 = false;
                String str = null;
                if (!i4.b() && i4.e() != null) {
                    JSONObject e5 = i4.e();
                    kotlin.jvm.internal.m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        if (!optJSONObject.isNull("message")) {
                            str = optJSONObject.optString("message");
                        }
                        if (!optJSONObject.isNull("preRegistered") && optJSONObject.optInt("preRegistered") != 0) {
                            z4 = true;
                        }
                    }
                }
                this.f20242d.f20191q.setValue(new E.c(new f(str, z4)));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$k */
    static final class k extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        Object f20243a;

        /* renamed from: b  reason: collision with root package name */
        Object f20244b;

        /* renamed from: c  reason: collision with root package name */
        long f20245c;

        /* renamed from: d  reason: collision with root package name */
        int f20246d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f20247e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2050h f20248f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20249g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Context context, C2050h hVar, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20247e = context;
            this.f20248f = hVar;
            this.f20249g = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(this.f20247e, this.f20248f, this.f20249g, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            r3.t tVar;
            long j4;
            u2.L l4;
            boolean z4;
            Object c5 = b.c();
            int i4 = this.f20246d;
            if (i4 == 0) {
                R2.n.b(obj);
                l4 = new u2.L(this.f20247e);
                long e5 = this.f20248f.e();
                if (this.f20248f.A() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.f20249g.z0(K.a(kotlin.coroutines.jvm.internal.b.b(this.f20248f.A0())));
                this.f20249g.y0(K.a(kotlin.coroutines.jvm.internal.b.b(this.f20248f.d0())));
                this.f20249g.G(l4, e5);
                this.f20249g.g0(l4, e5, z4);
                this.f20249g.E(l4, e5);
                this.f20249g.K(l4, e5, this.f20247e);
                this.f20249g.K(l4, e5, this.f20247e);
                if (this.f20248f.E0()) {
                    this.f20249g.k0(l4, e5);
                }
                C1988y1 y1Var = this.f20249g;
                this.f20243a = l4;
                this.f20245c = e5;
                this.f20246d = 1;
                obj = y1Var.D(l4, e5, this);
                if (obj != c5) {
                    j4 = e5;
                }
                return c5;
            } else if (i4 == 1) {
                j4 = this.f20245c;
                l4 = (u2.L) this.f20243a;
                R2.n.b(obj);
            } else if (i4 == 2) {
                tVar = (r3.t) this.f20244b;
                arrayList = (ArrayList) this.f20243a;
                R2.n.b(obj);
                tVar.setValue(obj);
                this.f20249g.f20175a.setValue(new E.c(new C1989a(arrayList, (C2046d) this.f20249g.y().getValue())));
                return R2.s.f8222a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ArrayList arrayList2 = (ArrayList) obj;
            r3.t y4 = this.f20249g.y();
            C1988y1 y1Var2 = this.f20249g;
            this.f20243a = arrayList2;
            this.f20244b = y4;
            this.f20246d = 2;
            Object a5 = y1Var2.C(l4, j4, this);
            if (a5 != c5) {
                Object obj2 = a5;
                arrayList = arrayList2;
                obj = obj2;
                tVar = y4;
                tVar.setValue(obj);
                this.f20249g.f20175a.setValue(new E.c(new C1989a(arrayList, (C2046d) this.f20249g.y().getValue())));
                return R2.s.f8222a;
            }
            return c5;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((k) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$l */
    static final class l extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u2.L f20251b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20252c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(u2.L l4, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20251b = l4;
            this.f20252c = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new l(this.f20251b, this.f20252c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20250a == 0) {
                R2.n.b(obj);
                L k4 = this.f20251b.k(this.f20252c);
                if (k4.b() || k4.e() == null) {
                    return null;
                }
                JSONObject e5 = k4.e();
                kotlin.jvm.internal.m.b(e5);
                JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                if (optJSONObject != null) {
                    return C2046d.f20554h.a(optJSONObject);
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((l) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$m */
    static final class m extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u2.L f20254b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20255c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(u2.L l4, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20254b = l4;
            this.f20255c = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new m(this.f20254b, this.f20255c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20253a == 0) {
                R2.n.b(obj);
                ArrayList arrayList = new ArrayList();
                L v4 = this.f20254b.v(this.f20255c);
                if (!v4.b() && v4.e() != null) {
                    C2062u.b bVar = C2062u.f20772c;
                    JSONObject e5 = v4.e();
                    kotlin.jvm.internal.m.b(e5);
                    arrayList.addAll(bVar.a(e5));
                }
                return arrayList;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((m) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$n */
    static final class n extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u2.L f20257b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20258c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20259d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(u2.L l4, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20257b = l4;
            this.f20258c = j4;
            this.f20259d = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new n(this.f20257b, this.f20258c, this.f20259d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20256a == 0) {
                R2.n.b(obj);
                ArrayList arrayList = new ArrayList();
                L y4 = this.f20257b.y(this.f20258c);
                ArrayList arrayList2 = null;
                if (!y4.b() && y4.e() != null) {
                    JSONObject e5 = y4.e();
                    kotlin.jvm.internal.m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        if (optJSONArray.length() <= 2) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                Q q4 = new Q((C2053k) null, (ArrayList) null, 0, 7, (C2103g) null);
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                                if (optJSONObject2 != null) {
                                    C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                                    kVar.m(optJSONObject2);
                                    kVar.q(true);
                                    q4.e(kVar);
                                }
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray("apps");
                                if (optJSONArray2 != null) {
                                    int length2 = optJSONArray2.length();
                                    for (int i5 = 0; i5 < length2; i5++) {
                                        C2050h hVar = new C2050h();
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                        kotlin.jvm.internal.m.d(optJSONObject3, "optJSONObject(...)");
                                        C2050h.b(hVar, optJSONObject3, (Context) null, 2, (Object) null);
                                        q4.a().add(hVar);
                                    }
                                }
                                arrayList.add(q4);
                            }
                        } else {
                            int length3 = optJSONArray.length();
                            for (int i6 = 0; i6 < length3; i6++) {
                                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i6);
                                C2053k kVar2 = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                                kVar2.q(true);
                                kotlin.jvm.internal.m.b(optJSONObject4);
                                kVar2.m(optJSONObject4);
                                arrayList.add(kVar2);
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    Object H4 = C1601o.H(arrayList);
                    if (H4 instanceof C2053k) {
                        arrayList2 = arrayList;
                        arrayList = null;
                    } else if (!(H4 instanceof Q)) {
                        arrayList = null;
                    }
                    this.f20259d.f20185k.setValue(new E.c(new c(arrayList, arrayList2)));
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((n) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$o */
    static final class o extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u2.L f20261b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20262c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20263d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(u2.L l4, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20261b = l4;
            this.f20262c = j4;
            this.f20263d = y1Var;
        }

        /* access modifiers changed from: private */
        public static final int k(g2.O o4, g2.O o5) {
            return o4.b() - o5.b();
        }

        /* access modifiers changed from: private */
        public static final int l(d3.p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new o(this.f20261b, this.f20262c, this.f20263d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            JSONArray optJSONArray;
            JSONObject optJSONObject;
            JSONArray optJSONArray2;
            b.c();
            if (this.f20260a == 0) {
                R2.n.b(obj);
                ArrayList arrayList = new ArrayList();
                L z02 = this.f20261b.z0(this.f20262c);
                if (!z02.b() && z02.e() != null) {
                    JSONObject e5 = z02.e();
                    kotlin.jvm.internal.m.b(e5);
                    if (!(e5.optInt("success") != 1 || (optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) == null || (optJSONArray2 = optJSONObject.optJSONArray("videos")) == null)) {
                        int length = optJSONArray2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                            Z.b bVar = Z.f20518c;
                            kotlin.jvm.internal.m.b(optJSONObject2);
                            arrayList.add(bVar.a(optJSONObject2));
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                L e02 = this.f20261b.e0(this.f20262c);
                if (!(e02.b() || (d5 = e02.d()) == null || d5.length() == 0)) {
                    String d6 = e02.d();
                    kotlin.jvm.internal.m.b(d6);
                    JSONObject jSONObject = new JSONObject(d6);
                    if (jSONObject.optInt("success") == 1 && (optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        int length2 = optJSONArray.length();
                        for (int i5 = 0; i5 < length2; i5++) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i5);
                            O.b bVar2 = g2.O.f20438e;
                            kotlin.jvm.internal.m.b(optJSONObject3);
                            g2.O a5 = bVar2.a(optJSONObject3);
                            if (a5.a() == 0) {
                                arrayList2.add(a5);
                            }
                            C1601o.t(arrayList2, new A1(new C1993z1()));
                        }
                    }
                }
                this.f20263d.f20183i.setValue(new E.c(new C1990b(arrayList2, arrayList)));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((o) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$p */
    static final class p extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20264a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20265b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u2.L f20266c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20267d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20268e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(Context context, u2.L l4, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20265b = context;
            this.f20266c = l4;
            this.f20267d = j4;
            this.f20268e = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new p(this.f20265b, this.f20266c, this.f20267d, this.f20268e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            JSONObject optJSONObject;
            b.c();
            if (this.f20264a == 0) {
                R2.n.b(obj);
                ArrayList arrayList = new ArrayList();
                if (m3.m.p(this.f20265b.getString(R.string.screen_type), "phone", true)) {
                    i4 = 5;
                } else {
                    i4 = 6;
                }
                L d02 = this.f20266c.d0(this.f20267d, i4, 0);
                if (!d02.b() && d02.e() != null) {
                    JSONObject e5 = d02.e();
                    kotlin.jvm.internal.m.b(e5);
                    int optInt = e5.optInt("success");
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optInt == 1 && optJSONArray != null) {
                        arrayList.addAll(g2.N.f20413o.e(optJSONArray));
                    }
                }
                L J4 = this.f20266c.J(this.f20267d);
                g2.N n4 = null;
                if (!J4.b() && J4.e() != null) {
                    JSONObject e6 = J4.e();
                    kotlin.jvm.internal.m.b(e6);
                    if (e6.optInt("success") == 1 && (optJSONObject = e6.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        n4 = new g2.N();
                        g2.N.f20413o.d(n4, optJSONObject);
                    }
                } else if (J4.b()) {
                    int f4 = J4.f();
                }
                this.f20268e.f20197w.setValue(n4);
                this.f20268e.f20187m.setValue(new E.c(new d(arrayList, n4)));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((p) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$q */
    static final class q extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20269a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20270b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20271c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20272d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(Context context, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20270b = context;
            this.f20271c = j4;
            this.f20272d = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new q(this.f20270b, this.f20271c, this.f20272d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20269a == 0) {
                R2.n.b(obj);
                ArrayList arrayList = new ArrayList();
                L V4 = new u2.L(this.f20270b).V(this.f20271c);
                if (!V4.b() && V4.e() != null) {
                    JSONObject e5 = V4.e();
                    kotlin.jvm.internal.m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            C2050h hVar = new C2050h();
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            kotlin.jvm.internal.m.d(optJSONObject, "optJSONObject(...)");
                            C2050h.b(hVar, optJSONObject, (Context) null, 2, (Object) null);
                            arrayList.add(hVar);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        this.f20272d.f20181g.setValue(arrayList);
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((q) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$r */
    static final class r extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20273a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f20274b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u2.L f20275c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20276d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20277e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(boolean z4, u2.L l4, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20274b = z4;
            this.f20275c = l4;
            this.f20276d = j4;
            this.f20277e = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new r(this.f20274b, this.f20275c, this.f20276d, this.f20277e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONObject optJSONObject;
            b.c();
            if (this.f20273a == 0) {
                R2.n.b(obj);
                if (this.f20274b) {
                    C2047e eVar = new C2047e();
                    L c5 = this.f20275c.c(this.f20276d);
                    if (!c5.b() && c5.e() != null) {
                        JSONObject e5 = c5.e();
                        kotlin.jvm.internal.m.b(e5);
                        if (e5.optInt("success") == 1 && (optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                            eVar.d(optJSONObject);
                            ArrayList a5 = eVar.a();
                            if (a5 != null && !a5.isEmpty()) {
                                this.f20277e.f20179e.setValue(eVar);
                            }
                        }
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    L h12 = this.f20275c.h1(this.f20276d, 20, 0);
                    if (!h12.b() && h12.e() != null) {
                        JSONObject e6 = h12.e();
                        kotlin.jvm.internal.m.b(e6);
                        JSONArray optJSONArray = e6.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (e6.optInt("success", 0) == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                C2050h hVar = new C2050h();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                kotlin.jvm.internal.m.b(optJSONObject2);
                                C2050h.b(hVar, optJSONObject2, (Context) null, 2, (Object) null);
                                arrayList.add(hVar);
                            }
                            if (!arrayList.isEmpty()) {
                                this.f20277e.f20177c.setValue(arrayList);
                            }
                        }
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((r) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$s */
    static final class s extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20278a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20279b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u2.L f20280c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20281d;

        /* renamed from: d2.y1$s$a */
        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Integer.valueOf(((X) obj2).d()), Integer.valueOf(((X) obj).d()));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(C1988y1 y1Var, u2.L l4, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20279b = y1Var;
            this.f20280c = l4;
            this.f20281d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new s(this.f20279b, this.f20280c, this.f20281d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20278a == 0) {
                R2.n.b(obj);
                this.f20279b.f20151A.setValue(E.a.f21883a);
                L Z4 = this.f20280c.Z(this.f20281d);
                ArrayList arrayList = new ArrayList();
                if (Z4.b() || Z4.e() == null) {
                    arrayList = new ArrayList();
                } else {
                    JSONObject e5 = Z4.e();
                    kotlin.jvm.internal.m.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        arrayList = X.f20507g.b(optJSONArray);
                    }
                }
                if (arrayList.size() > 1) {
                    this.f20279b.f0().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                    if (arrayList.size() > 1) {
                        C1601o.t(arrayList, new a());
                    }
                    this.f20279b.f20151A.setValue(new E.c(arrayList));
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((s) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$t */
    static final class t extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20283b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20284c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20285d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(Context context, C1988y1 y1Var, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20283b = context;
            this.f20284c = y1Var;
            this.f20285d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new t(this.f20283b, this.f20284c, this.f20285d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20282a == 0) {
                R2.n.b(obj);
                u2.L l4 = new u2.L(this.f20283b);
                if (this.f20284c.S().getValue() != null) {
                    l4.E0(this.f20285d);
                } else {
                    l4.D0(this.f20285d);
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((t) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$u */
    static final class u extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20286a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20287b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g2.N f20288c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f20289d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(C1988y1 y1Var, g2.N n4, Context context, V2.d dVar) {
            super(2, dVar);
            this.f20287b = y1Var;
            this.f20288c = n4;
            this.f20289d = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new u(this.f20287b, this.f20288c, this.f20289d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20286a;
            if (i4 == 0) {
                R2.n.b(obj);
                this.f20287b.f20199y.setValue(kotlin.coroutines.jvm.internal.b.b(-1));
                N.b bVar = g2.N.f20413o;
                g2.N n4 = this.f20288c;
                Context context = this.f20289d;
                this.f20286a = 1;
                obj = bVar.c(n4, context, this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                R2.n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f20287b.f20199y.setValue(kotlin.coroutines.jvm.internal.b.b(((Number) obj).intValue()));
            return R2.s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((u) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$v */
    static final class v extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20292c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20293d;

        /* renamed from: d2.y1$v$a */
        public static final class a implements f2.N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20294a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1988y1 f20295b;

            a(Context context, C1988y1 y1Var) {
                this.f20294a = context;
                this.f20295b = y1Var;
            }

            public void a() {
                this.f20295b.Y().setValue(0);
                this.f20295b.o0().setValue(Boolean.FALSE);
            }

            public void d() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "added");
                new u2.x(this.f20294a).d("recommended", bundle);
                this.f20295b.Y().setValue(1);
                this.f20295b.o0().setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(C1988y1 y1Var, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20291b = y1Var;
            this.f20292c = context;
            this.f20293d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new v(this.f20291b, this.f20292c, this.f20293d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20290a == 0) {
                R2.n.b(obj);
                a aVar = new a(this.f20292c, this.f20291b);
                this.f20291b.o0().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                new b2.s(this.f20292c, ViewModelKt.getViewModelScope(this.f20291b)).b(this.f20293d, aVar);
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((v) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$w */
    static final class w extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20296a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20297b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20298c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f20299d;

        /* renamed from: d2.y1$w$a */
        public static final class a implements f2.O {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20300a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1988y1 f20301b;

            a(Context context, C1988y1 y1Var) {
                this.f20300a = context;
                this.f20301b = y1Var;
            }

            public void a() {
                this.f20301b.Y().setValue(1);
                this.f20301b.o0().setValue(Boolean.FALSE);
            }

            public void f() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "removed");
                new u2.x(this.f20300a).d("recommended", bundle);
                this.f20301b.Y().setValue(0);
                this.f20301b.o0().setValue(Boolean.FALSE);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(C1988y1 y1Var, Context context, long j4, V2.d dVar) {
            super(2, dVar);
            this.f20297b = y1Var;
            this.f20298c = context;
            this.f20299d = j4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new w(this.f20297b, this.f20298c, this.f20299d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20296a == 0) {
                R2.n.b(obj);
                a aVar = new a(this.f20298c, this.f20297b);
                this.f20297b.o0().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                new b2.s(this.f20298c, ViewModelKt.getViewModelScope(this.f20297b)).c(this.f20299d, aVar);
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((w) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$x */
    static final class x extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20302a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20303b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20304c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ X f20305d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f20306e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20307f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(Context context, long j4, X x4, ArrayList arrayList, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20303b = context;
            this.f20304c = j4;
            this.f20305d = x4;
            this.f20306e = arrayList;
            this.f20307f = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new x(this.f20303b, this.f20304c, this.f20305d, this.f20306e, this.f20307f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20302a == 0) {
                R2.n.b(obj);
                u2.L l4 = new u2.L(this.f20303b);
                long j4 = this.f20304c;
                long a5 = this.f20305d.a();
                ArrayList arrayList = this.f20306e;
                ArrayList arrayList2 = new ArrayList(C1601o.p(arrayList, 10));
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList.get(i4);
                    i4++;
                    arrayList2.add(kotlin.coroutines.jvm.internal.b.c(((X) obj2).a()));
                }
                L V02 = l4.V0(j4, a5, arrayList2);
                if (!V02.b() && V02.e() != null) {
                    JSONObject e5 = V02.e();
                    kotlin.jvm.internal.m.b(e5);
                    if (e5.optInt("success") == 1) {
                        this.f20307f.k0(l4, this.f20304c);
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((x) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$y */
    static final class y extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20308a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20309b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f20310c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f20311d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f20312e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C1988y1 f20313f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(Context context, String str, int i4, long j4, C1988y1 y1Var, V2.d dVar) {
            super(2, dVar);
            this.f20309b = context;
            this.f20310c = str;
            this.f20311d = i4;
            this.f20312e = j4;
            this.f20313f = y1Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new y(this.f20309b, this.f20310c, this.f20311d, this.f20312e, this.f20313f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i4;
            b.c();
            if (this.f20308a == 0) {
                R2.n.b(obj);
                N.b bVar = g2.N.f20413o;
                boolean z4 = false;
                if (!bVar.b(this.f20309b, this.f20310c)) {
                    bVar.f(this.f20309b, this.f20310c, String.valueOf(System.currentTimeMillis()));
                    u2.L l4 = new u2.L(this.f20309b);
                    g2.N n4 = new g2.N();
                    n4.x(this.f20310c);
                    n4.w(this.f20311d);
                    L T02 = l4.T0(this.f20312e, n4);
                    i4 = T02.f();
                    if (!T02.b() && T02.e() != null) {
                        JSONObject e5 = T02.e();
                        kotlin.jvm.internal.m.b(e5);
                        if (e5.optInt("success") == 1) {
                            z4 = true;
                        }
                    }
                } else {
                    i4 = 0;
                }
                this.f20313f.f20195u.setValue(new E.c(new g(z4, i4)));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((y) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    /* renamed from: d2.y1$z */
    static final class z extends kotlin.coroutines.jvm.internal.l implements d3.p {

        /* renamed from: a  reason: collision with root package name */
        int f20314a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f20315b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f20316c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f20317d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(Context context, long j4, boolean z4, V2.d dVar) {
            super(2, dVar);
            this.f20315b = context;
            this.f20316c = j4;
            this.f20317d = z4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new z(this.f20315b, this.f20316c, this.f20317d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20314a == 0) {
                R2.n.b(obj);
                u2.t a5 = u2.t.f21927u.a(this.f20315b);
                a5.a();
                if (a5.v0(this.f20316c) != null) {
                    if (this.f20317d) {
                        a5.z1(this.f20316c, 1);
                    } else {
                        a5.z1(this.f20316c, 0);
                    }
                }
                a5.i();
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((z) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public C1988y1() {
        E.a aVar = E.a.f21883a;
        r3.t a5 = K.a(aVar);
        this.f20175a = a5;
        this.f20176b = a5;
        r3.t a6 = K.a(new ArrayList());
        this.f20177c = a6;
        this.f20178d = a6;
        r3.t a7 = K.a(new C2047e());
        this.f20179e = a7;
        this.f20180f = a7;
        r3.t a8 = K.a(new ArrayList());
        this.f20181g = a8;
        this.f20182h = a8;
        r3.t a9 = K.a(aVar);
        this.f20183i = a9;
        this.f20184j = a9;
        r3.t a10 = K.a(aVar);
        this.f20185k = a10;
        this.f20186l = a10;
        r3.t a11 = K.a(aVar);
        this.f20187m = a11;
        this.f20188n = a11;
        r3.t a12 = K.a(aVar);
        this.f20189o = a12;
        this.f20190p = a12;
        r3.t a13 = K.a(aVar);
        this.f20191q = a13;
        this.f20192r = a13;
        r3.t a14 = K.a(new ArrayList());
        this.f20193s = a14;
        this.f20194t = a14;
        r3.t a15 = K.a(aVar);
        this.f20195u = a15;
        this.f20196v = a15;
        r3.t a16 = K.a((Object) null);
        this.f20197w = a16;
        this.f20198x = a16;
        r3.t a17 = K.a(-1);
        this.f20199y = a17;
        this.f20200z = a17;
        r3.t a18 = K.a(aVar);
        this.f20151A = a18;
        this.f20152B = a18;
        Boolean bool = Boolean.FALSE;
        this.f20161K = K.a(bool);
        this.f20162L = K.a(bool);
        this.f20163M = K.a(bool);
        Boolean bool2 = Boolean.TRUE;
        this.f20164N = K.a(bool2);
        this.f20165O = K.a(bool);
        this.f20166P = K.a(bool);
        this.f20167Q = K.a(bool2);
        this.f20168R = K.a(0);
        this.f20169S = K.a(0);
        this.f20170T = K.a(-1);
        this.f20171U = K.a(bool);
        this.f20172V = K.a(bool);
        this.f20173W = new AtomicBoolean(false);
        this.f20174X = K.a(bool);
    }

    /* access modifiers changed from: private */
    public final Object C(u2.L l4, long j4, V2.d dVar) {
        return C0977g.g(Y.b(), new l(l4, j4, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final Object D(u2.L l4, long j4, V2.d dVar) {
        return C0977g.g(Y.b(), new m(l4, j4, (V2.d) null), dVar);
    }

    /* access modifiers changed from: private */
    public final void E(u2.L l4, long j4) {
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new n(l4, j4, this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void G(u2.L l4, long j4) {
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new o(l4, j4, this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void K(u2.L l4, long j4, Context context) {
        Context context2 = context;
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new p(context2, l4, j4, this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void g0(u2.L l4, long j4, boolean z4) {
        boolean z5 = z4;
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new r(z5, l4, j4, this, (V2.d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void k0(u2.L l4, long j4) {
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new s(this, l4, j4, (V2.d) null), 2, (Object) null);
    }

    public final I A() {
        return this.f20180f;
    }

    public final void A0(Context context, long j4, boolean z4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new z(context, j4, z4, (V2.d) null), 2, (Object) null);
    }

    public final AtomicBoolean B() {
        return this.f20173W;
    }

    public final void B0(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new A(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final void C0(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new B(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final r3.t F() {
        return this.f20158H;
    }

    public final I H() {
        return this.f20184j;
    }

    public final r3.t I() {
        return this.f20167Q;
    }

    public final I J() {
        return this.f20186l;
    }

    public final I L() {
        return this.f20188n;
    }

    public final r3.t M() {
        return this.f20163M;
    }

    public final r3.t N() {
        return this.f20161K;
    }

    public final I O() {
        return this.f20176b;
    }

    public final r3.t P() {
        return this.f20162L;
    }

    public final r3.t Q() {
        return this.f20164N;
    }

    public final r3.t R() {
        return this.f20160J;
    }

    public final r3.t S() {
        return this.f20154D;
    }

    public final I T() {
        return this.f20198x;
    }

    public final I U() {
        return this.f20190p;
    }

    public final I V() {
        return this.f20192r;
    }

    public final void W(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new q(context, j4, this, (V2.d) null), 2, (Object) null);
    }

    public final I X() {
        return this.f20182h;
    }

    public final r3.t Y() {
        return this.f20157G;
    }

    public final I Z() {
        return this.f20200z;
    }

    public final r3.t a0() {
        return this.f20170T;
    }

    public final I b0() {
        return this.f20194t;
    }

    public final r3.t c0() {
        return this.f20159I;
    }

    public final r3.t d0() {
        return this.f20169S;
    }

    public final I e0() {
        return this.f20196v;
    }

    public final r3.t f0() {
        return this.f20172V;
    }

    public final I h0() {
        return this.f20178d;
    }

    public final r3.t i0() {
        return this.f20166P;
    }

    public final r3.t j0() {
        return this.f20155E;
    }

    public final I l0() {
        return this.f20152B;
    }

    public final r3.t m0() {
        return this.f20171U;
    }

    public final r3.t n0() {
        return this.f20168R;
    }

    public final r3.t o0() {
        return this.f20174X;
    }

    public final r3.t p0() {
        return this.f20156F;
    }

    public final void q0(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new t(context, this, j4, (V2.d) null), 2, (Object) null);
    }

    public final boolean r0(Context context) {
        kotlin.jvm.internal.m.e(context, "context");
        return C2052j.f20686n.b(context, ((Number) this.f20158H.getValue()).longValue());
    }

    public final boolean s0(Context context) {
        kotlin.jvm.internal.m.e(context, "context");
        return C2065x.f20781n.b(context, ((Number) this.f20158H.getValue()).longValue());
    }

    public final void t0(Context context, g2.N n4) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(n4, "review");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new u(this, n4, context, (V2.d) null), 2, (Object) null);
    }

    public final void u(Context context, long j4, String str, String str2, long j5, boolean z4) {
        kotlin.jvm.internal.m.e(context, "context");
        String str3 = str;
        kotlin.jvm.internal.m.e(str3, "appName");
        J viewModelScope = ViewModelKt.getViewModelScope(this);
        boolean z5 = z4;
        G b5 = Y.b();
        C1001s0 unused = C0981i.d(viewModelScope, b5, (o3.L) null, new h(this, j4, str3, str2, z5, j5, context, (V2.d) null), 2, (Object) null);
    }

    public final void u0(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new v(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final void v(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new i(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final void v0(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new w(this, context, j4, (V2.d) null), 2, (Object) null);
    }

    public final void w(Context context, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new j(context, j4, this, (V2.d) null), 2, (Object) null);
    }

    public final void w0(Context context, long j4, X x4, ArrayList arrayList) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(x4, "currentDevice");
        kotlin.jvm.internal.m.e(arrayList, "devicesSelected");
        J viewModelScope = ViewModelKt.getViewModelScope(this);
        J j5 = viewModelScope;
        C1001s0 unused = C0981i.d(j5, Y.b(), (o3.L) null, new x(context, j4, x4, arrayList, this, (V2.d) null), 2, (Object) null);
    }

    public final void x(Context context, C2050h hVar) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(hVar, "appInfo");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new k(context, hVar, this, (V2.d) null), 2, (Object) null);
    }

    public final void x0(Context context, String str, int i4, long j4) {
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(str, "reviewText");
        J viewModelScope = ViewModelKt.getViewModelScope(this);
        J j5 = viewModelScope;
        C1001s0 unused = C0981i.d(j5, Y.b(), (o3.L) null, new y(context, str, i4, j4, this, (V2.d) null), 2, (Object) null);
    }

    public final r3.t y() {
        return this.f20153C;
    }

    public final void y0(r3.t tVar) {
        kotlin.jvm.internal.m.e(tVar, "<set-?>");
        this.f20157G = tVar;
    }

    public final r3.t z() {
        return this.f20165O;
    }

    public final void z0(r3.t tVar) {
        kotlin.jvm.internal.m.e(tVar, "<set-?>");
        this.f20156F = tVar;
    }
}
