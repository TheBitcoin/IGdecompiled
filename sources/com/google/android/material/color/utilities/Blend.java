package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i4, int i5, double d5) {
        Cam16 fromInt = Cam16.fromInt(i4);
        Cam16 fromInt2 = Cam16.fromInt(i5);
        double jstar = fromInt.getJstar();
        double astar = fromInt.getAstar();
        double bstar = fromInt.getBstar();
        return Cam16.fromUcs(jstar + ((fromInt2.getJstar() - jstar) * d5), astar + ((fromInt2.getAstar() - astar) * d5), bstar + ((fromInt2.getBstar() - bstar) * d5)).toInt();
    }

    public static int harmonize(int i4, int i5) {
        Hct fromInt = Hct.fromInt(i4);
        Hct fromInt2 = Hct.fromInt(i5);
        return Hct.from(MathUtils.sanitizeDegreesDouble(fromInt.getHue() + (Math.min(MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()) * 0.5d, 15.0d) * MathUtils.rotationDirection(fromInt.getHue(), fromInt2.getHue()))), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    public static int hctHue(int i4, int i5, double d5) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i4, i5, d5)).getHue(), Cam16.fromInt(i4).getChroma(), ColorUtils.lstarFromArgb(i4)).toInt();
    }
}
