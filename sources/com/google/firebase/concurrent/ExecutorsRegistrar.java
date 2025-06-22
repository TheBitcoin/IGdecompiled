package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import r0.C2213a;
import r0.C2214b;
import r0.c;
import r0.d;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.x;
import t0.C2282c;
import t0.C2283d;
import t0.e;
import t0.f;
import t0.g;
import t0.h;
import t0.i;
import t0.j;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    static final x f11120a = new x(new C2282c());

    /* renamed from: b  reason: collision with root package name */
    static final x f11121b = new x(new C2283d());

    /* renamed from: c  reason: collision with root package name */
    static final x f11122c = new x(new e());

    /* renamed from: d  reason: collision with root package name */
    static final x f11123d = new x(new f());

    public static /* synthetic */ ScheduledExecutorService a(C2270e eVar) {
        return (ScheduledExecutorService) f11121b.get();
    }

    public static /* synthetic */ ScheduledExecutorService e(C2270e eVar) {
        return (ScheduledExecutorService) f11122c.get();
    }

    public static /* synthetic */ ScheduledExecutorService g(C2270e eVar) {
        return (ScheduledExecutorService) f11120a.get();
    }

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            StrictMode.ThreadPolicy.Builder unused = detectNetwork.detectResourceMismatches();
            if (i4 >= 26) {
                StrictMode.ThreadPolicy.Builder unused2 = detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i4) {
        return new b(str, i4, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory k(String str, int i4, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i4, threadPolicy);
    }

    private static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f11123d.get());
    }

    public List getComponents() {
        Class<C2213a> cls = C2213a.class;
        Class<ScheduledExecutorService> cls2 = ScheduledExecutorService.class;
        Class<ExecutorService> cls3 = ExecutorService.class;
        Class<Executor> cls4 = Executor.class;
        C2268c d5 = C2268c.f(C2264F.a(cls, cls2), C2264F.a(cls, cls3), C2264F.a(cls, cls4)).f(new g()).d();
        Class<C2214b> cls5 = C2214b.class;
        C2268c d6 = C2268c.f(C2264F.a(cls5, cls2), C2264F.a(cls5, cls3), C2264F.a(cls5, cls4)).f(new h()).d();
        Class<c> cls6 = c.class;
        return Arrays.asList(new C2268c[]{d5, d6, C2268c.f(C2264F.a(cls6, cls2), C2264F.a(cls6, cls3), C2264F.a(cls6, cls4)).f(new i()).d(), C2268c.e(C2264F.a(d.class, cls4)).f(new j()).d()});
    }
}
