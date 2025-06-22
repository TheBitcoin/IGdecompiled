package com.uptodown.workers;

import N1.k;
import S2.C1601o;
import W1.C1612h;
import android.content.Context;
import android.os.Bundle;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.uptodown.UptodownApp;
import g2.C2048f;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.C2313C;
import u2.F;
import u2.t;
import u2.z;
import z2.b;

public final class GenerateQueueWorker extends Worker {

    /* renamed from: f  reason: collision with root package name */
    public static final a f19466f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f19467a = k.f7778g.a(this.f19467a);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19468b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19469c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19470d;

    /* renamed from: e  reason: collision with root package name */
    private String f19471e;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenerateQueueWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19467a = context;
        this.f19468b = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        this.f19469c = workerParameters.getInputData().getBoolean("downloadUptodown", false);
        this.f19470d = workerParameters.getInputData().getInt("downloadAutostartedInBackground", 0);
        this.f19471e = workerParameters.getInputData().getString("packagename");
    }

    private final void b(ArrayList arrayList) {
        if (!UptodownApp.f17422D.N(this.f19467a)) {
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", this.f19470d).putBoolean("downloadAnyway", this.f19468b).build();
            m.d(build, "build(...)");
            Class<DownloadUpdatesWorker> cls = DownloadUpdatesWorker.class;
            WorkManager.getInstance(this.f19467a).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(cls).addTag("DownloadUpdatesWorker")).setInputData(build)).build());
            if (arrayList.size() > 1) {
                WorkManager.getInstance(this.f19467a).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(cls).addTag("DownloadUpdatesWorker")).setInputData(build)).build());
            }
        }
    }

    private final void c(String str, boolean z4, Context context) {
        ArrayList arrayList;
        File n4;
        ArrayList arrayList2 = new ArrayList();
        t a5 = t.f21927u.a(context);
        a5.a();
        if (str != null) {
            arrayList = new ArrayList();
            S D02 = a5.D0(str);
            if (D02 != null) {
                arrayList.add(D02);
            }
        } else {
            arrayList = a5.F0();
        }
        String packageName = context.getPackageName();
        if (z4) {
            m.b(packageName);
            S D03 = a5.D0(packageName);
            if (D03 != null) {
                arrayList = new ArrayList();
                arrayList.add(D03);
            }
        }
        String m4 = com.uptodown.activities.preferences.a.f18818a.m(context);
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            S s4 = (S) next;
            C2048f A4 = new u2.m().A(context, s4.h());
            if (A4 != null && ((m3.m.p(packageName, A4.o(), true) || str != null || (A4.b() > 0 && A4.e() == 0 && A4.C(context) && e(A4, m4))) && !s4.m() && !new C1612h().p(context, s4.h()))) {
                C2060s b5 = s4.b(context);
                if (b5 == null || !b5.f() || (n4 = b5.n()) == null || !n4.exists()) {
                    arrayList2.add(A4);
                }
            }
        }
        a5.i();
        C1601o.t(arrayList2, new b());
        int size = arrayList2.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                if (m3.m.p(packageName, ((C2048f) arrayList2.get(i4)).o(), true) && ((C2048f) arrayList2.get(i4)).w() == C2048f.c.OUTDATED) {
                    Object obj = arrayList2.get(i4);
                    m.d(obj, "get(...)");
                    arrayList2.remove(i4);
                    arrayList2.add(0, (C2048f) obj);
                    break;
                }
                i4++;
            } else {
                break;
            }
        }
        UptodownApp.f17422D.L0(arrayList2);
    }

    /* access modifiers changed from: private */
    public static final int d(C2048f fVar, C2048f fVar2) {
        m.e(fVar, "app1");
        m.e(fVar2, "app2");
        if (fVar.m() == null) {
            return 1;
        }
        if (fVar2.m() == null) {
            return -1;
        }
        String m4 = fVar.m();
        m.b(m4);
        String m5 = fVar2.m();
        m.b(m5);
        return m3.m.j(m4, m5, true);
    }

    private final boolean e(C2048f fVar, String str) {
        String str2;
        if (m3.m.p(str, "2", true)) {
            if (fVar.o() != null) {
                u2.m mVar = new u2.m();
                Context context = this.f19467a;
                String o4 = fVar.o();
                m.b(o4);
                str2 = mVar.h(context, o4);
            } else {
                str2 = null;
            }
            if (str2 == null || !m3.m.p(str2, this.f19467a.getPackageName(), true)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public ListenableWorker.Result doWork() {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (!aVar.N(this.f19467a)) {
            c(this.f19471e, this.f19469c, this.f19467a);
            ArrayList E4 = aVar.E();
            if (E4 == null || E4.size() <= 0) {
                InstallUpdatesWorker.f19479b.a(this.f19467a);
            } else if (!com.uptodown.activities.preferences.a.f18818a.Z(this.f19467a)) {
                b(E4);
            } else if (z.f21956a.f() || this.f19468b) {
                b(E4);
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("apps_parcelable", E4);
                F.f21886a.g().send(105, bundle);
                C2313C.f21882a.F(this.f19467a);
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        return success;
    }
}
