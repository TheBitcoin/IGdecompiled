package p2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import g2.C2048f;
import u2.F;

public final class m extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f21487a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21488b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f21489c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f21490d = -1;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f21491e;

    public static final class a extends ImageCardView {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f21492a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar, Context context) {
            super(context);
            this.f21492a = mVar;
        }

        public void setSelected(boolean z4) {
            this.f21492a.b(this, z4);
            super.setSelected(z4);
        }
    }

    /* access modifiers changed from: private */
    public final void b(ImageCardView imageCardView, boolean z4) {
        int i4;
        int i5;
        if (z4) {
            i4 = this.f21487a;
        } else {
            i4 = this.f21488b;
        }
        if (z4) {
            i5 = this.f21490d;
        } else {
            i5 = this.f21489c;
        }
        imageCardView.setBackgroundColor(i4);
        imageCardView.findViewById(R.id.info_field).setBackgroundColor(i4);
        View findViewById = imageCardView.findViewById(R.id.title_text);
        kotlin.jvm.internal.m.c(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(i5);
        View findViewById2 = imageCardView.findViewById(R.id.content_text);
        kotlin.jvm.internal.m.c(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(i5);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        kotlin.jvm.internal.m.e(viewHolder, "viewHolder");
        kotlin.jvm.internal.m.e(obj, "item");
        View view = viewHolder.view;
        kotlin.jvm.internal.m.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof C2048f) {
            C2048f fVar = (C2048f) obj;
            imageCardView.setTitleText(fVar.m());
            Context context = imageCardView.getContext();
            kotlin.jvm.internal.m.d(context, "getContext(...)");
            imageCardView.setContentText(fVar.u(context));
            F f4 = F.f21886a;
            Context context2 = viewHolder.view.getContext();
            kotlin.jvm.internal.m.d(context2, "getContext(...)");
            String o4 = fVar.o();
            kotlin.jvm.internal.m.b(o4);
            Drawable k4 = f4.k(context2, o4);
            Resources resources = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources.getDimensionPixelSize(R.dimen.tv_card_height), resources.getDimensionPixelSize(R.dimen.tv_card_height));
            if (k4 != null) {
                imageCardView.setMainImage(k4);
            } else {
                imageCardView.setMainImage(this.f21491e);
            }
            imageCardView.setPadding(18, 18, 18, 18);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        kotlin.jvm.internal.m.e(viewGroup, "parent");
        this.f21488b = ContextCompat.getColor(viewGroup.getContext(), R.color.white);
        this.f21487a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        this.f21489c = ContextCompat.getColor(viewGroup.getContext(), R.color.black);
        this.f21490d = ContextCompat.getColor(viewGroup.getContext(), R.color.white);
        this.f21491e = ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.vector_uptodown_logo_disabled);
        a aVar = new a(this, viewGroup.getContext());
        aVar.setFocusable(true);
        aVar.setFocusableInTouchMode(true);
        b(aVar, false);
        return new Presenter.ViewHolder(aVar);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        kotlin.jvm.internal.m.e(viewHolder, "viewHolder");
        View view = viewHolder.view;
        kotlin.jvm.internal.m.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage((Drawable) null);
        imageCardView.setMainImage((Drawable) null);
    }
}
