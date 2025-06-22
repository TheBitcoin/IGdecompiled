package b3;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.m;

/* renamed from: b3.a  reason: case insensitive filesystem */
public abstract class C1641a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i4) {
        m.e(inputStream, "<this>");
        m.e(outputStream, "out");
        byte[] bArr = new byte[i4];
        int read = inputStream.read(bArr);
        long j4 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j4 += (long) read;
            read = inputStream.read(bArr);
        }
        return j4;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return a(inputStream, outputStream, i4);
    }
}
