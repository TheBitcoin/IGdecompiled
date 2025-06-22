package N3;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* renamed from: N3.g  reason: case insensitive filesystem */
public interface C2516g extends Z, ReadableByteChannel {
    C2514e buffer();

    boolean exhausted();

    C2514e h();

    InputStream inputStream();

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j4);

    C2517h readByteString(long j4);

    long readDecimalLong();

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readUtf8(long j4);

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j4);

    void require(long j4);

    boolean s(long j4, C2517h hVar);

    void skip(long j4);
}
