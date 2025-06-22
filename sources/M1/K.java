package M1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c2.O0;
import c2.P0;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2015f;
import g2.C2051i;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class K extends RecyclerView.Adapter {

    /* renamed from: g  reason: collision with root package name */
    public static final a f7477g = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f7478a;

    /* renamed from: b  reason: collision with root package name */
    private final C2015f f7479b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7480c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7481d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7482e;

    /* renamed from: f  reason: collision with root package name */
    private int f7483f;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private P0 f7484a;

        /* renamed from: b  reason: collision with root package name */
        private final C2015f f7485b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f7486c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ K f7487d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(K k4, P0 p02, C2015f fVar, Context context) {
            super(p02.getRoot());
            m.e(p02, "binding");
            m.e(fVar, "listener");
            m.e(context, "context");
            this.f7487d = k4;
            this.f7484a = p02;
            this.f7485b = fVar;
            this.f7486c = context;
        }

        /* access modifiers changed from: private */
        public static final void c(b bVar, C2051i iVar, int i4, View view) {
            bVar.f7485b.b(iVar, i4);
        }

        public final void b(C2051i iVar, int i4, boolean z4) {
            m.e(iVar, "avatar");
            s.h().l(iVar.c()).n(UptodownApp.f17422D.i0(this.f7486c)).l(R.drawable.shape_avatar_item).i(this.f7484a.f9890b);
            this.f7484a.f9890b.setOnClickListener(new L(this, iVar, i4));
            if (z4) {
                this.f7484a.f9893e.setBackground(ContextCompat.getDrawable(this.f7486c, R.drawable.shape_avatar_selected_turbo_item));
                this.f7484a.f9891c.setVisibility(0);
            } else {
                this.f7484a.f9893e.setBackground((Drawable) null);
                this.f7484a.f9891c.setVisibility(8);
            }
            if (this.f7487d.f7482e) {
                this.f7484a.f9892d.setVisibility(8);
            } else {
                this.f7484a.f9892d.setVisibility(0);
            }
        }
    }

    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private O0 f7488a;

        /* renamed from: b  reason: collision with root package name */
        private final C2015f f7489b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f7490c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ K f7491d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(K k4, O0 o02, C2015f fVar, Context context) {
            super(o02.getRoot());
            m.e(o02, "binding");
            m.e(fVar, "listener");
            m.e(context, "context");
            this.f7491d = k4;
            this.f7488a = o02;
            this.f7489b = fVar;
            this.f7490c = context;
        }

        /* access modifiers changed from: private */
        public static final void c(c cVar, C2051i iVar, int i4, View view) {
            cVar.f7489b.a(iVar, i4);
        }

        public final void b(C2051i iVar, int i4, int i5, boolean z4) {
            m.e(iVar, "avatar");
            s.h().l(iVar.c()).n(UptodownApp.f17422D.i0(this.f7490c)).l(R.drawable.shape_avatar_item).i(this.f7488a.f9875b);
            this.f7488a.f9875b.setOnClickListener(new M(this, iVar, i4));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
            int dimension = (int) this.f7490c.getResources().getDimension(R.dimen.margin_m);
            if (z4) {
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
                this.f7488a.getRoot().setLayoutParams(layoutParams);
                this.f7488a.getRoot().animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).start();
                this.f7488a.f9876c.setVisibility(0);
                this.f7488a.f9877d.setBackground(ContextCompat.getDrawable(this.f7490c, R.drawable.shape_avatar_selected_item));
                return;
            }
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            this.f7488a.getRoot().setLayoutParams(layoutParams);
            this.f7488a.getRoot().animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            this.f7488a.f9877d.setBackground((Drawable) null);
            this.f7488a.f9876c.setVisibility(8);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ K(java.util.ArrayList r2, f2.C2015f r3, int r4, int r5, boolean r6, int r7, kotlin.jvm.internal.C2103g r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r5 = 0
        L_0x0006:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x0011
            r7 = 0
        L_0x000b:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x0013
        L_0x0011:
            r7 = r6
            goto L_0x000b
        L_0x0013:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M1.K.<init>(java.util.ArrayList, f2.f, int, int, boolean, int, kotlin.jvm.internal.g):void");
    }

    public final ArrayList b() {
        return this.f7478a;
    }

    public final int c() {
        return this.f7483f;
    }

    public final void d(int i4) {
        this.f7483f = i4;
    }

    public int getItemCount() {
        return this.f7478a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "viewHolder");
        Object obj = this.f7478a.get(i4);
        m.d(obj, "get(...)");
        C2051i iVar = (C2051i) obj;
        boolean z4 = false;
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            int i5 = this.f7481d;
            if (this.f7483f == i4) {
                z4 = true;
            }
            cVar.b(iVar, i4, i5, z4);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            if (this.f7483f == i4) {
                z4 = true;
            }
            bVar.b(iVar, i4, z4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "viewGroup");
        int i5 = this.f7480c;
        if (i5 == 0) {
            O0 c5 = O0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(c5, "inflate(...)");
            C2015f fVar = this.f7479b;
            Context context = viewGroup.getContext();
            m.d(context, "getContext(...)");
            return new c(this, c5, fVar, context);
        } else if (i5 == 1) {
            P0 c6 = P0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(c6, "inflate(...)");
            C2015f fVar2 = this.f7479b;
            Context context2 = viewGroup.getContext();
            m.d(context2, "getContext(...)");
            return new b(this, c6, fVar2, context2);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public K(ArrayList arrayList, C2015f fVar, int i4, int i5, boolean z4) {
        m.e(arrayList, "avatars");
        m.e(fVar, "listener");
        this.f7478a = arrayList;
        this.f7479b = fVar;
        this.f7480c = i4;
        this.f7481d = i5;
        this.f7482e = z4;
        this.f7483f = -1;
    }
}
