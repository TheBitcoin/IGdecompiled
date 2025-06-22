package androidx.lifecycle;

import V2.g;
import V2.h;
import d3.a;
import d3.p;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.K;
import o3.P0;
import o3.Y;

public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    /* access modifiers changed from: private */
    public BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineLiveData(g gVar, long j4, p pVar, int i4, C2103g gVar2) {
        this((i4 & 1) != 0 ? h.f8445a : gVar, (i4 & 2) != 0 ? 5000 : j4, pVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearSource$lifecycle_livedata_release(V2.d r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r0 = (androidx.lifecycle.CoroutineLiveData) r0
            R2.n.b(r5)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            R2.n.b(r5)
            androidx.lifecycle.EmittedSource r5 = r4.emittedSource
            if (r5 == 0) goto L_0x0047
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.disposeNow(r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r4
        L_0x0048:
            r5 = 0
            r0.emittedSource = r5
            R2.s r5 = R2.s.f8222a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.clearSource$lifecycle_livedata_release(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r7 != r1) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emitSource$lifecycle_livedata_release(androidx.lifecycle.LiveData<T> r6, V2.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r6 = (androidx.lifecycle.CoroutineLiveData) r6
            R2.n.b(r7)
            goto L_0x0066
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.L$1
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            java.lang.Object r2 = r0.L$0
            androidx.lifecycle.CoroutineLiveData r2 = (androidx.lifecycle.CoroutineLiveData) r2
            R2.n.b(r7)
            r7 = r6
            r6 = r2
            goto L_0x0058
        L_0x0046:
            R2.n.b(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.clearSource$lifecycle_livedata_release(r0)
            if (r7 != r1) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            r7 = r6
            r6 = r5
        L_0x0058:
            r0.L$0 = r6
            r2 = 0
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource(r6, r7, r0)
            if (r7 != r1) goto L_0x0066
        L_0x0065:
            return r1
        L_0x0066:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r6.emittedSource = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.emitSource$lifecycle_livedata_release(androidx.lifecycle.LiveData, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.maybeRun();
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.cancel();
        }
    }

    public CoroutineLiveData(g gVar, long j4, p pVar) {
        m.e(gVar, "context");
        m.e(pVar, "block");
        long j5 = j4;
        p pVar2 = pVar;
        this.blockRunner = new BlockRunner<>(this, pVar2, j5, K.a(Y.c().D().plus(gVar).plus(P0.a((C1001s0) gVar.get(C1001s0.f3726k0)))), new a(this) {
            final /* synthetic */ CoroutineLiveData<T> this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.blockRunner = null;
            }
        });
    }
}
