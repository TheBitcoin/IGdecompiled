package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

public final class DummyTrackOutput implements TrackOutput {
    public final void format(Format format) {
    }

    public final int sampleData(ExtractorInput extractorInput, int i4, boolean z4) throws IOException, InterruptedException {
        int skip = extractorInput.skip(i4);
        if (skip != -1) {
            return skip;
        }
        if (z4) {
            return -1;
        }
        throw new EOFException();
    }

    public final void sampleMetadata(long j4, int i4, int i5, int i6, TrackOutput.CryptoData cryptoData) {
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i4) {
        parsableByteArray.skipBytes(i4);
    }
}
