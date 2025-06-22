package androidx.lifecycle;

import V2.d;
import V2.g;
import V2.h;
import androidx.annotation.RequiresApi;
import d3.p;
import j$.time.Duration;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.Y;

public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, d dVar) {
        return C0977g.g(Y.c().D(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, (d) null), dVar);
    }

    public static final <T> LiveData<T> liveData(g gVar, p pVar) {
        m.e(gVar, "context");
        m.e(pVar, "block");
        return liveData$default(gVar, 0, pVar, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(g gVar, long j4, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = h.f8445a;
        }
        if ((i4 & 2) != 0) {
            j4 = 5000;
        }
        return liveData(gVar, j4, pVar);
    }

    public static final <T> LiveData<T> liveData(p pVar) {
        m.e(pVar, "block");
        return liveData$default((g) null, 0, pVar, 3, (Object) null);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, p pVar) {
        m.e(duration, "timeout");
        m.e(pVar, "block");
        return liveData$default(duration, (g) null, pVar, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, g gVar, p pVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            gVar = h.f8445a;
        }
        return liveData(duration, gVar, pVar);
    }

    public static final <T> LiveData<T> liveData(g gVar, long j4, p pVar) {
        m.e(gVar, "context");
        m.e(pVar, "block");
        return new CoroutineLiveData(gVar, j4, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, g gVar, p pVar) {
        m.e(duration, "timeout");
        m.e(gVar, "context");
        m.e(pVar, "block");
        return new CoroutineLiveData(gVar, Api26Impl.INSTANCE.toMillis(duration), pVar);
    }
}
