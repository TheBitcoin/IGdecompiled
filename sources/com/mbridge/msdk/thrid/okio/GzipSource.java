package com.mbridge.msdk.thrid.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source, AutoCloseable {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section = 0;
    private final BufferedSource source;

    public GzipSource(Source source2) {
        if (source2 != null) {
            Inflater inflater2 = new Inflater(true);
            this.inflater = inflater2;
            BufferedSource buffer = Okio.buffer(source2);
            this.source = buffer;
            this.inflaterSource = new InflaterSource(buffer, inflater2);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void checkEqual(String str, int i4, int i5) throws IOException {
        if (i5 != i4) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}));
        }
    }

    private void consumeHeader() throws IOException {
        boolean z4;
        this.source.require(10);
        byte b5 = this.source.buffer().getByte(3);
        if (((b5 >> 1) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            updateCrc(this.source.buffer(), 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((b5 >> 2) & 1) == 1) {
            this.source.require(2);
            if (z4) {
                updateCrc(this.source.buffer(), 0, 2);
            }
            long readShortLe = (long) this.source.buffer().readShortLe();
            this.source.require(readShortLe);
            if (z4) {
                updateCrc(this.source.buffer(), 0, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b5 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) SECTION_HEADER);
            if (indexOf != -1) {
                if (z4) {
                    updateCrc(this.source.buffer(), 0, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b5 >> FCOMMENT) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) SECTION_HEADER);
            if (indexOf2 != -1) {
                if (z4) {
                    updateCrc(this.source.buffer(), 0, indexOf2 + 1);
                }
                this.source.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z4) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private void updateCrc(Buffer buffer, long j4, long j5) {
        Segment segment = buffer.head;
        while (true) {
            int i4 = segment.limit;
            int i5 = segment.pos;
            if (j4 < ((long) (i4 - i5))) {
                break;
            }
            j4 -= (long) (i4 - i5);
            segment = segment.next;
        }
        while (j5 > 0) {
            int i6 = (int) (((long) segment.pos) + j4);
            int min = (int) Math.min((long) (segment.limit - i6), j5);
            this.crc.update(segment.data, i6, min);
            j5 -= (long) min;
            segment = segment.next;
            j4 = 0;
        }
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long j4) throws IOException {
        GzipSource gzipSource;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (i4 == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long j5 = buffer.size;
                long read = this.inflaterSource.read(buffer, j4);
                if (read != -1) {
                    updateCrc(buffer, j5, read);
                    return read;
                }
                gzipSource = this;
                gzipSource.section = 2;
            } else {
                gzipSource = this;
            }
            if (gzipSource.section == 2) {
                consumeTrailer();
                gzipSource.section = 3;
                if (!gzipSource.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
