package com.uptodown.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.m;
import y2.j;

public final class ScrollableTextView extends AppCompatTextView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.e(context, "context");
        if (getText().toString().length() > 0) {
            j.d(this);
            j.b(this);
        }
    }
}
