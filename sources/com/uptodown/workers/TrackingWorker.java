package com.uptodown.workers;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import W1.C1612h;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import d3.p;
import g2.C2034B;
import g2.C2044b;
import g2.C2048f;
import g2.C2060s;
import g2.L;
import g2.S;
import g2.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import o3.C0977g;
import o3.J;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.C2313C;
import u2.G;
import u2.m;
import u2.q;
import u2.t;
import u2.x;

public final class TrackingWorker extends Worker {

    /* renamed from: h  reason: collision with root package name */
    public static final a f19509h = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f19510a = k.f7778g.a(this.f19510a);

    /* renamed from: b  reason: collision with root package name */
    private boolean f19511b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19512c;

    /* renamed from: d  reason: collision with root package name */
    private String f19513d;

    /* renamed from: e  reason: collision with root package name */
    private final x f19514e = new x(this.f19510a);

    /* renamed from: f  reason: collision with root package name */
    private boolean f19515f;

    /* renamed from: g  reason: collision with root package name */
    private int f19516g;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19517a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19518b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, d dVar) {
            super(2, dVar);
            this.f19518b = context;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f19518b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19517a;
            if (i4 == 0) {
                n.b(obj);
                ArrayList B4 = new m().B(this.f19518b);
                m mVar = new m();
                Context context = this.f19518b;
                this.f19517a = 1;
                if (mVar.f(B4, context, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19519a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TrackingWorker f19520b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TrackingWorker trackingWorker, d dVar) {
            super(2, dVar);
            this.f19520b = trackingWorker;
        }

        public final d create(Object obj, d dVar) {
            return new c(this.f19520b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19519a;
            if (i4 == 0) {
                n.b(obj);
                TrackingWorker trackingWorker = this.f19520b;
                Context a5 = trackingWorker.f19510a;
                this.f19519a = 1;
                if (trackingWorker.k(a5, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        kotlin.jvm.internal.m.e(context, "context");
        kotlin.jvm.internal.m.e(workerParameters, "params");
        this.f19510a = context;
        this.f19511b = workerParameters.getInputData().getBoolean("isCompressed", true);
        for (String next : getTags()) {
            if (next.equals("TrackingWorkerPeriodic") || next.equals("TrackingWorkerSingle")) {
                this.f19513d = next;
            }
        }
    }

    private final void c(S s4, C2048f fVar, Context context) {
        t a5 = t.f21927u.a(context);
        a5.a();
        if (fVar.o() != null && m3.m.p(fVar.o(), s4.h(), true)) {
            S D02 = a5.D0(s4.h());
            if (D02 == null) {
                a5.X0(s4);
                h(s4);
                if (!new C1612h().p(context, s4.h())) {
                    this.f19515f = true;
                    this.f19516g++;
                }
                new C2044b().l(fVar, s4, a5);
            } else if (D02.l(s4)) {
                a5.R(s4.h());
                a5.X0(s4);
                h(s4);
                new C2044b().l(fVar, s4, a5);
            }
        }
        a5.i();
    }

    private final void d(L l4) {
        if (l4.f() == 401) {
            this.f19512c = true;
        } else if (l4.f() == 0) {
            this.f19512c = true;
        }
    }

    private final void e() {
        if (!UptodownApp.f17422D.U("GenerateQueueWorker", this.f19510a)) {
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", 1).putBoolean("downloadAnyway", true).putBoolean("downloadUptodown", true).putString("packagename", this.f19510a.getPackageName()).build();
            kotlin.jvm.internal.m.d(build, "build(...)");
            WorkManager.getInstance(this.f19510a).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(build)).build());
        }
    }

    private final void f() {
        if (!UptodownApp.f17422D.U("GenerateQueueWorker", this.f19510a)) {
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", 1).build();
            kotlin.jvm.internal.m.d(build, "build(...)");
            WorkManager.getInstance(this.f19510a).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(build)).build());
        }
    }

    private final String g(String str) {
        if (m3.m.p(str, "TrackingWorkerPeriodic", true)) {
            return "periodic";
        }
        return "oneTime";
    }

    private final void h(S s4) {
        ArrayList i4 = s4.i();
        if (i4 != null && !i4.isEmpty()) {
            r rVar = new r();
            ArrayList i5 = s4.i();
            kotlin.jvm.internal.m.b(i5);
            ArrayList e5 = rVar.e(i5, this.f19510a);
            if (!e5.isEmpty()) {
                Iterator it = e5.iterator();
                kotlin.jvm.internal.m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    kotlin.jvm.internal.m.d(next, "next(...)");
                    Bundle bundle = new Bundle();
                    bundle.putInt("update", 1);
                    bundle.putString("feature", (String) next);
                    this.f19514e.d("required_features_not_supported", bundle);
                }
            }
        }
    }

    private final void i(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("updates", jSONArray);
        j(jSONObject);
    }

    private final void j(JSONObject jSONObject) {
        boolean z4;
        C2060s sVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("updates");
        t a5 = t.f21927u.a(this.f19510a);
        a5.a();
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            z4 = false;
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (!optJSONObject.isNull("packagename")) {
                    String optString = optJSONObject.optString("packagename");
                    kotlin.jvm.internal.m.b(optString);
                    C2048f Y4 = a5.Y(optString);
                    if (Y4 != null) {
                        S.b bVar = S.f20455j;
                        kotlin.jvm.internal.m.b(optJSONObject);
                        S c5 = bVar.c(Y4, optJSONObject);
                        if (c5 != null) {
                            Y4.c0(C2048f.c.OUTDATED);
                            if (m3.m.p(this.f19510a.getPackageName(), c5.h(), true)) {
                                z4 = true;
                            }
                            c(c5, Y4, this.f19510a);
                            arrayList.add(c5);
                        }
                    }
                }
            }
        } else {
            z4 = false;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("partialUpdates");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                optJSONArray2.getJSONObject(i5);
            }
        }
        Iterator it = a5.F0().iterator();
        kotlin.jvm.internal.m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.d(next, "next(...)");
            S s4 = (S) next;
            Iterator it2 = arrayList.iterator();
            kotlin.jvm.internal.m.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    a5.R(s4.h());
                    break;
                }
                Object next2 = it2.next();
                kotlin.jvm.internal.m.d(next2, "next(...)");
                if (m3.m.p(s4.h(), ((S) next2).h(), true)) {
                    break;
                }
            }
        }
        a5.i();
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        if (!aVar.h0(this.f19510a)) {
            if (aVar.W(this.f19510a) || m3.m.p(aVar.m(this.f19510a), "2", true)) {
                f();
            } else {
                C2313C.f21882a.F(this.f19510a);
                UploadFileWorker.f19521c.a(this.f19510a);
            }
            if (z4) {
                a5.a();
                String packageName = this.f19510a.getPackageName();
                kotlin.jvm.internal.m.d(packageName, "getPackageName(...)");
                S D02 = a5.D0(packageName);
                a5.i();
                String str = null;
                if (D02 != null) {
                    sVar = D02.a();
                } else {
                    sVar = null;
                }
                if (sVar == null || !sVar.f()) {
                    UptodownApp.f17422D.B().send(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, (Bundle) null);
                    return;
                }
                C2034B a6 = C2034B.f20333g.a(this.f19510a);
                if (a6 != null) {
                    str = a6.e();
                }
                if (str != null && !sVar.o().isEmpty() && ((C2060s.c) sVar.o().get(0)).a() != null && sVar.f()) {
                    String a7 = ((C2060s.c) sVar.o().get(0)).a();
                    kotlin.jvm.internal.m.b(a7);
                    File file = new File(a7);
                    if (file.exists()) {
                        String e5 = a6.e();
                        kotlin.jvm.internal.m.b(e5);
                        if (System.currentTimeMillis() - Long.parseLong(e5) > 604800000) {
                            C2313C.f21882a.B(this.f19510a, new q().t(file, this.f19510a));
                        }
                    }
                }
            }
        } else if (z4) {
            e();
        }
    }

    /* access modifiers changed from: private */
    public final Object k(Context context, d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(context, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0249 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0297 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02ae A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02ff A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0190 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c0 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ca A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e8 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ff A[Catch:{ Exception -> 0x0021 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void l() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "error"
            java.lang.String r2 = "sha256Status"
            com.uptodown.UptodownApp$a r3 = com.uptodown.UptodownApp.f17422D     // Catch:{ Exception -> 0x0021 }
            h2.j r4 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r5 = 600(0x258, float:8.41E-43)
            r6 = 0
            r4.send(r5, r6)     // Catch:{ Exception -> 0x0021 }
            u2.x r4 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r5 = "start"
            java.lang.String r7 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            java.lang.String r8 = "currentTag"
            if (r7 != 0) goto L_0x0024
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r7 = r6
            goto L_0x0024
        L_0x0021:
            r0 = move-exception
            goto L_0x0349
        L_0x0024:
            java.lang.String r7 = r1.g(r7)     // Catch:{ Exception -> 0x0021 }
            r4.f(r5, r6, r6, r7)     // Catch:{ Exception -> 0x0021 }
            o3.G r4 = o3.Y.b()     // Catch:{ Exception -> 0x0021 }
            o3.J r9 = o3.K.a(r4)     // Catch:{ Exception -> 0x0021 }
            com.uptodown.workers.TrackingWorker$c r12 = new com.uptodown.workers.TrackingWorker$c     // Catch:{ Exception -> 0x0021 }
            r12.<init>(r1, r6)     // Catch:{ Exception -> 0x0021 }
            r13 = 3
            r14 = 0
            r10 = 0
            r11 = 0
            o3.C1001s0 unused = o3.C0981i.d(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0021 }
            g2.r r4 = new g2.r     // Catch:{ Exception -> 0x0021 }
            r4.<init>()     // Catch:{ Exception -> 0x0021 }
            h2.d$a r5 = h2.C2072d.f20844a     // Catch:{ Exception -> 0x0021 }
            r5.a()     // Catch:{ Exception -> 0x0021 }
            u2.L r5 = new u2.L     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r5.<init>(r7, r6)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r4.k(r7)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = r4.a()     // Catch:{ Exception -> 0x0021 }
            com.uptodown.activities.preferences.a$a r9 = com.uptodown.activities.preferences.a.f18818a     // Catch:{ Exception -> 0x0021 }
            android.content.Context r10 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = r9.l(r10)     // Catch:{ Exception -> 0x0021 }
            r11 = 1
            boolean r12 = m3.m.p(r7, r10, r11)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x006a
            r12 = 0
            goto L_0x00d0
        L_0x006a:
            java.lang.String r12 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r12)     // Catch:{ Exception -> 0x0021 }
            g2.L r12 = r5.u(r12)     // Catch:{ Exception -> 0x0021 }
            u2.x r15 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r14 = "getDevice"
            java.lang.String r13 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r13 != 0) goto L_0x0081
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r13 = r6
        L_0x0081:
            java.lang.String r13 = r1.g(r13)     // Catch:{ Exception -> 0x0021 }
            r15.f(r14, r6, r12, r13)     // Catch:{ Exception -> 0x0021 }
            boolean r13 = r5.h(r12)     // Catch:{ Exception -> 0x0021 }
            if (r13 == 0) goto L_0x00b9
            int r13 = r12.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 != r14) goto L_0x00b9
            android.content.Context r13 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r13 = r9.Q(r13)     // Catch:{ Exception -> 0x0021 }
            if (r13 != 0) goto L_0x00ac
            android.content.Context r13 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r9.C0(r13, r11)     // Catch:{ Exception -> 0x0021 }
            h2.j r13 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r14 = 603(0x25b, float:8.45E-43)
            r13.send(r14, r6)     // Catch:{ Exception -> 0x0021 }
        L_0x00ac:
            java.lang.String r12 = r12.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r12)     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r4.b(r12)     // Catch:{ Exception -> 0x0021 }
            r12 = r12 ^ r11
            goto L_0x00d0
        L_0x00b9:
            int r13 = r12.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r13 != r14) goto L_0x0345
            android.content.Context r12 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r9.Q(r12)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x00cf
            android.content.Context r12 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r13 = 0
            r9.C0(r12, r13)     // Catch:{ Exception -> 0x0021 }
        L_0x00cf:
            r12 = 1
        L_0x00d0:
            java.lang.String r13 = "success"
            if (r12 == 0) goto L_0x0137
            boolean r10 = r1.f19511b     // Catch:{ Exception -> 0x0021 }
            g2.L r10 = r5.X0(r4, r10)     // Catch:{ Exception -> 0x0021 }
            u2.x r12 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r14 = "saveDevice"
            java.lang.String r15 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r15 != 0) goto L_0x00e6
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r15 = r6
        L_0x00e6:
            java.lang.String r15 = r1.g(r15)     // Catch:{ Exception -> 0x0021 }
            r12.f(r14, r6, r10, r15)     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r5.h(r10)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x0133
            java.lang.String r12 = r10.d()     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x0102
            int r12 = r12.length()     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x0100
            goto L_0x0102
        L_0x0100:
            r12 = 0
            goto L_0x0103
        L_0x0102:
            r12 = 1
        L_0x0103:
            if (r12 != 0) goto L_0x0133
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = r10.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r10)     // Catch:{ Exception -> 0x0021 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0021 }
            int r10 = r12.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r10 != r11) goto L_0x034c
            android.content.Context r10 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r9.B0(r10, r7)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r9.Q(r7)     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x013e
            android.content.Context r7 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r9.C0(r7, r11)     // Catch:{ Exception -> 0x0021 }
            h2.j r3 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r14 = 603(0x25b, float:8.45E-43)
            r3.send(r14, r6)     // Catch:{ Exception -> 0x0021 }
            goto L_0x013e
        L_0x0133:
            r1.d(r10)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0137:
            if (r10 != 0) goto L_0x013e
            android.content.Context r3 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r9.B0(r3, r7)     // Catch:{ Exception -> 0x0021 }
        L_0x013e:
            u2.m r3 = new u2.m     // Catch:{ Exception -> 0x0021 }
            r3.<init>()     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r3 = r3.B(r7)     // Catch:{ Exception -> 0x0021 }
            u2.m r7 = new u2.m     // Catch:{ Exception -> 0x0021 }
            r7.<init>()     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r3 = r7.g(r3)     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r3.isEmpty()     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x031d
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            g2.L r0 = r5.f0(r0)     // Catch:{ Exception -> 0x0021 }
            u2.x r7 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = "getStatus"
            java.lang.String r12 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x016f
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x016f:
            java.lang.String r12 = r1.g(r12)     // Catch:{ Exception -> 0x0021 }
            r7.f(r10, r6, r0, r12)     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r0.b()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = "data"
            if (r7 != 0) goto L_0x01b5
            java.lang.String r7 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r7 == 0) goto L_0x018d
            int r7 = r7.length()     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x018b
            goto L_0x018d
        L_0x018b:
            r7 = 0
            goto L_0x018e
        L_0x018d:
            r7 = 1
        L_0x018e:
            if (r7 != 0) goto L_0x01b5
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r7.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != r11) goto L_0x034c
            org.json.JSONObject r0 = r7.optJSONObject(r10)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x01b3
            boolean r7 = r0.isNull(r2)     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x01b3
            java.lang.String r0 = r0.optString(r2)     // Catch:{ Exception -> 0x0021 }
            goto L_0x01be
        L_0x01b3:
            r0 = r6
            goto L_0x01be
        L_0x01b5:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x0319
            goto L_0x01b3
        L_0x01be:
            if (r0 == 0) goto L_0x01ca
            u2.m r2 = new u2.m     // Catch:{ Exception -> 0x0021 }
            r2.<init>()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = r2.o(r3)     // Catch:{ Exception -> 0x0021 }
            goto L_0x01cb
        L_0x01ca:
            r2 = r6
        L_0x01cb:
            if (r2 == 0) goto L_0x01d3
            boolean r0 = kotlin.jvm.internal.m.a(r2, r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x0213
        L_0x01d3:
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r1.f19511b     // Catch:{ Exception -> 0x0021 }
            g2.L r0 = r5.Y0(r3, r0, r2)     // Catch:{ Exception -> 0x0021 }
            u2.x r2 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = "saveTracking"
            java.lang.String r12 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x01ec
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x01ec:
            java.lang.String r12 = r1.g(r12)     // Catch:{ Exception -> 0x0021 }
            r2.f(r7, r6, r0, r12)     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r5.h(r0)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x02ff
            java.lang.String r2 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x02ff
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r2.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x0213
            goto L_0x034c
        L_0x0213:
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            g2.L r0 = r5.o0(r0)     // Catch:{ Exception -> 0x0021 }
            u2.x r2 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = "getUpdates"
            java.lang.String r12 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x022a
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x022a:
            java.lang.String r8 = r1.g(r12)     // Catch:{ Exception -> 0x0021 }
            r2.f(r7, r6, r0, r8)     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r5.h(r0)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0265
            java.lang.String r2 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0246
            int r2 = r2.length()     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            r15 = 0
            goto L_0x0247
        L_0x0246:
            r15 = 1
        L_0x0247:
            if (r15 != 0) goto L_0x0265
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r0)     // Catch:{ Exception -> 0x0021 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r2.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != r11) goto L_0x034c
            org.json.JSONArray r0 = r2.optJSONArray(r10)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x028f
            r1.i(r0)     // Catch:{ Exception -> 0x0021 }
            goto L_0x028f
        L_0x0265:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x02fb
            u2.t$a r0 = u2.t.f21927u     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            u2.t r0 = r0.a(r2)     // Catch:{ Exception -> 0x0021 }
            r0.a()     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r2 = r0.F0()     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x0285
            r0.S()     // Catch:{ Exception -> 0x0021 }
        L_0x0285:
            r0.i()     // Catch:{ Exception -> 0x0021 }
            com.uptodown.workers.UploadFileWorker$a r0 = com.uptodown.workers.UploadFileWorker.f19521c     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r0.a(r2)     // Catch:{ Exception -> 0x0021 }
        L_0x028f:
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.h0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x02a6
            b2.n r0 = new b2.n     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            o3.G r5 = o3.Y.b()     // Catch:{ Exception -> 0x0021 }
            o3.J r5 = o3.K.a(r5)     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r3, r2, r5)     // Catch:{ Exception -> 0x0021 }
        L_0x02a6:
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.h0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x02f3
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.e0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x02c2
            g2.P r0 = new g2.P     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r0.k(r2, r4)     // Catch:{ Exception -> 0x0021 }
        L_0x02c2:
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            long r2 = r9.q(r0)     // Catch:{ Exception -> 0x0021 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0021 }
            r0 = 7200000(0x6ddd00, float:1.0089349E-38)
            long r7 = (long) r0     // Catch:{ Exception -> 0x0021 }
            long r2 = r2 + r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x02e4
            b2.c r0 = new b2.c     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            o3.G r3 = o3.Y.b()     // Catch:{ Exception -> 0x0021 }
            o3.J r3 = o3.K.a(r3)     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2, r6, r3)     // Catch:{ Exception -> 0x0021 }
        L_0x02e4:
            b2.b r0 = new b2.b     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            o3.G r3 = o3.Y.b()     // Catch:{ Exception -> 0x0021 }
            o3.J r3 = o3.K.a(r3)     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0021 }
        L_0x02f3:
            b2.t r0 = new b2.t     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x02fb:
            r1.d(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x02ff:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x0315
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r9.B0(r0, r6)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r0 = r1.f19510a     // Catch:{ Exception -> 0x0021 }
            r13 = 0
            r9.C0(r0, r13)     // Catch:{ Exception -> 0x0021 }
            r1.f19512c = r11     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0315:
            r1.d(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0319:
            r1.d(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x031d:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x0021 }
            r2.<init>()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = "identifier"
            java.lang.String r4 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x0021 }
            r2.putString(r3, r4)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = "noApps"
            r2.putString(r0, r3)     // Catch:{ Exception -> 0x0021 }
            u2.x r3 = r1.f19514e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r4 = r1.f19513d     // Catch:{ Exception -> 0x0021 }
            if (r4 != 0) goto L_0x033d
            kotlin.jvm.internal.m.u(r8)     // Catch:{ Exception -> 0x0021 }
            r4 = r6
        L_0x033d:
            java.lang.String r4 = r1.g(r4)     // Catch:{ Exception -> 0x0021 }
            r3.f(r0, r2, r6, r4)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0345:
            r1.d(r12)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0349:
            r0.printStackTrace()
        L_0x034c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.l():void");
    }

    public ListenableWorker.Result doWork() {
        if (getRunAttemptCount() > 3) {
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            kotlin.jvm.internal.m.d(failure, "failure(...)");
            return failure;
        }
        String str = this.f19513d;
        if (str == null) {
            kotlin.jvm.internal.m.u("currentTag");
            str = null;
        }
        if (m3.m.p(str, "TrackingWorkerPeriodic", true)) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.T("TrackingWorkerSingle", this.f19510a) || aVar.T("GenerateQueueWorker", this.f19510a) || aVar.T("DownloadUpdatesWorker", this.f19510a)) {
                ListenableWorker.Result success = ListenableWorker.Result.success();
                kotlin.jvm.internal.m.d(success, "success(...)");
                return success;
            }
        } else {
            String str2 = this.f19513d;
            if (str2 == null) {
                kotlin.jvm.internal.m.u("currentTag");
                str2 = null;
            }
            if (m3.m.p(str2, "TrackingWorkerSingle", true)) {
                UptodownApp.a aVar2 = UptodownApp.f17422D;
                if (aVar2.T("TrackingWorkerPeriodic", this.f19510a) || aVar2.T("GenerateQueueWorker", this.f19510a) || aVar2.T("DownloadUpdatesWorker", this.f19510a)) {
                    ListenableWorker.Result success2 = ListenableWorker.Result.success();
                    kotlin.jvm.internal.m.d(success2, "success(...)");
                    return success2;
                }
            }
        }
        if (new G(this.f19510a).b()) {
            UptodownApp.a aVar3 = UptodownApp.f17422D;
            aVar3.B().send(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, (Bundle) null);
            if (!aVar3.K()) {
                ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
                kotlin.jvm.internal.m.d(failure2, "failure(...)");
                return failure2;
            }
        }
        k.f7778g.b();
        a.C0236a aVar4 = com.uptodown.activities.preferences.a.f18818a;
        if (!aVar4.j0(this.f19510a) && aVar4.i0(this.f19510a)) {
            l();
            if (this.f19512c) {
                ListenableWorker.Result retry = ListenableWorker.Result.retry();
                kotlin.jvm.internal.m.d(retry, "retry(...)");
                return retry;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("newUpdatesAvailable", this.f19515f);
        bundle.putInt("newUpdatesAvailableCount", this.f19516g);
        UptodownApp.f17422D.B().send(601, bundle);
        aVar4.T0(this.f19510a, System.currentTimeMillis());
        ListenableWorker.Result success3 = ListenableWorker.Result.success();
        kotlin.jvm.internal.m.d(success3, "success(...)");
        return success3;
    }
}
