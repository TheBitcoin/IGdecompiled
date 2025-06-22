package androidx.slidingpanelayout.widget;

import R2.s;
import V2.d;
import W2.b;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.FoldingFeature;
import r3.C1036f;

public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 implements C1036f {
    final /* synthetic */ FoldingFeatureObserver this$0;

    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(FoldingFeatureObserver foldingFeatureObserver) {
        this.this$0 = foldingFeatureObserver;
    }

    public Object emit(FoldingFeature foldingFeature, d dVar) {
        s sVar;
        FoldingFeature foldingFeature2 = foldingFeature;
        FoldingFeatureObserver.OnFoldingFeatureChangeListener access$getOnFoldingFeatureChangeListener$p = this.this$0.onFoldingFeatureChangeListener;
        if (access$getOnFoldingFeatureChangeListener$p == null) {
            sVar = null;
        } else {
            access$getOnFoldingFeatureChangeListener$p.onFoldingFeatureChange(foldingFeature2);
            sVar = s.f8222a;
        }
        if (sVar == b.c()) {
            return sVar;
        }
        return s.f8222a;
    }
}
