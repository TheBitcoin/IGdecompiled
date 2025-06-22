package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static int f13679a = 2048;

    public static Bitmap a(Bitmap bitmap, int i4) {
        int i5;
        int i6;
        char c5;
        if (i4 <= 0) {
            i5 = 10;
        } else {
            i5 = i4;
        }
        int width = bitmap.getWidth() / i5;
        int height = bitmap.getHeight() / i5;
        int i7 = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i8 = width2 * height2;
        int[] iArr = new int[i8];
        createScaledBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
        int i9 = width2 - 1;
        int i10 = height2 - 1;
        int[] iArr2 = new int[i8];
        int[] iArr3 = new int[i8];
        int[] iArr4 = new int[i8];
        int[] iArr5 = new int[Math.max(width2, height2)];
        int[] iArr6 = new int[20736];
        for (int i11 = 0; i11 < 20736; i11++) {
            iArr6[i11] = i11 / 81;
        }
        int[] iArr7 = new int[2];
        iArr7[1] = 3;
        iArr7[0] = 17;
        int[][] iArr8 = (int[][]) Array.newInstance(Integer.TYPE, iArr7);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i12 >= height2) {
                break;
            }
            int i15 = -8;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            for (int i25 = 8; i15 <= i25; i25 = 8) {
                int i26 = iArr[i13 + Math.min(i9, Math.max(i15, i7))];
                int[] iArr9 = iArr8[i15 + 8];
                iArr9[i7] = (i26 & 16711680) >> 16;
                iArr9[1] = (i26 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i26 & 255;
                int abs = 9 - Math.abs(i15);
                int i27 = iArr9[i7];
                i16 += i27 * abs;
                int i28 = iArr9[1];
                i17 += i28 * abs;
                int i29 = iArr9[2];
                i18 += abs * i29;
                if (i15 > 0) {
                    i22 += i27;
                    i23 += i28;
                    i24 += i29;
                } else {
                    i19 += i27;
                    i20 += i28;
                    i21 += i29;
                }
                i15++;
            }
            int i30 = 8;
            int i31 = 0;
            while (i31 < width2) {
                iArr2[i13] = iArr6[i16];
                iArr3[i13] = iArr6[i17];
                iArr4[i13] = iArr6[i18];
                int i32 = i16 - i19;
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int[] iArr10 = iArr8[(i30 + 9) % 17];
                int i35 = i19 - iArr10[i7];
                int i36 = i20 - iArr10[1];
                int i37 = i21 - iArr10[2];
                if (i12 == 0) {
                    c5 = 0;
                    iArr5[i31] = Math.min(i31 + 9, i9);
                } else {
                    c5 = 0;
                }
                int i38 = iArr[i14 + iArr5[i31]];
                int i39 = (i38 & 16711680) >> 16;
                iArr10[c5] = i39;
                int i40 = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[1] = i40;
                int i41 = i38 & 255;
                iArr10[2] = i41;
                int i42 = i22 + i39;
                int i43 = i23 + i40;
                int i44 = i24 + i41;
                i16 = i32 + i42;
                i17 = i33 + i43;
                i18 = i34 + i44;
                i30 = (i30 + 1) % 17;
                int[] iArr11 = iArr8[i30 % 17];
                int i45 = iArr11[c5];
                i19 = i35 + i45;
                int i46 = iArr11[1];
                i20 = i36 + i46;
                int i47 = iArr11[2];
                i21 = i37 + i47;
                i22 = i42 - i45;
                i23 = i43 - i46;
                i24 = i44 - i47;
                i13++;
                i31++;
                i7 = 0;
            }
            i14 += width2;
            i12++;
            i7 = 0;
        }
        int i48 = 0;
        while (i48 < width2) {
            int i49 = -8 * width2;
            int i50 = i48;
            int[] iArr12 = iArr4;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            for (int i60 = -8; i60 <= 8; i60++) {
                int max = Math.max(0, i49) + i50;
                int[] iArr13 = iArr8[i60 + 8];
                iArr13[0] = iArr2[max];
                iArr13[1] = iArr3[max];
                iArr13[2] = iArr12[max];
                int abs2 = 9 - Math.abs(i60);
                i51 += iArr2[max] * abs2;
                i52 += iArr3[max] * abs2;
                i53 += iArr12[max] * abs2;
                if (i60 > 0) {
                    i57 += iArr13[0];
                    i58 += iArr13[1];
                    i59 += iArr13[2];
                } else {
                    i54 += iArr13[0];
                    i55 += iArr13[1];
                    i56 += iArr13[2];
                }
                if (i60 < i10) {
                    i49 += width2;
                }
            }
            int i61 = i50;
            int i62 = 0;
            int i63 = 8;
            while (i62 < height2) {
                iArr[i61] = (iArr[i61] & ViewCompat.MEASURED_STATE_MASK) | (iArr6[i51] << 16) | (iArr6[i52] << 8) | iArr6[i53];
                int i64 = i51 - i54;
                int i65 = i52 - i55;
                int i66 = i53 - i56;
                int[] iArr14 = iArr8[(i63 + 9) % 17];
                int i67 = i54 - iArr14[0];
                int i68 = i55 - iArr14[1];
                int i69 = i56 - iArr14[2];
                if (i50 == 0) {
                    i6 = i62;
                    iArr5[i6] = Math.min(i6 + 9, i10) * width2;
                } else {
                    i6 = i62;
                }
                int i70 = i50 + iArr5[i6];
                int i71 = iArr2[i70];
                iArr14[0] = i71;
                int i72 = iArr3[i70];
                iArr14[1] = i72;
                int i73 = iArr12[i70];
                iArr14[2] = i73;
                int i74 = i57 + i71;
                int i75 = i58 + i72;
                int i76 = i59 + i73;
                i51 = i64 + i74;
                i52 = i65 + i75;
                i53 = i66 + i76;
                i63 = (i63 + 1) % 17;
                int[] iArr15 = iArr8[i63];
                int i77 = iArr15[0];
                i54 = i67 + i77;
                int i78 = iArr15[1];
                i55 = i68 + i78;
                int i79 = iArr15[2];
                i56 = i69 + i79;
                i57 = i74 - i77;
                i58 = i75 - i78;
                i59 = i76 - i79;
                i61 += width2;
                i62 = i6 + 1;
            }
            i48 = i50 + 1;
            iArr4 = iArr12;
        }
        createScaledBitmap.setPixels(iArr, 0, width2, 0, 0, width2, height2);
        return createScaledBitmap;
    }
}
