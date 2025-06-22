package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

public class ColorContrastOptions {
    @StyleRes
    private final int highContrastThemeOverlayResourceId;
    @StyleRes
    private final int mediumContrastThemeOverlayResourceId;

    public static class Builder {
        /* access modifiers changed from: private */
        @StyleRes
        public int highContrastThemeOverlayResourceId;
        /* access modifiers changed from: private */
        @StyleRes
        public int mediumContrastThemeOverlayResourceId;

        @NonNull
        public ColorContrastOptions build() {
            return new ColorContrastOptions(this);
        }

        @NonNull
        public Builder setHighContrastThemeOverlay(@StyleRes int i4) {
            this.highContrastThemeOverlayResourceId = i4;
            return this;
        }

        @NonNull
        public Builder setMediumContrastThemeOverlay(@StyleRes int i4) {
            this.mediumContrastThemeOverlayResourceId = i4;
            return this;
        }
    }

    @StyleRes
    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    @StyleRes
    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }

    private ColorContrastOptions(Builder builder) {
        this.mediumContrastThemeOverlayResourceId = builder.mediumContrastThemeOverlayResourceId;
        this.highContrastThemeOverlayResourceId = builder.highContrastThemeOverlayResourceId;
    }
}
