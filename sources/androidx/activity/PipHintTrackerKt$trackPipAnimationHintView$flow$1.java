package androidx.activity;

import R2.n;
import V2.d;
import W2.b;
import android.view.View;
import d3.a;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import q3.q;
import q3.s;

@f(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends l implements p {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, d dVar) {
        super(2, dVar);
        this.$view = view;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i4 != i8 || i6 != i10 || i5 != i9 || i7 != i11) {
            sVar.B(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(s sVar, View view) {
        sVar.B(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    public final d create(Object obj, d dVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, dVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            s sVar = (s) this.L$0;
            final l lVar = new l(sVar);
            final m mVar = new m(sVar, this.$view);
            final PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(sVar, this.$view, mVar, lVar);
            if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view)) {
                sVar.B(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(mVar);
                this.$view.addOnLayoutChangeListener(lVar);
            }
            this.$view.addOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
            final View view = this.$view;
            AnonymousClass1 r5 = new a() {
                public final void invoke() {
                    view.getViewTreeObserver().removeOnScrollChangedListener(mVar);
                    view.removeOnLayoutChangeListener(lVar);
                    view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
                }
            };
            this.label = 1;
            if (q.a(sVar, r5, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return R2.s.f8222a;
    }

    public final Object invoke(s sVar, d dVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
