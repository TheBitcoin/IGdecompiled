package com.mbridge.msdk.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.mbridge.msdk.foundation.tools.ak;

public final class a {
    public static void a(View view, float f4, float f5, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view != null && strArr != null) {
            int[] iArr = new int[strArr.length];
            for (int i4 = 0; i4 < strArr.length; i4++) {
                iArr[i4] = Color.parseColor(strArr[i4]);
            }
            GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
            gradientDrawable.setCornerRadius((float) ak.a(view.getContext(), f5));
            gradientDrawable.setStroke(ak.a(view.getContext(), f4), Color.parseColor(str));
            view.setBackground(gradientDrawable);
        }
    }
}
