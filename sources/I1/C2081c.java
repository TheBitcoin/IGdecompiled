package i1;

import j$.util.Objects;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* renamed from: i1.c  reason: case insensitive filesystem */
public class C2081c implements Closeable, Flushable, AutoCloseable {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f20889j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f20890k = new String[128];

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f20891l;

    /* renamed from: a  reason: collision with root package name */
    private final Writer f20892a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f20893b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f20894c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f20895d;

    /* renamed from: e  reason: collision with root package name */
    private String f20896e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20897f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20898g;

    /* renamed from: h  reason: collision with root package name */
    private String f20899h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20900i;

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            f20890k[i4] = String.format("\\u%04x", new Object[]{Integer.valueOf(i4)});
        }
        String[] strArr = f20890k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f20891l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C2081c(Writer writer) {
        D(6);
        this.f20896e = ":";
        this.f20900i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f20892a = writer;
    }

    private int A() {
        int i4 = this.f20894c;
        if (i4 != 0) {
            return this.f20893b[i4 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void D(int i4) {
        int i5 = this.f20894c;
        int[] iArr = this.f20893b;
        if (i5 == iArr.length) {
            this.f20893b = Arrays.copyOf(iArr, i5 * 2);
        }
        int[] iArr2 = this.f20893b;
        int i6 = this.f20894c;
        this.f20894c = i6 + 1;
        iArr2[i6] = i4;
    }

    private void E(int i4) {
        this.f20893b[this.f20894c - 1] = i4;
    }

    private void J(String str) {
        String[] strArr;
        String str2;
        if (this.f20898g) {
            strArr = f20891l;
        } else {
            strArr = f20890k;
        }
        this.f20892a.write(34);
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i4 < i5) {
                this.f20892a.write(str, i4, i5 - i4);
            }
            this.f20892a.write(str2);
            i4 = i5 + 1;
        }
        if (i4 < length) {
            this.f20892a.write(str, i4, length - i4);
        }
        this.f20892a.write(34);
    }

    private void Q() {
        if (this.f20899h != null) {
            a();
            J(this.f20899h);
            this.f20899h = null;
        }
    }

    private void a() {
        int A4 = A();
        if (A4 == 5) {
            this.f20892a.write(44);
        } else if (A4 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        w();
        E(4);
    }

    private void d() {
        int A4 = A();
        if (A4 == 1) {
            E(2);
            w();
        } else if (A4 == 2) {
            this.f20892a.append(',');
            w();
        } else if (A4 != 4) {
            if (A4 != 6) {
                if (A4 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f20897f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            E(7);
        } else {
            this.f20892a.append(this.f20896e);
            E(5);
        }
    }

    private C2081c k(int i4, int i5, char c5) {
        int A4 = A();
        if (A4 != i5 && A4 != i4) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f20899h == null) {
            this.f20894c--;
            if (A4 == i5) {
                w();
            }
            this.f20892a.write(c5);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f20899h);
        }
    }

    private static boolean u(Class cls) {
        if (cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class) {
            return true;
        }
        return false;
    }

    private void w() {
        if (this.f20895d != null) {
            this.f20892a.write(10);
            int i4 = this.f20894c;
            for (int i5 = 1; i5 < i4; i5++) {
                this.f20892a.write(this.f20895d);
            }
        }
    }

    private C2081c z(int i4, char c5) {
        d();
        D(i4);
        this.f20892a.write(c5);
        return this;
    }

    public final void F(boolean z4) {
        this.f20898g = z4;
    }

    public final void G(String str) {
        if (str.length() == 0) {
            this.f20895d = null;
            this.f20896e = ":";
            return;
        }
        this.f20895d = str;
        this.f20896e = ": ";
    }

    public final void H(boolean z4) {
        this.f20897f = z4;
    }

    public final void I(boolean z4) {
        this.f20900i = z4;
    }

    public C2081c K(double d5) {
        Q();
        if (this.f20897f || (!Double.isNaN(d5) && !Double.isInfinite(d5))) {
            d();
            this.f20892a.append(Double.toString(d5));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d5);
    }

    public C2081c L(long j4) {
        Q();
        d();
        this.f20892a.write(Long.toString(j4));
        return this;
    }

    public C2081c M(Boolean bool) {
        String str;
        if (bool == null) {
            return x();
        }
        Q();
        d();
        Writer writer = this.f20892a;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public C2081c N(Number number) {
        if (number == null) {
            return x();
        }
        Q();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!u(cls) && !f20889j.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f20897f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        d();
        this.f20892a.append(obj);
        return this;
    }

    public C2081c O(String str) {
        if (str == null) {
            return x();
        }
        Q();
        d();
        J(str);
        return this;
    }

    public C2081c P(boolean z4) {
        String str;
        Q();
        d();
        Writer writer = this.f20892a;
        if (z4) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public void close() {
        this.f20892a.close();
        int i4 = this.f20894c;
        if (i4 > 1 || (i4 == 1 && this.f20893b[i4 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f20894c = 0;
    }

    public void flush() {
        if (this.f20894c != 0) {
            this.f20892a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public C2081c g() {
        Q();
        return z(1, '[');
    }

    public C2081c i() {
        Q();
        return z(3, '{');
    }

    public C2081c l() {
        return k(1, 2, ']');
    }

    public C2081c n() {
        return k(3, 5, '}');
    }

    public final boolean o() {
        return this.f20900i;
    }

    public final boolean p() {
        return this.f20898g;
    }

    public boolean r() {
        return this.f20897f;
    }

    public C2081c v(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f20899h != null) {
            throw new IllegalStateException();
        } else if (this.f20894c != 0) {
            this.f20899h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public C2081c x() {
        if (this.f20899h != null) {
            if (this.f20900i) {
                Q();
            } else {
                this.f20899h = null;
                return this;
            }
        }
        d();
        this.f20892a.write("null");
        return this;
    }
}
