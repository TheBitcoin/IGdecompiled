package p2;

import N1.k;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.squareup.picasso.s;
import com.uptodown.R;
import g2.C2050h;
import kotlin.jvm.internal.m;
import n2.c;

public final class e extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f21476a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f21477b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f21478c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f21479d = -1;

    public static final class a extends ImageCardView {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21480a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, Context context) {
            super(context);
            this.f21480a = eVar;
        }

        public void setSelected(boolean z4) {
            this.f21480a.b(this, z4);
            super.setSelected(z4);
        }
    }

    /* access modifiers changed from: private */
    public final void b(ImageCardView imageCardView, boolean z4) {
        int i4;
        int i5;
        if (z4) {
            i4 = this.f21476a;
        } else {
            i4 = this.f21477b;
        }
        if (z4) {
            i5 = this.f21479d;
        } else {
            i5 = this.f21478c;
        }
        imageCardView.setBackgroundColor(i4);
        View findViewById = imageCardView.findViewById(R.id.info_field);
        if (findViewById != null) {
            findViewById.setBackgroundColor(i4);
        }
        TextView textView = (TextView) imageCardView.findViewById(R.id.title_text);
        if (textView != null) {
            textView.setTextColor(i5);
        }
        TextView textView2 = (TextView) imageCardView.findViewById(R.id.content_text);
        if (textView2 != null) {
            textView2.setTextColor(i5);
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        View view = viewHolder.view;
        m.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof C2050h) {
            C2050h hVar = (C2050h) obj;
            imageCardView.setTitleText(hVar.L());
            imageCardView.setContentText(hVar.j0());
            TextView textView = (TextView) imageCardView.findViewById(R.id.title_text);
            if (textView != null) {
                textView.setVisibility(0);
                textView.setTextColor(this.f21478c);
                textView.setTypeface(k.f7778g.w());
            }
            TextView textView2 = (TextView) imageCardView.findViewById(R.id.content_text);
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setTextColor(this.f21478c);
                textView2.setTypeface(k.f7778g.x());
                textView2.setMaxLines(2);
                textView2.setLines(2);
            }
            Resources resources = imageCardView.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.tv_card_height);
            imageCardView.setMainImageDimensions(dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.tv_card_height));
            s.h().l(hVar.D(dimensionPixelSize)).l(R.drawable.shape_bg_placeholder).i(imageCardView.getMainImageView());
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.margin_m);
            imageCardView.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        } else if (obj instanceof c) {
            Resources resources2 = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources2.getDimensionPixelSize(R.dimen.tv_card_height) / 2, resources2.getDimensionPixelSize(R.dimen.tv_card_height) / 2);
            int dimensionPixelSize3 = resources2.getDimensionPixelSize(R.dimen.margin_m) * 5;
            imageCardView.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
            imageCardView.setMainImage(ContextCompat.getDrawable(imageCardView.getContext(), R.drawable.vector_plus));
            TextView textView3 = (TextView) imageCardView.findViewById(R.id.title_text);
            if (textView3 != null) {
                textView3.setVisibility(8);
                textView3.setText("");
            }
            TextView textView4 = (TextView) imageCardView.findViewById(R.id.content_text);
            if (textView4 != null) {
                textView4.setVisibility(8);
                textView4.setText("");
            }
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        if (viewGroup.getContext() == null) {
            return null;
        }
        this.f21477b = ContextCompat.getColor(viewGroup.getContext(), R.color.white);
        this.f21476a = ContextCompat.getColor(viewGroup.getContext(), R.color.main_blue_pressed);
        this.f21478c = ContextCompat.getColor(viewGroup.getContext(), R.color.white);
        this.f21479d = ContextCompat.getColor(viewGroup.getContext(), R.color.white);
        a aVar = new a(this, viewGroup.getContext());
        aVar.setFocusable(true);
        aVar.setFocusableInTouchMode(true);
        b(aVar, false);
        return new Presenter.ViewHolder(aVar);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        m.e(viewHolder, "viewHolder");
        View view = viewHolder.view;
        m.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage((Drawable) null);
        imageCardView.setMainImage((Drawable) null);
    }
}
