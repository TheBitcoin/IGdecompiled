package com.google.android.material.color;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;

public class DynamicColorsOptions {
    /* access modifiers changed from: private */
    public static final DynamicColors.Precondition ALWAYS_ALLOW = new DynamicColors.Precondition() {
        public boolean shouldApplyDynamicColors(@NonNull Activity activity, int i4) {
            return true;
        }
    };
    /* access modifiers changed from: private */
    public static final DynamicColors.OnAppliedCallback NO_OP_CALLBACK = new DynamicColors.OnAppliedCallback() {
        public void onApplied(@NonNull Activity activity) {
        }
    };
    @Nullable
    private Integer contentBasedSeedColor;
    @NonNull
    private final DynamicColors.OnAppliedCallback onAppliedCallback;
    @NonNull
    private final DynamicColors.Precondition precondition;
    @StyleRes
    private final int themeOverlay;

    private static int extractSeedColorFromImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return Score.score(QuantizerCelebi.quantize(iArr, 128)).get(0).intValue();
    }

    @Nullable
    public Integer getContentBasedSeedColor() {
        return this.contentBasedSeedColor;
    }

    @NonNull
    public DynamicColors.OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    @NonNull
    public DynamicColors.Precondition getPrecondition() {
        return this.precondition;
    }

    @StyleRes
    public int getThemeOverlay() {
        return this.themeOverlay;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public Bitmap contentBasedSourceBitmap;
        /* access modifiers changed from: private */
        @Nullable
        public Integer contentBasedSourceColor;
        /* access modifiers changed from: private */
        @NonNull
        public DynamicColors.OnAppliedCallback onAppliedCallback = DynamicColorsOptions.NO_OP_CALLBACK;
        /* access modifiers changed from: private */
        @NonNull
        public DynamicColors.Precondition precondition = DynamicColorsOptions.ALWAYS_ALLOW;
        /* access modifiers changed from: private */
        @StyleRes
        public int themeOverlay;

        @NonNull
        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this);
        }

        @NonNull
        public Builder setContentBasedSource(@NonNull Bitmap bitmap) {
            this.contentBasedSourceBitmap = bitmap;
            this.contentBasedSourceColor = null;
            return this;
        }

        @NonNull
        public Builder setOnAppliedCallback(@NonNull DynamicColors.OnAppliedCallback onAppliedCallback2) {
            this.onAppliedCallback = onAppliedCallback2;
            return this;
        }

        @NonNull
        public Builder setPrecondition(@NonNull DynamicColors.Precondition precondition2) {
            this.precondition = precondition2;
            return this;
        }

        @NonNull
        public Builder setThemeOverlay(@StyleRes int i4) {
            this.themeOverlay = i4;
            return this;
        }

        @NonNull
        public Builder setContentBasedSource(@ColorInt int i4) {
            this.contentBasedSourceBitmap = null;
            this.contentBasedSourceColor = Integer.valueOf(i4);
            return this;
        }
    }

    private DynamicColorsOptions(Builder builder) {
        this.themeOverlay = builder.themeOverlay;
        this.precondition = builder.precondition;
        this.onAppliedCallback = builder.onAppliedCallback;
        if (builder.contentBasedSourceColor != null) {
            this.contentBasedSeedColor = builder.contentBasedSourceColor;
        } else if (builder.contentBasedSourceBitmap != null) {
            this.contentBasedSeedColor = Integer.valueOf(extractSeedColorFromImage(builder.contentBasedSourceBitmap));
        }
    }
}
