package androidx.core.view;

import android.view.View;
import d3.l;

public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ l $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(l lVar) {
        this.$action$inlined = lVar;
    }

    public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        view.removeOnLayoutChangeListener(this);
        this.$action$inlined.invoke(view);
    }
}
