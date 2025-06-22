package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.mbridge.msdk.foundation.tools.a  reason: case insensitive filesystem */
public final class C1812a {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f13519a = new byte[16];

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f13520b = new byte[32];

    /* renamed from: com.mbridge.msdk.foundation.tools.a$a  reason: collision with other inner class name */
    public static class C0184a extends Provider {
        public C0184a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    static {
        String a5 = z.a("HkzwDFeD4QuyLdx5igfZYcu9xTM9NN==");
        if (!TextUtils.isEmpty(a5)) {
            try {
                byte[] digest = MessageDigest.getInstance("sha-384").digest(a5.getBytes());
                System.arraycopy(digest, 0, f13520b, 0, 32);
                System.arraycopy(digest, 32, f13519a, 0, 16);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static String a(String str) {
        return a(str, f13520b, f13519a);
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0184a());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(instance.doFinal(str.getBytes()), 0));
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
