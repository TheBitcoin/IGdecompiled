package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve2, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z4;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public static /* synthetic */ TonalPalette b(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    public static double enableLightForeground(double d5) {
        if (!tonePrefersLightForeground(d5) || toneAllowsLightForeground(d5)) {
            return d5;
        }
        return 49.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double foregroundTone(double r11, double r13) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r11, r13)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r11, r13)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r11)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r11)
            boolean r11 = tonePrefersLightForeground(r11)
            if (r11 == 0) goto L_0x003b
            double r11 = r4 - r6
            double r11 = java.lang.Math.abs(r11)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x002f
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x002f
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x002f
            r11 = 1
            goto L_0x0030
        L_0x002f:
            r11 = 0
        L_0x0030:
            int r12 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r12 >= 0) goto L_0x0044
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 >= 0) goto L_0x0044
            if (r11 == 0) goto L_0x0045
            goto L_0x0044
        L_0x003b:
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x0045
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 < 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            return r0
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.foregroundTone(double, double):double");
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String str, int i4) {
        return fromPalette(str, new C1706a(TonalPalette.fromInt(i4)), new C1709b(Hct.fromInt(i4)));
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public static boolean toneAllowsLightForeground(double d5) {
        if (Math.round(d5) <= 49) {
            return true;
        }
        return false;
    }

    public static boolean tonePrefersLightForeground(double d5) {
        if (Math.round(d5) < 60) {
            return true;
        }
        return false;
    }

    public int getArgb(@NonNull DynamicScheme dynamicScheme) {
        int i4 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i4;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (i4 & ViewCompat.MEASURED_SIZE_MASK);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0140 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0141 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getTone(@androidx.annotation.NonNull com.google.android.material.color.utilities.DynamicScheme r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            double r2 = r1.contrastLevel
            r4 = 0
            r5 = 1
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0010
            r2 = 1
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.ToneDeltaPair> r3 = r0.toneDeltaPair
            if (r3 == 0) goto L_0x0142
            java.lang.Object r3 = r3.apply(r1)
            com.google.android.material.color.utilities.ToneDeltaPair r3 = (com.google.android.material.color.utilities.ToneDeltaPair) r3
            com.google.android.material.color.utilities.DynamicColor r16 = r3.getRoleA()
            com.google.android.material.color.utilities.DynamicColor r17 = r3.getRoleB()
            double r18 = r3.getDelta()
            r20 = r6
            com.google.android.material.color.utilities.TonePolarity r6 = r3.getPolarity()
            boolean r3 = r3.getStayTogether()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r7 = r0.background
            java.lang.Object r7 = r7.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r7 = (com.google.android.material.color.utilities.DynamicColor) r7
            r22 = 4632233691727265792(0x4049000000000000, double:50.0)
            double r8 = r7.getTone(r1)
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.NEARER
            if (r6 == r7) goto L_0x0053
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.LIGHTER
            if (r6 != r7) goto L_0x004b
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0053
        L_0x004b:
            com.google.android.material.color.utilities.TonePolarity r7 = com.google.android.material.color.utilities.TonePolarity.DARKER
            if (r6 != r7) goto L_0x0054
            boolean r6 = r1.isDark
            if (r6 == 0) goto L_0x0054
        L_0x0053:
            r4 = 1
        L_0x0054:
            if (r4 == 0) goto L_0x0059
            r5 = r16
            goto L_0x005b
        L_0x0059:
            r5 = r17
        L_0x005b:
            if (r4 == 0) goto L_0x0060
            r4 = r17
            goto L_0x0062
        L_0x0060:
            r4 = r16
        L_0x0062:
            java.lang.String r6 = r0.name
            java.lang.String r7 = r5.name
            boolean r6 = r6.equals(r7)
            boolean r7 = r1.isDark
            if (r7 == 0) goto L_0x0071
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0073
        L_0x0071:
            r10 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0073:
            com.google.android.material.color.utilities.ContrastCurve r7 = r5.contrastCurve
            r16 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r14 = r1.contrastLevel
            double r14 = r7.getContrast(r14)
            com.google.android.material.color.utilities.ContrastCurve r7 = r4.contrastCurve
            r24 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r12 = r1.contrastLevel
            double r12 = r7.getContrast(r12)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r5 = r5.tone
            java.lang.Object r5 = r5.apply(r1)
            java.lang.Double r5 = (java.lang.Double) r5
            r7 = r2
            r26 = r3
            double r2 = r5.doubleValue()
            double r27 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r2)
            int r5 = (r27 > r14 ? 1 : (r27 == r14 ? 0 : -1))
            if (r5 < 0) goto L_0x00a2
            goto L_0x00a6
        L_0x00a2:
            double r2 = foregroundTone(r8, r14)
        L_0x00a6:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r4 = r4.tone
            java.lang.Object r1 = r4.apply(r1)
            java.lang.Double r1 = (java.lang.Double) r1
            double r4 = r1.doubleValue()
            double r27 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r4)
            int r1 = (r27 > r12 ? 1 : (r27 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x00bb
            goto L_0x00bf
        L_0x00bb:
            double r4 = foregroundTone(r8, r12)
        L_0x00bf:
            if (r7 == 0) goto L_0x00c9
            double r2 = foregroundTone(r8, r14)
            double r4 = foregroundTone(r8, r12)
        L_0x00c9:
            double r7 = r4 - r2
            double r7 = r7 * r10
            int r1 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f0
            double r4 = r18 * r10
            double r31 = r2 + r4
            r27 = 0
            r29 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r7 = com.google.android.material.color.utilities.MathUtils.clampDouble(r27, r29, r31)
            double r12 = r7 - r2
            double r12 = r12 * r10
            int r1 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ef
            r29 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r31 = r7 - r4
            r27 = 0
            double r2 = com.google.android.material.color.utilities.MathUtils.clampDouble(r27, r29, r31)
        L_0x00ef:
            r4 = r7
        L_0x00f0:
            int r1 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0113
            int r1 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x0113
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0107
            double r18 = r18 * r10
            double r1 = r18 + r16
            double r12 = java.lang.Math.max(r4, r1)
        L_0x0104:
            r2 = r16
            goto L_0x013e
        L_0x0107:
            double r18 = r18 * r10
            double r1 = r18 + r24
            double r1 = java.lang.Math.min(r4, r1)
        L_0x010f:
            r12 = r1
            r2 = r24
            goto L_0x013e
        L_0x0113:
            int r1 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x013d
            int r1 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x013d
            if (r26 == 0) goto L_0x0133
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x012a
            double r18 = r18 * r10
            double r1 = r18 + r16
            double r12 = java.lang.Math.max(r4, r1)
            goto L_0x0104
        L_0x012a:
            double r18 = r18 * r10
            double r1 = r18 + r24
            double r1 = java.lang.Math.min(r4, r1)
            goto L_0x010f
        L_0x0133:
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x013a
            r12 = r16
            goto L_0x013e
        L_0x013a:
            r12 = r24
            goto L_0x013e
        L_0x013d:
            r12 = r4
        L_0x013e:
            if (r6 == 0) goto L_0x0141
            return r2
        L_0x0141:
            return r12
        L_0x0142:
            r20 = r6
            r16 = 4633641066610819072(0x404e000000000000, double:60.0)
            r22 = 4632233691727265792(0x4049000000000000, double:50.0)
            r24 = 4632092954238910464(0x4048800000000000, double:49.0)
            r7 = r2
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r2 = r0.tone
            java.lang.Object r2 = r2.apply(r1)
            java.lang.Double r2 = (java.lang.Double) r2
            double r2 = r2.doubleValue()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r6 = r0.background
            if (r6 != 0) goto L_0x015f
            return r2
        L_0x015f:
            java.lang.Object r6 = r6.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r6 = (com.google.android.material.color.utilities.DynamicColor) r6
            double r8 = r6.getTone(r1)
            com.google.android.material.color.utilities.ContrastCurve r6 = r0.contrastCurve
            double r12 = r1.contrastLevel
            double r12 = r6.getContrast(r12)
            double r14 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r8, r2)
            int r6 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x017a
            goto L_0x017e
        L_0x017a:
            double r2 = foregroundTone(r8, r12)
        L_0x017e:
            if (r7 == 0) goto L_0x0184
            double r2 = foregroundTone(r8, r12)
        L_0x0184:
            boolean r6 = r0.isBackground
            if (r6 == 0) goto L_0x019e
            int r6 = (r22 > r2 ? 1 : (r22 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x019e
            int r6 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r6 >= 0) goto L_0x019e
            r6 = r24
            double r2 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r6, r8)
            int r8 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r8 < 0) goto L_0x019c
            r2 = r6
            goto L_0x019e
        L_0x019c:
            r2 = r16
        L_0x019e:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r6 = r0.secondBackground
            if (r6 == 0) goto L_0x021f
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r6 = r0.background
            java.lang.Object r6 = r6.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r6 = (com.google.android.material.color.utilities.DynamicColor) r6
            double r6 = r6.getTone(r1)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r8 = r0.secondBackground
            java.lang.Object r8 = r8.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r8 = (com.google.android.material.color.utilities.DynamicColor) r8
            double r8 = r8.getTone(r1)
            double r14 = java.lang.Math.max(r6, r8)
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r10 = java.lang.Math.min(r6, r8)
            double r18 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r14, r2)
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x01d5
            double r18 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r10, r2)
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 < 0) goto L_0x01d5
            goto L_0x021f
        L_0x01d5:
            double r1 = com.google.android.material.color.utilities.Contrast.lighter(r14, r12)
            double r10 = com.google.android.material.color.utilities.Contrast.darker(r10, r12)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r12 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x01ed
            java.lang.Double r13 = java.lang.Double.valueOf(r1)
            r3.add(r13)
        L_0x01ed:
            int r13 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r13 == 0) goto L_0x01f8
            java.lang.Double r14 = java.lang.Double.valueOf(r10)
            r3.add(r14)
        L_0x01f8:
            boolean r6 = tonePrefersLightForeground(r6)
            if (r6 != 0) goto L_0x021a
            boolean r6 = tonePrefersLightForeground(r8)
            if (r6 == 0) goto L_0x0205
            goto L_0x021a
        L_0x0205:
            int r1 = r3.size()
            if (r1 != r5) goto L_0x0216
            java.lang.Object r1 = r3.get(r4)
            java.lang.Double r1 = (java.lang.Double) r1
            double r1 = r1.doubleValue()
            return r1
        L_0x0216:
            if (r13 != 0) goto L_0x0219
            return r20
        L_0x0219:
            return r10
        L_0x021a:
            if (r12 != 0) goto L_0x021e
            r1 = 4636737291354636288(0x4059000000000000, double:100.0)
        L_0x021e:
            return r1
        L_0x021f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.getTone(com.google.android.material.color.utilities.DynamicScheme):double");
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4) {
        return new DynamicColor(str, function, function2, z4, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z4, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve2, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z4;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve2;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }
}
