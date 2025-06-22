package com.uptodown.core.activities;

import N1.j;
import N1.k;
import O1.C1582v;
import O1.C1583w;
import O1.C1584x;
import O1.C1585y;
import O1.C1586z;
import O1.M0;
import Q1.b;
import R2.n;
import R2.s;
import S1.c;
import S1.e;
import S1.f;
import S1.g;
import S1.i;
import S2.C1601o;
import U1.h;
import U2.a;
import V2.d;
import W1.C1612h;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.C1001s0;

public final class FileExplorerActivity extends M0 {

    /* renamed from: y0  reason: collision with root package name */
    public static final C1849a f18964y0 = new C1849a((C2103g) null);

    /* renamed from: A  reason: collision with root package name */
    private LinearLayout f18965A;

    /* renamed from: B  reason: collision with root package name */
    private LinearLayout f18966B;

    /* renamed from: C  reason: collision with root package name */
    private HorizontalScrollView f18967C;

    /* renamed from: D  reason: collision with root package name */
    private TextView f18968D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public TextView f18969E;

    /* renamed from: F  reason: collision with root package name */
    private TextView f18970F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public SearchView f18971G;

    /* renamed from: H  reason: collision with root package name */
    private ImageView f18972H;

    /* renamed from: I  reason: collision with root package name */
    private RelativeLayout f18973I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public RadioButton f18974J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public RadioButton f18975K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public RadioButton f18976L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public AlertDialog f18977M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public Toolbar f18978N;

    /* renamed from: O  reason: collision with root package name */
    private TextView f18979O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public b f18980P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public ArrayList f18981Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public ArrayList f18982R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public DocumentFile f18983S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public ArrayList f18984T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public ArrayList f18985U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public ArrayList f18986V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public File f18987W;

    /* renamed from: X  reason: collision with root package name */
    private boolean f18988X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public boolean f18989Y;

    /* renamed from: Z  reason: collision with root package name */
    private Object f18990Z;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public ArrayList f18991m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f18992n0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f18993o0;

    /* renamed from: p0  reason: collision with root package name */
    private TabLayout f18994p0;

    /* renamed from: q0  reason: collision with root package name */
    private TextView f18995q0;

    /* renamed from: r0  reason: collision with root package name */
    private Uri f18996r0;

    /* renamed from: s0  reason: collision with root package name */
    private String f18997s0;

    /* renamed from: t0  reason: collision with root package name */
    private C f18998t0 = new C(this);

    /* renamed from: u0  reason: collision with root package name */
    private final C1854f f18999u0 = new C1854f(this);

    /* renamed from: v0  reason: collision with root package name */
    private final G f19000v0 = new G(this);

    /* renamed from: w  reason: collision with root package name */
    private TextView f19001w;

    /* renamed from: w0  reason: collision with root package name */
    private final E f19002w0 = new E(this);
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public RecyclerView f19003x;

    /* renamed from: x0  reason: collision with root package name */
    private ActivityResultLauncher f19004x0;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f19005y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public LinearLayout f19006z;

    public static final class A implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19007a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f19008b;

        A(FileExplorerActivity fileExplorerActivity, File file) {
            this.f19007a = fileExplorerActivity;
            this.f19008b = file;
        }

