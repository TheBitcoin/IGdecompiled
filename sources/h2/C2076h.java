package h2;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import W1.C1605a;
import W1.C1606b;
import android.app.Activity;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.ResultReceiver;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2098b;
import kotlin.jvm.internal.m;
import o3.J;

/* renamed from: h2.h  reason: case insensitive filesystem */
public final class C2076h extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f20852a;

    /* renamed from: h2.h$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20853a;

        a(d dVar) {
            super(2, dVar);
        }

        public final d create(Object obj, d dVar) {
            return new a(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f20853a == 0) {
                n.b(obj);
                Activity g4 = k.f7778g.g();
                if (g4 != null) {
                    if (g4 instanceof Updates) {
                        ((Updates) g4).F5();
                    } else if (g4 instanceof MyDownloads) {
                        ((MyDownloads) g4).v4();
                    } else if (g4 instanceof MyApps) {
                        ((MyApps) g4).l5();
                    } else if (g4 instanceof WishlistActivity) {
                        ((WishlistActivity) g4).g5();
                    } else if (g4 instanceof RecommendedActivity) {
                        ((RecommendedActivity) g4).i5();
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: h2.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20854a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f20855b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f20856c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f20857d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C c5, C c6, String str, d dVar) {
            super(2, dVar);
            this.f20855b = c5;
            this.f20856c = c6;
            this.f20857d = str;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f20855b, this.f20856c, this.f20857d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
            if (((com.uptodown.activities.MainActivity) r5).U7((java.lang.String) r1, r4) == r0) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
            if (((com.uptodown.activities.AppDetailActivity) r5).r3((java.lang.String) r1, r4) == r0) goto L_0x0054;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r4.f20854a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L_0x0017:
                R2.n.b(r5)
                goto L_0x00b0
            L_0x001c:
                R2.n.b(r5)
                N1.k$a r5 = N1.k.f7778g
                android.app.Activity r5 = r5.g()
                if (r5 == 0) goto L_0x00b0
                boolean r1 = r5 instanceof com.uptodown.activities.MainActivity
                if (r1 == 0) goto L_0x003e
                kotlin.jvm.internal.C r1 = r4.f20855b
                java.lang.Object r1 = r1.f20968a
                if (r1 == 0) goto L_0x00b0
                com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                java.lang.String r1 = (java.lang.String) r1
                r4.f20854a = r3
                java.lang.Object r5 = r5.U7(r1, r4)
                if (r5 != r0) goto L_0x00b0
                goto L_0x0054
            L_0x003e:
                boolean r1 = r5 instanceof com.uptodown.activities.AppDetailActivity
                if (r1 == 0) goto L_0x0055
                kotlin.jvm.internal.C r1 = r4.f20855b
                java.lang.Object r1 = r1.f20968a
                if (r1 == 0) goto L_0x00b0
                com.uptodown.activities.AppDetailActivity r5 = (com.uptodown.activities.AppDetailActivity) r5
                java.lang.String r1 = (java.lang.String) r1
                r4.f20854a = r2
                java.lang.Object r5 = r5.r3(r1, r4)
                if (r5 != r0) goto L_0x00b0
            L_0x0054:
                return r0
            L_0x0055:
                boolean r0 = r5 instanceof com.uptodown.activities.MyDownloads
                if (r0 == 0) goto L_0x0065
                com.uptodown.activities.MyDownloads r5 = (com.uptodown.activities.MyDownloads) r5
                kotlin.jvm.internal.C r0 = r4.f20856c
                java.lang.Object r0 = r0.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r5.w4(r0)
                goto L_0x00b0
            L_0x0065:
                boolean r0 = r5 instanceof com.uptodown.activities.Updates
                if (r0 == 0) goto L_0x0075
                com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                kotlin.jvm.internal.C r0 = r4.f20855b
                java.lang.Object r0 = r0.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r5.G5(r0)
                goto L_0x00b0
            L_0x0075:
                boolean r0 = r5 instanceof com.uptodown.activities.MyApps
                if (r0 == 0) goto L_0x0085
                com.uptodown.activities.MyApps r5 = (com.uptodown.activities.MyApps) r5
                kotlin.jvm.internal.C r0 = r4.f20856c
                java.lang.Object r0 = r0.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r5.m5(r0)
                goto L_0x00b0
            L_0x0085:
                boolean r0 = r5 instanceof com.uptodown.core.activities.InstallerActivity
                if (r0 == 0) goto L_0x0091
                com.uptodown.core.activities.InstallerActivity r5 = (com.uptodown.core.activities.InstallerActivity) r5
                java.lang.String r0 = r4.f20857d
                r5.S1(r0)
                goto L_0x00b0
            L_0x0091:
                boolean r0 = r5 instanceof com.uptodown.activities.WishlistActivity
                if (r0 == 0) goto L_0x00a1
                com.uptodown.activities.WishlistActivity r5 = (com.uptodown.activities.WishlistActivity) r5
                kotlin.jvm.internal.C r0 = r4.f20856c
                java.lang.Object r0 = r0.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r5.h5(r0)
                goto L_0x00b0
            L_0x00a1:
                boolean r0 = r5 instanceof com.uptodown.activities.RecommendedActivity
                if (r0 == 0) goto L_0x00b0
                com.uptodown.activities.RecommendedActivity r5 = (com.uptodown.activities.RecommendedActivity) r5
                kotlin.jvm.internal.C r0 = r4.f20856c
                java.lang.Object r0 = r0.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r5.j5(r0)
            L_0x00b0:
                R2.s r5 = R2.s.f8222a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: h2.C2076h.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C2076h(Handler handler) {
        super(handler);
    }

    private final String a(int i4) {
        switch (i4) {
            case 1:
                return "STATUS_FAILURE";
            case 2:
                return "STATUS_FAILURE_BLOCKED";
            case 3:
                return "STATUS_FAILURE_ABORTED";
            case 4:
                return "STATUS_FAILURE_INVALID";
            case 5:
                return "STATUS_FAILURE_CONFLICT";
            case 6:
                return "STATUS_FAILURE_STORAGE";
            case 7:
                return "STATUS_FAILURE_INCOMPATIBLE";
            default:
                return String.valueOf(i4);
        }
    }

    private final ArrayList b(File file) {
        FeatureInfo[] featureInfoArr;
        PackageManager packageManager;
        PackageManager packageManager2;
        ArrayList arrayList = new ArrayList();
        ArrayList c5 = c(file);
        if (!c5.isEmpty()) {
            Context context = this.f20852a;
            String[] strArr = null;
            if (context == null || (packageManager2 = context.getPackageManager()) == null) {
                featureInfoArr = null;
            } else {
                featureInfoArr = packageManager2.getSystemAvailableFeatures();
            }
            Context context2 = this.f20852a;
            if (!(context2 == null || (packageManager = context2.getPackageManager()) == null)) {
                strArr = packageManager.getSystemSharedLibraryNames();
            }
            Iterator it = c5.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                T1.d dVar = (T1.d) next;
                if (dVar.c() && dVar.a() != null) {
                    boolean z4 = false;
                    if (m3.m.p(dVar.b(), "uses-feature", true) && featureInfoArr != null && featureInfoArr.length != 0) {
                        Iterator a5 = C2098b.a(featureInfoArr);
                        while (a5.hasNext()) {
                            if (m3.m.p(dVar.a(), ((FeatureInfo) a5.next()).name, true)) {
                                z4 = true;
                            }
                        }
                    } else if (!(!m3.m.p(dVar.b(), "uses-library", true) || strArr == null || strArr.length == 0)) {
                        Iterator a6 = C2098b.a(strArr);
                        while (a6.hasNext()) {
                            if (m3.m.p(dVar.a(), (String) a6.next(), true)) {
                                z4 = true;
                            }
                        }
                    }
                    if (!z4) {
                        String a7 = dVar.a();
                        m.b(a7);
                        arrayList.add(a7);
                    }
                }
            }
        }
        return arrayList;
    }

    private final ArrayList c(File file) {
        return new C1605a().f(new C1606b().f(file.getAbsolutePath()));
    }

    public final void d(Context context) {
        this.f20852a = context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceiveResult(int r19, android.os.Bundle r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            android.content.Context r3 = r0.f20852a
            if (r3 == 0) goto L_0x0269
            r4 = 222(0xde, float:3.11E-43)
            r5 = 0
            if (r1 == r4) goto L_0x0250
            r4 = 223(0xdf, float:3.12E-43)
            java.lang.String r6 = "install"
            java.lang.String r7 = "type"
            if (r1 == r4) goto L_0x0216
            r4 = 227(0xe3, float:3.18E-43)
            if (r1 == r4) goto L_0x002a
            r2 = 228(0xe4, float:3.2E-43)
            if (r1 == r2) goto L_0x0021
            goto L_0x0269
        L_0x0021:
            u2.C r1 = u2.C2313C.f21882a
            kotlin.jvm.internal.m.b(r3)
            r1.f(r3)
            return
        L_0x002a:
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            r1.K0(r5)
            kotlin.jvm.internal.C r1 = new kotlin.jvm.internal.C
            r1.<init>()
            kotlin.jvm.internal.C r3 = new kotlin.jvm.internal.C
            r3.<init>()
            u2.C r4 = u2.C2313C.f21882a
            android.content.Context r8 = r0.f20852a
            kotlin.jvm.internal.m.b(r8)
            r4.f(r8)
            java.lang.String r4 = "size"
            java.lang.String r8 = "packagename"
            if (r2 == 0) goto L_0x0060
            java.lang.String r10 = "piStatus"
            int r10 = r2.getInt(r10)
            java.lang.String r11 = r2.getString(r8)
            r1.f20968a = r11
            long r11 = r2.getLong(r4)
            java.lang.String r13 = "extra_error"
            java.lang.String r2 = r2.getString(r13)
            goto L_0x0064
        L_0x0060:
            r11 = -1
            r2 = r5
            r10 = 0
        L_0x0064:
            java.lang.String r10 = r0.a(r10)
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            java.lang.String r14 = "error"
            r13.putString(r14, r10)
            if (r2 == 0) goto L_0x0079
            java.lang.String r14 = "extraError"
            r13.putString(r14, r2)
        L_0x0079:
            java.lang.String r2 = "failed"
            r13.putString(r7, r2)
            java.lang.Object r2 = r1.f20968a
            if (r2 == 0) goto L_0x01bd
            java.lang.String r2 = (java.lang.String) r2
            r13.putString(r8, r2)
            android.content.Context r2 = r0.f20852a
            if (r2 == 0) goto L_0x01bd
            u2.m r2 = new u2.m
            r2.<init>()
            android.content.Context r7 = r0.f20852a
            kotlin.jvm.internal.m.b(r7)
            r19 = 0
            java.lang.Object r14 = r1.f20968a
            java.lang.String r14 = (java.lang.String) r14
            g2.f r2 = r2.A(r7, r14)
            u2.t$a r7 = u2.t.f21927u
            android.content.Context r14 = r0.f20852a
            kotlin.jvm.internal.m.b(r14)
            u2.t r7 = r7.a(r14)
            r7.a()
            java.lang.Object r14 = r1.f20968a
            java.lang.String r14 = (java.lang.String) r14
            g2.s r14 = r7.h0(r14)
            java.lang.Object r15 = r1.f20968a
            java.lang.String r15 = (java.lang.String) r15
            g2.S r15 = r7.D0(r15)
            java.lang.String r5 = "update"
            if (r15 == 0) goto L_0x00dd
            int r17 = r15.e()
            if (r17 != 0) goto L_0x00ce
            r9 = 2
            r15.p(r9)
            r7.v1(r15)
        L_0x00ce:
            r9 = 1
            r13.putInt(r5, r9)
            if (r2 == 0) goto L_0x00d9
            java.lang.String r5 = r2.m()
            goto L_0x00da
        L_0x00d9:
            r5 = 0
        L_0x00da:
            r3.f20968a = r5
            goto L_0x00e1
        L_0x00dd:
            r9 = 0
            r13.putInt(r5, r9)
        L_0x00e1:
            r7.i()
            u2.y r5 = u2.y.f21955a
            android.content.Context r7 = r0.f20852a
            kotlin.jvm.internal.m.b(r7)
            java.lang.Object r9 = r1.f20968a
            java.lang.String r9 = (java.lang.String) r9
            android.os.Bundle r13 = r5.b(r7, r9, r13)
            g2.C$b r5 = g2.C2035C.f20340i
            android.content.Context r7 = r0.f20852a
            kotlin.jvm.internal.m.b(r7)
            r5.b(r7, r2, r13)
            if (r14 == 0) goto L_0x0164
            java.util.ArrayList r2 = r14.o()
            int r2 = r2.size()
            r9 = 1
            if (r2 != r9) goto L_0x0132
            java.util.ArrayList r2 = r14.o()
            r9 = 0
            java.lang.Object r2 = r2.get(r9)
            g2.s$c r2 = (g2.C2060s.c) r2
            java.lang.String r2 = r2.a()
            if (r2 == 0) goto L_0x0132
            java.io.File r2 = new java.io.File
            java.util.ArrayList r5 = r14.o()
            java.lang.Object r5 = r5.get(r9)
            g2.s$c r5 = (g2.C2060s.c) r5
            java.lang.String r5 = r5.a()
            kotlin.jvm.internal.m.b(r5)
            r2.<init>(r5)
            goto L_0x0133
        L_0x0132:
            r2 = 0
        L_0x0133:
            java.util.ArrayList r5 = r14.o()
            int r5 = r5.size()
            r9 = 1
            if (r5 != r9) goto L_0x0165
            java.util.ArrayList r5 = r14.o()
            r9 = 0
            java.lang.Object r5 = r5.get(r9)
            g2.s$c r5 = (g2.C2060s.c) r5
            long r16 = r5.d()
            int r5 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x0165
            java.util.ArrayList r5 = r14.o()
            java.lang.Object r5 = r5.get(r9)
            g2.s$c r5 = (g2.C2060s.c) r5
            long r14 = r5.d()
            java.lang.String r5 = java.lang.String.valueOf(r14)
            goto L_0x0166
        L_0x0164:
            r2 = 0
        L_0x0165:
            r5 = 0
        L_0x0166:
            if (r2 == 0) goto L_0x01c0
            boolean r7 = r2.exists()
            if (r7 == 0) goto L_0x01c0
            java.util.ArrayList r2 = r0.b(r2)
            boolean r7 = r2.isEmpty()
            if (r7 != 0) goto L_0x01c0
            int r7 = r2.size()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r9 = "missed_features"
            r13.putString(r9, r7)
            java.util.Iterator r2 = r2.iterator()
            java.lang.String r7 = "iterator(...)"
            kotlin.jvm.internal.m.d(r2, r7)
        L_0x018e:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x01c0
            java.lang.Object r7 = r2.next()
            java.lang.String r9 = "next(...)"
            kotlin.jvm.internal.m.d(r7, r9)
            java.lang.String r7 = (java.lang.String) r7
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.lang.String r14 = "feature"
            r9.putString(r14, r7)
            java.lang.Object r7 = r1.f20968a
            java.lang.String r7 = (java.lang.String) r7
            r9.putString(r8, r7)
            u2.x r7 = new u2.x
            android.content.Context r14 = r0.f20852a
            r7.<init>(r14)
            java.lang.String r14 = "missing_feature"
            r7.d(r14, r9)
            goto L_0x018e
        L_0x01bd:
            r19 = 0
            r5 = 0
        L_0x01c0:
            int r2 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x01cd
            u2.y r2 = u2.y.f21955a
            java.lang.String r2 = r2.e(r11)
            r13.putString(r4, r2)
        L_0x01cd:
            if (r5 == 0) goto L_0x01db
            int r2 = r5.length()
            if (r2 != 0) goto L_0x01d6
            goto L_0x01db
        L_0x01d6:
            java.lang.String r2 = "fileId"
            r13.putString(r2, r5)
        L_0x01db:
            android.content.Context r2 = r0.f20852a
            if (r2 == 0) goto L_0x01e7
            r4 = 2131951966(0x7f13015e, float:1.9540361E38)
            java.lang.String r2 = r2.getString(r4)
            goto L_0x01e8
        L_0x01e7:
            r2 = 0
        L_0x01e8:
            if (r2 == 0) goto L_0x01f6
            int r4 = r2.length()
            if (r4 != 0) goto L_0x01f1
            goto L_0x01f6
        L_0x01f1:
            java.lang.String r4 = "dpi"
            r13.putString(r4, r2)
        L_0x01f6:
            u2.x r2 = new u2.x
            android.content.Context r4 = r0.f20852a
            r2.<init>(r4)
            r2.d(r6, r13)
            o3.E0 r2 = o3.Y.c()
            o3.J r4 = o3.K.a(r2)
            h2.h$b r7 = new h2.h$b
            r2 = 0
            r7.<init>(r1, r3, r10, r2)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            o3.C1001s0 unused = o3.C0981i.d(r4, r5, r6, r7, r8, r9)
            return
        L_0x0216:
            r2 = r5
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f17422D
            r1.K0(r2)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "cancelled"
            r1.putString(r7, r2)
            u2.x r2 = new u2.x
            android.content.Context r3 = r0.f20852a
            r2.<init>(r3)
            r2.d(r6, r1)
            u2.C r1 = u2.C2313C.f21882a
            android.content.Context r2 = r0.f20852a
            kotlin.jvm.internal.m.b(r2)
            r1.f(r2)
            o3.E0 r1 = o3.Y.c()
            o3.J r2 = o3.K.a(r1)
            h2.h$a r5 = new h2.h$a
            r1 = 0
            r5.<init>(r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            o3.C1001s0 unused = o3.C0981i.d(r2, r3, r4, r5, r6, r7)
            return
        L_0x0250:
            r1 = r5
            if (r2 == 0) goto L_0x025a
            java.lang.String r1 = "appNameAndVersion"
            java.lang.String r5 = r2.getString(r1)
            goto L_0x025b
        L_0x025a:
            r5 = r1
        L_0x025b:
            if (r5 != 0) goto L_0x025f
            java.lang.String r5 = ""
        L_0x025f:
            u2.C r1 = u2.C2313C.f21882a
            android.content.Context r2 = r0.f20852a
            kotlin.jvm.internal.m.b(r2)
            r1.m(r2, r5)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C2076h.onReceiveResult(int, android.os.Bundle):void");
    }
}
