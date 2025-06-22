package com.inmobi.cmp.data.model;

import androidx.annotation.FontRes;
import androidx.annotation.Keep;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@Keep
public final class ChoiceStyle {
    private Integer boldFont;
    private ChoiceColor darkModeColors;
    private ChoiceColor lightModeColors;
    private Integer regularFont;
    private ThemeMode themeMode;

    @Keep
    public static final class Builder {
        @FontRes
        private Integer boldFont;
        private ChoiceColor darkModeColors;
        private ChoiceColor lightModeColors;
        @FontRes
        private Integer regularFont;
        private ThemeMode themeMode;

        public final ChoiceStyle build() {
            return new ChoiceStyle(this.themeMode, this.lightModeColors, this.darkModeColors, this.boldFont, this.regularFont, (C2103g) null);
        }

        public final Builder setBoldFont(@FontRes int i4) {
            this.boldFont = Integer.valueOf(i4);
            return this;
        }

        public final Builder setDarkModeColors(ChoiceColor choiceColor) {
            m.e(choiceColor, "darkModeColors");
            this.darkModeColors = choiceColor;
            return this;
        }

        public final Builder setLightModeColors(ChoiceColor choiceColor) {
            m.e(choiceColor, "lightModeColors");
            this.lightModeColors = choiceColor;
            return this;
        }

        public final Builder setRegularFont(@FontRes int i4) {
            this.regularFont = Integer.valueOf(i4);
            return this;
        }

        public final Builder setThemeMode(ThemeMode themeMode2) {
            m.e(themeMode2, "themeMode");
            this.themeMode = themeMode2;
            return this;
        }
    }

    public /* synthetic */ ChoiceStyle(ThemeMode themeMode2, ChoiceColor choiceColor, ChoiceColor choiceColor2, Integer num, Integer num2, C2103g gVar) {
        this(themeMode2, choiceColor, choiceColor2, num, num2);
    }

    public final Integer getBoldFont() {
        return this.boldFont;
    }

    public final ChoiceColor getDarkModeColors() {
        return this.darkModeColors;
    }

    public final ChoiceColor getLightModeColors() {
        return this.lightModeColors;
    }

    public final Integer getRegularFont() {
        return this.regularFont;
    }

    public final ThemeMode getThemeMode() {
        return this.themeMode;
    }

    public final void setBoldFont(Integer num) {
        this.boldFont = num;
    }

    public final void setDarkModeColors(ChoiceColor choiceColor) {
        this.darkModeColors = choiceColor;
    }

    public final void setLightModeColors(ChoiceColor choiceColor) {
        this.lightModeColors = choiceColor;
    }

    public final void setRegularFont(Integer num) {
        this.regularFont = num;
    }

    public final void setThemeMode(ThemeMode themeMode2) {
        this.themeMode = themeMode2;
    }

    private ChoiceStyle(ThemeMode themeMode2, ChoiceColor choiceColor, ChoiceColor choiceColor2, @FontRes Integer num, @FontRes Integer num2) {
        this.themeMode = themeMode2;
        this.lightModeColors = choiceColor;
        this.darkModeColors = choiceColor2;
        this.boldFont = num;
        this.regularFont = num2;
    }

    public ChoiceStyle() {
        this((ThemeMode) null, (ChoiceColor) null, (ChoiceColor) null, (Integer) null, (Integer) null);
    }
}
