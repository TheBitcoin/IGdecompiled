package l2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.m;
import m3.a;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f21023a = new k();

    public final String a(Context context, String str) {
        m.e(context, "context");
        m.e(str, "packageName");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                return context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName();
            }
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String b(PackageManager packageManager, String str) {
        boolean z4;
        m.e(packageManager, "pm");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                m.b(str);
                SigningInfo a5 = C2123c.a(packageManager, str, 134217728).signingInfo;
                if (a5.hasPastSigningCertificates()) {
                    Signature[] a6 = a5.getSigningCertificateHistory();
                    m.d(a6, "signingInfo.signingCertificateHistory");
                    if (a6.length == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        C2122b bVar = C2122b.f21017a;
                        byte[] byteArray = a5.getSigningCertificateHistory()[0].toByteArray();
                        m.d(byteArray, "signingInfo.signingCerti…eHistory[0].toByteArray()");
                        return bVar.a(byteArray);
                    }
                }
                Signature[] a7 = a5.getApkContentsSigners();
                if (a7 == null) {
                    return null;
                }
                if (a7.length == 0) {
                    return null;
                }
                C2122b bVar2 = C2122b.f21017a;
                byte[] byteArray2 = a7[0].toByteArray();
                m.d(byteArray2, "signatures[0].toByteArray()");
                return bVar2.a(byteArray2);
            }
            m.b(str);
            Signature[] signatureArr = C2123c.a(packageManager, str, 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length == 0) {
                return null;
            }
            C2122b bVar3 = C2122b.f21017a;
            byte[] byteArray3 = signatureArr[0].toByteArray();
            m.d(byteArray3, "signatures[0].toByteArray()");
            return bVar3.a(byteArray3);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String c(String str) {
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            Charset forName = Charset.forName(C.UTF8_NAME);
            m.d(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            m.d(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            StringBuilder sb = new StringBuilder();
            m.d(digest, "bytes");
            for (byte b5 : digest) {
                String num = Integer.toString((b5 & 255) + 256, a.a(16));
                m.d(num, "toString(...)");
                String substring = num.substring(1);
                m.d(substring, "substring(...)");
                sb.append(substring);
            }
            String sb2 = sb.toString();
            m.d(sb2, "sb.toString()");
            return sb2;
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public final long d(Context context) {
        m.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            m.d(packageName, "context.packageName");
            return e(C2123c.a(packageManager, packageName, 0));
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final long e(PackageInfo packageInfo) {
        m.e(packageInfo, "pi");
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    public final String f(Context context) {
        m.e(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            m.d(packageName, "context.packageName");
            return C2123c.a(packageManager, packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final boolean g(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null) {
            applicationInfo = packageInfo.applicationInfo;
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null || (packageInfo.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
            return false;
        }
        return true;
    }
}
