package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    private TonalPalette(double d5, double d6, Hct hct) {
        this.hue = d5;
        this.chroma = d6;
        this.keyColor = hct;
    }

    private static Hct createKeyColor(double d5, double d6) {
        Hct from = Hct.from(d5, d6, 50.0d);
        double abs = Math.abs(from.getChroma() - d6);
        for (double d7 = 1.0d; d7 < 50.0d && Math.round(d6) != Math.round(from.getChroma()); d7 += 1.0d) {
            Hct from2 = Hct.from(d5, d6, 50.0d + d7);
            double abs2 = Math.abs(from2.getChroma() - d6);
            if (abs2 < abs) {
                abs = abs2;
                from = from2;
            }
            Hct from3 = Hct.from(d5, d6, 50.0d - d7);
            double abs3 = Math.abs(from3.getChroma() - d6);
            if (abs3 < abs) {
                abs = abs3;
                from = from3;
            }
        }
        return from;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d5, double d6) {
        return new TonalPalette(d5, d6, createKeyColor(d5, d6));
    }

    public static TonalPalette fromInt(int i4) {
        return fromHct(Hct.fromInt(i4));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d5) {
        return Hct.from(this.hue, this.chroma, d5);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i4) {
        Integer num = this.cache.get(Integer.valueOf(i4));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, (double) i4).toInt());
            this.cache.put(Integer.valueOf(i4), num);
        }
        return num.intValue();
    }
}
