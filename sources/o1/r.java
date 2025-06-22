package O1;

import N1.f;
import N1.g;
import N1.i;
import N1.k;
import R2.n;
import R2.s;
import V2.d;
import W1.C1612h;
import W2.b;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.core.activities.FileExplorerActivity;
import d3.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public abstract class r extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private AlertDialog f7929a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7930b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f7931c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f7932d;

    /* renamed from: e  reason: collision with root package name */
    private RadioButton f7933e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f7934f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f7935g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f7936h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f7937i;

    /* renamed from: j  reason: collision with root package name */
    private String f7938j;

    /* renamed from: k  reason: collision with root package name */
    private final ActivityResultLauncher f7939k;

    /* renamed from: l  reason: collision with root package name */
    private final ActivityResultLauncher f7940l;

    /* renamed from: m  reason: collision with root package name */
    private final ActivityResultLauncher f7941m;

    /* renamed from: n  reason: collision with root package name */
    private ActivityResultLauncher f7942n;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f7943a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f7944b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7945c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r rVar, String str, d dVar) {
            super(2, dVar);
            this.f7944b = rVar;
            this.f7945c = str;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f7944b, this.f7945c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f7943a == 0) {
                n.b(obj);
                View inflate = this.f7944b.getLayoutInflater().inflate(g.uptodown_toast, (ViewGroup) null, false);
                View findViewById = inflate.findViewById(f.tv_text_uptodown_toast);
                String str = this.f7945c;
                TextView textView = (TextView) findViewById;
                textView.setTypeface(k.f7778g.x());
                textView.setText(str);
                Toast toast = new Toast(this.f7944b);
                toast.setDuration(1);
                toast.setGravity(81, 0, 100);
                if (Build.VERSION.SDK_INT >= 30) {
                    toast.setView(inflate);
                } else {
                    toast.setView(inflate);
                }
                toast.show();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public r() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1567j(this));
        m.d(registerForActivityResult, "registerForActivityResul…nDenied()\n        }\n    }");
        this.f7939k = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1569k(this));
        m.d(registerForActivityResult2, "registerForActivityResul…        }\n        }\n    }");
        this.f7940l = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1571l(this));
        m.d(registerForActivityResult3, "registerForActivityResul…nownSourcesResult()\n    }");
        this.f7941m = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1573m(this));
        m.d(registerForActivityResult4, "registerForActivityResul…        tmp(result)\n    }");
        this.f7942n = registerForActivityResult4;
    }

    /* access modifiers changed from: private */
    public static final void A(r rVar, String str, String str2, long j4, boolean z4, CompoundButton compoundButton, boolean z5) {
        m.e(rVar, "this$0");
        rVar.t0(str, str2, j4, z4);
    }

    /* access modifiers changed from: private */
    public static final void B(r rVar, String str, String str2, long j4, boolean z4, RadioGroup radioGroup, int i4) {
        m.e(rVar, "this$0");
        rVar.t0(str, str2, j4, z4);
    }

    /* access modifiers changed from: private */
    public static final void C(r rVar, String str, String str2, long j4, boolean z4, RadioGroup radioGroup, int i4) {
        m.e(rVar, "this$0");
        rVar.t0(str, str2, j4, z4);
    }

    /* access modifiers changed from: private */
    public static final void D(r rVar, View view) {
        m.e(rVar, "this$0");
        TextView textView = rVar.f7936h;
        TextView textView2 = null;
        if (textView == null) {
            m.u("tvErrorPath");
            textView = null;
        }
        if (textView.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(rVar.getApplicationContext(), N1.a.core_shake);
            TextView textView3 = rVar.f7936h;
            if (textView3 == null) {
                m.u("tvErrorPath");
            } else {
                textView2 = textView3;
            }
            textView2.startAnimation(loadAnimation);
            return;
        }
        if (rVar.f7937i != null) {
            new P1.a(rVar).E(m.a(rVar.f7937i, Boolean.TRUE));
        }
        if (rVar.f7938j != null) {
            new P1.a(rVar).y(rVar.f7938j);
        }
        rVar.n0();
        AlertDialog alertDialog = rVar.f7929a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        rVar.f7929a = null;
        rVar.V();
    }

    /* access modifiers changed from: private */
    public static final void E(r rVar, View view) {
        m.e(rVar, "this$0");
        AlertDialog alertDialog = rVar.f7929a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        rVar.f7929a = null;
    }

    /* access modifiers changed from: private */
    public static final void G(r rVar, View view) {
        m.e(rVar, "this$0");
        AlertDialog alertDialog = rVar.f7929a;
        m.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void I(r rVar, View view) {
        m.e(rVar, "this$0");
        AlertDialog alertDialog = rVar.f7929a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        rVar.l0();
    }

    /* access modifiers changed from: private */
    public static final void K(r rVar, View view) {
        m.e(rVar, "this$0");
        AlertDialog alertDialog = rVar.f7929a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        rVar.k0();
    }

    /* access modifiers changed from: private */
    public static final void L(r rVar, View view) {
        m.e(rVar, "this$0");
        AlertDialog alertDialog = rVar.f7929a;
        m.b(alertDialog);
        alertDialog.dismiss();
        rVar.f0();
    }

    /* access modifiers changed from: private */
    public static final void M(r rVar, ActivityResult activityResult) {
        m.e(rVar, "this$0");
        m.d(activityResult, "result");
        rVar.r0(activityResult);
    }

    private final String N() {
        String string = getString(i.app_name);
        m.d(string, "getString(R.string.app_name)");
        return string;
    }

    private final long P() {
        try {
            PackageManager packageManager = getPackageManager();
            m.d(packageManager, "packageManager");
            String packageName = getPackageName();
            m.d(packageName, "packageName");
            return new C1612h().m(W1.s.d(packageManager, packageName, 0));
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static final void U(r rVar, ActivityResult activityResult) {
        m.e(rVar, "this$0");
        if (rVar.R()) {
            rVar.d0();
        } else {
            rVar.b0();
        }
    }

    private final void n0() {
        String str;
        P1.a aVar = new P1.a(this);
        RadioButton radioButton = this.f7931c;
        RadioButton radioButton2 = null;
        if (radioButton == null) {
            m.u("rbAppName");
            radioButton = null;
        }
        aVar.u(radioButton.isChecked());
        RadioButton radioButton3 = this.f7932d;
        if (radioButton3 == null) {
            m.u("rbPackagename");
            radioButton3 = null;
        }
        aVar.v(radioButton3.isChecked());
        CheckBox checkBox = this.f7934f;
        if (checkBox == null) {
            m.u("cbVersioncode");
            checkBox = null;
        }
        aVar.w(checkBox.isChecked());
        RadioButton radioButton4 = this.f7933e;
        if (radioButton4 == null) {
            m.u("rbXapkExtension");
        } else {
            radioButton2 = radioButton4;
        }
        if (radioButton2.isChecked()) {
            str = ".xapk";
        } else {
            str = ".apks";
        }
        aVar.x(str);
    }

    /* access modifiers changed from: private */
    public static final void o0(r rVar, ActivityResult activityResult) {
        Uri uri;
        m.e(rVar, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Integer num = null;
            if (data != null) {
                uri = data.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                Intent data2 = activityResult.getData();
                if (data2 != null) {
                    num = Integer.valueOf(data2.getFlags());
                }
                if (num != null) {
                    num = Integer.valueOf(num.intValue() & 3);
                }
                ContentResolver contentResolver = rVar.getContentResolver();
                m.b(num);
                contentResolver.takePersistableUriPermission(uri, num.intValue());
                if (new C1612h().q(uri)) {
                    rVar.Z();
                } else {
                    rVar.a0();
                }
            } else {
                rVar.Y();
            }
        }
    }

    private final void r0(ActivityResult activityResult) {
        String str;
        Boolean bool;
        Uri uri;
        Boolean bool2;
        String str2;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            TextView textView = null;
            if (data == null || (extras3 = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras3.getString("path_selected");
            }
            this.f7938j = str;
            Intent data2 = activityResult.getData();
            if (data2 == null || (extras2 = data2.getExtras()) == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(extras2.getBoolean("sdcard_selected"));
            }
            this.f7937i = bool;
            Intent data3 = activityResult.getData();
            if (data3 != null) {
                uri = data3.getData();
            } else {
                uri = null;
            }
            if (this.f7938j != null) {
                String str3 = this.f7938j;
                m.b(str3);
                File file = new File(str3);
                TextView textView2 = this.f7935g;
                if (textView2 == null) {
                    m.u("tvPath");
                    textView2 = null;
                }
                textView2.setText(this.f7938j);
                if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                    TextView textView3 = this.f7936h;
                    if (textView3 == null) {
                        m.u("tvErrorPath");
                    } else {
                        textView = textView3;
                    }
                    textView.setVisibility(0);
                    return;
                }
                TextView textView4 = this.f7936h;
                if (textView4 == null) {
                    m.u("tvErrorPath");
                } else {
                    textView = textView4;
                }
                textView.setVisibility(8);
            } else if (uri != null) {
                String lastPathSegment = uri.getLastPathSegment();
                Intent data4 = activityResult.getData();
                if (data4 == null || (extras = data4.getExtras()) == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(extras.getBoolean("sdcard_selected"));
                }
                this.f7937i = bool2;
                if (lastPathSegment != null) {
                    str2 = lastPathSegment.substring(m3.m.R(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                    m.d(str2, "this as java.lang.String).substring(startIndex)");
                } else {
                    str2 = null;
                }
                this.f7938j = str2;
                if (m.a(this.f7937i, Boolean.TRUE)) {
                    TextView textView5 = this.f7935g;
                    if (textView5 == null) {
                        m.u("tvPath");
                        textView5 = null;
                    }
                    textView5.setText(getString(i.sd_card) + '/' + this.f7938j);
                } else {
                    TextView textView6 = this.f7935g;
                    if (textView6 == null) {
                        m.u("tvPath");
                        textView6 = null;
                    }
                    textView6.setText(getString(i.internal_storage) + '/' + this.f7938j);
                }
                DocumentFile fromSingleUri = DocumentFile.fromSingleUri(this, uri);
                if (fromSingleUri == null || !fromSingleUri.exists() || !fromSingleUri.isDirectory() || !fromSingleUri.canWrite()) {
                    TextView textView7 = this.f7936h;
                    if (textView7 == null) {
                        m.u("tvErrorPath");
                    } else {
                        textView = textView7;
                    }
                    textView.setVisibility(0);
                    return;
                }
                TextView textView8 = this.f7936h;
                if (textView8 == null) {
                    m.u("tvErrorPath");
                } else {
                    textView = textView8;
                }
                textView.setVisibility(8);
            } else {
                TextView textView9 = this.f7936h;
                if (textView9 == null) {
                    m.u("tvErrorPath");
                } else {
                    textView = textView9;
                }
                textView.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void s0(r rVar, ActivityResult activityResult) {
        m.e(rVar, "this$0");
        rVar.h0();
    }

    private final void t0(String str, String str2, long j4, boolean z4) {
        String str3;
        RadioButton radioButton = this.f7931c;
        TextView textView = null;
        if (radioButton == null) {
            m.u("rbAppName");
            radioButton = null;
        }
        if (radioButton.isChecked()) {
            if (str == null) {
                str = N();
            }
        } else if (str2 != null) {
            str = str2;
        } else {
            str = getPackageName();
            m.d(str, "getPackageName()");
        }
        CheckBox checkBox = this.f7934f;
        if (checkBox == null) {
            m.u("cbVersioncode");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            if (j4 > -1) {
                str = str + '_' + j4;
            } else {
                str = str + '_' + P();
            }
        }
        if (z4) {
            RadioButton radioButton2 = this.f7933e;
            if (radioButton2 == null) {
                m.u("rbXapkExtension");
                radioButton2 = null;
            }
            if (radioButton2.isChecked()) {
                str3 = str + ".xapk";
            } else {
                str3 = str + ".apks";
            }
        } else {
            str3 = str + ".apk";
        }
        TextView textView2 = this.f7930b;
        if (textView2 == null) {
            m.u("tvResult");
        } else {
            textView = textView2;
        }
        textView.setText(str3);
    }

    /* access modifiers changed from: private */
    public static final void z(r rVar, View view) {
        m.e(rVar, "this$0");
        Intent intent = new Intent(rVar.getApplicationContext(), FileExplorerActivity.class);
        intent.putExtra("select_path", 1);
        rVar.f7942n.launch(intent);
    }

    public final void F(String str) {
        AlertDialog alertDialog = this.f7929a;
        if (alertDialog != null) {
            m.b(alertDialog);
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_accept, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_accept_msg);
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        if (str == null) {
            textView.setText(getString(i.error_unknown));
        } else {
            textView.setText(str);
        }
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C1577p(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.f7929a = builder.create();
        if (!isFinishing()) {
            AlertDialog alertDialog2 = this.f7929a;
            m.b(alertDialog2);
            Window window = alertDialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            AlertDialog alertDialog3 = this.f7929a;
            m.b(alertDialog3);
            alertDialog3.show();
        }
    }

    public final void H() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f7929a;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_accept, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(f.tv_dialog_accept_msg);
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        textView.setText(getString(i.msg_request_permissions_write_external_storage));
        TextView textView2 = (TextView) inflate.findViewById(f.tv_accept_option);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C1578q(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        this.f7929a = builder.create();
        if (!isFinishing() && (alertDialog = this.f7929a) != null) {
            alertDialog.show();
        }
    }

    public final void J() {
        try {
            if (!T()) {
                AlertDialog alertDialog = this.f7929a;
                if (alertDialog != null) {
                    m.b(alertDialog);
                    alertDialog.dismiss();
                }
                View inflate = getLayoutInflater().inflate(g.dialog_title_accept_cancel, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(f.tv_dialog_title);
                k.a aVar = k.f7778g;
                textView.setTypeface(aVar.w());
                int i4 = i.title_unknown_source_dialog;
                int i5 = i.app_name;
                textView.setText(getString(i4, new Object[]{getString(i5)}));
                TextView textView2 = (TextView) inflate.findViewById(f.tv_dialog_msg);
                textView2.setTypeface(aVar.x());
                textView2.setText(getString(i.msg_install_from_unknown_source, new Object[]{getString(i5)}));
                TextView textView3 = (TextView) inflate.findViewById(f.tv_accept_option);
                textView3.setTypeface(aVar.w());
                textView3.setOnClickListener(new C1575n(this));
                TextView textView4 = (TextView) inflate.findViewById(f.tv_cancel_option);
                textView4.setTypeface(aVar.w());
                textView4.setOnClickListener(new C1576o(this));
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(inflate);
                AlertDialog create = builder.create();
                this.f7929a = create;
                m.b(create);
                Window window = create.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                if (!isFinishing()) {
                    AlertDialog alertDialog2 = this.f7929a;
                    m.b(alertDialog2);
                    alertDialog2.show();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final AlertDialog O() {
        return this.f7929a;
    }

    public final boolean Q() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        return false;
    }

    public final boolean R() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return Q();
    }

    public final boolean S() {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    public final boolean T() {
        if (Build.VERSION.SDK_INT >= 26) {
            return getPackageManager().canRequestPackageInstalls();
        }
        if (Settings.Secure.getInt(getContentResolver(), "install_non_market_apps", 0) == 1) {
            return true;
        }
        return false;
    }

    public abstract void Y();

    public abstract void Z();

    public abstract void a0();

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (context != null) {
            context = k.f7778g.a(context);
        }
        super.attachBaseContext(context);
    }

    public abstract void b0();

    public abstract void d0();

    public final void i0() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 646);
        new P1.a(this).D(true);
    }

    public final void j0() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        intent.addFlags(195);
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        intent.putExtra("android.content.extra.FANCY", true);
        intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
        this.f7940l.launch(intent);
    }

    public final void k0() {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                this.f7941m.launch(new Intent("android.settings.SECURITY_SETTINGS"));
                return;
            }
            ActivityResultLauncher activityResultLauncher = this.f7941m;
            activityResultLauncher.launch(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
        } catch (ActivityNotFoundException e5) {
            e5.printStackTrace();
            g0();
        }
    }

    public final void l0() {
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    this.f7939k.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + getPackageName())));
                } catch (ActivityNotFoundException e5) {
                    e5.printStackTrace();
                    m0();
                }
            } else if (!Q()) {
                m0();
            }
        } else if (!Q()) {
            m0();
        }
    }

    public final void m0() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
    }

    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        m.e(strArr, "permissions");
        m.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i4, strArr, iArr);
        boolean z4 = true;
        if (i4 == 645) {
            if (iArr.length != 0) {
                z4 = false;
            }
            if (z4 || iArr[0] != 0) {
                c0();
            } else {
                e0();
            }
        } else if (i4 == 646) {
            if (iArr.length != 0) {
                z4 = false;
            }
            if (z4 || iArr[0] != 0) {
                W();
            } else {
                X();
            }
        }
    }

    public final void p0(AlertDialog alertDialog) {
        this.f7929a = alertDialog;
    }

    public final void q0(String str) {
        m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new a(this, str, (d) null), 2, (Object) null);
    }

    public final void y(String str, String str2, long j4, boolean z4) {
        CheckBox checkBox;
        Window window;
        AlertDialog alertDialog = this.f7929a;
        if (!(alertDialog == null || alertDialog == null)) {
            alertDialog.dismiss();
        }
        View inflate = getLayoutInflater().inflate(g.dialog_path, (ViewGroup) null, false);
        k.a aVar = k.f7778g;
        ((TextView) inflate.findViewById(f.tv_title_dialog_path)).setTypeface(aVar.w());
        View findViewById = inflate.findViewById(f.tv_path_dialog_path);
        m.d(findViewById, "view.findViewById(R.id.tv_path_dialog_path)");
        TextView textView = (TextView) findViewById;
        this.f7935g = textView;
        if (textView == null) {
            m.u("tvPath");
            textView = null;
        }
        textView.setTypeface(aVar.x());
        if (new P1.a(this).n()) {
            TextView textView2 = this.f7935g;
            if (textView2 == null) {
                m.u("tvPath");
                textView2 = null;
            }
            textView2.setText(getString(i.sd_card) + '/' + new P1.a(this).d());
        } else {
            TextView textView3 = this.f7935g;
            if (textView3 == null) {
                m.u("tvPath");
                textView3 = null;
            }
            textView3.setText(new P1.a(this).d());
        }
        View findViewById2 = inflate.findViewById(f.tv_error_path);
        m.d(findViewById2, "view.findViewById(R.id.tv_error_path)");
        TextView textView4 = (TextView) findViewById2;
        this.f7936h = textView4;
        if (textView4 == null) {
            m.u("tvErrorPath");
            textView4 = null;
        }
        textView4.setTypeface(aVar.x());
        ImageView imageView = (ImageView) inflate.findViewById(f.iv_browse_path);
        if (imageView != null) {
            imageView.setOnClickListener(new C1555d(this));
        }
        ((TextView) inflate.findViewById(f.tv_name_format_dialog_path)).setTypeface(aVar.x());
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(f.rg_name_format);
        View findViewById3 = inflate.findViewById(f.rb_option_appname);
        m.d(findViewById3, "view.findViewById(R.id.rb_option_appname)");
        RadioButton radioButton = (RadioButton) findViewById3;
        this.f7931c = radioButton;
        if (radioButton == null) {
            m.u("rbAppName");
            radioButton = null;
        }
        radioButton.setTypeface(aVar.x());
        View findViewById4 = inflate.findViewById(f.rb_option_packagename);
        m.d(findViewById4, "view.findViewById(R.id.rb_option_packagename)");
        RadioButton radioButton2 = (RadioButton) findViewById4;
        this.f7932d = radioButton2;
        if (radioButton2 == null) {
            m.u("rbPackagename");
            radioButton2 = null;
        }
        radioButton2.setTypeface(aVar.x());
        View findViewById5 = inflate.findViewById(f.cb_versioncode);
        m.d(findViewById5, "view.findViewById(R.id.cb_versioncode)");
        CheckBox checkBox2 = (CheckBox) findViewById5;
        this.f7934f = checkBox2;
        if (checkBox2 == null) {
            m.u("cbVersioncode");
            checkBox2 = null;
        }
        checkBox2.setTypeface(aVar.x());
        P1.a aVar2 = new P1.a(this);
        RadioButton radioButton3 = this.f7931c;
        if (radioButton3 == null) {
            m.u("rbAppName");
            radioButton3 = null;
        }
        radioButton3.setChecked(aVar2.i());
        RadioButton radioButton4 = this.f7932d;
        if (radioButton4 == null) {
            m.u("rbPackagename");
            radioButton4 = null;
        }
        radioButton4.setChecked(aVar2.j());
        CheckBox checkBox3 = this.f7934f;
        if (checkBox3 == null) {
            m.u("cbVersioncode");
            checkBox3 = null;
        }
        checkBox3.setChecked(aVar2.k());
        TextView textView5 = (TextView) inflate.findViewById(f.tv_extension_dialog_path);
        RadioGroup radioGroup2 = (RadioGroup) inflate.findViewById(f.rg_extension);
        View findViewById6 = inflate.findViewById(f.rb_xapk_extension);
        m.d(findViewById6, "view.findViewById(R.id.rb_xapk_extension)");
        this.f7933e = (RadioButton) findViewById6;
        if (z4) {
            textView5.setTypeface(aVar.x());
            RadioButton radioButton5 = this.f7933e;
            if (radioButton5 == null) {
                m.u("rbXapkExtension");
                radioButton5 = null;
            }
            radioButton5.setTypeface(aVar.x());
            RadioButton radioButton6 = this.f7933e;
            if (radioButton6 == null) {
                m.u("rbXapkExtension");
                radioButton6 = null;
            }
            radioButton6.setText(".xapk");
            View findViewById7 = inflate.findViewById(f.rb_apks_extension);
            m.d(findViewById7, "view.findViewById(R.id.rb_apks_extension)");
            RadioButton radioButton7 = (RadioButton) findViewById7;
            radioButton7.setTypeface(aVar.x());
            radioButton7.setText(".apks");
            String b5 = aVar2.b();
            RadioButton radioButton8 = this.f7933e;
            if (radioButton8 == null) {
                m.u("rbXapkExtension");
                radioButton8 = null;
            }
            radioButton8.setChecked(m3.m.p(b5, ".xapk", true));
            RadioButton radioButton9 = this.f7933e;
            if (radioButton9 == null) {
                m.u("rbXapkExtension");
                radioButton9 = null;
            }
            radioButton7.setChecked(!radioButton9.isChecked());
        } else {
            textView5.setVisibility(8);
            radioGroup2.setVisibility(8);
        }
        ((TextView) inflate.findViewById(f.tv_result_title_dialog_path)).setTypeface(aVar.x());
        View findViewById8 = inflate.findViewById(f.tv_result_dialog_path);
        m.d(findViewById8, "view.findViewById(R.id.tv_result_dialog_path)");
        TextView textView6 = (TextView) findViewById8;
        this.f7930b = textView6;
        if (textView6 == null) {
            m.u("tvResult");
            textView6 = null;
        }
        textView6.setTypeface(aVar.w());
        t0(str, str2, j4, z4);
        CheckBox checkBox4 = this.f7934f;
        if (checkBox4 == null) {
            m.u("cbVersioncode");
            checkBox = null;
        } else {
            checkBox = checkBox4;
        }
        String str3 = str;
        String str4 = str2;
        long j5 = j4;
        boolean z5 = z4;
        checkBox.setOnCheckedChangeListener(new C1557e(this, str3, str4, j5, z5));
        radioGroup.setOnCheckedChangeListener(new C1559f(this, str3, str4, j5, z5));
        radioGroup2.setOnCheckedChangeListener(new C1561g(this, str3, str4, j5, z5));
        View findViewById9 = inflate.findViewById(f.tv_ok_dialog_path);
        m.d(findViewById9, "view.findViewById(R.id.tv_ok_dialog_path)");
        TextView textView7 = (TextView) findViewById9;
        textView7.setTypeface(aVar.w());
        textView7.setOnClickListener(new C1563h(this));
        View findViewById10 = inflate.findViewById(f.tv_cancel_dialog_path);
        m.d(findViewById10, "view.findViewById(R.id.tv_cancel_dialog_path)");
        TextView textView8 = (TextView) findViewById10;
        textView8.setTypeface(aVar.w());
        textView8.setOnClickListener(new C1565i(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f7929a = create;
        if (!(create == null || (window = create.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f7929a;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
    }

    public void V() {
    }

    public void W() {
    }

    public void X() {
    }

    public void c0() {
    }

    public void e0() {
    }

    public void f0() {
    }

    public void g0() {
    }

    public void h0() {
    }
}
