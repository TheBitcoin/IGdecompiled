package O1;

import N1.f;
import N1.g;
import N1.i;
import N1.k;
import S1.j;
import T1.e;
import U1.c;
import U1.h;
import W1.C1612h;
import android.app.AlertDialog;
import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

public abstract class M0 extends r {

    /* renamed from: o  reason: collision with root package name */
    private TextView f7853o;

    /* renamed from: p  reason: collision with root package name */
    private ProgressBar f7854p;

    /* renamed from: q  reason: collision with root package name */
    private AlertDialog f7855q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f7856r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f7857s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f7858t;

    /* renamed from: u  reason: collision with root package name */
    private LinearLayout f7859u;

    /* renamed from: v  reason: collision with root package name */
    private LinearLayout.LayoutParams f7860v;

    public static final class a implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ M0 f7861a;

        a(M0 m02) {
            this.f7861a = m02;
        }

        public void a(View view, int i4) {
            this.f7861a.V0();
            k.a aVar = k.f7778g;
            h o4 = aVar.o();
            m.b(o4);
            int size = o4.g().size();
            if (size > 0 && size > i4) {
                h o5 = aVar.o();
                m.b(o5);
                Object obj = o5.g().get(i4);
                m.d(obj, "UptodownCoreApplication.…esInfoAvailable[position]");
                h o6 = aVar.o();
                m.b(o6);
                o6.k((NsdServiceInfo) obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void M0(M0 m02, e eVar) {
        m.e(m02, "this$0");
        m.e(eVar, "$fileTransferInfo");
        m02.g1(eVar);
    }

    private final void N0() {
        View inflate = View.inflate(this, g.dialog_sending_file, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(f.tv_percentage_dialog_sending);
        this.f7853o = textView;
        if (textView != null) {
            textView.setTypeface(k.f7778g.w());
        }
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(f.progressbar_dialog_sending);
        this.f7854p = progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView2 = (TextView) inflate.findViewById(f.tv_cancel_dialog_sending);
        this.f7858t = textView2;
        m.b(textView2);
        k.a aVar = k.f7778g;
        textView2.setTypeface(aVar.w());
        TextView textView3 = this.f7858t;
        if (textView3 != null) {
            textView3.setOnClickListener(new A0(this));
        }
        TextView textView4 = (TextView) inflate.findViewById(f.tv_sending_app);
        this.f7856r = textView4;
        if (textView4 != null) {
            textView4.setTypeface(aVar.x());
        }
        TextView textView5 = (TextView) inflate.findViewById(f.tv_device_to_sending);
        this.f7857s = textView5;
        if (textView5 != null) {
            textView5.setTypeface(aVar.w());
        }
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        f1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void O0(M0 m02, View view) {
        m.e(m02, "this$0");
        m02.V0();
        c r4 = k.f7778g.r();
        m.b(r4);
        r4.r();
        m02.a1();
    }

    /* access modifiers changed from: private */
    public static final void Q0(M0 m02, View view) {
        m.e(m02, "this$0");
        m02.V0();
        m02.a1();
    }

    /* access modifiers changed from: private */
    public static final void S0(M0 m02, String str, String str2) {
        m.e(m02, "this$0");
        m.e(str, "$filename");
        m02.V0();
        if (new C1612h().o(str)) {
            m02.j1(str);
            return;
        }
        m02.F(m02.getString(i.msg_file_received) + str + ' ' + str2);
    }

    /* access modifiers changed from: private */
    public static final void U0(M0 m02) {
        m.e(m02, "this$0");
        m02.V0();
        m02.m1();
    }

    /* access modifiers changed from: private */
    public final void V0() {
        LinearLayout linearLayout = this.f7859u;
        if (linearLayout == null) {
            AlertDialog alertDialog = this.f7855q;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.f7855q = null;
            return;
        }
        m.b(linearLayout);
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.f7859u;
        m.b(linearLayout2);
        linearLayout2.setVisibility(8);
    }

    private final boolean W0() {
        LinearLayout linearLayout;
        AlertDialog alertDialog = this.f7855q;
        if ((alertDialog == null || !alertDialog.isShowing()) && ((linearLayout = this.f7859u) == null || linearLayout.getVisibility() != 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void Z0(M0 m02, String str) {
        m.e(m02, "this$0");
        m.e(str, "$msg");
        m02.V0();
        m02.F(str);
    }

    /* access modifiers changed from: private */
    public static final void c1(M0 m02, NsdServiceInfo nsdServiceInfo) {
        m.e(m02, "this$0");
        m.e(nsdServiceInfo, "$nsdServiceInfo");
        StringBuilder sb = new StringBuilder();
        sb.append(m02.getString(i.msg_connected_to_service));
        h.a aVar = h.f8425h;
        String serviceName = nsdServiceInfo.getServiceName();
        m.d(serviceName, "nsdServiceInfo.serviceName");
        sb.append(aVar.c(serviceName));
        m02.q0(sb.toString());
    }

    /* access modifiers changed from: private */
    public static final void e1(M0 m02, String str) {
        m.e(m02, "this$0");
        m02.V0();
        m02.F(str);
        m02.a1();
    }

    private final void f1(View view) {
        Window window;
        AlertDialog alertDialog;
        LinearLayout linearLayout = this.f7859u;
        if (linearLayout == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);
            builder.setCancelable(false);
            AlertDialog create = builder.create();
            this.f7855q = create;
            if (create != null) {
                window = create.getWindow();
            } else {
                window = null;
            }
            m.b(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (!isFinishing() && (alertDialog = this.f7855q) != null) {
                alertDialog.show();
                return;
            }
            return;
        }
        m.b(linearLayout);
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = this.f7859u;
        m.b(linearLayout2);
        linearLayout2.addView(view, this.f7860v);
        LinearLayout linearLayout3 = this.f7859u;
        m.b(linearLayout3);
        linearLayout3.setVisibility(0);
    }

    private final void g1(e eVar) {
        V0();
        View inflate = View.inflate(this, g.dialog_confirm_receive, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_msg_confirm);
        m.d(findViewById, "view.findViewById(R.id.tv_msg_confirm)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        F f4 = F.f20971a;
        String string = getString(i.msg_confirm_receive_file);
        m.d(string, "getString(R.string.msg_confirm_receive_file)");
        String format = String.format(string, Arrays.copyOf(new Object[]{eVar.f(), eVar.e()}, 2));
        m.d(format, "format(format, *args)");
        textView.setText(format);
        View findViewById2 = inflate.findViewById(f.tv_confirm_receive);
        m.d(findViewById2, "view.findViewById(R.id.tv_confirm_receive)");
        TextView textView2 = (TextView) findViewById2;
        textView2.setTypeface(aVar.x());
        textView2.setOnClickListener(new y0(this, eVar));
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        m.d(findViewById3, "view.findViewById(R.id.tv_cancel)");
        TextView textView3 = (TextView) findViewById3;
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new z0(this));
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        f1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void h1(M0 m02, e eVar, View view) {
        m.e(m02, "this$0");
        m.e(eVar, "$fileTransferInfo");
        m02.V0();
        m02.o1(eVar.e());
        c r4 = k.f7778g.r();
        m.b(r4);
        r4.o(true);
    }

    /* access modifiers changed from: private */
    public static final void i1(M0 m02, View view) {
        m.e(m02, "this$0");
        m02.V0();
        c r4 = k.f7778g.r();
        m.b(r4);
        r4.o(false);
        m02.a1();
    }

    private final void j1(String str) {
        V0();
        View inflate = View.inflate(this, g.dialog_receiving_finished, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_receiving_finished);
        m.d(findViewById, "view.findViewById(R.id.tv_receiving_finished)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView.setText(str);
        View findViewById2 = inflate.findViewById(f.tv_install);
        m.d(findViewById2, "view.findViewById(R.id.tv_install)");
        TextView textView2 = (TextView) findViewById2;
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new L0(this, str));
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        m.d(findViewById3, "view.findViewById(R.id.tv_cancel)");
        TextView textView3 = (TextView) findViewById3;
        textView3.setTypeface(aVar.w());
        textView3.setText(getString(17039370));
        textView3.setOnClickListener(new x0(this));
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        f1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void k1(M0 m02, String str, View view) {
        m.e(m02, "this$0");
        m.e(str, "$filename");
        N1.j.f(new N1.j(m02), new File(new C1612h().f(m02), str), (String) null, false, 6, (Object) null);
        m02.V0();
        m02.a1();
    }

    /* access modifiers changed from: private */
    public static final void l1(M0 m02, View view) {
        m.e(m02, "this$0");
        m02.V0();
        m02.a1();
    }

    private final void m1() {
        V0();
        View inflate = View.inflate(this, g.dialog_receiving_finished, (ViewGroup) null);
        View findViewById = inflate.findViewById(f.tv_receiving_finished);
        m.d(findViewById, "view.findViewById(R.id.tv_receiving_finished)");
        TextView textView = (TextView) findViewById;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        textView.setText(getString(i.nsd_app_sent_successfully));
        View findViewById2 = inflate.findViewById(f.tv_install);
        m.d(findViewById2, "view.findViewById(R.id.tv_install)");
        ((TextView) findViewById2).setVisibility(8);
        View findViewById3 = inflate.findViewById(f.tv_cancel);
        m.d(findViewById3, "view.findViewById(R.id.tv_cancel)");
        TextView textView2 = (TextView) findViewById3;
        textView2.setTypeface(aVar.w());
        textView2.setText(getString(17039370));
        textView2.setOnClickListener(new K0(this));
        m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        f1(inflate);
    }

    /* access modifiers changed from: private */
    public static final void n1(M0 m02, View view) {
        m.e(m02, "this$0");
        m02.V0();
        m02.a1();
    }

    private final void o1(String str) {
        TextView textView;
        N0();
        TextView textView2 = this.f7856r;
        if (textView2 != null) {
            textView2.setText(getString(i.msg_receiving));
        }
        if (str != null && (textView = this.f7857s) != null) {
            textView.setText(str);
        }
    }

    private final void p1() {
        String str;
        TextView textView;
        NsdServiceInfo e5;
        N0();
        TextView textView2 = this.f7856r;
        if (textView2 != null) {
            textView2.setText(getString(i.sending_app_to));
        }
        h o4 = k.f7778g.o();
        if (o4 == null || (e5 = o4.e()) == null) {
            str = null;
        } else {
            str = e5.getServiceName();
        }
        if (str != null && (textView = this.f7857s) != null) {
            textView.setText(h.f8425h.c(str));
        }
    }

    /* access modifiers changed from: private */
    public static final void r1(M0 m02, boolean z4) {
        m.e(m02, "this$0");
        TextView textView = m02.f7853o;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        ProgressBar progressBar = m02.f7854p;
        if (progressBar != null) {
            progressBar.setIndeterminate(z4);
        }
    }

    /* access modifiers changed from: private */
    public static final void t1(M0 m02) {
        m.e(m02, "this$0");
        m02.p1();
        ProgressBar progressBar = m02.f7854p;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
    }

    /* access modifiers changed from: private */
    public static final void v1(M0 m02, int i4) {
        m.e(m02, "this$0");
        ProgressBar progressBar = m02.f7854p;
        if (progressBar != null) {
            progressBar.setProgress(i4);
        }
        TextView textView = m02.f7853o;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append('%');
            textView.setText(sb.toString());
        }
    }

    public final void L0(e eVar) {
        m.e(eVar, "fileTransferInfo");
        runOnUiThread(new J0(this, eVar));
    }

    public final void P0() {
        Integer num;
        ArrayList g4;
        k.a aVar = k.f7778g;
        h o4 = aVar.o();
        if (o4 == null || (g4 = o4.g()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(g4.size());
        }
        m.b(num);
        if (num.intValue() > 0) {
            a aVar2 = new a(this);
            View inflate = View.inflate(this, g.devices_available_nsd, (ViewGroup) null);
            h o5 = aVar.o();
            m.b(o5);
            Q1.a aVar3 = new Q1.a(o5.g(), aVar2);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(f.rv_devices);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
            }
            recyclerView.setAdapter(aVar3);
            View findViewById = inflate.findViewById(f.tv_cancel);
            m.d(findViewById, "view.findViewById(R.id.tv_cancel)");
            TextView textView = (TextView) findViewById;
            textView.setTypeface(aVar.w());
            textView.setOnClickListener(new B0(this));
            m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            f1(inflate);
            return;
        }
        F(getString(i.nsd_no_devices_available));
    }

    public final void R0(String str, String str2) {
        m.e(str, "filename");
        runOnUiThread(new H0(this, str, str2));
    }

    public final void T0() {
        runOnUiThread(new E0(this));
        k.f7778g.b();
    }

    public final void Y0(String str) {
        m.e(str, NotificationCompat.CATEGORY_MESSAGE);
        runOnUiThread(new D0(this, str));
    }

    public abstract void a1();

    public void b1(NsdServiceInfo nsdServiceInfo) {
        m.e(nsdServiceInfo, "nsdServiceInfo");
        runOnUiThread(new C0(this, nsdServiceInfo));
    }

    public final void d1(String str) {
        runOnUiThread(new G0(this, str));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        h o4;
        super.onResume();
        k.a aVar = k.f7778g;
        c r4 = aVar.r();
        if (r4 != null && !r4.j()) {
            Application application = getApplication();
            m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
            if (!((k) application).M().get() && (o4 = aVar.o()) != null) {
                o4.d();
            }
        }
        if (!W0()) {
            return;
        }
        if (aVar.s()) {
            aVar.L(false);
            T0();
        } else if (aVar.k() != null) {
            String k4 = aVar.k();
            m.b(k4);
            R0(k4, aVar.l());
            aVar.D((String) null);
            aVar.E((String) null);
        } else if (aVar.u() != null) {
            d1(aVar.u());
            aVar.N((String) null);
        } else if (aVar.t() != null) {
            String t4 = aVar.t();
            m.b(t4);
            Y0(t4);
            aVar.M((String) null);
        }
    }

    public final void q1(boolean z4) {
        runOnUiThread(new I0(this, z4));
    }

    public final void s1() {
        runOnUiThread(new w0(this));
    }

    public final void u1(int i4) {
        runOnUiThread(new F0(this, i4));
    }

    public void X0() {
    }
}
