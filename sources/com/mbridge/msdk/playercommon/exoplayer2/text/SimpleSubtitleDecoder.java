package com.mbridge.msdk.playercommon.exoplayer2.text;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.SimpleDecoder;
import java.nio.ByteBuffer;

public abstract class SimpleSubtitleDecoder extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    private final String name;

    protected SimpleSubtitleDecoder(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        this.name = str;
        setInitialInputBufferSize(1024);
    }

    /* access modifiers changed from: protected */
    public abstract Subtitle decode(byte[] bArr, int i4, boolean z4) throws SubtitleDecoderException;

    public final String getName() {
        return this.name;
    }

    public void setPositionUs(long j4) {
    }

    /* access modifiers changed from: protected */
    public final SubtitleInputBuffer createInputBuffer() {
        return new SubtitleInputBuffer();
    }

    /* access modifiers changed from: protected */
    public final SubtitleOutputBuffer createOutputBuffer() {
        return new SimpleSubtitleOutputBuffer(this);
    }

    /* access modifiers changed from: protected */
    public final SubtitleDecoderException createUnexpectedDecodeException(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public final SubtitleDecoderException decode(SubtitleInputBuffer subtitleInputBuffer, SubtitleOutputBuffer subtitleOutputBuffer, boolean z4) {
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.data;
            SubtitleOutputBuffer subtitleOutputBuffer2 = subtitleOutputBuffer;
            subtitleOutputBuffer2.setContent(subtitleInputBuffer.timeUs, decode(byteBuffer.array(), byteBuffer.limit(), z4), subtitleInputBuffer.subsampleOffsetUs);
            subtitleOutputBuffer2.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e5) {
            return e5;
        }
    }

    /* access modifiers changed from: protected */
    public final void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        super.releaseOutputBuffer(subtitleOutputBuffer);
    }
}
