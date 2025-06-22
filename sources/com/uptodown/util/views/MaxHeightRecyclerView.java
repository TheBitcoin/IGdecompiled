package com.uptodown.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private int f19433a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.e(context, "context");
        this.f19433a = (int) context.getResources().getDimension(R.dimen.remote_install_devices_rv_max_height);
    }

    public final int getMaxHeightPx() {
        return this.f19433a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int i6 = this.f19433a;
        if (i6 > 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
        }
        super.onMeasure(i4, i5);
    }

    public final void setMaxHeightPx(int i4) {
        this.f19433a = i4;
    }
}
