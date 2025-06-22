package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataSource dataSource;
    private byte[] peekBuffer = new byte[65536];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace = new byte[4096];
    private final long streamLength;

    public DefaultExtractorInput(DataSource dataSource2, long j4, long j5) {
        this.dataSource = dataSource2;
        this.position = j4;
        this.streamLength = j5;
    }

    private void commitBytesRead(int i4) {
        if (i4 != -1) {
            this.position += (long) i4;
        }
    }

    private void ensureSpaceForPeek(int i4) {
        int i5 = this.peekBufferPosition + i4;
        byte[] bArr = this.peekBuffer;
        if (i5 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i5, i5 + 524288));
        }
    }

    private int readFromDataSource(byte[] bArr, int i4, int i5, int i6, boolean z4) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.dataSource.read(bArr, i4 + i6, i5 - i6);
            if (read != -1) {
                return i6 + read;
            }
            if (i6 == 0 && z4) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private int readFromPeekBuffer(byte[] bArr, int i4, int i5) {
        int i6 = this.peekBufferLength;
        if (i6 == 0) {
            return 0;
        }
        int min = Math.min(i6, i5);
        System.arraycopy(this.peekBuffer, 0, bArr, i4, min);
        updatePeekBuffer(min);
        return min;
    }

    private int skipFromPeekBuffer(int i4) {
        int min = Math.min(this.peekBufferLength, i4);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i4) {
        byte[] bArr;
        int i5 = this.peekBufferLength - i4;
        this.peekBufferLength = i5;
        this.peekBufferPosition = 0;
        byte[] bArr2 = this.peekBuffer;
        if (i5 < bArr2.length - 524288) {
            bArr = new byte[(65536 + i5)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i4, bArr, 0, i5);
        this.peekBuffer = bArr;
    }

    public final boolean advancePeekPosition(int i4, boolean z4) throws IOException, InterruptedException {
        ensureSpaceForPeek(i4);
        int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i4);
        while (min < i4) {
            int i5 = i4;
            boolean z5 = z4;
            min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i5, min, z5);
            if (min == -1) {
                return false;
            }
            i4 = i5;
            z4 = z5;
        }
        int i6 = this.peekBufferPosition + i4;
        this.peekBufferPosition = i6;
        this.peekBufferLength = Math.max(this.peekBufferLength, i6);
        return true;
    }

    public final long getLength() {
        return this.streamLength;
    }

    public final long getPeekPosition() {
        return this.position + ((long) this.peekBufferPosition);
    }

    public final long getPosition() {
        return this.position;
    }

    public final boolean peekFully(byte[] bArr, int i4, int i5, boolean z4) throws IOException, InterruptedException {
        if (!advancePeekPosition(i5, z4)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i5, bArr, i4, i5);
        return true;
    }

    public final int read(byte[] bArr, int i4, int i5) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i4, i5);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromDataSource(bArr, i4, i5, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    public final boolean readFully(byte[] bArr, int i4, int i5, boolean z4) throws IOException, InterruptedException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i4, i5);
        while (readFromPeekBuffer < i5 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromDataSource(bArr, i4, i5, readFromPeekBuffer, z4);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    public final void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    public final <E extends Throwable> void setRetryPosition(long j4, E e5) throws Throwable {
        boolean z4;
        if (j4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        this.position = j4;
        throw e5;
    }

    public final int skip(int i4) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i4);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i4, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    public final boolean skipFully(int i4, boolean z4) throws IOException, InterruptedException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i4);
        while (skipFromPeekBuffer < i4 && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromDataSource(this.scratchSpace, -skipFromPeekBuffer, Math.min(i4, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z4);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }

    public final void peekFully(byte[] bArr, int i4, int i5) throws IOException, InterruptedException {
        peekFully(bArr, i4, i5, false);
    }

    public final void readFully(byte[] bArr, int i4, int i5) throws IOException, InterruptedException {
        readFully(bArr, i4, i5, false);
    }

    public final void advancePeekPosition(int i4) throws IOException, InterruptedException {
        advancePeekPosition(i4, false);
    }

    public final void skipFully(int i4) throws IOException, InterruptedException {
        skipFully(i4, false);
    }
}