        public void a() {
            j.f(new j(this.f19007a), this.f19008b, (String) null, false, 6, (Object) null);
        }
    }

    public static final class B implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19009a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f19010b;

        B(FileExplorerActivity fileExplorerActivity, DocumentFile documentFile) {
            this.f19009a = fileExplorerActivity;
            this.f19010b = documentFile;
        }

        public void a() {
            j jVar = new j(this.f19009a);
            Uri uri = this.f19010b.getUri();
            m.d(uri, "documentFile.uri");
            j.e(jVar, uri, (String) null, false, false, 14, (Object) null);
        }
    }

    public static final class C implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19011a;

        C(FileExplorerActivity fileExplorerActivity) {
            this.f19011a = fileExplorerActivity;
        }

        public void a(Object obj, int i4) {
            m.e(obj, "item");
            b p22 = this.f19011a.f18980P;
            if (p22 != null && p22.c()) {
                b p23 = this.f19011a.f18980P;
                m.b(p23);
                p23.g(i4);
                b p24 = this.f19011a.f18980P;
                m.b(p24);
                if (!p24.b().isEmpty()) {
                    this.f19011a.M4();
                    return;
                }
                b p25 = this.f19011a.f18980P;
                m.b(p25);
                p25.h(false);
                this.f19011a.R3();
            } else if (obj instanceof File) {
                File file = (File) obj;
                if (file.isDirectory()) {
                    this.f19011a.f18987W = file;
                    this.f19011a.f18983S = null;
                    FileExplorerActivity.W3(this.f19011a, false, 1, (Object) null);
                    return;
                }
                if (this.f19011a.getIntent().getExtras() != null) {
                    Bundle extras = this.f19011a.getIntent().getExtras();
                    m.b(extras);
                    if (extras.containsKey("select_file")) {
                        Bundle extras2 = this.f19011a.getIntent().getExtras();
                        m.b(extras2);
                        if (extras2.getInt("select_file") == 1) {
                            Intent intent = new Intent();
                            if (file.isFile()) {
                                intent.putExtra("path_selected", file.getAbsolutePath());
                                intent.putExtra("sdcard_selected", this.f19011a.f18989Y);
                                this.f19011a.setResult(145, intent);
                                this.f19011a.finish();
                                return;
                            }
                            return;
                        }
                    }
                }
                C1612h hVar = new C1612h();
                String name = file.getName();
                m.d(name, "item.name");
                if (hVar.o(name)) {
                    this.f19011a.T3(file);
                    return;
                }
                String name2 = file.getName();
                m.d(name2, "item.name");
                if (m3.m.o(name2, ".zip", false, 2, (Object) null)) {
                    this.f19011a.L3(obj);
                } else {
                    this.f19011a.t4(file);
                }
            } else if (obj instanceof DocumentFile) {
                DocumentFile documentFile = (DocumentFile) obj;
                if (documentFile.isDirectory()) {
                    this.f19011a.f18983S = documentFile;
                    this.f19011a.f18987W = null;
                    FileExplorerActivity.W3(this.f19011a, false, 1, (Object) null);
                    return;
                }
                if (this.f19011a.getIntent().getExtras() != null) {
                    Bundle extras3 = this.f19011a.getIntent().getExtras();
                    m.b(extras3);
                    if (extras3.containsKey("select_file")) {
                        Bundle extras4 = this.f19011a.getIntent().getExtras();
                        m.b(extras4);
                        if (extras4.getInt("select_file") == 1) {
                            Intent intent2 = new Intent();
                            if (documentFile.isFile()) {
                                intent2.setData(documentFile.getUri());
                                intent2.putExtra("sdcard_selected", this.f19011a.f18989Y);
                                this.f19011a.setResult(145, intent2);
                                this.f19011a.finish();
                                return;
                            }
                            return;
                        }
                    }
                }
                if (documentFile.getName() != null) {
                    C1612h hVar2 = new C1612h();
                    String name3 = documentFile.getName();
                    m.b(name3);
                    if (hVar2.o(name3)) {
                        this.f19011a.S3(documentFile);
                        return;
                    }
                }
                if (documentFile.getName() != null) {
                    String name4 = documentFile.getName();
                    m.b(name4);
                    if (m3.m.o(name4, ".zip", false, 2, (Object) null)) {
                        this.f19011a.L3(obj);
                        return;
                    }
                }
                this.f19011a.s4(documentFile);
            }
        }

        public void b(Object obj, int i4) {
            m.e(obj, "item");
            if (this.f19011a.f18980P != null) {
                b p22 = this.f19011a.f18980P;
                m.b(p22);
                if (p22.c()) {
                    b p23 = this.f19011a.f18980P;
                    m.b(p23);
                    p23.g(i4);
                    b p24 = this.f19011a.f18980P;
                    m.b(p24);
                    if (p24.b().contains(obj)) {
                        this.f19011a.M4();
                        return;
                    }
                    this.f19011a.R3();
                    b p25 = this.f19011a.f18980P;
                    m.b(p25);
                    p25.h(false);
                    return;
                }
                b p26 = this.f19011a.f18980P;
                m.b(p26);
                p26.h(true);
                b p27 = this.f19011a.f18980P;
                m.b(p27);
                p27.g(i4);
                this.f19011a.M4();
            }
        }
    }

    public static final class D implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19012a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19013b;

        D(FileExplorerActivity fileExplorerActivity, String str) {
            this.f19012a = fileExplorerActivity;
            this.f19013b = str;
        }

        public void a(ArrayList arrayList) {
            m.e(arrayList, "items");
            this.f19012a.f18982R = arrayList;
            this.f19012a.f18981Q = arrayList;
            this.f19012a.f18986V = null;
            this.f19012a.f18985U = null;
            FileExplorerActivity fileExplorerActivity = this.f19012a;
            SearchView B22 = fileExplorerActivity.f18971G;
            m.b(B22);
            fileExplorerActivity.j3(B22.getQuery().toString(), this.f19013b);
        }

        public void b(ArrayList arrayList) {
            m.e(arrayList, "items");
            this.f19012a.f18986V = arrayList;
            this.f19012a.f18985U = arrayList;
            this.f19012a.f18982R = null;
            this.f19012a.f18981Q = null;
            if (this.f19012a.f18987W != null) {
                File r22 = this.f19012a.f18987W;
                m.b(r22);
                if (!r22.canRead()) {
                    ArrayList t22 = this.f19012a.f18986V;
                    m.b(t22);
                    if (t22.isEmpty()) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File r23 = this.f19012a.f18987W;
                        m.b(r23);
                        String absolutePath = r23.getAbsolutePath();
                        if (absolutePath.equals(externalStorageDirectory.getAbsolutePath() + "/Android/data")) {
                            File file = new File(this.f19012a.f18987W, this.f19012a.getPackageName());
                            if (file.exists() && file.canRead()) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new File(this.f19012a.f18987W, this.f19012a.getPackageName()));
                                this.f19012a.f18986V = arrayList2;
                                this.f19012a.f18985U = arrayList2;
                            }
                        }
                    }
                }
            }
            FileExplorerActivity fileExplorerActivity = this.f19012a;
            SearchView B22 = fileExplorerActivity.f18971G;
            m.b(B22);
            fileExplorerActivity.j3(B22.getQuery().toString(), this.f19013b);
        }
    }

    public static final class E extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19014a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        E(FileExplorerActivity fileExplorerActivity) {
            super(true);
            this.f19014a = fileExplorerActivity;
        }

        public void handleOnBackPressed() {
            b p22 = this.f19014a.f18980P;
            if (p22 != null && p22.c()) {
                b p23 = this.f19014a.f18980P;
                m.b(p23);
                p23.h(false);
                this.f19014a.R3();
            } else if (this.f19014a.f18983S != null) {
                DocumentFile s22 = this.f19014a.f18983S;
                m.b(s22);
                String name = s22.getName();
                DocumentFile s23 = this.f19014a.f18983S;
                m.b(s23);
                DocumentFile parentFile = s23.getParentFile();
                if (parentFile != null) {
                    this.f19014a.f18983S = parentFile;
                    this.f19014a.f18987W = null;
                    this.f19014a.y4();
                    this.f19014a.U3(name);
                    SearchView B22 = this.f19014a.f18971G;
                    if (B22 != null) {
                        this.f19014a.n3(B22);
                        return;
                    }
                    return;
                }
                this.f19014a.finish();
            } else if (this.f19014a.f18987W == null || m.a(this.f19014a.f18987W, Environment.getExternalStorageDirectory())) {
                this.f19014a.finish();
            } else {
                File r22 = this.f19014a.f18987W;
                m.b(r22);
                String name2 = r22.getName();
                File r23 = this.f19014a.f18987W;
                m.b(r23);
                File parentFile2 = r23.getParentFile();
                if (parentFile2 != null) {
                    this.f19014a.f18987W = parentFile2;
                    this.f19014a.f18983S = null;
                    this.f19014a.y4();
                    this.f19014a.U3(name2);
                    SearchView B23 = this.f19014a.f18971G;
                    if (B23 != null) {
                        this.f19014a.n3(B23);
                        return;
                    }
                    return;
                }
                this.f19014a.finish();
            }
        }
    }

    public static final class F implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19015a;

        F(FileExplorerActivity fileExplorerActivity) {
            this.f19015a = fileExplorerActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            if (tab == null || tab.getId() != 0) {
                this.f19015a.f18989Y = true;
                ArrayList C22 = this.f19015a.f18984T;
                m.b(C22);
                if (C22.size() > 0) {
                    this.f19015a.z4();
                    this.f19015a.l3();
                    return;
                }
                return;
            }
            this.f19015a.f18989Y = false;
            RecyclerView A22 = this.f19015a.f19003x;
            if (A22 == null) {
                m.u("rvFiles");
                A22 = null;
            }
            A22.setVisibility(0);
            LinearLayout v22 = this.f19015a.f19006z;
            if (v22 == null) {
                m.u("llPermissionExplanation");
                v22 = null;
            }
            v22.setVisibility(8);
            RecyclerView A23 = this.f19015a.f19003x;
            if (A23 == null) {
                m.u("rvFiles");
                A23 = null;
            }
            A23.setVisibility(0);
            this.f19015a.z4();
            this.f19015a.F4();
            FileExplorerActivity.W3(this.f19015a, false, 1, (Object) null);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class G implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19016a;

        G(FileExplorerActivity fileExplorerActivity) {
            this.f19016a = fileExplorerActivity;
        }

        public boolean onQueryTextChange(String str) {
            m.e(str, "newText");
            this.f19016a.j3(str, (String) null);
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            this.f19016a.j3(str, (String) null);
            return true;
        }
    }

    static final class H extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19018b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        H(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19018b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new H(this.f19018b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19017a;
            if (i4 == 0) {
                n.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f19018b;
                this.f19017a = 1;
                if (fileExplorerActivity.v4(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((H) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class I extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19019a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19020b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19021c;

        /* renamed from: d  reason: collision with root package name */
        int f19022d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        I(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(dVar);
            this.f19021c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19020b = obj;
            this.f19022d |= Integer.MIN_VALUE;
            return this.f19021c.v4(this);
        }
    }

    static final class J extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19023a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f19024b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19025c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19026a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19027b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19027b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19027b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19026a == 0) {
                    n.b(obj);
                    this.f19027b.P4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19028a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19029b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19029b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new b(this.f19029b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19028a == 0) {
                    n.b(obj);
                    this.f19029b.N4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19030a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19031b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19031b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new c(this.f19031b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19030a == 0) {
                    n.b(obj);
                    this.f19031b.O4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        J(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19025c = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            J j4 = new J(this.f19025c, dVar);
            j4.f19024b = obj;
            return j4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
            if (r12.p(r11) == r0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0073, code lost:
            if (r12.p(r11) == r0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009a, code lost:
            if (r12.p(r11) == r0) goto L_0x009c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r11.f19023a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001a:
                R2.n.b(r12)
                goto L_0x009d
            L_0x001f:
                R2.n.b(r12)
                java.lang.Object r12 = r11.f19024b
                r5 = r12
                o3.J r5 = (o3.J) r5
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                android.widget.RadioButton r12 = r12.f18974J
                kotlin.jvm.internal.m.b(r12)
                boolean r12 = r12.isChecked()
                r1 = 0
                if (r12 == 0) goto L_0x004f
                com.uptodown.core.activities.FileExplorerActivity$J$c r8 = new com.uptodown.core.activities.FileExplorerActivity$J$c
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.Q r12 = o3.C0981i.b(r5, r6, r7, r8, r9, r10)
                r11.f19023a = r4
                java.lang.Object r12 = r12.p(r11)
                if (r12 != r0) goto L_0x009d
                goto L_0x009c
            L_0x004f:
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                android.widget.RadioButton r12 = r12.f18975K
                kotlin.jvm.internal.m.b(r12)
                boolean r12 = r12.isChecked()
                if (r12 == 0) goto L_0x0076
                com.uptodown.core.activities.FileExplorerActivity$J$a r8 = new com.uptodown.core.activities.FileExplorerActivity$J$a
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.Q r12 = o3.C0981i.b(r5, r6, r7, r8, r9, r10)
                r11.f19023a = r3
                java.lang.Object r12 = r12.p(r11)
                if (r12 != r0) goto L_0x009d
                goto L_0x009c
            L_0x0076:
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                android.widget.RadioButton r12 = r12.f18976L
                kotlin.jvm.internal.m.b(r12)
                boolean r12 = r12.isChecked()
                if (r12 == 0) goto L_0x009d
                com.uptodown.core.activities.FileExplorerActivity$J$b r8 = new com.uptodown.core.activities.FileExplorerActivity$J$b
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19025c
                r8.<init>(r12, r1)
                r9 = 3
                r10 = 0
                r6 = 0
                r7 = 0
                o3.Q r12 = o3.C0981i.b(r5, r6, r7, r8, r9, r10)
                r11.f19023a = r2
                java.lang.Object r12 = r12.p(r11)
                if (r12 != r0) goto L_0x009d
            L_0x009c:
                return r0
            L_0x009d:
                R2.s r12 = R2.s.f8222a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.J.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((J) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class K extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19032a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19033b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        K(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19033b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new K(this.f19033b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19032a == 0) {
                n.b(obj);
                this.f19033b.E4();
                RelativeLayout z22 = this.f19033b.f19005y;
                if (z22 == null) {
                    m.u("rlLoading");
                    z22 = null;
                }
                z22.setVisibility(8);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((K) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class L implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((DocumentFile) obj).lastModified()), Long.valueOf(((DocumentFile) obj2).lastModified()));
        }
    }

    public static final class M implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    public static final class N implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((File) obj).lastModified()), Long.valueOf(((File) obj2).lastModified()));
        }
    }

    public static final class O implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    public static final class P implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((DocumentFile) obj2).lastModified()), Long.valueOf(((DocumentFile) obj).lastModified()));
        }
    }

    public static final class Q implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    public static final class R implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
        }
    }

    public static final class S implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    public static final class T implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String str;
            String name = ((DocumentFile) obj).getName();
            String str2 = null;
            if (name != null) {
                m.d(name, RewardPlus.NAME);
                str = name.toUpperCase(Locale.ROOT);
                m.d(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            } else {
                str = null;
            }
            String name2 = ((DocumentFile) obj2).getName();
            if (name2 != null) {
                m.d(name2, RewardPlus.NAME);
                str2 = name2.toUpperCase(Locale.ROOT);
                m.d(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            return a.a(str, str2);
        }
    }

    public static final class U implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    public static final class V implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String name = ((File) obj).getName();
            m.d(name, "it.name");
            Locale locale = Locale.ROOT;
            String upperCase = name.toUpperCase(locale);
            m.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String name2 = ((File) obj2).getName();
            m.d(name2, "it.name");
            String upperCase2 = name2.toUpperCase(locale);
            m.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return a.a(upperCase, upperCase2);
        }
    }

    public static final class W implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    public static final class X implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String str;
            String name = ((DocumentFile) obj2).getName();
            String str2 = null;
            if (name != null) {
                m.d(name, RewardPlus.NAME);
                str = name.toUpperCase(Locale.ROOT);
                m.d(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            } else {
                str = null;
            }
            String name2 = ((DocumentFile) obj).getName();
            if (name2 != null) {
                m.d(name2, RewardPlus.NAME);
                str2 = name2.toUpperCase(Locale.ROOT);
                m.d(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            return a.a(str, str2);
        }
    }

    public static final class Y implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    public static final class Z implements Comparator {
        public final int compare(Object obj, Object obj2) {
            String name = ((File) obj2).getName();
            m.d(name, "it.name");
            Locale locale = Locale.ROOT;
            String upperCase = name.toUpperCase(locale);
            m.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String name2 = ((File) obj).getName();
            m.d(name2, "it.name");
            String upperCase2 = name2.toUpperCase(locale);
            m.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return a.a(upperCase, upperCase2);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$a  reason: case insensitive filesystem */
    public static final class C1849a {
        public /* synthetic */ C1849a(C2103g gVar) {
            this();
        }

        private C1849a() {
        }
    }

    public static final class a0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b  reason: case insensitive filesystem */
    static final class C1850b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19036c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f19037d;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19038a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19039b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f19040c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f19041d;

            /* renamed from: com.uptodown.core.activities.FileExplorerActivity$b$a$a  reason: collision with other inner class name */
            static final class C0238a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f19042a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ FileExplorerActivity f19043b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f19044c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0238a(FileExplorerActivity fileExplorerActivity, String str, d dVar) {
                    super(2, dVar);
                    this.f19043b = fileExplorerActivity;
                    this.f19044c = str;
                }

                public final d create(Object obj, d dVar) {
                    return new C0238a(this.f19043b, this.f19044c, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f19042a == 0) {
                        n.b(obj);
                        RelativeLayout z22 = this.f19043b.f19005y;
                        if (z22 == null) {
                            m.u("rlLoading");
                            z22 = null;
                        }
                        z22.setVisibility(8);
                        this.f19043b.L4(this.f19044c);
                        this.f19043b.k3();
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, d dVar) {
                    return ((C0238a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, String str, String str2, d dVar) {
                super(2, dVar);
                this.f19039b = fileExplorerActivity;
                this.f19040c = str;
                this.f19041d = str2;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19039b, this.f19040c, this.f19041d, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
                if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0049;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
                return r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
                if (com.uptodown.core.activities.FileExplorerActivity.N2(r7, r6) == r0) goto L_0x0049;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = W2.b.c()
                    int r1 = r6.f19038a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L_0x001e
                    if (r1 == r3) goto L_0x001a
                    if (r1 != r2) goto L_0x0012
                    R2.n.b(r7)
                    goto L_0x004a
                L_0x0012:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L_0x001a:
                    R2.n.b(r7)
                    goto L_0x0033
                L_0x001e:
                    R2.n.b(r7)
                    com.uptodown.core.activities.FileExplorerActivity r7 = r6.f19039b
                    java.lang.String r1 = r6.f19040c
                    r7.D4(r1)
                    com.uptodown.core.activities.FileExplorerActivity r7 = r6.f19039b
                    r6.f19038a = r3
                    java.lang.Object r7 = r7.v4(r6)
                    if (r7 != r0) goto L_0x0033
                    goto L_0x0049
                L_0x0033:
                    o3.E0 r7 = o3.Y.c()
                    com.uptodown.core.activities.FileExplorerActivity$b$a$a r1 = new com.uptodown.core.activities.FileExplorerActivity$b$a$a
                    com.uptodown.core.activities.FileExplorerActivity r3 = r6.f19039b
                    java.lang.String r4 = r6.f19041d
                    r5 = 0
                    r1.<init>(r3, r4, r5)
                    r6.f19038a = r2
                    java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                    if (r7 != r0) goto L_0x004a
                L_0x0049:
                    return r0
                L_0x004a:
                    R2.s r7 = R2.s.f8222a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1850b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1850b(FileExplorerActivity fileExplorerActivity, String str, String str2, d dVar) {
            super(2, dVar);
            this.f19035b = fileExplorerActivity;
            this.f19036c = str;
            this.f19037d = str2;
        }

        public final d create(Object obj, d dVar) {
            return new C1850b(this.f19035b, this.f19036c, this.f19037d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19034a;
            if (i4 == 0) {
                n.b(obj);
                o3.G b5 = o3.Y.b();
                a aVar = new a(this.f19035b, this.f19036c, this.f19037d, (d) null);
                this.f19034a = 1;
                if (C0977g.g(b5, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1850b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class b0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((DocumentFile) obj).length()), Long.valueOf(((DocumentFile) obj2).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$c  reason: case insensitive filesystem */
    static final class C1851c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19045a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f19046b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DocumentFile f19047c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f19048d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19049e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$c$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19050a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19051b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19051b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19051b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19050a == 0) {
                    n.b(obj);
                    this.f19051b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1851c(ArrayList arrayList, DocumentFile documentFile, c cVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19046b = arrayList;
            this.f19047c = documentFile;
            this.f19048d = cVar;
            this.f19049e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1851c(this.f19046b, this.f19047c, this.f19048d, this.f19049e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.h(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f19045a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                R2.n.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                R2.n.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                R2.n.b(r10)
                r10 = 1
                W1.H r3 = new W1.H
                r3.<init>()
                java.util.ArrayList r4 = r9.f19046b
                androidx.documentfile.provider.DocumentFile r5 = r9.f19047c
                S1.c r6 = r9.f19048d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f19049e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "applicationContext"
                kotlin.jvm.internal.m.d(r7, r1)
                r9.f19045a = r10
                r8 = r9
                java.lang.Object r10 = r3.h(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                o3.E0 r10 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$c$a r1 = new com.uptodown.core.activities.FileExplorerActivity$c$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f19049e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f19045a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1851c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1851c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class c0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$d  reason: case insensitive filesystem */
    static final class C1852d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19052a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f19053b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f19054c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f19055d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19056e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$d$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19057a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19058b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19058b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19058b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19057a == 0) {
                    n.b(obj);
                    this.f19058b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1852d(ArrayList arrayList, File file, c cVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19053b = arrayList;
            this.f19054c = file;
            this.f19055d = cVar;
            this.f19056e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1852d(this.f19053b, this.f19054c, this.f19055d, this.f19056e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (r7.i(r1, r4, r5, r6) == r0) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f19052a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r7)
                goto L_0x004a
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                R2.n.b(r7)
                goto L_0x0035
            L_0x001e:
                R2.n.b(r7)
                W1.H r7 = new W1.H
                r7.<init>()
                java.util.ArrayList r1 = r6.f19053b
                java.io.File r4 = r6.f19054c
                S1.c r5 = r6.f19055d
                r6.f19052a = r3
                java.lang.Object r7 = r7.i(r1, r4, r5, r6)
                if (r7 != r0) goto L_0x0035
                goto L_0x0049
            L_0x0035:
                o3.E0 r7 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$d$a r1 = new com.uptodown.core.activities.FileExplorerActivity$d$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r6.f19056e
                r4 = 0
                r1.<init>(r3, r4)
                r6.f19052a = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x004a
            L_0x0049:
                return r0
            L_0x004a:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1852d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1852d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((File) obj).length()), Long.valueOf(((File) obj2).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$e  reason: case insensitive filesystem */
    static final class C1853e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19060b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1853e(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19060b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1853e(this.f19060b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19059a;
            if (i4 == 0) {
                n.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f19060b;
                this.f19059a = 1;
                if (fileExplorerActivity.r3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1853e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$f  reason: case insensitive filesystem */
    public static final class C1854f implements S1.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19061a;

        C1854f(FileExplorerActivity fileExplorerActivity) {
            this.f19061a = fileExplorerActivity;
        }

        public void a(DocumentFile documentFile) {
            m.e(documentFile, "docFile");
        }

        public void b(Object obj, int i4, int i5, long j4) {
            m.e(obj, "file");
            if (obj instanceof File) {
                this.f19061a.v3(((File) obj).getName(), i4, i5, j4);
                return;
            }
            int i6 = i4;
            int i7 = i5;
            long j5 = j4;
            if (obj instanceof DocumentFile) {
                this.f19061a.v3(((DocumentFile) obj).getName(), i6, i7, j5);
                return;
            }
            FileExplorerActivity fileExplorerActivity = this.f19061a;
            fileExplorerActivity.v3(fileExplorerActivity.getString(N1.i.copying), i6, i7, j5);
        }

        public void c(File file) {
            m.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            m.e(documentFile, "docFile");
        }

        public void e(int i4, String str, long j4, long j5) {
            m.e(str, "currentFilename");
            if (this.f19061a.O() != null) {
                AlertDialog O4 = this.f19061a.O();
                m.b(O4);
                int i5 = N1.f.pb_dialog_copying;
                if (O4.findViewById(i5) != null) {
                    AlertDialog O5 = this.f19061a.O();
                    m.b(O5);
                    ((ProgressBar) O5.findViewById(i5)).setProgress(i4);
                    AlertDialog O6 = this.f19061a.O();
                    m.b(O6);
                    ((TextView) O6.findViewById(N1.f.tv_size_dialog_copying)).setText(this.f19061a.getString(N1.i.size_of_total_size, new Object[]{new W1.i().c(j4), new W1.i().c(j5)}));
                    AlertDialog O7 = this.f19061a.O();
                    m.b(O7);
                    ((TextView) O7.findViewById(N1.f.tv_percentage_dialog_copying)).setText(i4 + this.f19061a.getString(N1.i.percentage));
                    AlertDialog O8 = this.f19061a.O();
                    m.b(O8);
                    ((TextView) O8.findViewById(N1.f.tv_files_dialog_copying)).setText(str);
                }
            }
        }

        public void f(File file) {
            m.e(file, "file");
        }

        public void g() {
        }

        public void h(Object obj) {
            m.e(obj, "file");
        }

        public void i() {
            this.f19061a.f18991m0 = null;
            this.f19061a.R3();
            FileExplorerActivity.W3(this.f19061a, false, 1, (Object) null);
            AlertDialog O4 = this.f19061a.O();
            if (O4 != null) {
                O4.dismiss();
            }
            this.f19061a.p0((AlertDialog) null);
        }
    }

    public static final class f0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((DocumentFile) obj2).length()), Long.valueOf(((DocumentFile) obj).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$g  reason: case insensitive filesystem */
    static final class C1855g extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19062a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19063b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19064c;

        /* renamed from: d  reason: collision with root package name */
        int f19065d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1855g(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(dVar);
            this.f19064c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19063b = obj;
            this.f19065d |= Integer.MIN_VALUE;
            return this.f19064c.r3(this);
        }
    }

    public static final class g0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$h  reason: case insensitive filesystem */
    static final class C1856h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19067b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1856h(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19067b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1856h(this.f19067b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19066a == 0) {
                n.b(obj);
                if (this.f19067b.f18980P != null) {
                    FileExplorerActivity fileExplorerActivity = this.f19067b;
                    b p22 = fileExplorerActivity.f18980P;
                    m.b(p22);
                    fileExplorerActivity.f18991m0 = p22.b();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1856h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class h0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Long.valueOf(((File) obj2).length()), Long.valueOf(((File) obj).length()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$i  reason: case insensitive filesystem */
    static final class C1857i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19069b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1857i(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19069b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1857i(this.f19069b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            MenuItem menuItem;
            MenuItem menuItem2;
            MenuItem menuItem3;
            MenuItem menuItem4;
            MenuItem menuItem5;
            Menu menu;
            Menu menu2;
            Menu menu3;
            Menu menu4;
            Menu menu5;
            Menu menu6;
            W2.b.c();
            if (this.f19068a == 0) {
                n.b(obj);
                b p22 = this.f19069b.f18980P;
                m.b(p22);
                p22.h(false);
                if (this.f19069b.f18991m0 != null) {
                    ArrayList u22 = this.f19069b.f18991m0;
                    m.b(u22);
                    if (!u22.isEmpty()) {
                        Toolbar D22 = this.f19069b.f18978N;
                        MenuItem menuItem6 = null;
                        if (D22 == null || (menu6 = D22.getMenu()) == null) {
                            menuItem = null;
                        } else {
                            menuItem = menu6.findItem(N1.f.action_paste);
                        }
                        if (menuItem != null) {
                            menuItem.setVisible(true);
                        }
                        Toolbar D23 = this.f19069b.f18978N;
                        if (D23 == null || (menu5 = D23.getMenu()) == null) {
                            menuItem2 = null;
                        } else {
                            menuItem2 = menu5.findItem(N1.f.action_create);
                        }
                        if (menuItem2 != null) {
                            menuItem2.setVisible(true);
                        }
                        Toolbar D24 = this.f19069b.f18978N;
                        if (D24 == null || (menu4 = D24.getMenu()) == null) {
                            menuItem3 = null;
                        } else {
                            menuItem3 = menu4.findItem(N1.f.action_copy);
                        }
                        if (menuItem3 != null) {
                            menuItem3.setVisible(false);
                        }
                        Toolbar D25 = this.f19069b.f18978N;
                        if (D25 == null || (menu3 = D25.getMenu()) == null) {
                            menuItem4 = null;
                        } else {
                            menuItem4 = menu3.findItem(N1.f.action_compress);
                        }
                        if (menuItem4 != null) {
                            menuItem4.setVisible(false);
                        }
                        Toolbar D26 = this.f19069b.f18978N;
                        if (D26 == null || (menu2 = D26.getMenu()) == null) {
                            menuItem5 = null;
                        } else {
                            menuItem5 = menu2.findItem(N1.f.action_cut);
                        }
                        if (menuItem5 != null) {
                            menuItem5.setVisible(false);
                        }
                        Toolbar D27 = this.f19069b.f18978N;
                        if (!(D27 == null || (menu = D27.getMenu()) == null)) {
                            menuItem6 = menu.findItem(N1.f.action_delete);
                        }
                        if (menuItem6 != null) {
                            menuItem6.setVisible(false);
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1857i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class i0 implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return a.a(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j  reason: case insensitive filesystem */
    static final class C1858j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19070a;

        /* renamed from: b  reason: collision with root package name */
        int f19071b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19072c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ z f19073d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f19074e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j$a */
        static final class a extends kotlin.jvm.internal.n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19075a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity) {
                super(0);
                this.f19075a = fileExplorerActivity;
            }

            public final void invoke() {
                AlertDialog q22 = this.f19075a.f18977M;
                if (q22 != null) {
                    q22.dismiss();
                }
            }
        }

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j$b */
        static final class b extends kotlin.jvm.internal.n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19076a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(FileExplorerActivity fileExplorerActivity) {
                super(0);
                this.f19076a = fileExplorerActivity;
            }

            public final void invoke() {
                AlertDialog q22 = this.f19076a.f18977M;
                if (q22 != null) {
                    q22.dismiss();
                }
            }
        }

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$j$c */
        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19077a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19078b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19078b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new c(this.f19078b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19077a == 0) {
                    n.b(obj);
                    this.f19078b.V3(false);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1858j(FileExplorerActivity fileExplorerActivity, z zVar, String str, d dVar) {
            super(2, dVar);
            this.f19072c = fileExplorerActivity;
            this.f19073d = zVar;
            this.f19074e = str;
        }

        public final d create(Object obj, d dVar) {
            return new C1858j(this.f19072c, this.f19073d, this.f19074e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
            if (r12 == r0) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0097, code lost:
            if (r12 == r0) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
            if (o3.C0977g.g(r12, r1, r11) == r0) goto L_0x00be;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r11.f19071b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r4) goto L_0x0029
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                R2.n.b(r12)
                r8 = r11
                goto L_0x00bf
            L_0x0017:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001f:
                java.lang.Object r1 = r11.f19070a
                kotlin.jvm.internal.z r1 = (kotlin.jvm.internal.z) r1
                R2.n.b(r12)
                r8 = r11
                goto L_0x009a
            L_0x0029:
                java.lang.Object r1 = r11.f19070a
                kotlin.jvm.internal.z r1 = (kotlin.jvm.internal.z) r1
                R2.n.b(r12)
                r8 = r11
                goto L_0x0063
            L_0x0032:
                R2.n.b(r12)
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19072c
                java.io.File r12 = r12.f18987W
                if (r12 == 0) goto L_0x006c
                kotlin.jvm.internal.z r1 = r11.f19073d
                W1.g r5 = new W1.g
                r5.<init>()
                com.uptodown.core.activities.FileExplorerActivity r12 = r11.f19072c
                java.io.File r6 = r12.f18987W
                kotlin.jvm.internal.m.b(r6)
                java.lang.String r7 = r11.f19074e
                com.uptodown.core.activities.FileExplorerActivity r8 = r11.f19072c
                com.uptodown.core.activities.FileExplorerActivity$j$a r9 = new com.uptodown.core.activities.FileExplorerActivity$j$a
                r9.<init>(r8)
                r11.f19070a = r1
                r11.f19071b = r4
                r10 = r11
                java.lang.Object r12 = r5.d(r6, r7, r8, r9, r10)
                r8 = r10
                if (r12 != r0) goto L_0x0063
                goto L_0x00be
            L_0x0063:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                r1.f20985a = r12
                goto L_0x00a2
            L_0x006c:
                r8 = r11
                com.uptodown.core.activities.FileExplorerActivity r12 = r8.f19072c
                androidx.documentfile.provider.DocumentFile r12 = r12.f18983S
                if (r12 == 0) goto L_0x00a2
                kotlin.jvm.internal.z r1 = r8.f19073d
                r12 = 2
                W1.g r3 = new W1.g
                r3.<init>()
                com.uptodown.core.activities.FileExplorerActivity r4 = r8.f19072c
                androidx.documentfile.provider.DocumentFile r4 = r4.f18983S
                kotlin.jvm.internal.m.b(r4)
                java.lang.String r5 = r8.f19074e
                com.uptodown.core.activities.FileExplorerActivity r6 = r8.f19072c
                com.uptodown.core.activities.FileExplorerActivity$j$b r7 = new com.uptodown.core.activities.FileExplorerActivity$j$b
                r7.<init>(r6)
                r8.f19070a = r1
                r8.f19071b = r12
                java.lang.Object r12 = r3.d(r4, r5, r6, r7, r8)
                if (r12 != r0) goto L_0x009a
                goto L_0x00be
            L_0x009a:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                r1.f20985a = r12
            L_0x00a2:
                kotlin.jvm.internal.z r12 = r8.f19073d
                boolean r12 = r12.f20985a
                if (r12 == 0) goto L_0x00bf
                o3.E0 r12 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$j$c r1 = new com.uptodown.core.activities.FileExplorerActivity$j$c
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f19072c
                r4 = 0
                r1.<init>(r3, r4)
                r8.f19070a = r4
                r8.f19071b = r2
                java.lang.Object r12 = o3.C0977g.g(r12, r1, r11)
                if (r12 != r0) goto L_0x00bf
            L_0x00be:
                return r0
            L_0x00bf:
                R2.s r12 = R2.s.f8222a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1858j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1858j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$k  reason: case insensitive filesystem */
    static final class C1859k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19079a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19080b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1859k(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19080b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1859k(this.f19080b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19079a;
            if (i4 == 0) {
                n.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f19080b;
                this.f19079a = 1;
                if (fileExplorerActivity.y3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1859k) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$l  reason: case insensitive filesystem */
    static final class C1860l extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19081a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19083c;

        /* renamed from: d  reason: collision with root package name */
        int f19084d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1860l(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(dVar);
            this.f19083c = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19082b = obj;
            this.f19084d |= Integer.MIN_VALUE;
            return this.f19083c.y3(this);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$m  reason: case insensitive filesystem */
    static final class C1861m extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19086b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1861m(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19086b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1861m(this.f19086b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19085a == 0) {
                n.b(obj);
                if (this.f19086b.f18980P != null) {
                    FileExplorerActivity fileExplorerActivity = this.f19086b;
                    b p22 = fileExplorerActivity.f18980P;
                    m.b(p22);
                    fileExplorerActivity.f18991m0 = p22.b();
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1861m) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$n  reason: case insensitive filesystem */
    static final class C1862n extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19087a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19088b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1862n(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19088b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1862n(this.f19088b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            MenuItem menuItem;
            MenuItem menuItem2;
            MenuItem menuItem3;
            MenuItem menuItem4;
            MenuItem menuItem5;
            Menu menu;
            Menu menu2;
            Menu menu3;
            Menu menu4;
            Menu menu5;
            Menu menu6;
            W2.b.c();
            if (this.f19087a == 0) {
                n.b(obj);
                b p22 = this.f19088b.f18980P;
                m.b(p22);
                p22.h(false);
                if (this.f19088b.f18991m0 != null) {
                    ArrayList u22 = this.f19088b.f18991m0;
                    m.b(u22);
                    if (!u22.isEmpty()) {
                        Toolbar D22 = this.f19088b.f18978N;
                        MenuItem menuItem6 = null;
                        if (D22 == null || (menu6 = D22.getMenu()) == null) {
                            menuItem = null;
                        } else {
                            menuItem = menu6.findItem(N1.f.action_paste);
                        }
                        if (menuItem != null) {
                            menuItem.setVisible(true);
                        }
                        Toolbar D23 = this.f19088b.f18978N;
                        if (D23 == null || (menu5 = D23.getMenu()) == null) {
                            menuItem2 = null;
                        } else {
                            menuItem2 = menu5.findItem(N1.f.action_create);
                        }
                        if (menuItem2 != null) {
                            menuItem2.setVisible(true);
                        }
                        Toolbar D24 = this.f19088b.f18978N;
                        if (D24 == null || (menu4 = D24.getMenu()) == null) {
                            menuItem3 = null;
                        } else {
                            menuItem3 = menu4.findItem(N1.f.action_copy);
                        }
                        if (menuItem3 != null) {
                            menuItem3.setVisible(false);
                        }
                        Toolbar D25 = this.f19088b.f18978N;
                        if (D25 == null || (menu3 = D25.getMenu()) == null) {
                            menuItem4 = null;
                        } else {
                            menuItem4 = menu3.findItem(N1.f.action_compress);
                        }
                        if (menuItem4 != null) {
                            menuItem4.setVisible(false);
                        }
                        Toolbar D26 = this.f19088b.f18978N;
                        if (D26 == null || (menu2 = D26.getMenu()) == null) {
                            menuItem5 = null;
                        } else {
                            menuItem5 = menu2.findItem(N1.f.action_cut);
                        }
                        if (menuItem5 != null) {
                            menuItem5.setVisible(false);
                        }
                        Toolbar D27 = this.f19088b.f18978N;
                        if (!(D27 == null || (menu = D27.getMenu()) == null)) {
                            menuItem6 = menu.findItem(N1.f.action_delete);
                        }
                        if (menuItem6 != null) {
                            menuItem6.setVisible(false);
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1862n) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$o  reason: case insensitive filesystem */
    static final class C1863o extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19089a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f19090b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19091c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f19092d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19093e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$o$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19094a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19095b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19095b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19095b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19094a == 0) {
                    n.b(obj);
                    this.f19095b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1863o(File file, String str, e eVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19090b = file;
            this.f19091c = str;
            this.f19092d = eVar;
            this.f19093e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1863o(this.f19090b, this.f19091c, this.f19092d, this.f19093e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (o3.C0977g.g(r7, r1, r6) == r0) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (r7.m(r1, r4, r5, r6) == r0) goto L_0x0049;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f19089a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r7)
                goto L_0x004a
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                R2.n.b(r7)
                goto L_0x0035
            L_0x001e:
                R2.n.b(r7)
                W1.H r7 = new W1.H
                r7.<init>()
                java.io.File r1 = r6.f19090b
                java.lang.String r4 = r6.f19091c
                S1.e r5 = r6.f19092d
                r6.f19089a = r3
                java.lang.Object r7 = r7.m(r1, r4, r5, r6)
                if (r7 != r0) goto L_0x0035
                goto L_0x0049
            L_0x0035:
                o3.E0 r7 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$o$a r1 = new com.uptodown.core.activities.FileExplorerActivity$o$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r6.f19093e
                r4 = 0
                r1.<init>(r3, r4)
                r6.f19089a = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r1, r6)
                if (r7 != r0) goto L_0x004a
            L_0x0049:
                return r0
            L_0x004a:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1863o.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1863o) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$p  reason: case insensitive filesystem */
    static final class C1864p extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19096a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f19097b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f19098c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f19099d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19100e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$p$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19101a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19102b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19102b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19102b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19101a == 0) {
                    n.b(obj);
                    this.f19102b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1864p(File file, Uri uri, e eVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19097b = file;
            this.f19098c = uri;
            this.f19099d = eVar;
            this.f19100e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1864p(this.f19097b, this.f19098c, this.f19099d, this.f19100e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.l(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f19096a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                R2.n.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                R2.n.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                R2.n.b(r10)
                r10 = 1
                W1.H r3 = new W1.H
                r3.<init>()
                java.io.File r4 = r9.f19097b
                android.net.Uri r5 = r9.f19098c
                S1.e r6 = r9.f19099d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f19100e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "applicationContext"
                kotlin.jvm.internal.m.d(r7, r1)
                r9.f19096a = r10
                r8 = r9
                java.lang.Object r10 = r3.l(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                o3.E0 r10 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$p$a r1 = new com.uptodown.core.activities.FileExplorerActivity$p$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f19100e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f19096a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1864p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1864p) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$q  reason: case insensitive filesystem */
    static final class C1865q extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f19104b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19105c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f19106d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19107e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$q$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19108a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19109b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19109b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19109b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19108a == 0) {
                    n.b(obj);
                    this.f19109b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1865q(DocumentFile documentFile, String str, e eVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19104b = documentFile;
            this.f19105c = str;
            this.f19106d = eVar;
            this.f19107e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1865q(this.f19104b, this.f19105c, this.f19106d, this.f19107e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.k(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f19103a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                R2.n.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                R2.n.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                R2.n.b(r10)
                r10 = 1
                W1.H r3 = new W1.H
                r3.<init>()
                androidx.documentfile.provider.DocumentFile r4 = r9.f19104b
                java.lang.String r5 = r9.f19105c
                S1.e r6 = r9.f19106d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f19107e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "applicationContext"
                kotlin.jvm.internal.m.d(r7, r1)
                r9.f19103a = r10
                r8 = r9
                java.lang.Object r10 = r3.k(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                o3.E0 r10 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$q$a r1 = new com.uptodown.core.activities.FileExplorerActivity$q$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f19107e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f19103a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1865q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1865q) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$r  reason: case insensitive filesystem */
    static final class C1866r extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f19111b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Uri f19112c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f19113d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19114e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$r$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19115a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19116b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, d dVar) {
                super(2, dVar);
                this.f19116b = fileExplorerActivity;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19116b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19115a == 0) {
                    n.b(obj);
                    this.f19116b.R4();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1866r(DocumentFile documentFile, Uri uri, e eVar, FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19111b = documentFile;
            this.f19112c = uri;
            this.f19113d = eVar;
            this.f19114e = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1866r(this.f19111b, this.f19112c, this.f19113d, this.f19114e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
            if (r3.j(r4, r5, r6, r7, r8) == r0) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f19110a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                R2.n.b(r10)
                r8 = r9
                goto L_0x0059
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                R2.n.b(r10)
                r8 = r9
                goto L_0x0044
            L_0x0020:
                R2.n.b(r10)
                r10 = 1
                W1.H r3 = new W1.H
                r3.<init>()
                androidx.documentfile.provider.DocumentFile r4 = r9.f19111b
                android.net.Uri r5 = r9.f19112c
                S1.e r6 = r9.f19113d
                com.uptodown.core.activities.FileExplorerActivity r1 = r9.f19114e
                android.content.Context r7 = r1.getApplicationContext()
                java.lang.String r1 = "applicationContext"
                kotlin.jvm.internal.m.d(r7, r1)
                r9.f19110a = r10
                r8 = r9
                java.lang.Object r10 = r3.j(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L_0x0044
                goto L_0x0058
            L_0x0044:
                o3.E0 r10 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$r$a r1 = new com.uptodown.core.activities.FileExplorerActivity$r$a
                com.uptodown.core.activities.FileExplorerActivity r3 = r8.f19114e
                r4 = 0
                r1.<init>(r3, r4)
                r8.f19110a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0059
            L_0x0058:
                return r0
            L_0x0059:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1866r.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1866r) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$s  reason: case insensitive filesystem */
    static final class C1867s extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19118b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1867s(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19118b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1867s(this.f19118b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19117a;
            if (i4 == 0) {
                n.b(obj);
                FileExplorerActivity fileExplorerActivity = this.f19118b;
                this.f19117a = 1;
                if (fileExplorerActivity.E3(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1867s) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$t  reason: case insensitive filesystem */
    static final class C1868t extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19119a;

        /* renamed from: b  reason: collision with root package name */
        Object f19120b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f19121c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19122d;

        /* renamed from: e  reason: collision with root package name */
        int f19123e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1868t(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(dVar);
            this.f19122d = fileExplorerActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19121c = obj;
            this.f19123e |= Integer.MIN_VALUE;
            return this.f19122d.E3(this);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$u  reason: case insensitive filesystem */
    static final class C1869u extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19125b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1869u(FileExplorerActivity fileExplorerActivity, d dVar) {
            super(2, dVar);
            this.f19125b = fileExplorerActivity;
        }

        public final d create(Object obj, d dVar) {
            return new C1869u(this.f19125b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19124a == 0) {
                n.b(obj);
                RelativeLayout z22 = this.f19125b.f19005y;
                if (z22 == null) {
                    m.u("rlLoading");
                    z22 = null;
                }
                z22.setVisibility(0);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1869u) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$v  reason: case insensitive filesystem */
    static final class C1870v extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19126a;

        /* renamed from: b  reason: collision with root package name */
        int f19127b;

        /* renamed from: c  reason: collision with root package name */
        int f19128c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19129d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.A f19130e;

        /* renamed from: com.uptodown.core.activities.FileExplorerActivity$v$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f19131a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FileExplorerActivity f19132b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f19133c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(FileExplorerActivity fileExplorerActivity, int i4, d dVar) {
                super(2, dVar);
                this.f19132b = fileExplorerActivity;
                this.f19133c = i4;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f19132b, this.f19133c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f19131a == 0) {
                    n.b(obj);
                    b p22 = this.f19132b.f18980P;
                    m.b(p22);
                    p22.notifyItemRemoved(this.f19133c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(o3.J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1870v(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.A a5, d dVar) {
            super(2, dVar);
            this.f19129d = fileExplorerActivity;
            this.f19130e = a5;
        }

        public final d create(Object obj, d dVar) {
            return new C1870v(this.f19129d, this.f19130e, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f19128c
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x001f
                if (r1 != r3) goto L_0x0017
                int r1 = r9.f19127b
                java.lang.Object r4 = r9.f19126a
                java.util.Iterator r4 = (java.util.Iterator) r4
                R2.n.b(r10)
                goto L_0x0088
            L_0x0017:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001f:
                R2.n.b(r10)
                com.uptodown.core.activities.FileExplorerActivity r10 = r9.f19129d
                Q1.b r10 = r10.f18980P
                if (r10 == 0) goto L_0x008a
                com.uptodown.core.activities.FileExplorerActivity r10 = r9.f19129d
                Q1.b r10 = r10.f18980P
                kotlin.jvm.internal.m.b(r10)
                java.util.ArrayList r10 = r10.b()
                kotlin.jvm.internal.A r1 = r9.f19130e
                int r4 = r10.size()
                r1.f20966a = r4
                java.util.Iterator r10 = r10.iterator()
                r4 = r10
                r10 = 0
            L_0x0045:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x008a
                int r1 = r10 + 1
                java.lang.Object r5 = r4.next()
                boolean r6 = r5 instanceof java.io.File
                if (r6 == 0) goto L_0x0061
                W1.i r6 = new W1.i
                r6.<init>()
                java.io.File r5 = (java.io.File) r5
                boolean r5 = r6.a(r5)
                goto L_0x006d
            L_0x0061:
                boolean r6 = r5 instanceof androidx.documentfile.provider.DocumentFile
                if (r6 == 0) goto L_0x006c
                androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
                boolean r5 = r5.delete()
                goto L_0x006d
            L_0x006c:
                r5 = 0
            L_0x006d:
                if (r5 == 0) goto L_0x0088
                o3.E0 r5 = o3.Y.c()
                com.uptodown.core.activities.FileExplorerActivity$v$a r6 = new com.uptodown.core.activities.FileExplorerActivity$v$a
                com.uptodown.core.activities.FileExplorerActivity r7 = r9.f19129d
                r8 = 0
                r6.<init>(r7, r10, r8)
                r9.f19126a = r4
                r9.f19127b = r1
                r9.f19128c = r3
                java.lang.Object r10 = o3.C0977g.g(r5, r6, r9)
                if (r10 != r0) goto L_0x0088
                return r0
            L_0x0088:
                r10 = r1
                goto L_0x0045
            L_0x008a:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.C1870v.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1870v) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$w  reason: case insensitive filesystem */
    static final class C1871w extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19135b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.A f19136c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1871w(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.A a5, d dVar) {
            super(2, dVar);
            this.f19135b = fileExplorerActivity;
            this.f19136c = a5;
        }

        public final d create(Object obj, d dVar) {
            return new C1871w(this.f19135b, this.f19136c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19134a == 0) {
                n.b(obj);
                b p22 = this.f19135b.f18980P;
                m.b(p22);
                p22.h(false);
                RelativeLayout z22 = this.f19135b.f19005y;
                if (z22 == null) {
                    m.u("rlLoading");
                    z22 = null;
                }
                z22.setVisibility(8);
                FileExplorerActivity fileExplorerActivity = this.f19135b;
                String string = fileExplorerActivity.getString(N1.i.core_files_deleted, new Object[]{String.valueOf(this.f19136c.f20966a)});
                m.d(string, "getString(R.string.core_…ToDeleteCount.toString())");
                fileExplorerActivity.q0(string);
                this.f19135b.R3();
                this.f19135b.V3(false);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1871w) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$x  reason: case insensitive filesystem */
    public static final class C1872x implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f19137a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f19138b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f19139c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19140d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f19141e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TextView f19142f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ RelativeLayout f19143g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextView f19144h;

        C1872x(ProgressBar progressBar, TextView textView, EditText editText, FileExplorerActivity fileExplorerActivity, TextView textView2, TextView textView3, RelativeLayout relativeLayout, TextView textView4) {
            this.f19137a = progressBar;
            this.f19138b = textView;
            this.f19139c = editText;
            this.f19140d = fileExplorerActivity;
            this.f19141e = textView2;
            this.f19142f = textView3;
            this.f19143g = relativeLayout;
            this.f19144h = textView4;
        }

        public void a(String str) {
            m.e(str, "fileName");
            this.f19142f.setText(str);
            this.f19143g.setVisibility(8);
            this.f19141e.setVisibility(8);
            this.f19144h.setText(this.f19140d.getString(N1.i.close));
        }

        public void b(String str) {
            m.e(str, "filesCount");
            this.f19139c.setFocusable(false);
            this.f19139c.setFocusableInTouchMode(false);
            this.f19139c.clearFocus();
            this.f19137a.setVisibility(0);
            this.f19138b.setVisibility(0);
            this.f19138b.setText(this.f19140d.getString(N1.i.core_start_counting_value, new Object[]{str}));
            this.f19141e.setVisibility(8);
        }

        public void c(int i4, String str) {
            m.e(str, "filesCount");
            this.f19137a.setProgress(i4);
            this.f19138b.setText(str);
        }

        public void onError(String str) {
            this.f19142f.setText(str);
            this.f19137a.setVisibility(0);
            this.f19141e.setVisibility(8);
            this.f19144h.setText(this.f19140d.getString(N1.i.close));
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$y  reason: case insensitive filesystem */
    static final class C1873y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19146b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f19147c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1873y(FileExplorerActivity fileExplorerActivity, EditText editText, d dVar) {
            super(2, dVar);
            this.f19146b = fileExplorerActivity;
            this.f19147c = editText;
        }

        public final d create(Object obj, d dVar) {
            return new C1873y(this.f19146b, this.f19147c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19145a == 0) {
                n.b(obj);
                this.f19146b.w3(this.f19147c.getText().toString());
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1873y) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: com.uptodown.core.activities.FileExplorerActivity$z  reason: case insensitive filesystem */
    public static final class C1874z implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f19148a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FileExplorerActivity f19149b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f19150c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ProgressBar f19151d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ TextView f19152e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ TextView f19153f;

        C1874z(TextView textView, FileExplorerActivity fileExplorerActivity, View view, ProgressBar progressBar, TextView textView2, TextView textView3) {
            this.f19148a = textView;
            this.f19149b = fileExplorerActivity;
            this.f19150c = view;
            this.f19151d = progressBar;
            this.f19152e = textView2;
            this.f19153f = textView3;
        }

        public void a() {
            this.f19148a.setText(this.f19149b.getString(N1.i.core_decompress_dialog_error));
            this.f19151d.setIndeterminate(false);
            this.f19151d.setProgress(0);
            this.f19153f.setText(this.f19149b.getString(N1.i.close));
        }

        public void b(int i4) {
            this.f19148a.setText(this.f19149b.getString(N1.i.core_decompress_dialog_completed, new Object[]{String.valueOf(i4)}));
            this.f19151d.setIndeterminate(false);
            this.f19151d.setProgress(100);
            this.f19153f.setText(this.f19149b.getString(N1.i.close));
        }

        public void c() {
            this.f19148a.setText(this.f19149b.getString(N1.i.core_decompress_dialog_decompressing));
            ((RadioGroup) this.f19150c.findViewById(N1.f.rg_decompress_path)).setVisibility(8);
            TextView E22 = this.f19149b.f18969E;
            if (E22 == null) {
                m.u("tvSelectedPath");
                E22 = null;
            }
            E22.setVisibility(8);
            this.f19151d.setVisibility(0);
            this.f19151d.setIndeterminate(true);
            this.f19152e.setVisibility(8);
        }

        public void d(long j4) {
            TextView textView = this.f19148a;
            textView.setText(this.f19149b.getString(N1.i.core_decompress_dialog_decompressing) + ' ' + new W1.i().d(j4, this.f19149b));
        }
    }

    public FileExplorerActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1582v(this));
        m.d(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f19004x0 = registerForActivityResult;
    }

    private final C1001s0 A3(DocumentFile documentFile, String str, e eVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1865q(documentFile, str, eVar, this, (d) null), 3, (Object) null);
    }

    private final void A4() {
        Intent intent = new Intent();
        DocumentFile documentFile = this.f18983S;
        if (documentFile != null) {
            m.b(documentFile);
            if (documentFile.canWrite()) {
                DocumentFile documentFile2 = this.f18983S;
                m.b(documentFile2);
                intent.setData(documentFile2.getUri());
            } else {
                S4();
                return;
            }
        } else {
            File file = this.f18987W;
            m.b(file);
            if (file.canWrite()) {
                File file2 = this.f18987W;
                m.b(file2);
                intent.putExtra("path_selected", file2.getAbsolutePath());
            } else {
                S4();
                return;
            }
        }
        intent.putExtra("sdcard_selected", this.f18989Y);
        setResult(145, intent);
        finish();
    }

    private final C1001s0 B3(File file, Uri uri, e eVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1864p(file, uri, eVar, this, (d) null), 3, (Object) null);
    }

    private final void B4() {
        new Handler(Looper.getMainLooper()).post(new O1.B(this));
    }

    private final C1001s0 C3(File file, String str, e eVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1863o(file, str, eVar, this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void C4(FileExplorerActivity fileExplorerActivity) {
        m.e(fileExplorerActivity, "this$0");
        HorizontalScrollView horizontalScrollView = fileExplorerActivity.f18967C;
        LinearLayout linearLayout = null;
        if (horizontalScrollView == null) {
            m.u("svBreadcrumb");
            horizontalScrollView = null;
        }
        LinearLayout linearLayout2 = fileExplorerActivity.f18966B;
        if (linearLayout2 == null) {
            m.u("llBreadcrumb");
            linearLayout2 = null;
        }
        int right = linearLayout2.getRight();
        LinearLayout linearLayout3 = fileExplorerActivity.f18966B;
        if (linearLayout3 == null) {
            m.u("llBreadcrumb");
        } else {
            linearLayout = linearLayout3;
        }
        horizontalScrollView.scrollTo(right, linearLayout.getTop());
    }

    private final void D3() {
        C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1867s(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void D4(String str) {
        CharSequence charSequence;
        boolean q4 = new P1.a(this).q();
        if (str == null) {
            SearchView searchView = this.f18971G;
            if (searchView != null) {
                charSequence = searchView.getQuery();
            } else {
                charSequence = null;
            }
            str = String.valueOf(charSequence);
        }
        if (str.length() <= 0 && q4) {
            ArrayList arrayList = this.f18985U;
            if (arrayList != null) {
                this.f18986V = arrayList;
                return;
            }
            ArrayList arrayList2 = this.f18981Q;
            if (arrayList2 != null) {
                this.f18982R = arrayList2;
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.f18985U;
        if (arrayList3 != null) {
            m.b(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList3.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList3.get(i4);
                i4++;
                File file = (File) obj;
                String name = file.getName();
                m.d(name, "file.name");
                if (m3.m.B(name, str, true)) {
                    if (!q4) {
                        String name2 = file.getName();
                        m.d(name2, "file.name");
                        if (m3.m.y(name2, ".", false, 2, (Object) null)) {
                        }
                    }
                    arrayList4.add(obj);
                }
            }
            this.f18986V = arrayList4;
            return;
        }
        ArrayList arrayList5 = this.f18981Q;
        if (arrayList5 != null) {
            m.b(arrayList5);
            ArrayList arrayList6 = new ArrayList();
            int size2 = arrayList5.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList5.get(i5);
                i5++;
                DocumentFile documentFile = (DocumentFile) obj2;
                String name3 = documentFile.getName();
                m.b(name3);
                if (m3.m.B(name3, str, true)) {
                    if (!q4) {
                        String name4 = documentFile.getName();
                        m.b(name4);
                        if (m3.m.y(name4, ".", false, 2, (Object) null)) {
                        }
                    }
                    arrayList6.add(obj2);
                }
            }
            this.f18982R = arrayList6;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (o3.C0977g.g(r9, r5, r0) != r1) goto L_0x009e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E3(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.uptodown.core.activities.FileExplorerActivity.C1868t
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.core.activities.FileExplorerActivity$t r0 = (com.uptodown.core.activities.FileExplorerActivity.C1868t) r0
            int r1 = r0.f19123e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19123e = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$t r0 = new com.uptodown.core.activities.FileExplorerActivity$t
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19121c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19123e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0045
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            R2.n.b(r9)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            java.lang.Object r2 = r0.f19120b
            kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
            java.lang.Object r4 = r0.f19119a
            com.uptodown.core.activities.FileExplorerActivity r4 = (com.uptodown.core.activities.FileExplorerActivity) r4
            R2.n.b(r9)
            goto L_0x0088
        L_0x0045:
            java.lang.Object r2 = r0.f19120b
            kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
            java.lang.Object r5 = r0.f19119a
            com.uptodown.core.activities.FileExplorerActivity r5 = (com.uptodown.core.activities.FileExplorerActivity) r5
            R2.n.b(r9)
            goto L_0x0071
        L_0x0051:
            R2.n.b(r9)
            kotlin.jvm.internal.A r9 = new kotlin.jvm.internal.A
            r9.<init>()
            o3.E0 r2 = o3.Y.c()
            com.uptodown.core.activities.FileExplorerActivity$u r7 = new com.uptodown.core.activities.FileExplorerActivity$u
            r7.<init>(r8, r6)
            r0.f19119a = r8
            r0.f19120b = r9
            r0.f19123e = r5
            java.lang.Object r2 = o3.C0977g.g(r2, r7, r0)
            if (r2 != r1) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r5 = r8
            r2 = r9
        L_0x0071:
            o3.G r9 = o3.Y.b()
            com.uptodown.core.activities.FileExplorerActivity$v r7 = new com.uptodown.core.activities.FileExplorerActivity$v
            r7.<init>(r5, r2, r6)
            r0.f19119a = r5
            r0.f19120b = r2
            r0.f19123e = r4
            java.lang.Object r9 = o3.C0977g.g(r9, r7, r0)
            if (r9 != r1) goto L_0x0087
            goto L_0x009d
        L_0x0087:
            r4 = r5
        L_0x0088:
            o3.E0 r9 = o3.Y.c()
            com.uptodown.core.activities.FileExplorerActivity$w r5 = new com.uptodown.core.activities.FileExplorerActivity$w
            r5.<init>(r4, r2, r6)
            r0.f19119a = r6
            r0.f19120b = r6
            r0.f19123e = r3
            java.lang.Object r9 = o3.C0977g.g(r9, r5, r0)
            if (r9 != r1) goto L_0x009e
        L_0x009d:
            return r1
        L_0x009e:
            R2.s r9 = R2.s.f8222a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.E3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void E4() {
        String str;
        DocumentFile documentFile = this.f18983S;
        RecyclerView recyclerView = null;
        if (documentFile != null) {
            m.b(documentFile);
            String lastPathSegment = documentFile.getUri().getLastPathSegment();
            if (lastPathSegment != null) {
                str = lastPathSegment.substring(m3.m.R(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                m.d(str, "this as java.lang.String).substring(startIndex)");
            } else {
                str = "";
            }
            if (!this.f18989Y) {
                TextView textView = this.f19001w;
                if (textView == null) {
                    m.u("tvBreadCrumb");
                    textView = null;
                }
                textView.setText(getString(N1.i.internal_storage) + '/' + str);
            } else if (str.length() == 0) {
                TextView textView2 = this.f19001w;
                if (textView2 == null) {
                    m.u("tvBreadCrumb");
                    textView2 = null;
                }
                textView2.setText(getString(N1.i.sd_card));
            } else {
                h3();
            }
        } else {
            File file = this.f18987W;
            if (file != null) {
                if (m.a(file, Environment.getExternalStorageDirectory())) {
                    TextView textView3 = this.f19001w;
                    if (textView3 == null) {
                        m.u("tvBreadCrumb");
                        textView3 = null;
                    }
                    textView3.setText(getString(N1.i.internal_storage));
                } else {
                    i3();
                }
            }
        }
        if (this.f18980P == null) {
            this.f18980P = new b(this.f18998t0);
            RecyclerView recyclerView2 = this.f19003x;
            if (recyclerView2 == null) {
                m.u("rvFiles");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setAdapter(this.f18980P);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f18982R;
        if (arrayList2 != null) {
            m.b(arrayList2);
            arrayList.addAll(arrayList2);
        } else {
            ArrayList arrayList3 = this.f18986V;
            if (arrayList3 != null) {
                m.b(arrayList3);
                arrayList.addAll(arrayList3);
            }
        }
        b bVar = this.f18980P;
        m.b(bVar);
        bVar.f(arrayList);
    }

    private final void F3(Object obj) {
        ProgressBar progressBar;
        EditText editText;
        AlertDialog alertDialog;
        Object obj2 = obj;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            m.d(layoutInflater, "layoutInflater");
            View inflate = layoutInflater.inflate(N1.g.dialog_compress_files, (ViewGroup) null, false);
            k.a aVar = k.f7778g;
            ((TextView) inflate.findViewById(N1.f.tv_dialog_title_compress)).setTypeface(aVar.w());
            TextView textView = (TextView) inflate.findViewById(N1.f.tv_dialog_file_name_compress);
            textView.setTypeface(aVar.x());
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(N1.f.rl_dialog_file_name_compress);
            EditText editText2 = (EditText) inflate.findViewById(N1.f.et_dialog_file_name_compress);
            editText2.setTypeface(aVar.x());
            TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_dialog_file_name_extension);
            textView2.setTypeface(aVar.x());
            textView2.setText(".zip");
            ((TextView) inflate.findViewById(N1.f.tv_dialog_selected_files_title)).setTypeface(aVar.x());
            TextView textView3 = (TextView) inflate.findViewById(N1.f.tv_dialog_selected_files);
            textView3.setTypeface(aVar.x());
            TextView textView4 = (TextView) inflate.findViewById(N1.f.tv_progress_count_files);
            textView4.setTypeface(aVar.w());
            TextView textView5 = (TextView) inflate.findViewById(N1.f.tv_accept_option_compress);
            textView5.setTypeface(aVar.w());
            TextView textView6 = (TextView) inflate.findViewById(N1.f.tv_cancel_option_compress);
            textView6.setTypeface(aVar.w());
            ProgressBar progressBar2 = (ProgressBar) inflate.findViewById(N1.f.pb_dialog_compress);
            kotlin.jvm.internal.C c5 = new kotlin.jvm.internal.C();
            ArrayList arrayList = new ArrayList();
            c5.f20968a = arrayList;
            if (obj2 != null) {
                arrayList.add(obj2);
            } else {
                b bVar = this.f18980P;
                m.b(bVar);
                c5.f20968a = bVar.b();
            }
            ArrayList arrayList2 = new ArrayList();
            if (!((Collection) c5.f20968a).isEmpty()) {
                ArrayList arrayList3 = (ArrayList) c5.f20968a;
                int size = arrayList3.size();
                String str = "";
                editText = editText2;
                int i4 = 0;
                while (i4 < size) {
                    ProgressBar progressBar3 = progressBar2;
                    Object obj3 = arrayList3.get(i4);
                    i4++;
                    ArrayList arrayList4 = arrayList3;
                    if (obj3 instanceof File) {
                        str = str + ((File) obj3).getName() + 10;
                        arrayList2.add(obj3);
                    } else if (obj3 instanceof DocumentFile) {
                        str = str + ((DocumentFile) obj3).getName() + 10;
                    }
                    arrayList3 = arrayList4;
                    progressBar2 = progressBar3;
                }
                progressBar = progressBar2;
                textView3.setText(str);
            } else {
                editText = editText2;
                progressBar = progressBar2;
            }
            kotlin.jvm.internal.C c6 = new kotlin.jvm.internal.C();
            TextView textView7 = textView4;
            TextView textView8 = textView5;
            C1872x xVar = new C1872x(progressBar, textView7, editText, this, textView8, textView, relativeLayout, textView6);
            TextView textView9 = textView8;
            kotlin.jvm.internal.C c7 = c6;
            textView9.setOnClickListener(new O1.H(editText, c5, this, arrayList2, c7, xVar));
            textView6.setOnClickListener(new O1.I(c7, this));
            builder.setView(inflate);
            this.f18977M = builder.create();
            if (!isFinishing() && (alertDialog = this.f18977M) != null) {
                m.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f18977M;
                m.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void F4() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            this.f18987W = externalStorageDirectory;
            this.f18983S = null;
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(EditText editText, kotlin.jvm.internal.C c5, FileExplorerActivity fileExplorerActivity, ArrayList arrayList, kotlin.jvm.internal.C c6, C1872x xVar, View view) {
        int i4;
        String str;
        EditText editText2 = editText;
        kotlin.jvm.internal.C c7 = c5;
        FileExplorerActivity fileExplorerActivity2 = fileExplorerActivity;
        ArrayList arrayList2 = arrayList;
        kotlin.jvm.internal.C c8 = c6;
        C1872x xVar2 = xVar;
        m.e(c7, "$itemsToCompress");
        m.e(fileExplorerActivity2, "this$0");
        m.e(arrayList2, "$filesPath");
        m.e(c8, "$compressFilesJob");
        m.e(xVar2, "$compressListener");
        if (editText2.getText().toString().length() <= 0) {
            String string = fileExplorerActivity2.getString(N1.i.core_compress_dialog_file_name_empty);
            m.d(string, "getString(R.string.core_…s_dialog_file_name_empty)");
            fileExplorerActivity2.q0(string);
        } else if (!((Collection) c7.f20968a).isEmpty()) {
            File file = fileExplorerActivity2.f18987W;
            long j4 = 0;
            if (file != null) {
                m.b(file);
                long usableSpace = file.getUsableSpace();
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    j4 += ((File) obj).length();
                }
                if (usableSpace > j4 * ((long) 2)) {
                    StringBuilder sb = new StringBuilder();
                    File file2 = fileExplorerActivity2.f18987W;
                    if (file2 != null) {
                        str = file2.getAbsolutePath();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    sb.append('/');
                    sb.append(editText2.getText());
                    sb.append(".zip");
                    File file3 = new File(sb.toString());
                    if (!file3.exists()) {
                        k.f7778g.d(fileExplorerActivity2, editText2);
                        c8.f20968a = fileExplorerActivity2.p3(arrayList2, file3, xVar2);
                        return;
                    }
                    String string2 = fileExplorerActivity2.getString(N1.i.core_compress_dialog_file_name_already_exists, new Object[]{editText2.getText()});
                    m.d(string2, "getString(R.string.core_…_exists, etFileName.text)");
                    fileExplorerActivity2.q0(string2);
                    return;
                }
                String string3 = fileExplorerActivity2.getString(N1.i.error_not_enough_space);
                m.d(string3, "getString(R.string.error_not_enough_space)");
                fileExplorerActivity2.q0(string3);
            } else if (fileExplorerActivity2.f18983S != null) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = (ArrayList) c7.f20968a;
                int size2 = arrayList4.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj2 = arrayList4.get(i6);
                    i6++;
                    if (obj2 instanceof DocumentFile) {
                        arrayList3.add(obj2);
                    }
                }
                C1612h hVar = new C1612h();
                Context applicationContext = fileExplorerActivity2.getApplicationContext();
                m.d(applicationContext, "applicationContext");
                DocumentFile documentFile = fileExplorerActivity2.f18983S;
                m.b(documentFile);
                long l4 = hVar.l(applicationContext, documentFile);
                int size3 = arrayList3.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj3 = arrayList3.get(i7);
                    i7++;
                    j4 += ((DocumentFile) obj3).length();
                }
                if (l4 > j4 * ((long) 2)) {
                    String str2 = editText2.getText() + ".zip";
                    DocumentFile documentFile2 = fileExplorerActivity2.f18983S;
                    m.b(documentFile2);
                    DocumentFile[] listFiles = documentFile2.listFiles();
                    m.d(listFiles, "currentDirectoryDocumentFile!!.listFiles()");
                    int length = listFiles.length;
                    boolean z4 = false;
                    int i8 = 0;
                    while (i8 < length) {
                        if (m.a(listFiles[i8].getName(), str2)) {
                            i4 = 1;
                            String string4 = fileExplorerActivity2.getString(N1.i.core_compress_dialog_file_name_already_exists, new Object[]{editText2.getText()});
                            m.d(string4, "getString(\n             …                        )");
                            fileExplorerActivity2.q0(string4);
                            z4 = true;
                        } else {
                            i4 = 1;
                        }
                        i8 += i4;
                    }
                    if (!z4) {
                        k.f7778g.d(fileExplorerActivity2, editText2);
                        DocumentFile documentFile3 = fileExplorerActivity2.f18983S;
                        m.b(documentFile3);
                        DocumentFile createFile = documentFile3.createFile(new C1612h().i(str2), str2);
                        m.b(createFile);
                        c8.f20968a = fileExplorerActivity2.o3(arrayList3, createFile, xVar2);
                    }
                }
            }
        }
    }

    private final void G4() {
        int i4;
        MenuItem menuItem;
        MenuItem menuItem2;
        MenuItem menuItem3;
        Menu menu;
        Menu menu2;
        Menu menu3;
        Menu menu4;
        MenuItem menuItem4;
        MenuItem menuItem5;
        MenuItem menuItem6;
        Menu menu5;
        Menu menu6;
        Menu menu7;
        Menu menu8;
        b bVar = this.f18980P;
        if (bVar != null) {
            m.b(bVar);
            i4 = bVar.a();
        } else {
            i4 = 0;
        }
        MenuItem menuItem7 = null;
        if (i4 > 0) {
            Toolbar toolbar = this.f18978N;
            if (toolbar == null || (menu8 = toolbar.getMenu()) == null) {
                menuItem4 = null;
            } else {
                menuItem4 = menu8.findItem(N1.f.action_delete);
            }
            if (menuItem4 != null) {
                menuItem4.setEnabled(true);
            }
            Toolbar toolbar2 = this.f18978N;
            if (toolbar2 == null || (menu7 = toolbar2.getMenu()) == null) {
                menuItem5 = null;
            } else {
                menuItem5 = menu7.findItem(N1.f.action_copy);
            }
            if (menuItem5 != null) {
                menuItem5.setEnabled(true);
            }
            Toolbar toolbar3 = this.f18978N;
            if (toolbar3 == null || (menu6 = toolbar3.getMenu()) == null) {
                menuItem6 = null;
            } else {
                menuItem6 = menu6.findItem(N1.f.action_cut);
            }
            if (menuItem6 != null) {
                menuItem6.setEnabled(true);
            }
            Toolbar toolbar4 = this.f18978N;
            if (!(toolbar4 == null || (menu5 = toolbar4.getMenu()) == null)) {
                menuItem7 = menu5.findItem(N1.f.action_compress);
            }
            if (menuItem7 != null) {
                menuItem7.setEnabled(true);
            }
        } else {
            Toolbar toolbar5 = this.f18978N;
            if (toolbar5 == null || (menu4 = toolbar5.getMenu()) == null) {
                menuItem = null;
            } else {
                menuItem = menu4.findItem(N1.f.action_delete);
            }
            if (menuItem != null) {
                menuItem.setEnabled(false);
            }
            Toolbar toolbar6 = this.f18978N;
            if (toolbar6 == null || (menu3 = toolbar6.getMenu()) == null) {
                menuItem2 = null;
            } else {
                menuItem2 = menu3.findItem(N1.f.action_copy);
            }
            if (menuItem2 != null) {
                menuItem2.setEnabled(false);
            }
            Toolbar toolbar7 = this.f18978N;
            if (toolbar7 == null || (menu2 = toolbar7.getMenu()) == null) {
                menuItem3 = null;
            } else {
                menuItem3 = menu2.findItem(N1.f.action_cut);
            }
            if (menuItem3 != null) {
                menuItem3.setEnabled(false);
            }
            Toolbar toolbar8 = this.f18978N;
            if (!(toolbar8 == null || (menu = toolbar8.getMenu()) == null)) {
                menuItem7 = menu.findItem(N1.f.action_compress);
            }
            if (menuItem7 != null) {
                menuItem7.setEnabled(false);
            }
        }
        TextView textView = this.f18979O;
        if (textView != null) {
            textView.setText(getString(N1.i.core_x_items_selected, new Object[]{String.valueOf(i4)}));
        }
    }

    /* access modifiers changed from: private */
    public static final void H3(kotlin.jvm.internal.C c5, FileExplorerActivity fileExplorerActivity, View view) {
        m.e(c5, "$compressFilesJob");
        m.e(fileExplorerActivity, "this$0");
        C1001s0 s0Var = (C1001s0) c5.f20968a;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        AlertDialog alertDialog = fileExplorerActivity.f18977M;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void H4() {
        if (!this.f18988X) {
            RadioButton radioButton = this.f18976L;
            m.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_asc_on));
            RadioButton radioButton2 = this.f18975K;
            m.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_asc_off));
            RadioButton radioButton3 = this.f18974J;
            m.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f18976L;
        m.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_desc_on));
        RadioButton radioButton5 = this.f18975K;
        m.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_desc_off));
        RadioButton radioButton6 = this.f18974J;
        m.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_desc_off));
    }

    private final void I3() {
        AlertDialog alertDialog;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            m.d(layoutInflater, "layoutInflater");
            View inflate = layoutInflater.inflate(N1.g.dialog_create, (ViewGroup) null, false);
            k.a aVar = k.f7778g;
            ((TextView) inflate.findViewById(N1.f.tv_dialog_title_create)).setTypeface(aVar.w());
            ((TextView) inflate.findViewById(N1.f.tv_dialog_file_name_create)).setTypeface(aVar.x());
            EditText editText = (EditText) inflate.findViewById(N1.f.et_dialog_file_name_create);
            editText.setTypeface(aVar.x());
            TextView textView = (TextView) inflate.findViewById(N1.f.tv_accept_option_create);
            textView.setTypeface(aVar.w());
            TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_cancel_option_create);
            textView2.setTypeface(aVar.w());
            textView.setOnClickListener(new C1583w(editText, this));
            textView2.setOnClickListener(new C1584x(this));
            builder.setView(inflate);
            this.f18977M = builder.create();
            if (!isFinishing() && (alertDialog = this.f18977M) != null) {
                m.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f18977M;
                m.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    private final void I4() {
        if (!this.f18988X) {
            RadioButton radioButton = this.f18974J;
            m.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_asc_on));
            RadioButton radioButton2 = this.f18975K;
            m.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_asc_off));
            RadioButton radioButton3 = this.f18976L;
            m.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f18974J;
        m.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_desc_on));
        RadioButton radioButton5 = this.f18975K;
        m.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_desc_off));
        RadioButton radioButton6 = this.f18976L;
        m.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_desc_off));
    }

    /* access modifiers changed from: private */
    public static final void J3(EditText editText, FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        if (editText.getText().toString().length() > 0) {
            C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1873y(fileExplorerActivity, editText, (d) null), 3, (Object) null);
            return;
        }
        String string = fileExplorerActivity.getString(N1.i.core_compress_dialog_file_name_empty);
        m.d(string, "getString(R.string.core_…s_dialog_file_name_empty)");
        fileExplorerActivity.q0(string);
    }

    private final void J4() {
        if (!this.f18988X) {
            RadioButton radioButton = this.f18975K;
            m.b(radioButton);
            radioButton.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_asc_on));
            RadioButton radioButton2 = this.f18974J;
            m.b(radioButton2);
            radioButton2.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_asc_off));
            RadioButton radioButton3 = this.f18976L;
            m.b(radioButton3);
            radioButton3.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_asc_off));
            return;
        }
        RadioButton radioButton4 = this.f18975K;
        m.b(radioButton4);
        radioButton4.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_size_desc_on));
        RadioButton radioButton5 = this.f18974J;
        m.b(radioButton5);
        radioButton5.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_az_desc_off));
        RadioButton radioButton6 = this.f18976L;
        m.b(radioButton6);
        radioButton6.setBackground(ContextCompat.getDrawable(this, N1.e.core_vector_sort_date_desc_off));
    }

    /* access modifiers changed from: private */
    public static final void K3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        AlertDialog alertDialog = fileExplorerActivity.f18977M;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void K4(boolean z4) {
        LinearLayout linearLayout = null;
        if (z4) {
            TextView textView = this.f18968D;
            if (textView == null) {
                m.u("tvEmptyDirectory");
                textView = null;
            }
            textView.setText(getString(N1.i.empty_directory));
        } else {
            TextView textView2 = this.f18968D;
            if (textView2 == null) {
                m.u("tvEmptyDirectory");
                textView2 = null;
            }
            textView2.setText(getString(N1.i.no_permissions_directory));
        }
        LinearLayout linearLayout2 = this.f18965A;
        if (linearLayout2 == null) {
            m.u("llEmptyDirectory");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void L3(Object obj) {
        AlertDialog alertDialog;
        String str;
        Object obj2 = obj;
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater layoutInflater = getLayoutInflater();
            m.d(layoutInflater, "layoutInflater");
            TextView textView = null;
            View inflate = layoutInflater.inflate(N1.g.dialog_decompress_file, (ViewGroup) null, false);
            k.a aVar = k.f7778g;
            ((TextView) inflate.findViewById(N1.f.tv_dialog_title_decompress)).setTypeface(aVar.w());
            TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_dialog_file_name_decompress);
            textView2.setTypeface(aVar.x());
            RadioButton radioButton = (RadioButton) inflate.findViewById(N1.f.rb_dialog_decompress_current_path);
            radioButton.setTypeface(aVar.x());
            RadioButton radioButton2 = (RadioButton) inflate.findViewById(N1.f.rb_dialog_decompress_select_path);
            radioButton2.setTypeface(aVar.x());
            View findViewById = inflate.findViewById(N1.f.tv_dialog_decompress_selected_path);
            m.d(findViewById, "view.findViewById(R.id.t…decompress_selected_path)");
            TextView textView3 = (TextView) findViewById;
            this.f18969E = textView3;
            if (textView3 == null) {
                m.u("tvSelectedPath");
                textView3 = null;
            }
            textView3.setTypeface(aVar.x());
            kotlin.jvm.internal.C c5 = new kotlin.jvm.internal.C();
            if (obj2 instanceof File) {
                c5.f20968a = ((File) obj2).getParent();
            } else if (obj2 instanceof DocumentFile) {
                DocumentFile documentFile = this.f18983S;
                m.b(documentFile);
                String lastPathSegment = documentFile.getUri().getLastPathSegment();
                if (lastPathSegment != null) {
                    DocumentFile documentFile2 = this.f18983S;
                    m.b(documentFile2);
                    String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                    m.b(lastPathSegment2);
                    str = lastPathSegment.substring(m3.m.R(lastPathSegment2, ":", 0, false, 6, (Object) null) + 1);
                    m.d(str, "this as java.lang.String).substring(startIndex)");
                } else {
                    str = null;
                }
                c5.f20968a = getString(N1.i.sd_card) + '/' + str;
            }
            TextView textView4 = this.f18969E;
            if (textView4 == null) {
                m.u("tvSelectedPath");
                textView4 = null;
            }
            textView4.setText((CharSequence) c5.f20968a);
            this.f18997s0 = (String) c5.f20968a;
            TextView textView5 = (TextView) inflate.findViewById(N1.f.tv_accept_option_compress);
            textView5.setTypeface(aVar.w());
            TextView textView6 = (TextView) inflate.findViewById(N1.f.tv_cancel_option_decompress);
            textView6.setTypeface(aVar.w());
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(N1.f.pb_dialog_decompress);
            TextView textView7 = this.f18969E;
            if (textView7 == null) {
                m.u("tvSelectedPath");
            } else {
                textView = textView7;
            }
            textView.setOnClickListener(new O1.P(this));
            radioButton.setOnCheckedChangeListener(new O1.Q(this, c5));
            radioButton2.setOnCheckedChangeListener(new O1.S(this));
            kotlin.jvm.internal.C c6 = new kotlin.jvm.internal.C();
            View view = inflate;
            TextView textView8 = textView5;
            TextView textView9 = textView6;
            textView8.setOnClickListener(new O1.T(obj2, this, c6, new C1874z(textView2, this, view, progressBar, textView8, textView9)));
            textView9.setOnClickListener(new O1.U(c6, this));
            builder.setView(view);
            this.f18977M = builder.create();
            if (!isFinishing() && (alertDialog = this.f18977M) != null) {
                m.b(alertDialog);
                Window window = alertDialog.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog alertDialog2 = this.f18977M;
                m.b(alertDialog2);
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void L4(String str) {
        int i4 = 0;
        if (str != null) {
            ArrayList arrayList = this.f18982R;
            if (arrayList != null) {
                m.b(arrayList);
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    DocumentFile documentFile = (DocumentFile) obj;
                    if (documentFile.getName() != null && m3.m.p(documentFile.getName(), str, true)) {
                        break;
                    }
                    i4++;
                }
            } else {
                ArrayList arrayList2 = this.f18986V;
                if (arrayList2 != null) {
                    m.b(arrayList2);
                    int size2 = arrayList2.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj2 = arrayList2.get(i6);
                        i6++;
                        if (m3.m.p(((File) obj2).getName(), str, true)) {
                            break;
                        }
                        i4++;
                    }
                }
            }
        }
        RecyclerView recyclerView = this.f19003x;
        if (recyclerView == null) {
            m.u("rvFiles");
            recyclerView = null;
        }
        recyclerView.scrollToPosition(i4);
    }

    /* access modifiers changed from: private */
    public static final void M3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        Intent intent = new Intent(fileExplorerActivity.getApplicationContext(), FileExplorerActivity.class);
        intent.putExtra("select_path", 1);
        fileExplorerActivity.f19004x0.launch(intent);
    }

    /* access modifiers changed from: private */
    public final void M4() {
        MenuItem menuItem;
        MenuItem menuItem2;
        MenuItem menuItem3;
        MenuItem menuItem4;
        MenuItem menuItem5;
        Menu menu;
        Menu menu2;
        Menu menu3;
        Menu menu4;
        Menu menu5;
        Menu menu6;
        Toolbar toolbar = this.f18978N;
        MenuItem menuItem6 = null;
        if (toolbar == null || (menu6 = toolbar.getMenu()) == null) {
            menuItem = null;
        } else {
            menuItem = menu6.findItem(N1.f.action_delete);
        }
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
        Toolbar toolbar2 = this.f18978N;
        if (toolbar2 == null || (menu5 = toolbar2.getMenu()) == null) {
            menuItem2 = null;
        } else {
            menuItem2 = menu5.findItem(N1.f.action_create);
        }
        if (menuItem2 != null) {
            menuItem2.setVisible(true);
        }
        Toolbar toolbar3 = this.f18978N;
        if (toolbar3 == null || (menu4 = toolbar3.getMenu()) == null) {
            menuItem3 = null;
        } else {
            menuItem3 = menu4.findItem(N1.f.action_copy);
        }
        if (menuItem3 != null) {
            menuItem3.setVisible(true);
        }
        Toolbar toolbar4 = this.f18978N;
        if (toolbar4 == null || (menu3 = toolbar4.getMenu()) == null) {
            menuItem4 = null;
        } else {
            menuItem4 = menu3.findItem(N1.f.action_compress);
        }
        if (menuItem4 != null) {
            menuItem4.setVisible(true);
        }
        Toolbar toolbar5 = this.f18978N;
        if (toolbar5 == null || (menu2 = toolbar5.getMenu()) == null) {
            menuItem5 = null;
        } else {
            menuItem5 = menu2.findItem(N1.f.action_cut);
        }
        if (menuItem5 != null) {
            menuItem5.setVisible(true);
        }
        G4();
        ArrayList arrayList = this.f18991m0;
        if (arrayList != null) {
            m.b(arrayList);
            if (!arrayList.isEmpty()) {
                Toolbar toolbar6 = this.f18978N;
                if (!(toolbar6 == null || (menu = toolbar6.getMenu()) == null)) {
                    menuItem6 = menu.findItem(N1.f.action_paste);
                }
                if (menuItem6 != null) {
                    menuItem6.setVisible(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void N3(FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.C c5, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        m.e(c5, "$parentPath");
        if (z4) {
            TextView textView = fileExplorerActivity.f18969E;
            TextView textView2 = null;
            if (textView == null) {
                m.u("tvSelectedPath");
                textView = null;
            }
            textView.setVisibility(8);
            TextView textView3 = fileExplorerActivity.f18969E;
            if (textView3 == null) {
                m.u("tvSelectedPath");
            } else {
                textView2 = textView3;
            }
            textView2.setText((CharSequence) c5.f20968a);
        }
    }

    /* access modifiers changed from: private */
    public final void N4() {
        if (this.f18988X) {
            ArrayList arrayList = this.f18982R;
            if (arrayList != null) {
                m.b(arrayList);
                if (arrayList.size() > 1) {
                    C1601o.t(arrayList, new P());
                }
                ArrayList arrayList2 = this.f18982R;
                m.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C1601o.t(arrayList2, new Q());
                }
            }
            ArrayList arrayList3 = this.f18986V;
            if (arrayList3 != null) {
                m.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C1601o.t(arrayList3, new R());
                }
                ArrayList arrayList4 = this.f18986V;
                m.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C1601o.t(arrayList4, new S());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f18982R;
        if (arrayList5 != null) {
            m.b(arrayList5);
            if (arrayList5.size() > 1) {
                C1601o.t(arrayList5, new L());
            }
            ArrayList arrayList6 = this.f18982R;
            m.b(arrayList6);
            if (arrayList6.size() > 1) {
                C1601o.t(arrayList6, new M());
            }
        }
        ArrayList arrayList7 = this.f18986V;
        if (arrayList7 != null) {
            m.b(arrayList7);
            if (arrayList7.size() > 1) {
                C1601o.t(arrayList7, new N());
            }
            ArrayList arrayList8 = this.f18986V;
            m.b(arrayList8);
            if (arrayList8.size() > 1) {
                C1601o.t(arrayList8, new O());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        if (z4) {
            TextView textView = fileExplorerActivity.f18969E;
            if (textView == null) {
                m.u("tvSelectedPath");
                textView = null;
            }
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void O4() {
        if (this.f18988X) {
            ArrayList arrayList = this.f18982R;
            if (arrayList != null) {
                m.b(arrayList);
                if (arrayList.size() > 1) {
                    C1601o.t(arrayList, new X());
                }
                ArrayList arrayList2 = this.f18982R;
                m.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C1601o.t(arrayList2, new Y());
                }
            }
            ArrayList arrayList3 = this.f18986V;
            if (arrayList3 != null) {
                m.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C1601o.t(arrayList3, new Z());
                }
                ArrayList arrayList4 = this.f18986V;
                m.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C1601o.t(arrayList4, new a0());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f18982R;
        if (arrayList5 != null) {
            m.b(arrayList5);
            if (arrayList5.size() > 1) {
                C1601o.t(arrayList5, new T());
            }
            ArrayList arrayList6 = this.f18982R;
            m.b(arrayList6);
            if (arrayList6.size() > 1) {
                C1601o.t(arrayList6, new U());
            }
        }
        ArrayList arrayList7 = this.f18986V;
        if (arrayList7 != null) {
            m.b(arrayList7);
            if (arrayList7.size() > 1) {
                C1601o.t(arrayList7, new V());
            }
            ArrayList arrayList8 = this.f18986V;
            m.b(arrayList8);
            if (arrayList8.size() > 1) {
                C1601o.t(arrayList8, new W());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(Object obj, FileExplorerActivity fileExplorerActivity, kotlin.jvm.internal.C c5, C1874z zVar, View view) {
        long j4;
        Long l4;
        m.e(obj, "$file");
        m.e(fileExplorerActivity, "this$0");
        m.e(c5, "$decompressFilesJob");
        m.e(zVar, "$decompressFileListener");
        if (obj instanceof File) {
            if (fileExplorerActivity.f18997s0 != null) {
                File file = fileExplorerActivity.f18987W;
                if (file != null) {
                    l4 = Long.valueOf(file.getUsableSpace());
                } else {
                    l4 = null;
                }
                m.b(l4);
                File file2 = (File) obj;
                if (l4.longValue() > file2.length() * ((long) 2)) {
                    String str = fileExplorerActivity.f18997s0;
                    m.b(str);
                    c5.f20968a = fileExplorerActivity.C3(file2, str, zVar);
                }
            } else if (fileExplorerActivity.f18996r0 != null) {
                C1612h hVar = new C1612h();
                Context applicationContext = fileExplorerActivity.getApplicationContext();
                m.d(applicationContext, "applicationContext");
                Uri uri = fileExplorerActivity.f18996r0;
                m.b(uri);
                File file3 = (File) obj;
                if (hVar.k(applicationContext, uri) > file3.length() * ((long) 2)) {
                    Uri uri2 = fileExplorerActivity.f18996r0;
                    m.b(uri2);
                    c5.f20968a = fileExplorerActivity.B3(file3, uri2, zVar);
                }
            }
        } else if (!(obj instanceof DocumentFile)) {
        } else {
            if (fileExplorerActivity.f18997s0 != null) {
                File file4 = fileExplorerActivity.f18987W;
                if (file4 == null) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (externalStorageDirectory != null) {
                        j4 = externalStorageDirectory.getUsableSpace();
                    } else {
                        j4 = 0;
                    }
                } else {
                    m.b(file4);
                    j4 = file4.getUsableSpace();
                }
                DocumentFile documentFile = (DocumentFile) obj;
                if (j4 > documentFile.length() * ((long) 2)) {
                    String str2 = fileExplorerActivity.f18997s0;
                    m.b(str2);
                    c5.f20968a = fileExplorerActivity.A3(documentFile, str2, zVar);
                }
            } else if (fileExplorerActivity.f18996r0 != null) {
                C1612h hVar2 = new C1612h();
                Context applicationContext2 = fileExplorerActivity.getApplicationContext();
                m.d(applicationContext2, "applicationContext");
                Uri uri3 = fileExplorerActivity.f18996r0;
                m.b(uri3);
                DocumentFile documentFile2 = (DocumentFile) obj;
                if (hVar2.k(applicationContext2, uri3) > documentFile2.length() * ((long) 2)) {
                    Uri uri4 = fileExplorerActivity.f18996r0;
                    m.b(uri4);
                    c5.f20968a = fileExplorerActivity.z3(documentFile2, uri4, zVar);
                }
            } else {
                DocumentFile documentFile3 = fileExplorerActivity.f18983S;
                if (documentFile3 != null) {
                    m.b(documentFile3);
                    Uri uri5 = documentFile3.getUri();
                    m.d(uri5, "currentDirectoryDocumentFile!!.uri");
                    c5.f20968a = fileExplorerActivity.z3((DocumentFile) obj, uri5, zVar);
                    return;
                }
                File file5 = fileExplorerActivity.f18987W;
                if (file5 != null) {
                    m.b(file5);
                    String absolutePath = file5.getAbsolutePath();
                    m.d(absolutePath, "currentDirFile!!.absolutePath");
                    c5.f20968a = fileExplorerActivity.A3((DocumentFile) obj, absolutePath, zVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void P4() {
        if (this.f18988X) {
            ArrayList arrayList = this.f18982R;
            if (arrayList != null) {
                m.b(arrayList);
                if (arrayList.size() > 1) {
                    C1601o.t(arrayList, new f0());
                }
                ArrayList arrayList2 = this.f18982R;
                m.b(arrayList2);
                if (arrayList2.size() > 1) {
                    C1601o.t(arrayList2, new g0());
                }
            }
            ArrayList arrayList3 = this.f18986V;
            if (arrayList3 != null) {
                m.b(arrayList3);
                if (arrayList3.size() > 1) {
                    C1601o.t(arrayList3, new h0());
                }
                ArrayList arrayList4 = this.f18986V;
                m.b(arrayList4);
                if (arrayList4.size() > 1) {
                    C1601o.t(arrayList4, new i0());
                    return;
                }
                return;
            }
            return;
        }
        ArrayList arrayList5 = this.f18982R;
        if (arrayList5 != null) {
            m.b(arrayList5);
            if (arrayList5.size() > 1) {
                C1601o.t(arrayList5, new b0());
            }
            ArrayList arrayList6 = this.f18982R;
            m.b(arrayList6);
            if (arrayList6.size() > 1) {
                C1601o.t(arrayList6, new c0());
            }
        }
        ArrayList arrayList7 = this.f18986V;
        if (arrayList7 != null) {
            m.b(arrayList7);
            if (arrayList7.size() > 1) {
                C1601o.t(arrayList7, new d0());
            }
            ArrayList arrayList8 = this.f18986V;
            m.b(arrayList8);
            if (arrayList8.size() > 1) {
                C1601o.t(arrayList8, new e0());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Q3(kotlin.jvm.internal.C c5, FileExplorerActivity fileExplorerActivity, View view) {
        m.e(c5, "$decompressFilesJob");
        m.e(fileExplorerActivity, "this$0");
        C1001s0 s0Var = (C1001s0) c5.f20968a;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        AlertDialog alertDialog = fileExplorerActivity.f18977M;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void Q4(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(uri, getContentResolver().getType(uri));
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    /* access modifiers changed from: private */
    public final void R3() {
        MenuItem menuItem;
        MenuItem menuItem2;
        MenuItem menuItem3;
        MenuItem menuItem4;
        MenuItem menuItem5;
        Menu menu;
        Menu menu2;
        Menu menu3;
        Menu menu4;
        Menu menu5;
        Menu menu6;
        TextView textView = this.f18979O;
        if (textView != null) {
            textView.setText(getString(N1.i.action_name_file_explorer));
        }
        Toolbar toolbar = this.f18978N;
        MenuItem menuItem6 = null;
        if (toolbar == null || (menu6 = toolbar.getMenu()) == null) {
            menuItem = null;
        } else {
            menuItem = menu6.findItem(N1.f.action_create);
        }
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
        Toolbar toolbar2 = this.f18978N;
        if (toolbar2 == null || (menu5 = toolbar2.getMenu()) == null) {
            menuItem2 = null;
        } else {
            menuItem2 = menu5.findItem(N1.f.action_delete);
        }
        if (menuItem2 != null) {
            menuItem2.setVisible(false);
        }
        Toolbar toolbar3 = this.f18978N;
        if (toolbar3 == null || (menu4 = toolbar3.getMenu()) == null) {
            menuItem3 = null;
        } else {
            menuItem3 = menu4.findItem(N1.f.action_copy);
        }
        if (menuItem3 != null) {
            menuItem3.setVisible(false);
        }
        Toolbar toolbar4 = this.f18978N;
        if (toolbar4 == null || (menu3 = toolbar4.getMenu()) == null) {
            menuItem4 = null;
        } else {
            menuItem4 = menu3.findItem(N1.f.action_compress);
        }
        if (menuItem4 != null) {
            menuItem4.setVisible(false);
        }
        Toolbar toolbar5 = this.f18978N;
        if (toolbar5 == null || (menu2 = toolbar5.getMenu()) == null) {
            menuItem5 = null;
        } else {
            menuItem5 = menu2.findItem(N1.f.action_cut);
        }
        if (menuItem5 != null) {
            menuItem5.setVisible(false);
        }
        Toolbar toolbar6 = this.f18978N;
        if (!(toolbar6 == null || (menu = toolbar6.getMenu()) == null)) {
            menuItem6 = menu.findItem(N1.f.action_paste);
        }
        if (menuItem6 != null) {
            menuItem6.setVisible(false);
        }
    }

    /* access modifiers changed from: private */
    public final void R4() {
        b bVar = this.f18980P;
        m.b(bVar);
        bVar.h(false);
        R3();
        V3(false);
    }

    /* access modifiers changed from: private */
    public final void S3(DocumentFile documentFile) {
        Application application = getApplication();
        m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        Uri uri = documentFile.getUri();
        m.d(uri, "documentFile.uri");
        ((k) application).J(uri, new B(this, documentFile), this);
    }

    private final void S4() {
        String string = getString(N1.i.core_msg_cannot_write_path);
        m.d(string, "getString(R.string.core_msg_cannot_write_path)");
        q0(string);
    }

    /* access modifiers changed from: private */
    public final void T3(File file) {
        Application application = getApplication();
        m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
        ((k) application).K(file, new A(this, file), this);
    }

    /* access modifiers changed from: private */
    public final void U3(String str) {
        RelativeLayout relativeLayout = this.f19005y;
        if (relativeLayout == null) {
            m.u("rlLoading");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        if (this.f18983S == null && this.f18987W == null) {
            F4();
        }
        new R1.d(this.f18983S, this.f18987W, this, new D(this, str));
    }

    /* access modifiers changed from: private */
    public final void V3(boolean z4) {
        SearchView searchView;
        if (z4 && (searchView = this.f18971G) != null) {
            n3(searchView);
        }
        U3((String) null);
    }

    static /* synthetic */ void W3(FileExplorerActivity fileExplorerActivity, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = true;
        }
        fileExplorerActivity.V3(z4);
    }

    /* access modifiers changed from: private */
    public static final void X3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.A4();
    }

    /* access modifiers changed from: private */
    public static final void Y3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void Z3(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        if (z4) {
            fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
            RadioButton radioButton = fileExplorerActivity.f18974J;
            m.b(radioButton);
            radioButton.setOnClickListener(new O1.C(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f18975K;
            m.b(radioButton2);
            radioButton2.setOnClickListener(new O1.E());
            RadioButton radioButton3 = fileExplorerActivity.f18976L;
            m.b(radioButton3);
            radioButton3.setOnClickListener(new O1.F());
        }
    }

    /* access modifiers changed from: private */
    public static final void a4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
        fileExplorerActivity.u4();
        fileExplorerActivity.I4();
    }

    /* access modifiers changed from: private */
    public static final void b4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void c4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void d4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        if (z4) {
            fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
            RadioButton radioButton = fileExplorerActivity.f18975K;
            m.b(radioButton);
            radioButton.setOnClickListener(new O1.L(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f18974J;
            m.b(radioButton2);
            radioButton2.setOnClickListener(new O1.M());
            RadioButton radioButton3 = fileExplorerActivity.f18976L;
            m.b(radioButton3);
            radioButton3.setOnClickListener(new O1.N());
        }
    }

    /* access modifiers changed from: private */
    public static final void e4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
        fileExplorerActivity.u4();
        fileExplorerActivity.J4();
    }

    /* access modifiers changed from: private */
    public static final void f4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void g4(View view) {
    }

    private final void h3() {
        DocumentFile documentFile = this.f18983S;
        m.b(documentFile);
        String lastPathSegment = documentFile.getUri().getLastPathSegment();
        LinearLayout linearLayout = this.f18966B;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            m.u("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.findViewWithTag(lastPathSegment) == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i4 = N1.g.breadcrumb;
            LinearLayout linearLayout3 = this.f18966B;
            if (linearLayout3 == null) {
                m.u("llBreadcrumb");
                linearLayout3 = null;
            }
            View inflate = layoutInflater.inflate(i4, linearLayout3, false);
            m.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout4 = (LinearLayout) inflate;
            linearLayout4.setTag(lastPathSegment);
            TextView textView = (TextView) linearLayout4.findViewById(N1.f.tv_breadcrumb_path);
            m.b(lastPathSegment);
            String substring = lastPathSegment.substring(m3.m.R(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
            m.d(substring, "this as java.lang.String).substring(startIndex)");
            if (substring.length() > 0) {
                String substring2 = lastPathSegment.substring(m3.m.R(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                m.d(substring2, "this as java.lang.String).substring(startIndex)");
                String substring3 = substring2.substring(m3.m.R(substring2, "/", 0, false, 6, (Object) null) + 1);
                m.d(substring3, "this as java.lang.String).substring(startIndex)");
                if (substring3.length() > 0) {
                    String substring4 = substring2.substring(m3.m.R(substring2, "/", 0, false, 6, (Object) null) + 1);
                    m.d(substring4, "this as java.lang.String).substring(startIndex)");
                    textView.setText(substring4);
                } else {
                    String substring5 = substring2.substring(m3.m.R(substring2, ":", 0, false, 6, (Object) null) + 1);
                    m.d(substring5, "this as java.lang.String).substring(startIndex)");
                    textView.setText(substring5);
                }
            }
            textView.setTypeface(k.f7778g.x());
            LinearLayout linearLayout5 = this.f18966B;
            if (linearLayout5 == null) {
                m.u("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout5;
            }
            linearLayout2.addView(linearLayout4);
            s sVar = s.f8222a;
            B4();
        }
    }

    /* access modifiers changed from: private */
    public static final void h4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        if (z4) {
            fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
            RadioButton radioButton = fileExplorerActivity.f18976L;
            m.b(radioButton);
            radioButton.setOnClickListener(new C1585y(fileExplorerActivity));
            RadioButton radioButton2 = fileExplorerActivity.f18974J;
            m.b(radioButton2);
            radioButton2.setOnClickListener(new C1586z());
            RadioButton radioButton3 = fileExplorerActivity.f18975K;
            m.b(radioButton3);
            radioButton3.setOnClickListener(new O1.A());
        }
    }

    private final void i3() {
        File file = this.f18987W;
        m.b(file);
        String absolutePath = file.getAbsolutePath();
        LinearLayout linearLayout = this.f18966B;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            m.u("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.findViewWithTag(absolutePath) == null) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i4 = N1.g.breadcrumb;
            LinearLayout linearLayout3 = this.f18966B;
            if (linearLayout3 == null) {
                m.u("llBreadcrumb");
                linearLayout3 = null;
            }
            View inflate = layoutInflater.inflate(i4, linearLayout3, false);
            m.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout4 = (LinearLayout) inflate;
            linearLayout4.setTag(absolutePath);
            TextView textView = (TextView) linearLayout4.findViewById(N1.f.tv_breadcrumb_path);
            File file2 = this.f18987W;
            m.b(file2);
            String path = file2.getPath();
            m.d(path, "currentDirFile!!.path");
            textView.setText(Uri.parse(path).getLastPathSegment());
            textView.setTypeface(k.f7778g.x());
            LinearLayout linearLayout5 = this.f18966B;
            if (linearLayout5 == null) {
                m.u("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout5;
            }
            linearLayout2.addView(linearLayout4);
            s sVar = s.f8222a;
            B4();
        }
    }

    /* access modifiers changed from: private */
    public static final void i4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
        fileExplorerActivity.u4();
        fileExplorerActivity.H4();
    }

    /* access modifiers changed from: private */
    public final void j3(String str, String str2) {
        if (!isFinishing()) {
            RelativeLayout relativeLayout = this.f19005y;
            if (relativeLayout == null) {
                m.u("rlLoading");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1850b(this, str, str2, (d) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(View view) {
    }

    /* access modifiers changed from: private */
    public final void k3() {
        b bVar = this.f18980P;
        m.b(bVar);
        if (bVar.getItemCount() == 0) {
            DocumentFile documentFile = this.f18983S;
            if (documentFile != null) {
                m.b(documentFile);
                K4(documentFile.canRead());
                return;
            }
            File file = this.f18987W;
            if (file != null) {
                m.b(file);
                K4(file.canRead());
                return;
            }
            return;
        }
        LinearLayout linearLayout = this.f18965A;
        if (linearLayout == null) {
            m.u("llEmptyDirectory");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void k4(View view) {
    }

    /* access modifiers changed from: private */
    public final void l3() {
        Uri n4 = new C1612h().n(this);
        LinearLayout linearLayout = null;
        if (n4 != null) {
            this.f18983S = DocumentFile.fromTreeUri(this, n4);
            this.f18987W = null;
            W3(this, false, 1, (Object) null);
            return;
        }
        LinearLayout linearLayout2 = this.f19006z;
        if (linearLayout2 == null) {
            m.u("llPermissionExplanation");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        RecyclerView recyclerView = this.f19003x;
        if (recyclerView == null) {
            m.u("rvFiles");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        LinearLayout linearLayout3 = this.f19006z;
        if (linearLayout3 == null) {
            m.u("llPermissionExplanation");
        } else {
            linearLayout = linearLayout3;
        }
        View findViewById = linearLayout.findViewById(N1.f.tv_grant_access_sd);
        m.d(findViewById, "llPermissionExplanation.…(R.id.tv_grant_access_sd)");
        TextView textView = (TextView) findViewById;
        textView.setTypeface(k.f7778g.x());
        textView.setOnClickListener(new O1.G(this));
    }

    /* access modifiers changed from: private */
    public static final void l4(FileExplorerActivity fileExplorerActivity, CompoundButton compoundButton, boolean z4) {
        m.e(fileExplorerActivity, "this$0");
        new P1.a(fileExplorerActivity).H(z4);
        SearchView searchView = fileExplorerActivity.f18971G;
        m.b(searchView);
        fileExplorerActivity.j3(searchView.getQuery().toString(), (String) null);
    }

    /* access modifiers changed from: private */
    public static final void m3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.j0();
    }

    /* access modifiers changed from: private */
    public static final void m4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void n3(SearchView searchView) {
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) null);
        searchView.setQuery("", false);
        searchView.setOnQueryTextListener(this.f19000v0);
        Object systemService = getSystemService("input_method");
        m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public static final void n4(View view) {
    }

    private final C1001s0 o3(ArrayList arrayList, DocumentFile documentFile, c cVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1851c(arrayList, documentFile, cVar, this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean o4(FileExplorerActivity fileExplorerActivity, MenuItem menuItem) {
        m.e(fileExplorerActivity, "this$0");
        m.e(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == N1.f.action_create) {
            fileExplorerActivity.I3();
            return true;
        } else if (itemId == N1.f.action_delete) {
            fileExplorerActivity.s3();
            return true;
        } else if (itemId == N1.f.action_compress) {
            fileExplorerActivity.F3((Object) null);
            return true;
        } else if (itemId == N1.f.action_copy) {
            fileExplorerActivity.q3();
            return true;
        } else if (itemId == N1.f.action_cut) {
            fileExplorerActivity.x3();
            return true;
        } else if (itemId != N1.f.action_paste) {
            return true;
        } else {
            fileExplorerActivity.w4();
            return true;
        }
    }

    private final C1001s0 p3(ArrayList arrayList, File file, c cVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1852d(arrayList, file, cVar, this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void p4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        SearchView searchView = fileExplorerActivity.f18971G;
        if (searchView != null) {
            searchView.setIconified(false);
        }
    }

    private final void q3() {
        C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1853e(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void q4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        RelativeLayout relativeLayout = fileExplorerActivity.f18973I;
        m.b(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            view.animate().rotation(0.0f).start();
            RelativeLayout relativeLayout2 = fileExplorerActivity.f18973I;
            m.b(relativeLayout2);
            relativeLayout2.setVisibility(8);
            return;
        }
        view.animate().rotation(180.0f).start();
        RelativeLayout relativeLayout3 = fileExplorerActivity.f18973I;
        m.b(relativeLayout3);
        relativeLayout3.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r3(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.C1855g
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$g r0 = (com.uptodown.core.activities.FileExplorerActivity.C1855g) r0
            int r1 = r0.f19065d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19065d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$g r0 = new com.uptodown.core.activities.FileExplorerActivity$g
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f19063b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19065d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f19062a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            com.uptodown.core.activities.FileExplorerActivity$h r2 = new com.uptodown.core.activities.FileExplorerActivity$h
            r2.<init>(r6, r5)
            r0.f19062a = r6
            r0.f19065d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            com.uptodown.core.activities.FileExplorerActivity$i r4 = new com.uptodown.core.activities.FileExplorerActivity$i
            r4.<init>(r2, r5)
            r0.f19062a = r5
            r0.f19065d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.r3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void r4(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.f18988X = !fileExplorerActivity.f18988X;
        fileExplorerActivity.u4();
        fileExplorerActivity.I4();
    }

    private final void s3() {
        AlertDialog alertDialog = this.f18977M;
        if (alertDialog != null) {
            m.b(alertDialog);
            alertDialog.dismiss();
        }
        Integer num = null;
        View inflate = getLayoutInflater().inflate(N1.g.dialog_accept_cancel, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(N1.f.tv_dialog_msg);
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        Context context = textView.getContext();
        int i4 = N1.i.core_delete_x_files;
        b bVar = this.f18980P;
        if (bVar != null) {
            num = Integer.valueOf(bVar.a());
        }
        textView.setText(context.getString(i4, new Object[]{String.valueOf(num)}));
        TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_accept_option);
        textView2.setText(getString(N1.i.option_button_delete));
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new O1.J(this));
        TextView textView3 = (TextView) inflate.findViewById(N1.f.tv_cancel_option);
        textView3.setText(getString(N1.i.option_button_cancel));
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new O1.K(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        this.f18977M = create;
        m.b(create);
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        AlertDialog alertDialog2 = this.f18977M;
        m.b(alertDialog2);
        alertDialog2.show();
    }

    /* access modifiers changed from: private */
    public final void s4(DocumentFile documentFile) {
        Uri uri = documentFile.getUri();
        m.d(uri, "documentFile.uri");
        Q4(uri);
    }

    /* access modifiers changed from: private */
    public static final void t3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        fileExplorerActivity.D3();
        AlertDialog alertDialog = fileExplorerActivity.f18977M;
        m.b(alertDialog);
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public final void t4(File file) {
        Uri uriForFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
        m.d(uriForFile, "uri");
        Q4(uriForFile);
    }

    /* access modifiers changed from: private */
    public static final void u3(FileExplorerActivity fileExplorerActivity, View view) {
        m.e(fileExplorerActivity, "this$0");
        AlertDialog alertDialog = fileExplorerActivity.f18977M;
        m.b(alertDialog);
        alertDialog.dismiss();
    }

    private final void u4() {
        C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new H(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void v3(String str, int i4, int i5, long j4) {
        if (O() == null) {
            View inflate = getLayoutInflater().inflate(N1.g.dialog_copy_files, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(N1.f.tv_title_dialog_copying);
            k.a aVar = k.f7778g;
            textView.setTypeface(aVar.w());
            int i6 = N1.i.copying;
            int i7 = N1.i.size_of_total_size;
            textView.setText(getString(i6, new Object[]{getString(i7, new Object[]{String.valueOf(i4), String.valueOf(i5)})}));
            TextView textView2 = (TextView) inflate.findViewById(N1.f.tv_size_dialog_copying);
            textView2.setTypeface(aVar.x());
            int i8 = N1.i.mb_placeholder;
            int i9 = N1.i.zero;
            textView2.setText(getString(i7, new Object[]{getString(i8, new Object[]{getString(i9)}), new W1.i().c(j4)}));
            ((ProgressBar) inflate.findViewById(N1.f.pb_dialog_copying)).setProgress(0);
            TextView textView3 = (TextView) inflate.findViewById(N1.f.tv_files_dialog_copying);
            textView3.setTypeface(aVar.x());
            textView3.setText(str);
            TextView textView4 = (TextView) inflate.findViewById(N1.f.tv_percentage_dialog_copying);
            textView4.setTypeface(aVar.x());
            textView4.setText(getString(i9) + getString(N1.i.percentage));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);
            builder.setCancelable(false);
            if (!isFinishing()) {
                p0(builder.create());
                AlertDialog O4 = O();
                m.b(O4);
                Window window = O4.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog O5 = O();
                m.b(O5);
                O5.show();
                return;
            }
            return;
        }
        AlertDialog O6 = O();
        m.b(O6);
        TextView textView5 = (TextView) O6.findViewById(N1.f.tv_title_dialog_copying);
        if (textView5 != null) {
            textView5.setText(getString(N1.i.copying, new Object[]{getString(N1.i.size_of_total_size, new Object[]{String.valueOf(i4), String.valueOf(i5)})}));
        }
        AlertDialog O7 = O();
        m.b(O7);
        TextView textView6 = (TextView) O7.findViewById(N1.f.tv_files_dialog_copying);
        if (textView6 != null) {
            textView6.setTypeface(k.f7778g.x());
            textView6.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v4(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.I
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$I r0 = (com.uptodown.core.activities.FileExplorerActivity.I) r0
            int r1 = r0.f19022d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19022d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$I r0 = new com.uptodown.core.activities.FileExplorerActivity$I
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f19020b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19022d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f19019a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            com.uptodown.core.activities.FileExplorerActivity$J r2 = new com.uptodown.core.activities.FileExplorerActivity$J
            r2.<init>(r6, r5)
            r0.f19019a = r6
            r0.f19022d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            com.uptodown.core.activities.FileExplorerActivity$K r4 = new com.uptodown.core.activities.FileExplorerActivity$K
            r4.<init>(r2, r5)
            r0.f19019a = r5
            r0.f19022d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.v4(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void w3(String str) {
        C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1858j(this, new z(), str, (d) null), 3, (Object) null);
    }

    private final void w4() {
        if (this.f18987W != null) {
            ArrayList arrayList = this.f18991m0;
            m.b(arrayList);
            File file = this.f18987W;
            m.b(file);
            new R1.b(arrayList, file, this.f18999u0, this.f18992n0, this);
            return;
        }
        if (this.f18983S != null) {
            ArrayList arrayList2 = this.f18991m0;
            m.b(arrayList2);
            DocumentFile documentFile = this.f18983S;
            m.b(documentFile);
            new R1.b(arrayList2, documentFile, this.f18999u0, this.f18992n0, this);
        }
    }

    private final void x3() {
        this.f18992n0 = true;
        C1001s0 unused = C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1859k(this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void x4(FileExplorerActivity fileExplorerActivity, ActivityResult activityResult) {
        String str;
        Uri uri;
        Bundle extras;
        m.e(fileExplorerActivity, "this$0");
        if (activityResult.getResultCode() == 145) {
            Intent data = activityResult.getData();
            TextView textView = null;
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("path_selected");
            }
            fileExplorerActivity.f18997s0 = str;
            if (str != null) {
                fileExplorerActivity.f18996r0 = null;
                TextView textView2 = fileExplorerActivity.f18969E;
                if (textView2 == null) {
                    m.u("tvSelectedPath");
                } else {
                    textView = textView2;
                }
                textView.setText(fileExplorerActivity.f18997s0);
                return;
            }
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                uri = data2.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                fileExplorerActivity.f18996r0 = uri;
                fileExplorerActivity.f18997s0 = null;
                String lastPathSegment = uri.getLastPathSegment();
                m.b(lastPathSegment);
                String substring = lastPathSegment.substring(m3.m.R(lastPathSegment, ":", 0, false, 6, (Object) null) + 1);
                m.d(substring, "this as java.lang.String).substring(startIndex)");
                TextView textView3 = fileExplorerActivity.f18969E;
                if (textView3 == null) {
                    m.u("tvSelectedPath");
                } else {
                    textView = textView3;
                }
                textView.setText(fileExplorerActivity.getString(N1.i.sd_card) + '/' + substring);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y3(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.core.activities.FileExplorerActivity.C1860l
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.core.activities.FileExplorerActivity$l r0 = (com.uptodown.core.activities.FileExplorerActivity.C1860l) r0
            int r1 = r0.f19084d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19084d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.core.activities.FileExplorerActivity$l r0 = new com.uptodown.core.activities.FileExplorerActivity$l
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f19082b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f19084d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f19081a
            com.uptodown.core.activities.FileExplorerActivity r2 = (com.uptodown.core.activities.FileExplorerActivity) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            com.uptodown.core.activities.FileExplorerActivity$m r2 = new com.uptodown.core.activities.FileExplorerActivity$m
            r2.<init>(r6, r5)
            r0.f19081a = r6
            r0.f19084d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            com.uptodown.core.activities.FileExplorerActivity$n r4 = new com.uptodown.core.activities.FileExplorerActivity$n
            r4.<init>(r2, r5)
            r0.f19081a = r5
            r0.f19084d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.y3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void y4() {
        LinearLayout linearLayout = this.f18966B;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            m.u("llBreadcrumb");
            linearLayout = null;
        }
        if (linearLayout.getChildCount() > 1) {
            LinearLayout linearLayout3 = this.f18966B;
            if (linearLayout3 == null) {
                m.u("llBreadcrumb");
                linearLayout3 = null;
            }
            LinearLayout linearLayout4 = this.f18966B;
            if (linearLayout4 == null) {
                m.u("llBreadcrumb");
            } else {
                linearLayout2 = linearLayout4;
            }
            linearLayout3.removeViewAt(linearLayout2.getChildCount() - 1);
        }
    }

    private final C1001s0 z3(DocumentFile documentFile, Uri uri, e eVar) {
        return C0981i.d(o3.K.a(o3.Y.b()), (V2.g) null, (o3.L) null, new C1866r(documentFile, uri, eVar, this, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void z4() {
        LinearLayout linearLayout = this.f18966B;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            m.u("llBreadcrumb");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LayoutInflater layoutInflater = getLayoutInflater();
        int i4 = N1.g.breadcrumb_main;
        LinearLayout linearLayout3 = this.f18966B;
        if (linearLayout3 == null) {
            m.u("llBreadcrumb");
            linearLayout3 = null;
        }
        View inflate = layoutInflater.inflate(i4, linearLayout3, false);
        m.c(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout4 = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout4.findViewById(N1.f.tv_main_path);
        if (this.f18989Y) {
            textView.setText(getString(N1.i.sd_card));
        } else {
            textView.setText(getString(N1.i.internal_storage));
        }
        textView.setTypeface(k.f7778g.x());
        LinearLayout linearLayout5 = this.f18966B;
        if (linearLayout5 == null) {
            m.u("llBreadcrumb");
        } else {
            linearLayout2 = linearLayout5;
        }
        linearLayout2.addView(linearLayout4);
    }

    public void X0() {
        Object obj;
        super.X0();
        h o4 = k.f7778g.o();
        m.b(o4);
        if (o4.e() != null && (obj = this.f18990Z) != null) {
            m.b(obj);
            if (obj instanceof File) {
                File file = (File) obj;
                if (!file.isDirectory()) {
                    Application application = getApplication();
                    m.c(application, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                    ((k) application).V(file);
                }
            } else if (obj instanceof DocumentFile) {
                Application application2 = getApplication();
                m.c(application2, "null cannot be cast to non-null type com.uptodown.core.UptodownCoreApplication");
                ((k) application2).U((DocumentFile) obj);
            }
        }
    }

    public void Y() {
        F(getString(N1.i.msg_permission_storage_denied));
    }

    public void Z() {
        Uri n4 = new C1612h().n(this);
        if (n4 != null) {
            LinearLayout linearLayout = this.f19006z;
            if (linearLayout == null) {
                m.u("llPermissionExplanation");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView = this.f19003x;
            if (recyclerView == null) {
                m.u("rvFiles");
                recyclerView = null;
            }
            recyclerView.setVisibility(0);
            this.f18983S = DocumentFile.fromTreeUri(this, n4);
            this.f18987W = null;
            W3(this, false, 1, (Object) null);
        }
    }

    public void a0() {
        F(getString(N1.i.core_error_wrong_sdcard_path));
    }

    public void a1() {
    }

    public void b0() {
        F(getString(N1.i.msg_permission_storage_denied));
    }

    public void d0() {
        W3(this, false, 1, (Object) null);
        if (!Q()) {
            m0();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[LOOP:0: B:15:0x0056->B:18:0x0066, LOOP_START, PHI: r3 
      PHI: (r3v44 androidx.documentfile.provider.DocumentFile) = (r3v42 androidx.documentfile.provider.DocumentFile), (r3v45 androidx.documentfile.provider.DocumentFile) binds: [B:14:0x0044, B:18:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            int r12 = N1.g.file_explorer
            r11.setContentView((int) r12)
            android.content.Intent r12 = r11.getIntent()
            android.os.Bundle r12 = r12.getExtras()
            r0 = 1
            r1 = 0
            r2 = 0
            if (r12 == 0) goto L_0x00df
            java.lang.String r3 = "subdir"
            boolean r4 = r12.containsKey(r3)
            if (r4 == 0) goto L_0x0076
            java.lang.String r5 = r12.getString(r3)
            if (r5 == 0) goto L_0x0076
            java.lang.String r3 = "subdir_sd"
            boolean r3 = r12.getBoolean(r3)
            r11.f18989Y = r3
            if (r3 == 0) goto L_0x006d
            W1.h r3 = new W1.h
            r3.<init>()
            android.net.Uri r3 = r3.n(r11)
            if (r3 == 0) goto L_0x0076
            androidx.documentfile.provider.DocumentFile r3 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r11, r3)
            if (r3 == 0) goto L_0x0068
            int r4 = r5.length()
            if (r4 <= 0) goto L_0x0068
            java.lang.String r4 = "/"
            java.lang.String[] r6 = new java.lang.String[]{r4}
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            java.util.List r4 = m3.m.j0(r5, r6, r7, r8, r9, r10)
            java.util.Iterator r4 = r4.iterator()
        L_0x0056:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0068
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            androidx.documentfile.provider.DocumentFile r3 = r3.findFile(r5)
            if (r3 != 0) goto L_0x0056
        L_0x0068:
            r11.f18983S = r3
            r11.f18987W = r2
            goto L_0x0076
        L_0x006d:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            r11.f18987W = r3
            r11.f18983S = r2
        L_0x0076:
            java.lang.String r3 = "select_path"
            boolean r4 = r12.containsKey(r3)
            if (r4 == 0) goto L_0x00df
            int r12 = r12.getInt(r3)
            if (r12 != r0) goto L_0x00df
            r11.f18993o0 = r0
            int r12 = N1.f.ll_options
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r3 = "findViewById(R.id.ll_options)"
            kotlin.jvm.internal.m.d(r12, r3)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            int r3 = N1.f.view_options_shadow
            android.view.View r3 = r11.findViewById(r3)
            java.lang.String r4 = "findViewById(R.id.view_options_shadow)"
            kotlin.jvm.internal.m.d(r3, r4)
            r12.setVisibility(r1)
            r3.setVisibility(r1)
            int r12 = N1.f.tv_select_current_dir
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f18970F = r12
            if (r12 != 0) goto L_0x00b1
            goto L_0x00ba
        L_0x00b1:
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x00ba:
            android.widget.TextView r12 = r11.f18970F
            if (r12 == 0) goto L_0x00c6
            O1.s r3 = new O1.s
            r3.<init>(r11)
            r12.setOnClickListener(r3)
        L_0x00c6:
            int r12 = N1.f.tv_cancel
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
            O1.V r3 = new O1.V
            r3.<init>(r11)
            r12.setOnClickListener(r3)
        L_0x00df:
            int r12 = N1.f.f7776j0
            android.view.View r12 = r11.findViewById(r12)
            androidx.appcompat.widget.Toolbar r12 = (androidx.appcompat.widget.Toolbar) r12
            r11.f18978N = r12
            int r12 = N1.f.tv_toolbar_title
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f18979O = r12
            if (r12 != 0) goto L_0x00f6
            goto L_0x00ff
        L_0x00f6:
            int r3 = N1.i.action_name_file_explorer
            java.lang.String r3 = r11.getString(r3)
            r12.setText(r3)
        L_0x00ff:
            android.widget.TextView r12 = r11.f18979O
            if (r12 != 0) goto L_0x0104
            goto L_0x010d
        L_0x0104:
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x010d:
            androidx.appcompat.widget.Toolbar r12 = r11.f18978N
            if (r12 != 0) goto L_0x0112
            goto L_0x011b
        L_0x0112:
            int r3 = N1.e.core_vector_menu_dots_blue
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r11, r3)
            r12.setOverflowIcon(r3)
        L_0x011b:
            androidx.appcompat.widget.Toolbar r12 = r11.f18978N
            if (r12 != 0) goto L_0x0120
            goto L_0x0129
        L_0x0120:
            int r3 = N1.e.core_vector_back
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r11, r3)
            r12.setNavigationIcon((android.graphics.drawable.Drawable) r3)
        L_0x0129:
            androidx.appcompat.widget.Toolbar r12 = r11.f18978N
            if (r12 == 0) goto L_0x0135
            O1.W r3 = new O1.W
            r3.<init>(r11)
            r12.setNavigationOnClickListener(r3)
        L_0x0135:
            androidx.appcompat.widget.Toolbar r12 = r11.f18978N
            if (r12 == 0) goto L_0x013e
            int r3 = N1.h.core_menu_file_explorer
            r12.inflateMenu(r3)
        L_0x013e:
            androidx.appcompat.widget.Toolbar r12 = r11.f18978N
            if (r12 == 0) goto L_0x014a
            O1.X r3 = new O1.X
            r3.<init>(r11)
            r12.setOnMenuItemClickListener(r3)
        L_0x014a:
            r11.R3()
            int r12 = N1.f.layout_breadcrumb_main
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r3 = "findViewById(R.id.layout_breadcrumb_main)"
            kotlin.jvm.internal.m.d(r12, r3)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r11.f18966B = r12
            int r12 = N1.f.sv_breadcumb
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r3 = "findViewById(R.id.sv_breadcumb)"
            kotlin.jvm.internal.m.d(r12, r3)
            android.widget.HorizontalScrollView r12 = (android.widget.HorizontalScrollView) r12
            r11.f18967C = r12
            android.widget.LinearLayout r12 = r11.f18966B
            if (r12 != 0) goto L_0x0175
            java.lang.String r12 = "llBreadcrumb"
            kotlin.jvm.internal.m.u(r12)
            r12 = r2
        L_0x0175:
            int r3 = N1.f.tv_main_path
            android.view.View r12 = r12.findViewById(r3)
            java.lang.String r3 = "llBreadcrumb.findViewById(R.id.tv_main_path)"
            kotlin.jvm.internal.m.d(r12, r3)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f19001w = r12
            if (r12 != 0) goto L_0x018c
            java.lang.String r12 = "tvBreadCrumb"
            kotlin.jvm.internal.m.u(r12)
            r12 = r2
        L_0x018c:
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r12 = N1.f.tv_empty_dir
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r4 = "findViewById(R.id.tv_empty_dir)"
            kotlin.jvm.internal.m.d(r12, r4)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f18968D = r12
            if (r12 != 0) goto L_0x01ac
            java.lang.String r12 = "tvEmptyDirectory"
            kotlin.jvm.internal.m.u(r12)
            r12 = r2
        L_0x01ac:
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r12 = N1.f.search_view
            android.view.View r12 = r11.findViewById(r12)
            androidx.appcompat.widget.SearchView r12 = (androidx.appcompat.widget.SearchView) r12
            r11.f18971G = r12
            if (r12 == 0) goto L_0x01c4
            com.uptodown.core.activities.FileExplorerActivity$G r4 = r11.f19000v0
            r12.setOnQueryTextListener(r4)
        L_0x01c4:
            androidx.appcompat.widget.SearchView r12 = r11.f18971G
            if (r12 == 0) goto L_0x01d0
            O1.Y r4 = new O1.Y
            r4.<init>(r11)
            r12.setOnClickListener(r4)
        L_0x01d0:
            androidx.appcompat.widget.SearchView r12 = r11.f18971G
            kotlin.jvm.internal.m.b(r12)
            int r4 = androidx.appcompat.R.id.search_close_btn
            android.view.View r12 = r12.findViewById(r4)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            int r4 = N1.e.core_shape_transparent
            r12.setBackgroundResource(r4)
            androidx.appcompat.widget.SearchView r12 = r11.f18971G
            kotlin.jvm.internal.m.b(r12)
            int r4 = androidx.appcompat.R.id.search_src_text
            android.view.View r12 = r12.findViewById(r4)
            android.widget.EditText r12 = (android.widget.EditText) r12
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            int r4 = N1.c.text_primary
            int r4 = androidx.core.content.ContextCompat.getColor(r11, r4)
            r12.setTextColor(r4)
            int r4 = N1.c.core_search_view_color
            int r4 = androidx.core.content.ContextCompat.getColor(r11, r4)
            r12.setHintTextColor(r4)
            int r12 = N1.f.iv_search_options
            android.view.View r12 = r11.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r11.f18972H = r12
            kotlin.jvm.internal.m.b(r12)
            O1.Z r4 = new O1.Z
            r4.<init>(r11)
            r12.setOnClickListener(r4)
            int r12 = N1.f.rl_sort_options
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r11.f18973I = r12
            int r12 = N1.f.rb_name_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f18974J = r12
            kotlin.jvm.internal.m.b(r12)
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            android.widget.RadioButton r12 = r11.f18974J
            kotlin.jvm.internal.m.b(r12)
            O1.a0 r4 = new O1.a0
            r4.<init>(r11)
            r12.setOnClickListener(r4)
            android.widget.RadioButton r12 = r11.f18974J
            kotlin.jvm.internal.m.b(r12)
            O1.b0 r4 = new O1.b0
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = N1.f.rb_size_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f18975K = r12
            kotlin.jvm.internal.m.b(r12)
            O1.t r4 = new O1.t
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = N1.f.rb_date_sort
            android.view.View r12 = r11.findViewById(r12)
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            r11.f18976L = r12
            kotlin.jvm.internal.m.b(r12)
            O1.u r4 = new O1.u
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            int r12 = N1.f.cb_show_hidden_files
            android.view.View r12 = r11.findViewById(r12)
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            android.graphics.Typeface r4 = r3.x()
            r12.setTypeface(r4)
            P1.a r4 = new P1.a
            r4.<init>(r11)
            boolean r4 = r4.q()
            r12.setChecked(r4)
            O1.D r4 = new O1.D
            r4.<init>(r11)
            r12.setOnCheckedChangeListener(r4)
            r11.I4()
            int r12 = N1.f.rv_files
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r4 = "findViewById(R.id.rv_files)"
            kotlin.jvm.internal.m.d(r12, r4)
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            r11.f19003x = r12
            java.lang.String r4 = "rvFiles"
            if (r12 != 0) goto L_0x02bc
            kotlin.jvm.internal.m.u(r4)
            r12 = r2
        L_0x02bc:
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            r5.<init>(r11, r0, r1)
            r12.setLayoutManager(r5)
            androidx.recyclerview.widget.RecyclerView r12 = r11.f19003x
            if (r12 != 0) goto L_0x02cc
            kotlin.jvm.internal.m.u(r4)
            r12 = r2
        L_0x02cc:
            W1.u r5 = new W1.u
            android.content.res.Resources r6 = r11.getResources()
            int r7 = N1.d.margin_generic_item_recyclerview
            float r6 = r6.getDimension(r7)
            int r6 = (int) r6
            r5.<init>(r6)
            r12.addItemDecoration(r5)
            androidx.recyclerview.widget.RecyclerView r12 = r11.f19003x
            if (r12 != 0) goto L_0x02e7
            kotlin.jvm.internal.m.u(r4)
            r12 = r2
        L_0x02e7:
            androidx.recyclerview.widget.DefaultItemAnimator r4 = new androidx.recyclerview.widget.DefaultItemAnimator
            r4.<init>()
            r12.setItemAnimator(r4)
            int r12 = N1.f.rl_loading_file_explorer
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r4 = "findViewById(R.id.rl_loading_file_explorer)"
            kotlin.jvm.internal.m.d(r12, r4)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r11.f19005y = r12
            if (r12 != 0) goto L_0x0306
            java.lang.String r12 = "rlLoading"
            kotlin.jvm.internal.m.u(r12)
            r12 = r2
        L_0x0306:
            O1.O r4 = new O1.O
            r4.<init>()
            r12.setOnClickListener(r4)
            int r12 = N1.f.ll_empty_dir
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r4 = "findViewById(R.id.ll_empty_dir)"
            kotlin.jvm.internal.m.d(r12, r4)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r11.f18965A = r12
            int r12 = N1.f.ll_sd_permissions_explanation
            android.view.View r12 = r11.findViewById(r12)
            java.lang.String r4 = "findViewById(R.id.ll_sd_permissions_explanation)"
            kotlin.jvm.internal.m.d(r12, r4)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r11.f19006z = r12
            int r12 = N1.f.tv_storage_devices
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r11.f18995q0 = r12
            if (r12 != 0) goto L_0x0339
            goto L_0x0340
        L_0x0339:
            android.graphics.Typeface r3 = r3.w()
            r12.setTypeface(r3)
        L_0x0340:
            int r12 = N1.f.tl_storage
            android.view.View r12 = r11.findViewById(r12)
            com.google.android.material.tabs.TabLayout r12 = (com.google.android.material.tabs.TabLayout) r12
            r11.f18994p0 = r12
            kotlin.jvm.internal.m.b(r12)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.newTab()
            int r3 = N1.i.internal_storage
            java.lang.String r3 = r11.getString(r3)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.setText((java.lang.CharSequence) r3)
            java.lang.String r3 = "tabsStorage!!.newTab().s…string.internal_storage))"
            kotlin.jvm.internal.m.d(r12, r3)
            r12.setId(r1)
            com.google.android.material.tabs.TabLayout r3 = r11.f18994p0
            kotlin.jvm.internal.m.b(r3)
            r3.addTab(r12)
            com.google.android.material.tabs.TabLayout r12 = r11.f18994p0
            kotlin.jvm.internal.m.b(r12)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.newTab()
            int r3 = N1.i.sd_card
            java.lang.String r3 = r11.getString(r3)
            com.google.android.material.tabs.TabLayout$Tab r12 = r12.setText((java.lang.CharSequence) r3)
            java.lang.String r3 = "tabsStorage!!.newTab().s…String(R.string.sd_card))"
            kotlin.jvm.internal.m.d(r12, r3)
            r12.setId(r0)
            com.google.android.material.tabs.TabLayout r3 = r11.f18994p0
            kotlin.jvm.internal.m.b(r3)
            r3.addTab(r12)
            com.google.android.material.tabs.TabLayout r12 = r11.f18994p0
            kotlin.jvm.internal.m.b(r12)
            android.view.View r12 = androidx.core.view.ViewGroupKt.get(r12, r1)
            r12.setSelected(r0)
            com.google.android.material.tabs.TabLayout r12 = r11.f18994p0
            kotlin.jvm.internal.m.b(r12)
            com.uptodown.core.activities.FileExplorerActivity$F r3 = new com.uptodown.core.activities.FileExplorerActivity$F
            r3.<init>(r11)
            r12.addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.OnTabSelectedListener) r3)
            boolean r12 = r11.R()
            if (r12 == 0) goto L_0x03e8
            W3(r11, r1, r0, r2)
            W1.E r12 = new W1.E
            r12.<init>()
            java.util.ArrayList r12 = r12.c(r11)
            r11.f18984T = r12
            if (r12 == 0) goto L_0x03d5
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x03c4
            goto L_0x03d5
        L_0x03c4:
            com.google.android.material.tabs.TabLayout r12 = r11.f18994p0
            if (r12 != 0) goto L_0x03c9
            goto L_0x03cc
        L_0x03c9:
            r12.setVisibility(r1)
        L_0x03cc:
            android.widget.TextView r12 = r11.f18995q0
            if (r12 != 0) goto L_0x03d1
            goto L_0x03eb
        L_0x03d1:
            r12.setVisibility(r1)
            goto L_0x03eb
        L_0x03d5:
            com.google.android.material.tabs.TabLayout r12 = r11.f18994p0
            r0 = 8
            if (r12 != 0) goto L_0x03dc
            goto L_0x03df
        L_0x03dc:
            r12.setVisibility(r0)
        L_0x03df:
            android.widget.TextView r12 = r11.f18995q0
            if (r12 != 0) goto L_0x03e4
            goto L_0x03eb
        L_0x03e4:
            r12.setVisibility(r0)
            goto L_0x03eb
        L_0x03e8:
            r11.H()
        L_0x03eb:
            androidx.activity.OnBackPressedDispatcher r12 = r11.getOnBackPressedDispatcher()
            com.uptodown.core.activities.FileExplorerActivity$E r0 = r11.f19002w0
            r12.addCallback(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.FileExplorerActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        m.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i4 != 82) {
            return super.onKeyDown(i4, keyEvent);
        }
        Toolbar toolbar = this.f18978N;
        m.b(toolbar);
        toolbar.showOverflowMenu();
        return true;
    }
}
