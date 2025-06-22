package com.uptodown.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import kotlin.jvm.internal.m;

public final class InstantAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.e(context, "arg0");
    }

    public boolean enoughToFilter() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        if (z4 && getAdapter() != null) {
            performFiltering(getText(), 0);
        }
    }
}
