package androidx.core.util;

import android.util.AtomicFile;
import d3.l;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;
import m3.d;

public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    public static final String readText(AtomicFile atomicFile, Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = d.f21160b;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(AtomicFile atomicFile, l lVar) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            lVar.invoke(startWrite);
            kotlin.jvm.internal.l.b(1);
            atomicFile.finishWrite(startWrite);
            kotlin.jvm.internal.l.a(1);
        } catch (Throwable th) {
            kotlin.jvm.internal.l.b(1);
            atomicFile.failWrite(startWrite);
            kotlin.jvm.internal.l.a(1);
            throw th;
        }
    }

    public static final void writeBytes(AtomicFile atomicFile, byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void writeText(AtomicFile atomicFile, String str, Charset charset) {
        byte[] bytes = str.getBytes(charset);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            charset = d.f21160b;
        }
        writeText(atomicFile, str, charset);
    }
}
