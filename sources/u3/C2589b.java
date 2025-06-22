package U3;

import S2.C1594h;
import S2.C1601o;
import com.mbridge.msdk.foundation.tools.SameMD5;
import d3.l;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import m3.d;

/* renamed from: U3.b  reason: case insensitive filesystem */
public abstract class C2589b {

    /* renamed from: U3.b$a */
    public static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24053a = new a();

        public a() {
            super(1);
        }

        public Object invoke(Object obj) {
            String str;
            String str2 = (String) obj;
            m.e(str2, "s");
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (lowerCase.length() <= 0) {
                return lowerCase;
            }
            StringBuilder sb = new StringBuilder();
            char charAt = lowerCase.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.getDefault();
                m.d(locale, "getDefault()");
                str = m3.a.d(charAt, locale);
            } else {
                str = String.valueOf(charAt);
            }
            sb.append(str);
            String substring = lowerCase.substring(1);
            m.d(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
    }

    /* renamed from: U3.b$b  reason: collision with other inner class name */
    public static final class C0290b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0290b f24054a = new C0290b();

        public C0290b() {
            super(1);
        }

        public Object invoke(Object obj) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
            m.d(format, "format(this, *args)");
            return format;
        }
    }

    public static final String a(String str) {
        String str2 = str;
        m.e(str2, "<this>");
        return C1601o.O(m3.m.j0(str2, new String[]{" "}, false, 0, 6, (Object) null), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.f24053a, 30, (Object) null);
    }

    public static final String b(String str) {
        m.e(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = str.getBytes(d.f21160b);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        m.d(digest, "bytes");
        return C1594h.B(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0290b.f24054a, 30, (Object) null);
    }
}
