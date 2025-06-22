package l2;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

/* renamed from: l2.b  reason: case insensitive filesystem */
public final class C2122b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2122b f21017a = new C2122b();

    public final String a(byte[] bArr) {
        m.e(bArr, "s");
        try {
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.update(bArr);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            while (bigInteger.length() < 32) {
                F f4 = F.f20971a;
                bigInteger = String.format("0%s", Arrays.copyOf(new Object[]{bigInteger}, 1));
                m.d(bigInteger, "format(...)");
            }
            return bigInteger;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
