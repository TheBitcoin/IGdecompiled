package com.mbridge.msdk.playercommon.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DvbParser {
    private static final int DATA_TYPE_24_TABLE_DATA = 32;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 240;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    private static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas = new Canvas();
    private final ClutDefinition defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
    private final DisplayDefinition defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    private static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;
        public final int id;

        public ClutDefinition(int i4, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i4;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    private static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i4, int i5, int i6, int i7, int i8, int i9) {
            this.width = i4;
            this.height = i5;
            this.horizontalPositionMinimum = i6;
            this.horizontalPositionMaximum = i7;
            this.verticalPositionMinimum = i8;
            this.verticalPositionMaximum = i9;
        }
    }

    private static final class ObjectData {
        public final byte[] bottomFieldData;
        public final int id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i4, boolean z4, byte[] bArr, byte[] bArr2) {
            this.id = i4;
            this.nonModifyingColorFlag = z4;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    private static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i4, int i5, int i6, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i4;
            this.version = i5;
            this.state = i6;
            this.regions = sparseArray;
        }
    }

    private static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i4, int i5) {
            this.horizontalAddress = i4;
            this.verticalAddress = i5;
        }
    }

    private static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;
        public final int id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i4, boolean z4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, SparseArray<RegionObject> sparseArray) {
            this.id = i4;
            this.fillFlag = z4;
            this.width = i5;
            this.height = i6;
            this.levelOfCompatibility = i7;
            this.depth = i8;
            this.clutId = i9;
            this.pixelCode8Bit = i10;
            this.pixelCode4Bit = i11;
            this.pixelCode2Bit = i12;
            this.regionObjects = sparseArray;
        }

        public final void mergeFrom(RegionComposition regionComposition) {
            if (regionComposition != null) {
                SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
                for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                    this.regionObjects.put(sparseArray.keyAt(i4), sparseArray.valueAt(i4));
                }
            }
        }
    }

    private static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i4, int i5, int i6, int i7, int i8, int i9) {
            this.type = i4;
            this.provider = i5;
            this.horizontalPosition = i6;
            this.verticalPosition = i7;
            this.foregroundPixelCode = i8;
            this.backgroundPixelCode = i9;
        }
    }

    private static final class SubtitleService {
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();
        public final int ancillaryPageId;
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public DisplayDefinition displayDefinition;
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public PageComposition pageComposition;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final int subtitlePageId;

        public SubtitleService(int i4, int i5) {
            this.subtitlePageId = i4;
            this.ancillaryPageId = i5;
        }

        public final void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    public DvbParser(int i4, int i5) {
        Paint paint = new Paint();
        this.defaultPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.fillRegionPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.subtitleService = new SubtitleService(i4, i5);
    }

    private static byte[] buildClutMapTable(int i4, int i5, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr[i6] = (byte) parsableBitArray.readBits(i5);
        }
        return bArr;
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i9 = 1; i9 < 16; i9++) {
            if (i9 < 8) {
                if ((i9 & 1) != 0) {
                    i6 = 255;
                } else {
                    i6 = 0;
                }
                if ((i9 & 2) != 0) {
                    i7 = 255;
                } else {
                    i7 = 0;
                }
                if ((i9 & 4) != 0) {
                    i8 = 255;
                } else {
                    i8 = 0;
                }
                iArr[i9] = getColor(255, i6, i7, i8);
            } else {
                int i10 = i9 & 1;
                int i11 = ModuleDescriptor.MODULE_VERSION;
                if (i10 != 0) {
                    i4 = ModuleDescriptor.MODULE_VERSION;
                } else {
                    i4 = 0;
                }
                if ((i9 & 2) != 0) {
                    i5 = ModuleDescriptor.MODULE_VERSION;
                } else {
                    i5 = 0;
                }
                if ((i9 & 4) == 0) {
                    i11 = 0;
                }
                iArr[i9] = getColor(255, i4, i5, i11);
            }
        }
        return iArr;
    }

    private static int[] generateDefault8BitClutEntries() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i22 = 0; i22 < 256; i22++) {
            int i23 = 255;
            if (i22 < 8) {
                if ((i22 & 1) != 0) {
                    i20 = 255;
                } else {
                    i20 = 0;
                }
                if ((i22 & 2) != 0) {
                    i21 = 255;
                } else {
                    i21 = 0;
                }
                if ((i22 & 4) == 0) {
                    i23 = 0;
                }
                iArr[i22] = getColor(63, i20, i21, i23);
            } else {
                int i24 = i22 & 136;
                int i25 = 170;
                int i26 = 85;
                if (i24 == 0) {
                    if ((i22 & 1) != 0) {
                        i4 = 85;
                    } else {
                        i4 = 0;
                    }
                    if ((i22 & 16) != 0) {
                        i5 = 170;
                    } else {
                        i5 = 0;
                    }
                    int i27 = i4 + i5;
                    if ((i22 & 2) != 0) {
                        i6 = 85;
                    } else {
                        i6 = 0;
                    }
                    if ((i22 & 32) != 0) {
                        i7 = 170;
                    } else {
                        i7 = 0;
                    }
                    int i28 = i6 + i7;
                    if ((i22 & 4) == 0) {
                        i26 = 0;
                    }
                    if ((i22 & 64) == 0) {
                        i25 = 0;
                    }
                    iArr[i22] = getColor(255, i27, i28, i26 + i25);
                } else if (i24 != 8) {
                    int i29 = 43;
                    if (i24 == 128) {
                        if ((i22 & 1) != 0) {
                            i12 = 43;
                        } else {
                            i12 = 0;
                        }
                        int i30 = i12 + ModuleDescriptor.MODULE_VERSION;
                        if ((i22 & 16) != 0) {
                            i13 = 85;
                        } else {
                            i13 = 0;
                        }
                        int i31 = i30 + i13;
                        if ((i22 & 2) != 0) {
                            i14 = 43;
                        } else {
                            i14 = 0;
                        }
                        int i32 = i14 + ModuleDescriptor.MODULE_VERSION;
                        if ((i22 & 32) != 0) {
                            i15 = 85;
                        } else {
                            i15 = 0;
                        }
                        int i33 = i32 + i15;
                        if ((i22 & 4) == 0) {
                            i29 = 0;
                        }
                        int i34 = i29 + ModuleDescriptor.MODULE_VERSION;
                        if ((i22 & 64) == 0) {
                            i26 = 0;
                        }
                        iArr[i22] = getColor(255, i31, i33, i34 + i26);
                    } else if (i24 == 136) {
                        if ((i22 & 1) != 0) {
                            i16 = 43;
                        } else {
                            i16 = 0;
                        }
                        if ((i22 & 16) != 0) {
                            i17 = 85;
                        } else {
                            i17 = 0;
                        }
                        int i35 = i16 + i17;
                        if ((i22 & 2) != 0) {
                            i18 = 43;
                        } else {
                            i18 = 0;
                        }
                        if ((i22 & 32) != 0) {
                            i19 = 85;
                        } else {
                            i19 = 0;
                        }
                        int i36 = i18 + i19;
                        if ((i22 & 4) == 0) {
                            i29 = 0;
                        }
                        if ((i22 & 64) == 0) {
                            i26 = 0;
                        }
                        iArr[i22] = getColor(255, i35, i36, i29 + i26);
                    }
                } else {
                    if ((i22 & 1) != 0) {
                        i8 = 85;
                    } else {
                        i8 = 0;
                    }
                    if ((i22 & 16) != 0) {
                        i9 = 170;
                    } else {
                        i9 = 0;
                    }
                    int i37 = i8 + i9;
                    if ((i22 & 2) != 0) {
                        i10 = 85;
                    } else {
                        i10 = 0;
                    }
                    if ((i22 & 32) != 0) {
                        i11 = 170;
                    } else {
                        i11 = 0;
                    }
                    int i38 = i10 + i11;
                    if ((i22 & 4) == 0) {
                        i26 = 0;
                    }
                    if ((i22 & 64) == 0) {
                        i25 = 0;
                    }
                    iArr[i22] = getColor(ModuleDescriptor.MODULE_VERSION, i37, i38, i26 + i25);
                }
            }
        }
        return iArr;
    }

    private static int getColor(int i4, int i5, int i6, int i7) {
        return (i4 << 24) | (i5 << 16) | (i6 << 8) | i7;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[LOOP:0: B:1:0x0002->B:31:0x0078, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint2BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = 0
        L_0x0002:
            r1 = 2
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000d
            r7 = r0
        L_0x000b:
            r8 = 1
            goto L_0x005a
        L_0x000d:
            boolean r2 = r9.readBit()
            r4 = 3
            if (r2 == 0) goto L_0x0021
            int r2 = r9.readBits(r4)
            int r2 = r2 + r4
            int r1 = r9.readBits(r1)
        L_0x001d:
            r7 = r0
            r8 = r2
            r2 = r1
            goto L_0x005a
        L_0x0021:
            boolean r2 = r9.readBit()
            if (r2 == 0) goto L_0x002a
            r7 = r0
            r2 = 0
            goto L_0x000b
        L_0x002a:
            int r2 = r9.readBits(r1)
            if (r2 == 0) goto L_0x0057
            if (r2 == r3) goto L_0x0053
            if (r2 == r1) goto L_0x0047
            if (r2 == r4) goto L_0x003a
            r7 = r0
            r2 = 0
        L_0x0038:
            r8 = 0
            goto L_0x005a
        L_0x003a:
            r2 = 8
            int r2 = r9.readBits(r2)
            int r2 = r2 + 29
            int r1 = r9.readBits(r1)
            goto L_0x001d
        L_0x0047:
            r2 = 4
            int r2 = r9.readBits(r2)
            int r2 = r2 + 12
            int r1 = r9.readBits(r1)
            goto L_0x001d
        L_0x0053:
            r7 = r0
            r2 = 0
            r8 = 2
            goto L_0x005a
        L_0x0057:
            r2 = 0
            r7 = 1
            goto L_0x0038
        L_0x005a:
            if (r8 == 0) goto L_0x0074
            if (r14 == 0) goto L_0x0074
            if (r11 == 0) goto L_0x0062
            byte r2 = r11[r2]
        L_0x0062:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0074:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x0078
            return r12
        L_0x0078:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint2BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[LOOP:0: B:1:0x0002->B:34:0x0085, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint4BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = 0
        L_0x0002:
            r1 = 4
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            r7 = r0
        L_0x000b:
            r8 = 1
            goto L_0x0067
        L_0x000e:
            boolean r2 = r9.readBit()
            r4 = 3
            if (r2 != 0) goto L_0x0025
            int r1 = r9.readBits(r4)
            if (r1 == 0) goto L_0x0021
            int r1 = r1 + 2
            r7 = r0
            r8 = r1
            r2 = 0
            goto L_0x0067
        L_0x0021:
            r2 = 0
            r7 = 1
        L_0x0023:
            r8 = 0
            goto L_0x0067
        L_0x0025:
            boolean r2 = r9.readBit()
            r7 = 2
            if (r2 != 0) goto L_0x0039
            int r2 = r9.readBits(r7)
            int r2 = r2 + r1
            int r1 = r9.readBits(r1)
        L_0x0035:
            r7 = r0
            r8 = r2
            r2 = r1
            goto L_0x0067
        L_0x0039:
            int r2 = r9.readBits(r7)
            if (r2 == 0) goto L_0x0064
            if (r2 == r3) goto L_0x0060
            if (r2 == r7) goto L_0x0055
            if (r2 == r4) goto L_0x0048
            r7 = r0
            r2 = 0
            goto L_0x0023
        L_0x0048:
            r2 = 8
            int r2 = r9.readBits(r2)
            int r2 = r2 + 25
            int r1 = r9.readBits(r1)
            goto L_0x0035
        L_0x0055:
            int r2 = r9.readBits(r1)
            int r2 = r2 + 9
            int r1 = r9.readBits(r1)
            goto L_0x0035
        L_0x0060:
            r7 = r0
            r2 = 0
            r8 = 2
            goto L_0x0067
        L_0x0064:
            r7 = r0
            r2 = 0
            goto L_0x000b
        L_0x0067:
            if (r8 == 0) goto L_0x0081
            if (r14 == 0) goto L_0x0081
            if (r11 == 0) goto L_0x006f
            byte r2 = r11[r2]
        L_0x006f:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0081:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x0085
            return r12
        L_0x0085:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint4BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint8BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray r9, int[] r10, byte[] r11, int r12, int r13, android.graphics.Paint r14, android.graphics.Canvas r15) {
        /*
            r6 = 0
            r0 = 0
        L_0x0002:
            r1 = 8
            int r2 = r9.readBits(r1)
            r3 = 1
            if (r2 == 0) goto L_0x000e
            r7 = r0
            r8 = 1
            goto L_0x002e
        L_0x000e:
            boolean r2 = r9.readBit()
            r4 = 7
            if (r2 != 0) goto L_0x0023
            int r1 = r9.readBits(r4)
            if (r1 == 0) goto L_0x001f
            r7 = r0
            r8 = r1
            r2 = 0
            goto L_0x002e
        L_0x001f:
            r2 = 0
            r7 = 1
            r8 = 0
            goto L_0x002e
        L_0x0023:
            int r2 = r9.readBits(r4)
            int r1 = r9.readBits(r1)
            r7 = r0
            r8 = r2
            r2 = r1
        L_0x002e:
            if (r8 == 0) goto L_0x0048
            if (r14 == 0) goto L_0x0048
            if (r11 == 0) goto L_0x0036
            byte r2 = r11[r2]
        L_0x0036:
            r0 = r10[r2]
            r14.setColor(r0)
            float r1 = (float) r12
            float r2 = (float) r13
            int r0 = r12 + r8
            float r0 = (float) r0
            int r3 = r3 + r13
            float r4 = (float) r3
            r5 = r14
            r3 = r0
            r0 = r15
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0048:
            int r12 = r12 + r8
            if (r7 == 0) goto L_0x004c
            return r12
        L_0x004c:
            r0 = r7
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbParser.paint8BitPixelCodeString(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i4, int i5, int i6, Paint paint, Canvas canvas2) {
        Canvas canvas3;
        Paint paint2;
        int[] iArr2;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        byte[] bArr5 = null;
        int i7 = i5;
        int i8 = i6;
        byte[] bArr6 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        iArr2 = iArr;
                        Paint paint3 = paint;
                        canvas3 = canvas2;
                        if (i4 != 3) {
                            if (i4 != 2) {
                                bArr2 = null;
                                paint2 = paint3;
                                i7 = paint2BitPixelCodeString(parsableBitArray, iArr2, bArr2, i7, i8, paint2, canvas3);
                                parsableBitArray.byteAlign();
                                break;
                            } else if (bArr5 == null) {
                                bArr3 = defaultMap2To4;
                            } else {
                                bArr3 = bArr5;
                            }
                        } else if (bArr6 == null) {
                            bArr3 = defaultMap2To8;
                        } else {
                            bArr3 = bArr6;
                        }
                        paint2 = paint3;
                        bArr2 = bArr3;
                        i7 = paint2BitPixelCodeString(parsableBitArray, iArr2, bArr2, i7, i8, paint2, canvas3);
                        parsableBitArray.byteAlign();
                    case 17:
                        iArr2 = iArr;
                        Paint paint4 = paint;
                        canvas3 = canvas2;
                        if (i4 == 3) {
                            bArr4 = defaultMap4To8;
                        } else {
                            bArr4 = null;
                        }
                        paint2 = paint4;
                        i7 = paint4BitPixelCodeString(parsableBitArray, iArr2, bArr4, i7, i8, paint2, canvas3);
                        Paint paint5 = paint2;
                        parsableBitArray.byteAlign();
                        break;
                    case 18:
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas3 = canvas2;
                        i7 = paint8BitPixelCodeString(parsableBitArray, iArr2, (byte[]) null, i7, i8, paint2, canvas3);
                        break;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr5 = buildClutMapTable(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr6 = buildClutMapTable(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr6 = buildClutMapTable(16, 8, parsableBitArray);
                                break;
                        }
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas3 = canvas2;
                        break;
                }
            } else {
                iArr2 = iArr;
                paint2 = paint;
                canvas3 = canvas2;
                i8 += 2;
                i7 = i5;
            }
            iArr = iArr2;
            paint = paint2;
            canvas2 = canvas3;
        }
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i4, int i5, int i6, Paint paint, Canvas canvas2) {
        int[] iArr;
        if (i4 == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i4 == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        int[] iArr2 = iArr;
        int i7 = i4;
        int i8 = i5;
        int i9 = i6;
        Paint paint2 = paint;
        Canvas canvas3 = canvas2;
        paintPixelDataSubBlock(objectData.topFieldData, iArr2, i7, i8, i9, paint2, canvas3);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr2, i7, i8, i9 + 1, paint2, canvas3);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i4) {
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i10 = 8;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(8);
        int i11 = 2;
        int i12 = i4 - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i12 > 0) {
            int readBits2 = parsableBitArray2.readBits(i10);
            int readBits3 = parsableBitArray2.readBits(i10);
            if ((readBits3 & 128) != 0) {
                iArr = generateDefault2BitClutEntries;
            } else if ((readBits3 & 64) != 0) {
                iArr = generateDefault4BitClutEntries;
            } else {
                iArr = generateDefault8BitClutEntries;
            }
            if ((readBits3 & 1) != 0) {
                i8 = parsableBitArray2.readBits(i10);
                i7 = parsableBitArray2.readBits(i10);
                i6 = parsableBitArray2.readBits(i10);
                i5 = parsableBitArray2.readBits(i10);
                i9 = i12 - 6;
            } else {
                i6 = parsableBitArray2.readBits(4) << 4;
                i9 = i12 - 4;
                int readBits4 = parsableBitArray2.readBits(4) << 4;
                i5 = parsableBitArray2.readBits(i11) << 6;
                i8 = parsableBitArray2.readBits(6) << i11;
                i7 = readBits4;
            }
            if (i8 == 0) {
                i7 = 0;
                i6 = 0;
                i5 = 255;
            }
            double d5 = (double) i8;
            double d6 = (double) (i7 - 128);
            double d7 = (double) (i6 - 128);
            iArr[readBits2] = getColor((byte) (255 - (i5 & 255)), Util.constrainValue((int) (d5 + (1.402d * d6)), 0, 255), Util.constrainValue((int) ((d5 - (0.34414d * d7)) - (d6 * 0.71414d)), 0, 255), Util.constrainValue((int) (d5 + (d7 * 1.772d)), 0, 255));
            i12 = i9;
            readBits = readBits;
            i10 = 8;
            i11 = 2;
        }
        return new ClutDefinition(readBits, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i4;
        int i5;
        int i6;
        int i7;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i4 = parsableBitArray.readBits(16);
            i6 = readBits4;
            i5 = readBits5;
            i7 = readBits3;
        } else {
            i6 = readBits;
            i4 = readBits2;
            i7 = 0;
            i5 = 0;
        }
        return new DisplayDefinition(readBits, readBits2, i7, i6, i5, i4);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = null;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new ObjectData(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(readBits, readBit, bArr2, bArr);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i4) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i5 = i4 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i5 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i5 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i4) {
        int i5;
        int i6;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int readBits = parsableBitArray2.readBits(8);
        int i7 = 4;
        parsableBitArray2.skipBits(4);
        boolean readBit = parsableBitArray2.readBit();
        parsableBitArray2.skipBits(3);
        int i8 = 16;
        int readBits2 = parsableBitArray2.readBits(16);
        int readBits3 = parsableBitArray2.readBits(16);
        int i9 = readBits2;
        int readBits4 = parsableBitArray2.readBits(3);
        int readBits5 = parsableBitArray2.readBits(3);
        int i10 = 2;
        parsableBitArray2.skipBits(2);
        int i11 = readBits3;
        int i12 = readBits5;
        int i13 = i9;
        int readBits6 = parsableBitArray2.readBits(8);
        int readBits7 = parsableBitArray2.readBits(8);
        int i14 = i11;
        int readBits8 = parsableBitArray2.readBits(4);
        int i15 = readBits7;
        int readBits9 = parsableBitArray2.readBits(2);
        parsableBitArray2.skipBits(2);
        int i16 = i4 - 10;
        int i17 = i14;
        SparseArray sparseArray = new SparseArray();
        while (i16 > 0) {
            int readBits10 = parsableBitArray2.readBits(i8);
            int readBits11 = parsableBitArray2.readBits(i10);
            int readBits12 = parsableBitArray2.readBits(i10);
            int readBits13 = parsableBitArray2.readBits(12);
            parsableBitArray2.skipBits(i7);
            int readBits14 = parsableBitArray2.readBits(12);
            int i18 = i16 - 6;
            if (readBits11 != 1) {
                if (readBits11 != 2) {
                    i16 = i18;
                    i6 = 0;
                    i5 = 0;
                    sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i6, i5));
                    i7 = 4;
                    i8 = 16;
                    i10 = 2;
                }
            }
            i16 -= 8;
            i6 = parsableBitArray2.readBits(8);
            i5 = parsableBitArray2.readBits(8);
            sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i6, i5));
            i7 = 4;
            i8 = 16;
            i10 = 2;
        }
        return new RegionComposition(readBits, readBit, i13, i17, readBits4, i12, readBits6, i15, readBits8, readBits9, sparseArray);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService2) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w(TAG, "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    PageComposition pageComposition = subtitleService2.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state == 0) {
                        if (!(pageComposition == null || pageComposition.version == parsePageComposition.version)) {
                            subtitleService2.pageComposition = parsePageComposition;
                            break;
                        }
                    } else {
                        subtitleService2.pageComposition = parsePageComposition;
                        subtitleService2.regions.clear();
                        subtitleService2.cluts.clear();
                        subtitleService2.objects.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService2.pageComposition;
                if (readBits2 == subtitleService2.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0) {
                        parseRegionComposition.mergeFrom(subtitleService2.regions.get(parseRegionComposition.id));
                    }
                    subtitleService2.regions.put(parseRegionComposition.id, parseRegionComposition);
                    break;
                }
            case 18:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                        subtitleService2.ancillaryCluts.put(parseClutDefinition.id, parseClutDefinition);
                        break;
                    }
                } else {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService2.cluts.put(parseClutDefinition2.id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ObjectData parseObjectData = parseObjectData(parsableBitArray);
                        subtitleService2.ancillaryObjects.put(parseObjectData.id, parseObjectData);
                        break;
                    }
                } else {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService2.objects.put(parseObjectData2.id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    subtitleService2.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    public final List<Cue> decode(byte[] bArr, int i4) {
        int i5;
        Paint paint;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i4);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        SubtitleService subtitleService2 = this.subtitleService;
        if (subtitleService2.pageComposition == null) {
            return Collections.EMPTY_LIST;
        }
        DisplayDefinition displayDefinition = subtitleService2.displayDefinition;
        if (displayDefinition == null) {
            displayDefinition = this.defaultDisplayDefinition;
        }
        Bitmap bitmap2 = this.bitmap;
        if (!(bitmap2 != null && displayDefinition.width + 1 == bitmap2.getWidth() && displayDefinition.height + 1 == this.bitmap.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.bitmap = createBitmap;
            this.canvas.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray = this.subtitleService.pageComposition.regions;
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            PageRegion valueAt = sparseArray.valueAt(i6);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray.keyAt(i6));
            int i7 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i8 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            int min = Math.min(regionComposition.width + i7, displayDefinition.horizontalPositionMaximum);
            float f4 = (float) i7;
            float f5 = (float) i8;
            float f6 = (float) min;
            this.canvas.clipRect(f4, f5, f6, (float) Math.min(regionComposition.height + i8, displayDefinition.verticalPositionMaximum), Region.Op.REPLACE);
            float f7 = f5;
            float f8 = f4;
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            ClutDefinition clutDefinition2 = clutDefinition;
            SparseArray<RegionObject> sparseArray2 = regionComposition.regionObjects;
            int i9 = 0;
            while (i9 < sparseArray2.size()) {
                int keyAt = sparseArray2.keyAt(i9);
                RegionObject valueAt2 = sparseArray2.valueAt(i9);
                ObjectData objectData = this.subtitleService.objects.get(keyAt);
                if (objectData == null) {
                    objectData = this.subtitleService.ancillaryObjects.get(keyAt);
                }
                if (objectData != null) {
                    if (objectData.nonModifyingColorFlag) {
                        paint = null;
                    } else {
                        paint = this.defaultPaint;
                    }
                    Paint paint2 = paint;
                    paintPixelDataSubBlocks(objectData, clutDefinition2, regionComposition.depth, i7 + valueAt2.horizontalPosition, i8 + valueAt2.verticalPosition, paint2, this.canvas);
                }
                i9++;
                clutDefinition2 = clutDefinition2;
            }
            ClutDefinition clutDefinition3 = clutDefinition2;
            if (regionComposition.fillFlag) {
                int i10 = regionComposition.depth;
                if (i10 == 3) {
                    i5 = clutDefinition3.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (i10 == 2) {
                    i5 = clutDefinition3.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i5 = clutDefinition3.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i5);
                this.canvas.drawRect(f8, f7, (float) (regionComposition.width + i7), (float) (regionComposition.height + i8), this.fillRegionPaint);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(this.bitmap, i7, i8, regionComposition.width, regionComposition.height);
            int i11 = displayDefinition.width;
            int i12 = displayDefinition.height;
            arrayList.add(new Cue(createBitmap2, f8 / ((float) i11), 0, f7 / ((float) i12), 0, ((float) regionComposition.width) / ((float) i11), ((float) regionComposition.height) / ((float) i12)));
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public final void reset() {
        this.subtitleService.reset();
    }
}
