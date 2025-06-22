package androidx.lifecycle;

import V2.d;
import V2.g;
import V2.h;
import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import d3.p;
import j$.time.Duration;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;
import r3.I;

public final class FlowLiveDataConversions {
    public static final <T> C1035e asFlow(LiveData<T> liveData) {
        m.e(liveData, "<this>");
        return C1037g.j(C1037g.d(new FlowLiveDataConversions$asFlow$1(liveData, (d) null)));
    }

    public static final <T> LiveData<T> asLiveData(C1035e eVar) {
        m.e(eVar, "<this>");
        return asLiveData$default(eVar, (g) null, 0, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(C1035e eVar, g gVar, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = h.f8445a;
        }
        if ((i4 & 2) != 0) {
            j4 = 5000;
        }
        return asLiveData(eVar, gVar, j4);
    }

    public static final <T> LiveData<T> asLiveData(C1035e eVar, g gVar) {
        m.e(eVar, "<this>");
        m.e(gVar, "context");
        return asLiveData$default(eVar, gVar, 0, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(C1035e eVar, g gVar, long j4) {
        m.e(eVar, "<this>");
        m.e(gVar, "context");
        LiveData<T> liveData = CoroutineLiveDataKt.liveData(gVar, j4, (p) new FlowLiveDataConversions$asLiveData$1(eVar, (d) null));
        if (eVar instanceof I) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                liveData.setValue(((I) eVar).getValue());
                return liveData;
            }
            liveData.postValue(((I) eVar).getValue());
        }
        return liveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(C1035e eVar, Duration duration, g gVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            gVar = h.f8445a;
        }
        return asLiveData(eVar, duration, gVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(C1035e eVar, Duration duration, g gVar) {
        m.e(eVar, "<this>");
        m.e(duration, "timeout");
        m.e(gVar, "context");
        return asLiveData(eVar, gVar, Api26Impl.INSTANCE.toMillis(duration));
    }
}
