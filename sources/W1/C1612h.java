package W1;

import N1.i;
import P1.a;
import android.content.Context;
import android.content.UriPermission;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStatVfs;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.m;
import m3.j;

/* renamed from: W1.h  reason: case insensitive filesystem */
public final class C1612h {
    private final File d(Context context) {
        a aVar = new a(context);
        if (!aVar.o()) {
            return context.getExternalFilesDir((String) null);
        }
        File[] externalFilesDirs = context.getExternalFilesDirs((String) null);
        if (externalFilesDirs.length > 1) {
            return externalFilesDirs[1];
        }
        File externalFilesDir = context.getExternalFilesDir((String) null);
        aVar.F(false);
        aVar.E(false);
        return externalFilesDir;
    }

    public final File a(Context context, String str) {
        m.e(context, "context");
        m.e(str, "subdirName");
        File file = new File(d(context), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final String b(PackageInfo packageInfo, String str, PackageManager packageManager) {
        m.e(packageInfo, "pi");
        m.e(str, "realPath");
        m.e(packageManager, "pm");
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return packageManager.getApplicationLabel(applicationInfo).toString();
    }

    public final File c(Context context) {
        File file;
        m.e(context, "context");
        a aVar = new a(context);
        if (aVar.o()) {
            File[] externalFilesDirs = context.getExternalFilesDirs((String) null);
            if (externalFilesDirs.length > 1) {
                file = externalFilesDirs[1];
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                aVar.F(false);
                aVar.E(false);
                file = externalStorageDirectory;
            }
        } else {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null) {
            return context.getExternalFilesDir((String) null);
        }
        File file2 = new File(file.getAbsolutePath() + '/' + context.getResources().getString(i.app_name) + "/Backups");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public final File e() {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/");
    }

    public final File f(Context context) {
        m.e(context, "context");
        File file = new File(context.getExternalFilesDir((String) null), "received");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File g(Context context) {
        m.e(context, "context");
        File file = new File(context.getExternalFilesDir((String) null), "tmp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final Drawable h(Context context, String str) {
        m.e(context, "context");
        m.e(str, "filePath");
        PackageManager packageManager = context.getPackageManager();
        m.d(packageManager, "context.packageManager");
        PackageInfo c5 = s.c(packageManager, str, 128);
        if (c5 == null) {
            return null;
        }
        ApplicationInfo applicationInfo = c5.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return applicationInfo.loadIcon(context.getPackageManager());
    }

    public final String i(String str) {
        String str2;
        m.e(str, "fileName");
        String str3 = str;
        String str4 = str3;
        if (m3.m.L(str3, ".", 0, false, 6, (Object) null) > 0) {
            str2 = str4.substring(m3.m.R(str4, ".", 0, false, 6, (Object) null) + 1);
            m.d(str2, "this as java.lang.String).substring(startIndex)");
        } else {
            str2 = "";
        }
        if (m3.m.p(str2, "xapk", true)) {
            return "application/xapk-package-archive";
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Locale locale = Locale.getDefault();
        m.d(locale, "getDefault()");
        String lowerCase = str2.toLowerCase(locale);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            return "application/octet-stream";
        }
        return mimeTypeFromExtension;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j(android.net.Uri r9, android.app.Activity r10) {
        /*
            r8 = this;
            java.lang.String r0 = "contentUri"
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.m.e(r10, r0)
            r1 = 0
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch:{ Exception -> 0x004f, all -> 0x004c }
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002e }
            if (r9 == 0) goto L_0x0031
            java.lang.String r10 = "_display_name"
            int r10 = r9.getColumnIndex(r10)     // Catch:{ Exception -> 0x002e }
            r9.moveToFirst()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = r9.getString(r10)     // Catch:{ Exception -> 0x002e }
            r9.close()     // Catch:{ Exception -> 0x002e }
            goto L_0x0031
        L_0x002b:
            r0 = move-exception
        L_0x002c:
            r9 = r0
            goto L_0x006f
        L_0x002e:
            r0 = move-exception
        L_0x002f:
            r9 = r0
            goto L_0x0052
        L_0x0031:
            if (r1 != 0) goto L_0x004b
            java.lang.String r9 = r3.getPath()
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = r3.getPath()
            kotlin.jvm.internal.m.b(r9)
            boolean r9 = r8.o(r9)
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = r3.getLastPathSegment()
            return r9
        L_0x004b:
            return r1
        L_0x004c:
            r0 = move-exception
            r3 = r9
            goto L_0x002c
        L_0x004f:
            r0 = move-exception
            r3 = r9
            goto L_0x002f
        L_0x0052:
            r9.printStackTrace()     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x006e
            java.lang.String r9 = r3.getPath()
            if (r9 == 0) goto L_0x006e
            java.lang.String r9 = r3.getPath()
            kotlin.jvm.internal.m.b(r9)
            boolean r9 = r8.o(r9)
            if (r9 == 0) goto L_0x006e
            java.lang.String r1 = r3.getLastPathSegment()
        L_0x006e:
            return r1
        L_0x006f:
            if (r1 != 0) goto L_0x0087
            java.lang.String r10 = r3.getPath()
            if (r10 == 0) goto L_0x0087
            java.lang.String r10 = r3.getPath()
            kotlin.jvm.internal.m.b(r10)
            boolean r10 = r8.o(r10)
            if (r10 == 0) goto L_0x0087
            r3.getLastPathSegment()
        L_0x0087:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C1612h.j(android.net.Uri, android.app.Activity):java.lang.String");
    }

    public final long k(Context context, Uri uri) {
        m.e(context, "context");
        m.e(uri, "uri");
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            if (openFileDescriptor == null) {
                return 0;
            }
            StructStatVfs fstatvfs = Os.fstatvfs(openFileDescriptor.getFileDescriptor());
            long j4 = fstatvfs.f_bsize * fstatvfs.f_bavail;
            openFileDescriptor.close();
            return j4;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final long l(Context context, DocumentFile documentFile) {
        m.e(context, "context");
        m.e(documentFile, "documentFile");
        Uri uri = documentFile.getUri();
        m.d(uri, "documentFile.uri");
        return k(context, uri);
    }

    public final long m(PackageInfo packageInfo) {
        m.e(packageInfo, "pi");
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    public final Uri n(Context context) {
        m.e(context, "context");
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        m.d(persistedUriPermissions, "context.contentResolver.persistedUriPermissions");
        for (UriPermission next : persistedUriPermissions) {
            Uri uri = next.getUri();
            m.d(uri, "permission.uri");
            if (q(uri)) {
                return next.getUri();
            }
        }
        return null;
    }

    public final boolean o(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (m3.m.o(str, ".apk", false, 2, (Object) null) || G.f8470b.a(str)) {
            return true;
        }
        return false;
    }

    public final boolean p(Context context, String str) {
        m.e(context, "context");
        m.e(str, "packagename");
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                return true;
            }
            return false;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        } catch (Error e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public final boolean q(Uri uri) {
        m.e(uri, "uri");
        String path = uri.getPath();
        String str = "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]" + "[ABCDEF[0-9]]";
        String str2 = ".*\\b" + str + '-' + str + ":.*";
        if (path != null) {
            return new j(str2).e(path);
        }
        return false;
    }

    public final boolean r(PackageInfo packageInfo) {
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

    public final boolean s() {
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (m3.m.p(str, "Xiaomi", true) || m3.m.p(str2, "Xiaomi", true) || m3.m.p(str, "Poco", true)) {
            return true;
        }
        return false;
    }
}
