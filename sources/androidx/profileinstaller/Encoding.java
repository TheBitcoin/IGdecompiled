package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    static int bitsToBytes(int i4) {
        return ((i4 + 7) & -8) / 8;
    }

    static byte[] compress(@NonNull byte[] bArr) throws IOException {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    @NonNull
    static RuntimeException error(@Nullable String str) {
        return new IllegalStateException(str);
    }

    @NonNull
    static byte[] read(@NonNull InputStream inputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read >= 0) {
                i5 += read;
            } else {
                throw error("Not enough bytes to read: " + i4);
            }
        }
        return bArr;
    }

    @NonNull
    static byte[] readCompressed(@NonNull InputStream inputStream, int i4, int i5) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i5];
            byte[] bArr2 = new byte[2048];
            int i6 = 0;
            int i7 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i6 < i4) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i7 += inflater.inflate(bArr, i7, i5 - i7);
                    i6 += read;
                } else {
                    throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i4 + " bytes");
                }
            }
            if (i6 != i4) {
                throw error("Didn't read enough bytes during decompression. expected=" + i4 + " actual=" + i6);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw error("Inflater did not finish");
            }
        } catch (DataFormatException e5) {
            throw error(e5.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    @NonNull
    static String readString(InputStream inputStream, int i4) throws IOException {
        return new String(read(inputStream, i4), StandardCharsets.UTF_8);
    }

    static long readUInt(@NonNull InputStream inputStream, int i4) throws IOException {
        byte[] read = read(inputStream, i4);
        long j4 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j4 += ((long) (read[i5] & 255)) << (i5 * 8);
        }
        return j4;
    }

    static int readUInt16(@NonNull InputStream inputStream) throws IOException {
        return (int) readUInt(inputStream, 2);
    }

    static long readUInt32(@NonNull InputStream inputStream) throws IOException {
        return readUInt(inputStream, 4);
    }

    static int readUInt8(@NonNull InputStream inputStream) throws IOException {
        return (int) readUInt(inputStream, 1);
    }

    static int utf8Length(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void writeAll(@NonNull InputStream inputStream, @NonNull OutputStream outputStream, @Nullable FileLock fileLock) throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            throw new IOException("Unable to acquire a lock on the underlying file channel.");
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static void writeCompressed(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        writeUInt32(outputStream, (long) bArr.length);
        byte[] compress = compress(bArr);
        writeUInt32(outputStream, (long) compress.length);
        outputStream.write(compress);
    }

    static void writeString(@NonNull OutputStream outputStream, @NonNull String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(@NonNull OutputStream outputStream, long j4, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) ((int) ((j4 >> (i5 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    static void writeUInt16(@NonNull OutputStream outputStream, int i4) throws IOException {
        writeUInt(outputStream, (long) i4, 2);
    }

    static void writeUInt32(@NonNull OutputStream outputStream, long j4) throws IOException {
        writeUInt(outputStream, j4, 4);
    }

    static void writeUInt8(@NonNull OutputStream outputStream, int i4) throws IOException {
        writeUInt(outputStream, (long) i4, 1);
    }
}
