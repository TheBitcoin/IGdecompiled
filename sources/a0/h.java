package A0;

import A0.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import y0.C2420j;

class h implements C1267c {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f5721d = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final File f5722a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5723b;

    /* renamed from: c  reason: collision with root package name */
    private g f5724c;

    class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f5725a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int[] f5726b;

        a(byte[] bArr, int[] iArr) {
            this.f5725a = bArr;
            this.f5726b = iArr;
        }

        public void a(InputStream inputStream, int i4) {
            try {
                inputStream.read(this.f5725a, this.f5726b[0], i4);
                int[] iArr = this.f5726b;
                iArr[0] = iArr[0] + i4;
            } finally {
                inputStream.close();
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f5728a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5729b;

        b(byte[] bArr, int i4) {
            this.f5728a = bArr;
            this.f5729b = i4;
        }
    }

    h(File file, int i4) {
        this.f5722a = file;
        this.f5723b = i4;
    }

    private void f(long j4, String str) {
        if (this.f5724c != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i4 = this.f5723b / 4;
                if (str.length() > i4) {
                    str = "..." + str.substring(str.length() - i4);
                }
                this.f5724c.k(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j4), str.replaceAll("\r", " ").replaceAll("\n", " ")}).getBytes(f5721d));
                while (!this.f5724c.u() && this.f5724c.I() > this.f5723b) {
                    this.f5724c.E();
                }
            } catch (IOException e5) {
                v0.g.f().e("There was a problem writing to the Crashlytics log.", e5);
            }
        }
    }

    private b g() {
        if (!this.f5722a.exists()) {
            return null;
        }
        h();
        g gVar = this.f5724c;
        if (gVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[gVar.I()];
        try {
            this.f5724c.p(new a(bArr, iArr));
        } catch (IOException e5) {
            v0.g.f().e("A problem occurred while reading the Crashlytics log file.", e5);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.f5724c == null) {
            try {
                this.f5724c = new g(this.f5722a);
            } catch (IOException e5) {
                v0.g f4 = v0.g.f();
                f4.e("Could not open log file: " + this.f5722a, e5);
            }
        }
    }

    public void a() {
        C2420j.f(this.f5724c, "There was a problem closing the Crashlytics log file.");
        this.f5724c = null;
    }

    public String b() {
        byte[] c5 = c();
        if (c5 != null) {
            return new String(c5, f5721d);
        }
        return null;
    }

    public byte[] c() {
        b g4 = g();
        if (g4 == null) {
            return null;
        }
        int i4 = g4.f5729b;
        byte[] bArr = new byte[i4];
        System.arraycopy(g4.f5728a, 0, bArr, 0, i4);
        return bArr;
    }

    public void d() {
        a();
        this.f5722a.delete();
    }

    public void e(long j4, String str) {
        h();
        f(j4, str);
    }
}
