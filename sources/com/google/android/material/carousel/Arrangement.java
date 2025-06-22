package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    Arrangement(int i4, float f4, float f5, float f6, int i5, float f7, int i6, float f8, int i7, float f9) {
        this.priority = i4;
        this.smallSize = MathUtils.clamp(f4, f5, f6);
        this.smallCount = i5;
        this.mediumSize = f7;
        this.mediumCount = i6;
        this.largeSize = f8;
        this.largeCount = i7;
        fit(f9, f5, f6, f8);
        this.cost = cost(f8);
    }

    private float calculateLargeSize(float f4, int i4, float f5, int i5, int i6) {
        if (i4 <= 0) {
            f5 = 0.0f;
        }
        float f6 = ((float) i5) / 2.0f;
        return (f4 - ((((float) i4) + f6) * f5)) / (((float) i6) + f6);
    }

    private float cost(float f4) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f4 - this.largeSize) * ((float) this.priority);
    }

    static Arrangement findLowestCostArrangement(float f4, float f5, float f6, float f7, int[] iArr, float f8, int[] iArr2, float f9, int[] iArr3) {
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        Arrangement arrangement = null;
        int i4 = 1;
        for (int i5 : iArr3) {
            int length = iArr5.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = iArr5[i6];
                int length2 = iArr4.length;
                int i8 = 0;
                while (i8 < length2) {
                    int i9 = i6;
                    int i10 = i4;
                    int i11 = i9;
                    int i12 = length2;
                    int i13 = i8;
                    int i14 = length;
                    Arrangement arrangement2 = new Arrangement(i10, f5, f6, f7, iArr4[i8], f8, i7, f9, i5, f4);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i15 = i10 + 1;
                    i8 = i13 + 1;
                    i6 = i11;
                    i4 = i15;
                    length = i14;
                    length2 = i12;
                }
                int i16 = i6;
                int i17 = i4;
                int i18 = i16;
                int i19 = length;
                int i20 = i17;
                i6 = i18 + 1;
                i4 = i20;
                length = i19;
            }
        }
        return arrangement;
    }

    private void fit(float f4, float f5, float f6, float f7) {
        float f8;
        float space = f4 - getSpace();
        int i4 = this.smallCount;
        if (i4 > 0 && space > 0.0f) {
            float f9 = this.smallSize;
            this.smallSize = f9 + Math.min(space / ((float) i4), f6 - f9);
        } else if (i4 > 0 && space < 0.0f) {
            float f10 = this.smallSize;
            this.smallSize = f10 + Math.max(space / ((float) i4), f5 - f10);
        }
        int i5 = this.smallCount;
        if (i5 > 0) {
            f8 = this.smallSize;
        } else {
            f8 = 0.0f;
        }
        this.smallSize = f8;
        float calculateLargeSize = calculateLargeSize(f4, i5, f8, this.mediumCount, this.largeCount);
        this.largeSize = calculateLargeSize;
        float f11 = (this.smallSize + calculateLargeSize) / 2.0f;
        this.mediumSize = f11;
        int i6 = this.mediumCount;
        if (i6 > 0 && calculateLargeSize != f7) {
            float f12 = (f7 - calculateLargeSize) * ((float) this.largeCount);
            float min = Math.min(Math.abs(f12), f11 * 0.1f * ((float) i6));
            if (f12 > 0.0f) {
                this.mediumSize -= min / ((float) this.mediumCount);
                this.largeSize += min / ((float) this.largeCount);
                return;
            }
            this.mediumSize += min / ((float) this.mediumCount);
            this.largeSize -= min / ((float) this.largeCount);
        }
    }

    private float getSpace() {
        return (this.largeSize * ((float) this.largeCount)) + (this.mediumSize * ((float) this.mediumCount)) + (this.smallSize * ((float) this.smallCount));
    }

    private boolean isValid() {
        int i4 = this.largeCount;
        if (i4 > 0 && this.smallCount > 0 && this.mediumCount > 0) {
            float f4 = this.largeSize;
            float f5 = this.mediumSize;
            if (f4 <= f5 || f5 <= this.smallSize) {
                return false;
            }
            return true;
        } else if (i4 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}
