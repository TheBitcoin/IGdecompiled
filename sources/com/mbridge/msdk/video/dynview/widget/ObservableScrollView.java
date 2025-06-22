package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class ObservableScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private a f16235a = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public void fling(int i4) {
        super.fling(i4 / 4);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        a aVar = this.f16235a;
        if (aVar != null) {
            aVar.a(this, i4, i5, i6, i7);
        }
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
