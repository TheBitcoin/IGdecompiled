package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import d3.a;
import d3.l;
import kotlin.jvm.internal.m;

public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {
    final /* synthetic */ a $onBackCancelled;
    final /* synthetic */ a $onBackInvoked;
    final /* synthetic */ l $onBackProgressed;
    final /* synthetic */ l $onBackStarted;

    OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(l lVar, l lVar2, a aVar, a aVar2) {
        this.$onBackStarted = lVar;
        this.$onBackProgressed = lVar2;
        this.$onBackInvoked = aVar;
        this.$onBackCancelled = aVar2;
    }

    public void onBackCancelled() {
        this.$onBackCancelled.invoke();
    }

    public void onBackInvoked() {
        this.$onBackInvoked.invoke();
    }

    public void onBackProgressed(BackEvent backEvent) {
        m.e(backEvent, "backEvent");
        this.$onBackProgressed.invoke(new BackEventCompat(backEvent));
    }

    public void onBackStarted(BackEvent backEvent) {
        m.e(backEvent, "backEvent");
        this.$onBackStarted.invoke(new BackEventCompat(backEvent));
    }
}
