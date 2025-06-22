package x2;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.UptodownApp;
import com.uptodown.views.FullHeightImageView;
import f2.C2006E;
import g2.O;
import g2.Z;
import kotlin.jvm.internal.m;

/* renamed from: x2.y0  reason: case insensitive filesystem */
public final class C2405y0 extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2006E f22551a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f22552b;

    /* renamed from: x2.y0$a */
    public static final class a implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2405y0 f22553a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ O f22554b;

        a(C2405y0 y0Var, O o4) {
            this.f22553a = y0Var;
            this.f22554b = o4;
        }

        public void a(Exception exc) {
            m.e(exc, "e");
            exc.printStackTrace();
            this.f22553a.f22551a.b(this.f22554b);
        }

        public void b() {
            this.f22553a.itemView.setVisibility(0);
            if (this.f22553a.f22552b == 0) {
                View view = this.f22553a.itemView;
                m.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
                if (((FullHeightImageView) view).getWidth() > 0) {
                    C2405y0 y0Var = this.f22553a;
                    View view2 = y0Var.itemView;
                    m.c(view2, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
                    y0Var.f22552b = ((FullHeightImageView) view2).getWidth();
                }
            }
        }
    }

    /* renamed from: x2.y0$b */
    public static final class b implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2405y0 f22555a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f22556b;

        b(C2405y0 y0Var, Z z4) {
            this.f22555a = y0Var;
            this.f22556b = z4;
        }

        public void a(Exception exc) {
            m.e(exc, "e");
            exc.printStackTrace();
            this.f22555a.f22551a.c(this.f22556b);
        }

        public void b() {
            this.f22555a.itemView.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2405y0(View view, C2006E e5) {
        super(view);
        m.e(view, "itemView");
        m.e(e5, "listener");
        this.f22551a = e5;
    }

    /* access modifiers changed from: private */
    public static final void h(C2405y0 y0Var, O o4, View view) {
        y0Var.f22551a.a(o4);
    }

    /* access modifiers changed from: private */
    public static final void i(C2405y0 y0Var, Z z4, View view) {
        y0Var.f22551a.d(z4);
    }

    public final void f(O o4) {
        m.e(o4, "screenShot");
        this.itemView.setOnClickListener(new C2403x0(this, o4));
        View view = this.itemView;
        m.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        ((FullHeightImageView) view).setMinimumWidth(this.f22552b);
        w l4 = s.h().l(o4.d());
        UptodownApp.a aVar = UptodownApp.f17422D;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        w n4 = l4.n(aVar.j0(context));
        View view2 = this.itemView;
        m.c(view2, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        n4.j((FullHeightImageView) view2, new a(this, o4));
    }

    public final void g(Z z4) {
        m.e(z4, MimeTypes.BASE_TYPE_VIDEO);
        this.itemView.setOnClickListener(new C2401w0(this, z4));
        w l4 = s.h().l(z4.b());
        UptodownApp.a aVar = UptodownApp.f17422D;
        Context context = this.itemView.getContext();
        m.d(context, "getContext(...)");
        w n4 = l4.n(aVar.h0(context));
        View view = this.itemView;
        m.c(view, "null cannot be cast to non-null type com.uptodown.views.FullHeightImageView");
        n4.j((FullHeightImageView) view, new b(this, z4));
    }
}
