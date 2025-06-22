package q3;

import d3.l;
import d3.p;
import k3.e;
import kotlin.jvm.internal.k;
import o3.C0989m;
import t3.F;

public abstract class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final j f4067a = new j(-1, (j) null, (b) null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f4068b = I.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f4069c = I.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final F f4070d = new F("BUFFERED");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final F f4071e = new F("SHOULD_BUFFER");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final F f4072f = new F("S_RESUMING_BY_RCV");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final F f4073g = new F("RESUMING_BY_EB");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final F f4074h = new F("POISONED");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final F f4075i = new F("DONE_RCV");
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final F f4076j = new F("INTERRUPTED_SEND");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final F f4077k = new F("INTERRUPTED_RCV");

    /* renamed from: l  reason: collision with root package name */
    private static final F f4078l = new F("CHANNEL_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final F f4079m = new F("SUSPEND");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final F f4080n = new F("SUSPEND_NO_WAITER");
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final F f4081o = new F("FAILED");
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final F f4082p = new F("NO_RECEIVE_RESULT");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final F f4083q = new F("CLOSE_HANDLER_CLOSED");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final F f4084r = new F("CLOSE_HANDLER_INVOKED");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final F f4085s = new F("NO_CLOSE_CAUSE");

    /* synthetic */ class a extends k implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4086a = new a();

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final j d(long j4, j jVar) {
            return c.x(j4, jVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (j) obj2);
        }
    }

    /* access modifiers changed from: private */
    public static final long A(int i4) {
        if (i4 == 0) {
            return 0;
        }
        if (i4 != Integer.MAX_VALUE) {
            return (long) i4;
        }
        return Long.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static final boolean B(C0989m mVar, Object obj, l lVar) {
        Object b5 = mVar.b(obj, (Object) null, lVar);
        if (b5 == null) {
            return false;
        }
        mVar.D(b5);
        return true;
    }

    static /* synthetic */ boolean C(C0989m mVar, Object obj, l lVar, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            lVar = null;
        }
        return B(mVar, obj, lVar);
    }

    /* access modifiers changed from: private */
    public static final long v(long j4, boolean z4) {
        long j5;
        if (z4) {
            j5 = 4611686018427387904L;
        } else {
            j5 = 0;
        }
        return j5 + j4;
    }

    /* access modifiers changed from: private */
    public static final long w(long j4, int i4) {
        return (((long) i4) << 60) + j4;
    }

    /* access modifiers changed from: private */
    public static final j x(long j4, j jVar) {
        return new j(j4, jVar, jVar.u(), 0);
    }

    public static final e y() {
        return a.f4086a;
    }

    public static final F z() {
        return f4078l;
    }
}
