package N3;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* renamed from: N3.f  reason: case insensitive filesystem */
public interface C2515f extends X, WritableByteChannel {
    C2514e buffer();

    C2515f emitCompleteSegments();

    void flush();

    OutputStream outputStream();

    C2515f write(byte[] bArr);

    C2515f write(byte[] bArr, int i4, int i5);

    C2515f writeByte(int i4);

    C2515f writeDecimalLong(long j4);

    C2515f writeHexadecimalUnsignedLong(long j4);

    C2515f writeInt(int i4);

    C2515f writeShort(int i4);

    C2515f writeUtf8(String str);
}
