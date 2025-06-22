package com.uptodown.workers;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import g2.C2041I;
import g2.C2050h;
import g2.C2060s;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.C2313C;
import u2.C2315a;
import u2.F;
import u2.L;
import u2.q;
import u2.t;
import u2.w;
import u2.x;
import u2.z;

public final class DownloadApkWorker extends DownloadWorker {

    /* renamed from: i  reason: collision with root package name */
    public static final a f19447i = new a((C2103g) null);

    /* renamed from: h  reason: collision with root package name */
    private String f19448h;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context, String str) {
            m.e(context, "context");
            m.e(str, "url");
            if (!UptodownApp.f17422D.U("downloadApkWorker", context)) {
                Data.Builder putString = new Data.Builder().putString("url", str);
                m.d(putString, "putString(...)");
                Data build = putString.build();
                m.d(build, "build(...)");
                WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DownloadApkWorker.class).addTag("downloadApkWorker")).setInputData(build)).build());
            }
        }

        public final void b(Context context, String str, int i4) {
            m.e(context, "context");
            m.e(str, "url");
            if (!UptodownApp.f17422D.U("downloadApkWorker", context)) {
                Data.Builder putInt = new Data.Builder().putString("url", str).putInt("downloadId", i4);
                m.d(putInt, "putInt(...)");
                Data build = putInt.build();
                m.d(build, "build(...)");
                WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DownloadApkWorker.class).addTag("downloadApkWorker")).setInputData(build)).build());
            }
        }

        public final boolean c(Context context, int i4) {
            m.e(context, "context");
            if (UptodownApp.f17422D.U("downloadApkWorker", context)) {
                return false;
            }
            Data.Builder putInt = new Data.Builder().putInt("downloadId", i4);
            m.d(putInt, "putInt(...)");
            Data build = putInt.build();
            m.d(build, "build(...)");
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DownloadApkWorker.class).addTag("downloadApkWorker")).setInputData(build)).build());
            return true;
        }

        private a() {
        }
    }

    public static final class b implements DownloadWorker.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ B f19449a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ B f19450b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DownloadApkWorker f19451c;

        b(B b5, B b6, DownloadApkWorker downloadApkWorker) {
            this.f19449a = b5;
            this.f19450b = b6;
            this.f19451c = downloadApkWorker;
        }

        public void a(long j4) {
            this.f19449a.f20967a = j4;
        }

        public void b() {
        }

        public void c(long j4) {
            this.f19450b.f20967a = j4;
        }

        public void d() {
            Bundle bundle = new Bundle();
            bundle.putString("type", "reconnected");
            DownloadApkWorker downloadApkWorker = this.f19451c;
            downloadApkWorker.w(bundle, downloadApkWorker.t());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadApkWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "c");
        m.e(workerParameters, "params");
        v();
        int i4 = workerParameters.getInputData().getInt("downloadId", -1);
        if (i4 >= 0) {
            t a5 = t.f21927u.a(p());
            a5.a();
            DownloadWorker.f19459d.q(a5.l1(i4));
            a5.i();
        }
        this.f19448h = workerParameters.getInputData().getString("url");
    }

    private final void C(C2060s sVar, String str) {
        if (sVar != null) {
            sVar.I(p());
            H(sVar);
        }
        C2313C.f21882a.y(p(), sVar, str);
    }

    private final void L() {
        C2060s sVar;
        if (!z.f21956a.d()) {
            F.f21886a.f().send(209, (Bundle) null);
            return;
        }
        ArrayList i4 = new q().i(p());
        boolean Z4 = com.uptodown.activities.preferences.a.f18818a.Z(p());
        Iterator it = i4.iterator();
        m.d(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                sVar = null;
                break;
            }
            Object next = it.next();
            m.d(next, "next(...)");
            sVar = (C2060s) next;
            if (Z4) {
                if (!z.f21956a.f()) {
                    if (sVar.l() == 1) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        aVar.q((C2060s) null);
        if (sVar != null) {
            aVar.p(false);
            aVar.r(false);
            aVar.o();
            aVar.q(sVar);
            C2060s f4 = aVar.f();
            m.b(f4);
            if (((C2060s.c) f4.o().get(0)).d() > 0) {
                C2060s f5 = aVar.f();
                m.b(f5);
                String N4 = N(f5);
                if (N4 != null) {
                    M(N4);
                    L();
                }
            }
        }
    }

    private final void M(String str) {
        long j4;
        long j5;
        String d5;
        String str2 = str;
        K((String) null);
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        aVar.o();
        if (!z.f21956a.d()) {
            F.f21886a.f().send(209, (Bundle) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString("type", "start");
        w(bundle, new URL(str2).getHost());
        HttpsURLConnection G4 = G(str2, currentTimeMillis);
        if (G4 != null) {
            K(G4.getURL().getHost());
            String url = G4.getURL().toString();
            m.d(url, "toString(...)");
            String r4 = r(url);
            if (m3.m.L(r4, ".", 0, false, 6, (Object) null) < 0) {
                String url2 = G4.getURL().toString();
                m.d(url2, "toString(...)");
                r4 = r4 + q(url2);
            }
            if (r4.length() > 0) {
                C2060s f4 = aVar.f();
                m.b(f4);
                if (((C2060s.c) f4.o().get(0)).a() == null) {
                    File file = new File(new w().f(p()), r4);
                    C2060s f5 = aVar.f();
                    m.b(f5);
                    ((C2060s.c) f5.o().get(0)).k(file.getAbsolutePath());
                    t a5 = t.f21927u.a(p());
                    a5.a();
                    C2060s f6 = aVar.f();
                    m.b(f6);
                    Object obj = f6.o().get(0);
                    m.d(obj, "get(...)");
                    a5.x1((C2060s.c) obj);
                    a5.i();
                }
            }
            String i4 = new w().i(r4);
            if (i4 == null || i4.length() == 0) {
                j4 = 0;
            } else {
                L l4 = new L(p());
                j4 = 0;
                g2.L T4 = l4.T(new C2050h().f(l4.m(i4)));
                if (!(T4.b() || (d5 = T4.d()) == null || d5.length() == 0)) {
                    String d6 = T4.d();
                    m.b(d6);
                    JSONObject optJSONObject = new JSONObject(d6).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        C2050h a6 = C2050h.f20600F0.a(optJSONObject, p());
                        aVar.q(new C2060s());
                        C2060s f7 = aVar.f();
                        m.b(f7);
                        f7.d(a6);
                        if (a6.z() > 0 && a6.e() > 0) {
                            String d7 = l4.p0(String.valueOf(a6.z()), 0, String.valueOf(a6.e())).d();
                            m.b(d7);
                            JSONObject optJSONObject2 = new JSONObject(d7).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                            if (optJSONObject2 != null && !optJSONObject2.isNull("downloadURL")) {
                                String optString = optJSONObject2.optString("downloadURL");
                                m.b(optString);
                                M(optString);
                                return;
                            }
                        }
                    }
                }
            }
            if (aVar.f() == null) {
                aVar.q(new C2060s());
                C2060s.c cVar = new C2060s.c();
                cVar.m(-1);
                cVar.q(-1);
                cVar.n("");
                C2060s f8 = aVar.f();
                m.b(f8);
                f8.o().add(cVar);
            }
            File f9 = new w().f(p());
            if (f9.exists() || f9.mkdirs()) {
                C2060s f10 = aVar.f();
                m.b(f10);
                String a7 = ((C2060s.c) f10.o().get(0)).a();
                m.b(a7);
                File file2 = new File(a7);
                if (file2.exists()) {
                    j5 = file2.length();
                } else {
                    j5 = j4;
                }
                if (aVar.i()) {
                    j(currentTimeMillis);
                } else if (A(G4, currentTimeMillis)) {
                    C2060s f11 = aVar.f();
                    m.b(f11);
                    long j6 = j4;
                    long j7 = j5;
                    HttpsURLConnection httpsURLConnection = G4;
                    if (new C2315a().a(new w().k(p(), f9), ((C2060s.c) f11.o().get(0)).i() - file2.length())) {
                        C2060s f12 = aVar.f();
                        m.b(f12);
                        I(f12, 200);
                        B b5 = new B();
                        B b6 = new B();
                        b bVar = new b(b5, b6, this);
                        long j8 = currentTimeMillis;
                        C2060s f13 = aVar.f();
                        m.b(f13);
                        C2060s f14 = aVar.f();
                        m.b(f14);
                        Object obj2 = f14.o().get(0);
                        m.d(obj2, "get(...)");
                        String t4 = t();
                        m.b(t4);
                        File file3 = file2;
                        long j9 = j8;
                        long m4 = m(httpsURLConnection, file3, f13, (C2060s.c) obj2, t4, j9, bVar);
                        long j10 = j9;
                        if (m4 >= j6) {
                            if (aVar.i()) {
                                j(j10);
                                return;
                            }
                            C2060s f15 = aVar.f();
                            m.b(f15);
                            long i5 = ((C2060s.c) f15.o().get(0)).i();
                            C2060s f16 = aVar.f();
                            m.b(f16);
                            File file4 = file3;
                            Bundle h4 = h(j7, m4, file4, i5, ((C2060s.c) f16.o().get(0)).e());
                            File file5 = file4;
                            if (h4 != null) {
                                C2060s f17 = aVar.f();
                                if (f17 != null) {
                                    f17.S(p());
                                }
                                h4.putString("url", str2);
                                l(" (111)", h4, j10);
                                return;
                            }
                            x(b5.f20967a, j10, b6.f20967a, m4);
                            if (new P1.a(p()).m()) {
                                UptodownApp.a.Y(UptodownApp.f17422D, file5, p(), (String) null, 4, (Object) null);
                            } else {
                                t a8 = t.f21927u.a(p());
                                a8.a();
                                Iterator it = a8.A0().iterator();
                                m.d(it, "iterator(...)");
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Object next = it.next();
                                    m.d(next, "next(...)");
                                    C2041I i6 = (C2041I) next;
                                    int b7 = i6.b();
                                    DownloadWorker.a aVar2 = DownloadWorker.f19459d;
                                    C2060s f18 = aVar2.f();
                                    m.b(f18);
                                    if (b7 == f18.q()) {
                                        C2313C.f21882a.q(p(), aVar2.f(), i6.c());
                                        C2060s f19 = aVar2.f();
                                        m.b(f19);
                                        a8.N(f19.q());
                                        break;
                                    }
                                }
                                a8.i();
                            }
                            C2060s f20 = DownloadWorker.f19459d.f();
                            m.b(f20);
                            I(f20, 202);
                            C2313C.f21882a.e(p());
                            return;
                        }
                        return;
                    }
                    long j11 = currentTimeMillis;
                    httpsURLConnection.disconnect();
                    C2060s f21 = aVar.f();
                    if (f21 != null) {
                        f21.S(p());
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("type", "fail");
                    bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space");
                    l(" (112)", bundle2, j11);
                }
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString("type", "fail");
                bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir");
                l(" (106)", bundle3, currentTimeMillis);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String N(g2.C2060s r10) {
        /*
            r9 = this;
            u2.z r0 = u2.z.f21956a
            boolean r0 = r0.d()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            u2.F r10 = u2.F.f21886a
            h2.e r10 = r10.f()
            r0 = 209(0xd1, float:2.93E-43)
            r10.send(r0, r1)
            return r1
        L_0x0015:
            r0 = 199(0xc7, float:2.79E-43)
            r9.I(r10, r0)
            u2.L r0 = new u2.L
            android.content.Context r2 = r9.p()
            r0.<init>(r2)
            java.util.ArrayList r2 = r10.o()
            int r2 = r2.size()
            r3 = 1
            r4 = 0
            r6 = 0
            if (r2 != r3) goto L_0x0062
            java.util.ArrayList r2 = r10.o()
            java.lang.Object r2 = r2.get(r6)
            g2.s$c r2 = (g2.C2060s.c) r2
            java.lang.String r2 = r2.a()
            if (r2 == 0) goto L_0x0062
            java.io.File r2 = new java.io.File
            java.util.ArrayList r7 = r10.o()
            java.lang.Object r7 = r7.get(r6)
            g2.s$c r7 = (g2.C2060s.c) r7
            java.lang.String r7 = r7.a()
            kotlin.jvm.internal.m.b(r7)
            r2.<init>(r7)
            boolean r7 = r2.exists()
            if (r7 == 0) goto L_0x0062
            long r7 = r2.length()
            goto L_0x0063
        L_0x0062:
            r7 = r4
        L_0x0063:
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            java.util.ArrayList r2 = r10.o()
            java.lang.Object r2 = r2.get(r6)
            g2.s$c r2 = (g2.C2060s.c) r2
            long r7 = r2.d()
            java.lang.String r2 = java.lang.String.valueOf(r7)
            long r7 = r10.h()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            g2.L r0 = r0.q0(r2, r6, r7)
            goto L_0x00a4
        L_0x0086:
            java.util.ArrayList r2 = r10.o()
            java.lang.Object r2 = r2.get(r6)
            g2.s$c r2 = (g2.C2060s.c) r2
            long r7 = r2.d()
            java.lang.String r2 = java.lang.String.valueOf(r7)
            long r7 = r10.h()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            g2.L r0 = r0.p0(r2, r6, r7)
        L_0x00a4:
            boolean r2 = r0.b()
            if (r2 != 0) goto L_0x00fa
            java.lang.String r2 = r0.d()
            if (r2 == 0) goto L_0x00fa
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r0 = r0.d()
            kotlin.jvm.internal.m.b(r0)
            r2.<init>(r0)
            java.lang.String r0 = "success"
            boolean r7 = r2.isNull(r0)
            if (r7 != 0) goto L_0x00c9
            int r0 = r2.optInt(r0)
            goto L_0x00ca
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            java.lang.String r7 = "data"
            org.json.JSONObject r2 = r2.optJSONObject(r7)
            if (r2 == 0) goto L_0x00f9
            java.lang.String r7 = "sha256"
            boolean r8 = r2.isNull(r7)
            if (r8 != 0) goto L_0x00eb
            java.lang.String r7 = r2.optString(r7)
            java.util.ArrayList r8 = r10.o()
            java.lang.Object r6 = r8.get(r6)
            g2.s$c r6 = (g2.C2060s.c) r6
            r6.n(r7)
        L_0x00eb:
            java.lang.String r6 = "downloadURL"
            boolean r7 = r2.isNull(r6)
            if (r7 != 0) goto L_0x00f9
            java.lang.String r2 = r2.optString(r6)
            r6 = r0
            goto L_0x00fb
        L_0x00f9:
            r6 = r0
        L_0x00fa:
            r2 = r1
        L_0x00fb:
            if (r6 == r3) goto L_0x0103
            java.lang.String r0 = " (105)"
            r9.C(r10, r0)
            return r2
        L_0x0103:
            com.uptodown.workers.DownloadWorker$a r10 = com.uptodown.workers.DownloadWorker.f19459d
            boolean r10 = r10.i()
            if (r10 == 0) goto L_0x010e
            com.uptodown.workers.DownloadWorker.k(r9, r4, r3, r1)
        L_0x010e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadApkWorker.N(g2.s):java.lang.String");
    }

    public void H(C2060s sVar) {
        m.e(sVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", sVar);
        F.f21886a.f().send(203, bundle);
    }

    public void I(C2060s sVar, int i4) {
        m.e(sVar, "download");
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", sVar);
        bundle.putString("packagename", sVar.w());
        F.f21886a.f().send(i4, bundle);
    }

    public ListenableWorker.Result doWork() {
        String str = this.f19448h;
        if (str != null) {
            m.b(str);
            M(str);
            L();
        } else {
            DownloadWorker.a aVar = DownloadWorker.f19459d;
            if (aVar.f() == null) {
                C((C2060s) null, " (100)");
            } else {
                C2060s f4 = aVar.f();
                m.b(f4);
                if (f4.o().isEmpty()) {
                    C(aVar.f(), " (114)");
                } else {
                    C2060s f5 = aVar.f();
                    m.b(f5);
                    if (((C2060s.c) f5.o().get(0)).d() < 0) {
                        C(aVar.f(), " (103)");
                    } else {
                        C2060s f6 = aVar.f();
                        m.b(f6);
                        if (f6.h() == -1) {
                            C(aVar.f(), " (113)");
                        } else {
                            C2060s f7 = aVar.f();
                            m.b(f7);
                            String N4 = N(f7);
                            if (N4 != null) {
                                M(N4);
                                L();
                            }
                        }
                    }
                }
            }
        }
        F.f21886a.f().send(210, (Bundle) null);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        return success;
    }

    public void l(String str, Bundle bundle, long j4) {
        m.e(str, "errorCode");
        m.e(bundle, "bundle");
        C(DownloadWorker.f19459d.f(), str);
        if (j4 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j4) / ((long) 1000));
        }
        Bundle g4 = g(bundle);
        x s4 = s();
        if (s4 != null) {
            s4.d("download", g4);
        }
    }
}
