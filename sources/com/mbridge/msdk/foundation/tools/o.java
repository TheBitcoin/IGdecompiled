package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f13671a;

    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z4);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f13671a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (r0 != 5) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[SYNTHETIC, Splitter:B:48:0x00de] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x0187=Splitter:B:64:0x0187, B:46:0x00ce=Splitter:B:46:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r16, java.lang.String r17, java.lang.String r18, com.mbridge.msdk.foundation.tools.o.a r19, com.mbridge.msdk.foundation.entity.CampaignEx r20) {
        /*
            r0 = r16
            r1 = r18
            r6 = r20
            java.lang.String r2 = ""
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0010
            goto L_0x0195
        L_0x0010:
            java.lang.String r3 = b(r16, r17, r18)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0016
        L_0x0015:
            r3 = r2
        L_0x0016:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.mbridge.msdk.foundation.same.b.c r5 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML
            java.lang.String r5 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r5)
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r7 = r4.toString()
            r4 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x003b }
            if (r5 != 0) goto L_0x003c
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x003b }
            r5.<init>(r7, r3)     // Catch:{ Exception -> 0x003b }
            r4 = r5
            goto L_0x003c
        L_0x003b:
        L_0x003c:
            if (r4 == 0) goto L_0x0044
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x0064
        L_0x0044:
            java.lang.String r4 = ".xml"
            java.lang.String r4 = r3.replace(r4, r2)
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r9 = java.io.File.separator
            r8.append(r9)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r5.<init>(r4, r3)
            r4 = r5
        L_0x0064:
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x006f }
            if (r5 == 0) goto L_0x006f
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x006f }
            goto L_0x0070
        L_0x006f:
            r4 = r2
        L_0x0070:
            com.mbridge.msdk.foundation.same.report.d.e r8 = new com.mbridge.msdk.foundation.same.report.d.e
            r8.<init>()
            java.lang.String r5 = "scenes"
            java.lang.String r9 = "1"
            r8.a(r5, r9)
            java.lang.String r5 = "url"
            r8.a(r5, r1)
            r9 = 2
            java.lang.String r10 = "resource_type"
            r11 = 1
            if (r0 == 0) goto L_0x00a2
            if (r0 == r11) goto L_0x009a
            if (r0 == r9) goto L_0x008f
            r5 = 5
            if (r0 == r5) goto L_0x009a
            goto L_0x00a9
        L_0x008f:
            r5 = 3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0098 }
            r8.a(r10, r5)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a9
        L_0x0098:
            goto L_0x00a9
        L_0x009a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0098 }
            r8.a(r10, r5)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00a9
        L_0x00a2:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0098 }
            r8.a(r10, r5)     // Catch:{ Exception -> 0x0098 }
        L_0x00a9:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r12 = "m_download_start"
            java.lang.String r13 = "cache"
            java.lang.String r14 = "DynamicViewResourceManager"
            if (r5 != 0) goto L_0x00de
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x00de
            if (r19 == 0) goto L_0x0195
            r2 = r4
            r4 = 0
            r5 = 1
            r0 = r19
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00ce
        L_0x00c6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r14, r0)
        L_0x00ce:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0195 }
            r8.a(r13, r0)     // Catch:{ Exception -> 0x0195 }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0195 }
            r0.a((java.lang.String) r12, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.same.report.d.e) r8)     // Catch:{ Exception -> 0x0195 }
            goto L_0x0195
        L_0x00de:
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0178 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x0178 }
            r4 = 47
            int r4 = r3.lastIndexOf(r4)     // Catch:{ Exception -> 0x0178 }
            int r4 = r4 + r11
            java.lang.String r4 = r3.substring(r4)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r3 = ".zip"
            java.lang.String r15 = r4.replace(r3, r2)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r2 = "test_zip_download "
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0178 }
            r3.<init>()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r5 = "start download path： "
            r3.append(r5)     // Catch:{ Exception -> 0x0178 }
            r3.append(r7)     // Catch:{ Exception -> 0x0178 }
            r3.append(r4)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.DownloadMessage r1 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.DownloadResourceType r6 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x017d }
            r5 = 100
            r3 = r18
            r2 = r20
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x017a }
            r6 = r2
            r2 = r4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0178 }
            r1.addExtra(r10, r0)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.MBDownloadManager r0 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.download(r1)     // Catch:{ Exception -> 0x0178 }
            int r1 = com.mbridge.msdk.foundation.same.a.f13147u     // Catch:{ Exception -> 0x0178 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withReadTimeout((long) r3)     // Catch:{ Exception -> 0x0178 }
            int r1 = com.mbridge.msdk.foundation.same.a.f13146t     // Catch:{ Exception -> 0x0178 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r0 = r0.withConnectTimeout((long) r3)     // Catch:{ Exception -> 0x0178 }
            r3 = 60000(0xea60, double:2.9644E-319)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withTimeout(r3)     // Catch:{ Exception -> 0x0178 }
            int r1 = com.mbridge.msdk.foundation.same.a.f13145s     // Catch:{ Exception -> 0x0178 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withWriteTimeout(r3)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r1 = "download_scene"
            java.lang.String r3 = "download_dynamic_view"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.with(r1, r3)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.DownloadPriority r1 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withDownloadPriority(r1)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r0.withHttpRetryCounter(r11)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r10 = r0.withDirectoryPathInternal(r7)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.tools.o$1 r0 = new com.mbridge.msdk.foundation.tools.o$1     // Catch:{ Exception -> 0x0178 }
            r4 = r18
            r3 = r19
            r1 = r7
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r0 = r10.withDownloadStateListener(r0)     // Catch:{ Exception -> 0x0178 }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r0.build()     // Catch:{ Exception -> 0x0178 }
            r0.start()     // Catch:{ Exception -> 0x0178 }
            goto L_0x0187
        L_0x0178:
            r0 = move-exception
            goto L_0x0180
        L_0x017a:
            r0 = move-exception
            r6 = r2
            goto L_0x0180
        L_0x017d:
            r0 = move-exception
            r6 = r20
        L_0x0180:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r14, r0)
        L_0x0187:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0195 }
            r8.a(r13, r0)     // Catch:{ Exception -> 0x0195 }
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0195 }
            r0.a((java.lang.String) r12, (com.mbridge.msdk.foundation.entity.CampaignEx) r6, (com.mbridge.msdk.foundation.same.report.d.e) r8)     // Catch:{ Exception -> 0x0195 }
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(int, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.o$a, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private static String b(int i4, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                String path = new URL(str2).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    return substring.replace(".zip", "");
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!TextUtils.isEmpty(substring)) {
                    String replace = substring.replace(".zip", "");
                    List<String> list = f13671a;
                    if (list == null || list.contains(replace)) {
                        return "";
                    }
                    return replace;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(int i4, String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = b(i4, str, str2);
        } catch (Exception unused) {
            str3 = "";
        }
        String str4 = e.a(c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(str3)) {
                file = new File(str4, str3);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str4 + File.separator + str3.replace(".xml", ""), str3);
        }
        return file.getPath();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC, Splitter:B:16:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            android.net.Uri r0 = android.net.Uri.parse(r11)     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "natmp"
            java.lang.String r0 = r0.getQueryParameter(r2)     // Catch:{ all -> 0x0022 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.lang.String r0 = b(r11)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r0 = r1
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0030
            return r1
        L_0x0030:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb }
            r2.<init>()     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML     // Catch:{ Exception -> 0x00cb }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r3)     // Catch:{ Exception -> 0x00cb }
            r2.append(r3)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x00cb }
            r2.append(r3)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00cb }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00cb }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00cb }
            boolean r0 = r3.isFile()     // Catch:{ Exception -> 0x00cb }
            if (r0 == 0) goto L_0x005d
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00cb }
            if (r0 == 0) goto L_0x005d
            java.lang.String r11 = r3.getPath()     // Catch:{ Exception -> 0x00cb }
            return r11
        L_0x005d:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00cb }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x00cb }
            r3 = 47
            int r3 = r0.lastIndexOf(r3)     // Catch:{ Exception -> 0x00cb }
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r8 = r0.substring(r3)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.DownloadMessage r5 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x00cb }
            java.lang.Object r6 = new java.lang.Object     // Catch:{ Exception -> 0x00cb }
            r6.<init>()     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.DownloadResourceType r10 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER     // Catch:{ Exception -> 0x00cb }
            r9 = 100
            r7 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.MBDownloadManager r11 = com.mbridge.msdk.foundation.download.MBDownloadManager.getInstance()     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.download(r5)     // Catch:{ Exception -> 0x00cb }
            int r0 = com.mbridge.msdk.foundation.same.a.f13147u     // Catch:{ Exception -> 0x00cb }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withReadTimeout((long) r5)     // Catch:{ Exception -> 0x00cb }
            int r0 = com.mbridge.msdk.foundation.same.a.f13141o     // Catch:{ Exception -> 0x00cb }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.DownloadRequestBuilder r11 = r11.withConnectTimeout((long) r5)     // Catch:{ Exception -> 0x00cb }
            java.lang.String r0 = "download_scene"
            java.lang.String r3 = "download_dynamic_view"
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.with(r0, r3)     // Catch:{ Exception -> 0x00cb }
            int r0 = com.mbridge.msdk.foundation.same.a.f13145s     // Catch:{ Exception -> 0x00cb }
            long r5 = (long) r0     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withWriteTimeout(r5)     // Catch:{ Exception -> 0x00cb }
            r5 = 60000(0xea60, double:2.9644E-319)
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withTimeout(r5)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.DownloadPriority r0 = com.mbridge.msdk.foundation.download.DownloadPriority.MEDIUM     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadPriority(r0)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withHttpRetryCounter(r4)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDirectoryPathInternal(r2)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.tools.o$2 r0 = new com.mbridge.msdk.foundation.tools.o$2     // Catch:{ Exception -> 0x00cb }
            r0.<init>(r2, r8)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.RequestBuilder r11 = r11.withDownloadStateListener(r0)     // Catch:{ Exception -> 0x00cb }
            com.mbridge.msdk.foundation.download.core.DownloadRequest r11 = r11.build()     // Catch:{ Exception -> 0x00cb }
            r11.start()     // Catch:{ Exception -> 0x00cb }
        L_0x00cb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.o.a(java.lang.String):java.lang.String");
    }
}
