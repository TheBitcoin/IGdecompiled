package k0;

import M.C0335p;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: k0.o  reason: case insensitive filesystem */
public abstract class C0940o {
    public static Object a(C0937l lVar) {
        C0335p.j();
        C0335p.h();
        C0335p.m(lVar, "Task must not be null");
        if (lVar.m()) {
            return h(lVar);
        }
        r rVar = new r((q) null);
        i(lVar, rVar);
        rVar.c();
        return h(lVar);
    }

    public static Object b(C0937l lVar, long j4, TimeUnit timeUnit) {
        C0335p.j();
        C0335p.h();
        C0335p.m(lVar, "Task must not be null");
        C0335p.m(timeUnit, "TimeUnit must not be null");
        if (lVar.m()) {
            return h(lVar);
        }
        r rVar = new r((q) null);
        i(lVar, rVar);
        if (rVar.e(j4, timeUnit)) {
            return h(lVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static C0937l c(Executor executor, Callable callable) {
        C0335p.m(executor, "Executor must not be null");
        C0335p.m(callable, "Callback must not be null");
        O o4 = new O();
        executor.execute(new P(o4, callable));
        return o4;
    }

    public static C0937l d(Exception exc) {
        O o4 = new O();
        o4.q(exc);
        return o4;
    }

    public static C0937l e(Object obj) {
        O o4 = new O();
        o4.r(obj);
        return o4;
    }

    public static C0937l f(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return e((Object) null);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((C0937l) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        O o4 = new O();
        t tVar = new t(collection.size(), o4);
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            i((C0937l) it2.next(), tVar);
        }
        return o4;
    }

    public static C0937l g(C0937l... lVarArr) {
        if (lVarArr == null || lVarArr.length == 0) {
            return e((Object) null);
        }
        return f(Arrays.asList(lVarArr));
    }

    private static Object h(C0937l lVar) {
        if (lVar.n()) {
            return lVar.j();
        }
        if (lVar.l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(lVar.i());
    }

    private static void i(C0937l lVar, s sVar) {
        Executor executor = C0939n.f3497b;
        lVar.f(executor, sVar);
        lVar.d(executor, sVar);
        lVar.a(executor, sVar);
    }
}
