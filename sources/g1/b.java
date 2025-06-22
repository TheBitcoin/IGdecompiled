package G1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.m;

public abstract class b extends FrameLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        if (getLayoutParams().height == -2) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i4) * 9) / 16, 1073741824));
        } else {
            super.onMeasure(i4, i5);
        }
    }
}
