package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialDynamicColors {
    public static /* synthetic */ Double A0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        materialDynamicColors.getClass();
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 0.0d;
            } else {
                d6 = 100.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair C(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryContainer(), materialDynamicColors.secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double C0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 95.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double C1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair D(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.errorContainer(), materialDynamicColors.error(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double D0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = 87.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double D1(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 90.0d;
            } else {
                d6 = 25.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double F0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double G(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 60.0d;
        } else {
            d5 = 50.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double G1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double H(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 12.0d;
        } else {
            d5 = 94.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double H1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double I0(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 100.0d;
            } else {
                d6 = 0.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double I1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double K(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double K0(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 10.0d;
            } else {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double L(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double M(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 24.0d;
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double M1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double N(DynamicScheme dynamicScheme) {
        double d5 = 100.0d;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d5 = 10.0d;
            }
            return Double.valueOf(d5);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double O0(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 90.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double Q0(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 85.0d;
            } else {
                d6 = 25.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double R0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 20.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double S0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 22.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double U(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 40.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double U1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 25.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double W1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair X1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryFixed(), materialDynamicColors.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double Y0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double Z(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 100.0d;
        } else {
            d5 = 0.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair Z0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryContainer(), materialDynamicColors.secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair a(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryFixed(), materialDynamicColors.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double a0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 17.0d;
        } else {
            d5 = 92.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double a1(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 10.0d;
            } else {
                d6 = 90.0d;
            }
            return Double.valueOf(d6);
        }
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double b(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 20.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double b1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 90.0d;
        } else {
            d5 = 30.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double d1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair e1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryFixed(), materialDynamicColors.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ ToneDeltaPair f(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryFixed(), materialDynamicColors.primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double f2(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 10.0d;
        } else {
            d5 = 96.0d;
        }
        return Double.valueOf(d5);
    }

    static double findDesiredChromaByTone(double d5, double d6, double d7, boolean z4) {
        double d8;
        Hct from = Hct.from(d5, d6, d7);
        if (from.getChroma() < d6) {
            double chroma = from.getChroma();
            while (from.getChroma() < d6) {
                if (z4) {
                    d8 = -1.0d;
                } else {
                    d8 = 1.0d;
                }
                d7 += d8;
                Hct from2 = Hct.from(d5, d6, d7);
                if (chroma > from2.getChroma() || Math.abs(from2.getChroma() - d6) < 0.4d) {
                    return d7;
                }
                if (Math.abs(from2.getChroma() - d6) < Math.abs(from.getChroma() - d6)) {
                    from = from2;
                }
                chroma = Math.max(chroma, from2.getChroma());
            }
        }
        return d7;
    }

    public static /* synthetic */ Double g(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double g1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        materialDynamicColors.getClass();
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 0.0d;
            } else {
                d6 = 100.0d;
            }
            return Double.valueOf(d6);
        } else if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        } else {
            if (dynamicScheme.isDark) {
                d5 = 90.0d;
            } else {
                d5 = 10.0d;
            }
            return Double.valueOf(d5);
        }
    }

    public static /* synthetic */ Double h1(DynamicScheme dynamicScheme) {
        double d5;
        double d6;
        if (isMonochrome(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d6 = 60.0d;
            } else {
                d6 = 49.0d;
            }
            return Double.valueOf(d6);
        } else if (!isFidelity(dynamicScheme)) {
            if (dynamicScheme.isDark) {
                d5 = 30.0d;
            } else {
                d5 = 90.0d;
            }
            return Double.valueOf(d5);
        } else {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        if (variant == Variant.FIDELITY || variant == Variant.CONTENT) {
            return true;
        }
        return false;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        if (dynamicScheme.variant == Variant.MONOCHROME) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Double j(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 100.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double j1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 40.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double k(DynamicScheme dynamicScheme) {
        double d5;
        double d6 = 30.0d;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        if (isMonochrome(dynamicScheme)) {
            if (!dynamicScheme.isDark) {
                d6 = 85.0d;
            }
            return Double.valueOf(d6);
        } else if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d5);
        } else {
            return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d5, !dynamicScheme.isDark)), dynamicScheme));
        }
    }

    public static /* synthetic */ Double k0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double l1(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double m(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        double d5;
        materialDynamicColors.getClass();
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(materialDynamicColors.secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double m0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 0.2d;
        } else {
            d5 = 0.12d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair m1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryContainer(), materialDynamicColors.primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double n(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair o0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.errorContainer(), materialDynamicColors.error(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double p0(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 40.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double p1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 80.0d;
        } else {
            d5 = 90.0d;
        }
        return Double.valueOf(d5);
    }

    static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct inViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (!DynamicColor.tonePrefersLightForeground(hct.getTone()) || DynamicColor.toneAllowsLightForeground(inViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(inViewingConditions.getTone());
        }
        return DynamicColor.enableLightForeground(hct.getTone());
    }

    public static /* synthetic */ Double q(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 90.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double s(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 4.0d;
        } else {
            d5 = 100.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair s0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.secondaryFixed(), materialDynamicColors.secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public static /* synthetic */ Double t(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double t1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 100.0d;
        } else {
            d5 = 10.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair u(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.primaryContainer(), materialDynamicColors.primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ ToneDeltaPair v1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryFixed(), materialDynamicColors.tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 30.0d;
        } else {
            d5 = 80.0d;
        }
        return ViewingConditions.defaultWithBackgroundLstar(d5);
    }

    public static /* synthetic */ Double w1(DynamicScheme dynamicScheme) {
        double d5;
        if (isMonochrome(dynamicScheme)) {
            d5 = 70.0d;
        } else {
            d5 = 80.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ Double x0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 6.0d;
        } else {
            d5 = 98.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair y0(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryContainer(), materialDynamicColors.tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    public static /* synthetic */ Double z0(DynamicScheme dynamicScheme) {
        double d5;
        if (dynamicScheme.isDark) {
            d5 = 80.0d;
        } else {
            d5 = 40.0d;
        }
        return Double.valueOf(d5);
    }

    public static /* synthetic */ ToneDeltaPair z1(MaterialDynamicColors materialDynamicColors, DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(materialDynamicColors.tertiaryContainer(), materialDynamicColors.tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    @NonNull
    public DynamicColor background() {
        return new DynamicColor("background", new Z0(), new C1708a1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new C1769v0(), new C1772w0());
    }

    @NonNull
    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new S0(), new T0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null, new U0());
    }

    @NonNull
    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new C1725g0(), new C1757r0());
    }

    @NonNull
    public DynamicColor error() {
        return new DynamicColor(CampaignEx.JSON_NATIVE_VIDEO_ERROR, new I(), new K(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new L(this));
    }

    @NonNull
    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new C1710b0(), new C1713c0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C1716d0(this));
    }

    @NonNull
    public DynamicColor highestSurface(@NonNull DynamicScheme dynamicScheme) {
        if (dynamicScheme.isDark) {
            return surfaceBright();
        }
        return surfaceDim();
    }

    @NonNull
    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new C1765u(), new C1768v(), false, new C1771w(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new C1750o1(), new C1753p1(), false, new C1756q1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new T(), new U(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new C1745n(), new C1777y());
    }

    @NonNull
    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new R1(), new S1());
    }

    @NonNull
    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new C1717d1(), new C1720e1(), false, new C1723f1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onError() {
        return new DynamicColor("on_error", new D1(), new E1(), false, new F1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new W(), new X(), false, new Y(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new C1741l1(), new C1744m1(), false, new C1747n1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new I1(), new J1(this), false, new K1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new E(), new F(), false, new G(this), new H(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new C1770v1(), new C1773w1(), false, new C1776x1(this), new C1779y1(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new C1715d(), new C1718e(), false, new C1721f(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new B(), new C(this), false, new D(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new C1754q(), new r(), false, new C1759s(this), new C1762t(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new C1746n0(), new C1749o0(), false, new C1752p0(this), new C1755q0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new N1(), new Y1(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new Q(), new S(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new C1726g1(), new C1758r1(), false, new C1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new C1774x(), new C1780z(this), false, new A(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new M0(), new N0(), false, new O0(this), new P0(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new A0(), new B0(), false, new C0(this), new D0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor outline() {
        return new DynamicColor("outline", new C1739l(), new C1742m(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new C1729h1(), new C1732i1(), false, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor primary() {
        return new DynamicColor("primary", new C1731i0(), new C1734j0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C1737k0(this));
    }

    @NonNull
    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new W0(), new X0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Y0(this));
    }

    @NonNull
    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new a2(), new b2(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new c2(this));
    }

    @NonNull
    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new d2(), new e2(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new f2(this));
    }

    @NonNull
    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new C1775x0(), new C1778y0());
    }

    @NonNull
    public DynamicColor scrim() {
        return new DynamicColor("scrim", new C1740l0(), new C1743m0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor secondary() {
        return new DynamicColor("secondary", new C1724g(), new C1727h(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C1730i(this));
    }

    @NonNull
    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new I0(), new J0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new L0(this));
    }

    @NonNull
    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new C1761s1(), new C1764t1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C1767u1(this));
    }

    @NonNull
    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new L1(), new M1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new O1(this));
    }

    @NonNull
    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new E0(), new F0());
    }

    @NonNull
    public DynamicColor shadow() {
        return new DynamicColor("shadow", new V1(), new W1(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surface() {
        return new DynamicColor("surface", new C1712c(), new C1781z0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new C1735j1(), new C1738k1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new O(), new P(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new C1711b1(), new C1714c1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new X1(), new Z1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new G0(), new H0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new C1733j(), new C1736k(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new J(), new V(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new C1748o(), new C1751p(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new P1(), new Q1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new C1760s0(), new C1763t0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C1766u0(this));
    }

    @NonNull
    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new g2(), new h2(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new i2(this));
    }

    @NonNull
    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new C1719e0(), new C1722f0(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C1728h0(this));
    }

    @NonNull
    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new C1782z1(), new A1(), true, new j2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new B1(this));
    }

    @NonNull
    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new Q0(), new R0());
    }

    @NonNull
    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new T1(), new U1());
    }

    @NonNull
    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new M(), new N());
    }

    @NonNull
    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new G1(), new H1());
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new Z(), new C1707a0());
    }

    @NonNull
    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new K0(), new V0());
    }
}
