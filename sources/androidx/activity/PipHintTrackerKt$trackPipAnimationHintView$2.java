package androidx.activity;

import R2.s;
import V2.d;
import android.app.Activity;
import android.graphics.Rect;
import r3.C1036f;

final class PipHintTrackerKt$trackPipAnimationHintView$2<T> implements C1036f {
    final /* synthetic */ Activity $this_trackPipAnimationHintView;

    PipHintTrackerKt$trackPipAnimationHintView$2(Activity activity) {
        this.$this_trackPipAnimationHintView = activity;
    }

    public final Object emit(Rect rect, d dVar) {
        Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.$this_trackPipAnimationHintView, rect);
        return s.f8222a;
    }
}
