package com.mbridge.msdk.playercommon.exoplayer2.video;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    private AvcConfig(List<byte[]> list, int i4, int i5, int i6, float f4) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i4;
        this.width = i5;
        this.height = i6;
        this.pixelWidthAspectRatio = f4;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, readUnsignedShort);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        float f4;
        int i4;
        int i5;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i6 = 0; i6 < readUnsignedByte2; i6++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i7 = 0; i7 < readUnsignedByte3; i7++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i8 = parseSpsNalUnit.width;
                    int i9 = parseSpsNalUnit.height;
                    f4 = parseSpsNalUnit.pixelWidthAspectRatio;
                    i5 = i8;
                    i4 = i9;
                } else {
                    i5 = -1;
                    i4 = -1;
                    f4 = 1.0f;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i5, i4, f4);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw new ParserException("Error parsing AVC config", e5);
        }
    }
}
