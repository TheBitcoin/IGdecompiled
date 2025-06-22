package com.mbridge.msdk.thrid.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source, AutoCloseable {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
    }

    private void releaseInflatedBytes() throws IOException {
        int i4 = this.bufferBytesHeldByInflater;
        if (i4 != 0) {
            int remaining = i4 - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    public long read(Buffer buffer, long j4) throws IOException {
        Segment writableSegment;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (i4 == 0) {
            return 0;
        } else {
            while (true) {
                boolean refill = refill();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) Math.min(j4, (long) (8192 - writableSegment.limit)));
                    if (inflate > 0) {
                        writableSegment.limit += inflate;
                        long j5 = (long) inflate;
                        buffer.size += j5;
                        return j5;
                    } else if (this.inflater.finished()) {
                        break;
                    } else if (this.inflater.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e5) {
                    throw new IOException(e5);
                }
            }
            releaseInflatedBytes();
            if (writableSegment.pos != writableSegment.limit) {
                return -1;
            }
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
            return -1;
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.source.exhausted()) {
            return true;
        } else {
            Segment segment = this.source.buffer().head;
            int i4 = segment.limit;
            int i5 = segment.pos;
            int i6 = i4 - i5;
            this.bufferBytesHeldByInflater = i6;
            this.inflater.setInput(segment.data, i5, i6);
            return false;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater2 != null) {
            this.source = bufferedSource;
            this.inflater = inflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
