package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

interface EbmlReaderOutput {
    public static final int TYPE_BINARY = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_MASTER = 1;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UNSIGNED_INT = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int i4, int i5, ExtractorInput extractorInput) throws IOException, InterruptedException;

    void endMasterElement(int i4) throws ParserException;

    void floatElement(int i4, double d5) throws ParserException;

    int getElementType(int i4);

    void integerElement(int i4, long j4) throws ParserException;

    boolean isLevel1Element(int i4);

    void startMasterElement(int i4, long j4, long j5) throws ParserException;

    void stringElement(int i4, String str) throws ParserException;
}
