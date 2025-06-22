package com.uptodown.workers;

import N1.k;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import g2.C2044b;
import g2.C2048f;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.C2313C;
import u2.C2315a;
import u2.F;
import u2.t;
import u2.w;
import u2.z;

public final class DownloadUpdatesWorker extends DownloadWorker {

    /* renamed from: j  reason: collision with root package name */
    public static final a f19452j = new a((C2103g) null);

    /* renamed from: k  reason: collision with root package name */
    private static S f19453k;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f19454h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19455i;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements DownloadWorker.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ B f19456a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ B f19457b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DownloadUpdatesWorker f19458c;

        b(B b5, B b6, DownloadUpdatesWorker downloadUpdatesWorker) {
            this.f19456a = b5;
            this.f19457b = b6;
            this.f19458c = downloadUpdatesWorker;
        }

        public void a(long j4) {
            this.f19456a.f20967a = j4;
        }

        public void b() {
        }

        public void c(long j4) {
            this.f19457b.f20967a = j4;
        }

        public void d() {
            Bundle bundle = new Bundle();
            bundle.putString("type", "reconnected");
            DownloadUpdatesWorker downloadUpdatesWorker = this.f19458c;
            downloadUpdatesWorker.w(bundle, downloadUpdatesWorker.t());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "c");
        m.e(workerParameters, "params");
        this.f19454h = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        this.f19455i = workerParameters.getInputData().getInt("downloadAutostartedInBackground", 0);
        v();
    }

    private final void L(String str, S s4, C2060s.c cVar) {
        File file;
        File file2;
        long j4;
        String str2 = str;
        K((String) null);
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        aVar.o();
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString("type", "start");
        w(bundle, new URL(str2).getHost());
        HttpsURLConnection G4 = G(str2, currentTimeMillis);
        if (G4 != null) {
            K(G4.getURL().getHost());
            w wVar = new w();
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            File g4 = wVar.g(applicationContext);
            if (g4.exists() || g4.mkdirs()) {
                C2060s.c cVar2 = cVar;
                String a5 = cVar2.a();
                if (a5 == null || a5.length() == 0) {
                    String url = G4.getURL().toString();
                    m.d(url, "toString(...)");
                    String str3 = s4.h() + '_' + cVar2.d() + '.' + q(url);
                    StringBuilder sb = new StringBuilder();
                    sb.append(g4.getAbsolutePath());
                    sb.append('/');
                    sb.append(s4.h());
                    file = g4;
                    sb.append(s4.j());
                    File file3 = new File(sb.toString());
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    file2 = new File(file3.getAbsolutePath() + '/' + str3);
                    cVar2.k(file2.getAbsolutePath());
                    t a6 = t.f21927u.a(p());
                    a6.a();
                    a6.x1(cVar2);
                    a6.i();
                } else {
                    String a7 = cVar2.a();
                    m.b(a7);
                    file = g4;
                    file2 = new File(a7);
                }
                if (file2.exists()) {
                    j4 = file2.length();
                } else {
                    j4 = 0;
                }
                if (A(G4, currentTimeMillis)) {
                    C2060s f4 = aVar.f();
                    m.b(f4);
                    if (new C2315a().a(new w().k(p(), file), f4.z() - j4)) {
                        B b5 = new B();
                        B b6 = new B();
                        b bVar = new b(b5, b6, this);
                        C2060s f5 = aVar.f();
                        m.b(f5);
                        String t4 = t();
                        m.b(t4);
                        long m4 = m(G4, file2, f5, cVar2, t4, currentTimeMillis, bVar);
                        File file4 = file2;
                        long j5 = currentTimeMillis;
                        if (m4 >= 0) {
                            if (aVar.i()) {
                                j(j5);
                                return;
                            }
                            long i4 = cVar.i();
                            String e5 = cVar.e();
                            m.b(e5);
                            long j6 = m4;
                            long j7 = j5;
                            Bundle h4 = h(j4, j6, file4, i4, e5);
                            if (h4 != null) {
                                C2060s f6 = aVar.f();
                                if (f6 != null) {
                                    f6.S(p());
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("packagename", s4.h());
                                F.f21886a.g().send(102, bundle2);
                                h4.putString("url", str2);
                                C2060s f7 = aVar.f();
                                m.b(f7);
                                Bundle bundle3 = h4;
                                y(s4, f7, cVar, bundle3, t(), j7);
                                return;
                            }
                            x(b5.f20967a, j7, b6.f20967a, j6);
                            if (k.f7778g.g() == null) {
                                C2044b bVar2 = new C2044b();
                                t.a aVar2 = t.f21927u;
                                Context applicationContext2 = getApplicationContext();
                                m.d(applicationContext2, "getApplicationContext(...)");
                                t a8 = aVar2.a(applicationContext2);
                                a8.a();
                                C2048f Y4 = a8.Y(s4.h());
                                if (Y4 != null) {
                                    bVar2.j(Y4, s4, a8);
                                }
                                a8.i();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    S s5 = s4;
                    G4.disconnect();
                    C2060s f8 = aVar.f();
                    if (f8 != null) {
                        f8.S(p());
                    }
                    w wVar2 = new w();
                    Context applicationContext3 = getApplicationContext();
                    m.d(applicationContext3, "getApplicationContext(...)");
                    wVar2.b(applicationContext3);
                    F.f21886a.g().send(104, (Bundle) null);
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space");
                    C2060s f9 = aVar.f();
                    m.b(f9);
                    y(s5, f9, cVar, bundle4, t(), currentTimeMillis);
                    return;
                }
                return;
            }
            Bundle bundle5 = new Bundle();
            bundle5.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir");
            C2060s f10 = aVar.f();
            m.b(f10);
            y(s4, f10, cVar, bundle5, t(), currentTimeMillis);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void M() {
        /*
            r17 = this;
            r1 = r17
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
            g2.f r0 = r0.s()
            u2.w r2 = new u2.w
            r2.<init>()
            android.content.Context r3 = r1.p()
            java.io.File r2 = r2.g(r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x001e
            r2.mkdirs()
        L_0x001e:
            if (r0 == 0) goto L_0x02eb
            u2.z r3 = u2.z.f21956a
            boolean r3 = r3.d()
            if (r3 == 0) goto L_0x02eb
            com.uptodown.UptodownApp$a r3 = com.uptodown.UptodownApp.f17422D
            java.lang.String r4 = "downloadApkWorker"
            android.content.Context r5 = r1.p()
            boolean r3 = r3.U(r4, r5)
            if (r3 == 0) goto L_0x0038
            goto L_0x02eb
        L_0x0038:
            u2.t$a r3 = u2.t.f21927u
            android.content.Context r4 = r1.p()
            u2.t r3 = r3.a(r4)
            r3.a()
            java.lang.String r4 = r0.o()
            kotlin.jvm.internal.m.b(r4)
            g2.S r4 = r3.D0(r4)
            f19453k = r4
            r3.i()
            com.uptodown.workers.DownloadWorker$a r3 = com.uptodown.workers.DownloadWorker.f19459d
            g2.S r4 = f19453k
            r5 = 0
            if (r4 == 0) goto L_0x0061
            g2.s r4 = r4.a()
            goto L_0x0062
        L_0x0061:
            r4 = r5
        L_0x0062:
            r3.q(r4)
            g2.s r4 = r3.f()
            if (r4 == 0) goto L_0x02e3
            g2.s r4 = r3.f()
            kotlin.jvm.internal.m.b(r4)
            java.util.ArrayList r4 = r4.o()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x02e3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            g2.s r6 = r3.f()
            kotlin.jvm.internal.m.b(r6)
            java.lang.String r6 = r6.w()
            java.lang.String r7 = "packagename"
            r4.putString(r7, r6)
            u2.F r6 = u2.F.f21886a
            h2.g r6 = r6.g()
            r8 = 109(0x6d, float:1.53E-43)
            r6.send(r8, r4)
            g2.s r3 = r3.f()
            kotlin.jvm.internal.m.b(r3)
            java.util.ArrayList r3 = r3.o()
            java.util.Iterator r3 = r3.iterator()
            java.lang.String r4 = "iterator(...)"
            kotlin.jvm.internal.m.d(r3, r4)
        L_0x00b0:
            boolean r4 = r3.hasNext()
            r6 = 1
            if (r4 == 0) goto L_0x0240
            java.lang.Object r4 = r3.next()
            java.lang.String r8 = "next(...)"
            kotlin.jvm.internal.m.d(r4, r8)
            g2.s$c r4 = (g2.C2060s.c) r4
            u2.a r8 = new u2.a
            r8.<init>()
            u2.w r9 = new u2.w
            r9.<init>()
            android.content.Context r10 = r1.p()
            long r9 = r9.k(r10, r2)
            com.uptodown.workers.DownloadWorker$a r11 = com.uptodown.workers.DownloadWorker.f19459d
            g2.s r12 = r11.f()
            kotlin.jvm.internal.m.b(r12)
            long r12 = r12.z()
            boolean r8 = r8.a(r9, r12)
            if (r8 != 0) goto L_0x00f4
            u2.F r0 = u2.F.f21886a
            h2.g r0 = r0.g()
            r3 = 104(0x68, float:1.46E-43)
            r0.send(r3, r5)
            goto L_0x0240
        L_0x00f4:
            u2.L r8 = new u2.L
            android.content.Context r9 = r1.p()
            r8.<init>(r9)
            g2.r r9 = new g2.r
            r9.<init>()
            android.content.Context r10 = r1.p()
            r9.j(r10)
            long r9 = r4.d()
            r12 = 102(0x66, float:1.43E-43)
            r13 = 0
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x0229
            com.uptodown.UptodownApp$a r9 = com.uptodown.UptodownApp.f17422D
            g2.S r10 = f19453k
            kotlin.jvm.internal.m.b(r10)
            r9.w0(r10)
            java.lang.String r10 = r4.a()
            if (r10 == 0) goto L_0x013c
            java.io.File r10 = new java.io.File
            java.lang.String r15 = r4.a()
            kotlin.jvm.internal.m.b(r15)
            r10.<init>(r15)
            boolean r15 = r10.exists()
            if (r15 == 0) goto L_0x013c
            long r15 = r10.length()
            goto L_0x013d
        L_0x013c:
            r15 = r13
        L_0x013d:
            int r10 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r10 <= 0) goto L_0x0156
            long r13 = r4.d()
            java.lang.String r10 = java.lang.String.valueOf(r13)
            long r13 = r0.b()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            g2.L r8 = r8.q0(r10, r6, r13)
            goto L_0x016a
        L_0x0156:
            long r13 = r4.d()
            java.lang.String r10 = java.lang.String.valueOf(r13)
            long r13 = r0.b()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            g2.L r8 = r8.p0(r10, r6, r13)
        L_0x016a:
            boolean r10 = r8.b()
            if (r10 != 0) goto L_0x020a
            java.lang.String r10 = r8.d()
            if (r10 == 0) goto L_0x020a
            int r10 = r10.length()
            if (r10 != 0) goto L_0x017e
            goto L_0x020a
        L_0x017e:
            org.json.JSONObject r10 = new org.json.JSONObject
            java.lang.String r8 = r8.d()
            kotlin.jvm.internal.m.b(r8)
            r10.<init>(r8)
            java.lang.String r8 = "success"
            boolean r13 = r10.isNull(r8)
            if (r13 != 0) goto L_0x0197
            int r8 = r10.optInt(r8)
            goto L_0x0198
        L_0x0197:
            r8 = 0
        L_0x0198:
            if (r8 == r6) goto L_0x01b5
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            g2.S r6 = f19453k
            kotlin.jvm.internal.m.b(r6)
            java.lang.String r6 = r6.h()
            r4.putString(r7, r6)
            u2.F r6 = u2.F.f21886a
            h2.g r6 = r6.g()
            r6.send(r12, r4)
            goto L_0x021f
        L_0x01b5:
            java.lang.String r8 = "data"
            org.json.JSONObject r8 = r10.optJSONObject(r8)
            if (r8 == 0) goto L_0x021f
            java.lang.String r10 = "sha256"
            boolean r12 = r8.isNull(r10)
            if (r12 != 0) goto L_0x01cc
            java.lang.String r10 = r8.optString(r10)
            r4.n(r10)
        L_0x01cc:
            java.lang.String r10 = "downloadURL"
            boolean r12 = r8.isNull(r10)
            if (r12 != 0) goto L_0x021f
            java.lang.String r8 = r8.optString(r10)
            com.uptodown.activities.preferences.a$a r10 = com.uptodown.activities.preferences.a.f18818a
            android.content.Context r12 = r1.p()
            boolean r10 = r10.Z(r12)
            if (r10 == 0) goto L_0x01f0
            boolean r10 = r1.f19454h
            if (r10 != 0) goto L_0x01f0
            u2.z r10 = u2.z.f21956a
            boolean r10 = r10.f()
            if (r10 == 0) goto L_0x021f
        L_0x01f0:
            boolean r10 = r1.f19454h
            if (r10 == 0) goto L_0x01fe
            g2.s r10 = r11.f()
            kotlin.jvm.internal.m.b(r10)
            r10.W(r6)
        L_0x01fe:
            kotlin.jvm.internal.m.b(r8)
            g2.S r6 = f19453k
            kotlin.jvm.internal.m.b(r6)
            r1.L(r8, r6, r4)
            goto L_0x021f
        L_0x020a:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = r0.o()
            r4.putString(r7, r6)
            u2.F r6 = u2.F.f21886a
            h2.g r6 = r6.g()
            r6.send(r12, r4)
        L_0x021f:
            g2.S r4 = f19453k
            kotlin.jvm.internal.m.b(r4)
            r9.e0(r4)
            goto L_0x00b0
        L_0x0229:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r6 = r0.o()
            r4.putString(r7, r6)
            u2.F r6 = u2.F.f21886a
            h2.g r6 = r6.g()
            r6.send(r12, r4)
            goto L_0x00b0
        L_0x0240:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.uptodown.workers.DownloadWorker$a r3 = com.uptodown.workers.DownloadWorker.f19459d
            g2.s r4 = r3.f()
            kotlin.jvm.internal.m.b(r4)
            java.lang.String r4 = r4.w()
            r0.putString(r7, r4)
            u2.F r4 = u2.F.f21886a
            h2.g r4 = r4.g()
            r7 = 108(0x6c, float:1.51E-43)
            r4.send(r7, r0)
            g2.s r0 = r3.f()
            kotlin.jvm.internal.m.b(r0)
            java.lang.String r0 = r0.w()
            android.content.Context r4 = r1.p()
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = m3.m.p(r0, r4, r6)
            if (r0 == 0) goto L_0x02da
            N1.k$a r0 = N1.k.f7778g
            android.app.Activity r0 = r0.g()
            g2.s r4 = r3.f()
            kotlin.jvm.internal.m.b(r4)
            java.io.File r4 = r4.n()
            if (r4 == 0) goto L_0x02e3
            boolean r6 = r4.exists()
            if (r6 == 0) goto L_0x02e3
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 31
            if (r6 < r7) goto L_0x02be
            if (r0 != 0) goto L_0x02be
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
            android.content.Context r6 = r1.p()
            r0.V(r4, r6, r5)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r4 = "type"
            java.lang.String r5 = "start"
            r0.putString(r4, r5)
            u2.x r4 = r1.s()
            if (r4 == 0) goto L_0x02ba
            java.lang.String r5 = "install"
            r4.d(r5, r0)
        L_0x02ba:
            r3.b()
            goto L_0x02e3
        L_0x02be:
            u2.C r0 = u2.C2313C.f21882a     // Catch:{ Exception -> 0x02d5 }
            android.content.Context r3 = r1.p()     // Catch:{ Exception -> 0x02d5 }
            u2.q r5 = new u2.q     // Catch:{ Exception -> 0x02d5 }
            r5.<init>()     // Catch:{ Exception -> 0x02d5 }
            android.content.Context r6 = r1.p()     // Catch:{ Exception -> 0x02d5 }
            android.net.Uri r4 = r5.t(r4, r6)     // Catch:{ Exception -> 0x02d5 }
            r0.B(r3, r4)     // Catch:{ Exception -> 0x02d5 }
            goto L_0x02e3
        L_0x02d5:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x02e3
        L_0x02da:
            com.uptodown.workers.InstallUpdatesWorker$a r0 = com.uptodown.workers.InstallUpdatesWorker.f19479b
            android.content.Context r3 = r1.p()
            r0.a(r3)
        L_0x02e3:
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
            g2.f r0 = r0.s()
            goto L_0x001e
        L_0x02eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadUpdatesWorker.M():void");
    }

    public void H(C2060s sVar) {
        m.e(sVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", f19453k);
        bundle.putParcelable("download", sVar);
        F.f21886a.g().send(102, bundle);
    }

    public void I(C2060s sVar, int i4) {
        m.e(sVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", f19453k);
        bundle.putParcelable("download", sVar);
        bundle.putString("packagename", sVar.w());
        F.f21886a.g().send(i4, bundle);
    }

    public ListenableWorker.Result doWork() {
        F f4 = F.f21886a;
        f4.g().send(107, (Bundle) null);
        z zVar = z.f21956a;
        if (zVar.d()) {
            w wVar = new w();
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            wVar.b(applicationContext);
            ArrayList E4 = UptodownApp.f17422D.E();
            if (E4 != null && E4.size() > 0) {
                if (!com.uptodown.activities.preferences.a.f18818a.Z(p())) {
                    M();
                } else if (zVar.f() || this.f19454h) {
                    M();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("apps_parcelable", E4);
                    f4.g().send(105, bundle);
                }
            }
        } else {
            f4.g().send(110, (Bundle) null);
        }
        InstallUpdatesWorker.f19479b.a(p());
        f4.g().send(103, (Bundle) null);
        C2313C.f21882a.F(p());
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        return success;
    }

    public S u() {
        return f19453k;
    }

    public void y(S s4, C2060s sVar, C2060s.c cVar, Bundle bundle, String str, long j4) {
        m.e(s4, "update");
        m.e(sVar, "download");
        m.e(cVar, "df");
        m.e(bundle, "bundleParamsFail");
        bundle.putString("type", "fail");
        if (j4 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j4) / ((long) 1000));
        }
        w(bundle, str);
    }
}
