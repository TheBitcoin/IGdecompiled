package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i4 = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        byte b5 = this.scratch.data[0] & 255;
        if (b5 == 0) {
            return Long.MIN_VALUE;
        }
        int i5 = 128;
        int i6 = 0;
        while ((b5 & i5) == 0) {
            i5 >>= 1;
            i6++;
        }
        int i7 = b5 & (~i5);
        extractorInput.peekFully(this.scratch.data, 1, i6);
        while (i4 < i6) {
            i4++;
            i7 = (this.scratch.data[i4] & 255) + (i7 << 8);
        }
        this.peekLength += i6 + 1;
        return (long) i7;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        long readUint;
        int i4;
        long length = extractorInput.getLength();
        long j4 = 1024;
        int i5 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i5 != 0 && length <= 1024) {
            j4 = length;
        }
        int i6 = (int) j4;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long readUnsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (readUnsignedInt != 440786851) {
            int i7 = this.peekLength + 1;
            this.peekLength = i7;
            if (i7 == i6) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            readUnsignedInt = ((readUnsignedInt << 8) & -256) | ((long) (this.scratch.data[0] & 255));
        }
        long readUint2 = readUint(extractorInput);
        long j5 = (long) this.peekLength;
        if (readUint2 != Long.MIN_VALUE && (i5 == 0 || j5 + readUint2 < length)) {
            while (true) {
                int i8 = this.peekLength;
                long j6 = j5 + readUint2;
                if (((long) i8) < j6) {
                    if (readUint(extractorInput) != Long.MIN_VALUE && readUint >= 0 && readUint <= 2147483647L) {
                        if (i4 != 0) {
                            int readUint3 = (int) (readUint = readUint(extractorInput));
                            extractorInput.advancePeekPosition(readUint3);
                            this.peekLength += readUint3;
                        }
                    }
                } else if (((long) i8) == j6) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
