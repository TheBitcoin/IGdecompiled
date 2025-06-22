package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* renamed from: com.google.android.material.color.utilities.QuantizerWu$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.android.material.color.utilities.QuantizerWu$Direction[] r0 = com.google.android.material.color.utilities.QuantizerWu.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = r0
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.RED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.GREEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.BLUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.QuantizerWu.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int i4, int i5) {
            this.resultCount = i5;
        }
    }

    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int i4, double d5) {
            this.cutLocation = i4;
            this.maximum = d5;
        }
    }

    static int bottom(Box box, Direction direction, int[] iArr) {
        int i4;
        int i5;
        int i6 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i6 == 1) {
            i4 = (-iArr[getIndex(box.f10976r0, box.f10975g1, box.f10973b1)]) + iArr[getIndex(box.f10976r0, box.f10975g1, box.f10972b0)] + iArr[getIndex(box.f10976r0, box.f10974g0, box.f10973b1)];
            i5 = iArr[getIndex(box.f10976r0, box.f10974g0, box.f10972b0)];
        } else if (i6 == 2) {
            i4 = (-iArr[getIndex(box.f10977r1, box.f10974g0, box.f10973b1)]) + iArr[getIndex(box.f10977r1, box.f10974g0, box.f10972b0)] + iArr[getIndex(box.f10976r0, box.f10974g0, box.f10973b1)];
            i5 = iArr[getIndex(box.f10976r0, box.f10974g0, box.f10972b0)];
        } else if (i6 == 3) {
            i4 = (-iArr[getIndex(box.f10977r1, box.f10975g1, box.f10972b0)]) + iArr[getIndex(box.f10977r1, box.f10974g0, box.f10972b0)] + iArr[getIndex(box.f10976r0, box.f10975g1, box.f10972b0)];
            i5 = iArr[getIndex(box.f10976r0, box.f10974g0, box.f10972b0)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i4 - i5;
    }

    static int getIndex(int i4, int i5, int i6) {
        return (i4 << 10) + (i4 << 6) + i4 + (i5 << 5) + i5 + i6;
    }

    static int top(Box box, Direction direction, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i7 == 1) {
            i5 = (iArr[getIndex(i4, box.f10975g1, box.f10973b1)] - iArr[getIndex(i4, box.f10975g1, box.f10972b0)]) - iArr[getIndex(i4, box.f10974g0, box.f10973b1)];
            i6 = iArr[getIndex(i4, box.f10974g0, box.f10972b0)];
        } else if (i7 == 2) {
            i5 = (iArr[getIndex(box.f10977r1, i4, box.f10973b1)] - iArr[getIndex(box.f10977r1, i4, box.f10972b0)]) - iArr[getIndex(box.f10976r0, i4, box.f10973b1)];
            i6 = iArr[getIndex(box.f10976r0, i4, box.f10972b0)];
        } else if (i7 == 3) {
            i5 = (iArr[getIndex(box.f10977r1, box.f10975g1, i4)] - iArr[getIndex(box.f10977r1, box.f10974g0, i4)]) - iArr[getIndex(box.f10976r0, box.f10975g1, i4)];
            i6 = iArr[getIndex(box.f10976r0, box.f10974g0, i4)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i5 + i6;
    }

    static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f10977r1, box.f10975g1, box.f10973b1)] - iArr[getIndex(box.f10977r1, box.f10975g1, box.f10972b0)]) - iArr[getIndex(box.f10977r1, box.f10974g0, box.f10973b1)]) + iArr[getIndex(box.f10977r1, box.f10974g0, box.f10972b0)]) - iArr[getIndex(box.f10976r0, box.f10975g1, box.f10973b1)]) + iArr[getIndex(box.f10976r0, box.f10975g1, box.f10972b0)]) + iArr[getIndex(box.f10976r0, box.f10974g0, box.f10973b1)]) - iArr[getIndex(box.f10976r0, box.f10974g0, box.f10972b0)];
    }

    /* access modifiers changed from: package-private */
    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            int redFromArgb = ColorUtils.redFromArgb(intValue);
            int greenFromArgb = ColorUtils.greenFromArgb(intValue);
            int blueFromArgb = ColorUtils.blueFromArgb(intValue);
            int index = getIndex((redFromArgb >> 3) + 1, (greenFromArgb >> 3) + 1, (blueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + intValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = iArr2[index] + (redFromArgb * intValue2);
            int[] iArr3 = this.momentsG;
            iArr3[index] = iArr3[index] + (greenFromArgb * intValue2);
            int[] iArr4 = this.momentsB;
            iArr4[index] = iArr4[index] + (blueFromArgb * intValue2);
            double[] dArr = this.moments;
            dArr[index] = dArr[index] + ((double) (intValue2 * ((redFromArgb * redFromArgb) + (greenFromArgb * greenFromArgb) + (blueFromArgb * blueFromArgb))));
        }
    }

    /* access modifiers changed from: package-private */
    public CreateBoxesResult createBoxes(int i4) {
        int i5;
        double d5;
        double d6;
        this.cubes = new Box[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            this.cubes[i6] = new Box((AnonymousClass1) null);
        }
        double[] dArr = new double[i4];
        Box box = this.cubes[0];
        box.f10977r1 = 32;
        box.f10975g1 = 32;
        box.f10973b1 = 32;
        int i7 = 1;
        int i8 = 0;
        while (true) {
            if (i7 >= i4) {
                i5 = i4;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i8], boxArr[i7]).booleanValue()) {
                Box box2 = this.cubes[i8];
                if (box2.vol > 1) {
                    d5 = variance(box2);
                } else {
                    d5 = 0.0d;
                }
                dArr[i8] = d5;
                Box box3 = this.cubes[i7];
                if (box3.vol > 1) {
                    d6 = variance(box3);
                } else {
                    d6 = 0.0d;
                }
                dArr[i7] = d6;
            } else {
                dArr[i8] = 0.0d;
                i7--;
            }
            double d7 = dArr[0];
            int i9 = 0;
            for (int i10 = 1; i10 <= i7; i10++) {
                double d8 = dArr[i10];
                if (d8 > d7) {
                    i9 = i10;
                    d7 = d8;
                }
            }
            if (d7 <= 0.0d) {
                i5 = i7 + 1;
                break;
            }
            i7++;
            i8 = i9;
        }
        return new CreateBoxesResult(i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void createMoments() {
        int i4 = 1;
        while (true) {
            int i5 = 33;
            if (i4 < 33) {
                int[] iArr = new int[33];
                int[] iArr2 = new int[33];
                int[] iArr3 = new int[33];
                int[] iArr4 = new int[33];
                double[] dArr = new double[33];
                int i6 = 1;
                while (i6 < i5) {
                    int i7 = 0;
                    double d5 = 0.0d;
                    int i8 = 1;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (i8 < i5) {
                        int index = getIndex(i4, i6, i8);
                        i7 += this.weights[index];
                        i9 += this.momentsR[index];
                        i10 += this.momentsG[index];
                        i11 += this.momentsB[index];
                        d5 += this.moments[index];
                        iArr[i8] = iArr[i8] + i7;
                        iArr2[i8] = iArr2[i8] + i9;
                        iArr3[i8] = iArr3[i8] + i10;
                        iArr4[i8] = iArr4[i8] + i11;
                        dArr[i8] = dArr[i8] + d5;
                        int index2 = getIndex(i4 - 1, i6, i8);
                        int i12 = i8;
                        int[] iArr5 = this.weights;
                        iArr5[index] = iArr5[index2] + iArr[i12];
                        int[] iArr6 = this.momentsR;
                        iArr6[index] = iArr6[index2] + iArr2[i12];
                        int[] iArr7 = this.momentsG;
                        iArr7[index] = iArr7[index2] + iArr3[i12];
                        int[] iArr8 = this.momentsB;
                        iArr8[index] = iArr8[index2] + iArr4[i12];
                        double[] dArr2 = this.moments;
                        dArr2[index] = dArr2[index2] + dArr[i12];
                        i8 = i12 + 1;
                        i5 = 33;
                    }
                    i6++;
                    i5 = 33;
                }
                i4++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> createResult(int i4) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < i4; i5++) {
            Box box = this.cubes[i5];
            int volume = volume(box, this.weights);
            if (volume > 0) {
                int volume2 = volume(box, this.momentsG) / volume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / volume) & 255) | (((volume(box, this.momentsR) / volume) & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((volume2 & 255) << 8)));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Boolean cut(Box box, Box box2) {
        Box box3 = box;
        Box box4 = box2;
        int volume = volume(box3, this.momentsR);
        int volume2 = volume(box3, this.momentsG);
        int volume3 = volume(box3, this.momentsB);
        int volume4 = volume(box3, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximize = maximize(box3, direction, box3.f10976r0 + 1, box3.f10977r1, volume, volume2, volume3, volume4);
        Direction direction2 = direction;
        Direction direction3 = Direction.GREEN;
        MaximizeResult maximize2 = maximize(box3, direction3, box3.f10974g0 + 1, box3.f10975g1, volume, volume2, volume3, volume4);
        Direction direction4 = direction3;
        Direction direction5 = Direction.BLUE;
        MaximizeResult maximize3 = maximize(box3, direction5, box3.f10972b0 + 1, box3.f10973b1, volume, volume2, volume3, volume4);
        double d5 = maximize.maximum;
        double d6 = maximize2.maximum;
        MaximizeResult maximizeResult = maximize;
        double d7 = maximize3.maximum;
        if (d5 < d6 || d5 < d7) {
            if (d6 >= d5 && d6 >= d7) {
                direction5 = direction4;
            }
        } else if (maximizeResult.cutLocation < 0) {
            return Boolean.FALSE;
        } else {
            direction5 = direction2;
        }
        box4.f10977r1 = box3.f10977r1;
        box4.f10975g1 = box3.f10975g1;
        box4.f10973b1 = box3.f10973b1;
        int i4 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction5.ordinal()];
        if (i4 == 1) {
            int i5 = maximizeResult.cutLocation;
            box3.f10977r1 = i5;
            box4.f10976r0 = i5;
            box4.f10974g0 = box3.f10974g0;
            box4.f10972b0 = box3.f10972b0;
        } else if (i4 == 2) {
            int i6 = maximize2.cutLocation;
            box3.f10975g1 = i6;
            box4.f10976r0 = box3.f10976r0;
            box4.f10974g0 = i6;
            box4.f10972b0 = box3.f10972b0;
        } else if (i4 == 3) {
            int i7 = maximize3.cutLocation;
            box3.f10973b1 = i7;
            box4.f10976r0 = box3.f10976r0;
            box4.f10974g0 = box3.f10974g0;
            box4.f10972b0 = i7;
        }
        box3.vol = (box3.f10977r1 - box3.f10976r0) * (box3.f10975g1 - box3.f10974g0) * (box3.f10973b1 - box3.f10972b0);
        box4.vol = (box4.f10977r1 - box4.f10976r0) * (box4.f10975g1 - box4.f10974g0) * (box4.f10973b1 - box4.f10972b0);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public MaximizeResult maximize(Box box, Direction direction, int i4, int i5, int i6, int i7, int i8, int i9) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        Direction direction2 = direction;
        int bottom = bottom(box2, direction2, quantizerWu.momentsR);
        int bottom2 = bottom(box2, direction2, quantizerWu.momentsG);
        int bottom3 = bottom(box2, direction2, quantizerWu.momentsB);
        int bottom4 = bottom(box2, direction2, quantizerWu.weights);
        int i10 = i5;
        double d5 = 0.0d;
        int i11 = -1;
        int i12 = i4;
        while (i12 < i10) {
            int pVar = top(box2, direction2, i12, quantizerWu.momentsR) + bottom;
            int pVar2 = top(box2, direction2, i12, quantizerWu.momentsG) + bottom2;
            int pVar3 = top(box2, direction2, i12, quantizerWu.momentsB) + bottom3;
            int pVar4 = top(box2, direction2, i12, quantizerWu.weights) + bottom4;
            if (pVar4 != 0) {
                double d6 = ((double) (((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3))) / ((double) pVar4);
                int i13 = i6 - pVar;
                int i14 = i7 - pVar2;
                int i15 = i8 - pVar3;
                int i16 = i9 - pVar4;
                if (i16 != 0) {
                    double d7 = d6 + (((double) (((i13 * i13) + (i14 * i14)) + (i15 * i15))) / ((double) i16));
                    if (d7 > d5) {
                        d5 = d7;
                        i11 = i12;
                    }
                }
            }
            i12++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i11, d5);
    }

    public QuantizerResult quantize(int[] iArr, int i4) {
        constructHistogram(new QuantizerMap().quantize(iArr, i4).colorToCount);
        createMoments();
        List<Integer> createResult = createResult(createBoxes(i4).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer next : createResult) {
            next.intValue();
            linkedHashMap.put(next, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    /* access modifiers changed from: package-private */
    public double variance(Box box) {
        int volume = volume(box, this.momentsR);
        int volume2 = volume(box, this.momentsG);
        int volume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.f10977r1, box.f10975g1, box.f10973b1)] - this.moments[getIndex(box.f10977r1, box.f10975g1, box.f10972b0)]) - this.moments[getIndex(box.f10977r1, box.f10974g0, box.f10973b1)]) + this.moments[getIndex(box.f10977r1, box.f10974g0, box.f10972b0)]) - this.moments[getIndex(box.f10976r0, box.f10975g1, box.f10973b1)]) + this.moments[getIndex(box.f10976r0, box.f10975g1, box.f10972b0)]) + this.moments[getIndex(box.f10976r0, box.f10974g0, box.f10973b1)]) - this.moments[getIndex(box.f10976r0, box.f10974g0, box.f10972b0)]) - (((double) (((volume * volume) + (volume2 * volume2)) + (volume3 * volume3))) / ((double) volume(box, this.weights)));
    }

    private static final class Box {

        /* renamed from: b0  reason: collision with root package name */
        int f10972b0;

        /* renamed from: b1  reason: collision with root package name */
        int f10973b1;

        /* renamed from: g0  reason: collision with root package name */
        int f10974g0;

        /* renamed from: g1  reason: collision with root package name */
        int f10975g1;

        /* renamed from: r0  reason: collision with root package name */
        int f10976r0;

        /* renamed from: r1  reason: collision with root package name */
        int f10977r1;
        int vol;

        private Box() {
            this.f10976r0 = 0;
            this.f10977r1 = 0;
            this.f10974g0 = 0;
            this.f10975g1 = 0;
            this.f10972b0 = 0;
            this.f10973b1 = 0;
            this.vol = 0;
        }

        /* synthetic */ Box(AnonymousClass1 r12) {
            this();
        }
    }
}
