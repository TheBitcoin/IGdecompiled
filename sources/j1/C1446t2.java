package J1;

import N1.j;
import N1.k;
import R2.n;
import R2.s;
import U1.h;
import W1.C1612h;
import W1.i;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import b2.C1631c;
import b2.C1640l;
import b2.w;
import c2.C1702z;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import d3.p;
import f2.C2007F;
import f2.C2018i;
import f2.C2027s;
import f2.W;
import g2.C2048f;
import g2.C2050h;
import g2.C2060s;
import g2.K;
import g2.S;
import g2.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import u2.t;
import u2.x;

/* renamed from: J1.t2  reason: case insensitive filesystem */
public abstract class C1446t2 extends C1826a {
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public ProgressBar f7137J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public TextView f7138K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public TextView f7139L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public boolean f7140M;

    /* renamed from: N  reason: collision with root package name */
    private boolean f7141N;

    /* renamed from: O  reason: collision with root package name */
    private C1001s0 f7142O;

    /* renamed from: P  reason: collision with root package name */
    private ArrayList f7143P = new ArrayList();

    /* renamed from: Q  reason: collision with root package name */
    private boolean f7144Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public C1702z f7145R;

    /* renamed from: S  reason: collision with root package name */
    private File f7146S;

    /* renamed from: T  reason: collision with root package name */
    private boolean f7147T;

    /* renamed from: U  reason: collision with root package name */
    private e f7148U = new e(this);

    /* renamed from: J1.t2$a */
    public static final class a implements C2018i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7149a;

        a(C1446t2 t2Var) {
            this.f7149a = t2Var;
        }

        public void a(ArrayList arrayList) {
            m.e(arrayList, "positives");
            UptodownApp.f17422D.C0(arrayList);
            this.f7149a.A4();
            this.f7149a.f7140M = false;
        }

