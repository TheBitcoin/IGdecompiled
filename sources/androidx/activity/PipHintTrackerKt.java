package androidx.activity;

import R2.s;
import V2.d;
import W2.b;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import r3.C1037g;

public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(Activity activity, View view, d dVar) {
        Object collect = C1037g.d(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, (d) null)).collect(new PipHintTrackerKt$trackPipAnimationHintView$2(activity), dVar);
        if (collect == b.c()) {
            return collect;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
