package x2;

import R2.s;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.m;
import y2.n;

/* renamed from: x2.m  reason: case insensitive filesystem */
public abstract class C2381m extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private boolean f22437a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2381m(View view) {
        super(view);
        m.e(view, "itemView");
    }

    /* access modifiers changed from: private */
    public static final s d(ProgressBar progressBar, C2381m mVar) {
        progressBar.setVisibility(8);
        mVar.f22437a = false;
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final s f(C2381m mVar) {
        mVar.f22437a = false;
        return s.f8222a;
    }

    public final void c(ProgressBar progressBar, ImageView imageView) {
        m.e(progressBar, "pb");
        m.e(imageView, "ivIcon");
        if (progressBar.getVisibility() == 0 && !this.f22437a) {
            this.f22437a = true;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            new n(context).j(imageView, new C2379l(progressBar, this));
        }
    }

    public final void e(ProgressBar progressBar, ImageView imageView) {
        m.e(progressBar, "pb");
        m.e(imageView, "ivIcon");
        if (progressBar.getVisibility() == 8 && !this.f22437a) {
            progressBar.setVisibility(0);
            this.f22437a = true;
            Context context = this.itemView.getContext();
            m.d(context, "getContext(...)");
            new n(context).l(imageView, new C2377k(this));
        }
    }
}