        public void b() {
            UptodownApp.f17422D.C0(new ArrayList());
            this.f7149a.A4();
            this.f7149a.f7140M = false;
        }
    }

    /* renamed from: J1.t2$c */
    public static final class c implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2048f f7154b;

        c(C1446t2 t2Var, C2048f fVar) {
            this.f7153a = t2Var;
            this.f7154b = fVar;
        }

        public void b(int i4) {
            C1446t2 t2Var = this.f7153a;
            String string = t2Var.getString(R.string.rollback_not_available, new Object[]{this.f7154b.m()});
            m.d(string, "getString(...)");
            t2Var.q0(string);
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            if (hVar.c()) {
                Intent intent = new Intent(this.f7153a.getApplicationContext(), OldVersionsActivity.class);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f7154b);
                intent.putExtra("appInfo", hVar);
                C1446t2 t2Var = this.f7153a;
                t2Var.startActivity(intent, UptodownApp.f17422D.a(t2Var));
                return;
            }
            C1446t2 t2Var2 = this.f7153a;
            String string = t2Var2.getString(R.string.rollback_not_available, new Object[]{hVar.L()});
            m.d(string, "getString(...)");
            t2Var2.q0(string);
        }
    }

    /* renamed from: J1.t2$d */
    public static final class d implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7155a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2048f f7156b;

        d(C1446t2 t2Var, C2048f fVar) {
            this.f7155a = t2Var;
            this.f7156b = fVar;
        }

        public void a(K k4) {
            m.e(k4, "reportVT");
            Intent intent = new Intent(this.f7155a, VirusTotalReport.class);
            intent.putExtra("app_selected", this.f7156b);
            intent.putExtra("appReportVT", k4);
            C1446t2 t2Var = this.f7155a;
            t2Var.startActivity(intent, UptodownApp.f17422D.a(t2Var));
        }

        public void b() {
            if (this.f7156b.t() > 650000000) {
                Intent intent = new Intent(this.f7155a, VirusTotalReport.class);
                intent.putExtra("app_selected", this.f7156b);
                intent.putExtra("isVirusTotalReportAvaialable", false);
                C1446t2 t2Var = this.f7155a;
                t2Var.startActivity(intent, UptodownApp.f17422D.a(t2Var));
                return;
            }
            this.f7155a.F2(this.f7156b.r());
        }
    }

    /* renamed from: J1.t2$e */
    public static final class e implements C2007F {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7157a;

        e(C1446t2 t2Var) {
            this.f7157a = t2Var;
        }

        public void a(String str) {
            m.e(str, "appName");
            this.f7157a.q0(str);
        }
    }

    /* renamed from: J1.t2$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f7158a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7159b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7160c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i4, C1446t2 t2Var, V2.d dVar) {
            super(2, dVar);
            this.f7159b = i4;
            this.f7160c = t2Var;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f7159b, this.f7160c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f7158a == 0) {
                n.b(obj);
                C1702z zVar = null;
                switch (this.f7159b) {
                    case 106:
                        C1702z A32 = this.f7160c.f7145R;
                        if (A32 == null) {
                            m.u("dialogBinding");
                        } else {
                            zVar = A32;
                        }
                        zVar.f10921p.setText(this.f7160c.getString(R.string.action_update));
                        break;
                    case 107:
                        C1702z A33 = this.f7160c.f7145R;
                        if (A33 == null) {
                            m.u("dialogBinding");
                        } else {
                            zVar = A33;
                        }
                        zVar.f10921p.setText(this.f7160c.getString(R.string.action_cancel_download));
                        break;
                    case 108:
                        C1702z A34 = this.f7160c.f7145R;
                        if (A34 == null) {
                            m.u("dialogBinding");
                        } else {
                            zVar = A34;
                        }
                        zVar.f10921p.setText(this.f7160c.getString(R.string.notification_msg_update_uptodown));
                        break;
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final void G3() {
        new C1631c(this, new a(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void H3(String str, int i4) {
        Window window;
        if (i4 == 0) {
            AlertDialog j22 = j2();
            if (j22 != null) {
                j22.dismiss();
            }
            View inflate = getLayoutInflater().inflate(R.layout.dialog_backup_app, (ViewGroup) null, false);
            k.a aVar = k.f7778g;
            ((TextView) inflate.findViewById(R.id.tv_title_dialog_backup_app)).setTypeface(aVar.w());
            TextView textView = (TextView) inflate.findViewById(R.id.tv_name_dialog_backup_app);
            this.f7138K = textView;
            if (textView != null) {
                textView.setTypeface(aVar.x());
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_percentage_dialog_backup_app);
            this.f7139L = textView2;
            if (textView2 != null) {
                textView2.setTypeface(aVar.x());
            }
            this.f7137J = (ProgressBar) inflate.findViewById(R.id.progressbar_dialog_backup_app);
            View findViewById = inflate.findViewById(R.id.tv_cancel_dialog_backup_app);
            m.d(findViewById, "findViewById(...)");
            TextView textView3 = (TextView) findViewById;
            textView3.setTypeface(aVar.w());
            textView3.setOnClickListener(new C1384k2(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);
            builder.setCancelable(false);
            J2(builder.create());
            AlertDialog j23 = j2();
            if (!(j23 == null || (window = j23.getWindow()) == null)) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog j24 = j2();
            if (j24 != null) {
                j24.show();
            }
        }
        TextView textView4 = this.f7138K;
        if (textView4 != null) {
            textView4.setText(str);
        }
        TextView textView5 = this.f7139L;
        if (textView5 != null) {
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{0}, 1));
            m.d(format, "format(...)");
            textView5.setText(format);
        }
        ProgressBar progressBar = this.f7137J;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void I3(C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            C1001s0 s0Var = t2Var.f7142O;
            if (s0Var == null) {
                m.u("jobBackup");
                s0Var = null;
            }
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
            AlertDialog j22 = t2Var.j2();
            if (j22 != null) {
                j22.dismiss();
            }
            t2Var.J2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public static final s K3(C1446t2 t2Var, File file, S s4) {
        t2Var.x2(file, s4.f());
        return s.f8222a;
    }

    private final void L3(String str, boolean z4) {
        C2060s sVar;
        t.a aVar = t.f21927u;
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        t a5 = aVar.a(applicationContext);
        a5.a();
        S D02 = a5.D0(str);
        a5.i();
        if (D02 != null) {
            sVar = D02.a();
        } else {
            sVar = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "required_feature");
        if (sVar != null && sVar.o().size() == 1 && ((C2060s.c) sVar.o().get(0)).d() > 0) {
            bundle.putString("fileId", String.valueOf(((C2060s.c) sVar.o().get(0)).d()));
        }
        bundle.putString("packagename", str);
        x m22 = m2();
        if (m22 != null) {
            m22.d("warning", bundle);
        }
        String string = getString(R.string.msg_warning_incompatible_required_features);
        m.d(string, "getString(...)");
        O1(string, new V1(this, z4, str));
    }

    /* access modifiers changed from: private */
    public static final s M3(C1446t2 t2Var, boolean z4, String str) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.U("GenerateQueueWorker", t2Var) || aVar.U("downloadApkWorker", t2Var)) {
            String string = t2Var.getString(R.string.error_download_in_progress_wait);
            m.d(string, "getString(...)");
            t2Var.U1(string);
        } else {
            t2Var.f7141N = true;
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", 0).putBoolean("downloadAnyway", z4).putString("packagename", str).build();
            m.d(build, "build(...)");
            WorkManager.getInstance(t2Var).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(build)).build());
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void N3(String str, String str2) {
        AlertDialog j22 = j2();
        if (j22 != null) {
            j22.dismiss();
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_backup_result, (ViewGroup) null, false);
        k.a aVar = k.f7778g;
        ((TextView) inflate.findViewById(R.id.tv_title_dialog_backup_result)).setTypeface(aVar.w());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg_dialog_backup_result);
        textView.setTypeface(aVar.x());
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_ok_dialog_backup_result);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C1363h2(this));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_browse_dialog_backup_result);
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new C1370i2(this));
        if (!(str2 == null || str2.length() == 0)) {
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_share_dialog_backup_result);
            textView4.setTypeface(aVar.w());
            textView4.setOnClickListener(new C1377j2(this, str2));
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        J2(builder.create());
        AlertDialog j23 = j2();
        m.b(j23);
        Window window = j23.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog j24 = j2();
        m.b(j24);
        j24.show();
    }

    /* access modifiers changed from: private */
    public static final void O3(C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog j22 = t2Var.j2();
            if (j22 != null) {
                j22.dismiss();
            }
            t2Var.J2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            Intent intent = new Intent(t2Var, FileExplorerActivity.class);
            intent.putExtra("subdir", new P1.a(t2Var).d());
            intent.putExtra("subdir_sd", new P1.a(t2Var).n());
            t2Var.startActivity(intent);
            AlertDialog j22 = t2Var.j2();
            if (j22 != null) {
                j22.dismiss();
            }
            t2Var.J2((AlertDialog) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void Q3(C1446t2 t2Var, String str, View view) {
        if (UptodownApp.f17422D.a0()) {
            Intent intent = new Intent("android.intent.action.SEND");
            Object c5 = new P1.a(t2Var).c();
            if (c5 instanceof File) {
                File file = new File((File) c5, str);
                if (file.exists()) {
                    intent.setType("application/vnd.android.package-archive");
                    intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(t2Var, t2Var.getPackageName() + ".provider", file));
                    t2Var.startActivity(Intent.createChooser(intent, t2Var.getString(R.string.intent_chooser_title_share_file)));
                }
            } else if (c5 instanceof DocumentFile) {
                intent.putExtra("android.intent.extra.STREAM", ((DocumentFile) c5).getUri());
                t2Var.startActivity(Intent.createChooser(intent, t2Var.getString(R.string.intent_chooser_title_share_file)));
            }
        }
    }

    private final void R3(C2048f fVar, S s4) {
        long j4;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        m.d(layoutInflater, "getLayoutInflater(...)");
        View inflate = layoutInflater.inflate(R.layout.version_details_dialog, (ViewGroup) null, false);
        t a5 = t.f21927u.a(this);
        a5.a();
        if (s4.a() != null) {
            C2060s a6 = s4.a();
            m.b(a6);
            j4 = a6.z();
        } else {
            j4 = 0;
        }
        a5.i();
        k.a aVar = k.f7778g;
        ((TextView) inflate.findViewById(R.id.tv_title_vd)).setTypeface(aVar.w());
        ((TextView) inflate.findViewById(R.id.tv_label_app_name_vd)).setTypeface(aVar.x());
        TextView textView = (TextView) inflate.findViewById(R.id.tv_app_name_vd);
        textView.setTypeface(aVar.w());
        textView.setText(fVar.m());
        ((TextView) inflate.findViewById(R.id.tv_label_installed_version_vd)).setTypeface(aVar.x());
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_installed_version_vd);
        textView2.setTypeface(aVar.w());
        F f4 = F.f20971a;
        String format = String.format("%s(%s)", Arrays.copyOf(new Object[]{fVar.B(), Long.valueOf(fVar.A())}, 2));
        m.d(format, "format(...)");
        textView2.setText(format);
        ((TextView) inflate.findViewById(R.id.tv_label_update_version_vd)).setTypeface(aVar.x());
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_update_version_vd);
        textView3.setTypeface(aVar.w());
        String format2 = String.format("%s(%s)", Arrays.copyOf(new Object[]{s4.k(), Long.valueOf(s4.j())}, 2));
        m.d(format2, "format(...)");
        textView3.setText(format2);
        ((TextView) inflate.findViewById(R.id.tv_label_packagename_vd)).setTypeface(aVar.x());
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_packagename_vd);
        textView4.setTypeface(aVar.w());
        textView4.setText(fVar.o());
        ((TextView) inflate.findViewById(R.id.tv_label_size_vd)).setTypeface(aVar.x());
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_size_vd);
        textView5.setTypeface(aVar.w());
        textView5.setText(new i().d(j4, this));
        ((TextView) inflate.findViewById(R.id.tv_label_filename_vd)).setTypeface(aVar.x());
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_filename_vd);
        textView6.setTypeface(aVar.w());
        textView6.setText(getString(R.string.version_details_filename_not_found, new Object[]{fVar.m()}));
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_version_details_accept);
        textView7.setTypeface(aVar.w());
        textView7.setOnClickListener(new C1349f2(this));
        builder.setView(inflate);
        J2(builder.create());
        if (!isFinishing()) {
            AlertDialog j22 = j2();
            m.b(j22);
            Window window = j22.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog j23 = j2();
            m.b(j23);
            j23.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void S3(C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void U3(C1446t2 t2Var, C2048f fVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            t2Var.C2(fVar.b());
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void V3(C1446t2 t2Var, C2048f fVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            t2Var.v4(fVar);
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void W3(C2048f fVar, C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            String o4 = fVar.o();
            if (!(o4 == null || o4.length() == 0)) {
                PackageManager packageManager = t2Var.getPackageManager();
                String o5 = fVar.o();
                m.b(o5);
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(o5);
                if (launchIntentForPackage != null) {
                    t2Var.startActivity(launchIntentForPackage);
                } else {
                    String string = t2Var.getString(R.string.error_open_app, new Object[]{fVar.m()});
                    m.d(string, "getString(...)");
                    t2Var.U1(string);
                }
            }
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void X3(C2048f fVar, C1446t2 t2Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            String o4 = fVar.o();
            if (!(o4 == null || o4.length() == 0)) {
                j jVar = new j(t2Var);
                String o5 = fVar.o();
                m.b(o5);
                jVar.h(o5);
            }
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void Y3(C1446t2 t2Var, C2048f fVar, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            Intent intent = new Intent(t2Var.getApplicationContext(), K1.b.class);
            intent.putExtra("AppIndex", fVar.o());
            t2Var.startActivity(intent, aVar.a(t2Var));
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void Z3(C1446t2 t2Var, C2048f fVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            C1446t2 t2Var2 = t2Var;
            new w(t2Var2, (C2050h) null, fVar, t2Var.f7148U, LifecycleOwnerKt.getLifecycleScope(t2Var));
            AlertDialog j22 = t2Var2.j2();
            m.b(j22);
            t2Var2.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005a, code lost:
        if (r0.size() > 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0045, code lost:
        if (r0.size() > 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a4(J1.C1446t2 r6, g2.C2048f r7, android.view.View r8) {
        /*
            com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f17422D
            boolean r8 = r8.a0()
            if (r8 == 0) goto L_0x0075
            android.app.AlertDialog r8 = r6.j2()
            kotlin.jvm.internal.m.b(r8)
            r6.l4(r8)
            r8 = 1
            r6.f7147T = r8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.f7143P = r0
            T1.b r0 = new T1.b
            java.lang.String r1 = r7.o()
            kotlin.jvm.internal.m.b(r1)
            java.lang.String r2 = r7.m()
            kotlin.jvm.internal.m.b(r2)
            r0.<init>(r1, r2)
            java.util.ArrayList r1 = r6.f7143P
            r1.add(r0)
            java.util.ArrayList r0 = r7.v()
            if (r0 == 0) goto L_0x0049
            java.util.ArrayList r0 = r7.v()
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0049
        L_0x0047:
            r5 = 1
            goto L_0x005f
        L_0x0049:
            java.util.ArrayList r0 = r7.n()
            if (r0 == 0) goto L_0x005d
            java.util.ArrayList r0 = r7.n()
            kotlin.jvm.internal.m.b(r0)
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x005d
            goto L_0x0047
        L_0x005d:
            r8 = 0
            r5 = 0
        L_0x005f:
            java.lang.String r1 = r7.m()
            kotlin.jvm.internal.m.b(r1)
            java.lang.String r2 = r7.o()
            kotlin.jvm.internal.m.b(r2)
            long r3 = r7.A()
            r0 = r6
            r0.y(r1, r2, r3, r5)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C1446t2.a4(J1.t2, g2.f, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void b4(C1446t2 t2Var, C2048f fVar, View view) {
        t2Var.y4(fVar);
        AlertDialog j22 = t2Var.j2();
        m.b(j22);
        t2Var.l4(j22);
    }

    /* access modifiers changed from: private */
    public static final void c4(C1446t2 t2Var, t tVar, C2048f fVar, int i4, View view) {
        t2Var.o4(tVar, fVar, i4);
    }

    /* access modifiers changed from: private */
    public static final void d4(C1446t2 t2Var, t tVar, C2048f fVar, int i4, View view) {
        t2Var.o4(tVar, fVar, i4);
    }

    /* access modifiers changed from: private */
    public static final void e4(S s4, C1446t2 t2Var, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            aVar.f0(s4.h());
            C2060s a5 = s4.a();
            if (a5 != null) {
                a5.S(t2Var);
            }
            UptodownApp.a.P0(aVar, t2Var, false, 2, (Object) null);
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
        }
    }

    /* access modifiers changed from: private */
    public static final void f4(C1446t2 t2Var, C2048f fVar, S s4, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
            t2Var.R3(fVar, s4);
        }
    }

    /* access modifiers changed from: private */
    public static final void g4(C1446t2 t2Var, S s4, t tVar, int i4, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
            if (s4.m()) {
                s4.p(0);
            } else {
                s4.p(1);
                C2060s a5 = s4.a();
                if (a5 != null) {
                    a5.S(t2Var);
                }
            }
            tVar.a();
            tVar.v1(s4);
            tVar.i();
            t2Var.x4(i4, s4.e());
            UptodownApp.a.P0(aVar, t2Var, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0058, code lost:
        if (r9.size() > 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0043, code lost:
        if (r9.size() > 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0045, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h4(J1.C1446t2 r7, g2.C2048f r8, android.view.View r9) {
        /*
            com.uptodown.UptodownApp$a r9 = com.uptodown.UptodownApp.f17422D
            boolean r9 = r9.a0()
            if (r9 == 0) goto L_0x0073
            android.app.AlertDialog r9 = r7.j2()
            kotlin.jvm.internal.m.b(r9)
            r7.l4(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r7.f7143P = r9
            T1.b r9 = new T1.b
            java.lang.String r0 = r8.o()
            kotlin.jvm.internal.m.b(r0)
            java.lang.String r1 = r8.m()
            kotlin.jvm.internal.m.b(r1)
            r9.<init>(r0, r1)
            java.util.ArrayList r0 = r7.f7143P
            r0.add(r9)
            java.util.ArrayList r9 = r8.v()
            r0 = 1
            if (r9 == 0) goto L_0x0047
            java.util.ArrayList r9 = r8.v()
            kotlin.jvm.internal.m.b(r9)
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x0047
        L_0x0045:
            r6 = 1
            goto L_0x005d
        L_0x0047:
            java.util.ArrayList r9 = r8.n()
            if (r9 == 0) goto L_0x005b
            java.util.ArrayList r9 = r8.n()
            kotlin.jvm.internal.m.b(r9)
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x005b
            goto L_0x0045
        L_0x005b:
            r0 = 0
            r6 = 0
        L_0x005d:
            java.lang.String r2 = r8.m()
            kotlin.jvm.internal.m.b(r2)
            java.lang.String r3 = r8.o()
            kotlin.jvm.internal.m.b(r3)
            long r4 = r8.A()
            r1 = r7
            r1.y(r2, r3, r4, r6)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C1446t2.h4(J1.t2, g2.f, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void i4(C1446t2 t2Var, C2048f fVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
            t2Var.z4(fVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(C1446t2 t2Var, C2048f fVar, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            AlertDialog j22 = t2Var.j2();
            m.b(j22);
            t2Var.l4(j22);
            Intent intent = new Intent(t2Var, AppInstalledDetailsActivity.class);
            intent.putExtra("appInstalled", fVar);
            t2Var.startActivity(intent, aVar.a(t2Var));
        }
    }

    /* access modifiers changed from: private */
    public static final void k4(C1446t2 t2Var, DialogInterface dialogInterface) {
        t2Var.f7144Q = false;
    }

    private final void l4(AlertDialog alertDialog) {
        alertDialog.dismiss();
        this.f7144Q = false;
    }

    private final void o4(t tVar, C2048f fVar, int i4) {
        if (UptodownApp.f17422D.a0()) {
            AlertDialog j22 = j2();
            m.b(j22);
            l4(j22);
            tVar.a();
            if (fVar.e() == 0) {
                fVar.N(1);
                fVar.c0(C2048f.c.UPDATED);
                u2.w wVar = new u2.w();
                Context applicationContext = getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                wVar.b(applicationContext);
            } else {
                fVar.N(0);
                fVar.c0(C2048f.c.OUTDATED);
            }
            tVar.o1(fVar);
            tVar.i();
            w4(i4, fVar.e());
        }
    }

    private final void z4(C2048f fVar) {
        if (!isFinishing()) {
            new b2.p(this, (String) null, fVar.r(), new d(this, fVar), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void A4();

    public final void B4(File file) {
        this.f7146S = file;
    }

    public final void C4(boolean z4) {
        this.f7147T = z4;
    }

    public final void D4(boolean z4) {
        this.f7141N = z4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E4(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            com.uptodown.UptodownApp$a r0 = com.uptodown.UptodownApp.f17422D
            java.lang.String r1 = "GenerateQueueWorker"
            boolean r2 = r0.U(r1, r5)
            if (r2 != 0) goto L_0x00af
            java.lang.String r2 = "downloadApkWorker"
            boolean r2 = r0.U(r2, r5)
            if (r2 != 0) goto L_0x00af
            java.lang.String r2 = "DownloadUpdatesWorker"
            boolean r0 = r0.U(r2, r5)
            if (r0 != 0) goto L_0x00af
            r0 = 1
            if (r6 == 0) goto L_0x005d
            int r2 = r6.length()
            if (r2 != 0) goto L_0x0024
            goto L_0x005d
        L_0x0024:
            u2.t$a r2 = u2.t.f21927u
            android.content.Context r3 = r5.getApplicationContext()
            java.lang.String r4 = "getApplicationContext(...)"
            kotlin.jvm.internal.m.d(r3, r4)
            u2.t r2 = r2.a(r3)
            r2.a()
            g2.S r3 = r2.D0(r6)
            r2.i()
            if (r3 == 0) goto L_0x005d
            g2.r r2 = new g2.r
            r2.<init>()
            java.util.ArrayList r4 = r3.i()
            if (r4 == 0) goto L_0x005d
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0051
            goto L_0x005d
        L_0x0051:
            java.util.ArrayList r3 = r3.i()
            kotlin.jvm.internal.m.b(r3)
            boolean r2 = r2.f(r3, r5)
            goto L_0x005e
        L_0x005d:
            r2 = 1
        L_0x005e:
            if (r2 == 0) goto L_0x00a8
            r5.f7141N = r0
            androidx.work.Data$Builder r0 = new androidx.work.Data$Builder
            r0.<init>()
            java.lang.String r2 = "downloadAutostartedInBackground"
            r3 = 0
            androidx.work.Data$Builder r0 = r0.putInt(r2, r3)
            java.lang.String r2 = "downloadAnyway"
            androidx.work.Data$Builder r7 = r0.putBoolean(r2, r7)
            java.lang.String r0 = "packagename"
            androidx.work.Data$Builder r6 = r7.putString(r0, r6)
            androidx.work.Data r6 = r6.build()
            java.lang.String r7 = "build(...)"
            kotlin.jvm.internal.m.d(r6, r7)
            androidx.work.OneTimeWorkRequest$Builder r7 = new androidx.work.OneTimeWorkRequest$Builder
            java.lang.Class<com.uptodown.workers.GenerateQueueWorker> r0 = com.uptodown.workers.GenerateQueueWorker.class
            r7.<init>(r0)
            androidx.work.WorkRequest$Builder r7 = r7.addTag(r1)
            androidx.work.OneTimeWorkRequest$Builder r7 = (androidx.work.OneTimeWorkRequest.Builder) r7
            androidx.work.WorkRequest$Builder r6 = r7.setInputData(r6)
            androidx.work.OneTimeWorkRequest$Builder r6 = (androidx.work.OneTimeWorkRequest.Builder) r6
            androidx.work.WorkRequest r6 = r6.build()
            androidx.work.OneTimeWorkRequest r6 = (androidx.work.OneTimeWorkRequest) r6
            androidx.work.WorkManager r7 = androidx.work.WorkManager.getInstance(r5)
            androidx.work.Operation r6 = r7.enqueue((androidx.work.WorkRequest) r6)
            kotlin.jvm.internal.m.b(r6)
            return
        L_0x00a8:
            kotlin.jvm.internal.m.b(r6)
            r5.L3(r6, r7)
            return
        L_0x00af:
            r6 = 2131951998(0x7f13017e, float:1.9540426E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r7 = "getString(...)"
            kotlin.jvm.internal.m.d(r6, r7)
            r5.U1(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C1446t2.E4(java.lang.String, boolean):void");
    }

    public final void F3(int i4, boolean z4, Toolbar toolbar) {
        m.e(toolbar, "toolbar");
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            m.b(menu);
            menu.findItem(i4).setChecked(z4);
        }
    }

    public final void F4(int i4) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new f(i4, this, (V2.d) null), 2, (Object) null);
    }

    public void J3(File file, S s4) {
        m.e(file, "file");
        m.e(s4, "update");
        String string = getString(R.string.msg_warning_incompatible_required_features_to_install);
        m.d(string, "getString(...)");
        O1(string, new C1342e2(this, file, s4));
    }

    public final void T3(C2048f fVar, int i4) {
        long j4;
        C1702z zVar;
        Window window;
        NsdServiceInfo e5;
        String k4;
        C2048f fVar2 = fVar;
        int i5 = i4;
        if (!isFinishing() && fVar2 != null) {
            C1702z c5 = C1702z.c(getLayoutInflater());
            this.f7145R = c5;
            if (c5 == null) {
                m.u("dialogBinding");
                c5 = null;
            }
            TextView textView = c5.f10919n;
            k.a aVar = k.f7778g;
            textView.setTypeface(aVar.w());
            C1702z zVar2 = this.f7145R;
            if (zVar2 == null) {
                m.u("dialogBinding");
                zVar2 = null;
            }
            zVar2.f10919n.setText(fVar2.m());
            String o4 = fVar2.o();
            if (o4 == null || o4.length() == 0 || (k4 = fVar2.k()) == null || k4.length() == 0 || fVar2.b() == 0) {
                C1702z zVar3 = this.f7145R;
                if (zVar3 == null) {
                    m.u("dialogBinding");
                    zVar3 = null;
                }
                zVar3.f10917l.setVisibility(8);
            } else {
                C1702z zVar4 = this.f7145R;
                if (zVar4 == null) {
                    m.u("dialogBinding");
                    zVar4 = null;
                }
                zVar4.f10917l.setTypeface(aVar.x());
                C1702z zVar5 = this.f7145R;
                if (zVar5 == null) {
                    m.u("dialogBinding");
                    zVar5 = null;
                }
                zVar5.f10917l.setOnClickListener(new C1356g2(this, fVar2));
            }
            t.a aVar2 = t.f21927u;
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            t a5 = aVar2.a(applicationContext);
            a5.a();
            String o5 = fVar2.o();
            m.b(o5);
            S D02 = a5.D0(o5);
            a5.i();
            C2060s a6 = D02 != null ? D02.a() : null;
            if (D02 != null) {
                C1702z zVar6 = this.f7145R;
                if (zVar6 == null) {
                    m.u("dialogBinding");
                    zVar6 = null;
                }
                zVar6.f10921p.setTypeface(aVar.x());
                if (D02.c()) {
                    C1702z zVar7 = this.f7145R;
                    if (zVar7 == null) {
                        m.u("dialogBinding");
                        zVar7 = null;
                    }
                    zVar7.f10921p.setText(getString(R.string.action_cancel_download));
                } else if (a6 != null && a6.f()) {
                    C1702z zVar8 = this.f7145R;
                    if (zVar8 == null) {
                        m.u("dialogBinding");
                        zVar8 = null;
                    }
                    zVar8.f10921p.setText(getString(R.string.notification_msg_update_uptodown));
                } else if (a6 == null || a6.x() <= 0) {
                    C1702z zVar9 = this.f7145R;
                    if (zVar9 == null) {
                        m.u("dialogBinding");
                        zVar9 = null;
                    }
                    zVar9.f10921p.setText(getString(R.string.action_update));
                } else {
                    C1702z zVar10 = this.f7145R;
                    if (zVar10 == null) {
                        m.u("dialogBinding");
                        zVar10 = null;
                    }
                    zVar10.f10921p.setText(getString(R.string.updates_button_resume));
                }
                C1702z zVar11 = this.f7145R;
                if (zVar11 == null) {
                    m.u("dialogBinding");
                    zVar11 = null;
                }
                zVar11.f10921p.setOnClickListener(new C1439s2(this, fVar2));
            } else {
                C1702z zVar12 = this.f7145R;
                if (zVar12 == null) {
                    m.u("dialogBinding");
                    zVar12 = null;
                }
                zVar12.f10921p.setVisibility(8);
            }
            if (!m3.m.p(getPackageName(), fVar2.o(), true)) {
                C1702z zVar13 = this.f7145R;
                if (zVar13 == null) {
                    m.u("dialogBinding");
                    zVar13 = null;
                }
                zVar13.f10916k.setTypeface(aVar.x());
                C1702z zVar14 = this.f7145R;
                if (zVar14 == null) {
                    m.u("dialogBinding");
                    zVar14 = null;
                }
                zVar14.f10916k.setOnClickListener(new W1(fVar2, this));
                C1702z zVar15 = this.f7145R;
                if (zVar15 == null) {
                    m.u("dialogBinding");
                    zVar15 = null;
                }
                zVar15.f10920o.setTypeface(aVar.x());
                C1702z zVar16 = this.f7145R;
                if (zVar16 == null) {
                    m.u("dialogBinding");
                    zVar16 = null;
                }
                zVar16.f10920o.setOnClickListener(new X1(fVar2, this));
            } else {
                C1702z zVar17 = this.f7145R;
                if (zVar17 == null) {
                    m.u("dialogBinding");
                    zVar17 = null;
                }
                zVar17.f10916k.setVisibility(8);
                C1702z zVar18 = this.f7145R;
                if (zVar18 == null) {
                    m.u("dialogBinding");
                    zVar18 = null;
                }
                zVar18.f10920o.setVisibility(8);
            }
            if (UptodownApp.f17422D.K()) {
                C1702z zVar19 = this.f7145R;
                if (zVar19 == null) {
                    m.u("dialogBinding");
                    zVar19 = null;
                }
                zVar19.f10916k.setText(R.string.debug_title_info_app);
                C1702z zVar20 = this.f7145R;
                if (zVar20 == null) {
                    m.u("dialogBinding");
                    zVar20 = null;
                }
                zVar20.f10916k.setOnClickListener(new Y1(this, fVar2));
                C1702z zVar21 = this.f7145R;
                if (zVar21 == null) {
                    m.u("dialogBinding");
                    zVar21 = null;
                }
                zVar21.f10916k.setVisibility(0);
            }
            String z4 = fVar2.z();
            if (z4 == null || z4.length() == 0) {
                C1702z zVar22 = this.f7145R;
                if (zVar22 == null) {
                    m.u("dialogBinding");
                    zVar22 = null;
                }
                zVar22.f10918m.setVisibility(8);
            } else {
                C1702z zVar23 = this.f7145R;
                if (zVar23 == null) {
                    m.u("dialogBinding");
                    zVar23 = null;
                }
                zVar23.f10918m.setTypeface(aVar.x());
                C1702z zVar24 = this.f7145R;
                if (zVar24 == null) {
                    m.u("dialogBinding");
                    zVar24 = null;
                }
                zVar24.f10918m.setOnClickListener(new Z1(this, fVar2));
            }
            C1702z zVar25 = this.f7145R;
            if (zVar25 == null) {
                m.u("dialogBinding");
                zVar25 = null;
            }
            zVar25.f10914i.setTypeface(aVar.x());
            C1702z zVar26 = this.f7145R;
            if (zVar26 == null) {
                m.u("dialogBinding");
                zVar26 = null;
            }
            zVar26.f10914i.setOnClickListener(new C1314a2(this, fVar2));
            U1.c r4 = aVar.r();
            if (r4 == null || !r4.j()) {
                j4 = 0;
            } else {
                h o6 = aVar.o();
                String serviceName = (o6 == null || (e5 = o6.e()) == null) ? null : e5.getServiceName();
                if (serviceName != null) {
                    C1702z zVar27 = this.f7145R;
                    if (zVar27 == null) {
                        m.u("dialogBinding");
                        zVar27 = null;
                    }
                    TextView textView2 = zVar27.f10914i;
                    F f4 = F.f20971a;
                    j4 = 0;
                    String format = String.format("%s%s", Arrays.copyOf(new Object[]{getString(R.string.nsd_option_send_to), h.f8425h.c(serviceName)}, 2));
                    m.d(format, "format(...)");
                    textView2.setText(format);
                } else {
                    j4 = 0;
                    C1702z zVar28 = this.f7145R;
                    if (zVar28 == null) {
                        m.u("dialogBinding");
                        zVar28 = null;
                    }
                    zVar28.f10914i.setVisibility(8);
                }
            }
            if (fVar2.h() != 1 || fVar2.b() == j4) {
                C1702z zVar29 = this.f7145R;
                if (zVar29 == null) {
                    m.u("dialogBinding");
                    zVar29 = null;
                }
                zVar29.f10915j.setVisibility(8);
            } else {
                C1702z zVar30 = this.f7145R;
                if (zVar30 == null) {
                    m.u("dialogBinding");
                    zVar30 = null;
                }
                zVar30.f10915j.setTypeface(aVar.x());
                C1702z zVar31 = this.f7145R;
                if (zVar31 == null) {
                    m.u("dialogBinding");
                    zVar31 = null;
                }
                zVar31.f10915j.setOnClickListener(new C1321b2(this, fVar2));
            }
            C1702z zVar32 = this.f7145R;
            if (zVar32 == null) {
                m.u("dialogBinding");
                zVar32 = null;
            }
            zVar32.f10912g.setTypeface(aVar.x());
            C1702z zVar33 = this.f7145R;
            if (zVar33 == null) {
                m.u("dialogBinding");
                zVar33 = null;
            }
            zVar33.f10907b.setChecked(fVar2.e() == 0);
            C1702z zVar34 = this.f7145R;
            if (zVar34 == null) {
                m.u("dialogBinding");
                zVar34 = null;
            }
            zVar34.f10908c.setOnClickListener(new C1328c2(this, a5, fVar2, i5));
            C1702z zVar35 = this.f7145R;
            if (zVar35 == null) {
                m.u("dialogBinding");
                zVar35 = null;
            }
            zVar35.f10907b.setOnClickListener(new C1335d2(this, a5, fVar2, i5));
            if (D02 != null && fVar2.w() == C2048f.c.OUTDATED && fVar2.e() == 0) {
                C1702z zVar36 = this.f7145R;
                if (zVar36 == null) {
                    m.u("dialogBinding");
                    zVar36 = null;
                }
                zVar36.f10911f.setTypeface(aVar.x());
                C1702z zVar37 = this.f7145R;
                if (zVar37 == null) {
                    m.u("dialogBinding");
                    zVar37 = null;
                }
                zVar37.f10911f.setOnClickListener(new C1391l2(D02, this));
                C1702z zVar38 = this.f7145R;
                if (zVar38 == null) {
                    m.u("dialogBinding");
                    zVar38 = null;
                }
                zVar38.f10922q.setTypeface(aVar.x());
                C1702z zVar39 = this.f7145R;
                if (zVar39 == null) {
                    m.u("dialogBinding");
                    zVar39 = null;
                }
                zVar39.f10922q.setOnClickListener(new C1398m2(this, fVar2, D02));
            } else {
                C1702z zVar40 = this.f7145R;
                if (zVar40 == null) {
                    m.u("dialogBinding");
                    zVar40 = null;
                }
                zVar40.f10911f.setVisibility(8);
                C1702z zVar41 = this.f7145R;
                if (zVar41 == null) {
                    m.u("dialogBinding");
                    zVar41 = null;
                }
                zVar41.f10922q.setVisibility(8);
            }
            if (D02 != null) {
                C1702z zVar42 = this.f7145R;
                if (zVar42 == null) {
                    m.u("dialogBinding");
                    zVar42 = null;
                }
                zVar42.f10913h.setVisibility(0);
                C1702z zVar43 = this.f7145R;
                if (zVar43 == null) {
                    m.u("dialogBinding");
                    zVar43 = null;
                }
                zVar43.f10913h.setTypeface(aVar.x());
                if (D02.m()) {
                    C1702z zVar44 = this.f7145R;
                    if (zVar44 == null) {
                        m.u("dialogBinding");
                        zVar44 = null;
                    }
                    zVar44.f10913h.setText(R.string.reactivate_skipped_update);
                } else {
                    C1702z zVar45 = this.f7145R;
                    if (zVar45 == null) {
                        m.u("dialogBinding");
                        zVar45 = null;
                    }
                    zVar45.f10913h.setText(R.string.skip_update);
                }
                C1702z zVar46 = this.f7145R;
                if (zVar46 == null) {
                    m.u("dialogBinding");
                    zVar46 = null;
                }
                zVar46.f10913h.setOnClickListener(new C1405n2(this, D02, a5, i5));
            } else {
                C1702z zVar47 = this.f7145R;
                if (zVar47 == null) {
                    m.u("dialogBinding");
                    zVar47 = null;
                }
                zVar47.f10913h.setVisibility(8);
            }
            if (fVar2.o() != null) {
                C1702z zVar48 = this.f7145R;
                if (zVar48 == null) {
                    m.u("dialogBinding");
                    zVar48 = null;
                }
                zVar48.f10910e.setVisibility(0);
                C1702z zVar49 = this.f7145R;
                if (zVar49 == null) {
                    m.u("dialogBinding");
                    zVar49 = null;
                }
                zVar49.f10910e.setTypeface(aVar.x());
                C1702z zVar50 = this.f7145R;
                if (zVar50 == null) {
                    m.u("dialogBinding");
                    zVar50 = null;
                }
                zVar50.f10910e.setOnClickListener(new C1412o2(this, fVar2));
            }
            if (fVar2.r() != null) {
                C1702z zVar51 = this.f7145R;
                if (zVar51 == null) {
                    m.u("dialogBinding");
                    zVar51 = null;
                }
                zVar51.f10923r.setVisibility(0);
                C1702z zVar52 = this.f7145R;
                if (zVar52 == null) {
                    m.u("dialogBinding");
                    zVar52 = null;
                }
                zVar52.f10923r.setTypeface(aVar.x());
                C1702z zVar53 = this.f7145R;
                if (zVar53 == null) {
                    m.u("dialogBinding");
                    zVar53 = null;
                }
                zVar53.f10923r.setOnClickListener(new C1419p2(this, fVar2));
            }
            C1702z zVar54 = this.f7145R;
            if (zVar54 == null) {
                m.u("dialogBinding");
                zVar54 = null;
            }
            zVar54.f10909d.setTypeface(aVar.x());
            C1702z zVar55 = this.f7145R;
            if (zVar55 == null) {
                m.u("dialogBinding");
                zVar55 = null;
            }
            zVar55.f10909d.setOnClickListener(new C1426q2(this, fVar2));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C1702z zVar56 = this.f7145R;
            if (zVar56 == null) {
                m.u("dialogBinding");
                zVar = null;
            } else {
                zVar = zVar56;
            }
            builder.setView(zVar.getRoot());
            J2(builder.create());
            AlertDialog j22 = j2();
            if (j22 != null) {
                j22.setOnCancelListener(new C1432r2(this));
                s sVar = s.f8222a;
            }
            if (!isFinishing()) {
                AlertDialog j23 = j2();
                if (!(j23 == null || (window = j23.getWindow()) == null)) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    s sVar2 = s.f8222a;
                }
                AlertDialog j24 = j2();
                if (j24 != null) {
                    j24.show();
                    s sVar3 = s.f8222a;
                }
                this.f7144Q = true;
            }
        }
    }

    public void V() {
        this.f7142O = new R1.a(this, new b(this)).t(this.f7143P);
        this.f7143P = new ArrayList();
    }

    public void X0() {
        File file;
        super.X0();
        h o4 = k.f7778g.o();
        m.b(o4);
        if (o4.e() != null && (file = this.f7146S) != null) {
            m.b(file);
            if (!file.isDirectory()) {
                UptodownApp uptodownApp = new UptodownApp();
                File file2 = this.f7146S;
                m.b(file2);
                uptodownApp.V(file2);
            }
        }
    }

    public final void m4(int i4, boolean z4, Toolbar toolbar) {
        m.e(toolbar, "toolbar");
        if (toolbar.getMenu() != null) {
            Menu menu = toolbar.getMenu();
            m.b(menu);
            menu.findItem(i4).setEnabled(z4);
        }
    }

    public final void n4(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        UptodownApp.a aVar = UptodownApp.f17422D;
        String o4 = fVar.o();
        m.b(o4);
        if (!aVar.P(o4)) {
            aVar.c(fVar);
        }
    }

    public final File p4() {
        return this.f7146S;
    }

    public final boolean q4() {
        return this.f7141N;
    }

    public final boolean r4() {
        return this.f7147T;
    }

    public final boolean s4() {
        return this.f7144Q;
    }

    public final void t4() {
        if (!this.f7140M) {
            this.f7140M = true;
            G3();
        }
    }

    public final void u4(C2048f fVar) {
        String str;
        if (fVar != null) {
            str = fVar.o();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            t a5 = t.f21927u.a(this);
            a5.a();
            m.b(fVar);
            String o4 = fVar.o();
            m.b(o4);
            S D02 = a5.D0(o4);
            if (D02 != null) {
                UptodownApp.a aVar = UptodownApp.f17422D;
                if (aVar.O(D02)) {
                    DownloadWorker.f19459d.c(D02.h());
                    aVar.e0(D02);
                } else if (aVar.P(D02.h())) {
                    aVar.f0(D02.h());
                }
            }
            a5.i();
        }
    }

    public final void v4(C2048f fVar) {
        String str;
        if (fVar != null) {
            str = fVar.o();
        } else {
            str = null;
        }
        if (str != null) {
            t.a aVar = t.f21927u;
            Context applicationContext = getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            t a5 = aVar.a(applicationContext);
            a5.a();
            String o4 = fVar.o();
            m.b(o4);
            S D02 = a5.D0(o4);
            if (D02 != null) {
                C2060s a6 = D02.a();
                if (D02.c()) {
                    DownloadWorker.a aVar2 = DownloadWorker.f19459d;
                    if (aVar2.h()) {
                        aVar2.o();
                    } else if (UptodownApp.f17422D.N(this)) {
                        aVar2.c(D02.h());
                    } else {
                        E4(fVar.o(), false);
                    }
                } else if (a6 != null) {
                    if (a6.f()) {
                        boolean z4 = true;
                        if (m3.m.p(a6.w(), getApplicationContext().getPackageName(), true)) {
                            String a7 = ((C2060s.c) a6.o().get(0)).a();
                            m.b(a7);
                            S1(new File(a7));
                        } else {
                            r rVar = new r();
                            ArrayList i4 = D02.i();
                            if (i4 != null && !i4.isEmpty()) {
                                ArrayList i5 = D02.i();
                                m.b(i5);
                                z4 = rVar.f(i5, this);
                            }
                            File n4 = a6.n();
                            if (n4 == null || !n4.exists() || !a6.b(n4)) {
                                Context applicationContext2 = getApplicationContext();
                                m.d(applicationContext2, "getApplicationContext(...)");
                                a6.S(applicationContext2);
                                String string = getString(R.string.installable_files_not_found);
                                m.d(string, "getString(...)");
                                U1(string);
                            } else if (z4) {
                                x2(n4, D02.f());
                            } else {
                                J3(n4, D02);
                            }
                        }
                    } else {
                        UptodownApp.a aVar3 = UptodownApp.f17422D;
                        if (!aVar3.N(this)) {
                            E4(fVar.o(), false);
                        } else {
                            String o5 = fVar.o();
                            m.b(o5);
                            if (aVar3.P(o5)) {
                                String o6 = fVar.o();
                                m.b(o6);
                                aVar3.f0(o6);
                            } else {
                                n4(fVar);
                            }
                        }
                    }
                } else if (!UptodownApp.f17422D.N(this)) {
                    E4(fVar.o(), false);
                } else {
                    n4(fVar);
                }
            }
            a5.i();
        }
    }

    public final void y4(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        new C1640l(this, fVar.b(), new c(this, fVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* renamed from: J1.t2$b */
    public static final class b implements S1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1446t2 f7150a;

        b(C1446t2 t2Var) {
            this.f7150a = t2Var;
        }

        public void a(T1.b bVar) {
            m.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            C1446t2 t2Var = this.f7150a;
            t2Var.F(t2Var.getString(R.string.core_msg_cannot_write_path));
        }

        public void b(T1.b bVar, int i4) {
            m.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f7150a.H3(bVar.b(), i4);
        }

        public void c(ArrayList arrayList) {
            m.e(arrayList, "apps");
            NsdServiceInfo nsdServiceInfo = null;
            if (arrayList.size() == 1) {
                if (this.f7150a.r4()) {
                    AlertDialog j22 = this.f7150a.j2();
                    if (j22 != null) {
                        j22.dismiss();
                    }
                    this.f7150a.C4(false);
                    Object c5 = new P1.a(this.f7150a).c();
                    if (c5 instanceof File) {
                        C1446t2 t2Var = this.f7150a;
                        String a5 = ((T1.b) arrayList.get(0)).a();
                        m.b(a5);
                        t2Var.B4(new File((File) c5, a5));
                        h o4 = k.f7778g.o();
                        if (o4 != null) {
                            nsdServiceInfo = o4.e();
                        }
                        if (nsdServiceInfo == null) {
                            this.f7150a.P0();
                            return;
                        }
                        File p4 = this.f7150a.p4();
                        if (p4 != null && p4.exists()) {
                            File p42 = this.f7150a.p4();
                            m.b(p42);
                            if (!p42.isDirectory()) {
                                UptodownApp uptodownApp = new UptodownApp();
                                File p43 = this.f7150a.p4();
                                m.b(p43);
                                uptodownApp.V(p43);
                                return;
                            }
                        }
                        C1446t2 t2Var2 = this.f7150a;
                        t2Var2.F(t2Var2.getString(R.string.error_generico));
                    } else if (c5 instanceof DocumentFile) {
                        String a6 = ((T1.b) arrayList.get(0)).a();
                        m.b(a6);
                        DocumentFile findFile = ((DocumentFile) c5).findFile(a6);
                        if (findFile != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(findFile);
                            new R1.b(arrayList2, new C1612h().g(this.f7150a), new a(this.f7150a, arrayList), false, this.f7150a);
                        }
                    }
                } else {
                    this.f7150a.N3(((T1.b) arrayList.get(0)).b(), ((T1.b) arrayList.get(0)).a());
                }
            } else if (arrayList.size() > 0) {
                F f4 = F.f20971a;
                String string = this.f7150a.getString(R.string.msg_backup_x_apps);
                m.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(arrayList.size())}, 1));
                m.d(format, "format(...)");
                this.f7150a.N3(format, (String) null);
            }
        }

        public void d(T1.b bVar) {
            m.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            C1446t2 t2Var = this.f7150a;
            t2Var.F(t2Var.getString(R.string.core_msg_cannot_write_path));
        }

        public void e(String str) {
            m.e(str, "appName");
            TextView C32 = this.f7150a.f7138K;
            if (C32 != null) {
                C32.setText(str);
            }
            TextView D32 = this.f7150a.f7139L;
            if (D32 != null) {
                F f4 = F.f20971a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{0}, 1));
                m.d(format, "format(...)");
                D32.setText(format);
            }
            ProgressBar B32 = this.f7150a.f7137J;
            if (B32 != null) {
                B32.setProgress(0);
            }
        }

        public void f(T1.b bVar) {
            m.e(bVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            C1446t2 t2Var = this.f7150a;
            t2Var.F(t2Var.getString(R.string.backup_no_free_space));
        }

        public void g(int i4) {
            TextView D32 = this.f7150a.f7139L;
            if (D32 != null) {
                F f4 = F.f20971a;
                String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
                m.d(format, "format(...)");
                D32.setText(format);
            }
            ProgressBar B32 = this.f7150a.f7137J;
            if (B32 != null) {
                B32.setProgress(i4);
            }
        }

        /* renamed from: J1.t2$b$a */
        public static final class a implements S1.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1446t2 f7151a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f7152b;

            a(C1446t2 t2Var, ArrayList arrayList) {
                this.f7151a = t2Var;
                this.f7152b = arrayList;
            }

            public void a(DocumentFile documentFile) {
                m.e(documentFile, "docFile");
            }

            public void b(Object obj, int i4, int i5, long j4) {
                m.e(obj, "file");
            }

            public void c(File file) {
                m.e(file, "file");
            }

            public void d(DocumentFile documentFile) {
                m.e(documentFile, "docFile");
            }

            public void e(int i4, String str, long j4, long j5) {
                m.e(str, "currentFilename");
            }

            public void f(File file) {
                m.e(file, "file");
            }

            public void h(Object obj) {
                m.e(obj, "file");
            }

            public void i() {
                NsdServiceInfo nsdServiceInfo;
                C1446t2 t2Var = this.f7151a;
                File g4 = new C1612h().g(this.f7151a);
                String a5 = ((T1.b) this.f7152b.get(0)).a();
                m.b(a5);
                t2Var.B4(new File(g4, a5));
                h o4 = k.f7778g.o();
                if (o4 != null) {
                    nsdServiceInfo = o4.e();
                } else {
                    nsdServiceInfo = null;
                }
                if (nsdServiceInfo == null) {
                    this.f7151a.P0();
                    return;
                }
                File p4 = this.f7151a.p4();
                if (p4 != null && p4.exists()) {
                    File p42 = this.f7151a.p4();
                    m.b(p42);
                    if (!p42.isDirectory()) {
                        UptodownApp uptodownApp = new UptodownApp();
                        File p43 = this.f7151a.p4();
                        m.b(p43);
                        uptodownApp.V(p43);
                        return;
                    }
                }
                C1446t2 t2Var2 = this.f7151a;
                t2Var2.F(t2Var2.getString(R.string.error_generico));
            }

            public void g() {
            }
        }
    }

    public void w4(int i4, int i5) {
    }

    public void x4(int i4, int i5) {
    }
}
