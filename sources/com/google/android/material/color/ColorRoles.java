package com.google.android.material.color;

import androidx.annotation.ColorInt;

public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;

    ColorRoles(@ColorInt int i4, @ColorInt int i5, @ColorInt int i6, @ColorInt int i7) {
        this.accent = i4;
        this.onAccent = i5;
        this.accentContainer = i6;
        this.onAccentContainer = i7;
    }

    @ColorInt
    public int getAccent() {
        return this.accent;
    }

    @ColorInt
    public int getAccentContainer() {
        return this.accentContainer;
    }

    @ColorInt
    public int getOnAccent() {
        return this.onAccent;
    }

    @ColorInt
    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }
}
