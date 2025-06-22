package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

final class FileOperator {
    private final FileChannel fileChannel;

    FileOperator(FileChannel fileChannel2) {
        this.fileChannel = fileChannel2;
    }

    public void read(long j4, Buffer buffer, long j5) throws IOException {
        if (j5 >= 0) {
            long j6 = j4;
            long j7 = j5;
            while (j7 > 0) {
                long transferTo = this.fileChannel.transferTo(j6, j7, buffer);
                j6 += transferTo;
                j7 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void write(long j4, Buffer buffer, long j5) throws IOException {
        if (j5 < 0 || j5 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j6 = j4;
        long j7 = j5;
        while (j7 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j6, j7);
            j6 += transferFrom;
            j7 -= transferFrom;
        }
    }
}
