package y0;

import B0.F;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: y0.h  reason: case insensitive filesystem */
class C2418h implements L {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22639a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22640b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22641c;

    C2418h(String str, String str2, byte[] bArr) {
        this.f22640b = str;
        this.f22641c = str2;
        this.f22639a = bArr;
    }

    private byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (d()) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(this.f22639a);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    private boolean d() {
        byte[] bArr = this.f22639a;
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f22641c;
    }

    public F.d.b b() {
        byte[] c5 = c();
        if (c5 == null) {
            return null;
        }
        return F.d.b.a().b(c5).c(this.f22640b).a();
    }

    public InputStream getStream() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f22639a);
    }
}
