package x2;

import N1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import f2.C2029u;
import kotlin.jvm.internal.m;

public final class U extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2029u f22272a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f22273b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f22274c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public U(View view, String str, C2029u uVar) {
        super(view);
        m.e(view, "itemView");
        m.e(str, MimeTypes.BASE_TYPE_TEXT);
        this.f22272a = uVar;
        View findViewById = view.findViewById(R.id.tv_myappsupdates_title);
        m.d(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.f22273b = textView;
        this.f22274c = (ImageView) view.findViewById(R.id.iv_myappsupdates_info);
        textView.setTypeface(k.f7778g.w());
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void d(U u4, View view) {
        u4.f22272a.a();
    }

    /* access modifiers changed from: private */
    public static final void f(U u4, View view) {
        u4.f22272a.a();
    }

    public final void c(boolean z4) {
        if (z4) {
            this.f22273b.setVisibility(0);
        } else {
            this.f22273b.setVisibility(8);
        }
        if (this.f22272a != null) {
            ImageView imageView = this.f22274c;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f22274c;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new T(this));
                return;
            }
            return;
        }
        ImageView imageView3 = this.f22274c;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    public final void e(boolean z4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_l), 0, 0);
        this.itemView.setLayoutParams(layoutParams);
        if (z4) {
            this.f22273b.setVisibility(0);
        } else {
            this.f22273b.setVisibility(8);
        }
        if (this.f22272a != null) {
            ImageView imageView = this.f22274c;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f22274c;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new S(this));
                return;
            }
            return;
        }
        ImageView imageView3 = this.f22274c;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }
}
