package N3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: N3.s  reason: case insensitive filesystem */
public class C2527s extends C2520k {
    private final void m(Q q4) {
        if (g(q4)) {
            throw new IOException(q4 + " already exists.");
        }
    }

    private final void n(Q q4) {
        if (!g(q4)) {
            throw new IOException(q4 + " doesn't exist.");
        }
    }

    public void a(Q q4, Q q5) {
        m.e(q4, "source");
        m.e(q5, TypedValues.AttributesType.S_TARGET);
        if (!q4.m().renameTo(q5.m())) {
            throw new IOException("failed to move " + q4 + " to " + q5);
        }
    }

    public void d(Q q4, boolean z4) {
        m.e(q4, "dir");
        if (!q4.m().mkdir()) {
            C2519j h4 = h(q4);
            if (h4 == null || !h4.c()) {
                throw new IOException("failed to create directory: " + q4);
            } else if (z4) {
                throw new IOException(q4 + " already exist.");
            }
        }
    }

    public void f(Q q4, boolean z4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (!Thread.interrupted()) {
            File m4 = q4.m();
            if (m4.delete()) {
                return;
            }
            if (m4.exists()) {
                throw new IOException("failed to delete " + q4);
            } else if (z4) {
                throw new FileNotFoundException("no such file: " + q4);
            }
        } else {
            throw new InterruptedIOException("interrupted");
        }
    }

    public C2519j h(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        File m4 = q4.m();
        boolean isFile = m4.isFile();
        boolean isDirectory = m4.isDirectory();
        long lastModified = m4.lastModified();
        long length = m4.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !m4.exists()) {
            return null;
        }
        return new C2519j(isFile, isDirectory, (Q) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (C2103g) null);
    }

    public C2518i i(Q q4) {
        m.e(q4, "file");
        return new r(false, new RandomAccessFile(q4.m(), CampaignEx.JSON_KEY_AD_R));
    }

    public C2518i k(Q q4, boolean z4, boolean z5) {
        m.e(q4, "file");
        if (!z4 || !z5) {
            if (z4) {
                m(q4);
            }
            if (z5) {
                n(q4);
            }
            return new r(true, new RandomAccessFile(q4.m(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
    }

    public Z l(Q q4) {
        m.e(q4, "file");
        return L.k(q4.m());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
