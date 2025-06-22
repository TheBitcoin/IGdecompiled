package androidx.datastore.core;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.m;

public final class UncloseableOutputStream extends OutputStream implements AutoCloseable {
    private final FileOutputStream fileOutputStream;

    public UncloseableOutputStream(FileOutputStream fileOutputStream2) {
        m.e(fileOutputStream2, "fileOutputStream");
        this.fileOutputStream = fileOutputStream2;
    }

    public void close() {
    }

    public void flush() {
        this.fileOutputStream.flush();
    }

    public final FileOutputStream getFileOutputStream() {
        return this.fileOutputStream;
    }

    public void write(int i4) {
        this.fileOutputStream.write(i4);
    }

    public void write(byte[] bArr) {
        m.e(bArr, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
        this.fileOutputStream.write(bArr);
    }

    public void write(byte[] bArr, int i4, int i5) {
        m.e(bArr, "bytes");
        this.fileOutputStream.write(bArr, i4, i5);
    }
}
