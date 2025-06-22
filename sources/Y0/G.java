package y0;

import B0.F;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class G implements L {

    /* renamed from: a  reason: collision with root package name */
    private final File f22590a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22591b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22592c;

    G(String str, String str2, File file) {
        this.f22591b = str;
        this.f22592c = str2;
        this.f22590a = file;
    }

    private byte[] c() {
        InputStream stream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            stream = getStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            if (stream == null) {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                if (stream != null) {
                    stream.close();
                }
                return null;
            }
            while (true) {
                int read = stream.read(bArr);
                if (read > 0) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    stream.close();
                    return byteArray;
                }
            }
            throw th;
            throw th;
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    public String a() {
        return this.f22592c;
    }

    public F.d.b b() {
        byte[] c5 = c();
        if (c5 != null) {
            return F.d.b.a().b(c5).c(this.f22591b).a();
        }
        return null;
    }

    public InputStream getStream() {
        if (this.f22590a.exists() && this.f22590a.isFile()) {
            try {
                return new FileInputStream(this.f22590a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
