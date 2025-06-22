package s2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.m;

/* renamed from: s2.b  reason: case insensitive filesystem */
public final class C2279b extends ImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2279b(Context context) {
        super(context);
        m.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        if (getDrawable() != null) {
            int size = View.MeasureSpec.getSize(i5);
            setMeasuredDimension((int) Math.ceil((double) ((((float) size) * ((float) getDrawable().getIntrinsicWidth())) / ((float) getDrawable().getIntrinsicHeight()))), size);
            return;
        }
        super.onMeasure(i4, i5);
    }
}
