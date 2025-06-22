package com.mbridge.msdk.playercommon.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class PgsDecoder extends SimpleSubtitleDecoder {
    private static final byte INFLATE_HEADER = 120;
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 128;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final ParsableByteArray buffer = new ParsableByteArray();
    private final CueBuilder cueBuilder = new CueBuilder();
    private byte[] inflatedData;
    private int inflatedDataSize;
    private Inflater inflater;

    private static final class CueBuilder {
        private final ParsableByteArray bitmapData = new ParsableByteArray();
        private int bitmapHeight;
        private int bitmapWidth;
        private int bitmapX;
        private int bitmapY;
        private final int[] colors = new int[256];
        private boolean colorsSet;
        private int planeHeight;
        private int planeWidth;

        /* access modifiers changed from: private */
        public void parseBitmapSection(ParsableByteArray parsableByteArray, int i4) {
            boolean z4;
            int readUnsignedInt24;
            if (i4 >= 4) {
                parsableByteArray.skipBytes(3);
                if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i5 = i4 - 4;
                if (z4) {
                    if (i5 >= 7 && (readUnsignedInt24 = parsableByteArray.readUnsignedInt24()) >= 4) {
                        this.bitmapWidth = parsableByteArray.readUnsignedShort();
                        this.bitmapHeight = parsableByteArray.readUnsignedShort();
                        this.bitmapData.reset(readUnsignedInt24 - 4);
                        i5 = i4 - 11;
                    } else {
                        return;
                    }
                }
                int position = this.bitmapData.getPosition();
                int limit = this.bitmapData.limit();
                if (position < limit && i5 > 0) {
                    int min = Math.min(i5, limit - position);
                    parsableByteArray.readBytes(this.bitmapData.data, position, min);
                    this.bitmapData.setPosition(position + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void parseIdentifierSection(ParsableByteArray parsableByteArray, int i4) {
            if (i4 >= 19) {
                this.planeWidth = parsableByteArray.readUnsignedShort();
                this.planeHeight = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(11);
                this.bitmapX = parsableByteArray.readUnsignedShort();
                this.bitmapY = parsableByteArray.readUnsignedShort();
            }
        }

        /* access modifiers changed from: private */
        public void parsePaletteSection(ParsableByteArray parsableByteArray, int i4) {
            if (i4 % 5 == 2) {
                ParsableByteArray parsableByteArray2 = parsableByteArray;
                parsableByteArray2.skipBytes(2);
                Arrays.fill(this.colors, 0);
                int i5 = i4 / 5;
                for (int i6 = 0; i6 < i5; i6++) {
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                    int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                    int readUnsignedByte4 = parsableByteArray2.readUnsignedByte();
                    int readUnsignedByte5 = parsableByteArray2.readUnsignedByte();
                    double d5 = (double) readUnsignedByte2;
                    double d6 = (double) (readUnsignedByte3 - 128);
                    double d7 = (double) (readUnsignedByte4 - 128);
                    this.colors[readUnsignedByte] = (Util.constrainValue((int) ((d5 - (0.34414d * d7)) - (d6 * 0.71414d)), 0, 255) << 8) | (readUnsignedByte5 << 24) | (Util.constrainValue((int) ((1.402d * d6) + d5), 0, 255) << 16) | Util.constrainValue((int) (d5 + (d7 * 1.772d)), 0, 255);
                }
                this.colorsSet = true;
            }
        }

        public final Cue build() {
            int i4;
            int i5;
            int i6;
            if (this.planeWidth == 0 || this.planeHeight == 0 || this.bitmapWidth == 0 || this.bitmapHeight == 0 || this.bitmapData.limit() == 0 || this.bitmapData.getPosition() != this.bitmapData.limit() || !this.colorsSet) {
                return null;
            }
            this.bitmapData.setPosition(0);
            int i7 = this.bitmapWidth * this.bitmapHeight;
            int[] iArr = new int[i7];
            int i8 = 0;
            while (i8 < i7) {
                int readUnsignedByte = this.bitmapData.readUnsignedByte();
                if (readUnsignedByte != 0) {
                    i6 = i8 + 1;
                    iArr[i8] = this.colors[readUnsignedByte];
                } else {
                    int readUnsignedByte2 = this.bitmapData.readUnsignedByte();
                    if (readUnsignedByte2 != 0) {
                        if ((readUnsignedByte2 & 64) == 0) {
                            i4 = readUnsignedByte2 & 63;
                        } else {
                            i4 = ((readUnsignedByte2 & 63) << 8) | this.bitmapData.readUnsignedByte();
                        }
                        if ((readUnsignedByte2 & 128) == 0) {
                            i5 = 0;
                        } else {
                            i5 = this.colors[this.bitmapData.readUnsignedByte()];
                        }
                        i6 = i4 + i8;
                        Arrays.fill(iArr, i8, i6, i5);
                    }
                }
                i8 = i6;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888);
            int i9 = this.planeWidth;
            float f4 = ((float) this.bitmapX) / ((float) i9);
            int i10 = this.planeHeight;
            return new Cue(createBitmap, f4, 0, ((float) this.bitmapY) / ((float) i10), 0, ((float) this.bitmapWidth) / ((float) i9), ((float) this.bitmapHeight) / ((float) i10));
        }

        public final void reset() {
            this.planeWidth = 0;
            this.planeHeight = 0;
            this.bitmapX = 0;
            this.bitmapY = 0;
            this.bitmapWidth = 0;
            this.bitmapHeight = 0;
            this.bitmapData.reset(0);
            this.colorsSet = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
    }

    private boolean maybeInflateData(byte[] bArr, int i4) {
        if (i4 != 0 && bArr[0] == 120) {
            if (this.inflater == null) {
                this.inflater = new Inflater();
                this.inflatedData = new byte[i4];
            }
            this.inflatedDataSize = 0;
            this.inflater.setInput(bArr, 0, i4);
            while (!this.inflater.finished() && !this.inflater.needsDictionary() && !this.inflater.needsInput()) {
                try {
                    int i5 = this.inflatedDataSize;
                    byte[] bArr2 = this.inflatedData;
                    if (i5 == bArr2.length) {
                        this.inflatedData = Arrays.copyOf(bArr2, bArr2.length * 2);
                    }
                    int i6 = this.inflatedDataSize;
                    Inflater inflater2 = this.inflater;
                    byte[] bArr3 = this.inflatedData;
                    this.inflatedDataSize = i6 + inflater2.inflate(bArr3, i6, bArr3.length - i6);
                } catch (DataFormatException unused) {
                    this.inflater.reset();
                } catch (Throwable th) {
                    this.inflater.reset();
                    throw th;
                }
            }
            boolean finished = this.inflater.finished();
            this.inflater.reset();
            return finished;
        }
        return false;
    }

    private static Cue readNextSection(ParsableByteArray parsableByteArray, CueBuilder cueBuilder2) {
        int limit = parsableByteArray.limit();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition() + readUnsignedShort;
        Cue cue = null;
        if (position > limit) {
            parsableByteArray.setPosition(limit);
            return null;
        }
        if (readUnsignedByte != 128) {
            switch (readUnsignedByte) {
                case 20:
                    cueBuilder2.parsePaletteSection(parsableByteArray, readUnsignedShort);
                    break;
                case 21:
                    cueBuilder2.parseBitmapSection(parsableByteArray, readUnsignedShort);
                    break;
                case 22:
                    cueBuilder2.parseIdentifierSection(parsableByteArray, readUnsignedShort);
                    break;
            }
        } else {
            cue = cueBuilder2.build();
            cueBuilder2.reset();
        }
        parsableByteArray.setPosition(position);
        return cue;
    }

    /* access modifiers changed from: protected */
    public final Subtitle decode(byte[] bArr, int i4, boolean z4) throws SubtitleDecoderException {
        if (maybeInflateData(bArr, i4)) {
            this.buffer.reset(this.inflatedData, this.inflatedDataSize);
        } else {
            this.buffer.reset(bArr, i4);
        }
        this.cueBuilder.reset();
        ArrayList arrayList = new ArrayList();
        while (this.buffer.bytesLeft() >= 3) {
            Cue readNextSection = readNextSection(this.buffer, this.cueBuilder);
            if (readNextSection != null) {
                arrayList.add(readNextSection);
            }
        }
        return new PgsSubtitle(DesugarCollections.unmodifiableList(arrayList));
    }
}
