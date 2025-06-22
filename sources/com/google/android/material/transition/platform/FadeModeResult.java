package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i4, int i5, boolean z4) {
        this.startAlpha = i4;
        this.endAlpha = i5;
        this.endOnTop = z4;
    }

    static FadeModeResult endOnTop(int i4, int i5) {
        return new FadeModeResult(i4, i5, true);
    }

    static FadeModeResult startOnTop(int i4, int i5) {
        return new FadeModeResult(i4, i5, false);
    }
}
