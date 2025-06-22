package x;

import android.app.job.JobInfo;
import androidx.work.WorkRequest;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import x.C1083c;

public abstract class f {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private A.a f4623a;

        /* renamed from: b  reason: collision with root package name */
        private Map f4624b = new HashMap();

        public a a(o.f fVar, b bVar) {
            this.f4624b.put(fVar, bVar);
            return this;
        }

        public f b() {
            if (this.f4623a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f4624b.keySet().size() >= o.f.values().length) {
                Map map = this.f4624b;
                this.f4624b = new HashMap();
                return f.d(this.f4623a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }

        public a c(A.a aVar) {
            this.f4623a = aVar;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j4);

            public abstract a c(Set set);

            public abstract a d(long j4);
        }

        public static a a() {
            return new C1083c.b().c(Collections.EMPTY_SET);
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set c();

        /* access modifiers changed from: package-private */
        public abstract long d();
    }

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i4, long j4) {
        long j5;
        int i5 = i4 - 1;
        if (j4 > 1) {
            j5 = j4;
        } else {
            j5 = 2;
        }
        return (long) (Math.pow(3.0d, (double) i5) * ((double) j4) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) (j5 * ((long) i5)))));
    }

    public static a b() {
        return new a();
    }

    static f d(A.a aVar, Map map) {
        return new C1082b(aVar, map);
    }

    public static f f(A.a aVar) {
        return b().a(o.f.DEFAULT, b.a().b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).d(86400000).a()).a(o.f.HIGHEST, b.a().b(1000).d(86400000).a()).a(o.f.VERY_LOW, b.a().b(86400000).d(86400000).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static Set i(Object... objArr) {
        return DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, o.f fVar, long j4, int i4) {
        builder.setMinimumLatency(g(fVar, j4, i4));
        j(builder, ((b) h().get(fVar)).c());
        return builder;
    }

    /* access modifiers changed from: package-private */
    public abstract A.a e();

    public long g(o.f fVar, long j4, int i4) {
        long a5 = j4 - e().a();
        b bVar = (b) h().get(fVar);
        return Math.min(Math.max(a(i4, bVar.b()), a5), bVar.d());
    }

    /* access modifiers changed from: package-private */
    public abstract Map h();
}
