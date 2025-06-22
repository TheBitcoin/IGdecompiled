package E3;

import D3.C2450A;
import D3.C2470r;
import D3.C2472t;
import D3.y;
import N3.C2514e;
import N3.C2517h;
import N3.Z;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f23242a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f23243b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final C2450A f23244c;

    /* renamed from: d  reason: collision with root package name */
    public static final y f23245d;

    /* renamed from: e  reason: collision with root package name */
    private static final C2517h f23246e = C2517h.d("efbbbf");

    /* renamed from: f  reason: collision with root package name */
    private static final C2517h f23247f = C2517h.d("feff");

    /* renamed from: g  reason: collision with root package name */
    private static final C2517h f23248g = C2517h.d("fffe");

    /* renamed from: h  reason: collision with root package name */
    private static final C2517h f23249h = C2517h.d("0000ffff");

    /* renamed from: i  reason: collision with root package name */
    private static final C2517h f23250i = C2517h.d("ffff0000");

    /* renamed from: j  reason: collision with root package name */
    public static final Charset f23251j = Charset.forName(C.UTF8_NAME);

    /* renamed from: k  reason: collision with root package name */
    public static final Charset f23252k = Charset.forName("ISO-8859-1");

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f23253l = Charset.forName("UTF-16BE");

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f23254m = Charset.forName("UTF-16LE");

    /* renamed from: n  reason: collision with root package name */
    private static final Charset f23255n = Charset.forName("UTF-32BE");

    /* renamed from: o  reason: collision with root package name */
    private static final Charset f23256o = Charset.forName("UTF-32LE");

    /* renamed from: p  reason: collision with root package name */
    public static final TimeZone f23257p = DesugarTimeZone.getTimeZone("GMT");

    /* renamed from: q  reason: collision with root package name */
    public static final Comparator f23258q = new a();

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f23259r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f23261b;

        b(String str, boolean z4) {
            this.f23260a = str;
            this.f23261b = z4;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f23260a);
            thread.setDaemon(this.f23261b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f23242a = bArr;
        f23244c = C2450A.g((C2472t) null, bArr);
        f23245d = y.c((C2472t) null, bArr);
    }

    public static int A(String str, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            char charAt = str.charAt(i6);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i6 + 1;
            }
        }
        return i4;
    }

    public static ThreadFactory B(String str, boolean z4) {
        return new b(str, z4);
    }

    public static String C(String str, int i4, int i5) {
        int z4 = z(str, i4, i5);
        return str.substring(z4, A(str, z4, i5));
    }

    public static boolean D(String str) {
        return f23259r.matcher(str).matches();
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String b(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = j(str, 0, str.length());
            } else {
                inetAddress = j(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return u(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !g(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void c(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static void e(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e5) {
                if (!w(e5)) {
                    throw e5;
                }
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] f(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean g(String str) {
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int h(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        if (c5 >= 'a' && c5 <= 'f') {
            return c5 - 'W';
        }
        if (c5 < 'A' || c5 > 'F') {
            return -1;
        }
        return c5 - '7';
    }

    private static boolean i(String str, int i4, int i5, byte[] bArr, int i6) {
        int i7 = i6;
        while (i4 < i5) {
            if (i7 == bArr.length) {
                return false;
            }
            if (i7 != i6) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i8 = i4;
            int i9 = 0;
            while (i8 < i5) {
                char charAt = str.charAt(i8);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i9 == 0 && i4 != i8) || (i9 = ((i9 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i8++;
                }
            }
            if (i8 - i4 == 0) {
                return false;
            }
            bArr[i7] = (byte) i9;
            i7++;
            i4 = i8;
        }
        if (i7 != i6 + 4) {
            return false;
        }
        return true;
    }

    private static InetAddress j(String str, int i4, int i5) {
        byte[] bArr = new byte[16];
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            if (i4 >= i5) {
                break;
            } else if (i6 == 16) {
                return null;
            } else {
                int i9 = i4 + 2;
                if (i9 > i5 || !str.regionMatches(i4, "::", 0, 2)) {
                    if (i6 != 0) {
                        if (str.regionMatches(i4, ":", 0, 1)) {
                            i4++;
                        } else if (!str.regionMatches(i4, ".", 0, 1) || !i(str, i8, i5, bArr, i6 - 2)) {
                            return null;
                        } else {
                            i6 += 2;
                        }
                    }
                    i8 = i4;
                } else if (i7 != -1) {
                    return null;
                } else {
                    i6 += 2;
                    i7 = i6;
                    if (i9 == i5) {
                        break;
                    }
                    i8 = i9;
                }
                i4 = i8;
                int i10 = 0;
                while (i4 < i5) {
                    int h4 = h(str.charAt(i4));
                    if (h4 == -1) {
                        break;
                    }
                    i10 = (i10 << 4) + h4;
                    i4++;
                }
                int i11 = i4 - i8;
                if (i11 == 0 || i11 > 4) {
                    return null;
                }
                int i12 = i6 + 1;
                bArr[i6] = (byte) ((i10 >>> 8) & 255);
                i6 += 2;
                bArr[i12] = (byte) (i10 & 255);
            }
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i13 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i13, i13);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int k(String str, int i4, int i5, char c5) {
        while (i4 < i5) {
            if (str.charAt(i4) == c5) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static int l(String str, int i4, int i5, String str2) {
        while (i4 < i5) {
            if (str2.indexOf(str.charAt(i4)) != -1) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    public static boolean m(Z z4, int i4, TimeUnit timeUnit) {
        try {
            return y(z4, i4, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean n(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static String o(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String p(C2470r rVar, boolean z4) {
        String str;
        if (rVar.k().contains(":")) {
            str = "[" + rVar.k() + "]";
        } else {
            str = rVar.k();
        }
        if (!z4 && rVar.w() == C2470r.d(rVar.A())) {
            return str;
        }
        return str + ":" + rVar.w();
    }

    public static List q(List list) {
        return DesugarCollections.unmodifiableList(new ArrayList(list));
    }

    public static List r(Object... objArr) {
        return DesugarCollections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static int s(Comparator comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (comparator.compare(strArr[i4], str) == 0) {
                return i4;
            }
        }
        return -1;
    }

    public static int t(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 31 || charAt >= 127) {
                return i4;
            }
        }
        return -1;
    }

    private static String u(byte[] bArr) {
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            int i8 = i6;
            while (i8 < 16 && bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                i8 += 2;
            }
            int i9 = i8 - i6;
            if (i9 > i7 && i9 >= 4) {
                i4 = i6;
                i7 = i9;
            }
            i6 = i8 + 2;
        }
        C2514e eVar = new C2514e();
        while (i5 < bArr.length) {
            if (i5 == i4) {
                eVar.writeByte(58);
                i5 += i7;
                if (i5 == 16) {
                    eVar.writeByte(58);
                }
            } else {
                if (i5 > 0) {
                    eVar.writeByte(58);
                }
                eVar.writeHexadecimalUnsignedLong((long) (((bArr[i5] & 255) << 8) | (bArr[i5 + 1] & 255)));
                i5 += 2;
            }
        }
        return eVar.readUtf8();
    }

    public static String[] v(Comparator comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i4]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i4++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean w(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static boolean x(Comparator comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean y(Z z4, int i4, TimeUnit timeUnit) {
        long j4;
        long nanoTime = System.nanoTime();
        if (z4.timeout().e()) {
            j4 = z4.timeout().c() - nanoTime;
        } else {
            j4 = Long.MAX_VALUE;
        }
        z4.timeout().d(Math.min(j4, timeUnit.toNanos((long) i4)) + nanoTime);
        try {
            C2514e eVar = new C2514e();
            while (z4.e(eVar, 8192) != -1) {
                eVar.a();
            }
            if (j4 == Long.MAX_VALUE) {
                z4.timeout().a();
                return true;
            }
            z4.timeout().d(nanoTime + j4);
            return true;
        } catch (InterruptedIOException unused) {
            if (j4 == Long.MAX_VALUE) {
                z4.timeout().a();
                return false;
            }
            z4.timeout().d(nanoTime + j4);
            return false;
        } catch (Throwable th) {
            if (j4 == Long.MAX_VALUE) {
                z4.timeout().a();
            } else {
                z4.timeout().d(nanoTime + j4);
            }
            throw th;
        }
    }

    public static int z(String str, int i4, int i5) {
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4;
            }
            i4++;
        }
        return i5;
    }
}
