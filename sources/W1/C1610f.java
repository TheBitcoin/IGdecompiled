package W1;

import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import m3.a;
import m3.d;

/* renamed from: W1.f  reason: case insensitive filesystem */
public final class C1610f {

    /* renamed from: a  reason: collision with root package name */
    public static final C1610f f8672a = new C1610f();

    private C1610f() {
    }

    private final String a(String str, String str2) {
        Charset forName = Charset.forName(C.UTF8_NAME);
        m.d(forName, "forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return b(bytes, str2);
    }

    private final String b(byte[] bArr, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(bArr);
            StringBuilder sb = new StringBuilder();
            m.d(digest, "bytes");
            for (byte b5 : digest) {
                String num = Integer.toString((b5 & 255) + 256, a.a(16));
                m.d(num, "toString(this, checkRadix(radix))");
                String substring = num.substring(1);
                m.d(substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
            }
            return sb.toString();
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String c(String str) {
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        return a(str, "SHA-256");
    }

    public final String d(byte[] bArr) {
        m.e(bArr, "byteArray");
        return b(bArr, "SHA-256");
    }

    public final String e(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                while (bigInteger.length() < 64) {
                    bigInteger = '0' + bigInteger;
                }
                return bigInteger;
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public final String f(String str) {
        m.e(str, "s");
        byte[] bytes = str.getBytes(d.f21160b);
        m.d(bytes, "this as java.lang.String).getBytes(charset)");
        return g(bytes);
    }

    public final String g(byte[] bArr) {
        m.e(bArr, "s");
        try {
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.update(bArr);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            while (bigInteger.length() < 32) {
                F f4 = F.f20971a;
                bigInteger = String.format("0%s", Arrays.copyOf(new Object[]{bigInteger}, 1));
                m.d(bigInteger, "format(format, *args)");
            }
            return bigInteger;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
