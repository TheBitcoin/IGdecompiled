package N3;

import N3.Q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public class K extends C2527s {
    private final Long p(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    public void a(Q q4, Q q5) {
        m.e(q4, "source");
        m.e(q5, TypedValues.AttributesType.S_TARGET);
        try {
            Path unused = Files.move(q4.n(), q5.n(), new CopyOption[]{C2531w.a(StandardCopyOption.ATOMIC_MOVE), C2531w.a(StandardCopyOption.REPLACE_EXISTING)});
        } catch (NoSuchFileException e5) {
            throw new FileNotFoundException(e5.getMessage());
        } catch (UnsupportedOperationException unused2) {
            throw new IOException("atomic move not supported");
        }
    }

    public C2519j h(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return o(q4.n());
    }

    /* access modifiers changed from: protected */
    public final C2519j o(Path path) {
        Path path2;
        Q q4;
        Long l4;
        Long l5;
        Path path3 = path;
        m.e(path3, "nioPath");
        Long l6 = null;
        try {
            BasicFileAttributes a5 = Files.readAttributes(path3, C2528t.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (a5.isSymbolicLink()) {
                path2 = Files.readSymbolicLink(path3);
            } else {
                path2 = null;
            }
            boolean a6 = a5.isRegularFile();
            boolean a7 = a5.isDirectory();
            if (path2 != null) {
                q4 = Q.a.f(Q.f23639b, path2, false, 1, (Object) null);
            } else {
                q4 = null;
            }
            Long valueOf = Long.valueOf(a5.size());
            FileTime a8 = a5.creationTime();
            if (a8 != null) {
                l4 = p(a8);
            } else {
                l4 = null;
            }
            FileTime a9 = a5.lastModifiedTime();
            if (a9 != null) {
                l5 = p(a9);
            } else {
                l5 = null;
            }
            FileTime a10 = a5.lastAccessTime();
            if (a10 != null) {
                l6 = p(a10);
            }
            return new C2519j(a6, a7, q4, valueOf, l4, l5, l6, (Map) null, 128, (C2103g) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    public String toString() {
        return "NioSystemFileSystem";
    }
}
