package com.uptodown.workers;

import N1.k;
import S1.h;
import W1.G;
import W1.j;
import W1.s;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
import u2.t;
import u2.v;
import u2.x;

public final class InstallUpdatesWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19479b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f19480a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            if (!UptodownApp.f17422D.U("InstallUpdatesWorker", context)) {
                WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(InstallUpdatesWorker.class).addTag("InstallUpdatesWorker")).build());
            }
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstallUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19480a = context;
        this.f19480a = k.f7778g.a(context);
    }

    private final boolean a(Context context) {
        boolean z4;
        boolean z5;
        boolean W4 = com.uptodown.activities.preferences.a.f18818a.W(context);
        if (!new u2.m().y(context) || W4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (k.f7778g.i() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean e5 = new v().e(context);
        if (!z5 || !z4 || e5) {
            return false;
        }
        return true;
    }

    private final boolean b(Context context, C2048f fVar) {
        if (m3.m.p(context.getPackageName(), fVar.o(), true) || (fVar.e() == 0 && fVar.C(context))) {
            return true;
        }
        return false;
    }

    public ListenableWorker.Result doWork() {
        PackageInfo packageInfo;
        C2048f Y4;
        C2060s a5;
        if (a(this.f19480a)) {
            t.a aVar = t.f21927u;
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            t a6 = aVar.a(applicationContext);
            a6.a();
            ArrayList F02 = a6.F0();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = F02.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                S s4 = (S) next;
                if (!s4.m() && (Y4 = a6.Y(s4.h())) != null && b(this.f19480a, Y4) && (a5 = s4.a()) != null && a5.f()) {
                    arrayList.add(s4);
                    arrayList2.add(a5);
                }
            }
            a6.i();
            boolean y4 = new u2.m().y(this.f19480a);
            Iterator it2 = arrayList2.iterator();
            m.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                C2060s sVar = (C2060s) next2;
                if (com.uptodown.activities.preferences.a.f18818a.W(this.f19480a)) {
                    if (sVar.o().size() == 1 && ((C2060s.c) sVar.o().get(0)).a() != null) {
                        String a7 = ((C2060s.c) sVar.o().get(0)).a();
                        m.b(a7);
                        File file = new File(a7);
                        if (file.exists()) {
                            UptodownApp.a.W(UptodownApp.f17422D, file, this.f19480a, (String) null, 4, (Object) null);
                            break;
                        }
                    }
                } else if (!y4) {
                    try {
                        PackageManager packageManager = this.f19480a.getPackageManager();
                        m.d(packageManager, "getPackageManager(...)");
                        String w4 = sVar.w();
                        m.b(w4);
                        packageInfo = s.d(packageManager, w4, 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        j jVar = new j(this.f19480a, (h) null);
                        if (jVar.A(packageInfo.applicationInfo.targetSdkVersion)) {
                            String packageName = this.f19480a.getPackageName();
                            u2.m mVar = new u2.m();
                            Context context = this.f19480a;
                            String w5 = sVar.w();
                            m.b(w5);
                            if (m.a(packageName, mVar.h(context, w5))) {
                                ArrayList arrayList3 = new ArrayList();
                                Iterator it3 = sVar.o().iterator();
                                m.d(it3, "iterator(...)");
                                while (it3.hasNext()) {
                                    Object next3 = it3.next();
                                    m.d(next3, "next(...)");
                                    C2060s.c cVar = (C2060s.c) next3;
                                    if (cVar.a() != null) {
                                        String a8 = cVar.a();
                                        m.b(a8);
                                        arrayList3.add(new File(a8));
                                    }
                                }
                                if (arrayList3.size() == 1) {
                                    G.a aVar2 = G.f8470b;
                                    String absolutePath = ((File) arrayList3.get(0)).getAbsolutePath();
                                    m.d(absolutePath, "getAbsolutePath(...)");
                                    if (aVar2.a(absolutePath)) {
                                        UptodownApp.a aVar3 = UptodownApp.f17422D;
                                        Object obj = arrayList3.get(0);
                                        m.d(obj, "get(...)");
                                        UptodownApp.a.W(aVar3, (File) obj, this.f19480a, (String) null, 4, (Object) null);
                                    }
                                }
                                j.x(jVar, arrayList3, false, 2, (Object) null);
                                Bundle bundle = new Bundle();
                                bundle.putString("type", "start");
                                new x(this.f19480a).d("install", bundle);
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            ListenableWorker.Result success = ListenableWorker.Result.success();
            m.d(success, "success(...)");
            return success;
        }
        C2313C.f21882a.F(this.f19480a);
        UploadFileWorker.f19521c.a(this.f19480a);
        ListenableWorker.Result success2 = ListenableWorker.Result.success();
        m.d(success2, "success(...)");
        return success2;
    }
}
