package com.mbridge.msdk.playercommon.exoplayer2.extractor.flv;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class ScriptTagPayloadReader extends TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final String KEY_DURATION = "duration";
    private static final String NAME_METADATA = "onMetaData";
    private long durationUs = C.TIME_UNSET;

    public ScriptTagPayloadReader() {
        super((TrackOutput) null);
    }

    private static Boolean readAmfBoolean(ParsableByteArray parsableByteArray) {
        boolean z4 = true;
        if (parsableByteArray.readUnsignedByte() != 1) {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    private static Object readAmfData(ParsableByteArray parsableByteArray, int i4) {
        if (i4 == 0) {
            return readAmfDouble(parsableByteArray);
        }
        if (i4 == 1) {
            return readAmfBoolean(parsableByteArray);
        }
        if (i4 == 2) {
            return readAmfString(parsableByteArray);
        }
        if (i4 == 3) {
            return readAmfObject(parsableByteArray);
        }
        if (i4 == 8) {
            return readAmfEcmaArray(parsableByteArray);
        }
        if (i4 == 10) {
            return readAmfStrictArray(parsableByteArray);
        }
        if (i4 != 11) {
            return null;
        }
        return readAmfDate(parsableByteArray);
    }

    private static Date readAmfDate(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) readAmfDouble(parsableByteArray).doubleValue());
        parsableByteArray.skipBytes(2);
        return date;
    }

    private static Double readAmfDouble(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
    }

    private static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap<String, Object> hashMap = new HashMap<>(readUnsignedIntToInt);
        for (int i4 = 0; i4 < readUnsignedIntToInt; i4++) {
            hashMap.put(readAmfString(parsableByteArray), readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return hashMap;
    }

    private static HashMap<String, Object> readAmfObject(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String readAmfString = readAmfString(parsableByteArray);
            int readAmfType = readAmfType(parsableByteArray);
            if (readAmfType == 9) {
                return hashMap;
            }
            hashMap.put(readAmfString, readAmfData(parsableByteArray, readAmfType));
        }
    }

    private static ArrayList<Object> readAmfStrictArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        ArrayList<Object> arrayList = new ArrayList<>(readUnsignedIntToInt);
        for (int i4 = 0; i4 < readUnsignedIntToInt; i4++) {
            arrayList.add(readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return arrayList;
    }

    private static String readAmfString(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new String(parsableByteArray.data, position, readUnsignedShort);
    }

    private static int readAmfType(ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    /* access modifiers changed from: protected */
    public final boolean parseHeader(ParsableByteArray parsableByteArray) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void parsePayload(ParsableByteArray parsableByteArray, long j4) throws ParserException {
        if (readAmfType(parsableByteArray) != 2) {
            throw new ParserException();
        } else if (NAME_METADATA.equals(readAmfString(parsableByteArray)) && readAmfType(parsableByteArray) == 8) {
            HashMap<String, Object> readAmfEcmaArray = readAmfEcmaArray(parsableByteArray);
            if (readAmfEcmaArray.containsKey("duration")) {
                double doubleValue = ((Double) readAmfEcmaArray.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.durationUs = (long) (doubleValue * 1000000.0d);
                }
            }
        }
    }

    public final void seek() {
    }
}
