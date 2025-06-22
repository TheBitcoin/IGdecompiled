package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import q3.s;

public final /* synthetic */ class m implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f784a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f785b;

    public /* synthetic */ m(s sVar, View view) {
        this.f784a = sVar;
        this.f785b = view;
    }

    public final void onScrollChanged() {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(this.f784a, this.f785b);
    }
}
