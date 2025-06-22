package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

public final class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c5, float[] fArr) {
        arrayList.add(new PathDataNode(c5, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < pathDataNodeArr.length; i4++) {
            if (pathDataNodeArr[i4].mType != pathDataNodeArr2[i4].mType || pathDataNodeArr[i4].mParams.length != pathDataNodeArr2[i4].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i4, int i5) {
        if (i4 <= i5) {
            int length = fArr.length;
            if (i4 < 0 || i4 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i6 = i5 - i4;
            int min = Math.min(i6, length - i4);
            float[] fArr2 = new float[i6];
            System.arraycopy(fArr, i4, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        int i5 = 0;
        while (i4 < str.length()) {
            int nextStart = nextStart(str, i4);
            String trim = str.substring(i5, nextStart).trim();
            if (!trim.isEmpty()) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i5 = nextStart;
            i4 = nextStart + 1;
        }
        if (i4 - i5 == 1 && i5 < str.length()) {
            addNode(arrayList, str.charAt(i5), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e5) {
            throw new RuntimeException("Error in parsing " + str, e5);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i4 = 0; i4 < pathDataNodeArr.length; i4++) {
            pathDataNodeArr2[i4] = new PathDataNode(pathDataNodeArr[i4]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[LOOP:0: B:1:0x0007->B:20:0x0039, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0029
            r6 = 69
            if (r5 == r6) goto L_0x0035
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0035
            switch(r5) {
                case 44: goto L_0x0029;
                case 45: goto L_0x002c;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0033
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0036
        L_0x0027:
            r10.mEndWithNegOrDot = r7
        L_0x0029:
            r2 = 0
            r4 = 1
            goto L_0x0036
        L_0x002c:
            if (r1 == r9) goto L_0x0033
            if (r2 != 0) goto L_0x0033
            r10.mEndWithNegOrDot = r7
            goto L_0x0029
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r4 == 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i4 = 1;
            int i5 = 0;
            while (i4 < length) {
                extract(str, i4, extractFloatResult);
                int i6 = extractFloatResult.mEndPosition;
                if (i4 < i6) {
                    fArr[i5] = Float.parseFloat(str.substring(i4, i6));
                    i5++;
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
            }
            return copyOfRange(fArr, 0, i5);
        } catch (NumberFormatException e5) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e5);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f4, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f4)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i4) {
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i4++;
        }
        return i4;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c5 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c5, pathDataNode.mType, pathDataNode.mParams);
            c5 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i4 = 0; i4 < pathDataNodeArr2.length; i4++) {
            char unused = pathDataNodeArr[i4].mType = pathDataNodeArr2[i4].mType;
            for (int i5 = 0; i5 < pathDataNodeArr2[i4].mParams.length; i5++) {
                pathDataNodeArr[i4].mParams[i5] = pathDataNodeArr2[i4].mParams[i5];
            }
        }
    }

    public static class PathDataNode {
        /* access modifiers changed from: private */
        public final float[] mParams;
        /* access modifiers changed from: private */
        public char mType;

        PathDataNode(char c5, float[] fArr) {
            this.mType = c5;
            this.mParams = fArr;
        }

        /* access modifiers changed from: private */
        public static void addCommand(Path path, float[] fArr, char c5, char c6, float[] fArr2) {
            int i4;
            int i5;
            boolean z4;
            boolean z5;
            int i6;
            float f4;
            float f5;
            float f6;
            float f7;
            boolean z6;
            boolean z7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            Path path2 = path;
            char c7 = c6;
            float[] fArr3 = fArr2;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i4 = 7;
                    break;
                case 'C':
                case 'c':
                    i4 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i4 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i4 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    break;
            }
            i4 = 2;
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i7 = 0;
            char c8 = c5;
            while (i7 < fArr3.length) {
                if (c7 == 'A') {
                    float f28 = f24;
                    float f29 = f25;
                    i5 = i7;
                    int i8 = i5 + 5;
                    float f30 = fArr3[i8];
                    int i9 = i5 + 6;
                    float f31 = fArr3[i9];
                    float f32 = fArr3[i5];
                    float f33 = fArr3[i5 + 1];
                    float f34 = fArr3[i5 + 2];
                    if (fArr3[i5 + 3] != 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (fArr3[i5 + 4] != 0.0f) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    drawArc(path, f28, f29, f30, f31, f32, f33, f34, z4, z5);
                    f20 = fArr3[i8];
                    f24 = f20;
                    f21 = fArr3[i9];
                    f25 = f21;
                } else if (c7 == 'C') {
                    i5 = i7;
                    int i10 = i5 + 2;
                    int i11 = i5 + 3;
                    int i12 = i5 + 4;
                    int i13 = i5 + 5;
                    path2.cubicTo(fArr3[i5], fArr3[i5 + 1], fArr3[i10], fArr3[i11], fArr3[i12], fArr3[i13]);
                    float f35 = fArr3[i12];
                    float f36 = fArr3[i13];
                    float f37 = fArr3[i10];
                    float f38 = fArr3[i11];
                    f24 = f35;
                    f25 = f36;
                    f21 = f38;
                    f20 = f37;
                } else if (c7 != 'H') {
                    if (c7 != 'Q') {
                        if (c7 == 'V') {
                            i5 = i7;
                            path2.lineTo(f24, fArr3[i5]);
                            f7 = fArr3[i5];
                        } else if (c7 != 'a') {
                            if (c7 == 'c') {
                                int i14 = i7 + 2;
                                int i15 = i7 + 3;
                                int i16 = i7 + 4;
                                int i17 = i7 + 5;
                                path2.rCubicTo(fArr3[i7], fArr3[i7 + 1], fArr3[i14], fArr3[i15], fArr3[i16], fArr3[i17]);
                                float f39 = fArr3[i14] + f24;
                                float f40 = fArr3[i15] + f25;
                                f24 += fArr3[i16];
                                f25 += fArr3[i17];
                                f20 = f39;
                                f21 = f40;
                            } else if (c7 != 'h') {
                                if (c7 != 'q') {
                                    if (c7 != 'v') {
                                        if (c7 != 'L') {
                                            if (c7 == 'M') {
                                                f12 = fArr3[i7];
                                                f13 = fArr3[i7 + 1];
                                                if (i7 > 0) {
                                                    path2.lineTo(f12, f13);
                                                } else {
                                                    path2.moveTo(f12, f13);
                                                    f24 = f12;
                                                    f26 = f24;
                                                    f25 = f13;
                                                }
                                            } else if (c7 == 'S') {
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f24 = (f24 * 2.0f) - f20;
                                                    f25 = (f25 * 2.0f) - f21;
                                                }
                                                float f41 = f24;
                                                float f42 = f25;
                                                int i18 = i7 + 1;
                                                int i19 = i7 + 2;
                                                int i20 = i7 + 3;
                                                path2.cubicTo(f41, f42, fArr3[i7], fArr3[i18], fArr3[i19], fArr3[i20]);
                                                f4 = fArr3[i7];
                                                f5 = fArr3[i18];
                                                f6 = fArr3[i19];
                                                f25 = fArr3[i20];
                                                i6 = i7;
                                            } else if (c7 == 'T') {
                                                if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                    f24 = (f24 * 2.0f) - f20;
                                                    f25 = (f25 * 2.0f) - f21;
                                                }
                                                int i21 = i7 + 1;
                                                path2.quadTo(f24, f25, fArr3[i7], fArr3[i21]);
                                                float f43 = fArr3[i7];
                                                f7 = fArr3[i21];
                                                f20 = f24;
                                                f21 = f25;
                                                i5 = i7;
                                                f24 = f43;
                                            } else if (c7 == 'l') {
                                                int i22 = i7 + 1;
                                                path2.rLineTo(fArr3[i7], fArr3[i22]);
                                                f24 += fArr3[i7];
                                                f11 = fArr3[i22];
                                            } else if (c7 == 'm') {
                                                float f44 = fArr3[i7];
                                                f24 += f44;
                                                float f45 = fArr3[i7 + 1];
                                                f25 += f45;
                                                if (i7 > 0) {
                                                    path2.rLineTo(f44, f45);
                                                } else {
                                                    path2.rMoveTo(f44, f45);
                                                    f26 = f24;
                                                }
                                            } else if (c7 == 's') {
                                                if (c8 == 'c' || c8 == 's' || c8 == 'C' || c8 == 'S') {
                                                    f14 = f25 - f21;
                                                    f15 = f24 - f20;
                                                } else {
                                                    f15 = 0.0f;
                                                    f14 = 0.0f;
                                                }
                                                int i23 = i7 + 1;
                                                int i24 = i7 + 2;
                                                int i25 = i7 + 3;
                                                path2.rCubicTo(f15, f14, fArr3[i7], fArr3[i23], fArr3[i24], fArr3[i25]);
                                                f8 = fArr3[i7] + f24;
                                                f9 = fArr3[i23] + f25;
                                                f24 += fArr3[i24];
                                                f10 = fArr3[i25];
                                            } else if (c7 == 't') {
                                                if (c8 == 'q' || c8 == 't' || c8 == 'Q' || c8 == 'T') {
                                                    f16 = f24 - f20;
                                                    f17 = f25 - f21;
                                                } else {
                                                    f17 = 0.0f;
                                                    f16 = 0.0f;
                                                }
                                                int i26 = i7 + 1;
                                                path2.rQuadTo(f16, f17, fArr3[i7], fArr3[i26]);
                                                float f46 = f16 + f24;
                                                float f47 = f17 + f25;
                                                f24 += fArr3[i7];
                                                f25 += fArr3[i26];
                                                f21 = f47;
                                                f20 = f46;
                                            }
                                            f27 = f25;
                                        } else {
                                            int i27 = i7 + 1;
                                            path2.lineTo(fArr3[i7], fArr3[i27]);
                                            f12 = fArr3[i7];
                                            f13 = fArr3[i27];
                                        }
                                        f24 = f12;
                                        f25 = f13;
                                    } else {
                                        path2.rLineTo(0.0f, fArr3[i7]);
                                        f11 = fArr3[i7];
                                    }
                                    f25 += f11;
                                } else {
                                    int i28 = i7 + 1;
                                    int i29 = i7 + 2;
                                    int i30 = i7 + 3;
                                    path2.rQuadTo(fArr3[i7], fArr3[i28], fArr3[i29], fArr3[i30]);
                                    f8 = fArr3[i7] + f24;
                                    f9 = fArr3[i28] + f25;
                                    f24 += fArr3[i29];
                                    f10 = fArr3[i30];
                                }
                                f25 += f10;
                                f20 = f8;
                                f21 = f9;
                            } else {
                                path2.rLineTo(fArr3[i7], 0.0f);
                                f24 += fArr3[i7];
                            }
                            i5 = i7;
                        } else {
                            int i31 = i7 + 5;
                            float f48 = fArr3[i31] + f24;
                            int i32 = i7 + 6;
                            float f49 = fArr3[i32] + f25;
                            float f50 = fArr3[i7];
                            float f51 = fArr3[i7 + 1];
                            float f52 = fArr3[i7 + 2];
                            float f53 = f25;
                            if (fArr3[i7 + 3] != 0.0f) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            i5 = i7;
                            if (fArr3[i7 + 4] != 0.0f) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            float f54 = f24;
                            drawArc(path, f54, f53, f48, f49, f50, f51, f52, z6, z7);
                            f24 = f54 + fArr3[i31];
                            f25 = f53 + fArr3[i32];
                            f20 = f24;
                            f21 = f25;
                        }
                        f25 = f7;
                    } else {
                        i6 = i7;
                        int i33 = i6 + 1;
                        int i34 = i6 + 2;
                        int i35 = i6 + 3;
                        path2.quadTo(fArr3[i6], fArr3[i33], fArr3[i34], fArr3[i35]);
                        f4 = fArr3[i6];
                        f5 = fArr3[i33];
                        f6 = fArr3[i34];
                        f25 = fArr3[i35];
                    }
                    f20 = f4;
                    f21 = f5;
                } else {
                    i5 = i7;
                    path2.lineTo(fArr3[i5], f25);
                    f24 = fArr3[i5];
                }
                i7 = i5 + i4;
                path2 = path;
                c8 = c7;
            }
            fArr[0] = f24;
            fArr[1] = f25;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        private static void arcToBezier(Path path, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
            double d14 = d7;
            int ceil = (int) Math.ceil(Math.abs((d13 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d11);
            double sin = Math.sin(d11);
            double cos2 = Math.cos(d12);
            double sin2 = Math.sin(d12);
            double d15 = -d14;
            double d16 = d15 * cos;
            double d17 = d8 * sin;
            double d18 = (d16 * sin2) - (d17 * cos2);
            double d19 = d15 * sin;
            double d20 = d8 * cos;
            double d21 = (sin2 * d19) + (cos2 * d20);
            double d22 = d13 / ((double) ceil);
            double d23 = d12;
            double d24 = d21;
            double d25 = d18;
            int i4 = 0;
            double d26 = d9;
            double d27 = d10;
            while (i4 < ceil) {
                double d28 = d23 + d22;
                double sin3 = Math.sin(d28);
                double cos3 = Math.cos(d28);
                double d29 = (d5 + ((d14 * cos) * cos3)) - (d17 * sin3);
                int i5 = i4;
                double d30 = d6 + (d7 * sin * cos3) + (d20 * sin3);
                double d31 = (d16 * sin3) - (d17 * cos3);
                double d32 = (sin3 * d19) + (cos3 * d20);
                double d33 = d28 - d23;
                double tan = Math.tan(d33 / 2.0d);
                double sin4 = (Math.sin(d33) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d34 = d26 + (d25 * sin4);
                int i6 = ceil;
                double d35 = cos;
                double d36 = d27 + (d24 * sin4);
                double d37 = d19;
                Path path2 = path;
                path2.rLineTo(0.0f, 0.0f);
                float f4 = (float) d34;
                Path path3 = path2;
                path3.cubicTo(f4, (float) d36, (float) (d29 - (sin4 * d31)), (float) (d30 - (sin4 * d32)), (float) d29, (float) d30);
                sin = sin;
                d22 = d22;
                d26 = d29;
                d19 = d37;
                d23 = d28;
                d24 = d32;
                cos = d35;
                d14 = d7;
                d27 = d30;
                i4 = i5 + 1;
                ceil = i6;
                d25 = d31;
            }
        }

        private static void drawArc(Path path, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z4, boolean z5) {
            double d5;
            double d6;
            float f11 = f4;
            float f12 = f6;
            float f13 = f10;
            double radians = Math.toRadians((double) f13);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d7 = (double) f11;
            float f14 = f5;
            double d8 = (double) f14;
            double d9 = d8;
            double d10 = d7;
            double d11 = (double) f8;
            double d12 = ((d7 * cos) + (d8 * sin)) / d11;
            double d13 = (double) f9;
            double d14 = ((((double) (-f11)) * sin) + (d9 * cos)) / d13;
            float f15 = f7;
            double d15 = (double) f15;
            double d16 = ((((double) f12) * cos) + (d15 * sin)) / d11;
            double d17 = ((((double) (-f12)) * sin) + (d15 * cos)) / d13;
            double d18 = d12 - d16;
            double d19 = d14 - d17;
            double d20 = (d12 + d16) / 2.0d;
            double d21 = (d14 + d17) / 2.0d;
            double d22 = d17;
            double d23 = (d18 * d18) + (d19 * d19);
            if (d23 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d23);
                float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                drawArc(path, f4, f14, f12, f15, f8 * sqrt, sqrt * f9, f13, z4, z5);
                return;
            }
            boolean z6 = z5;
            double sqrt2 = Math.sqrt(d24);
            double d25 = d18 * sqrt2;
            double d26 = sqrt2 * d19;
            if (z4 == z6) {
                d6 = d20 - d26;
                d5 = d21 + d25;
            } else {
                d6 = d20 + d26;
                d5 = d21 - d25;
            }
            double atan2 = Math.atan2(d14 - d5, d12 - d6);
            double atan22 = Math.atan2(d22 - d5, d16 - d6) - atan2;
            int i4 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z6 != (i4 >= 0)) {
                atan22 = i4 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d27 = d6 * d11;
            double d28 = d5 * d13;
            arcToBezier(path, (d27 * cos) - (d28 * sin), (d27 * sin) + (d28 * cos), d11, d13, d10, d9, radians, atan2, atan22);
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f4) {
            this.mType = pathDataNode.mType;
            int i4 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i4 < fArr.length) {
                    this.mParams[i4] = (fArr[i4] * (1.0f - f4)) + (pathDataNode2.mParams[i4] * f4);
                    i4++;
                } else {
                    return;
                }
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f4) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i4 = 0; i4 < pathDataNodeArr.length; i4++) {
                pathDataNodeArr[i4].interpolatePathDataNode(pathDataNodeArr2[i4], pathDataNodeArr3[i4], f4);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
