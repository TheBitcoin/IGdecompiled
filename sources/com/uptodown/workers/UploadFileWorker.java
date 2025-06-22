package com.uptodown.workers;

import N1.k;
import W1.C1610f;
import W1.s;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.UptodownApp;
import g2.C2048f;
import g2.C2063v;
import g2.T;
import g2.r;
import h2.C2072d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.L;
import u2.t;
import u2.v;
import u2.x;
import u2.y;
import u2.z;
import v2.C2332c;

public final class UploadFileWorker extends Worker {

    /* renamed from: c  reason: collision with root package name */
    public static final a f19521c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f19522a = k.f7778g.a(this.f19522a);

    /* renamed from: b  reason: collision with root package name */
    private final x f19523b;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            if (!new v().e(context) && !UptodownApp.f17422D.U("UploadFileWorker", context)) {
                WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(UploadFileWorker.class).addTag("UploadFileWorker")).build());
            }
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadFileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.e(context, "context");
        m.e(workerParameters, "params");
        this.f19522a = context;
        this.f19523b = new x(context);
    }

    private final String a(String str, ArrayList arrayList) {
        ApplicationInfo applicationInfo;
        String str2 = str;
        PackageManager packageManager = this.f19522a.getPackageManager();
        Iterator it = arrayList.iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2048f fVar = (C2048f) next;
            Iterator it2 = it;
            if (fVar.r() != null && m3.m.p(fVar.r(), str2, true)) {
                try {
                    m.b(packageManager);
                    String o4 = fVar.o();
                    m.b(o4);
                    applicationInfo = s.a(packageManager, o4, 128);
                } catch (PackageManager.NameNotFoundException unused) {
                    applicationInfo = null;
                }
                if (applicationInfo != null) {
                    String e5 = C1610f.f8672a.e(applicationInfo.sourceDir);
                    if (m3.m.p(str2, e5, true)) {
                        return applicationInfo.sourceDir;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "ignored");
                    bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotMatch");
                    bundle.putString("filehash", str2);
                    bundle.putString("packagename", applicationInfo.packageName);
                    bundle.putString("filehashCalculated", e5);
                    this.f19523b.d("upload", y.f21955a.a(bundle));
                    t a5 = t.f21927u.a(this.f19522a);
                    a5.a();
                    fVar.Z(e5);
                    a5.r1(fVar);
                    a5.i();
                    return null;
                }
            }
            t a6 = t.f21927u.a(this.f19522a);
            a6.a();
            ArrayList a02 = a6.a0(fVar);
            a6.i();
            if (a02 != null) {
                Iterator it3 = a02.iterator();
                m.d(it3, "iterator(...)");
                while (it3.hasNext()) {
                    Object next2 = it3.next();
                    m.d(next2, "next(...)");
                    C2063v vVar = (C2063v) next2;
                    PackageManager packageManager2 = packageManager;
                    Iterator it4 = it3;
                    if (!m3.m.p(str2, vVar.c(), true) || vVar.a() == null) {
                        packageManager = packageManager2;
                        it3 = it4;
                    } else {
                        C1610f fVar2 = C1610f.f8672a;
                        String a7 = vVar.a();
                        m.b(a7);
                        String e6 = fVar2.e(a7);
                        if (m3.m.p(str2, e6, true)) {
                            return vVar.a();
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("type", "ignored");
                        bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotMatch");
                        bundle2.putString("filehash", str2);
                        bundle2.putString("packagename", fVar.o());
                        bundle2.putString("filehashCalculated", e6);
                        this.f19523b.d("upload", y.f21955a.a(bundle2));
                        return null;
                    }
                }
                continue;
            }
            it = it2;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("type", "ignored");
        bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "hashNotFound");
        bundle3.putString("filehash", str2);
        this.f19523b.d("upload", y.f21955a.a(bundle3));
        return null;
    }

    private final JSONObject b() {
        C2072d.f20844a.a();
        boolean c5 = new v().c(this.f19522a);
        boolean d5 = new v().d(this.f19522a);
        if (c5 && c() && !d5) {
            r rVar = new r();
            rVar.j(this.f19522a);
            L l4 = new L(this.f19522a, (C2072d) null);
            String d6 = rVar.d();
            m.b(d6);
            g2.L w4 = l4.w(d6);
            this.f19523b.f("getFileToUpload", (Bundle) null, w4, (String) null);
            if (!l4.h(w4) || w4.d() == null) {
                w4.f();
            } else {
                String d7 = w4.d();
                m.b(d7);
                JSONObject jSONObject = new JSONObject(d7);
                if (jSONObject.optInt("success") == 1) {
                    return jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                }
            }
        }
        return null;
    }

    private final boolean c() {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.T("DownloadUpdatesWorker", this.f19522a) || aVar.T("downloadApkWorker", this.f19522a)) {
            return false;
        }
        return true;
    }

    private final boolean d(String str, String str2) {
        boolean c5 = new v().c(this.f19522a);
        boolean d5 = new v().d(this.f19522a);
        if (!c5 || !c() || d5) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "ignored");
            if (!c5) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "battery");
            } else {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "notIdle");
            }
            this.f19523b.d("upload", y.f21955a.a(bundle));
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            long length = file.length();
            z zVar = z.f21956a;
            if (zVar.f()) {
                return C2332c.b(new C2332c(), this.f19522a, file, str2, false, 8, (Object) null);
            }
            if (zVar.e()) {
                T a5 = T.f20465c.a(this.f19522a);
                if (length > 0 && length < a5.a(this.f19522a)) {
                    return new C2332c().a(this.f19522a, file, str2, true);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("type", "ignored");
                bundle2.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size");
                y yVar = y.f21955a;
                bundle2.putString("size", yVar.e(length));
                this.f19523b.d("upload", yVar.a(bundle2));
                return false;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("type", "ignored");
            bundle3.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "connection");
            y yVar2 = y.f21955a;
            bundle3.putString("size", yVar2.e(length));
            this.f19523b.d("upload", yVar2.a(bundle3));
            return false;
        }
        Bundle bundle4 = new Bundle();
        bundle4.putString("type", "ignored");
        bundle4.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "fileNotFound");
        this.f19523b.d("upload", y.f21955a.a(bundle4));
        return false;
    }

    public ListenableWorker.Result doWork() {
        String str;
        UptodownApp.a aVar = UptodownApp.f17422D;
        boolean T4 = aVar.T("DownloadUpdatesWorker", this.f19522a);
        boolean T5 = aVar.T("downloadApkWorker", this.f19522a);
        if (!T4 && !T5) {
            JSONObject b5 = b();
            if (b5 == null || b5.isNull("sha256")) {
                str = null;
            } else {
                str = b5.optString("sha256");
            }
            if (str != null) {
                t a5 = t.f21927u.a(this.f19522a);
                a5.a();
                ArrayList b02 = a5.b0();
                a5.i();
                String a6 = a(str, b02);
                if (a6 != null && d(a6, str)) {
                    UptodownApp.a.P0(aVar, this.f19522a, false, 2, (Object) null);
                }
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        m.d(success, "success(...)");
        return success;
    }
}
