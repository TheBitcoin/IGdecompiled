package x2;

import N1.k;
import T1.c;
import W1.C1612h;
import W1.G;
import W1.i;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import f2.C2020k;
import g2.C2060s;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

/* renamed from: x2.t  reason: case insensitive filesystem */
public final class C2394t extends C2381m {

    /* renamed from: b  reason: collision with root package name */
    private final C2020k f22485b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f22486c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22487d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22488e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22489f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22490g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f22491h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f22492i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f22493j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f22494k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f22495l;

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f22496m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2394t(View view, C2020k kVar) {
        super(view);
        m.e(view, "itemView");
        this.f22485b = kVar;
        View findViewById = view.findViewById(R.id.rl_download_item);
        m.d(findViewById, "findViewById(...)");
        this.f22486c = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_download_item);
        m.d(findViewById2, "findViewById(...)");
        this.f22487d = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_version_download_item);
        m.d(findViewById3, "findViewById(...)");
        this.f22488e = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_size_download_item);
        m.d(findViewById4, "findViewById(...)");
        this.f22489f = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_date_download_item);
        m.d(findViewById5, "findViewById(...)");
        this.f22490g = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.pb_progress_download_item);
        m.d(findViewById6, "findViewById(...)");
        this.f22491h = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_cancel_download_item);
        m.d(findViewById7, "findViewById(...)");
        this.f22492i = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.iv_icon_download_item);
        m.d(findViewById8, "findViewById(...)");
        this.f22493j = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_info_download_item);
        m.d(findViewById9, "findViewById(...)");
        this.f22494k = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.iv_resume_download_item);
        m.d(findViewById10, "findViewById(...)");
        this.f22495l = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.rl_container_options_download_item);
        m.d(findViewById11, "findViewById(...)");
        this.f22496m = (RelativeLayout) findViewById11;
        view.setOnClickListener(new C2387p(this));
        view.setOnLongClickListener(new C2389q(this));
        TextView textView = this.f22487d;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        this.f22488e.setTypeface(aVar.x());
        this.f22489f.setTypeface(aVar.w());
        this.f22490g.setTypeface(aVar.x());
        this.f22494k.setTypeface(aVar.w());
        this.f22492i.setOnClickListener(new r(this));
        this.f22495l.setOnClickListener(new C2392s(this));
    }

    /* access modifiers changed from: private */
    public static final void k(C2394t tVar, View view) {
        int bindingAdapterPosition;
        if (tVar.f22485b != null && (bindingAdapterPosition = tVar.getBindingAdapterPosition()) != -1) {
            tVar.f22485b.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean l(C2394t tVar, View view) {
        int bindingAdapterPosition;
        if (tVar.f22485b == null || (bindingAdapterPosition = tVar.getBindingAdapterPosition()) == -1) {
            return false;
        }
        tVar.f22485b.c(bindingAdapterPosition);
        return false;
    }

    /* access modifiers changed from: private */
    public static final void m(C2394t tVar, View view) {
        C2020k kVar;
        int bindingAdapterPosition = tVar.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1 && (kVar = tVar.f22485b) != null) {
            kVar.b(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void n(C2394t tVar, View view) {
        C2020k kVar;
        int bindingAdapterPosition = tVar.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1 && (kVar = tVar.f22485b) != null) {
            kVar.d(bindingAdapterPosition);
        }
    }

    public final void o(C2060s sVar, boolean z4, boolean z5, boolean z6) {
        C2060s sVar2 = sVar;
        m.e(sVar2, "download");
        this.f22493j.setPadding(0, 0, 0, 0);
        String D4 = sVar2.D();
        if (D4 != null && D4.length() != 0) {
            w l4 = s.h().l(sVar2.D());
            UptodownApp.a aVar = UptodownApp.f17422D;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            l4.n(aVar.i0(context)).i(this.f22493j);
        } else if (sVar2.p() != null) {
            this.f22493j.setImageDrawable(sVar2.p());
        } else if (sVar2.o().size() == 1) {
            String a5 = ((C2060s.c) sVar2.o().get(0)).a();
            m.b(a5);
            if (m3.m.o(a5, ".apk", false, 2, (Object) null)) {
                C1612h hVar = new C1612h();
                Context context2 = this.itemView.getContext();
                m.d(context2, "getContext(...)");
                String a6 = ((C2060s.c) sVar2.o().get(0)).a();
                m.b(a6);
                if (hVar.h(context2, a6) != null) {
                    this.f22493j.setImageDrawable(sVar2.p());
                } else {
                    this.f22493j.setImageResource(R.drawable.core_vector_apk);
                }
            } else {
                G.a aVar2 = G.f8470b;
                String a7 = ((C2060s.c) sVar2.o().get(0)).a();
                m.b(a7);
                if (aVar2.a(a7)) {
                    this.f22493j.setImageResource(R.drawable.core_vector_xapk);
                } else {
                    this.f22493j.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_file));
                }
            }
        } else {
            this.f22493j.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_vector_file));
        }
        if (sVar2.o().size() != 1 || ((C2060s.c) sVar2.o().get(0)).a() == null) {
            this.f22487d.setText(sVar2.i());
        } else {
            TextView textView = this.f22487d;
            String a8 = ((C2060s.c) sVar2.o().get(0)).a();
            m.b(a8);
            textView.setText(new File(a8).getName());
        }
        if (sVar2.E() > 0) {
            this.f22488e.setText(String.valueOf(sVar2.E()));
        } else {
            this.f22488e.setVisibility(4);
        }
        this.f22495l.setVisibility(8);
        if (!sVar2.f()) {
            TextView textView2 = this.f22489f;
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(sVar2.x())}, 1));
            m.d(format, "format(...)");
            textView2.setText(format);
            this.f22490g.setVisibility(8);
            this.f22491h.setProgress(sVar2.x());
            this.f22494k.setText("");
            this.f22494k.setVisibility(8);
            this.f22496m.setVisibility(0);
            this.f22492i.setVisibility(0);
            e(this.f22491h, this.f22493j);
        } else {
            String a9 = ((C2060s.c) sVar2.o().get(0)).a();
            m.b(a9);
            File file = new File(a9);
            long lastModified = file.lastModified();
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
            this.f22490g.setVisibility(0);
            if (sVar2.L() || z6) {
                this.f22491h.setIndeterminate(true);
                this.f22490g.setVisibility(8);
                this.f22489f.setText("");
                this.f22494k.setText(this.itemView.getContext().getString(R.string.installing));
                this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.download_installed_status));
                this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_installed));
                this.f22496m.setVisibility(8);
                e(this.f22491h, this.f22493j);
            } else {
                k.a aVar3 = k.f7778g;
                if (aVar3.j() != null) {
                    String a10 = ((C2060s.c) sVar2.o().get(0)).a();
                    c j4 = aVar3.j();
                    m.b(j4);
                    if (m3.m.p(a10, j4.a(), true)) {
                        this.f22490g.setText(dateTimeInstance.format(new Date(lastModified)));
                        this.f22489f.setText(new i().c(file.length()));
                        ProgressBar progressBar = this.f22491h;
                        c j5 = aVar3.j();
                        m.b(j5);
                        progressBar.setProgress(j5.b());
                        TextView textView3 = this.f22494k;
                        Context context3 = this.itemView.getContext();
                        c j6 = aVar3.j();
                        m.b(j6);
                        textView3.setText(context3.getString(R.string.unzipping_status, new Object[]{Integer.valueOf(j6.b())}));
                        this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.download_installed_status));
                        this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_installed));
                        this.f22496m.setVisibility(8);
                        e(this.f22491h, this.f22493j);
                    }
                }
                this.f22490g.setText(dateTimeInstance.format(new Date(lastModified)));
                this.f22489f.setText(new i().c(file.length()));
                TextView textView4 = this.f22489f;
                i iVar = new i();
                long length = file.length();
                Context context4 = this.itemView.getContext();
                m.d(context4, "getContext(...)");
                textView4.setText(iVar.d(length, context4));
                this.f22494k.setText(this.itemView.getContext().getString(R.string.option_button_install));
                this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
                this.f22494k.setVisibility(0);
                this.f22496m.setVisibility(8);
                c(this.f22491h, this.f22493j);
            }
        }
        if (sVar2.G() > -1 && sVar2.F() > -1) {
            this.f22494k.setVisibility(0);
            this.f22496m.setVisibility(8);
            this.f22492i.setVisibility(8);
            if (sVar2.G() > sVar2.F()) {
                this.f22494k.setText(this.itemView.getContext().getString(R.string.status_download_oldversion));
                this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_status_download_outdate));
            } else if (sVar2.G() < sVar2.F()) {
                this.f22494k.setText(this.itemView.getContext().getString(R.string.action_update));
                this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
            } else {
                this.f22494k.setText(this.itemView.getContext().getString(R.string.status_download_installed));
                this.f22494k.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.main_blue));
                this.f22494k.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_stroke_blue_primary));
            }
        }
        if (!z4) {
            this.f22486c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        } else if (z5) {
            this.f22486c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_selected_item));
        } else {
            this.f22486c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        }
    }

    public final void p(C2060s sVar, boolean z4, boolean z5) {
        boolean z6;
        m.e(sVar, "download");
        e(this.f22491h, this.f22493j);
        String D4 = sVar.D();
        if (!(D4 == null || D4.length() == 0)) {
            w l4 = s.h().l(sVar.D());
            UptodownApp.a aVar = UptodownApp.f17422D;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            l4.n(aVar.i0(context)).i(this.f22493j);
        }
        String i4 = sVar.i();
        if (i4 == null) {
            i4 = sVar.w() + sVar.E();
        }
        this.f22487d.setText(i4);
        if (sVar.E() > 0) {
            this.f22488e.setText(String.valueOf(sVar.E()));
        } else {
            this.f22488e.setVisibility(4);
        }
        if (sVar.z() == 0) {
            this.f22489f.setVisibility(8);
        } else {
            this.f22489f.setVisibility(0);
            TextView textView = this.f22489f;
            F f4 = F.f20971a;
            i iVar = new i();
            long y4 = sVar.y();
            Context context2 = this.itemView.getContext();
            m.d(context2, "getContext(...)");
            String d5 = iVar.d(y4, context2);
            i iVar2 = new i();
            long z7 = sVar.z();
            Context context3 = this.itemView.getContext();
            m.d(context3, "getContext(...)");
            String format = String.format("%s/%s", Arrays.copyOf(new Object[]{d5, iVar2.d(z7, context3)}, 2));
            m.d(format, "format(...)");
            textView.setText(format);
        }
        this.f22496m.setVisibility(0);
        this.f22492i.setVisibility(0);
        this.f22495l.setVisibility(8);
        this.f22494k.setVisibility(8);
        int x4 = sVar.x();
        if (1 > x4 || x4 >= 100) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z6) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            Context context4 = this.itemView.getContext();
            m.d(context4, "getContext(...)");
            if (!aVar2.T("downloadApkWorker", context4) || !DownloadWorker.f19459d.k(sVar.h(), sVar.E())) {
                z6 = false;
            } else {
                z6 = true;
            }
        }
        TextView textView2 = this.f22490g;
        F f5 = F.f20971a;
        String format2 = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(sVar.x())}, 1));
        m.d(format2, "format(...)");
        textView2.setText(format2);
        this.f22490g.setVisibility(0);
        if (z6) {
            this.f22491h.setIndeterminate(false);
            this.f22491h.setProgress(sVar.x());
            if (DownloadWorker.f19459d.h()) {
                this.f22492i.setVisibility(8);
                this.f22495l.setVisibility(0);
            } else {
                this.f22492i.setVisibility(0);
                this.f22495l.setVisibility(8);
            }
        } else {
            this.f22491h.setIndeterminate(true);
        }
        if (!z4) {
            return;
        }
        if (z5) {
            this.f22486c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_selected_item));
        } else {
            this.f22486c.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.core_ripple_bg_card));
        }
    }
}
