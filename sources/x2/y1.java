package x2;

import N1.k;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import c2.Z0;
import com.uptodown.R;
import f2.L;
import g2.X;
import kotlin.jvm.internal.m;

public final class y1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Z0 f22557a;

    /* renamed from: b  reason: collision with root package name */
    private final L f22558b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y1(Z0 z02, L l4) {
        super(z02.getRoot());
        m.e(z02, "binding");
        this.f22557a = z02;
        this.f22558b = l4;
        TextView textView = z02.f10184e;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        z02.f10185f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void d(y1 y1Var, View view) {
        y1Var.f22557a.f10181b.performClick();
    }

    /* access modifiers changed from: private */
    public static final void e(y1 y1Var, CompoundButton compoundButton, boolean z4) {
        L l4 = y1Var.f22558b;
        if (l4 != null) {
            l4.a(y1Var.getBindingAdapterPosition());
        }
    }

    public final void c(X x4) {
        m.e(x4, "userRemoteDevice");
        if (x4.d() == 1) {
            Z0 z02 = this.f22557a;
            z02.f10184e.setText(z02.getRoot().getContext().getString(R.string.current_device_tag));
        } else {
            this.f22557a.f10184e.setText(x4.b());
        }
        if (x4.e() == 1) {
            this.f22557a.getRoot().setAlpha(1.0f);
            this.f22557a.f10181b.setVisibility(8);
            this.f22557a.f10185f.setVisibility(0);
            Z0 z03 = this.f22557a;
            z03.f10185f.setText(z03.getRoot().getContext().getString(R.string.app_installed));
            Z0 z04 = this.f22557a;
            z04.f10185f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(z04.getRoot().getContext(), R.drawable.vector_installed_check), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22557a.getRoot().setOnClickListener((View.OnClickListener) null);
            this.f22557a.f10181b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        } else if (x4.c() == 1) {
            this.f22557a.f10181b.setVisibility(0);
            if (x4.f() == 1) {
                this.f22557a.getRoot().setAlpha(0.3f);
                this.f22557a.f10181b.setClickable(false);
                this.f22557a.f10181b.setChecked(true);
                this.f22557a.f10185f.setVisibility(0);
                Z0 z05 = this.f22557a;
                z05.f10185f.setText(z05.getRoot().getContext().getString(R.string.install_pending));
                Z0 z06 = this.f22557a;
                z06.f10185f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(z06.getRoot().getContext(), R.drawable.vector_pending), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f22557a.getRoot().setOnClickListener((View.OnClickListener) null);
                this.f22557a.f10181b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                return;
            }
            this.f22557a.getRoot().setAlpha(1.0f);
            this.f22557a.f10181b.setClickable(true);
            this.f22557a.f10181b.setChecked(false);
            this.f22557a.f10185f.setVisibility(8);
            this.f22557a.f10185f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22557a.getRoot().setOnClickListener(new w1(this));
            this.f22557a.f10181b.setOnCheckedChangeListener(new x1(this));
        } else {
            this.f22557a.getRoot().setAlpha(0.3f);
            this.f22557a.f10181b.setVisibility(8);
            this.f22557a.f10185f.setVisibility(0);
            Z0 z07 = this.f22557a;
            z07.f10185f.setText(z07.getRoot().getContext().getString(R.string.device_not_compatible));
            Z0 z08 = this.f22557a;
            z08.f10185f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(z08.getRoot().getContext(), R.drawable.vector_incompatible), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f22557a.getRoot().setOnClickListener((View.OnClickListener) null);
            this.f22557a.f10181b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
    }
}
