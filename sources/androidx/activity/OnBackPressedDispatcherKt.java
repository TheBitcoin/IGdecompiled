package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import d3.l;
import kotlin.jvm.internal.m;

public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z4, l lVar) {
        m.e(onBackPressedDispatcher, "<this>");
        m.e(lVar, "onBackPressed");
        OnBackPressedDispatcherKt$addCallback$callback$1 onBackPressedDispatcherKt$addCallback$callback$1 = new OnBackPressedDispatcherKt$addCallback$callback$1(z4, lVar);
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedDispatcherKt$addCallback$callback$1);
            return onBackPressedDispatcherKt$addCallback$callback$1;
        }
        onBackPressedDispatcher.addCallback(onBackPressedDispatcherKt$addCallback$callback$1);
        return onBackPressedDispatcherKt$addCallback$callback$1;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z4, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i4 & 2) != 0) {
            z4 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z4, lVar);
    }
}
